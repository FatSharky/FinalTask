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
<fmt:message bundle="${locale}" key="locale.resume.add" var="add" />
<fmt:message bundle="${locale}" key="locale.resume.resumeName"
	var="resumeName" />
<fmt:message bundle="${locale}" key="locale.resume.enterResumeName"
	var="enterResumeName" />
<fmt:message bundle="${locale}" key="locale.resume.wrongResumeName"
	var="wrongResumeName" />
<fmt:message bundle="${locale}" key="locale.resume.military"
	var="military" />
<fmt:message bundle="${locale}"
	key="locale.resume.military.notSpecified" var="notSpecified" />
<fmt:message bundle="${locale}" key="locale.resume.military.fit"
	var="fit" />
<fmt:message bundle="${locale}" key="locale.resume.military.notFit"
	var="notFit" />
<fmt:message bundle="${locale}"
	key="locale.resume.military.militaryDepartment"
	var="militaryDepartment" />
<fmt:message bundle="${locale}" key="locale.resume.military.notBound"
	var="notBound" />
<fmt:message bundle="${locale}" key="locale.resume.addResume"
	var="addResume" />
<fmt:message bundle="${locale}" key="locale.resume.education"
	var="education" />
<fmt:message bundle="${locale}" key="locale.resume.addField"
	var="addField" />
<fmt:message bundle="${locale}"
	key="locale.resume.education.institution" var="institution" />
<fmt:message bundle="${locale}"
	key="locale.resume.education.enterInstitution" var="enterInstitution" />
<fmt:message bundle="${locale}"
	key="locale.resume.education.wrongInstitution" var="wrongIstitution" />
<fmt:message bundle="${locale}" key="locale.resume.education.faculty"
	var="faculty" />
<fmt:message bundle="${locale}"
	key="locale.resume.education.enterFaculty" var="enterFaculty" />
<fmt:message bundle="${locale}"
	key="locale.resume.education.wrongFaculty" var="wrongFaculty" />
<fmt:message bundle="${locale}" key="locale.resume.education.department"
	var="department" />
<fmt:message bundle="${locale}"
	key="locale.resume.education.enterDepartment" var="enterDepartment" />
<fmt:message bundle="${locale}"
	key="locale.resume.education.wrongDepartment" var="wrongDepartment" />
<fmt:message bundle="${locale}" key="locale.resume.education.educField"
	var="educField" />
<fmt:message bundle="${locale}"
	key="locale.resume.education.notSpecified" var="notSpecified" />
<fmt:message bundle="${locale}" key="locale.resume.education.incomplete"
	var="incomplete" />
<fmt:message bundle="${locale}" key="locale.resume.education.higher"
	var="higher" />
<fmt:message bundle="${locale}" key="locale.resume.education.master"
	var="master" />
<fmt:message bundle="${locale}" key="locale.resume.education.phD"
	var="phD" />
<fmt:message bundle="${locale}" key="locale.resume.education.secondary"
	var="secondary" />
<fmt:message bundle="${locale}" key="locale.resume.education.techSchool"
	var="techSchool" />
<fmt:message bundle="${locale}"
	key="locale.resume.education.phDCandidate" var="phDCandidate" />
<fmt:message bundle="${locale}" key="locale.resume.education.gradYear"
	var="gradYear" />
<fmt:message bundle="${locale}"
	key="locale.resume.education.enterGradYear" var="enterGradYear" />
<fmt:message bundle="${locale}"
	key="locale.resume.education.wrongGradYear" var="wrongGradYear" />
<fmt:message bundle="${locale}" key="locale.resume.education.postGrad"
	var="postGrad" />
<fmt:message bundle="${locale}"
	key="locale.resume.education.notAssigned" var="notAssigned" />
<fmt:message bundle="${locale}" key="locale.resume.education.assigned"
	var="assigned" />
<fmt:message bundle="${locale}"
	key="locale.resume.education.toBeAssigned" var="toBeAssigned" />
