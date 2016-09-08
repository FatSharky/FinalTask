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
<fmt:message bundle="${locale}" key="locale.hr.office.header.vacancy"
	var="vacancy" />
<fmt:message bundle="${locale}"
	key="locale.hr.office.header.vacancyVerify" var="vacancyVerify" />
<fmt:message bundle="${locale}" key="locale.hr.office.header.interview"
	var="interview" />
<fmt:message bundle="${locale}" key="locale.vacancy.add" var="add" />
<fmt:message bundle="${locale}" key="locale.open" var="open" />
<fmt:message bundle="${locale}" key="locale.edit" var="edit" />
<fmt:message bundle="${locale}" key="locale.remove" var="remove" />
<fmt:message bundle="${locale}" key="locale.edit" var="edit" />
<fmt:message bundle="${locale}" key="locale.active" var="active" />
<fmt:message bundle="${locale}" key="locale.deactive" var="deactive" />
<fmt:message bundle="${locale}" key="locale.hot" var="hot" />
<fmt:message bundle="${locale}"
	key="locale.applicant.office.header.profile" var="profile" />


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ru">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${privateOffice}</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
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
		<br> <br> <br> <br> <br>
		<div class="container">
			<div class="container">
				<div class="top-nav clearfix">
					<ul class="nav nav-tabs nav-justified">
						<li><a href="Controller?command=to-private-office">${profile}</a></li>
						<li><a href="Controller?command=to-hr-list-vacancy">${vacancy}</a></li>
						<li class="active"><a
							href="Controller?command=to-verify-list">${vacancyVerify}</a></li>
						<li><a href="#">${interview}</a></li>
					</ul>
				</div>
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">${listVacancy}</h3>
					</div>
					<div class="panel-body">
						<div class="panel-body">
							<div class="thumbnail">
								<div class="caption">
									<h3>Vacancy: ${requestScope.verify.vacancy.name}</h3>
									<h3>Applicant:
										${requestScope.verify.resume.applicant.surname}
										${requestScope.verify.resume.applicant.name}
										${requestScope.verify.resume.applicant.secondName}</h3>
									<p>
										<strong>Skype:</strong>
										${requestScope.verify.resume.applicant.skype}
									</p>
									<p>
										<strong>ContactPhone:</strong>
										${requestScope.verify.resume.applicant.contactPhone}
									</p>
									<div class="panel panel-primary">
										<div class="panel-heading">
											<h4 class="panel-title">
												<a data-toggle="collapse" href="#collapse1">Add
													Interview </a>
											</h4>
										</div>
										<div id="collapse1" class="panel-collapse collapse">
											<div class="panel-body">
												<form class="form-horizontal" action="Controller"
													method="post">
													<input type="hidden" name="command"
														value="add-interview-to-applicant"> <input
														type="hidden" value="${requestScope.verify.idVerify}"
														name="idVerify">
													<div class="form-group">
														<label class="control-label col-xs-2 col-md-1"
															for="interviewType">interviewType</label>
														<div class="col-xs-6">
															<select class="form-control" name="interviewType">
																<option value="preliminary">preliminary</option>
																<option value="techical">techical</option>
															</select>
														</div>
													</div>
													<div class="form-group">
														<label class="control-label col-xs-2 col-md-1"
															for="interviewDate">interviewDate</label>
														<div class="col-xs-6">
															<input type="text" class="form-control"
																name="interviewDate" placeholder="interviewDate"
																required>
															<c:choose>
																<c:when test="${requestScope.errorDate}">
																	<div class="help-block">
																		<p class="text-danger">${wrongBirthDate}</p>
																	</div>
																</c:when>
																<c:otherwise>
																	<div class="help-block">
																		<p>interviewDate</p>
																	</div>
																</c:otherwise>
															</c:choose>
														</div>
													</div>
													<input type="submit" class="btn btn-primary"
														value="${registration}">
												</form>
											</div>
										</div>
									</div>
									<table class="table table-hover">
										<thead>
											<tr>
												<th>Interview type</th>
												<th>Date</th>
												<th>Add mark</th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${requestScope.interviewList}"
												var="interview">
												<tr>
													<td>${interview.interviewType}</td>
													<td>${interview.dateBegin}</td>
													<td><button class="btn btn-success"
															data-toggle="modal"
															data-target="#${interview.idInterview}">Add Mark</button></td>
												</tr>
												<div class="modal fade" id="${interview.idInterview}"
													tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
													aria-hidden="true">
													<div class="modal-dialog">
														<div class="modal-content">
															<div class="modal-header">
																<button type="button" class="close" data-dismiss="modal"
																	aria-hidden="true">&times;</button>
																<h3 class="modal-title" id="myModalLabel">Add Mark</h3>
															</div>
															<div class="modal-body clearfix">
																<form class="form-horizontal" action="Controller"
																	method="post">
																	<input type="hidden" name="command" value="add-mark">
																	<input type="hidden" value="${interview.idInterview}"
																		name="idInterview">

																	<div class="form-group">
																		<label class="control-label col-xs-2" for="skill">skill*:</label>
																		<div class="col-xs-6">
																			<input type="text" class="form-control" name="skill"
																				placeholder="skill" required>
																		</div>
																		<c:if test="${requestScope.errorSkillName}">
																			<div class="col-xs-2">
																				<p class="text-danger">${wrongSkillName}</p>
																			</div>
																		</c:if>
																	</div>
																	<div class="form-group">
																		<label class="control-label col-xs-2" for="mark">mark</label>
																		<div class="col-xs-6">
																			<select class="form-control" name="mark">
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
												</div>
											</c:forEach>
										</tbody>
									</table>
									<h3>MARKS:</h3>
									<h2>Techical</h2>
									<c:forEach items="${requestScope.listMarkTechnical}"
										var="technical">
										<p>${technical.skill}-${technical.mark}</p>
									</c:forEach>
									<h2>Preliminari</h2>
									<c:forEach items="${requestScope.listMarkPreliminary}"
										var="preliminary">
										<p>${preliminary.skill}-${preliminary.mark}</p>
									</c:forEach>
								</div>
							</div>
						</div>

					</div>
					<pt:paging-links page="${requestScope.page}"
						pageAmount="${requestScope.pageAmount}"
						href="Controller?command=to-verify-list" />
				</div>
			</div>
		</div>
	</div>


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>