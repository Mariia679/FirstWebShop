<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container" >
	<div class="row marg"   >
		<div class="col-md-4 col-sm-4 col-xs-12" >
			<img src="/resources/img/map.png" width="35"><span
				style="font-size: 30px;" class="our-tel">Адрес</span>
			<div class="marg" style="margin-left: 20px;">
				<p>г. Харьков</p>
				<p>График работы:</p>
				<p>пн-вс: 9-20</p>
			</div>
		</div>
		<div class="col-md-4 col-sm-4 col-xs-12">
			<span style="font-size: 30px;" class="glyphicon glyphicon-earphone "></span><span
				class="our-tel" style="font-size: 30px;">Телефон</span>
			<div class="marg">
				<p>+38(050) 595-04-42 - Сергей</p>
				<p>+38(066) 858-06-49 - Ирина</p>
			</div>
		</div>
		<div class="col-md-4 col-sm-4 col-xs-12">
			<span style="font-size: 35px;">@</span> <span
				style="font-size: 30px;" class="our-tel">E-Mail</span>
			<div class="marg" style="margin-left: 20px;">
				<p>ssandy679@gmail.com</p>
			</div>
		</div>
	</div>

	<div class="row">
		<p style="font-size: 30px;" class="our-tel text-center">Обратная связь</p>
		<form class="form-horizontal" action="/contact" method="POST">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<div class="form-group">
				<label for="name" class="col-sm-1 control-label">Имя<span
					style="color: red;"><sup>✶</sup></span></label>
				<div class="col-sm-10">
					<input class="form-control" name="username" id="name"
						required="required">
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-1 control-label">Почта<span
					style="color: red;"><sup>✶</sup></span></label>
				<div class="col-sm-10">
					<input class="form-control" name="email" id="email"
						required="required">
				</div>

			</div>
			<div class="form-group">
				<label for="review" class="col-sm-1 control-label">Вопрос</label>
				<div class="col-sm-10">
					<input class="form-control" name="review" >
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Оформить</button>
					<a href="/contact/cancel" type="submit" class="btn btn-primary">Cancel</a>
				</div>
			</div>
		</form>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		$('#summernote').summernote({
			lang : 'ru-RU'
		});
	});
</script>