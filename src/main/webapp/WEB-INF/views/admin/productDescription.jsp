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
				<li class="active"><a href="/admin/productDescription">Картинки</a><span
					class="sr-only">(current)</span></li>
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
	<form:form class="form-horizontal" action="/admin/productDescription"
		method="POST" modelAttribute="productDescription"
		enctype="multipart/form-data">
		<custom:hiddenInputs excludeParams="commodity, file" />
		<form:errors path="*" />
		<div class="form-group">
			<label for="commodity" class="col-sm-2 control-label">Название
				товара</label>
			<div class="col-sm-7">
				<form:select class="form-control" path="commodity" id="commodity"
					items="${commodities}" itemValue="id" itemLabel="name" />
			</div>
			<%-- <label style="color: red; text-align: left;" for="category"
				class="col-sm-3 control-label"><form:errors path="category" /></label> --%>
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
				<a class="btn btn-primary" href="/admin/productDescription/cancel">Отменить</a>
			</div>
		</div>
	</form:form>
</div>
<div class="row">
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-xs-3">
				<h3>Картинка</h3>
			</div>
			<div class="col-md-3 col-xs-3">
				<h3>Название кия</h3>
			</div>
			<div class="col-md-3 col-xs-3">
				<h3>Обновить</h3>
			</div>
			<div class="col-md-3 col-xs-3">
				<h3>Удалить</h3>
			</div>
		</div>
		<c:forEach items="${productDescriptions}" var="productDescription">
			<div class="row">

				<div class="col-md-3 col-xs-3">
					<img
						src="/images/desc/${productDescription.id}.jpg?version=${productDescription.version}"
						width="120" alt="Here is cue">
				</div>
				<div class="col-md-3 col-xs-3">${productDescription.commodity.name}</div>

				<div class="col-md-3 col-xs-3">
					<a class="btn btn-warning"
						href="/admin/productDescription/update/${productDescription.id}<custom:allParams/>">update</a>
				</div>
				<div class="col-md-3 col-xs-3">
					<a class="btn btn-danger"
						href="/admin/productDescription/delete/${productDescription.id}<custom:allParams/>">delete</a>
				</div>
			</div>
		</c:forEach>
	</div>
</div>