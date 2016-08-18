<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="EN" />
<c:if test="${sessionScope.locale!=null}">
	<fmt:setLocale value="${sessionScope.locale}" />
</c:if>
<fmt:setBundle basename="resource.locale" var="locale" />
<fmt:message bundle="${locale}"
	key="locale.applicant.office.header.profile" var="profile" />
<fmt:message bundle="${locale}"
	key="locale.applicant.office.header.resume" var="resume" />
<fmt:message bundle="${locale}" key="locale.update.applicant"
	var="update" />
<fmt:message bundle="${locale}" key="locale.update.save" var="save" />
<fmt:message bundle="${locale}" key="locale.update.cancel" var="cancel" />
<fmt:message bundle="${locale}" key="locale.reg.password" var="password" />
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
<fmt:message bundle="${locale}" key="locale.reg.surname" var="surname" />
<fmt:message bundle="${locale}" key="locale.reg.enterSurname"
	var="enterSurname" />
<fmt:message bundle="${locale}" key="locale.reg.wrongSurname"
	var="wrongSurname" />
<fmt:message bundle="${locale}" key="locale.reg.name" var="name" />
<fmt:message bundle="${locale}" key="locale.reg.enterName"
	var="enterName" />
<fmt:message bundle="${locale}" key="locale.reg.wrongName"
	var="wrongName" />
<fmt:message bundle="${locale}" key="locale.reg.secondname"
	var="secondname" />
<fmt:message bundle="${locale}" key="locale.reg.enterSecondname"
	var="enterSecondname" />
<fmt:message bundle="${locale}" key="locale.reg.wrongSecondname"
	var="wrongSecondname" />
<fmt:message bundle="${locale}" key="locale.reg.skype" var="skype" />
<fmt:message bundle="${locale}" key="locale.reg.enterSkype"
	var="enterSkype" />
<fmt:message bundle="${locale}" key="locale.reg.wrongSkype"
	var="wrongSkype" />
<fmt:message bundle="${locale}" key="locale.reg.birthDate"
	var="birthDate" />
<fmt:message bundle="${locale}" key="locale.reg.enterBirthDate"
	var="enterBirthDate" />
<fmt:message bundle="${locale}" key="locale.reg.wrongBirthDate"
	var="wrongBirthDate" />
<fmt:message bundle="${locale}" key="locale.reg.phone" var="phone" />
<fmt:message bundle="${locale}" key="locale.reg.enterPhone"
	var="enterPhone" />
<fmt:message bundle="${locale}" key="locale.reg.wrongPhone"
	var="wrongPhone" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ru">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${update}</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/styleForProfile.css" rel="stylesheet">
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
	<br><br><br><br><br>
	<div class="container">
		<div class="top-nav clearfix">
			<ul class="nav nav-tabs nav-justified">
				<li class="active"><a href="Controller?command=to-applicant-profile">${profile}</a></li>
				<li><a href="Controller?command=to-applicant-list-resume">${resume}</a></li>
			</ul>
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