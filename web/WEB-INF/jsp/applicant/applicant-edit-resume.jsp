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
<fmt:message bundle="${locale}" key="locale.resume.language"
	var="language" />


<fmt:message bundle="${locale}"
	key="locale.resume.language.languageName" var="languageName" />
<fmt:message bundle="${locale}"
	key="locale.resume.language.enterLanguageName" var="enterLanguageName" />
<fmt:message bundle="${locale}"
	key="locale.resume.language.wrongLanguageName" var="wrongLanguageName" />
<fmt:message bundle="${locale}"
	key="locale.resume.language.languageLevel" var="languageLevel" />
<fmt:message bundle="${locale}" key="locale.resume.language.elementary"
	var="elementary" />
<fmt:message bundle="${locale}"
	key="locale.resume.language.lowPreIntermediate"
	var="lowPreIntermediate" />
<fmt:message bundle="${locale}"
	key="locale.resume.language.preIntermediate" var="preIntermediate" />
<fmt:message bundle="${locale}"
	key="locale.resume.language.lowIntermediate" var="lowIntermediate" />
<fmt:message bundle="${locale}"
	key="locale.resume.language.intermediate" var="intermediate" />
<fmt:message bundle="${locale}"
	key="locale.resume.language.lowUppermediate" var="lowUppermediate" />
<fmt:message bundle="${locale}"
	key="locale.resume.language.upperMediate" var="upperMediate" />
<fmt:message bundle="${locale}" key="locale.resume.language.preAdvanced"
	var="preAdvanced" />
<fmt:message bundle="${locale}" key="locale.resume.language.advanced"
	var="advanced" />
<fmt:message bundle="${locale}"
	key="locale.resume.language.preProficient" var="preProficient" />
<fmt:message bundle="${locale}" key="locale.resume.language.proficient"
	var="proficient" />
<fmt:message bundle="${locale}"
	key="locale.resume.language.nativeSpeaker" var="nativeSpeaker" />


<fmt:message bundle="${locale}" key="locale.resume.skill" var="skill" />
<fmt:message bundle="${locale}" key="locale.resume.skill.skillName"
	var="skillName" />
<fmt:message bundle="${locale}" key="locale.resume.skill.enterSkillName"
	var="enterSkillName" />
<fmt:message bundle="${locale}" key="locale.resume.skill.wrongSkilName"
	var="wrongSkillName" />
<fmt:message bundle="${locale}" key="locale.resume.skill.skillLevel"
	var="skillLevel" />
<fmt:message bundle="${locale}" key="locale.resume.skill.noviceSkill"
	var="noviceSkill" />
<fmt:message bundle="${locale}"
	key="locale.resume.skill.intermediateSkill" var="intermediateSkill" />
<fmt:message bundle="${locale}" key="locale.resume.skill.advancedSkill"
	var="advancedSkill" />
<fmt:message bundle="${locale}" key="locale.resume.skill.expertSkill"
	var="expertSkill" />


<fmt:message bundle="${locale}" key="locale.resume.workplace"
	var="workplace" />
<fmt:message bundle="${locale}"
	key="locale.resume.workplace.workPlaceName" var="workPlaceName" />
<fmt:message bundle="${locale}"
	key="locale.resume.workplace.enterWorkPlaceName"
	var="enterWorkPlaceName" />
<fmt:message bundle="${locale}"
	key="locale.resume.workplace.wrongWorkPlaceName"
	var="wrongWorkPlaceName" />

<fmt:message bundle="${locale}"
	key="locale.resume.workplace.workPlacePosition" var="workPlacePosition" />
<fmt:message bundle="${locale}"
	key="locale.resume.workplace.enterWorkPlacePosition"
	var="enterWorkPlacePosition" />
<fmt:message bundle="${locale}"
	key="locale.resume.workplace.wrongWorkPlacePosition"
	var="wronWorkPlacePosition" />

<fmt:message bundle="${locale}" key="locale.resume.workplace.dateBegin"
	var="dateBegin" />
<fmt:message bundle="${locale}"
	key="locale.resume.workplace.enterDateBegin" var="enterDateBegin" />
<fmt:message bundle="${locale}"
	key="locale.resume.workplace.wrongDateBegin" var="wrongDateBegin" />

<fmt:message bundle="${locale}" key="locale.resume.workplace.dateEnd"
	var="dateEnd" />
<fmt:message bundle="${locale}"
	key="locale.resume.workplace.enterDateEnd" var="enterDateEnd" />
