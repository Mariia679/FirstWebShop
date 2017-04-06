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

<div class="row all-products display-flex">
	<div class="col-md-1 col-sm-1 col-xs-1 text-center">
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
				<custom:sort innerHtml="По цене по возрастанию" paramValue="price" />
				<custom:sort innerHtml="По цене по убыванию" paramValue="price,desc" />

			</ul>
		</div>
	</div>
	<div class="col-md-1 col-sm-1 col-xs-1 text-center">
		<custom:size posibleSizes="1,2,4,8,16,24" size="${page.size}" />
	</div>
</div>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-3 col-sm-3 col-xs-3">
			<form:form class="form-inline" action="/chalk" method="GET"
				modelAttribute="filter">
				<custom:hiddenInputs excludeParams="nameChalk, min, max" />
				<div class="all-products">
					<div class="col-sm-12 col-xs-12">
						<form:input path="nameChalk" class="form-control "
							placeholder="Search" />
					</div>
				</div>
				<div class="all-products">
					<div class="col-sm-6 col-xs-6">
						<form:input path="min" class="form-control" placeholder="Min" />
					</div>
					<div class="col-sm-6 col-xs-6">
						<form:input path="max" class="form-control" placeholder="Max" />
					</div>
				</div>
				<button class="btn btn-primary" type="submit">Ok</button>
			</form:form>
		</div>

		<div class="all-product">
			<c:forEach items="${page.content}" var="chalk">
				<div class="thumbnail">
					<img src="/images/chalk/${chalk.id}.jpg?version=${chalk.version}"
						width="300" alt="Here is cue">
					<h3 class="text-center">${chalk.name}</h3>
					<p>Цена ${chalk.price} грн</p>
					<p>
						<a href="/chalk/buy/${chalk.id}" class="btn btn-primary"
							role="button">Купить</a> <a href="/chalk/details/${chalk.id}"
							class="btn btn-default" role="button">Подробнее...</a>
					</p>

				</div>
			</c:forEach>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12 col-xs-12 text-center">
			<custom:pageable page="${page}" cell="<li></li>"
				container="<ul class='pagination'></ul>" />
		</div>
	</div>
</div>