<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<fmt:setLocale value="EN" />
<c:if test="${sessionScope.locale!=null}">
	<fmt:setLocale value="${sessionScope.locale}" />
</c:if>
<fmt:setBundle basename="resource.locale" var="locale" />
<fmt:message bundle="${locale}" key="locale.fillIn" var="fillIn" />
<fmt:message bundle="${locale}" key="locale.reg.regPage" var="regPage" />
<fmt:message bundle="${locale}" key="locale.mainPage" var="mainPage" />
<fmt:message bundle="${locale}" key="locale.reg.registration"
	var="registration" />
<fmt:message bundle="${locale}" key="locale.reg.pattern" var="pattern" />
<fmt:message bundle="${locale}" key="locale.reg.email" var="regEmail" />
<fmt:message bundle="${locale}" key="locale.reg.enterEmail"
	var="enterEmail" />
<fmt:message bundle="${locale}" key="locale.reg.wrongEmail"
	var="wrongEmail" />
<fmt:message bundle="${locale}" key="locale.reg.userAlreadyExist"
	var="userAlreadyExist" />
<fmt:message bundle="${locale}" key="locale.reg.emailPattern"
	var="emailPattern" />
<fmt:message bundle="${locale}" key="locale.reg.password"
	var="regPassword" />
<fmt:message bundle="${locale}" key="locale.reg.enterPassword"
	var="enterPassword" />
<fmt:message bundle="${locale}" key="locale.reg.wrongPassword"
	var="wrongPassword" />
<fmt:message bundle="${locale}" key="locale.reg.copypassword"
	var="copypassword" />
<fmt:message bundle="${locale}" key="locale.reg.enterCopypassword"
	var="enterCopypassword" />
<fmt:message bundle="${locale}" key="locale.reg.passwordNotEquals"
	var="passwordNotEquals" />
<fmt:message bundle="${locale}" key="locale.reg.passwordPattern"
	var="passwordPattern" />
<fmt:message bundle="${locale}" key="locale.reg.surname" var="surname" />
<fmt:message bundle="${locale}" key="locale.reg.enterSurname"
	var="enterSurname" />
<fmt:message bundle="${locale}" key="locale.reg.wrongSurname"
	var="wrongSurname" />
<fmt:message bundle="${locale}" key="locale.reg.surnamePattern"
	var="surnamePattern" />
<fmt:message bundle="${locale}" key="locale.reg.name" var="name" />
<fmt:message bundle="${locale}" key="locale.reg.enterName"
	var="enterName" />
<fmt:message bundle="${locale}" key="locale.reg.wrongName"
	var="wrongName" />
<fmt:message bundle="${locale}" key="locale.reg.namePattern"
	var="namePattern" />
<fmt:message bundle="${locale}" key="locale.reg.secondname"
	var="secondname" />
<fmt:message bundle="${locale}" key="locale.reg.enterSecondname"
	var="enterSecondname" />
<fmt:message bundle="${locale}" key="locale.reg.wrongSecondname"
	var="wrongSecondname" />
<fmt:message bundle="${locale}" key="locale.reg.secondnamePattern"
	var="secondnamePattern" />
<fmt:message bundle="${locale}" key="locale.reg.skype" var="skype" />
<fmt:message bundle="${locale}" key="locale.reg.enterSkype"
	var="enterSkype" />
<fmt:message bundle="${locale}" key="locale.reg.wrongSkype"
	var="wrongSkype" />
<fmt:message bundle="${locale}" key="locale.reg.skypePattern"
	var="skypePattern" />
<fmt:message bundle="${locale}" key="locale.reg.birthDate"
	var="birthDate" />
<fmt:message bundle="${locale}" key="locale.reg.enterBirthDate"
	var="enterBirthDate" />
<fmt:message bundle="${locale}" key="locale.reg.wrongBirthDate"
	var="wrongBirthDate" />
<fmt:message bundle="${locale}" key="locale.reg.birthDatePattern"
	var="birthDatePattern" />
<fmt:message bundle="${locale}" key="locale.reg.phone" var="phone" />
<fmt:message bundle="${locale}" key="locale.reg.enterPhone"
	var="enterPhone" />
<fmt:message bundle="${locale}" key="locale.reg.wrongPhone"
	var="wrongPhone" />
<fmt:message bundle="${locale}" key="locale.reg.phonePattern"
	var="phonePattern" />
<fmt:message bundle="${locale}" key="locale.reg.role" var="role" />
<fmt:message bundle="${locale}" key="locale.reg.roleApplicant"
	var="roleApplicant" />