<fmt:message bundle="${locale}"
	key="locale.resume.workplace.wrongDateEnd" var="wrondDateEnd" />

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
			<div>
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


					<c:forEach items="${requestScope.educationList}" var="education">

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

					</c:forEach>
				</div>
			</div>
			<div class="panel-group col-xs-8 clearfix">
				<div class="panel panel-primary clearfix">
					<div class="panel-heading clearfix">
						<h3 class="panel-title pull-left">${language}</h3>
						<a class="btn btn-default  pull-right" data-toggle="collapse"
							href="#collapseSecond">${addField}</a>

					</div>
					<div id="collapseSecond" class="collapse">

						<div class="panel-body">
							<form class="form-horizontal" action="Controller" method="post">
								<input type="hidden" name="command" value="add-resume-language">
								<input type="hidden" value="${requestScope.resume.idResume}"
									name="idResume">

								<div class="form-group">
									<label class="control-label col-xs-2" for="languageName">${languageName}*:</label>
									<div class="col-xs-6">
										<input type="text" class="form-control" name="languageName"
											placeholder="${enterLanguageName}" required>
									</div>
									<c:if test="${requestScope.errorLanguageName}">
										<div class="col-xs-2">
											<p class="text-danger">${wrongLanguageName}</p>
										</div>
									</c:if>
								</div>
								<div class="form-group">
									<label class="control-label col-xs-2" for="languageLevel">${languageLevel}</label>
									<div class="col-xs-6">
										<select class="form-control" name="languageLevel">
											<option value="not specified">${notSpecified}</option>
											<option value="A1">${elementary}</option>
											<option value="A1 plus">${lowPreIntermediate}</option>
											<option value="A2">${preIntermediate}</option>
											<option value="A2 plus">${lowIntermediate}</option>
											<option value="B1">${intermediate}</option>
											<option value="B1 plus">${lowUppermediate}</option>
											<option value="B2">${upperMediate}</option>
											<option value="B2 plus">${preAdvanced}</option>
											<option value="C1">${advanced}</option>
											<option value="C1 plus">${preProficient}</option>
											<option value="C2">${proficient}</option>
											<option value="Native speaker">${nativeSpeaker}</option>
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


				<c:forEach items="${requestScope.resumeLangList}" var="resumeLang">

					<div class="panel panel-default clearfix">
						<div class="panel-heading clearfix">
							<h3 class="panel-title pull-left">${resumeLang.name}:
								${resumeLang.raiting}</h3>
							<a class="btn btn-danger  pull-right"
								href="Controller?command=delete-resume-language&idLanguage=${resumeLang.idLanguage}">${remove}</a>
							<a class="btn btn-default  pull-right" data-toggle="collapse"
								href="#${resumeLang.idLanguage}">${edit}</a>
						</div>
						<div id="${resumeLang.idLanguage}" class="collapse">
							<form class="form-horizontal" action="Controller" method="post">
								<input type="hidden" name="command" value="edit-resume-language">
								<input type="hidden" value="${resumeLang.idLanguage}"
									name="idLanguage">
								<div class="panel-body">
									<div class="form-group">
										<label class="control-label col-xs-2" for="languageName">${languageName}*:</label>
										<div class="col-xs-6">
											<input type="text" class="form-control" name="languageName"
												value="${resumeLang.name}">
										</div>
										<c:if test="${requestScope.errorLanguageName}">
											<div class="col-xs-2">
												<p class="text-danger">${wrongLanguageName}</p>
											</div>
										</c:if>
									</div>
									<div class="form-group">
										<label class="control-label col-xs-2" for="languageLevel">${languageLevel}</label>
										<div class="col-xs-6">
											<select class="form-control" name="languageLevel">
												<option value="not specified">${notSpecified}</option>
												<option value="A1">${elementary}</option>
												<option value="A1 plus">${lowPreIntermediate}</option>
												<option value="A2">${preIntermediate}</option>
												<option value="A2 plus">${lowIntermediate}</option>
												<option value="B1">${intermediate}</option>
												<option value="B1 plus">${lowUppermediate}</option>
												<option value="B2">${upperMediate}</option>
												<option value="B2 plus">${preAdvanced}</option>
												<option value="C1">${advanced}</option>
												<option value="C1 plus">${preProficient}</option>
												<option value="C2">${proficient}</option>
												<option value="Native speaker">${nativeSpeaker}</option>
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

				</c:forEach>

			</div>
			<div class="panel-group col-xs-8 clearfix">
				<div class="panel panel-primary clearfix">
					<div class="panel-heading clearfix">
						<h3 class="panel-title pull-left">${skill}</h3>
						<a class="btn btn-default  pull-right" data-toggle="collapse"
							href="#collapseThird">${addField}</a>

					</div>
					<div id="collapseThird" class="collapse">

						<div class="panel-body">
							<form class="form-horizontal" action="Controller" method="post">
								<input type="hidden" name="command" value="add-skill"> <input
									type="hidden" value="${requestScope.resume.idResume}"
									name="idResume">

								<div class="form-group">
									<label class="control-label col-xs-2" for="skillName">${skillName}*:</label>
									<div class="col-xs-6">
										<input type="text" class="form-control" name="skillName"
											placeholder="${enterSkillName}" required>
									</div>
									<c:if test="${requestScope.errorSkillName}">
										<div class="col-xs-2">
											<p class="text-danger">${wrongSkillName}</p>
										</div>
									</c:if>
								</div>
								<div class="form-group">
									<label class="control-label col-xs-2" for="skillLevel">${skillLevel}</label>
									<div class="col-xs-6">
										<select class="form-control" name="skillLevel">
											<option value="novice">${noviceSkill}</option>
											<option value="intermediate">${intermediateSkill}</option>
											<option value="advanced">${advancedSkill}</option>
											<option value="expert">${expertSkill}</option>
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


				<c:forEach items="${requestScope.skillList}" var="skill">

					<div class="panel panel-default clearfix">
						<div class="panel-heading clearfix">
							<h3 class="panel-title pull-left">${skill.name}:
								${skill.raiting}</h3>
							<a class="btn btn-danger  pull-right"
								href="Controller?command=delete-skill&idSkill=${skill.idSkill}">${remove}</a>
							<a class="btn btn-default  pull-right" data-toggle="collapse"
								href="#${skill.idSkill}">${edit}</a>
						</div>
						<div id="${skill.idSkill}" class="collapse">
							<form class="form-horizontal" action="Controller" method="post">
								<input type="hidden" name="command" value="edit-skill">
								<input type="hidden" value="${skill.idSkill}" name="idSkill">
								<div class="panel-body">

									<div class="form-group">
										<label class="control-label col-xs-2" for="skillName">${skillName}*:</label>
										<div class="col-xs-6">
											<input type="text" class="form-control" name="skillName"
												value="${skill.name}">
										</div>
										<c:if test="${requestScope.errorSkillName}">
											<div class="col-xs-2">
												<p class="text-danger">${wrongSkillName}</p>
											</div>
										</c:if>
									</div>
									<div class="form-group">
										<label class="control-label col-xs-2" for="skillLevel">${skillLevel}</label>
										<div class="col-xs-6">
											<select class="form-control" name="skillLevel">
												<option value="novice">${noviceSkill}</option>
												<option value="intermediate">${intermediateSkill}</option>
												<option value="advanced">${advancedSkill}</option>
												<option value="expert">${expertSkill}</option>
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

				</c:forEach>


			</div>

			<div class="panel-group col-xs-8 clearfix">
				<div class="panel panel-primary clearfix">
					<div class="panel-heading clearfix">
						<h3 class="panel-title pull-left">${workplace}</h3>
						<a class="btn btn-default  pull-right" data-toggle="collapse"
							href="#collapseFourth">${addField}</a>

					</div>
					<div id="collapseFourth" class="collapse">

						<div class="panel-body">
							<form class="form-horizontal" action="Controller" method="post">
								<input type="hidden" name="command" value="add-workplace">
								<input type="hidden" value="${requestScope.resume.idResume}"
									name="idResume">

								<div class="form-group">
									<label class="control-label col-xs-2" for="workPlaceName">${workPlaceName}*:</label>
									<div class="col-xs-6">
										<input type="text" class="form-control" name="workPlaceName"
											placeholder="${enterWorkPlaceName}" required>
									</div>
									<c:if test="${requestScope.errorWorkPlaceName}">
										<div class="col-xs-2">
											<p class="text-danger">${wrongWorkPlaceName}</p>
										</div>
									</c:if>
								</div>

								<div class="form-group">
									<label class="control-label col-xs-2" for="workPlacePosition">${workPlacePosition}*:</label>
									<div class="col-xs-6">
										<input type="text" class="form-control"
											name="workPlacePosition"
											placeholder="${enterWorkPlacePosition}" required>
									</div>
									<c:if test="${requestScope.errorWorkPlacePosition}">
										<div class="col-xs-2">
											<p class="text-danger">${wrongWorkPlacePosition}</p>
										</div>
									</c:if>
								</div>

								<div class="form-group">
									<label class="control-label col-xs-2" for="dateBegin">${dateBegin}*:</label>
									<div class="col-xs-6">
										<input type="text" class="form-control" name="dateBegin"
											placeholder="${enterDateBegin}" required>
									</div>
									<c:if test="${requestScope.errorDateBegin}">
										<div class="col-xs-2">
											<p class="text-danger">${wrongDateBegin}</p>
										</div>
									</c:if>
								</div>

								<div class="form-group">
									<label class="control-label col-xs-2" for="dateEnd">${dateEnd}*:</label>
									<div class="col-xs-6">
										<input type="text" class="form-control" name="dateEnd"
											placeholder="${enterDateEnd}" required>
									</div>
									<c:if test="${requestScope.errorDateEnd}">
										<div class="col-xs-2">
											<p class="text-danger">${wrongDateEnd}</p>
										</div>
									</c:if>
								</div>


								<div class="left-menu clearfix">
									<input type="submit" class="btn btn-success btn-lg"
										value="${addResume}">
								</div>
							</form>
						</div>
					</div>
				</div>


				<c:forEach items="${requestScope.workPlaceList}" var="workPlace">

					<div class="panel panel-default clearfix">
						<div class="panel-heading clearfix">
							<h3 class="panel-title pull-left">${workPlace.companyName}:
								${workPlace.position}</h3>
							<a class="btn btn-danger  pull-right"
								href="Controller?command=delete-workPlace&idWorkPlace=${workPlace.idWorkPlace}">${remove}</a>
							<a class="btn btn-default  pull-right" data-toggle="collapse"
								href="#${workPlace.idWorkPlace}">${edit}</a>
						</div>
						<div id="${workPlace.idWorkPlace}" class="collapse">
							<form class="form-horizontal" action="Controller" method="post">
								<input type="hidden" name="command" value="edit-workPlace">
								<input type="hidden" value="${workPlace.idWorkPlace}"
									name="idWorkPlace">
								<div class="panel-body">


									<div class="form-group">
										<label class="control-label col-xs-2" for="workPlaceName">${workPlaceName}*:</label>
										<div class="col-xs-6">
											<input type="text" class="form-control" name="workPlaceName"
												value="${workPlace.companyName}">
										</div>
										<c:if test="${requestScope.errorWorkPlaceName}">
											<div class="col-xs-2">
												<p class="text-danger">${wrongWorkPlaceName}</p>
											</div>
										</c:if>
									</div>

									<div class="form-group">
										<label class="control-label col-xs-2" for="workPlacePosition">${workPlacePosition}*:</label>
										<div class="col-xs-6">
											<input type="text" class="form-control"
												name="workPlacePosition" value="${workPlace.position} ">
										</div>
										<c:if test="${requestScope.errorWorkPlacePosition}">
											<div class="col-xs-2">
												<p class="text-danger">${wrongWorkPlacePosition}</p>
											</div>
										</c:if>
									</div>

									<div class="form-group">
										<label class="control-label col-xs-2" for="dateBegin">${dateBegin}*:</label>
										<div class="col-xs-6">
											<input type="text" class="form-control" name="dateBegin"
												value="${workPlace.dateBegin}">
										</div>
										<c:if test="${requestScope.errorDateBegin}">
											<div class="col-xs-2">
												<p class="text-danger">${wrongDateBegin}</p>
											</div>
										</c:if>
									</div>

									<div class="form-group">
										<label class="control-label col-xs-2" for="dateEnd">${dateEnd}*:</label>
										<div class="col-xs-6">
											<input type="text" class="form-control" name="dateEnd"
												value="${workPlace.dateEnd}">
										</div>
										<c:if test="${requestScope.errorDateEnd}">
											<div class="col-xs-2">
												<p class="text-danger">${wrongDateEnd}</p>
											</div>
										</c:if>
									</div>


									<div class="left-menu clearfix">
										<input type="submit" class="btn btn-success btn-lg"
											value="${edit}">
									</div>
								</div>
							</form>
						</div>
					</div>

				</c:forEach>
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