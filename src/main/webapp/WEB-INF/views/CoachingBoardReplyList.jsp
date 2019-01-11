<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!doctype html>
<html lang="ko">
  <head>
      <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
      
    <title>코칭 커뮤니티</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet">
      
    <!--fontawesome--->
    <script src="https://use.fontawesome.com/6cf989a115.js"></script>

      
      <link type="text/css" rel="stylesheet" href="css/bcPicker.css"/>
		<script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
		<script type="text/javascript" src="js/bcPicker.js"></script>
  </head>

  <body>
  	<div class="board-view-comments-contents mb-4">
		<c:forEach var="row" items="${list}">
			<div class="bvc-content">
                <h6>${row.replyer}</h6>
                <ul>
                    <li><i class="fa fa-clock-o mr-1" aria-hidden="true"></i>${row.regdate}</li>
                    <li class="float-right">
                        <button type="button" class="btn-sm btn btn-outline-secondary btn-defalut-outline">삭제</button>
                    </li>
                </ul>
                <div class="bvc-txt">
                    <div class="row">
                        <div class="col-sm-7 bvc-txt-inner">
                            ${row.replytext}
                        </div>
                        <div class="col-sm-5">
                            <img src="${pageContext.request.contextPath}/assets${row.fileName}" alt="평가캡쳐 이미지" class="comment-img">
                        </div>
                    </div>
                </div>
            </div><!--bvc-content-end-->
		</c:forEach>
	</div>
  </body>
</html>




<!--  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css"> 
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
	<link rel="stylesheet" href="../assets/css/styles.min.css">
	<link rel="stylesheet" type="text/css" href="../static/site/css/styles.css" />
	<link rel="stylesheet" type="text/css" href="../assets/CoachingList/Style.css" />
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> 
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>
	
	<div class="container">
		<c:forEach var="row" items="${list}">
			<table class="table table-bordered">
				<tbody>
					<tr>
						<th>전문가 평가</th>
					</tr>
					<tr>
						<th>전문가 코치 메시지: </th>
						<td>${row.replytext}</td>
					</tr>
					<tr>
						<th>코치 id: </th>
						<td>${row.replyer}(<fmt:formatDate value="${row.regdate}" pattern="yyyy-MM-dd HH:mm:ss" />)</td>
					</tr>
					<tr>
						<th>수술장면 첨삭 스크린샷: </th>
						<td> 
							<img src="${pageContext.request.contextPath}/assets${row.fileName}"/>
						</td>
					</tr>
				</tbody>
			</table>
		</c:forEach>
	</div>
	
	
</body>
</html>
-->