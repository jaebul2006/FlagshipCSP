<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   	<meta name="description" content="">
   	<meta name="author" content="">
   	<link rel="icon" href="./KVRF/final/images/favicon.ico">

	<title>유저등록하기</title>

    <!-- Bootstrap core CSS -->
    <link href="./KVRF/final/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./KVRF/final/css/signin.css" rel="stylesheet">
      
    <style>
        .form-sign-in {margin: 0 auto; max-width: 465px;}
    </style>

	<script>
		$(document).ready(function(){
			
			$("#BtnRegistAccount").click(function(){
				var input_id = $("#AdminID").val();
				var mac_address = $("#MacAddress").val();
				var pw = $("#PassWord").val();
				var user_type = "STUDENT";
				
				if(document.getElementById('type_teacher').checked){
					user_type = "TEACHER";
				}
				
				var param = {"adminid":input_id, "macaddress":mac_address, "password":pw, "user_type":user_type};
				
				$.ajax({
					
					type: "post",
					data: param,
					url: "/CSP/RegistAccount",
					
					success: function(data){
						console.log(data);
						if(data != ""){
							location.href = "${path}/CSP";	
						}
						else{
							alert("중복되는 id가 존재합니다");
						}
					}
					
				});
			});
			
		});
	</script>
</head>

<body>
	<!--  	
	<div class="container">
		<table class="table table-bordered">
			<tbody>
				
					<tr>
						<th>Admin ID: </th>
						<td><input type="text" style="width:100%;" id="AdminID" class="form-control"/></td>
					</tr>
					<tr>
						<th>Password: </th>
						<td><input type="password" style="width:100%;" id="PassWord" class="form-control"/></td>
					</tr>
					<tr>
						<th>Mac Address: </th>
						<td><input type="text" style="width:100%;" id="MacAddress" class="form-control"/></td>
					</tr>
					<tr>
						<th>유저 타입: </th>
						<td><input type="radio" name="user_type" id="type_student" value="student"/>실습자</td>
						<td><input type="radio" name="user_type" id="type_teacher" value="teacher"/>평가자</td>
					</tr>
					<tr>
		                <td colspan="2">
		                 	<button type="button" id="BtnRegistAccount">계정등록</button>
		                </td>
           			</tr>
				
			</tbody>
		</table>
	</div>    
	-->
	
	<form class="form-signin" class="needs-validation">
        <div class="form-container">
          <h4 class="mb-3">유저등록하기</h4>
            <hr class="mb-4">
            <div class="row">
              <div class="col-md-12 mb-3">
                <label for="AdminID">ID</label>
                <input type="text" class="form-control" id="AdminID" placeholder="ID" value="" required="">
                <div class="invalid-feedback">
                  Valid first name is required.
                </div>
              </div>
            </div>
            <div class="mb-3">
              <label for="pwd">Password</label>
              <input type="password" class="form-control" id="PassWord" placeholder="Password" required="">
            </div>
            <div class="row">
              <div class="col-md-12 mb-3">
                <label for="MacAddress">Mac Address</label>
                <input type="text" class="form-control" id="MacAddress" placeholder="00-00-00-00-00-00" value="" required="">
                <div class="invalid-feedback">
                  Valid first name is required.
                </div>
              </div>
            </div>
            <h5 class="mb-3">유저 타입</h5>
            <div class="d-block my-3">
              <div class="custom-control custom-radio d-inline mr-4">
                <input id="type_student" name="user_type" type="radio" class="custom-control-input" required="" value="student">
                <label class="custom-control-label" for="type_student">실습자</label>
              </div>
              <div class="custom-control custom-radio d-inline">
                <input id="type_teacher" name="user_type" type="radio" class="custom-control-input" required="" value=teacher">
                <label class="custom-control-label" for="type_teacher">평가자</label>
              </div>
            </div>
            <hr class="mb-4">
            <button class="btn btn-lg btn-primary p-btn btn-block" type="submit" id="BtnRegistAccount">등록하기</button>
            
        </div>
       <p class="login-copyright col-sm-12 text-center">© Solideng all rights reserved.</p>
    </form>
	
	
</body>
</html>