<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container logo body-down">
	<h3 class="text-centre">Регистрация</h3>
	<form:form class="form-horizontal" action="/registration" method="POST"
		modelAttribute="form">
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Login</label>
			<div class="col-sm-7">
				<form:input class="form-control" path="username" id="name" required="required"/>
			</div>
			<label style="color: red; text-align: left;" for="name"
				class="col-sm-3"><form:errors path="username" /></label>
		</div>
		<div class="form-group">
			<label for="email" class="col-sm-2 control-label">Email</label>
			<div class="col-sm-7">
				<form:input class="form-control" path="email" id="email" required="required"/>
			</div>
			<label style="color: red; text-align: left;" for="email"
				class="col-sm-3"><form:errors path="email" /></label>
		</div>
		<div class="form-group">
			<label for="password" class="col-sm-2 control-label">Password</label>
			<div class="col-sm-7">
				<form:password class="form-control" path="password" id="password" required="required"/>
			</div>
			<label style="color: red; text-align: left;" for="password"
				class="col-sm-3"><form:errors path="password" /></label>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Register</button>
				<a href="/registration/cancel" type="submit" class="btn btn-primary">Cancel</a>
			</div>
		</div>
	</form:form>

</div>