<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp" %>
<!doctype html>
<html lang="ko">

<head>
	<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>수술 평가</title>

        <!-- Bootstrap core CSS -->
        <link href="./KVRF/final/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="./KVRF/final/css/style.css" rel="stylesheet">

        <!--fontawesome--->
       <script src="https://use.fontawesome.com/6cf989a115.js"></script>

        <!--chart--->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/chartist/0.11.0/chartist.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/chartist/0.11.0/chartist.min.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
        <script src="./KVRF/final/js/jquery.knob.min.js"></script>
        <script>
            $(function($) {

                $(".knob").knob({
                    change : function (value) {
                        //console.log("change : " + value);
                    },
                    release : function (value) {
                        //console.log(this.$.attr('value'));
                        console.log("release : " + value);
                    },
                    cancel : function () {
                        console.log("cancel : ", this);
                    },
                    /*format : function (value) {
                        return value + '%';
                    },*/
                    draw : function () {

                        // "tron" case
                        if(this.$.data('skin') == 'tron') {

                            this.cursorExt = 0.3;

                            var a = this.arc(this.cv)  // Arc
                                , pa                   // Previous arc
                                , r = 1;

                            this.g.lineWidth = this.lineWidth;

                            if (this.o.displayPrevious) {
                                pa = this.arc(this.v);
                                this.g.beginPath();
                                this.g.strokeStyle = this.pColor;
                                this.g.arc(this.xy, this.xy, this.radius - this.lineWidth, pa.s, pa.e, pa.d);
                                this.g.stroke();
                            }

                            this.g.beginPath();
                            this.g.strokeStyle = r ? this.o.fgColor : this.fgColor ;
                            this.g.arc(this.xy, this.xy, this.radius - this.lineWidth, a.s, a.e, a.d);
                            this.g.stroke();

                            this.g.lineWidth = 2;
                            this.g.beginPath();
                            this.g.strokeStyle = this.o.fgColor;
                            this.g.arc( this.xy, this.xy, this.radius - this.lineWidth + 1 + this.lineWidth * 2 / 3, 0, 2 * Math.PI, false);
                            this.g.stroke();

                            return false;
                        }
                    }
                });

                // Example of infinite knob, iPod click wheel
                var v, up=0,down=0,i=0
                    ,$idir = $("div.idir")
                    ,$ival = $("div.ival")
                    ,incr = function() { i++; $idir.show().html("+").fadeOut(); $ival.html(i); }
                    ,decr = function() { i--; $idir.show().html("-").fadeOut(); $ival.html(i); };
                $("input.infinite").knob(
                                    {
                                    min : 0
                                    , max : 20
                                    , stopper : false
                                    , change : function () {
                                                    if(v > this.cv){
                                                        if(up){
                                                            decr();
                                                            up=0;
                                                        }else{up=1;down=0;}
                                                    } else {
                                                        if(v < this.cv){
                                                            if(down){
                                                                incr();
                                                                down=0;
                                                            }else{down=1;up=0;}
                                                        }
                                                    }
                                                    v = this.cv;
                                                }
                                    });
            });
        </script>
</head>

