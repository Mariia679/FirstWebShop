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

<link rel="stylesheet" type="text/css" href="/resources/css/slick.css">
<link rel="stylesheet" type="text/css"
	href="/resources/css/slick-theme.css">

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
.our-tel {
	margin: 20px;
	font-size: 24px;
}

.accessories {
	margin: auto;
	flex-wrap: wrap;
	display: flex;
	justify-content: space-between;
	/* align-content: space-between;  */
}

.align-product {
	padding-top: 10px;
}

.all-product {
	display: flex;
	flex-wrap: wrap;
}

.all-product .thumbnail {
	width: 23%;
	margin: 10px;
}

.accessories>* {
	width: 23%;
}

.btn {
	margin-left: 15px;
}

.block {
	margin: 30px;
	padding: 20px;
	font-size: 18px;
	border: 3px solid #949494;
	color: #949494;
}

.block:hover {
	text-decoration: none;
	color: firebrick;
}

.total-cost {
	font-size: 16px;
	font-weight: 800;
}

.margin-minus {
	margin-left: -220px;
}

.cart-commodity-name {
	margin: 10px;
}

.none-purchase-down {
	margin-top: 100px;
}

.marg {
	margin: 20px 0px;
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

.font {
	font-size: 25px;
}

.weight-font-size {
	font-size: 15px;
}

.column .text-uppercase {
	margin: 0px 30px;
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
	height: 500px;
	overflow: auto;
}

.jq-number {
	border: 1px solid #7b7a78;
	
	
}

.color-cart {
	display: flex;
	justify-content: flex-end;
	margin: 10px;
	color: firebrick;
}

.font-product {
	font-size: 17px;
	font-weight: 700;
	color: #211c18;
}

.color-sum {
	font-size: 20px;
	font-weight: 900;
	color: #1f801f;
}

.cart-bord {
	padding-bottom: 10px;
	border-bottom: 3px solid #d8ecf3;
	margin-bottom: 10px;
}

.trash {
	margin: 10px;
	color: firebrick;
}

.btn-modal-cart {
	display: flex;
	justify-content: flex-end;
	margin: 10px;
}

.cart-bord a {
	text-decoration: none;
	color: black;
}

.cart-bord a:hover {
	font-size: 15px;
	color: firebrick;
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

.cart-product {
	display: flex;
	justify-content: space-between;
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

.cart-background {
	background-color: #d8ecf3;
	font-style: italic;
	height: 100%;
}

.why-our-shop {
	margin: 20px;
	font-size: 18px;
}

.all-simple {
	font-size: 16px;
}

.column {
	padding: 70px 0px;
}

.bascket {
	margin-top: 30px;
}

@media ( max-width :768px) {
	.all-product .thumbnail {
		width: 50%;
	}
	.body-down {
		font-size: 20px;
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
	.all-product .thumbnail {
		width: 25%;
	}
	.product-hiden {
		margin-left: -120px;
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
	.product-hiden {
		margin-left: -160px;
	}
}

@media ( max-width :1000px) {
	.image-none-purchase {
		margin-left: 0px;
	}
	.all-product .thumbnail {
		width: 33%;
		flex-wrap: wrap;
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
	<div class="container-fluid ">
		<tiles:insertAttribute name="body" />
	</div>
	<tiles:insertAttribute name="footer" />
</body>
</html>