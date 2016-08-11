<%@ page errorPage="error-page.jsp" language="java"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.locale}" />
<fmt:setBundle basename="resource.locale" var="locale" />
<fmt:message bundle="${locale}" key="locale.registrationPage.pageName"
	var="pageName" />
<fmt:message bundle="${locale}" key="locale.siteName" var="siteName" />
<fmt:message bundle="${locale}" key="locale.forAplicant"
	var="forApplicant" />
<fmt:message bundle="${locale}" key="locale.sendResume" var="sendResume" />


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ru">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${pageName}</title>
<!-- Bootstrap -->
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/style.css" rel="stylesheet">
<link href="../css/footerStyle.css" rel="stylesheet">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->




</head>
<body>
	<nav class="navbar navbar-fixed-top navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#responsive-menu">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">${siteName}</a>
		</div>
		<div class="collapse navbar-collapse" id="responsive-menu">
			<ul class="nav navbar-nav visible-lg visible-md">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">${forApplicant}<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#">${sendResume}</a></li>
						<li><a href="#">Как улучшить резюме</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Работодателям<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#">Разместить вакансию</a></li>
						<li><a href="#">Услуги</a></li>
					</ul></li>
				<li><a href="#">О нас</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li>
					<button class="btn btn-success" data-toggle="modal"
						data-target="#signInModal">
						<span class="glyphicon glyphicon-log-in"></span> Войти
					</button>
				</li>
				<li><a href="#">EN</a></li>
				<li><a href="#">RU</a></li>
			</ul>
			<form class="navbar-form navbar-right" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">Поиск</button>
			</form>
		</div>
	</div>
	</nav>

	<div class="modal fade" id="signInModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h3 class="modal-title" id="myModalLabel">IFoundJob</h3>
				</div>
				<div class="modal-body clearfix">
					<form class="form-signin">
						<h2 class="form-signin-heading">Please sign in</h2>
						<input type="email" class="form-control"
							placeholder="Email address" required="" autofocus=""> <input
							type="password" class="form-control" placeholder="Password"
							required="">
						<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
							in</button>
					</form>
				</div>
				<div class="applicant">
					<h4>Соискателям</h4>
					<p>Зарегистрировавшись, соискатели могут размещать резюме, а
						также оставлять отклики на заинтересовавшие их вакансии.</p>
					<button class="btn btn-success " type="submit">Регистрация
						соискателя</button>
				</div>
				<div class="employer clearfix">
					<h4>Работодателям</h4>
					<p>Зарегистрировавшись, работодатели могут размещать свои
						вакансии.</p>
					<button class="btn btn-warning" type="submit">Регистрация
						работодателя</button>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
				</div>
			</div>
		</div>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="/js/bootstrap.min.js"></script>
</body>
</html>