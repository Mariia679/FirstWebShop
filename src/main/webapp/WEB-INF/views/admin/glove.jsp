<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
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

				<li class="active"><a href="/admin/glove<custom:allParams/>">Перчатки</a><span
					class="sr-only">(current)</span></li>

				<li><a href="/admin/productCare">Средство по уходу</a></li>
				<li><a href="/admin/holdersChalk">Держатели мела</a></li>
				<li><a href="/admin/motherInLaw">Тещи для бильярда</a></li>
				<li><a href="/admin/tube">Тубус</a></li>
			</ul>
		</div>
	</nav>
</div>
<div class="row">
	<div class="col-md-3 col-xs-3">
		<form:form class="form-inline" action="/admin/glove" method="GET"
			modelAttribute="filter">
			<custom:hiddenInputs excludeParams="search" />
			<div class="form-group">
				<form:input path="search" class="form-control" placeholder="Search" />
			</div>
			<button class="btn btn-primary" type="submit">Ok</button>
		</form:form>
	</div>
	<div class="col-md-7 col-xs-6">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/admin/glove"
					method="POST" modelAttribute="glove" enctype="multipart/form-data">
					<custom:hiddenInputs excludeParams="name, price, description" />
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Название</label>
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
							<button type="submit" class="btn btn-default">Создать</button>
							<a class="btn btn-primary" href="/admin/glove/cancel">Отменить</a>
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
<div class="row">
	<div class="col-md-2 col-xs-2">
		<h3>Картинки</h3>
	</div>
	<div class="col-md-2 col-xs-2 text-center">
		<h3>Название</h3>
	</div>
	<div class="col-md-1 col-xs-1 text-center">
		<h3>Цена</h3>
	</div>
	<div class="col-md-3 col-xs-3 text-center">
		<h3>Описание</h3>
	</div>
	<div class="col-md-2 col-xs-2">
		<h3>Обновить</h3>
	</div>
	<div class="col-md-2 col-xs-2">
		<h3>Удалить</h3>
	</div>
</div>

<c:forEach items="${page.content}" var="glove">
	<div class="row">
		<div class="col-md-2 col-xs-2">
			<img src="/images/glove/${glove.id}.jpg?version=${glove.version}"
				width="150" alt="Glove">
		</div>
		<div class="col-md-2 col-xs-2 text-center">${glove.name}</div>
		<div class="col-md-1 col-xs-1 text-center">${glove.price}</div>
		<div class="col-md-3 col-xs-3">${glove.description}</div>
		<div class="col-md-2 col-xs-2">
			<a class="btn btn-warning"
				href="/admin/glove/update/${glove.id}<custom:allParams/>">update</a>
		</div>
		<div class="col-md-2 col-xs-2">
			<a class="btn btn-danger"
				href="/admin/glove/delete/${glove.id}<custom:allParams/>">delete</a>
		</div>
	</div>
</c:forEach>
<div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>"
			container="<ul class='pagination'></ul>" />
	</div>
</div>
<script>
	$(document).ready(function() {
		$('#summernote').summernote({
			lang : 'ru-RU'
		});
	});
</script>