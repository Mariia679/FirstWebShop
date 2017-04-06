<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<div class="icon">
	<div class="row space">
		<div class="space">
			<div class="container-fluid" id="upperheader">

				<ul class="list-inline col-md-10 col-sm-10 text-right">
					<li class="dropdown"><a href="" role="button"
						class="dropdown-toggle" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> <span
							class="glyphicon glyphicon-home" aria-hidden="true"></span>
							Личный кабинет <span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="/user/cart"> <span
									class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
									Корзина
							</a></li>
							<li><a href="/checkout"> <span
									class="glyphicon glyphicon-file" aria-hidden="true"></span>
									Оформить заказ
							</a></li>
						</ul></li>
					<security:authorize access="!isAuthenticated()">
						<li><a href="" role="button" data-toggle="modal"
							data-target=".bs-example-modal" class="color-login">Войти</a></li>
					</security:authorize>
				</ul>
				<security:authorize access="!isAuthenticated()">
					<div class="modal fade bs-example-modal " tabindex="-1"
						role="dialog" aria-labelledby="myLargeModalLabel">
						<div class="modal-dialog modal-lg" role="document">
							<div class="modal-content">
								<form:form action="/login" method="POST">
									<div class="form-group margin-padding ">
										<input class="form-control" placeholder="Login" name="login">
									</div>
									<div class="form-group margin-padding ">
										<input class="form-control" placeholder="Password"
											type="password" name="password">
									</div>
									<div class="checkbox margin-padding ">
										<label> <input name="remember-me" type="checkbox">
											<span>Remember me</span>
										</label>
									</div>
									<div class="btn-modal-cart ">
										<button class="marg-padding btn btn-primary">Sign in</button>
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</security:authorize>


				<ul class="nav navbar-nav navbar-right bascket">
					<li>
						<button type="button" class="btn btn-default cart"
							data-toggle="modal" data-target=".bs-example-modal-lg">
							<span class="glyphicon glyphicon-shopping-cart"></span> Корзина <span
								class="badge"> ${quantity.count}</span>
						</button>
					</li>
				</ul>
				<security:authorize access="isAuthenticated()">
					<form:form class="navbar-form navbar-right" action="/logout"
						method="POST">
						<button class="btn btn-primary">Sign out</button>
					</form:form>
					<security:authorize access="hasRole('ROLE_ADMIN')">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="/admin">Admin</a></li>
							<li class="dropdown"><a href="" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false"> Entities <span class="caret"></span>
							</a>

								<ul class="dropdown-menu">
									<li><a href="/admin/mainPage">Контент главной страницы</a></li>
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
									<li><a href="/admin/ringBumper">Бондажное кольцо
											бампера</a></li>
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
									<li><a href="/admin/winding">Обмотка для кия</a></li>
									<li><a href="/admin/tube">Тубус</a></li>
								</ul></li>
						</ul>
					</security:authorize>
				</security:authorize>

				<a href="/"> <img alt="" src="/resources/img/4nlncmfGrMY.png"
					class="img-circle"></a>
			</div>
		</div>
	</div>
	<div class="modal fade bs-example-modal-lg " tabindex="-1"
		role="dialog" aria-labelledby="myLargeModalLabel">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content text">
				<a href="/user/cart" class="color-cart ">Перейти в корзину ↑ </a>
				<div class="row">

					<c:choose>
						<c:when
							test="${empty commodities and empty tubes 
							and empty chalks and empty stickers 
							and empty productCares and empty motherInLaws 
							and empty holdersChalks and empty gloves}">
							<div style="display: flex;">
								<div>
									<img alt="" src="/resources/img/carzina.png"
										class="image-none-purchase">
								</div>
								<div class="text-center none-purchase-down">
									<span class="purchases">Ну что,</span>
									<p class="purchases">за покупками?</p>
								</div>
							</div>
						</c:when>
						<c:otherwise>

							<div class="full-modal-cart col-md-11 col-sm-11"
								style="margin-left: 50px;">
								<c:forEach items="${commodities}" var="commodity">
									<div class="cart-bord">
										<div class="row">
											<div class="col-md-5 col-sm-5 col-xs-5">
												<a href="/allProducts/details/${commodity.id}"> <img
													src="/images/commodity/${commodity.id}.jpg?version=${commodity.version}"
													width="150" alt="Here is cue">
												</a>
											</div>
											<div class="col-md-5 col-sm-5 col-xs-5"
												style="padding-top: 50px;">
												<a href="/allProducts/details/${commodity.id}"
													class="text-uppercase" id="commodity-name">${commodity.name}</a>

											</div>
											<div class="col-md-2 col-sm-2 col-xs-2"
												style="padding-top: 50px;">
												<a href="/commodity/del/${commodity.id}" class="btn trash"><span
													class="glyphicon glyphicon-trash"></span></a>
											</div>

										</div>
										<div class="row ">
											<div class="col-sm-9 col-xs-12">
												<div class="col-sm-3 col-xs-3">Цена</div>
												<div class="col-sm-5 col-xs-5">Количество</div>
												<div class="col-sm-4 col-xs-4">Сумма</div>
											</div>
											<div class="row ">
												<div class="col-sm-9 col-xs-12">
													<div class="col-sm-3 col-xs-3 font-product" id="price">
														${commodity.price} грн</div>
													<div class="col-sm-5 col-xs-5 font-product">${commodity.quantity}</div>
													<div class="col-sm-4 col-xs-4 color-sum" id="price">
														${commodity.sumPrice} грн</div>
												</div>
											</div>
										</div>

									</div>
								</c:forEach>
								<c:forEach items="${tubes}" var="tube">
									<div class="cart-bord">
										<div class="row">
											<div class="col-md-5 col-sm-5 col-xs-5">
												<a href="/cover/details/${tube.id}"> <img
													src="/images/tube/${tube.id}.jpg?version=${tube.version}"
													width="150" alt="Here is cue"></a>
											</div>
											<div class="col-md-5 col-sm-5 col-xs-5"
												style="padding-top: 50px;">
												<a href="/cover/details/${tube.id}" class="text-uppercase"
													id="commodity-name">${tube.name}</a>
											</div>
											<div class="col-md-2 col-sm-2 col-xs-2"
												style="padding-top: 50px;">
												<a href="/tube/del/${tube.id}" class="btn trash"><span
													class="glyphicon glyphicon-trash"></span></a>
											</div>
										</div>
										<div class="row ">
											<div class="col-sm-9 col-xs-12" style="padding-left: 30px;">
												<div class="col-sm-3 col-xs-3">Цена</div>
												<div class="col-sm-5 col-xs-5">Количество</div>
												<div class="col-sm-4 col-xs-4">Сумма</div>
											</div>
											<div class="row ">
												<div class="col-sm-9 col-xs-12" style="padding-left: 30px;">
													<div class="col-sm-3 col-xs-3 font-product" id="price">
														${tube.price} грн</div>
													<div class="col-sm-5 col-xs-5 font-product">${tube.quantity}</div>
													<div class="col-sm-4 col-xs-4 color-sum" id="price">
														${tube.sumPrice} грн</div>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
								<c:forEach items="${chalks}" var="chalk">
									<div class="cart-bord">
										<div class="row">
											<div class="col-md-5 col-sm-5 col-xs-5">
												<a href="/chalk/details/${chalk.id}"> <img
													src="/images/chalk/${chalk.id}.jpg?version=${chalk.version}"
													width="150" alt="Here is cue"></a>
											</div>
											<div class="col-md-5 col-sm-5 col-xs-5"
												style="padding-top: 50px;">
												<a href="/chalk/details/${chalk.id}" class="text-uppercase"
													id="commodity-name">${chalk.name}</a>
											</div>
											<div class="col-md-2 col-sm-2 col-xs-2"
												style="padding-top: 50px;">
												<a href="/chalk/del/${chalk.id}" class="btn trash"><span
													class="glyphicon glyphicon-trash"></span></a>
											</div>
										</div>
										<div class="row ">
											<div class="col-sm-9 col-xs-12" style="padding-left: 30px;">
												<div class="col-sm-4 col-xs-4">Цена</div>
												<div class="col-sm-4 col-xs-4">Количество</div>
												<div class="col-sm-4 col-xs-4">Сумма</div>
											</div>
											<div class="row ">
												<div class="col-sm-9 col-xs-12" style="padding-left: 30px;">
													<div class="col-sm-3 col-xs-3 font-product" id="price">
														${chalk.price} грн</div>
													<div class="col-sm-5 col-xs-5 font-product">${chalk.quantity}</div>
													<div class="col-sm-4 col-xs-4 color-sum" id="price">
														${chalk.sumPrice} грн</div>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
								<c:forEach items="${stickers}" var="sticker">
									<div class="cart-bord">
										<div class="row">
											<div class="col-md-5 col-sm-5 col-xs-5">
												<a href="/sticker/details/${sticker.id}"> <img
													src="/images/sticker/${sticker.id}.jpg?version=${sticker.version}"
													width="150" alt="Here is cue"></a>
											</div>
											<div class="col-md-5 col-sm-5 col-xs-5"
												style="padding-top: 50px;">
												<a href="/sticker/details/${sticker.id}"
													class="text-uppercase" id="commodity-name">${sticker.name}</a>
											</div>
											<div class="col-md-2 col-sm-2 col-xs-2"
												style="padding-top: 50px;">
												<a href="/sticker/del/${sticker.id}" class="btn trash"><span
													class="glyphicon glyphicon-trash"></span></a>
											</div>
										</div>
										<div class="row ">
											<div class="col-sm-9 col-xs-12" style="padding-left: 30px;">
												<div class="col-sm-4 col-xs-4">Цена</div>
												<div class="col-sm-4 col-xs-4">Количество</div>
												<div class="col-sm-4 col-xs-4">Сумма</div>
											</div>
											<div class="row ">
												<div class="col-sm-9 col-xs-12" style="padding-left: 30px;">
													<div class="col-sm-3 col-xs-3 font-product" id="price">
														${sticker.price} грн</div>
													<div class="col-sm-5 col-xs-5 font-product">${sticker.quantity}</div>
													<div class="col-sm-4 col-xs-4 color-sum" id="price">
														${sticker.sumPrice} грн</div>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
								<c:forEach items="${productCares}" var="productCare">
									<div class="cart-bord">
										<div class="row">
											<div class="col-md-5 col-sm-5 col-xs-5">
												<a href="/productCare/details/${productCare.id}"> <img
													src="/images/product_care/${productCare.id}.jpg?version=${productCare.version}"
													width="150" alt="Here is cue"></a>
											</div>
											<div class="col-md-5 col-sm-5 col-xs-5"
												style="padding-top: 50px;">
												<a href="/productCare/details/${productCare.id}"
													class="text-uppercase" id="commodity-name">${productCare.name}</a>
											</div>
											<div class="col-md-2 col-sm-2 col-xs-2"
												style="padding-top: 50px;">
												<a href="/productCare/del/${productCare.id}"
													class="btn trash"><span
													class="glyphicon glyphicon-trash"></span></a>
											</div>
										</div>
										<div class="row ">
											<div class="col-sm-9 col-xs-12" style="padding-left: 30px;">
												<div class="col-sm-4 col-xs-4">Цена</div>
												<div class="col-sm-4 col-xs-4">Количество</div>
												<div class="col-sm-4 col-xs-4">Сумма</div>
											</div>
											<div class="row ">
												<div class="col-sm-9 col-xs-12" style="padding-left: 30px;">
													<div class="col-sm-3 col-xs-3 font-product" id="price">
														${productCare.price} грн</div>
													<div class="col-sm-5 col-xs-5 font-product">${productCare.quantity}</div>
													<div class="col-sm-4 col-xs-4 color-sum" id="price">
														${productCare.sumPrice} грн</div>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
								<c:forEach items="${motherInLaws}" var="motherInLaw">
									<div class="cart-bord">
										<div class="row">
											<div class="col-md-5 col-sm-5 col-xs-5">
												<a href="/motherInLaw/details/${motherInLaw.id}"> <img
													src="/images/mother_in_law/${motherInLaw.id}.jpg?version=${motherInLaw.version}"
													width="150" alt="Here is cue"></a>
											</div>
											<div class="col-md-5 col-sm-5 col-xs-5"
												style="padding-top: 50px;">
												<a href="/motherInLaw/details/${motherInLaw.id}"
													class="text-uppercase" id="commodity-name">${motherInLaw.name}</a>
											</div>
											<div class="col-md-2 col-sm-2 col-xs-2"
												style="padding-top: 50px;">
												<a href="/motherInLaw/del/${motherInLaw.id}"
													class="btn trash"><span
													class="glyphicon glyphicon-trash"></span></a>
											</div>
										</div>
										<div class="row ">
											<div class="col-sm-9 col-xs-12" style="padding-left: 30px;">
												<div class="col-sm-4 col-xs-4">Цена</div>
												<div class="col-sm-4 col-xs-4">Количество</div>
												<div class="col-sm-4 col-xs-4">Сумма</div>
											</div>
											<div class="row ">
												<div class="col-sm-9 col-xs-12" style="padding-left: 30px;">
													<div class="col-sm-3 col-xs-3 font-product" id="price">
														${motherInLaw.price} грн</div>
													<div class="col-sm-5 col-xs-5 font-product">${motherInLaw.quantity}</div>
													<div class="col-sm-4 col-xs-4 color-sum" id="price">
														${motherInLaw.sumPrice} грн</div>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
								<c:forEach items="${holdersChalks}" var="holdersChalk">
									<div class="cart-bord">
										<div class="row">
											<div class="col-md-5 col-sm-5 col-xs-5">
												<a href="/holdersChalk/details/${holdersChalk.id}"> <img
													src="/images/holders_chalk/${holdersChalk.id}.jpg?version=${holdersChalk.version}"
													width="150" alt="Here is cue"></a>
											</div>
											<div class="col-md-5 col-sm-5 col-xs-5"
												style="padding-top: 50px;">
												<a href="/holdersChalk/details/${holdersChalk.id}"
													class="text-uppercase" id="commodity-name">${holdersChalk.name}</a>
											</div>
											<div class="col-md-2 col-sm-2 col-xs-2"
												style="padding-top: 50px;">
												<a href="/holdersChalk/del/${holdersChalk.id}"
													class="btn trash"><span
													class="glyphicon glyphicon-trash"></span></a>
											</div>
										</div>
										<div class="row ">
											<div class="col-sm-9 col-xs-12" style="padding-left: 30px;">
												<div class="col-sm-4 col-xs-4">Цена</div>
												<div class="col-sm-4 col-xs-4">Количество</div>
												<div class="col-sm-4 col-xs-4">Сумма</div>
											</div>
											<div class="row ">
												<div class="col-sm-9 col-xs-12" style="padding-left: 30px;">
													<div class="col-sm-3 col-xs-3 font-product" id="price">
														${holdersChalk.price} грн</div>
													<div class="col-sm-5 col-xs-5 font-product">${holdersChalk.quantity}</div>
													<div class="col-sm-4 col-xs-4 color-sum" id="price">
														${holdersChalk.sumPrice} грн</div>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
								<c:forEach items="${gloves}" var="glove">
									<div class="cart-bord">
										<div class="row">
											<div class="col-md-5 col-sm-5 col-xs-5">
												<a href="/gloves/details/${glove.id}"> <img
													src="/images/glove/${glove.id}.jpg?version=${glove.version}"
													width="150" alt="Here is cue"></a>
											</div>
											<div class="col-md-5 col-sm-5 col-xs-5"
												style="padding-top: 50px;">
												<a href="/gloves/details/${glove.id}" class="text-uppercase"
													id="commodity-name">${glove.name}</a>
											</div>
											<div class="col-md-2 col-sm-2 col-xs-2"
												style="padding-top: 50px;">
												<a href="/glove/del/${glove.id}" class="btn trash"><span
													class="glyphicon glyphicon-trash"></span></a>
											</div>
										</div>
										<div class="row ">
											<div class="col-sm-9 col-xs-12" style="padding-left: 30px;">
												<div class="col-sm-4 col-xs-4">Цена</div>
												<div class="col-sm-4 col-xs-4">Количество</div>
												<div class="col-sm-4 col-xs-4">Сумма</div>
											</div>
											<div class="row ">
												<div class="col-sm-9 col-xs-12" style="padding-left: 30px;">
													<div class="col-sm-3 col-xs-3 font-product" id="price">
														${glove.price} грн</div>
													<div class="col-sm-5 col-xs-5 font-product">${glove.quantity}</div>
													<div class="col-sm-4 col-xs-4 color-sum" id="price">
														${glove.sumPrice} грн</div>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
							<div class="col-md-12 col-sm-12">
								<hr>

								<h3 class="text-center">Oформление заказа</h3>

								<div style="margin-top: 30px;margin-left: 50px;">Купить в 1 клик:</div>

								<form:form class="form-inline" action="/user/cart" method="POST"
									modelAttribute="userForm" style="margin-left: 50px;">
									<div class="form-group">
										<form:input type="tel" class="form-control input-lg"
											path="phone" id="phone" required="required"
											placeholder="+38(0__)___-__-__" value="+38(0" />
									</div>
									<div class="form-group">
										<button type="submit" class="btn btn-primary btn-lg">Купить</button>
									</div>
								</form:form>

								<div class="btn-modal-cart">
									<a href="/checkout" class="btn btn-success btn-lg ">
										Оформить покупку</a>
								</div>
							</div>
						</c:otherwise>
					</c:choose>
				</div>

			</div>
		</div>
	</div>

	<header class="row" style="margin-top: 40px;">
		<nav class="navbar navbar-default text-uppercase">
			<div class="container-fluid">

				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar" aria-expanded="false">
					<span style="font-size: 40px; margin: 0px 10px;"
						class="glyphicon glyphicon-th-list"></span>
					<!-- 
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span> -->
				</button>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">
						<li><a href="/">Главная</a></li>
						<li><a href="/allProducts">Кии для бильярда</a></li>
						<li><a href="/cover">Чехлы и тубусы</a></li>
						<li class="dropdown "><a href="" role="button"
							class="dropdown-toggle" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded=false> Аксессуары для
								бильярда<span class="caret"></span>
						</a>
							<ul class="dropdown-menu text-lowercase">
								<li><a href="/chalk"><strong>Мел для кия</strong></a></li>
								<li><a href="/sticker"><strong>Наклейки для
											кия</strong></a></li>
								<li><a href="/gloves"><strong>Перчатки для
											бильярда</strong></a></li>
								<li><a href="/productCare"><strong>Средство по
											уходу за кием</strong></a></li>
								<li><a href="/holdersChalk"><strong>Держатели
											для мела</strong></a></li>
								<li><a href="/motherInLaw"><strong>Мосты, тещи
											для бильярда</strong></a></li>
							</ul></li>
						<!-- </ul> -->
						<!-- <ul class="nav navbar-nav navbar-right"> -->
						<security:authorize access="!isAuthenticated()">
							<li><a href="/registration">Регистрация</a></li>
						</security:authorize>
						<li><a href="/contact">Контакты</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
</div>
