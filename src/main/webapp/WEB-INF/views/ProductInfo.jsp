<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Flagship CSP</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="./static/site/css/styles.css" />

<script type="text/javascript" src="./static/site/js/jquery/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>

</head>

<body>	
<!--  <div id="header"> -->
	<div id="top-header">
		<div id="company-logo">
			<h1><img src="./static/site/images/logo-1.png" alt="BIZZ GROUP" id="logo" style="position:relative; right:65%;"/></h1>
		</div>
		<ul id="main-navigation">
			<li><a href="/CSP">홈</a></li>
			<li class="active"><a href="/CSP/ProductInfo">제품소개</a></li>
			<li><a href="/CSP/ResultEvaluationHome">수술 평가 갤러리</a></li>
			<li><a href="/CSP/DashBoard1?id=${pageContext.request.remoteUser}">코칭 대시보드</a></li>
			<li><a href="#">커뮤니티</a></li>
			<li><a href="/CSP/LicenseBuy">라이센스구매</a></li>
		</ul>
		<div id="userInfo" style="position:relative; width:50%; left:70%; top:52%;">
			<c:choose>
				<c:when test="${session_login != null}">
					<p> 안녕하세요. <b><c:out value="${pageContext.request.remoteUser}" /></b></p>
				</c:when>
			</c:choose>
		</div>
		
		<div class="clear"></div>
	</div>
<!--  </div> -->
	
<div id="content">
	<div class="wide-wrapper">
		<div class="content-container">
			<div class="content-container middle-side"  style="width:1000px;">
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Website designed by <a href="http://www.solideng.co.kr/" target="_blank" rel="nofollow">http://www.solideng.co.kr</a><br/>
</div>

	

</body>
</html>