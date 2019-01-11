<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>OS 수술 평가정보</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link rel="stylesheet" href="./KVRF/chartist-js-master/dist/chartist.min.css">
	<script src="./KVRF/chartist-js-master/dist/chartist.min.js"></script>
	<link rel="stylesheet" href="./static/MDBFree/css/bootstrap.min.css">
	<link rel="stylesheet" href="./static/MDBFree/css/style.min.css">
	<link rel="stylesheet" href="./static/MDBFree/css/mdb.min.css">
	<link rel="stylesheet" type="text/css" href="./static/site/css/styles.css" />
</head>
<body>	
	<div id="top-header" style="top:39px; left:600px;">
		<div id="company-logo">
			<h1><img src="./static/site/images/logo-1.png" alt="BIZZ GROUP" id="logo" style="position:relative; right:65%;"/></h1>
		</div>
		<ul id="main-navigation">
			<li><a href="/CSP">홈</a></li>
			<li><a href="/CSP/ProductInfo">제품소개</a></li>
			<li class="active"><a href="/CSP/ResultEvaluationHome">수술 평가 갤러리</a></li>
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

	<script src="./assets/googleblockly/blockly_compressed.js"></script>
	<script src="./assets/googleblockly/blocks_compressed.js"></script>
	<script src="./assets/googleblockly/msg/js/ko.js"></script>
	<div id="blockDiv" style="height:720px; width:1280px; margin-left:auto; margin-right:auto;"></div>
	<xml id="toolbox" style="display: none">
	  <block type="controls_if"></block>
	  <block type="controls_repeat_ext"></block>
	  <block type="logic_compare"></block>
	  <block type="math_number"></block>
	  <block type="math_arithmetic"></block>
	  <block type="text"></block>
	  <block type="text_print"></block>
	  
	  <block type="test1"></block>
	  <block type="test2"></block>
	</xml>
	<script>
		Blockly.Blocks['test1'] = {
			  init: function() {
			    this.appendValueInput('VALUE')
			        .setCheck('String')
			        .appendField('룰베이스테스트1');
			    this.setOutput(true, 'Number');
			    this.setColour(160);
			    this.setTooltip('Returns number of letters in the provided text.');
			    this.setHelpUrl('http://www.w3schools.com/jsref/jsref_length_string.asp');
			  }
			};
		
		Blockly.Blocks['test2'] = {
				  init: function() {
				    this.appendValueInput('VALUE')
				        .setCheck('String')
				        .appendField('룰베이스테스트2');
				    //this.setOutput(true, 'Number');
				    this.setColour(160);
				    this.setTooltip('Returns number of letters in the provided text.');
				    this.setHelpUrl('http://www.w3schools.com/jsref/jsref_length_string.asp');
				    
				    this.setPreviousStatement(true, 'Action');
				    //this.setNextStatement(true, 'Action');
				  }
				};
		
		var workspace = Blockly.inject('blockDiv', {toolbox: document.getElementById('toolbox')});
		
	</script>
	
</body>
</html>