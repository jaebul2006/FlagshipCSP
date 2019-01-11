<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ page session="true" %>
<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>콘텐츠 다운로드</title>
</head>
<body>

	<c:url var="downloadUrl" value="/download" />
	<form class="form-inline" action="${downloadUrl}" method="get">
      						<input type="submit" value="콘텐츠 다운로드" />
      						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    					</form>

</body>
</html>