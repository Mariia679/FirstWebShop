'use strict';

var compare = (function($) {

	var ui = {
		$body : $('body'),
		elAddToCompare : '.js-add-to-compare',
		elCompareFilters : '.js-compare-filter',
		elCompareRemove : '.js-compare-remove',
		$compareTab : $('#compare-tab'),
		$compareTable : $('#compare-table')
	};

	var tpl = {
		filters : _.template($('#compare-filters-template').html() || ''),
		header : _.template($('#compare-header-template').html() || ''),
		props : _.template($('#compare-props-template').html() || '')
	};

	var settings = {
		cookie : {
			goods : 'compared_goods',
			category : 'compared_category'
		}
	};

	function _onClickAddToCompare(e) {
		var $button = $(e.target), goodId = $button.attr('data-id'), categoryId = $button
				.attr('data-category-id'), comparedGoodsStr = $
				.cookie(settings.cookie.goods), comparedGoodsArr = comparedGoodsStr ? comparedGoodsStr
				.split(',')
				: [], comparedCategoryId = $.cookie(settings.cookie.category);

		if (comparedCategoryId && categoryId !== comparedCategoryId) {
			alert('РќРµ РґРѕРїСѓСЃРєР°РµС‚СЃСЏ СЃСЂР°РІРЅРёРІР°С‚СЊ С‚РѕРІР°СЂС‹ СЂР°Р·РЅС‹С… РєР°С‚РµРіРѕСЂРёР№');
			return false;
		}

		if (comparedGoodsArr.indexOf(goodId) === -1) {
			comparedGoodsArr.push(goodId);
			$.cookie(settings.cookie.goods, comparedGoodsArr.join(','), {
				expires : 365,
				path : '/'
			});
			$.cookie(settings.cookie.category, categoryId, {
				expires : 365,
				path : '/'
			});
			updateCompareTab();
			alert('РўРѕРІР°СЂ РґРѕР±Р°РІР»РµРЅ Рє СЃСЂР°РІРЅРµРЅРёСЋ!');
		} else {
			alert('Р­С‚РѕС‚ С‚РѕРІР°СЂ СѓР¶Рµ РµСЃС‚СЊ РІ СЃРїРёСЃРєРµ СЃСЂР°РІРЅРёРІР°РµРјС‹С…');
		}
	}

	function _onClickCompareFilters(e) {
		ui.$compareTable.attr('data-compare', e.target.value);
	}

	function _onClickCompareRemove(e) {
		var id = $(e.target).attr('data-id'), goods = $.cookie(
				settings.cookie.goods).split(','), categoryId = $
				.cookie(settings.cookie.category), newGoods = _.without(goods,
				id), newGoodsStr = newGoods.join(',');

		if (!newGoodsStr) {
			$.removeCookie(settings.cookie.goods, {
				path : '/'
			});
			$.removeCookie(settings.cookie.category, {
				path : '/'
			});
		}

		document.location.hash = newGoodsStr ? encodeURIComponent(categoryId
				+ '|' + newGoodsStr) : '';
		document.location.reload();
	}

	function _bindHandlers() {
		ui.$body.on('click', ui.elAddToCompare, _onClickAddToCompare);
		ui.$body.on('click', ui.elCompareFilters, _onClickCompareFilters);
		ui.$body.on('click', ui.elCompareRemove, _onClickCompareRemove);
	}

	function updateCompareTab() {
		var comparedGoodsStr = $.cookie(settings.cookie.goods), comparedGoodsArr = comparedGoodsStr ? comparedGoodsStr
				.split(',')
				: [], comparedCategoryId = $.cookie(settings.cookie.category), compareHref = 'compare.html'
				+ (comparedGoodsArr.length ? '#'
						+ encodeURIComponent(comparedCategoryId + '|'
								+ comparedGoodsStr) : '');

		ui.$compareTab.find('span').text(comparedGoodsArr.length || '');

		ui.$compareTab.find('a').attr('href', compareHref);
	}

	function _getBaseProps(goods) {
		var baseProps = [ {
			key : 'brand',
			prop : 'Р‘СЂРµРЅРґ'
		}, {
			key : 'price',
			prop : 'Р¦РµРЅР°'
		}, {
			key : 'rating',
			prop : 'Р РµР№С‚РёРЅРі'
		} ];

		var valuesWithIds, values, equal;

		return _.map(baseProps, function(item) {

			valuesWithIds = _.map(goods, function(good) {
				return {
					goodId : good.good_id,
					value : good[item.key]
				}
			});

			values = _.pluck(valuesWithIds, 'value');

			equal = _.uniq(values).length === 1;

			return {
				prop : item.prop,
				values : valuesWithIds,
				equal : equal
			}
		});
	}

	function _getAdditionalProps(props) {
		var valuesWithIds, values, equal;
		return _.chain(props).groupBy('prop').map(function(valuesArray, key) {

			valuesWithIds = _.map(valuesArray, function(item) {
				return {
					goodId : item.good_id,
					value : item.value
				}
			});

			values = _.pluck(valuesWithIds, 'value');

			// РћРґРёРЅР°РєРѕРІС‹Рµ Р»Рё Р·РЅР°С‡РµРЅРёСЏ РІРѕ РІСЃРµС…
			// С‚РѕРІР°СЂР°С…
			equal = (values.length > 1) && (_.uniq(values).length === 1);

			return {
				prop : key,
				values : valuesWithIds,
				equal : equal
			}
		}).value();
	}

	function _renderCompareTable(response) {
		var filters = [ {
			value : 'all',
			title : 'Р’СЃРµ',
			checked : true
		}, {
			value : 'equal',
			title : 'РЎРѕРІРїР°РґР°СЋС‰РёРµ'
		}, {
			value : 'not-equal',
			title : 'Р Р°Р·Р»РёС‡Р°СЋС‰РёРµСЃСЏ'
		} ];

		var goods = response.data.goods;

		var allProps = _.union(_getBaseProps(goods),
				_getAdditionalProps(response.data.props));

		ui.$compareTable.find('thead tr').html(tpl.filters({
			buttons : filters
		}));

		ui.$compareTable.find('thead tr').append(tpl.header({
			goods : goods
		}));

		ui.$compareTable.find('tbody').append(tpl.props({
			goods : _.pluck(goods, 'good_id'),
			props : allProps
		}));
	}

	function _onAjaxError(response) {
		console.error('response', response);
	}

	function _initComparePage() {
		var hashData = decodeURIComponent(location.hash).substr(1).split('|'), categoryId = hashData.length ? hashData[0]
				: 0, goods = hashData.length ? hashData[1] : [];

		if (!goods) {
			alert('РќРµ РІС‹Р±СЂР°РЅС‹ С‚РѕРІР°СЂС‹ РґР»СЏ СЃСЂР°РІРЅРµРЅРёСЏ');
			return false;
		}

		$.cookie(settings.cookie.goods, goods, {
			expires : 365,
			path : '/'
		});
		$.cookie(settings.cookie.category, categoryId, {
			expires : 365,
			path : '/'
		});

		$.ajax({
			url : 'scripts/compare.php',
			data : 'goods=' + encodeURIComponent(goods),
			type : 'GET',
			cache : false,
			dataType : 'json',
			error : _onAjaxError,
			success : function(response) {
				if (response.code === 'success') {
					_renderCompareTable(response);
				} else {
					_onAjaxError(response);
				}
			}
		});
	}

	function init() {
		_bindHandlers();
		if (ui.$body.attr('data-page') === 'compare') {
			_initComparePage();
		}
	}

	return {
		updateCompareTab : updateCompareTab,
		init : init
	}

})(jQuery);