<fmt:message bundle="${locale}" key="locale.reg.roleHr" var="roleHr" />
<fmt:message bundle="${locale}" key="locale.reg.regSuccess" var="regSuccess" />
<fmt:message bundle="${locale}" key="locale.reg.clearForm"
	var="clearForm" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ru">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${regPage}</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/footerStyle.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
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
	<div class="container">
		<ol class="breadcrumb">
			<li><a href="Controller?command=to-index-page">${mainPage}</a></li>
			<li class="active"><a
				href="Controller?command=to-registration-page">${regPage}</a></li>
		</ol>

		<h2>${registration}</h2>
		<em>${fillIn}</em>
		<h3>${pattern}</h3>
		<br>
		<form class="form-horizontal" action="Controller" method="post">
			<input type="hidden" name="command" value="user-registrarion">
			<c:if test="${requestScope.regSuccess}">
				<p class="bg-success col-xs-6">${regSuccess }</p>
			</c:if>
			<div class="form-group">
				<label class="control-label col-xs-2 col-md-1" for="email">${regEmail}</label>
				<div class="col-xs-6 controls">
					<input type="text" class="form-control" name="email"
						placeholder="${enterEmail}" value="${requestScope.email}" required>
					<c:choose>
						<c:when test="${requestScope.errorEmail}">
							<div class="help-block">
								<p class="text-danger">${wrongEmail}</p>
							</div>
						</c:when>
						<c:when test="${requestScope.errorAlreadyExist}">
							<div class="help-block">
								<p class="text-danger">${userAlreadyExist}</p>
							</div>
						</c:when>
						<c:otherwise>
							<div class="help-block">
								<p>${emailPattern}</p>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-xs-2 col-md-1" for="password">${regPassword}</label>
				<div class="col-xs-6">
					<input type="password" class="form-control" name="password"
						placeholder="${enterPassword}" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-xs-2 col-md-1" for="copypassword"></label>
				<div class="col-xs-6">
					<input type="password" class="form-control" name="copypassword"
						placeholder="${enterCopypassword}" required>
					<c:choose>
						<c:when test="${requestScope.errorPassword}">
							<div class="help-block">
								<p class="text-danger">${wrongPassword}</p>
							</div>
						</c:when>
						<c:when test="${requestScope.errorPasswordNotEquals}">
							<div class="help-block">
								<p class="text-danger">${passwordNotEquals}</p>
							</div>
						</c:when>
						<c:otherwise>
							<div class="help-block">
								<p>${passwordPattern}</p>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-xs-2 col-md-1" for="surname">${surname}</label>
				<div class="col-xs-6">
					<input type="text" class="form-control" name="surname"
						placeholder="${enterSurname}" value="${requestScope.surname}"
						required>
					<c:choose>
						<c:when test="${requestScope.errorSurname}">
							<div class="help-block">
								<p class="text-danger">${wrongSurname}</p>
							</div>
						</c:when>
						<c:otherwise>
							<div class="help-block">
								<p>${surnamePattern}</p>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-xs-2 col-md-1" for="name">${name}</label>
				<div class="col-xs-6">
					<input type="text" class="form-control" name="name"
						placeholder="${enterName}" value="${requestScope.name}" required>
					<c:choose>
						<c:when test="${requestScope.errorName}">
							<div class="help-block">
								<p class="text-danger">${wrongName}</p>
							</div>
						</c:when>
						<c:otherwise>
							<div class="help-block">
								<p>${namePattern}</p>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-xs-2 col-md-1" for="secondname">${secondname}</label>
				<div class="col-xs-6">
					<input type="text" class="form-control" name="secondname"
						placeholder="${enterSecondname}"
						value="${requestScope.secondname}" required>
					<c:choose>
						<c:when test="${requestScope.errorSecondname}">
							<div class="help-block">
								<p class="text-danger">${wrongSecondname}</p>
							</div>
						</c:when>
						<c:otherwise>
							<div class="help-block">
								<p>${secondnamePattern}</p>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-xs-2 col-md-1" for="skype">${skype}</label>
				<div class="col-xs-6">
					<input type="text" class="form-control" name="skype"
						placeholder="${enterSkype}" value="${requestScope.skype}" required>
					<c:choose>
						<c:when test="${requestScope.errorSkype}">
							<div class="help-block">
								<p class="text-danger">${wrongSkype}</p>
							</div>
						</c:when>
						<c:otherwise>
							<div class="help-block">
								<p>${skypePattern}</p>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-xs-2 col-md-1" for="phone">${phone}</label>
				<div class="col-xs-6">
					<input type="text" class="form-control" name="phone"
						placeholder="${enterPhone}" value="${requestScope.phone}" required>
					<c:choose>
						<c:when test="${requestScope.errorPhone}">
							<div class="help-block">
								<p class="text-danger">${wrongPhone}</p>
							</div>
						</c:when>
						<c:otherwise>
							<div class="help-block">
								<p>${phonePattern}</p>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-xs-2 col-md-1" for="birthDate">${birthDate}</label>
				<div class="col-xs-6">
					<input type="text" class="form-control" name="birthDate"
						placeholder="${enterBirthDate}" value="${requestScope.birthDate}"
						required>
					<c:choose>
						<c:when test="${requestScope.errorDate}">
							<div class="help-block">
								<p class="text-danger">${wrongBirthDate}</p>
							</div>
						</c:when>
						<c:otherwise>
							<div class="help-block">
								<p>${birthDatePattern}</p>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<div class="form-group" id="accordion">
				<label class="control-label col-xs-2 col-md-1" for="role">${role}</label>
				<div class="col-xs-6">
					<select class="form-control" name="role">
						<option value="applicant">${roleApplicant}</option>
						<option value="hr">${roleHr}</option>
					</select>
				</div>
			</div>
			<br>
			<div class="col-xs-offset-1 col-xs-9">
				<input type="submit" class="btn btn-primary" value="${registration}">
				<input type="reset" class="btn btn-default" value="${clearForm}">
			</div>
			<br>
		</form>
	</div>

	<%@include file="/WEB-INF/jspf/footer.jspf"%>
	<br>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
	<script src="js/validator.js"></script>

	<script src="js/jquery-3.1.0.min.js"></script>
</body>
</html>