<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<style>
.filter .control-label {
	text-align: left;
}
</style>
<div class="row">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav ">
				<li><a href="/admin/mainPage">Контент главной страницы</a></li>
			</ul>
		</div>
	</nav>
</div>
<div class="row">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a
						href="/admin/commodity<custom:allParams/>">Товар</a><span
						class="sr-only">(current)</span></li>
					<li><a href="/admin/category">Категория</a></li>
					<li><a href="/admin/mainMaterial">Основной материал</a></li>
					<li><a href="/admin/wood">Дерево</a></li>
					<li><a href="/admin/sticker">Наклейка</a></li>
					<li><a href="/admin/typeSticker">Тип наклейки</a></li>
					<li><a href="/admin/gashType">Вид запила</a></li>
					<li><a href="/admin/shaft">Шафт</a></li>
					<li><a href="/admin/butt">Турняк</a></li>
					<li><a href="/admin/carvingJoint">Вид резьбы</a></li>
					<li><a href="/admin/materialJoint">Материал резьбы</a></li>
					<li><a href="/admin/damper">Амортизатор</a></li>
					<li><a href="/admin/ferula">Феруле</a></li>
					<li><a href="/admin/ringEnd">Бондажные кольца торцов</a></li>
					<li><a href="/admin/ringBumper">Бондажное кольцо бампера</a></li>
					<li><a href="/admin/country">Страна</a></li>
					<li><a href="/admin/city">Город</a></li>
					<li><a href="/admin/methodDelivery">Способ доставки</a></li>
					<li><a href="/admin/newMail">Новая Почта</a></li>
					<li><a href="/admin/ukrMail">УкрПочта</a></li>
					<li><a href="/admin/productDescription">Картинки</a></li>
					<li><a href="/admin/chalk">Мел для кия</a></li>
					<li><a href="/admin/glove">Перчатки</a></li>
					<li><a href="/admin/productCare">Средство по уходу</a></li>
					<li><a href="/admin/holdersChalk">Держатели мела</a></li>
					<li><a href="/admin/motherInLaw">Тещи для бильярда</a></li>
					<li><a href="/admin/tube">Тубус</a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>
