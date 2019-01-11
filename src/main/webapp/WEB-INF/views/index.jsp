<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
            <a href="#" onclick="LogoutCSP();" class="top-link thd" >로그아웃</a>
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
              <a class="nav-link" href="/CSP/DashBoard1?id=${pageContext.request.remoteUser}">커뮤니티</a>
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
          <h1 class="main-visual-heading mb-4">시뮬레이터 시스템</h1>
          <p>
            실제와 매우 유사한 가상의 수술실 환경을 구성합니다. <br>
            수술에 대한 숙련도와 이해를 증진시키고자 하는 의사선생님들과 향후 수술실에서 <br>
            실습을 하게 될 예비의사 선생님들을 위한 시스템입니다.
          </p>
        </div>
      </section> 
      <div class="main-second-container bg-light-blue">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 align-self-center">
                    <div class="">
                      <h2 class="two-title">
                          가상현실 수술실<br><strong>시뮬레이터 시스템</strong>
                        </h2>
                        <span>
                            3D 가상현실을 시뮬레이터에 결합해 몰입감 넘치는 학습 시스템입니다.
                        </span>
                      <p class="p-txt">
                        360도 수술장면 중계 활용 교육 및 CT, MRI 3D모델 위에 종양 등의 정보를 가시화해 수술과정을 수술 전에 시뮬레이션해 수술의 위험을 줄여줍니다. <br>
                        가상치료 및 재활 가상의 자극에 적응하도록 유도하고 게임기술을 활용치료에 대한 동기를 지속적으로 유지해 환자들을 치유하는데 활용할 수 있습니다.    
                      </p>
                      <p><a class="btn btn-primary btn-lg" href="#" role="button">Read More</a></p>
                    </div>
                </div>
                <div class="col-sm-6">
                    <span class="machine">
                    
                    </span>
                </div>
            </div>
        </div>
      </div>
      <div class="album container-pd bg-light">
        <div class="container">
          <div class="row">
              <div class="col-md-12 text-center mb-5">
                  <h2 class="two-title mb-2">
                      컨텐츠
                  </h2>
                  <span class="title-sm">나에게 적합한 컨텐츠를 선택하세요. 다양한 수술을 반복적으로 경험할 수 있습니다.</span>
              </div>
            <div class="col-md-4">
              <div class="card mb-4 shadow-sm">
                <img class="card-img-top" src="./KVRF/final/images/thum01.jpg" alt="Card image cap">
                <div class="card-body">
                    <h5>이비인후과 종양 제거 수술</h5>
                  <p class="card-text">각각의 컨텐츠는 수술마다 차별화된 내용을 포함하고 있습니다. 수술 별로 체험되어야할 특징이 모두 다름으로서 작업자의 몰입도를 증가시켜줍니다.</p>
                  <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group">
                      <a href="#" class="btn btn-primary btn-sm">Read More</a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-md-4">
              <div class="card mb-4 shadow-sm">
                <img class="card-img-top" src="./KVRF/final/images/thum02.jpg" alt="Card image cap">
                <div class="card-body">
                    <h5>고관절 치환 수술</h5>
                  <p class="card-text">각각의 컨텐츠는 수술마다 차별화된 내용을 포함하고 있습니다. 수술 별로 체험되어야할 특징이 모두 다름으로서 작업자의 몰입도를 증가시켜줍니다.</p>
                  <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group">
                      <a href="#" class="btn btn-primary btn-sm">Read More</a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-md-4">
              <div class="card mb-4 shadow-sm">
                <img class="card-img-top" src="./KVRF/final/images/thum03.jpg" alt="Card image cap">
                <div class="card-body">
                    <h5>추가 수술 콘텐츠 예정</h5>
                  <p class="card-text">각각의 컨텐츠는 수술마다 차별화된 내용을 포함하고 있습니다. 수술 별로 체험되어야할 특징이 모두 다름으로서 작업자의 몰입도를 증가시켜줍니다.</p>
                  <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group">
                      <a href="#" class="btn btn-primary btn-sm">Read More</a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="main-last bg-blue container-pd">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <div class="text-white">
                      <h2 class="two-title">
                          수술 평가 & 코칭 커뮤니티
                        </h2>
                      <p class="p-txt text-white mb-4">
                        자신이 실습한 결과를 시스템에 업로드하여 
                        경험 많고 뛰어난 멘토 의사 선생님들의 피드백을 받을 수 있도록 구성된 시스템입니다. 
                        또한 자신의 실력을 점수로 환산한 결과를 받아 볼 수 있습니다. 
                        이로 인하여 수술 숙련 향상을 위한 동기부여에 크게 기여할 것입니다.
                      </p>
                      <p><a class="btn btn-white btn-lg" href="#" role="button">Read More</a></p>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class=" text-white">
                    <img src="./KVRF/final/images/monitor.png" alt="모니터" class="m-img">
                    </div>
                </div>
            </div>
        </div>
      </div>
    </main>
    <!--- 메인 끝--->
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
</body>



