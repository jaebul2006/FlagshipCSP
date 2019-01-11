<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>제품소개</title>

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
            <a href="#" onclick="LogoutCSP();" class="top-link thd">로그아웃</a>
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
            <li class="nav-item">
              <a class="nav-link" href="/CSP">홈</a>
            </li>
            <li class="nav-item active">
              <a class="nav-link active" href="#">제품소개<span class="sr-only">(current)</span></a>
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
      <section class="sub-visual product">
        <div class="container">
          <h1 class="main-visual-heading mb-0">제품소개</h1>
        </div>
      </section>
      <div class="sub-nav-wrap bg-light-blue">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 sub-nav-wrap-inner clear-after">
                    <div class="sub-nav-home"><a href="index.html"><i class="fa fa-home"></i></a></div>
                    <div class="sub-nav-list"><h3 class="sub-nav-title">제품소개</h3></div>
                </div>
            </div>
        </div>
      </div>
      <div class="product-visual-container">
        <div class="container">
            <div class="row m-row">
                <div class="col-sm-6">
                    <span class="machine-2">
                    </span>
                </div>
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
                    </div>
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
                </div>
              </div>
            </div>
            <div class="col-md-4">
              <div class="card mb-4 shadow-sm">
                <img class="card-img-top" src="./KVRF/final/images/thum02.jpg" alt="Card image cap">
                <div class="card-body">
                    <h5>고관절 치환 수술</h5>
                  <p class="card-text">각각의 컨텐츠는 수술마다 차별화된 내용을 포함하고 있습니다. 수술 별로 체험되어야할 특징이 모두 다름으로서 작업자의 몰입도를 증가시켜줍니다.</p>
                </div>
              </div>
            </div>
            <div class="col-md-4">
              <div class="card mb-4 shadow-sm">
                <img class="card-img-top" src="./KVRF/final/images/thum03.jpg" alt="Card image cap">
                <div class="card-body">
                    <h5>추가 수술 콘텐츠 예정</h5>
                  <p class="card-text">각각의 컨텐츠는 수술마다 차별화된 내용을 포함하고 있습니다. 수술 별로 체험되어야할 특징이 모두 다름으로서 작업자의 몰입도를 증가시켜줍니다.</p>
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
                    <div class="text-white mt-5">
                      <h2 class="two-title">
                          수술 평가 & 코칭 커뮤니티
                        </h2>
                      <p class="p-txt text-white mb-4">
                        자신이 실습한 결과를 시스템에 업로드하여 
                        경험 많고 뛰어난 멘토 의사 선생님들의 피드백을 받을 수 있도록 구성된 시스템입니다. 
                        또한 자신의 실력을 점수로 환산한 결과를 받아 볼 수 있습니다. 
                        이로 인하여 수술 숙련 향상을 위한 동기부여에 크게 기여할 것입니다.
                      </p>
                    
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
    </script> 
  </body>
</html>