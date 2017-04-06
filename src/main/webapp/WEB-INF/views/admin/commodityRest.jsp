<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:csrfMetaTags />
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular.min.js"></script>
<script>
/* app.filter('byName', function(){
return function(input, search){
		 if(!search)return input;
		 var array= [];
		 for(var i = 0;i<input.length;i++){
			 if(input[i].name.toUpperCase().indexOf(search.toUpperCase())!==-1){
				 array.push(input[i]);
				 }
			 }
		 return array;
		 }
 });  */
var app = angular.module('app',[]).constant("commodityUrl", "/commodity");
 app.controller('commodityCtrl', function($scope, $http, $httpParamSerializer, commodityUrl){
	    $scope.currentView = "table";
	    $scope.items = {content:[]};
	    $scope.pages = [];
	    $scope.pageSizes = [1,5,10];
	    $scope.currentPage = 1;
	    $scope.size = 10;
	    $scope.sort;
	    $scope.search = "";
	    $scope.pageSorts = [{name:'price', param:'price'},
	                       {name:'price desc', param:'price,desc'},
	                       {name:'butt name', param:'butt.name'},
	                       {name:'butt name desc', param:'butt.name,desc'},{name:'name', param:'name'},
	                       {name:'name desc', param:'name,desc'}
	                       ];
	    $scope.butts=[];
	   /* $scope.measuringSystems=[]; */
	    
	    $scope.refreshData = function(){
	    	$http({
				method:"GET",
				url:"/butt"
				}).then(function(result) {
					$scope.butts = result.data;
	        });
	   
	      
			  /* $http.get("/ms").then(function(result){
			  $scope.measuringSystems = result.data; }); */
			 
	    
	    }
	    $scope.refreshData();
	    
	   /*  $scope.changeSort = function(pageSort){
	        $scope.sort = pageSort;
	        $scope.refresh();
	    }
	    
	    $scope.changeSize = function(size){
	        $scope.size = size;
	        $scope.refresh();
	    }
	    
	    $scope.firstPage = function(){
	        if($scope.currentPage!=1){
	            $scope.currentPage = 1;
	            $scope.refresh();
	        }
	    }
	    
	    $scope.previousPage = function(){
	        if($scope.currentPage!=1){
	            $scope.currentPage = $scope.currentPage-1;
	            $scope.refresh();
	        }
	    }
	    
	    $scope.nextPage = function(){
	        if($scope.currentPage!=$scope.items.totalPages){
	            $scope.currentPage = $scope.currentPage+1;
	            $scope.refresh();
	        }
	    }
	    
	    $scope.lastPage = function(){
	        if($scope.currentPage!=$scope.items.totalPages){
	            $scope.currentPage = $scope.items.totalPages;
	            $scope.refresh();
	        }
	    }
	    
	    
	    
	    $scope.changePage = function(page){
	        if($scope.currentPage!=page){
	            $scope.currentPage=page;
	            $scope.refresh();
	        }
	    }
	    
	    $scope.buildPages = function(){
	        var start = ($scope.currentPage-2) >= 1 ? ($scope.currentPage-2) : 1;
	        var finish = ($scope.currentPage+2) <= $scope.items.totalPages ? ($scope.currentPage+2) : $scope.items.totalPages;
	        start = (finish - start < 5) ? (finish - 6) : start;
	        start = start <= 0 ? 1 : start;
	        finish = (finish - start) < 5 ? start + 4 : finish;
	        finish = finish > $scope.items.totalPages ? $scope.items.totalPages : finish;
	        $scope.pages = [];
	        for(; start<=finish; start++){
	            $scope.pages.push(start);
	        }
	    }
	    
	    $scope.$watch('currentView', function(oldValue, newValue, scope){
	        if(oldValue=="table"){
	            $scope.refresh();
	        }
	    });
	    
	    $scope.$watch('search', function(oldValue, newValue, scope){
	        $scope.refresh();
	    });
	    
	    function buildParams(){
	        var config = {page:$scope.currentPage, size:$scope.size};
	        if($scope.sort){
	            config.sort=$scope.sort;
	        }
	        if($scope.search){
	            config.search=$scope.search;
	        }
	        return "?"+$httpParamSerializer(config);
	    }
	    
	    $scope.refresh = function () {
	        $http.get(commodityUrl+buildParams()).then(function (result) {
	            $scope.items = result.data;
	            console.log(result.data);
	            $scope.buildPages();
	        });
	    } */
	    $scope.create = function (item) {
	        console.log(angular.toJson(item));
	        $http.post(commodityUrl, angular.toJson(item)).then(function (result) {
	            $scope.currentView = "table";
	        });
	    }
	    $scope.update = function (item) {
	        $http({
	            url: commodityUrl+"/" + item.id,
	            method: "PUT",
	            data: angular.toJson(item)
	        }).then(function (modifiedItem) {
	            $scope.currentView = "table";
	        });
	    }
	    $scope.delete = function (item) {
	        $http({
	            method: "DELETE",
	            url: commodityUrl+"/" + item.id
	        }).then(function () {
	            $scope.refresh();
	        });
	    }
	    $scope.editOrCreate = function (item) {
	        $scope.currentItem = item ? angular.copy(item) : {};
	        $scope.currentView = "edit";
	    }
	    $scope.cancelEdit = function () {
	        $scope.currentItem = {};
	        $scope.currentView = "table";
	    }
	    $scope.saveEdit = function (item) {
	        if (angular.isDefined(item.id)) {
	            $scope.update(item);
	        } else {
	            $scope.create(item);
	        }
	    }
//$scope.refresh();
	});</script>


