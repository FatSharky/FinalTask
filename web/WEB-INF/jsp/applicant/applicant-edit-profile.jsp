<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ru">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Редактирование профиля</title>
<!-- Bootstrap -->
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/styleForProfile.css" rel="stylesheet">
<link href="../css/footerStyle.css" rel="stylesheet">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="container">
		<div class="left-menu clearfix">
			<button type="button" class="btn btn-success btn-lg">Сохранить</button>
			<button type="button" class="btn btn-danger btn-lg">Отменить</button>
		</div>

		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Редактирование</h3>
			</div>
			<div class="panel-body">
				<form class="form-horizontal">
					<div class="form-group">
						<img src="../images/photo.jpg" alt="..."
							class="img-circle col-xs-4">
						<div class="col-xs-6">
							<button type="button" class="btn btn-success">Добавить</button>
							<button type="button" class="btn btn-danger">Удалить</button>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-2 col-md-1" for="lastName">Фамилия:</label>
						<div class="col-xs-6">
							<input type="text" class="form-control" id="lastName"
								placeholder="Гапеенко" required autofocus>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-2 col-md-1" for="firstName">Имя:</label>
						<div class="col-xs-6">
							<input type="text" class="form-control" id="firstName"
								placeholder="Владислав" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-2 col-md-1" for="fatherName">Отчество:</label>
						<div class="col-xs-6">
							<input type="text" class="form-control" id="fatherName"
								placeholder="Витальевич" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-2 col-md-1" for="email">Email:</label>
						<div class="col-xs-6">
							<input type="text" class="form-control" id="email"
								placeholder="vladbypinsk@mail.ru" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-2 col-md-1" for="password">Пароль:</label>
						<div class="col-xs-6">
							<input type="text" class="form-control" id="password"
								placeholder="Введите новый пароль" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-2 col-md-1" for="confPassword">Подтвердите
							пароль:</label>
						<div class="col-xs-6">
							<input type="text" class="form-control" id="confPassword"
								placeholder="Поддтвердите пароль" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-2 col-md-1" for="phoneNumber">Телефон:</label>
						<div class="col-xs-6">
							<input type="tel" class="form-control" id="phoneNumber"
								placeholder="Введите номер телефона" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-2 col-md-1">Дата
							рождения:</label>
						<div class="col-xs-2">
							<select class="form-control">
								<option>Дата</option>
							</select>
						</div>
						<div class="col-xs-2">
							<select class="form-control">
								<option>Месяц</option>
							</select>
						</div>
						<div class="col-xs-2">
							<select class="form-control">
								<option>Год</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-2 col-md-1">Армия:</label>
						<div class="col-xs-6">
							<select class="form-control">
								<option>Годен</option>
								<option>Не годен</option>
							</select>
						</div>
					</div>
				</form>
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