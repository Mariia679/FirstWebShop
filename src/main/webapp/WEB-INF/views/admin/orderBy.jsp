<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav ">
				<li><a href="/admin/mainPage">Контент главной страницы</a></li>
				<li><a href="/admin/order">Заказы</a></li>
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

				<!-- НОВЫЕ ДОБАВЛЕНИЯ -->

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
<div class="container">
	<div class="row">
		<h3>Hомер заказа ${order.id}</h3>

	</div>
	<div class="row">
		<div class="col-md-3 col-xs-">
			<h3>Название</h3>
		</div>
		<div class="col-md-3 col-xs-">
			<h3>Количество</h3>
		</div>
		<div class="col-md-3 col-xs-">
			<h3>Цена з 1шт.</h3>
		</div>
		<div class="col-md-3 col-xs-3">
			<h3>Сумма</h3>
		</div>

	</div>


	<c:forEach items="${commodity}" var="commodity">
		<div class="row">
			<div class="col-md-3 col-sm-3 col-xs-3">${commodity.name}</div>
			<div class="col-md-3 col-sm-3 col-xs-3">${commodity.quantity}</div>
			<div class="col-md-3 col-sm-3 col-xs-3">${commodity.price}грн</div>

			<div class="col-md-3 col-sm-3 col-xs-3">${commodity.sumPrice}</div>
		</div>
	</c:forEach>



	<c:forEach items="${tube}" var="tube">
		<div class="row">
			<div class="col-md-3 col-sm-3 col-xs-3">${tube.name}</div>
			<div class="col-md-3 col-sm-3 col-xs-3">${tube.quantity}</div>
			<div class="col-md-3 col-sm-3 col-xs-3">${tube.price}грн</div>
			<div class="col-md-3 col-sm-3 col-xs-3">${tube.sumPrice}грн</div>
		</div>
	</c:forEach>


	<c:forEach items="${chalk}" var="chalk">
		<div class="row">
			<div class="col-md-3 col-sm-3 col-xs-3">${chalk.name}</div>
			<div class="col-md-3 col-sm-3 col-xs-3">${chalk.quantity}</div>
			<div class="col-md-3 col-sm-3 col-xs-3">${chalk.price}грн</div>
			<div class="col-md-3 col-sm-3 col-xs-3">${chalk.sumPrice}грн</div>
		</div>
	</c:forEach>


	<c:forEach items="${sticker}" var="sticker">
		<div class="row">
			<div class="col-md-3 col-sm-3 col-xs-3">${sticker.name}</div>
			<div class="col-md-3 col-sm-3 col-xs-3">${sticker.quantity}</div>
			<div class="col-md-3 col-sm-3 col-xs-3">${sticker.price}грн</div>
			<div class="col-md-3 col-sm-3 col-xs-3">${sticker.sumPrice}грн</div>
		</div>
	</c:forEach>


	<c:forEach items="${productCare}" var="productCare">
		<div class="row">
			<div class="col-md-3 col-sm-3 col-xs-3">${productCare.name}</div>
			<div class="col-md-3 col-sm-3 col-xs-3">${productCare.quantity}</div>
			<div class="col-md-3 col-sm-3 col-xs-3">${productCare.price}грн</div>
			<div class="col-md-3 col-sm-3 col-xs-3">${productCare.sumPrice}грн</div>
		</div>
	</c:forEach>


	<c:forEach items="${motherInLaw}" var="motherInLaw">
		<div class="row">
			<div class="col-md-3 col-sm-3 col-xs-3">${motherInLaw.name}</div>
			<div class="col-md-3 col-sm-3 col-xs-3">${motherInLaw.quantity}</div>
			<div class="col-md-3 col-sm-3 col-xs-3">${motherInLaw.price}грн</div>
			<div class="col-md-3 col-sm-3 col-xs-3">${motherInLaw.sumPrice}грн</div>
		</div>
	</c:forEach>


	<c:forEach items="${holdersChalk}" var="holdersChalk">
		<div class="row">
			<div class="col-md-3 col-sm-3 col-xs-3">${holdersChalk.name}</div>
			<div class="col-md-3 col-sm-3 col-xs-3">${holdersChalk.quantity}</div>
			<div class="col-md-3 col-sm-3 col-xs-3">${holdersChalk.price}грн</div>
			<div class="col-md-3 col-sm-3 col-xs-3">${holdersChalk.sumPrice}грн</div>
		</div>
	</c:forEach>


	<c:forEach items="${glove}" var="glove">
		<div class="row">
			<div class="col-md-3 col-sm-3 col-xs-3">${glove.name}</div>
			<div class="col-md-3 col-sm-3 col-xs-3">${glove.quantity}</div>
			<div class="col-md-3 col-sm-3 col-xs-3">${glove.price}грн</div>
			<div class="col-md-3 col-sm-3 col-xs-3">${glove.sumPrice}грн</div>
		</div>
	</c:forEach>
	<p class="text-right">${order.price }</p>

</div>
