<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <security:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
	<a href="/admin">admin</a>
		<security:authentication property="principal.email"/>
</security:authorize> --%>
<br>
<br>
<div class="row body-down">
	<div class="container-fluid">

		<!-- THERE WOULD BE AN ADVERTISING-->
		<div id="carousel-example-generic" class="carousel slide"
			data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#carousel-example-generic" data-slide-to="0"
					class="active"></li>
				<li data-target="#carousel-example-generic" data-slide-to="1"></li>
				<li data-target="#carousel-example-generic" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="/resources/img/pM5gK6hq.inettools.net.rotate.image.jpg"
						alt="...">
					<div class="carousel-caption"></div>
				</div>
				<div class="item">
					<img src="/resources/img/G9zqwkVO.inettools.net.rotate.image.jpg"
						alt="...">
					<div class="carousel-caption"></div>
				</div>

				<div class="item">
					<img src="/resources/img/8TNXv0a9.inettools.net.rotate.image.jpg"
						alt="...">
					<div class="carousel-caption"></div>
				</div>

			</div>

			<!-- Controls -->
			<a class="left carousel-control" href="#carousel-example-generic"
				role="button" data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#carousel-example-generic"
				role="button" data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>


		<!-- INFORMATION ABOUT HOW YOU CAN SELLECT THE CUES-->

		<!-- MOST POPULAR CUES-->

		<div class="all-product">
			<c:forEach items="${page.content}" var="commodity">

				 <div class="thumbnail">
					<img
						src="/images/commodity/${commodity.id}.jpg?version=${commodity.version}"
						width="300" alt="Here is cue"> 
					<h3 class="text-center">${commodity.name}</h3>
					<%--  <p>Категория ${commodity.category.name}</p>
					<p>Дерево ${commodity.wood.name} --%>
					<p> 
					<p>Цена ${commodity.price} грн</p>
					<div class="align-product">
						<a href="/allProducts/buy/${commodity.id}" class="btn btn-primary"
							role="button">Купить</a> <a
							href="/allProducts/details/${commodity.id}"
							class="btn btn-default" role="button">Подробнее...</a>
					</div>
				 </div> 

			</c:forEach>
		</div>
		<!-- INFORMATION ABOUT SHOP-->
		<div class="row all-products">
			<c:forEach items="${mainPages}" var="mainPage">
				<div class="row">
					<div class="col-md-12 col-xs-12 text-center">
						<h3>${mainPage.name}</h3>
					</div>
					<div class="col-md-12 col-xs-12 ">${mainPage.content}</div>
				</div>
			</c:forEach>
		</div>
		<!-- ALL FOR BILLIARD-->

	</div>
</div>