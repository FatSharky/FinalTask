<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="/WEB-INF/tld/paging.tlg" prefix="pt"%>

<c:if test="${sessionScope.locale==null}">
	<c:set var="locale" value="EN" scope="session" />
</c:if>
<c:if test="${sessionScope.locale!=null}">
	<fmt:setLocale value="${sessionScope.locale}" />
</c:if>
<fmt:setBundle basename="resource.locale" var="locale" />
<fmt:message bundle="${locale}" key="locale.index.hotVacancies"
	var="hotVacancies" />
<fmt:message bundle="${locale}" key="locale.mainPage" var="mainPage" />
<fmt:message bundle="${locale}" key="locale.index.listOfVacancies"
	var="listOfVacancies" />
<fmt:message bundle="${locale}" key="locale.reg.email" var="email" />
<fmt:message bundle="${locale}" key="locale.reg.enterEmail"
	var="enterEmail" />

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
				<h4 class="list-group-item-heading">${hotVacancies}</h4>
			</a>
			<c:forEach var="hotVacancy" items="${requestScope.hotVacancies}">
				<a
					href="Controller?command=show-vacancy&vacancy-id=${hotVacancy.idVacancy}"
					class="list-group-item">
					<h4 class="list-group-item-heading">${hotVacancy.name}</h4>
					<p class="list-group-item-text">${hotVacancy.salary}руб.</p>
					<p class="list-group-item-text">${hotVacancy.description}</p>
				</a>

			</c:forEach>

		</div>
	</div>
	<div class="container">
		<ol class="breadcrumb">
			<li class="active"><a href="Controller?command=to-index-page">${mainPage}</a></li>
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
		<h1>${listOfVacancies}</h1>
		<div class="row text-center">
			<c:forEach var="vacancy" items="${requestScope.vacancies}">
				<div class="col-md-3 thumbnail thumbnail-poster center-block">
					<a
						href="Controller?command=show-vacancy&vacancy-id=${vacancy.idVacancy}">
						<h3>${vacancy.name}</h3>
					</a>

				</div>
			</c:forEach>
			<pt:paging-links page="${requestScope.page}"
				pageAmount="${requestScope.pageAmount}"
				href="Controller?command=to-index-page" />
		</div>
	</div>
	<%@include file="/WEB-INF/jspf/footer.jspf"%>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>