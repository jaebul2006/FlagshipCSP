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
    <link href="./KVRF/final/css/bootstrap.min.css" rel="stylesheet">
    <link href="./KVRF/final/css/style.css" rel="stylesheet">	
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
                      수술평가 - 정형외과
                  </h2>
                  <span class="title-sm"></span>
              </div>
            
	           	<c:forEach var="row" items="${map.list}">		
					<div class="col-md-4">
		              <div class="card mb-4 shadow-sm">
		                <img class="card-img-top" src="./KVRF/final/images/thum02.jpg" alt="Card image cap">
		                <div class="card-body">
		                    <h5>${row.date}</h5>
		                  <p class="card-text"></p>
		                  <div class="d-flex justify-content-between align-items-center">
		                    <div class="btn-group">
		                      <a href="${path}/EvalOSView?id=${row.ID}" class="btn btn-primary btn-sm">확인</a>
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
    <!--- 하단풋터 끝--->
	
	
<!--  
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
	
	<div class="container">
		<div class="row">
		<div class="col-md-12">
			<div class="card">
				<ul class="nav nav-tabs" role="tablist">
					<li><a href="/CSP/ResultEvaluationHome?id=${pageContext.request.remoteUser}">
					<h4 class="glyphicon glyphicon-home"></h4><br/>메인
					Home</a></li>
					<c:choose>
						<c:when test="${map.operType == 'TSA'}">
							<li class="active"><a href="/CSP/EvalTSA?id=${pageContext.request.remoteUser}">
							<h4 class="glyphicon glyphicon-check"></h4><br/>
							TSA 수술</a></li>	
						</c:when>
						<c:otherwise>
							<li><a href="/CSP/EvalTSA?id=${pageContext.request.remoteUser}">
							<h4 class="glyphicon glyphicon-check"></h4><br/>
							TSA 수술</a></li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${map.operType == 'OS'}">
							<li class="active"><a href="/CSP/EvalOS?id=${pageContext.request.remoteUser}">
							<h4 class="glyphicon glyphicon-check"></h4><br/>
							OS 수술</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="/CSP/EvalOS?id=${pageContext.request.remoteUser}">
							<h4 class="glyphicon glyphicon-check"></h4><br/>
							OS 수술</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
				
				<c:forEach var="row" items="${map.list}">		
					<div class="col-md-3">
						<div class="card">
							<img class="card-img-top" src="./assets/img/HipTitle.png">
							
							<div class="card-block">
								<h4 class="card-title mt-3">${row.date} </h4>
							</div>
							
							<div class="card-text">총점수: ${row.totalScore}</div>
							<div class="card-text">수술횟수: ${row.actionCount}</div>
							
							<div class="card-footer">
								<button class="btn btn-secondary btn-sm" onclick="window.location.href='${path}/EvalOSView?id=${row.ID}'">결과상세</button>
							</div>
						</div>
					</div>
				</c:forEach>
			
				</div>
			</div>
		</div>
	</div>

	<form name="form1" method="post" action="${path}/EvalOS">  
		<select name="searchOption">
			<option value="all" <c:out value="${map.searchOption == 'all' ? 'selected' : ''}" /> >제목+이름+제목</option>
			<option value="user_name" <c:out value="${map.searchOption}" /> >이름</option>
			<option value="content" <c:out value="${map.searchOption == 'content' ? 'selected' : ''}" /> >내용</option>
			<option value="title" <c:out value="${map.searchOption == 'title' ? 'selected' : ''}" /> >제목</option>
		</select>
		<input name="keyword" value="${map.keyword}">
		<input type="submit" class="btn btn-primary" value="조회">

	</form>
		
	${map.count} 개의 게시물이 있습니다
	<br>

		
		
	<div class="container">
		<ul class="pagination pagination-lg">
			<c:if test="${map.boardPager.curBlock > 1}">
				<li><a href="javascript:list('1')">처음</a></li>
			</c:if>
			<c:if test="${map.boardPager.curBlock > 1}">
				<li><a href="javascript:list('${map.boardPager.prevPage}')">이전</a></li>
			</c:if>
			
			<c:forEach var="num" begin="${map.boardPager.blockBegin}" end="${map.boardPager.blockEnd}">
				<c:choose>
					<c:when test="${num == map.boardPager.curPage}">
						<li class="active"><a href="#">${num}</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="javascript:list('${num}')">${num}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${map.boardPager.curBlock <= map.boardPager.totBlock}">
				<li><a href="javascript:list('${map.boardPager.nextPage}')">다음</a></li>
			</c:if>
			<c:if test="${map.boardPager.curPage <= map.boardPager.totPage}">
				<li><a href="javascript:list('${map.boardPager.totPage}')">끝</a></li>
			</c:if>
		</ul>
	</div>
-->

	
</body>
</html>