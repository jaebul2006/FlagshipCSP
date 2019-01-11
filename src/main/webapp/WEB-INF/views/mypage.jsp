<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  	<script src="./static/bootstrap/js/Chart.js"></script>
  	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script> 
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
	<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>  

	<title>마이 페이지</title>
</head>
<body>
	<script>
	var start_d;
	var end_d;
	var cur_content;
	
	$(function() {
	    start_d = $( "#start_day" ).datepicker({
	    	showOn: "both",
	    	buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif",
	    	buttonImageOnly: true,
	    	dateFormat:"yy-mm-dd",
	    });
	});
	
	$(function() {
		end_d = $( "#end_day" ).datepicker({
	    	showOn: "both",
	    	buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif",
	    	buttonImageOnly: true,
	    	dateFormat:"yy-mm-dd",
	    });
	});
	
	function GetScore(id, content_name)
	{
		content_name = "HipSurgery";
		
		if(content_name == undefined){
			// 선택된 컨텐츠가 없음.
			window.alert("선택된 컨텐츠가 없습니다.");
			return;
		}
		
		cur_content = content_name;
		
		var sd = start_d[0].value;
		var ed = end_d[0].value;
		
		var param = {"id":id, "content":content_name, "sd":sd, "ed":ed};
		console.log("param -> server: " + param.id + "," + param.content + "," + param.sd + "," + param.ed);
		
		$.ajax({
			url:'/CSP/userscore',
			type:'post',
			data: param,
			dataType:'json',
			success:function(data){
				console.log(data);
				var str_data = JSON.stringify(data);
				var label_arr = new Array();
				var score_arr = new Array();
				var bg_color_arr = new Array();
				var border_color_arr = new Array();
				
				var json_obj = JSON.parse(str_data);
				
				console.log(str_data);
				console.log(json_obj);
				
				for(var i=0; i<json_obj.length; i++){
					var counter = json_obj[i];
					label_arr[i] = counter.date;// + "{" + counter.time + "}";
					score_arr[i] = counter.score;
					bg_color_arr[i] = 'rgba(255,' + i * 10 + ',132, 0.3)';
					border_color_arr[i] = 'rgba(255,' + i * 10 + ',132, 1)';
				}
				
				var ctx = document.getElementById("myChart").getContext('2d');
				var myChart = new Chart(ctx, {
				    type: 'line',
				    data: {
				        labels: label_arr,
				        datasets: [{
				            label: '점수',
				            data: score_arr,
				            backgroundColor: bg_color_arr,
				            borderColor: border_color_arr, 
				            borderWidth: 1
				        }]
				    },
				    options: {
				        scales: {
				            yAxes: [{
				                ticks: {
				                    beginAtZero:true
				                }
				            }]
				        }
				    }
				});
			}
		});
	}
	</script> 

	<form name="homebtn" action="/CSP"><input type="submit" value="홈으로"></form>

	<div class="container">
		<h2>${user.USERNAME}  </h2>
			
		<div class="tab-content">
			<c:forEach items="${gcl}" var="gcl">
				<button onclick="GetScore('${user.ID}', '${gcl.CONTENT}')"> ${gcl.CONTENT} </button>
			</c:forEach>
			<br>
			<input type="text" id="start_day"> ~ <input type="text" id="end_day">
			<button onclick="GetScore('${user.ID}', cur_content)"> 조회 </button>
			<br><br>
		</div>
		<canvas id="myChart" width="400" height="250"></canvas>
	</div>
		

</body>
</html>