<!--  구버전  -->
<!--   
    <link href="../CSP/dashboard/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="../CSP/dashboard/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="../CSP/dashboard/vendors/nprogress/nprogress.css" rel="stylesheet">
    <link href="../CSP/dashboard/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <link href="../CSP/dashboard/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <link href="../CSP/dashboard/vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet"/>
    <link href="../CSP/dashboard/vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
    <link href="../CSP/dashboard/build/css/custom.css" rel="stylesheet">

<title>Flagship CSP</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="./static/site/css/styles.css" />
<script type="text/javascript" src="./static/site/js/jquery/jquery-1.4.2.min.js"></script>

	<script>
		$(document).ready(function(){

			var param = {"id": "${pageContext.request.remoteUser}"};
			
			$.ajax({
				type: "post",
				data: param,
				url: "/CSP/CheckAdmin",
				
				success: function(data){
					//console.log(data);
					if(data == "admin"){
						var $menu = $("<li><a href='/CSP/RegistCommonUser'>일반유저등록</a></li>");
						$('#main-navigation').append($menu);
					}
				}	
			});
			
		});
	</script>

</head>
<body>
	
<div id="header">
	<div id="top-header">
		<div id="company-logo">
			<h1><img src="./static/site/images/logo-1.png" alt="BIZZ GROUP" id="logo" style="position:relative; right:65%;"/></h1>
		</div>
		<ul id="main-navigation">
			<li class="active"><a href="/CSP">홈</a></li>
			<li><a href="/CSP/ProductInfo">제품소개</a></li>
			<li><a href="/CSP/ResultEvaluationHome">수술 평가</a></li> 
			<li><a href="/CSP/DashBoard1?id=${pageContext.request.remoteUser}">코칭 커뮤니티</a></li> 
			<li><a href="#">커뮤니티</a></li>
			<li><a href="/CSP/LicenseBuy">라이센스구매</a></li>
		</ul>
		<div id="userInfo" style="position:relative; width:50%; left:70%; top:52%;">
			<c:choose>
				<c:when test="${session_login != null}">
					<p> 안녕하세요. <b><c:out value="${pageContext.request.remoteUser}" /></b></p>
					<form action="/CSP/logoutDo" method="post">
						<button type="submit" id="btn_logout">로그아웃</button>
					</form>
				</c:when>
			</c:choose>
		</div>
		<div class="clear"></div>
	</div>

	<div id="header-banner-wrap" style="height:550px;">
		<div id="header-banner" style="height:550px;">
			<div class="webgl-content">
					<iframe allowfullscreen src="./static/b4w/Oper_RobFullNoPeopleFix.html" width="1000" height="548"></iframe>
		    </div>
   		</div>
	</div>
</div>

