<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<div class="row">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav ">
				<li class="active"><a href="/admin/mainPage<custom:allParams/>">Контент
						главной страницы</a><span class="sr-only">(current)</span></li>
			</ul>
		</div>
	</nav>
</div>
<div class="row">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<ul class="nav navbar-nav ">
				<li><a href="/admin/commodity">Товар</a></li>
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
	</nav>
</div>
<div class="row">
	<div class="col-md-2 col-xs-2">
		<form:form class="form-inline" action="/admin/mainPage" method="GET"
			modelAttribute="filter">
			<custom:hiddenInputs excludeParams="search" />
			<div class="form-group">
				<form:input path="search" class="form-control" placeholder="Search" />
			</div>
			<button class="btn btn-primary" type="submit"
				style="margin-top: 5px;">Ok</button>
		</form:form>
	</div>
	<div class="col-md-8 col-xs-7">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/admin/mainPage"
					method="POST" modelAttribute="mainPage">
					<custom:hiddenInputs excludeParams="name, content" />
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Название</label>
						<div class="col-sm-8">
							<form:input type="text" class="form-control" path="name"
								id="name" />
						</div>
						<label style="color: red; text-align: left;" for="name"
							class="col-sm-2 control-label"><form:errors path="name" /></label>
					</div>
					<div class="form-group">
						<label for="content" class="col-sm-2 control-label">Контент</label>
						<div class="col-sm-8">
							<form:textarea path="content" cols="73" rows="15" id="summernote" />
						</div>

						<label style="color: red; text-align: left;" for="content"
							class="col-sm-2 control-label"><form:errors
								path="content" /></label>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Cоздать</button>
							<a class="btn btn-primary" href="/admin/mainPage/cancel">Отменить</a>
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

					</ul>
				</div>
			</div>
			<div class="col-md-3 col-sm-3 col-xs-3 text-center">
				<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
			</div>
		</div>
	</div>
</div>
<div class="container">
	<div class="row">
		<!-- <div class="col-md-2 col-xs-2">
			<h3>Название</h3>
		</div> -->
		<div class="col-md-8 col-xs-8">
			<h3>Контент</h3>
		</div>
		<div class="col-md-2 col-xs-2">
			<h3>Обновить</h3>
		</div>
		<div class="col-md-2 col-xs-2">
			<h3>Удалить</h3>
		</div>
	</div>

	<c:forEach items="${page.content}" var="mainPage">
		<div class="row">
			<div class="col-md-12 col-xs-12">${mainPage.name}</div>
			<div class="col-md-8 col-xs-8">${mainPage.content}</div>
			<div class="col-md-2 col-xs-2">
				<a class="btn btn-warning"
					href="/admin/mainPage/update/${mainPage.id}<custom:allParams/>">update</a>
			</div>
			<div class="col-md-2 col-xs-2">
				<a class="btn btn-danger"
					href="/admin/mainPage/delete/${mainPage.id}<custom:allParams/>">delete</a>
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