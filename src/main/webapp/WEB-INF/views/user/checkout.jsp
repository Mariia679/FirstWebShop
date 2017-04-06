<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="row">

	<div class="col-md-8 col-sm-12 col-xs-12">
		<h3 class="text-center">Оформление заказа</h3>
		<h4 class="text-center">Личные данные</h4>
		<form:form class="form-horizontal" action="/checkout" method="POST"
			modelAttribute="userForm">
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">Имя<span
					style="color: red;"><sup>✶</sup></span></label>
				<div class="col-sm-7">
					<form:input class="form-control" path="name" id="name"
						required="required" />
				</div>
				<label style="color: red; text-align: left;" for="name"
					class="col-sm-3"><form:errors path="name" /></label>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">Фамилия<span
					style="color: red;"><sup>✶</sup></span></label>
				<div class="col-sm-7">
					<form:input class="form-control" path="surname" id="name"
						required="required" />
				</div>


			</div>
			<div class="form-group">
				<label for="email" class="col-sm-2 control-label">Ваш E-mail<span
					style="color: red;"><sup>✶</sup></span>
				</label>
				<div class="col-sm-7">
					<form:input class="form-control" path="email" id="email"
						required="required" />
				</div>
				<label style="color: red; text-align: left;" for="email"
					class="col-sm-3"><form:errors path="email" /></label>
			</div>
			<div class="form-group">
				<label for="phone" class="col-sm-2 control-label">Телефон<span
					style="color: red;"><sup>✶</sup></span></label>
				<div class="col-sm-7">
					<form:input type="tel" class="form-control" path="phone" id="phone"
						required="required" />
				</div>

			</div>
			<div class="form-group">
				<label for="city" class="col-sm-2 control-label">Город<span
					style="color: red;"><sup>✶</sup></span></label>
				<div class="col-sm-7">
					<form:select class="form-control" path="city" id="city"
						items="${cities}" itemValue="id" itemLabel="name"
						required="required" />
				</div>

			</div>
			<div class="form-group">
				<label for="mail" class="col-sm-2 control-label">Отделение
					Новой почты<span style="color: red;"><sup>✶</sup></span>
				</label>
				<div class="col-sm-7">
					<form:input type="text" class="form-control" path="mail" id="mail"
						required="required" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Оформить</button>
					<a href="/checkout/cancel" type="submit" class="btn btn-primary">Cancel</a>
				</div>
			</div>
		</form:form>
	</div>
	<div class="col-md-4 col-sm-12 col-xs-12  product-hiden">

		<c:choose>
			<c:when
				test="${empty commodities and empty tubes 
							and empty chalks and empty stickers 
							and empty productCares and empty motherInLaws 
							and empty holdersChalks and empty gloves}">
				<div style="display: flex;">
					<div>
						<img alt="" src="/resources/img/carzina.png">
					</div>
					<div class="text-center none-purchase-down">
						<span class="purchases">Ну что,</span>
						<p class="purchases">за покупками?</p>

					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="total-cost " style="font-size: 20px; margin: 20px 0px;">Сумма
					${cartItemPrice} грн.</div>
				<div id="col-sm-12">
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
									<a href="/sticker/details/${sticker.id}" class="text-uppercase"
										id="commodity-name">${sticker.name}</a>
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
									<a href="/productCare/del/${productCare.id}" class="btn trash"><span
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
									<a href="/motherInLaw/del/${motherInLaw.id}" class="btn trash"><span
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
										class="btn trash"><span class="glyphicon glyphicon-trash"></span></a>
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
			</c:otherwise>
		</c:choose>
	</div>
</div>

