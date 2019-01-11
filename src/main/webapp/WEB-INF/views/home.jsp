<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ page session="false" %>
<%@ page pageEncoding="utf-8" %>

<html>
<head>
	<title> 솔리드 이엔지 CSP</title>
	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h1>
	솔리드 이엔지 서비스 플랫폼
</h1>


<div id="main_btns">
	<form:form method = "GET" action = "/legacymvc/panorama">
		<input type = "submit" class="btn btn-info" value = "컨텐츠 목록 이동"/>
	</form:form>
	
	<form:form method = "GET" action = "/legacymvc/inputtest">
		<input type = "submit" class="btn btn-primary" value = "회원등록"/>
	</form:form>
	
	<form:form method = "GET" action = "/legacymvc/blacklist">
		<input type = "submit" class="btn btn-success" value = "회원목록"/>
	</form:form>
</div>

</body>
</html>
