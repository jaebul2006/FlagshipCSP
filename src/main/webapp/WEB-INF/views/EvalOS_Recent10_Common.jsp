<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>수술 경과 상세</title>
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	  <link rel="stylesheet" href="./KVRF/chartist-js-master/dist/chartist.min.css">
	  <script src="./KVRF/chartist-js-master/dist/chartist.min.js"></script>
</head>
<body>
	<div id="container" style="position:absolute; width:100%; height:100%;">
		<div class="ct-chart ct-golden-section" id="chart1" style="width:30%; height:30%;"></div>
	</div>

	<script>
		var oper_count_list = new Array();
		var count = 1;
		<c:forEach items="${score_list}" var="oper_count">
			oper_count_list.push(count);
			count++;
		</c:forEach>
		
		var score_list = new Array();
		<c:forEach items="${score_list}" var="score">
			score_list.push("${score}");
		</c:forEach>
		
		new Chartist.Line('#chart1', {
		    labels: oper_count_list,
		    series: [score_list]
		  });
	</script>

</body>
</html>