<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:if test="${sessionScope.locale==null}">
	<c:set var="locale" value="EN" scope="session" />
</c:if>
<c:if test="${sessionScope.locale!=null}">
	<fmt:setLocale value="${sessionScope.locale}" />
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ru">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>IFoundJob</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/footerStyle.css" rel="stylesheet">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<%@include file="/WEB-INF/jspf/navigation.jspf"%>
	<%@include file="/WEB-INF/jspf/header.jspf"%>
	
	<div class="col-xs-2 col-sm-2 visible-lg visible-md" id="sidebar"
		role="navigation">
		<div class="list-group">
			<a href="#" class="list-group-item active">
				<h4 class="list-group-item-heading">Горячие вакансии</h4>
			</a> <a href="#" class="list-group-item">
				<h4 class="list-group-item-heading">Заместистель начальника
					Главного управления</h4>
				<p class="list-group-item-text">2020 руб.</p>
				<p class="list-group-item-text">Пожалуй лучшая работа на свете</p>
			</a> <a href="#" class="list-group-item">
				<h4 class="list-group-item-heading">Заместистель начальника
					Главного управления</h4>
				<p class="list-group-item-text">2020 руб.</p>
				<p class="list-group-item-text">Пожалуй лучшая работа на свете</p>
			</a> <a href="#" class="list-group-item">
				<h4 class="list-group-item-heading">Заместистель начальника
					Главного управления</h4>
				<p class="list-group-item-text">2020 руб.</p>
				<p class="list-group-item-text">Пожалуй лучшая работа на свете</p>
			</a> <a href="#" class="list-group-item">
				<h4 class="list-group-item-heading">Заместистель начальника
					Главного управления</h4>
				<p class="list-group-item-text">2020 руб.</p>
				<p class="list-group-item-text">Пожалуй лучшая работа на свете</p>
			</a> <a href="#" class="list-group-item">
				<h4 class="list-group-item-heading">Заместистель начальника
					Главного управления</h4>
				<p class="list-group-item-text">2020 руб.</p>
				<p class="list-group-item-text">Пожалуй лучшая работа на свете</p>
			</a> <a href="#" class="list-group-item">
				<h4 class="list-group-item-heading">Заместистель начальника
					Главного управления</h4>
				<p class="list-group-item-text">2020 руб.</p>
				<p class="list-group-item-text">Пожалуй лучшая работа на свете</p>
			</a>
		</div>
	</div>
	<div class="container">
		<ol class="breadcrumb">
			<li class="active"><a href="#">Главная</a></li>
		</ol>
		<div class="search-panel">
			<div class="input-group">
				<input type="text" class="form-control">
				<div class="input-group-btn">
					<button type="button" class="btn btn-default dropdown-toggle"
						data-toggle="dropdown">
						Поиск вакансий <span class="caret"></span>
					</button>
					<ul class="dropdown-menu pull-right">
						<li><a href="#">Поиск резюме</a></li>
						<li><a href="#">Поиск компаний</a></li>
					</ul>
				</div>
			</div>
			<a href="#">Расширеный поиск</a>
		</div>
		<h1>Вакансии ведущих компаний</h1>
		<div class="row">
			<div class="col-xs-6 col-md-3">
				<a href="#" class="thumbnail"> <img src="images/logo.png"
					alt="...">
				</a>
			</div>
			<div class="col-xs-6 col-md-3">
				<a href="#" class="thumbnail"> <img src="images/logo.png"
					alt="...">
				</a>
			</div>
			<div class="col-xs-6 col-md-3">
				<a href="#" class="thumbnail"> <img src="images/logo.png"
					alt="...">
				</a>
			</div>
			<div class="col-xs-6 col-md-3">
				<a href="#" class="thumbnail"> <img src="images/logo.png"
					alt="...">
				</a>
			</div>
			<div class="col-xs-6 col-md-3">
				<a href="#" class="thumbnail"> <img src="images/logo.png"
					alt="...">
				</a>
			</div>
			<div class="col-xs-6 col-md-3">
				<a href="#" class="thumbnail"> <img src="images/logo.png"
					alt="...">
				</a>
			</div>
		</div>
	</div>
	<nav class="text-center">
	<ul class="pagination">
		<li class="disabled"><a href="#">&laquo;</a></li>
		<li class="active"><a href="#">1</a></li>
		<li><a href="#">2</a></li>
		<li><a href="#">3</a></li>
		<li><a href="#">4</a></li>
		<li><a href="#">5</a></li>
		<li><a href="#">&raquo;</a></li>
	</ul>
	</nav>
	<%@include file="/WEB-INF/jspf/footer.jspf"%>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>