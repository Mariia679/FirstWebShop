<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="/resources/img/4nlncmfGrMY.png"
	type="image/png">
<link rel="stylesheet" href="/resources/css/common.css">
<script type="text/javascript" src="/resources/js/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<script src="/resources/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/resources/css/chosen.min.css">
<script src="/resources/js/chosen.jquery.min.js"></script>
<link rel="stylesheet" href="/resources/dist/ui/trumbowyg.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular.min.js"></script>

<link rel="stylesheet" href="/resources/dist/summernote.css">
<script src="/resources/dist/summernote.min.js"></script>
<script src="/resources/lang/summernote-ru-RU.js"></script>
<script src="/resources/Gruntfile.js"></script>

<script>
	$(function() {
		$("select").chosen();
	});
</script>

<style type="text/css">
.cart-commodity-name {
	width: 100%;
	height: 50%;
}

.none-purchase-down {
	margin-top: 100px;
}

.margin-padding {
	margin: 15px 25px 20px 25px;
}

.color-login:HOVER {
	color: firebrick;
}

.marg-padding {
	margin: 0px 25px;
}

.image-none-purchase {
	margin-left: 100px;
}

.purchases {
	font-size: 30px;
	color: green;
}

#upperheader {
	margin-top: 10px;
}

.space {
	margin: 0px 70px;
}

.weight-font-size {
	font-size: 15px;
}

.column .text-uppercase {
	margin: 0px 30px;
}

.row {
	margin-right: 0;
	padding-left: 0;
}

.container-fluid {
	padding-right: 0px;
}

.all-products {
	display: flex;
	margin: 15px 0px 15px 0px;;
}

.full-modal-cart {
	margin: 10px 0px;
	height: 400px;
	overflow: auto;
}

.color-cart {
	display: flex;
	justify-content: flex-end;
	margin: 10px;
}

.btn-modal-cart {
	display: flex;
	justify-content: flex-end;
	margin: 10px;
}

.btn-modal-cart a {
	font-size: 25px;
}

.text .color-cart {
	color: #949494;
}

.modal-cart {
	display: flex;
	justify-content: space-between;
	margin: 25px;
}

.modal-cart>* {
	align-self: center;
}

.display-flex {
	display: flex;
	justify-content: space-between;
	margin: auto;
	padding-right: 5%;
}

.form-inline .form-control {
	width: 100%;
}

.row {
	margin-right: 0;
	padding-left: 0;
}

.parent {
	display: flex;
	flex-flow: row wrap;
	justify-content: flex-start;
	margin-top: 20px;
}

.parent>* {
	box-sizing: border-box;
	padding: 10px;
}

.icon {
	background: url(/resources/img/look.com.ua-1241.jpg) repeat-x;
	height: 250px;
	margin-bottom: 15px;
}

.footer {
	margin-top: 50px;
	background: url(/resources/img/look.com.ua-1241.jpg) repeat-x;
	background-size: 100%;
	color: white;
}

.main-body {
	margin-bottom: 317px;
}

.column {
	padding: 70px 0px;
}

.bascket {
	margin-top: 30px;
}

@media ( max-width :768px) {
	.body-down {
		font-size: 24px;
	}
	.icon {
		font-size: 24px;
		width: 100%;
		height: 100%;
		margin-bottom: 0;
	}
}

@media ( min-width : 992px) and (max-width:1200px) {
	.bord {
		padding: 10px 30px;
	}
	.text-bot {
		padding-left: 50px;
	}
	.pager {
		width: 100%;
	}
}

@media ( min-width : 1000px) {
	.navbar .navbar-nav {
		display: inline-block;
		float: none;
		vertical-align: top;
	}
	.navbar .navbar-collapse {
		text-align: center;
	}
	.body-down {
		margin: 0px 100px;
	}
}

@media ( max-width :1000px) {
	.image-none-purchase {
		margin-left: 0px;
	}
	.purchases {
		font-size: 20px;
	}
	.space {
		margin: 0px 10px 0px 0px;
	}
	.body-down {
		font-size: 20px;
		margin: 0px 25px 0px 10px;
	}
	.icon {
		font-size: 20px;
		width: 100%;
		height: 100%;
		margin-bottom: 0;
	}
	.nav>li {
		float: none;
		position: relative;
		display: block;
	}
	.navbar-collapse.collapse {
		display: none !important;
	}
	.navbar-collapse {
		overflow-x: visible !important;
	}
	/*  .navbar-collapse.in {
		overflow-y: auto !important;
	}  */
	.collapse.in {
		display: block !important;
	}
	.navbar-toggle {
		display: block;
	}
}
</style>
<title><tiles:getAsString name="title" /></title>
</head>
<body>
	<tiles:insertAttribute name="header" />
	<div class="container-fluid main-body">
		<tiles:insertAttribute name="body" />
	</div>
	<tiles:insertAttribute name="footer" />
</body>
</html>