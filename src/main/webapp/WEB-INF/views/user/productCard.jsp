<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<style type="text/css">
.slider {
	width: 60%;
	/*  margin: 100px auto; */
}

.slick-slide {
	margin: 0px 20px;
}

.slick-slide img {
	width: 100%;
}

.slick-prev:before, .slick-next:before {
	color: black;
}
</style>

<div class="container">
	<div class="row">

		<div class="col-md-6 col-sm-6 col-xs-12">
			<div class="row name">${commodity.name}</div>

			<section class="slider-for slider">
				<c:forEach items="${productDescriptions}" var="productDescription">
						<c:choose>
							<c:when test="${productDescription.commodity.id == commodity.id}">
							<div>
								<img
									src="/images/desc/${productDescription.id}.jpg?version=${productDescription.version}"
									width="120" alt="Here is cue"></div>
							</c:when>
						</c:choose>
					
				</c:forEach>
			</section>

			<section class="slider-nav slider">

				<c:forEach items="${productDescriptions}" var="productDescription">
				
						<c:choose>
							<c:when test="${productDescription.commodity.id == commodity.id}">
									<div><img
									src="/images/desc/${productDescription.id}.jpg?version=${productDescription.version}"
									alt="Here is cue" style="width: 200;"></div>
							</c:when>
						</c:choose>
					
				</c:forEach>
			</section>

		</div>

		<div class="col-md-6 col-sm-6 col-xs-12">

			<div class="price">${commodity.price}грн.</div>
			<div class="row indent">
				<a href="/allProducts/toBascet/${commodity.id}"
					class="btn btn-primary" role="button">В корзину</a>
			</div>
			<div class="row">
				<!--  Доставка оплата гарантия -->
				<!-- Nav tabs -->
				<div class="row ">
					<div class="col-md-12 ">
						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation" class="active"><a href="#delivery"
								aria-controls="delivery" role="tab" data-toggle="tab">Доставка</a></li>
							<li role="presentation"><a href="#payment"
								aria-controls="payment" role="tab" data-toggle="tab">Оплата</a></li>
							<li role="presentation"><a href="#seal" aria-controls="seal"
								role="tab" data-toggle="tab">Гарантия</a></li>
						</ul>

						<!-- Tab panes -->
						<div class="tab-content">
							<div role="tabpanel" class="tab-pane active" id="delivery">Новой
								почтой блаблабла</div>
							<div role="tabpanel" class="tab-pane" id="payment">Оплата
								наличными блаблабла</div>
							<div role="tabpanel" class="tab-pane" id="seal">Гарантия
								блаблабла</div>
						</div>
					</div>
				</div>
				<!--   ЗДЕСЬ БУДУТ ПОХОЖИЕ ТОВАРЫ -->


			</div>
		</div>
	</div>
</div>

<div class="row">
	<div class="container">

		<!-- Nav tabs -->
		<ul class="nav nav-tabs" role="tablist">
			<li role="presentation" class="active"><a href="#home"
				aria-controls="home" role="tab" data-toggle="tab">Характеристика</a></li>
			<li role="presentation"><a href="#profile"
				aria-controls="profile" role="tab" data-toggle="tab">Описание</a></li>
			<li role="presentation"><a href="#messages"
				aria-controls="messages" role="tab" data-toggle="tab">Отзывы</a></li>
		</ul>

		<!-- Tab panes -->
		<div class="tab-content">
			<div role="tabpanel" class="tab-pane active bascket" id="home">
				<p>
					<strong><em>Категория:</em></strong> ${commodity.category.name}
				</p>
				<p>
					<strong><em>Дерево:</em></strong> ${commodity.wood.name}
				</p>
				<p>
					<strong><em>Вид запила:</em></strong> ${commodity.gashType.name}
				</p>
				<p>
					<em><strong>Запилы:</strong></em> <em>Шафт</em>
					${commodity.shaft.name}, <em>Турняк</em> ${commodity.butt.name}
				</p>
				<p>
					<em><strong>Вес:</strong></em> ${commodity.weight}
				</p>
				<p>
					<em><strong>Стакан (феруле):</strong></em> ${commodity.ferula.name}
				</p>
				<p>
					<em><strong>Наклейка:</strong></em> ${commodity.sticker.name}
				</p>
				<p>
					<em><strong>Тип наклейки:</strong></em>
					${commodity.typeSticker.name}
				</p>
				<p>
					<em><strong>Длина в сборе:</strong></em> ${commodity.length}
				</p>
				<p>
					<em><strong>Скрутка (тип резьбы):</strong></em>
					${commodity.materialJoint.name}, ${commodity.carvingJoint.name}
				</p>
				<p>
					<em><strong>Бондажные кольца торцов:</strong></em>
					${commodity.ringEnd.name}
				</p>
				<p>
					<em><strong>Бондажное кольцо бампера:</strong></em>
					${commodity.ringBumper.name}
				</p>
				<p>
					<em><strong>Амортизатор:</strong></em> ${commodity.damper.name}
				</p>
			</div>
			<div role="tabpanel" class="tab-pane bascket" id="profile">
				${commodity.description}</div>
			<div role="tabpanel" class="tab-pane bascket" id="messages">

				<form:form class="form-horizontal"
					action="/user/productCard/${commodity.id}" method="POST"
					modelAttribute="productCard">
					<custom:hiddenInputs excludeParams="name, review" />
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Имя</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="name" id="name">
						</div>
					</div>
					<div class="form-group">
						<label for="review" class="col-sm-2 control-label">Отзыв</label>
						<div class="col-sm-10">
							<textarea class="form-control" name="review" id="summernote"></textarea>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Cоздать</button>
							<a class="btn btn-primary" href="/user/productCard/cancel/${commodity.id}">Отменить</a>
						</div>
					</div>
				</form:form>

				<c:forEach items="${reviews}" var="review">
					<div>${review.user.username}</div>
					<div class="display-flex">
						<div>${review.review}</div>
						<div>${review.date}</div>
					</div>
					<security:authorize
						access="isAuthenticated() and principal.username=='${review.user.username}'">
						<a class="btn btn-warning"
							href="/user/productCard/update/${review.id}/${commodity.id}">update</a>
						<a class="btn btn-danger"
							href="/user/productCard/delete/${review.id}/${commodity.id}">delete</a>
					</security:authorize>
				</c:forEach>
			</div>
		</div>

	</div>

</div>
<script type="text/javascript">
	$(document).ready(function() {
		$('#summernote').summernote({
			lang : 'ru-RU'
		});
	});
</script>
<script src="https://code.jquery.com/jquery-2.2.0.min.js"
	type="text/javascript"></script>
<script src="/resources/js/slick.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript">
	$(document).on('ready', function() {

		$('.slider-for').slick({
			slidesToShow : 1,
			slidesToScroll : 1,
			arrows : false,
			fade : true,
			asNavFor : '.slider-nav'
		});
		$('.slider-nav').slick({
			slidesToShow : 2,
			slidesToScroll : 1,
			asNavFor : '.slider-for',
			/* dots : true, */
			centerMode : true,
			focusOnSelect : true,
			autoplay : true
		});

	});
</script>
<!--  -->
