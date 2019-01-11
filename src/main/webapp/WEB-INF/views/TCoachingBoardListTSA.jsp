<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>

<head>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>플래그십 - 시뮬레이터 시스템</title>
    <link href="../KVRF/final/css/bootstrap.min.css" rel="stylesheet">
    <link href="../KVRF/final/css/style.css" rel="stylesheet">
</head>

<body>
	<header>
      <div class="top-header bg-blue shadow-sm">
        <div class="container text-right m-text-center">
            <a href="/CSP/ResultEvaluationHome" class="top-link fst">수술평가</a>
            <a href="/CSP/DashBoard1?id=${pageContext.request.remoteUser}" class="top-link sed">코칭 커뮤니티</a>
            <a href="#" class="top-link thd" onclick="LogoutCSP();">로그아웃</a>
        </div>
      </div>
    </header>
    
    <nav class="navbar navbar-expand-lg bg-white" id="navbar">
      <div class="container">
        <a class="navbar-brand" href="#"><img src="../KVRF/final/images/logo.png" alt="로고"></a>
        <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarsExample07" aria-controls="navbarsExample07" aria-expanded="false" aria-label="Toggle navigation">
          <img src="../KVRF/final/images/line-menu.png" alt="toggle-icon" width="22">
        </button>
        <div class="navbar-collapse collapse" id="navbarsExample07" style="">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link active" href="/CSP">홈 <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/CSP/Product">제품소개</a>
            </li>
              <li class="nav-item">
              <a class="nav-link" href="#">커뮤니티</a>
            </li>
              <li class="nav-item">
              <a class="nav-link" href="/CSP/LicenseBuy">라이센스 구매</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
	 
	 <main role="main">
      <section class="main-visual">
        <div class="container">
        </div>
      </section>
      <div class="main-second-container bg-light-blue">
        <div class="container">
        </div>
      </div>
      <div class="album container-pd bg-light">
        <div class="container">
          <div class="row">
              <div class="col-md-12 text-center mb-5">
                  <h2 class="two-title mb-2">
                      코칭 커뮤니티 - 이비인후과
                  </h2>
                  <span class="title-sm"></span>
              </div>
            
	           	<c:forEach var="row" items="${map.list}">		
					<div class="col-md-4">
		              <div class="card mb-4 shadow-sm">
		              	<img class="card-img-top" src="../KVRF/final/images/thum04.jpg" alt="Card image cap">
		                <div class="card-body">
		                    <h5>${row.regdate}</h5>
		                  <p class="card-text"></p>
		                  <div class="d-flex justify-content-between align-items-center">
		                    <div class="btn-group">
		                      <a href="${path}/CoachingBoard/TCoachingBoardView?bno=${row.bno}&curPage=${map.boardPager.curPage}&searchOption=${map.searchOption}&keyword=${map.keyword}" class="btn btn-primary btn-sm">확인</a>
		                    </div>
		                  </div>
		                </div>
		              </div>
		            </div>
				</c:forEach>
              
          </div>
        </div>
      </div>
    </main>
	 
	<!--- 하단풋터 --->
    <footer class="text-muted">
      <div class="container">
        <p class="text-white text-center">ⓒ Solideng all rights reserved.</p>
      </div>
    </footer>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script>window.jQuery || document.write('<script src="./KVRF/final/assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../KVRF/final/assets/js/vendor/popper.min.js"></script>
    <script src="../KVRF/final/js/bootstrap.min.js"></script>
    <script src="../KVRF/final/assets/js/vendor/holder.min.js"></script>
    <script type="text/javascript" src="../static/site/js/jquery/jquery-1.4.2.min.js"></script>
    <script>
            $(window).scroll(function(){
                if ($(window).scrollTop() >= 300) {
                   $('#navbar').addClass('fixed-headers');
                }
                else {
                   $('#navbar').removeClass('fixed-headers');
                }
            });
            
            function LogoutCSP(){
            	var f = document.createElement("form");
            	f.setAttribute('method', "post");
            	f.setAttribute('action', "/CSP/logoutDo");
            	$("body").append(f);
            	f.submit();
            }
    </script> 
    <!--- 하단풋터 끝--->
	
			
</body>
</html>