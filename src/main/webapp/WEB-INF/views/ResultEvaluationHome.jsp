<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp" %>
<!doctype html>
<html lang="ko">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>플래그십 - 시뮬레이터 시스템</title>
    <link href="./KVRF/final/css/bootstrap.min.css" rel="stylesheet">
    <link href="./KVRF/final/css/style.css" rel="stylesheet">
    <script src="https://use.fontawesome.com/6cf989a115.js"></script>
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
        <a class="navbar-brand" href="#"><img src="./KVRF/final/images/logo.png" alt="로고"></a>
        <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarsExample07" aria-controls="navbarsExample07" aria-expanded="false" aria-label="Toggle navigation">
          <img src="./KVRF/final/images/line-menu.png" alt="toggle-icon" width="22">
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
      <section class="sub-visual evaluation">
        <div class="container">
          <h1 class="main-visual-heading mb-0">수술 평가</h1>
        </div>
      </section>
      <div class="sub-nav-wrap bg-light-blue">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 sub-nav-wrap-inner clear-after">
                    <div class="sub-nav-home"><a href="/CSP"><i class="fa fa-home"></i></a></div>
                    <div class="sub-nav-list"><h3 class="sub-nav-title">수술 평가</h3></div>
                </div>
            </div>
        </div>
      </div>
      <div class="album container-pd bg-light">
        <div class="container">
          <div class="row flexbox-container">
              <div class="col-md-12 text-center mb-5">
                  <span class="title-sm">수술 평가 유형을 선택해주세요.</span>
              </div>
            <div class="col-md-4">
              <div class="card mb-4 shadow-sm">
                <img class="card-img-top" src="./KVRF/final/images/thum01.jpg" alt="Card image cap">
                <div class="card-body">
                    <h5 class="mb-4">TSA(이비인후과)</h5>
                  <div class="d-flex justify-content-between align-items-center">
                      <a href="/CSP/ResultEvaluationHome2" class="btn btn-primary btn-sm width100">나의 실습목록 보기</a>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-md-4">
              <div class="card mb-4 shadow-sm">
                <img class="card-img-top" src="./KVRF/final/images/thum02.jpg" alt="Card image cap">
                <div class="card-body">
                    <h5 class="mb-4">OS(정형외과)</h5>
                  <div class="d-flex justify-content-between align-items-center">
                      <a href="/CSP/EvalOS?id=${pageContext.request.remoteUser}" class="btn btn-primary btn-sm width100">나의 실습목록 보기</a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>
	  
    <footer class="text-muted">
      <div class="container">
        <p class="text-white text-center">ⓒ Solideng all rights reserved.</p>
      </div>
    </footer>

    
    <script>window.jQuery || document.write('<script src="./KVRF/final/assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="./KVRF/final/assets/js/vendor/popper.min.js"></script>
    <script src="./KVRF/final/js/bootstrap.min.js"></script>
    <script src="./KVRF/final/assets/js/vendor/holder.min.js"></script>
    <script type="text/javascript" src="./static/site/js/jquery/jquery-1.4.2.min.js"></script>
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

	 	
</body>
</html>
