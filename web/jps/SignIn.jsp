<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form class="form-signin" action="controller" method="post">
			<h2 class="form-signin-heading">Please sign in</h2>
			<input type="hidden" name="command" value="login"> <input
				type="text" class="form-control" placeholder="Login" name="login">
			<input type="password" class="form-control" placeholder="Password"
				name="password"> <input type="submit"
				class="btn btn-lg btn-primary btn-block" value="Sign in">
		</form>
	</div>
</body>
</html>