<fmt:message bundle="${locale}" key="locale.remove" var="remove" />
<fmt:message bundle="${locale}" key="locale.edit" var="edit" />

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
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="container">
		<div class="top-nav clearfix">
			<ul class="nav nav-tabs nav-justified">
				<li><a href="Controller?command=to-private-office">${profile}</a></li>
				<li class="active"><a
					href="Controller?command=to-applicant-list-resume">${resume}</a></li>
			</ul>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" action="Controller" method="post">
				<input type="hidden" name="command" value="edit-resume"> <input
					type="hidden" value="${requestScope.resume.idResume}"
					name="idResume">
				<div class="left-menu clearfix">
					<input type="submit" class="btn btn-success btn-lg"
						value="${addResume}">
				</div>
				<div class="form-group clearfix">
					<label class="control-label col-xs-2 col-md-1" for="resumeName">${resumeName}</label>
					<div class="col-xs-6">
						<input type="text" class="form-control" name="resumeName"
							value="${requestScope.resume.name}">
					</div>
					<c:if test="${requestScope.errorResumeName}">
						<div class="col-xs-2">
							<p class="text-danger">${wrongResumeName}</p>
						</div>
					</c:if>
				</div>
				<div class="form-group">
					<label class="control-label col-xs-2 col-md-1" for="military">${military}</label>
					<div class="col-xs-6">
						<select class="form-control" name="military">
							<option value="not specified">${notSpecified}</option>
							<option value="fit">${fit}</option>
							<option value="not fit">${notFit}</option>
							<option value="military department">${militaryDepartment}</option>
							<option value="not bound">${notBound}</option>
						</select>
					</div>
				</div>

			</form>

			<div class="panel-group col-xs-8 clearfix">
				<div class="panel panel-primary clearfix">
					<div class="panel-heading clearfix">
						<h3 class="panel-title pull-left">${education}</h3>
						<a class="btn btn-default  pull-right" data-toggle="collapse"
							href="#collapseOne">${addField}</a>

					</div>
					<div id="collapseOne" class="collapse">

						<div class="panel-body">
							<form class="form-horizontal" action="Controller" method="post">
								<input type="hidden" name="command" value="add-education">
								<input type="hidden" value="${requestScope.resume.idResume}"
									name="idResume">

								<div class="form-group">
									<label class="control-label col-xs-2" for="institution">${institution}*:</label>
									<div class="col-xs-6">
										<input type="text" class="form-control" name="institution"
											placeholder="${enterInstitution}" required>
									</div>
									<c:if test="${requestScope.errorInstitution}">
										<div class="col-xs-2">
											<p class="text-danger">${wrongInstitution}</p>
										</div>
									</c:if>
								</div>

								<div class="form-group">
									<label class="control-label col-xs-2" for="faculty">${faculty}*:</label>
									<div class="col-xs-6">
										<input type="text" class="form-control" name="faculty"
											placeholder="${enterFaculty}" required>
									</div>
									<c:if test="${requestScope.errorFaculty}">
										<div class="col-xs-2">
											<p class="text-danger">${wrongFaculty}</p>
										</div>
									</c:if>
								</div>

								<div class="form-group">
									<label class="control-label col-xs-2" for="department">${department}*:</label>
									<div class="col-xs-6">
										<input type="text" class="form-control" name="department"
											placeholder="${enterDepartment}" required>
									</div>
									<c:if test="${requestScope.errorDepartment}">
										<div class="col-xs-2">
											<p class="text-danger">${wrongDepartment}</p>
										</div>
									</c:if>
								</div>
								<div class="form-group">
									<label class="control-label col-xs-2" for="educField">${educField}</label>
									<div class="col-xs-6">
										<select class="form-control" name="educField">
											<option value="not specified">${notSpecified}</option>
											<option value="university incomplete">${incomplete}</option>
											<option value="higher">${higher}</option>
											<option value="master">${master}</option>
											<option value="PhD">${phD}</option>
											<option value="secondary">${secondary}</option>
											<option value="technical school">${techSchool}</option>
											<option value="PhD candidate">${phDCandidate}</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-xs-2" for="gradYear">${gradYear}*:</label>
									<div class="col-xs-6">
										<input type="text" class="form-control" name="gradYear"
											placeholder="${enterGradYear}" required>
									</div>
									<c:if test="${requestScope.errorGandYear}">
										<div class="col-xs-2">
											<p class="text-danger">${wrongGradYear}</p>
										</div>
									</c:if>
								</div>
								<div class="form-group">
									<label class="control-label col-xs-2" for="postGrad">${postGrad}*:</label>
									<div class="col-xs-6">
										<select class="form-control" name="postGrad">
											<option value="not assigned">${notAssigned}</option>
											<option value="assigned">${assigned}</option>
											<option value="to be assigned">${toBeAssigned}</option>
										</select>
									</div>
								</div>
								<div class="left-menu clearfix">
									<input type="submit" class="btn btn-success btn-lg"
										value="${addResume}">
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<c:forEach items="${requestScope.educationList}" var="education">
				<div class="panel-group col-xs-8 clearfix">
					<div class="panel panel-default clearfix">
						<div class="panel-heading clearfix">
							<h3 class="panel-title pull-left">${education.institution},${education.faculty},${education.department}</h3>
							<a class="btn btn-danger  pull-right"
								href="Controller?command=delete-education&idEducation=${education.idEducation}">${remove}</a>
							<a class="btn btn-default  pull-right" data-toggle="collapse"
								href="#${education.idEducation}">${edit}</a>
						</div>
						<div id="${education.idEducation }" class="collapse">
							<form class="form-horizontal" action="Controller" method="post">
								<input type="hidden" name="command" value="edit-education">
								<input type="hidden" value="${education.idEducation}"
									name="idEducation">
								<div class="panel-body">
									<div class="form-group">
										<label class="control-label col-xs-2" for="institution">${institution}*:</label>
										<div class="col-xs-6">
											<input type="text" class="form-control" name="institution"
												value="${education.institution}">
										</div>
										<c:if test="${requestScope.errorInstitution}">
											<div class="col-xs-2">
												<p class="text-danger">${wrongInstitution}</p>
											</div>
										</c:if>
									</div>

									<div class="form-group">
										<label class="control-label col-xs-2" for="faculty">${faculty}*:</label>
										<div class="col-xs-6">
											<input type="text" class="form-control" name="faculty"
												value="${education.faculty}">
										</div>
										<c:if test="${requestScope.errorFaculty}">
											<div class="col-xs-2">
												<p class="text-danger">${wrongFaculty}</p>
											</div>
										</c:if>
									</div>

									<div class="form-group">
										<label class="control-label col-xs-2" for="department">${department}*:</label>
										<div class="col-xs-6">
											<input type="text" class="form-control" name="department"
												value="${education.department}">
										</div>
										<c:if test="${requestScope.errorDepartment}">
											<div class="col-xs-2">
												<p class="text-danger">${wrongDepartment}</p>
											</div>
										</c:if>
									</div>
									<div class="form-group">
										<label class="control-label col-xs-2" for="educField">${educField}</label>
										<div class="col-xs-6">
											<select class="form-control" name="educField">
												<option value="not specified">${notSpecified}</option>
												<option value="university incomplete">${incomplete}</option>
												<option value="higher">${higher}</option>
												<option value="master">${master}</option>
												<option value="PhD">${phD}</option>
												<option value="secondary">${secondary}</option>
												<option value="technical school">${techSchool}</option>
												<option value="PhD candidate">${phDCandidate}</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-xs-2" for="gradYear">${gradYear}*:</label>
										<div class="col-xs-6">
											<input type="text" class="form-control" name="gradYear"
												value="${education.gradYear}">
										</div>
										<c:if test="${requestScope.errorGandYear}">
											<div class="col-xs-2">
												<p class="text-danger">${wrongGradYear}</p>
											</div>
										</c:if>
									</div>
									<div class="form-group">
										<label class="control-label col-xs-2" for="postGrad">${postGrad}*:</label>
										<div class="col-xs-6">
											<select class="form-control" name="postGrad">
												<option value="not assigned">${notAssigned}</option>
												<option value="assigned">${assigned}</option>
												<option value="to be assigned">${toBeAssigned}</option>
											</select>
										</div>
									</div>
									<div class="left-menu clearfix">
										<input type="submit" class="btn btn-success btn-lg"
											value="${edit}">
									</div>
								</div>
							</form>

						</div>
					</div>
				</div>
			</c:forEach>

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