<div class="row">
	<div class="col-md-3 col-xs-3">
		<form:form class="form-horizontal filter" action="/admin/commodity"
			method="GET" modelAttribute="filter">
			<custom:hiddenInputs
				excludeParams="nameCommodity,min, max, lengthCue, 
				weightCue,  categoryId,mainMaterialId,
				gashTypeId,shaftId,buttId,carvingJointId,
				materialJointId,woodId,damperId,ringBumperId,
				ringEndId,typeStickerId,stickerId,ferulaId,
				 _categoryId, _mainMaterialId, _gashTypeId, _shaftId,
				  _buttId, _carvingJointId, _materialJointId, _woodId, 
				  _damperId, _ringBumperId, _ringEndId, _typeStickerId, 
				  _stickerId, _ferulaId" />
			<div class="form-group">
				<form:input path="nameCommodity" class="form-control"
					placeholder="Search" />
			</div>
			<div class="form-group">
				<div class="col-sm-6">
					<form:input path="min" class="form-control" placeholder="Min" />
				</div>
				<div class="col-sm-6">
					<form:input path="max" class="form-control" placeholder="Max" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-6">
					<form:input path="lengthCue" class="form-control"
						placeholder="Length" />
				</div>
				<div class="col-sm-6">
					<form:input path="weightCue" class="form-control"
						placeholder="Weight" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12 weight-font-size">Категория</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${categories}" itemValue="id"
						itemLabel="name" path="categoryId" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12 weight-font-size">Основной
					материал</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${mainMaterials}"
						itemValue="id" itemLabel="name" path="mainMaterialId" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12 weight-font-size">Вид
					запила</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${gashTypes}" itemValue="id"
						itemLabel="name" path="gashTypeId" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12 weight-font-size">Шафт</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${shafts}" itemValue="id"
						itemLabel="name" path="shaftId" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12 weight-font-size">Турняк</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${butts}" itemValue="id"
						itemLabel="name" path="buttId" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12 weight-font-size">Вид
					резьбы</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${carvingJs}" itemValue="id"
						itemLabel="name" path="carvingJointId" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12 weight-font-size">Материал
					резьбы</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${materialJs}" itemValue="id"
						itemLabel="name" path="materialJointId" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12 weight-font-size">Дерево</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${woods}" itemValue="id"
						itemLabel="name" path="woodId" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12 weight-font-size">Амортизатор</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${dampers}" itemValue="id"
						itemLabel="name" path="damperId" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12 weight-font-size">Бондажное
					кольцо бампер</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${ringBumpers}"
						itemValue="id" itemLabel="name" path="ringBumperId" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12 weight-font-size">Бондажные
					кольца торцов</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${ringEnds}" itemValue="id"
						itemLabel="name" path="ringEndId" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12 weight-font-size">Тип
					наклейки</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${typeStickers}"
						itemValue="id" itemLabel="name" path="typeStickerId" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12 weight-font-size">Наклейка</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${stickers}" itemValue="id"
						itemLabel="name" path="stickerId" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12 weight-font-size">Феруле</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${ferulas}" itemValue="id"
						itemLabel="name" path="ferulaId" />
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Ok</button>
		</form:form>
	</div>
	<div class="col-md-7 col-xs-6">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/admin/commodity"
					method="POST" modelAttribute="commodity"
					enctype="multipart/form-data">
					<custom:hiddenInputs
						excludeParams="category, name, price, weight, length, mainMaterial, gashType, shaft, butt, carvingJoint, materialJoint, wood, damper, ringBumper, ringEnd, typeSticker, sticker, ferula, description, file" />
					<div class="form-group">
						<label for="category" class="col-sm-2 control-label">Категория</label>
						<div class="col-sm-7">
							<form:select class="form-control" path="category" id="category"
								items="${categories}" itemValue="id" itemLabel="name" />
						</div>
						<label style="color: red; text-align: left;" for="category"
							class="col-sm-3 control-label"><form:errors
								path="category" /></label>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Название
							кия</label>
						<div class="col-sm-7">
							<form:input type="text" class="form-control" path="name"
								id="name" />
						</div>
						<label style="color: red; text-align: left;" for="name"
							class="col-sm-3 control-label"><form:errors path="name" /></label>
					</div>
					<div class="form-group">
						<label for="price" class="col-sm-2 control-label">Цена</label>
						<div class="col-sm-7">
							<form:input type="text" class="form-control" path="price"
								id="price" />
						</div>
						<label style="color: red; text-align: left;" for="price"
							class="col-sm-3 control-label"><form:errors path="price" /></label>
					</div>
					<div class="form-group">
						<label for="weight" class="col-sm-2 control-label">Вес</label>
						<div class="col-sm-7">
							<form:input type="text" class="form-control" path="weight"
								id="weight" />
						</div>
						<label style="color: red; text-align: left;" for="weight"
							class="col-sm-3 control-label"><form:errors path="weight" /></label>
					</div>
					<div class="form-group">
						<label for="length" class="col-sm-2 control-label">Длинна</label>
						<div class="col-sm-7">
							<form:input type="text" class="form-control" path="length"
								id="length" />
						</div>
						<label style="color: red; text-align: left;" for="length"
							class="col-sm-3 control-label"><form:errors path="length" /></label>
					</div>
					<div class="form-group">
						<label for="mainMaterial" class="col-sm-2 control-label">Основной
							материал</label>
						<div class="col-sm-7">
							<form:select class="form-control" path="mainMaterial"
								id="mainMaterial" items="${mainMaterials}" itemValue="id"
								itemLabel="name" />
						</div>
						<label style="color: red; text-align: left;" for="mainMaterial"
							class="col-sm-3 control-label"><form:errors
								path="mainMaterial" /></label>
					</div>
					<div class="form-group">
						<label for="gashType" class="col-sm-2 control-label">Вид
							запила</label>
						<div class="col-sm-7">
							<form:select class="form-control" path="gashType" id="gashType"
								items="${gashTypes}" itemValue="id" itemLabel="name" />
						</div>
						<label style="color: red; text-align: left;" for="gashType"
							class="col-sm-3 control-label"><form:errors
								path="gashType" /></label>
					</div>
					<div class="form-group">
						<label for="shaft" class="col-sm-2 control-label">Шафт</label>
						<div class="col-sm-7">
							<form:select class="form-control" path="shaft" id="shaft"
								items="${shafts}" itemValue="id" itemLabel="name" />
						</div>
						<label style="color: red; text-align: left;" for="shaft"
							class="col-sm-3 control-label"><form:errors path="shaft" /></label>
					</div>
					<div class="form-group">
						<label for="butt" class="col-sm-2 control-label">Турняк</label>
						<div class="col-sm-7">
							<form:select class="form-control" path="butt" id="butt"
								items="${butts}" itemValue="id" itemLabel="name" />
						</div>
						<label style="color: red; text-align: left;" for="butt"
							class="col-sm-3 control-label"><form:errors path="butt" /></label>
					</div>
					<div class="form-group">
						<label for="carvingJoint" class="col-sm-2 control-label">Вид
							резьбы</label>
						<div class="col-sm-7">
							<form:select class="form-control" path="carvingJoint"
								id="carvingJoint" items="${carvingJs}" itemValue="id"
								itemLabel="name" />
						</div>
						<label style="color: red; text-align: left;" for="carvingJoint"
							class="col-sm-3 control-label"><form:errors
								path="carvingJoint" /></label>
					</div>
					<div class="form-group">
						<label for="materialJoint" class="col-sm-2 control-label">Материал
							резьбы</label>
						<div class="col-sm-7">
							<form:select class="form-control" path="materialJoint"
								id="materialJoint" items="${materialJs}" itemValue="id"
								itemLabel="name" />
						</div>
						<label style="color: red; text-align: left;" for="materialJoint"
							class="col-sm-3 control-label"><form:errors
								path="materialJoint" /></label>
					</div>
					<div class="form-group">
						<label for="wood" class="col-sm-2 control-label">Дерево</label>
						<div class="col-sm-7">
							<form:select class="form-control" path="wood" id="wood"
								items="${woods}" itemValue="id" itemLabel="name" />
						</div>
						<label style="color: red; text-align: left;" for="wood"
							class="col-sm-3 control-label"><form:errors path="wood" /></label>
					</div>
					<div class="form-group">
						<label for="damper" class="col-sm-2 control-label">Амортизатор</label>
						<div class="col-sm-7">
							<form:select class="form-control" path="damper" id="damper"
								items="${dampers}" itemValue="id" itemLabel="name" />
						</div>
						<label style="color: red; text-align: left;" for="damper"
							class="col-sm-3 control-label"><form:errors path="damper" /></label>
					</div>
					<div class="form-group">
						<label for="ringBumper" class="col-sm-2 control-label">Бондажное
							кольцо бампер</label>
						<div class="col-sm-7">
							<form:select class="form-control" path="ringBumper"
								id="ringBumper" items="${ringBumpers}" itemValue="id"
								itemLabel="name" />
						</div>
						<label style="color: red; text-align: left;" for="ringBumper"
							class="col-sm-3 control-label"><form:errors
								path="ringBumper" /></label>
					</div>
					<div class="form-group">
						<label for="ringEnd" class="col-sm-2 control-label">Бондажные
							кольца торцов</label>
						<div class="col-sm-7">
							<form:select class="form-control" path="ringEnd" id="ringEnd"
								items="${ringEnds}" itemValue="id" itemLabel="name" />
						</div>
						<label style="color: red; text-align: left;" for="ringEnd"
							class="col-sm-3 control-label"><form:errors
								path="ringEnd" /></label>
					</div>
					<div class="form-group">
						<label for="typeSticker" class="col-sm-2 control-label">Тип
							наклейки</label>
						<div class="col-sm-7">
							<form:select class="form-control" path="typeSticker"
								id="typeSticker" items="${typeStickers}" itemValue="id"
								itemLabel="name" />
						</div>
						<label style="color: red; text-align: left;" for="typeSticker"
							class="col-sm-3 control-label"><form:errors
								path="typeSticker" /></label>
					</div>
					<div class="form-group">
						<label for="sticker" class="col-sm-2 control-label">Наклейка</label>
						<div class="col-sm-7">
							<form:select class="form-control" path="sticker" id="sticker"
								items="${stickers}" itemValue="id" itemLabel="name" />
						</div>
						<label style="color: red; text-align: left;" for="sticker"
							class="col-sm-3 control-label"><form:errors
								path="sticker" /></label>
					</div>
					<div class="form-group">
						<label for="ferula" class="col-sm-2 control-label">Феруле</label>
						<div class="col-sm-7">
							<form:select class="form-control" path="ferula" id="ferula"
								items="${ferulas}" itemValue="id" itemLabel="name" />
						</div>
						<label style="color: red; text-align: left;" for="ferula"
							class="col-sm-3 control-label"><form:errors path="ferula" /></label>
					</div>
					<div class="form-group">
						<label for="description" class="col-sm-2 control-label">Описание</label>
						<div class="col-sm-8">
							<form:textarea path="description" cols="54" rows="7" id="summernote" />
						</div>

						<label style="color: red; text-align: left;" for="description"
							class="col-sm-2 control-label"><form:errors
								path="description" /></label>
					</div>
					<div class="form-group">
						<label for="file" class="col-sm-2 control-label">Картинка</label>
						<div class="col-sm-10">
							<input name="file" type="file" id="file">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Cоздать</button>
							<a class="btn btn-primary" href="/admin/commodity/cancel">Отменить</a>
						</div>
					</div>

				</form:form>
			</div>
		</div>
	</div>
	<div class="col-md-2 col-xs-3">
		<div class="row">
			<div class="col-md-8 col-sm-8 col-xs-8 text-center">
				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" type="button"
						data-toggle="dropdown">
						Сотировка <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<custom:sort innerHtml="По названию по возрастанию"
							paramValue="name" />
						<custom:sort innerHtml="По названию по убыванию"
							paramValue="name,desc" />
						<custom:sort innerHtml="По цене по возрастанию" paramValue="price" />
						<custom:sort innerHtml="По цене по убыванию"
							paramValue="price,desc" />

					</ul>
				</div>
			</div>
			<div class="col-md-3 col-sm-3 col-xs-3 text-center">
				<custom:size posibleSizes="1,2,5,10,20" size="${page.size}" />
			</div>
		</div>
	</div>