<div ng-app="app" ng-controller="commodityCtrl">
	<div class="row">
		<div class="col-sm-3">
			<form action="" class="form-horizontal">
				<input type="text" class="form-control" ng-model="search">

			</form>
		</div>
		<div class="col-sm-9"
			ng-show="currentView == 'table' && items.content.length">
			<div class="row">
				<div class="col-md-3 col-xs-3">
					<h3>Название кия</h3>
				</div>
				<div class="col-md-3 col-xs-3">
					<h3>Турняк</h3>
				</div>
				<div class="col-md-2 col-xs-2">
					<h3>Цена</h3>
				</div>
				<div class="col-md-2 col-xs-2">
					<h3>Обновить</h3>
				</div>
				<div class="col-md-2 col-xs-2">
					<h3>Удалить</h3>
				</div>

			</div>
			<div class="row" ng-repeat="item in items.content | byName:search ">
				<div class="col-sm-3">{{item.name}}</div>
				<div class="col-sm-3">{{item.buttName}}</div>
				<div class="col-sm-3">{{item.price}}</div>
				<div class="col-sm-3">
					<button class="btn btn-warning" ng-click="editOrCreate(item)">Update</button>
					<button class="btn btn-danger" ng-click="delete(item)">Delete</button>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<button class="btn btn-primary" ng-click="refresh()">Refresh</button>
					<button class="btn btn-primary" ng-click="editOrCreate()">New</button>
				</div>
			</div>
		</div>
		<div class="col-xs-12 col-sm-12 text-center"
			ng-show="!items.content.length">No items found</div>
	</div>
	<div ng-show="currentView == 'edit'" class="col-xs-12 col-sm-12">
		<form class="form-horizontal" ng-show="currentView == 'edit'">
			<div class="form-group">
				<label class="col-sm-2 control-label">Butt</label>
				<div class="col-sm-10">
					<select ng-options="butt.name for butt in butts"
						ng-model="currentItem.butt" class="form-control"></select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Name</label>
				<div class="col-sm-10">
					<input class="form-control" ng-model="currentItem.name">
				</div>

			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Price</label>
				<div class="col-sm-10">
					<input class="form-control" ng-model="currentItem.price">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-10 col-sm-offset-2">
					<button class="btn btn-primary" ng-click="saveEdit(currentItem)">Save</button>
					<button class="btn btn-primary" ng-click="cancelEdit()">Cancel</button>
				</div>
			</div>
		</form>
	</div>
</div>

<!-- <div ng-show="currentView == 'table' && items.content.length"
		class="col-xs-12 col-sm-12 text-center">
		<ul class="pagination">
			<li ng-class="{true:'disabled', false:''}[items.first]"
				ng-click="firstPage()"><a href="">&lt;&lt;</a></li>
			<li ng-class="{true:'disabled', false:''}[items.first]"
				ng-click="previousPage()"><a href="">&lt;</a></li>
			<li ng-repeat="page in pages"
				ng-class="{true:'active', false:''}[currentPage==page]"><a
				href="" ng-click="changePage(page)">{{page}}</a></li>
			<li ng-class="{true:'disabled', false:''}[items.last]"
				ng-click="nextPage()"><a href="">&gt;</a></li>
			<li ng-class="{true:'disabled', false:''}[items.last]"
				ng-click="lastPage()"><a href="">&gt;&gt;</a></li>
		</ul>
	</div>
	<div class="col-xs-12 col-sm-2">
		<div class="row">
			<div class="col-md-6 col-xs-6">
				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" type="button"
						data-toggle="dropdown">
						Sort <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li ng-repeat="pageSort in pageSorts"
							ng-class="{true:'active', false:''}[sort==pageSort.param]"><a
							href="" ng-click="changeSort(pageSort.param)">{{pageSort.name}}</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="col-md-6 col-xs-6">
				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" type="button"
						data-toggle="dropdown">
						Size <span class="caret"></span>
					</button>
					<ul class="dropdown-menu page-size">
						<li ng-repeat="size in pageSizes"
							ng-class="{true:'active', false:''}[items.size==size]"><a
							href="" ng-click="changeSize(size)">{{size}}</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div> -->