<body>
 	<!--- 상단헤더 --->
    <header>
        <div class="top-header bg-blue shadow-sm">
            <div class="container text-right m-text-center">
                <a href="/CSP/ResultEvaluationHome" class="top-link fst">수술평가</a>
                <a href="/CSP/CoachingBoard/CoachingBoardListHome" class="top-link sed">코칭 커뮤니티</a>
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
    
      <!--- 상단헤더 끝 --->
      <!--- 메인 --->
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
                          <div class="sub-nav-home"><a href="index.html"><i class="fa fa-home"></i></a></div>
                          <div class="sub-nav-list">
                              <h3 class="sub-nav-title">수술 평가</h3>
                          </div>
                      </div>
                  </div>
              </div>
          </div>
          <div class="container">
              <div class="row">
                  <div class="col-sm-12">
                      <ol class="cd-breadcrumb triangle custom-icons">
                      	<li class="current"><a href="#" onclick="TSA();">Step <strong>TSA</strong></a></li>
                        <li><a href="#" onclick="TransClivalApproach();">Step <strong>경사대접근법</strong></a></li>
                        <li><a href="#" onclick="AcidosisMaxillarySinus();">Step <strong>축농증-상악동</strong></a></li>
                        <li><a href="#" onclick="AcidosisFrontalSinus();">Step <strong>축농증-전두동</strong></a></li>
                        <li><a href="#" onclick="AcidosisEthmoidalSinus();">Step <strong>축농증-사골동</strong></a></li>
                      </ol>
                  </div>

                  <h4 class="title-lg text-center mb-5 mt-5">실습자 모드</h4>

                  <div class="col-md-6 col-sm-12">
                      <div class="chart-inner-content at-height">
                          <div class="row">
                              <div class="col-md-12">
                                  <h6 class="chart-top-title">항목별 점수</h6>
                                  <ul class="chart-color-ul">
                                      <li><span class="chart-color one"></span>전문가 점수</li>
                                      <li><span class="chart-color two"></span>실습자 점수</li>
                                      <li><span class="chart-color three"></span>실습자 평균</li>
                                  </ul>
                              </div>
                              <div class="first-chart">
                                  <div class="first-chart-container">
                                      <div class="ct-chart ct-perfect-fourth"></div>
                                      <script type="text/javascript">
                                      new Chartist.Bar('.ct-chart', {
                                          labels: ['수술행위', '도구사용', '내시경 숙련도'],
                                          series: [
                                          [50, 40, 30],
                                          [100, 70, 80],
                                          [30, 20, 90]
                                        ]
                                      }, {
                                          seriesBarDistance: 10,
                                          reverseData: true,
                                          horizontalBars: true,
                                          axisY: {
                                              offset: 80,
                                              position: 'start',
                                              labelOffset: {
                                                  x: 0,
                                                  y: 0
                                              },
                                          },

                                      });
                                      </script>
                                  </div>
                                  <div class="first-chart-container score-box">
                                      <div class="form-row">
                                          <div class="col">
                                              <label for="formGroupExampleInput">환산점수</label>
                                              <input type="text" class="form-control form-control-sm">
                                          </div>
                                          <div class="col">
                                              <label for="formGroupExampleInput">백분위 점수</label>
                                              <input type="text" class="form-control form-control-sm">
                                          </div>
                                      </div>
                                      <div class="form-row">
                                          <div class="col">
                                              <input type="text" class="form-control form-control-sm">
                                          </div>
                                          <div class="col">
                                              <input type="text" class="form-control form-control-sm">
                                          </div>
                                      </div>
                                      <div class="form-row">
                                          <div class="col">
                                              <input type="text" class="form-control form-control-sm">
                                          </div>
                                          <div class="col">
                                              <input type="text" class="form-control form-control-sm">
                                          </div>
                                      </div>
                                  </div>

                              </div>
                          </div>

                      </div>
                  </div>
                  <div class="col-md-6 col-sm-12">
                      <div class="chart-inner-content">
                          <h6 class="chart-top-title">도구궤적 그래프</h6>
                          <div class="ct-chart ct-chart-bar"></div>
                          <script>
                          new Chartist.Line('.ct-chart-bar', {
                              labels: ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday'],
                              series: [
                                      [12, 9, 7, 8, 5],
                                      [2, 1, 3.5, 7, 3],
                                      [1, 3, 4, 5, 6]
                                    ]
                          }, {
                              height: 322,
                              fullWidth: true,
                              chartPadding: {
                                  right: 40
                              }
                          });
                          </script>
                      </div>
                  </div>
                  <div class="col-md-6">
                      <div class="chart-inner-content">
                          <h6 class="chart-top-title">상세 점수</h6>
                          <table class="table ev-tbl">
                              <thead class="thead-dark">
                                  <tr>
                                      <th scope="col">중요 부위</th>
                                      <th scope="col">접초 횟수</th>
                                      <th scope="col">배점</th>
                                      <th scope="col">감점</th>
                                  </tr>
                              </thead>
                              <tbody>
                                  <tr>
                                      <th scope="row">해면정맥동</th>
                                      <td>3</td>
                                      <td>10</td>
                                      <td>5</td>
                                  </tr>
                                  <tr>
                                      <th scope="row">시신경</th>
                                      <td>3</td>
                                      <td>10</td>
                                      <td>5</td>
                                  </tr>
                                  <tr>
                                      <th scope="row">정상 뇌하수체</th>
                                      <td>3</td>
                                      <td>10</td>
                                      <td>5</td>
                                  </tr>
                                  <tr>
                                      <th scope="row">합계</th>
                                      <td>3</td>
                                      <td>10</td>
                                      <td>5</td>
                                  </tr>
                              </tbody>
                          </table>
                      </div>
                  </div>
                  <div class="col-md-6 col-sm-12">
                      <div class="chart-inner-content">
                          <h6 class="chart-top-title">점수 분포 그래프</h6>
                          <div class="ct-chart ct-chart-2"></div>
                          <script>
                          var chart = new Chartist.Line('.ct-chart-2', {
                              labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri'],
                              series: [
                                  [1, 5, 100, 4, 3],
                                  [2, 3, 8, 1, 2],
                                  [5, 4, 2, 1, 0.5]
                                ]
                          }, {
                              low: 0,
                              showArea: true,
                              showPoint: false,
                              fullWidth: true,
                              height: 245
                          });

                          chart.on('draw', function(data) {
                              if (data.type === 'line' || data.type === 'area') {
                                  data.element.animate({
                                      d: {
                                          begin: 2000 * data.index,
                                          dur: 2000,
                                          from: data.path.clone()
                                              .scale(1, 0)
                                              .translate(0, data.chartRect.height())
                                              .stringify(),
                                          to: data.path.clone()
                                              .stringify(),
                                          easing: Chartist.Svg.Easing.easeOutQuint
                                      }
                                  });
                              }
                          });
                          </script>
                      </div>
                  </div>
                  <div class="col-md-6 col-sm-12">
                      <div class="chart-inner-content">
                          <h6 class="chart-top-title">수술 부위 도식</h6>
                          <img src="./KVRF/final/images/chart-sub-img.jpg" alt="수술부위도식 이미지" class="img100">
                      </div>
                  </div>
                  <div class="col-md-6 col-sm-12">
                      <div class="chart-inner-content">
                          <h6 class="chart-top-title">총 점수</h6>
                          <div style="width:250px;height:250px;padding:20px" class="mx-auto">
                              <input class="knob" data-min="0" data-max="100" data-linecap="round" data-cgColor="#d7d7d7" data-fgColor="#43b9f6" data-thickness=".2" data-readOnly=true value="75">
                          </div>
                      </div>
                  </div>
              </div>
          </div>
          <div class="container-fluid bg-light m-container mt-5 pb-5">
          <div class="container">
               <div class="row">
                  <h4 class="title-lg text-center mb-5 mt-5">실습자 일반 정보 표시 영역</h4>

                  <div class="col-md-6 col-sm-12">
                      <div class="chart-inner-content">
                          <div class="row">

                              <div class="col-md-12">
                                  <h6 class="chart-top-title">항목별 점수</h6>
                                  <ul class="chart-color-ul">
                                      <li><span class="chart-color one"></span>전문가 점수</li>
                                      <li><span class="chart-color two"></span>실습자 점수</li>
                                      <li><span class="chart-color three"></span>실습자 평균</li>
                                  </ul>
                              </div>
                              <div class="first-chart">
                                  <div class="first-chart-container">
                                      <div class="ct-chart-02 ct-perfect-fourth mt-3"></div>
                                      <script type="text/javascript">
                                      new Chartist.Bar('.ct-chart-02', {
                                        labels: ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'],
                                        series: [
                                          [5, 4, 3, 7, 5, 10, 3],
                                          [3, 2, 9, 5, 4, 6, 4],
                                          [3, 2, 9, 5, 4, 6, 4]
                                            
                                        ]
                                      }, {
                                        seriesBarDistance: 10,
                                        reverseData: true,
                                        horizontalBars: true,

                                        axisY: {
                                          offset: 70
                                        }
                                      });
                                      </script>
                                  </div>
                                  <div class="first-chart-container score-box-2">
                                      <div class="form-row">
                                          <div class="col">
                                              <label for="formGroupExampleInput">환산점수</label>
                                              <input type="text" class="form-control form-control-sm">
                                          </div>
                                          <div class="col">
                                              <label for="formGroupExampleInput">백분위 점수</label>
                                              <input type="text" class="form-control form-control-sm">
                                          </div>
                                      </div>
                                      <div class="form-row">
                                          <div class="col">
                                              <input type="text" class="form-control form-control-sm">
                                          </div>
                                          <div class="col">
                                              <input type="text" class="form-control form-control-sm">
                                          </div>
                                      </div>
                                      <div class="form-row">
                                          <div class="col">
                                              <input type="text" class="form-control form-control-sm">
                                          </div>
                                          <div class="col">
                                              <input type="text" class="form-control form-control-sm">
                                          </div>
                                      </div>
                                      <div class="form-row">
                                          <div class="col">
                                              <input type="text" class="form-control form-control-sm">
                                          </div>
                                          <div class="col">
                                              <input type="text" class="form-control form-control-sm">
                                          </div>
                                      </div>
                                      <div class="form-row">
                                          <div class="col">
                                              <input type="text" class="form-control form-control-sm">
                                          </div>
                                          <div class="col">
                                              <input type="text" class="form-control form-control-sm">
                                          </div>
                                      </div>
                                      <div class="form-row">
                                          <div class="col">
                                              <input type="text" class="form-control form-control-sm">
                                          </div>
                                          <div class="col">
                                              <input type="text" class="form-control form-control-sm">
                                          </div>
                                      </div>
                                  </div>

                              </div>
                          </div>

                      </div>
                  </div>
                  <div class="col-md-6 col-sm-12">
                      <div class="chart-inner-content">
                          <h6 class="chart-top-title">도구궤적 그래프</h6>
                          <div class="ct-chart ct-chart-bar-03"></div>
                          <script>
                          new Chartist.Line('.ct-chart-bar-03', {
                              labels: ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday'],
                              series: [
                                      [12, 9, 7, 8, 5],
                                      [2, 1, 3.5, 7, 3],
                                      [1, 3, 4, 5, 6]
                                    ]
                          }, {
                              height: 322,
                              fullWidth: true,
                              chartPadding: {
                                  right: 40
                              }
                          });
                          </script>
                      </div>
                  </div>
                  <div class="col-md-6">
                      <div class="chart-inner-content">
                          <h6 class="chart-top-title">상세 점수</h6>
                          <table class="table ev-tbl">
                              <thead class="thead-dark">
                                  <tr>
                                      <th scope="col">중요 부위</th>
                                      <th scope="col">접초 횟수</th>
                                      <th scope="col">배점</th>
                                      <th scope="col">감점</th>
                                  </tr>
                              </thead>
                              <tbody>
                                  <tr>
                                      <th scope="row">해면정맥동</th>
                                      <td>3</td>
                                      <td>10</td>
                                      <td>5</td>
                                  </tr>
                                  <tr>
                                      <th scope="row">시신경</th>
                                      <td>3</td>
                                      <td>10</td>
                                      <td>5</td>
                                  </tr>
                                  <tr>
                                      <th scope="row">정상 뇌하수체</th>
                                      <td>3</td>
                                      <td>10</td>
                                      <td>5</td>
                                  </tr>
                                  <tr>
                                      <th scope="row">합계</th>
                                      <td>3</td>
                                      <td>10</td>
                                      <td>5</td>
                                  </tr>
                              </tbody>
                          </table>
                      </div>
                  </div>
                  <div class="col-md-6 col-sm-12">
                      <div class="chart-inner-content">
                          <h6 class="chart-top-title">점수 분포 그래프</h6>
                          <div class="ct-chart ct-chart-04"></div>
                          <script>
                          var chart = new Chartist.Line('.ct-chart-04', {
                              labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri'],
                              series: [
                                  [1, 5, 100, 4, 3],
                                  [2, 3, 8, 1, 2],
                                  [5, 4, 2, 1, 0.5]
                                ]
                          }, {
                              low: 0,
                              showArea: true,
                              showPoint: false,
                              fullWidth: true,
                              height: 245
                          });

                          chart.on('draw', function(data) {
                              if (data.type === 'line' || data.type === 'area') {
                                  data.element.animate({
                                      d: {
                                          begin: 2000 * data.index,
                                          dur: 2000,
                                          from: data.path.clone()
                                              .scale(1, 0)
                                              .translate(0, data.chartRect.height())
                                              .stringify(),
                                          to: data.path.clone()
                                              .stringify(),
                                          easing: Chartist.Svg.Easing.easeOutQuint
                                      }
                                  });
                              }
                          });
                          </script>
                      </div>
                  </div>
                  <div class="col-md-6 col-sm-12">
                      <div class="chart-inner-content">
                          <h6 class="chart-top-title">수술 부위 도식</h6>
                          <img src="./KVRF/final/images/chart-sub-img.jpg" alt="수술부위도식 이미지" class="img100">
                      </div>
                  </div>
                  <div class="col-md-6 col-sm-12">
                      <div class="chart-inner-content">
                          <h6 class="chart-top-title">총 점수</h6>
                          <div style="width:250px;height:250px;padding:20px" class="mx-auto">
                              <input class="knob normal" data-min="0" data-max="100" data-linecap="round" data-cgColor="#d7d7d7" data-fgColor="#007bff" data-thickness=".2" data-readOnly=true value="45">
                          </div>
                      </div>
                  </div>
              </div><!--row-end--->
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
        <script>
        window.jQuery || document.write('<script src="./KVRF/final/assets/js/vendor/jquery-slim.min.js"><\/script>')
        </script>
        <script src="./KVRF/final/assets/js/vendor/popper.min.js"></script>
        <script src="./KVRF/final/js/bootstrap.min.js"></script>
        <script src="./KVRF/final/assets/js/vendor/holder.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script>
        $(window)
            .scroll(function() {
                if ($(window)
                    .scrollTop() >= 300) {
                    $('#navbar')
                        .addClass('fixed-headers');
                } else {
                    $('#navbar')
                        .removeClass('fixed-headers');
                }
            });
        
        function LogoutCSP(){
        	var f = document.createElement("form");
        	f.setAttribute('method', "post");
        	f.setAttribute('action', "/CSP/logoutDo");
        	$("body").append(f);
        	f.submit();
        }
        
        // TSA
        function TSA()
        {
        	console.log("TSA");
        }
        
        // 경사대접근법
        function TransClivalApproach()
        {
        	console.log("TransClivalApproach");
        }
        
        // 축농증-상악동
        function AcidosisMaxillarySinus()
        {
        	console.log("AcidosisMaxillarySinus");
        }
        
        // 축농증-전두동
        function AcidosisFrontalSinus()
        {
        	console.log("AcidosisFrontalSinus");
        }
        
        // 축농증-사골동
        function AcidosisEthmoidalSinus()
        {
        	console.log("AcidosisEthmoidalSinus");
        }
        </script>
        <!--- 하단풋터 끝--->
</body>
</html>