<div id="content">
	<div class="wide-wrapper">
		<div class="content-container">
			<div class="info-box wide-box">
				<h3>시뮬레이터 시스템 소개</h3>
				<div>
					<p>
						<img src="./assets/img/vr.jpg" class="photo" alt="" /><strong>- 시뮬레이터 시스템은</strong> 
						실제와 매우 유사한 가상의 수술실 환경을 구성합니다. 
						수술에 대한 숙련도와 이해를 증진시키고자 하는 의사선생님들과 
						향후 수술실에서 실습을 하게 될 예비의사 선생님들을 위한 시스템입니다.
					</p>
					<p>
						<strong>- <a href="/CSP/DashBoard1">코칭 대시보드</a> </strong>는 자신이 실습한 결과를 시스템에 업로드하면 경험많고 
						뛰어난 멘토 의사선생님들의 피드백을 받을 수 있도록 구성된 시스템입니다. 
					</p>
					<a href="#" class="readmore-small"><img src="./static/site/images/read-more-btn.png" alt="" /></a>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<div class="content-container middle-side">
		<div class="info-box">
			<h4>이비인후과 <br>종양 제거 수술</h4>
			<div class="align-content">
				<p><img src="./assets/img/surgical1.JPG" class="photo" alt="" /></p>
				<p>각각의 컨텐츠는 수술마다 차별화된 내용을 포함하고 있습니다. 수술 별로 체험되어야할 특징이 모두 다름으로서 작업자의 몰입도를 증가시켜줍니다.</p>
			</div>
			<a href="#" class="readmore-small"><img src="./static/site/images/read-more-btn.png" alt="" /></a>
		</div>
		<div class="info-box">
			<h4>고관절 <br>치환 수술 </h4>
			<div class="align-content">
				<p><img src="./assets/img/surgical2.jpg" class="photo" alt="" /></p>
				<p>각각의 컨텐츠는 수술마다 차별화된 내용을 포함하고 있습니다. 수술 별로 체험되어야할 특징이 모두 다름으로서 작업자의 몰입도를 증가시켜줍니다.</p>
			</div>
			<a href="#" class="readmore-small"><img src="./static/site/images/read-more-btn.png" alt="" /></a>
		</div>
		<div class="info-box">
			<h4>치과 <br>치석 제거 </h4>
			<div class="align-content">
				<p><img src="./assets/img/surgical3.jpg" class="photo" alt="" /></p>
				<p>각각의 컨텐츠는 수술마다 차별화된 내용을 포함하고 있습니다. 수술 별로 체험되어야할 특징이 모두 다름으로서 작업자의 몰입도를 증가시켜줍니다.</p>
			</div>
			<a href="#" class="readmore-small"><img src="./static/site/images/read-more-btn.png" alt="" /></a>
		</div>
		<div class="info-box">
			<h4>업데이트 &amp; <br>개발중인 컨텐츠 1</h4>
			<div class="align-content">
				<p><img src="./assets/img/surgical4.jpg" class="photo" alt="" /></p>
				<p>각각의 컨텐츠는 수술마다 차별화된 내용을 포함하고 있습니다. 수술 별로 체험되어야할 특징이 모두 다름으로서 작업자의 몰입도를 증가시켜줍니다.</p>
			</div>
			<a href="#" class="readmore-small"><img src="./static/site/images/read-more-btn.png" alt="" /></a>
		</div>
		<div class="info-box">
			<h4>업데이트 &amp; <br>개발중인 컨텐츠 2</h4>
			<div class="align-content">
				<p><img src="./assets/img/surgical5.jpg" class="photo" alt="" /></p>
				<p>각각의 컨텐츠는 수술마다 차별화된 내용을 포함하고 있습니다. 수술 별로 체험되어야할 특징이 모두 다름으로서 작업자의 몰입도를 증가시켜줍니다.</p>
			</div>
			<a href="#" class="readmore-small"><img src="./static/site/images/read-more-btn.png" alt="" /></a>
		</div>
		<div class="info-box">
			<h4>업데이트 &amp; <br>개발중인 컨텐츠 3</h4>
			<div class="align-content">
				<p><img src="./assets/img/surgical6.jpg" class="photo" alt="" /></p>
				<p>각각의 컨텐츠는 수술마다 차별화된 내용을 포함하고 있습니다. 수술 별로 체험되어야할 특징이 모두 다름으로서 작업자의 몰입도를 증가시켜줍니다.</p>
			</div>
			<a href="#" class="readmore-small"><img src="./static/site/images/read-more-btn.png" alt="" /></a>
		</div>
		<div class="clear"></div>
	</div>
	<div class="wide-wrapper">
		<div class="content-container">
			<div class="info-box" style="width='528px;'">
				<h4>코칭 대시보드</h4>
				<p>
				코칭 대시보드는 자신이 실습한 결과를 시스템에 업로드하면 경험많고 뛰어난 멘토 의사선생님들의 피드백을 받을 수 있도록 구성된 시스템입니다.
				또한 자신의 실력을 점수로 환산한 결과를 받아 볼 수 있습니다. 이로 인하여 수술 숙련 향상을 위한 동기부여에 크게 기여할 것입니다.
				</p>
				<a href="/CSP/DashBoard1?id=${pageContext.request.remoteUser}" class="readmore-small"><img src="./static/site/images/read-more-btn.png" alt="" /></a>
			</div>
			<div class="info-box">
				<img src="./assets/img/CDashBoard.png" class="photo" alt="" />
			</div>
			<div class="clear"></div>
		</div>
	</div>
</div>


<div id="footer">
	Website designed by <a href="http://www.solideng.co.kr/" target="_blank" rel="nofollow">http://www.solideng.co.kr</a><br/>
</div>
</body>
-->
</html>