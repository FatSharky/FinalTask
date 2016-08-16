<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.locale}" />
<c:if test="${sessionScope.locale==null}">
	<fmt:setLocale value="EN" />
</c:if>
<fmt:setBundle basename="resource.locale" var="locale" />
<fmt:message bundle="${locale}"
	key="locale.applicant.office.privateOffice" var="privateOffice" />
<fmt:message bundle="${locale}" key="locale.applicant.office.edit"
	var="edit" />
<fmt:message bundle="${locale}" key="locale.applicant.office.email"
	var="email" />
<fmt:message bundle="${locale}" key="locale.applicant.office.mobPhone"
	var="mobPhone" />
<fmt:message bundle="${locale}" key="locale.applicant.office.skype"
	var="skype" />
<fmt:message bundle="${locale}" key="locale.applicant.office.birthDate"
	var="birthDate" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ru">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${privateOffice}</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/styleForProfile.css" rel="stylesheet">
<link href="css/footerStyleForProfile.css" rel="stylesheet">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<%@include file="/WEB-INF/jspf/navigation.jspf"%>


	<div class="container">
		<%@include file="/WEB-INF/jspf/privateOfficeApplicantHeader.jspf"%>
		<form action="Controller" method="get">
			<input type="hidden" name="command" value="to-applicant-edit-profile">
			<div class="left-menu clearfix">
				<input type="submit" class="btn btn-success btn-lg" value="${edit}">
			</div>
		</form>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">${sessionScope.user.surname}
					${sessionScope.user.name} ${sessionScope.user.secondName}</h3>
			</div>
			<div class="panel-body">
				<form class="form-horizontal">
					<div class="form-group">
						<img src="../images/photo.jpg" alt="..."
							class="img-circle col-xs-4">
					</div>
					<div class="form-group">
						<p class="text-left col-xs-2">
							<b>${email}</b>
						</p>
						<p class="text-left col-xs-6">${sessionScope.user.email}</p>
					</div>
					<div class="form-group">
						<p class="text-left col-xs-2">
							<b>${mobPhone}</b>
						</p>
						<p class="text-left col-xs-6">${sessionScope.user.contactPhone}</p>
					</div>
					<div class="form-group">
						<p class="text-left col-xs-2">
							<b>${skype}</b>
						</p>
						<p class="text-left col-xs-6">${sessionScope.user.skype}</p>
					</div>
					<div class="form-group">
						<p class="text-left col-xs-2">
							<b>${birthDate}</b>
						</p>
						<p class="text-left col-xs-6">${sessionScope.user.birthDate}</p>
					</div>
				</form>
			</div>
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