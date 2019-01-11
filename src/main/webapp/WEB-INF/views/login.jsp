<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--  
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="../CSP/assets/login/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="../CSP/assets/login/css/login-form.css">
	<link rel="stylesheet" href="../CSP/assets/login/css/login-form1.css">
	<link rel="stylesheet" href="../CSP/assets/login/css/styles.css">

	<title>로그인 페이지</title>

</head>
<body>

	<button onclick="window.location.href='/CSP/RegistUser'">유저등록</button>

	<div class="container full-height">
		<div class="row flex center v-center full-height">
			<div class="col-8 col-sm-4">
				<div class="form-box">
					<form name="form1" method="post" action="login_process">
						<fieldset>
							<legend>CSP 인증</legend>
							<img src="../CSP/assets/login/img/avatar.png" id="avatar" class="avatar round">
							<input class="form-control" type="text" id="id" name="id" placeholder="id"></input>
							<input class="form-control" type="password" id="pw" name="pw" placeholder="password"></input>
							<input type="submit" class="btn btn-primary btn-block" value="로그인">
							<input type='hidden' name="${_csrf.parameterName}" value="${_csrf.token}" ></input>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script src="../CSP/assets/login/js/jquery.min.js"></script>
	<script src="../CSP/assets/login/bootstrap/js/bootstrap.min.js"></script>
	
</body>
</html> 
-->

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>시뮬레이터시스템 로그인</title>

    <!-- Bootstrap core CSS -->
    <link href="./KVRF/final/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./KVRF/final/css/signin.css" rel="stylesheet">
  </head>

  <body class="text-center">
  
    <form name="form1" class="form-signin" method="post" action="login_process">
        <div class="form-container">
          <img class="mb-4" src="./KVRF/final/images/login-logo.png" alt="로고">
          <label for="inputEmail" class="sr-only">Username</label>
          <input type="text" id="id" class="form-control" name="id" placeholder="ID" required autofocus>
          <label for="inputPassword" class="sr-only">Password</label>
          <input type="password" id="pw" class="form-control" name="pw" placeholder="Password" required>
          <button class="btn btn-lg btn-primary p-btn btn-block" type="submit">Login</button>
          <input type='hidden' name="${_csrf.parameterName}" value="${_csrf.token}" ></input>
            <div class="form-bottom">
                <a href="/CSP/RegistUser" class="btn btn-outline-secondary-s btn-sm">유저등록</a>
            </div>
        </div>
        <p class="login-copyright col-sm-12">&copy; Solideng all rights reserved.</p>
    </form>
      
  </body>