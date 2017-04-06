<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<div class="container">
	<div class="row">

		<div class="col-md-4 col-sm-4 col-xs-12">
			<div class="row name">${chalk.name}</div>
			<img src="/images/chalk/${chalk.id}.jpg?version=${chalk.version}"
				width="300" alt="Here is cue">
			
		</div>
		<div class="col-md-8 col-sm-8 col-xs-12">

			<div class="price">${chalk.price}грн.</div>
			<div class="row indent">
				<a href="/chalk/toBascet/${chalk.id}" class="btn btn-primary"
					role="button">В корзину</a>
			</div>
			<div class="row">
				<!--  Доставка оплата гарантия -->
				<!-- Nav tabs -->
				<div class="row">
					<div class="col-md-5">
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
	<div class="row">
		<div>
			<!-- Nav tabs -->
			<ul class="nav nav-tabs" role="tablist">

				<li role="presentation" class="active"><a href="#profile"
					aria-controls="profile" role="tab" data-toggle="tab">Описание</a></li>
				<li role="presentation"><a href="#messages"
					aria-controls="messages" role="tab" data-toggle="tab">Отзывы</a></li>
			</ul>
			<!-- Tab panes -->
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane bascket active" id="profile">
					${chalk.description}</div>
				<div role="tabpanel" class="tab-pane bascket" id="messages">

					<form:form class="form-horizontal"
						action="/user/chalkCard/${chalk.id}" method="POST"
						modelAttribute="tubeCard">
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
								<textarea class="form-control" name="review"
									id="summernote"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label for="review" class="col-sm-2 control-label">Отзыв</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="review"
									id="review">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">Cоздать</button>
								<a class="btn btn-primary" href="/user/chalkCard/cancel">Отменить</a>
							</div>
						</div>
					</form:form>

					<c:forEach items="${reviews}" var="review">
						<div class="display-flex">
							<div>${review.review}</div>
							<div>${review.date}</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
$(document).ready(function() {
    $('#summernote').summernote({
    	lang: 'ru-RU'
    });
});
</script>