</div>
<div class="container">
	<div class="row">
		<div class="col-md-2 col-xs-2">
			<h3>Картинка</h3>
		</div>
		<div class="col-md-2 col-xs-3">
			<h3>Название кия</h3>
		</div>
		<div class="col-md-2 col-xs-3">
			<h3>Категория</h3>
		</div>
		<div class="col-md-1 col-xs-1">
			<h3>Цена</h3>
		</div>
		<div class="col-md-2 col-xs-2">
			<h3>Обновить</h3>
		</div>
		<div class="col-md-2 col-xs-1">
			<h3>Удалить</h3>
		</div>
	</div>
	<c:forEach items="${page.content}" var="commodity">
		<div class="row">

			<div class="col-md-2 col-xs-2">
				<img
					src="/images/commodity/${commodity.id}.jpg?version=${commodity.version}"
					width="120" alt="Here is cue">
			</div>
			<div class="col-md-2 col-xs-3">${commodity.name}</div>
			<div class="col-md-2 col-xs-3">${commodity.category.name}</div>
			<div class="col-md-1 col-xs-1">${commodity.price}</div>
			<div class="col-md-2 col-xs-2">
				<a class="btn btn-warning"
					href="/admin/commodity/update/${commodity.id}<custom:allParams/>">update</a>
			</div>
			<div class="col-md-2 col-xs-1">
				<a class="btn btn-danger"
					href="/admin/commodity/delete/${commodity.id}<custom:allParams/>">delete</a>
			</div>
		</div>
	</c:forEach>
</div>
<div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>"
			container="<ul class='pagination'></ul>" />
	</div>
</div>
<script>
    $(document).ready(function() {
        $('#summernote').summernote({
        	lang: 'ru-RU'
        });
    });
  </script>