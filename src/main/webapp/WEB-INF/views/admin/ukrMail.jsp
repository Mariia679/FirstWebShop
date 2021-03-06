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
			<ul class="nav navbar-nav">
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
				<li class="active"><a href="/admin/ukrMail<custom:allParams/>">УкрПочта</a><span
					class="sr-only">(current)</span></li>
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
	<div class="col-md-3 col-xs-3">
		<form:form class="form-horizontal filter" action="/admin/ukrMail"
			method="GET" modelAttribute="filter">
			<custom:hiddenInputs excludeParams="departmentMail,cityId, _cityId" />
			<div class="form-group">
				<form:input path="departmentMail" class="form-control"
					placeholder="Search" />
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12  weight-font-size">Город</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${cities}" itemValue="id"
						itemLabel="name" path="cityId" />
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Ok</button>
		</form:form>
	</div>
	<div class="col-md-7 col-xs-6">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/admin/ukrMail"
					method="POST" modelAttribute="ukrMail">
					<custom:hiddenInputs excludeParams="city, department" />
					<div class="form-group">
						<label for="city" class="col-sm-2 control-label">Город</label>
						<div class="col-sm-7">
							<form:select class="form-control" path="city" id="city"
								items="${cities}" itemValue="id" itemLabel="name" />
						</div>
						<label style="color: red; text-align: left;" for="city"
							class="col-sm-3 control-label"><form:errors path="city" /></label>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Отделение</label>
						<div class="col-sm-7">
							<form:input type="text" class="form-control" path="department"
								id="name" />
						</div>
						<label style="color: red; text-align: left;" for="name"
							class="col-sm-3 control-label"><form:errors
								path="department" /></label>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Создать</button>
							<a class="btn btn-primary" href="/admin/ukrMail/cancel">Отменить</a>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-xs-4">
				<h3>Отделение</h3>
			</div>
			<div class="col-md-3 col-xs-3">
				<h3>Город</h3>
			</div>
			<div class="col-md-3 col-xs-3">
				<h3>Обновить</h3>
			</div>
			<div class="col-md-2 col-xs-2">
				<h3>Удалить</h3>
			</div>
		</div>

		<c:forEach items="${page.content}" var="ukrMail">
			<div class="row">
				<div class="col-md-4 col-xs-4">${ukrMail.department}</div>
				<div class="col-md-3 col-xs-3">${ukrMail.city.name}</div>
				<div class="col-md-3 col-xs-3">
					<a class="btn btn-warning"
						href="/admin/ukrMail/update/${ukrMail.id}<custom:allParams/>">update</a>
				</div>
				<div class="col-md-2 col-xs-2">
					<a class="btn btn-danger"
						href="/admin/ukrMail/delete/${ukrMail.id}<custom:allParams/>">delete</a>
				</div>
			</div>
		</c:forEach>
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
						<custom:sort innerHtml="По отделению по возрастанию"
							paramValue="department" />
						<custom:sort innerHtml="По отделению по убыванию"
							paramValue="department,desc" />

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
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>"
			container="<ul class='pagination'></ul>" />
	</div>
</div>