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

        <title>TSA</title>

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
                    <li class="nav-item active">
                        <a class="nav-link" href="/CSP">홈</a>
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
    
      <!--- 상단헤더 끝 --->
      <!--- 메인 --->
      <main role="main">
          <section class="sub-visual evaluation">
              <div class="container">
                  <h1 class="main-visual-heading mb-0">TSA</h1>
              </div>
          </section>
          <div class="sub-nav-wrap bg-light-blue">
              <div class="container">
                  <div class="row">
                      <div class="col-sm-12 sub-nav-wrap-inner clear-after">
                          <div class="sub-nav-home"><a href="/CSP"><i class="fa fa-home"></i></a></div>
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
                      	<li><a href="#" onclick="TSAOuterBreak();">Step <strong>외향골절</strong></a></li>
                        <li><a href="#" onclick="TSASeptalFlap();">Step <strong>비중격피판도안</strong></a></li>
                        <li><a href="#" onclick="TSASuperiorTurbinate();">Step <strong>접형동개방</strong></a></li>
                        <li><a href="#" onclick="TSASellaDuramater();">Step <strong>터키안개방 및 경막절개</strong></a></li>
                        <li class="current"><a href="#" onclick="TSATumorRemoval();">Step <strong>종양 절제</strong></a></li>
                      </ol>
                  </div>

                  <h4 class="title-lg text-center mb-5 mt-5">종양 절제</h4>
				  
				  <div class="col-md-6">
                      <div class="chart-inner-content">
                          <h6 class="chart-top-title">일반 정보</h6>
                          <table class="table ev-tbl">
                              <thead class="thead-dark">
                                  <tr>
                                      <th scope="col">목차</th>
                                      <th scope="col">정보</th>
                                  </tr>
                              </thead>
                              <tbody>
                                  <tr>
                                      <th scope="row">이름</th>
                                      <td>${map.tsa_ent_common_Name}</td>
                                  </tr>
                                  <tr>
                                      <th scope="row">학번</th>
                                      <td>${map.tsa_ent_common_ClassNo}</td>
                                  </tr>
                                  <tr>
                                      <th scope="row">실습 시작 날짜, 시간</th>
                                      <td>${map.tsa_ent_common_Date}</td>
                                  </tr>
                                  <tr>
                                      <th scope="row">시도 횟수 회차</th>
                                      <td>${map.tsa_ent_common_ActionCount}</td>
                                  </tr>
                                  <tr>
                                      <th scope="row">종합 점수</th>
                                      <td>${map.tsa_ent_common_TotalScore}</td>
                                  </tr>
                              </tbody>
                          </table>
                      </div>
                  </div>
				  
				  <div class="col-md-6">
                      <div class="chart-inner-content">
                          <h6 class="chart-top-title">TSA 도구 정보</h6>
                          <table class="table ev-tbl">
                              <thead class="thead-dark">
                                  <tr>
                                      <th scope="col">도구 수치 목록</th>
                                      <th scope="col">수치</th>
                                  </tr>
                              </thead>
                              <tbody>
                                  <tr>
                                      <th scope="row">충돌횟수</th>
                                      <td>${map.ent_tsa_tools_TouchCount}</td>
                                  </tr>
                                  <tr>
                                      <th scope="row">툴 조작 횟수</th>
                                      <td>${map.ent_tsa_tools_ToolUseCount}</td>
                                  </tr>
                                  <tr>
                                      <th scope="row">내시경 화면내 정확한 툴 위치횟수</th>
                                      <td>${map.ent_tsa_tools_ToolInnerCount}</td>
                                  </tr>
                                  <tr>
                                      <th scope="row">도구 충돌 점수</th>
                                      <td>${map.ent_tsa_tools_ToolTouchScore}</td>
                                  </tr>
                                  <tr>
                                      <th scope="row">내시경 화면내 도구 위치 점수</th>
                                      <td>${map.ent_tsa_tools_ToolViewScore}</td>
                                  </tr>
                                  <tr>
                                      <th scope="row">각각 최대 툴 점수</th>
                                      <td>${map.ent_tsa_tools_MaxScore}</td>
                                  </tr>
                              </tbody>
                          </table>
                      </div>
                  </div>

                  <div class="col-md-6 col-sm-12">
                      <div class="chart-inner-content at-height">
                          <div class="row">
                              <div class="col-md-12">
                                  <h6 class="chart-top-title">TSA 도구 점수</h6>
                                  <ul class="chart-color-ul">
                                      <li><span class="chart-color one"></span>전문가 점수</li>
                                      <li><span class="chart-color two"></span>실습자 점수</li>
                                      <li><span class="chart-color three"></span>실습자 평균</li>
                                  </ul>
                              </div>
                              <div class="first-chart">
                                  <div class="first-chart-container">
                                      <div class="ct-chart ct-perfect-fourth" id="tool_chart1"></div>
                                      <script type="text/javascript">
                                      new Chartist.Bar('#tool_chart1', {
                                          labels: ['충돌횟수', '툴 조작 횟수', '내시경 화면내 정확한 툴 위치횟수', '도구 충돌 점수', '내시경 화면내 도구 위치 점수', '각각 최대 툴 점수'],
                                          series: [
                                          [${map.mo_ex_TouchCount}, ${map.mo_ex_ToolUseCount}, ${map.mo_ex_ToolInnerCount}, ${map.mo_ex_ToolTouchScore}, ${map.mo_ex_ToolViewScore}, ${map.mo_ex_MaxScore}],
                                          [${map.ent_tsa_tools_TouchCount}, ${map.ent_tsa_tools_ToolUseCount}, ${map.ent_tsa_tools_ToolInnerCount}, ${map.ent_tsa_tools_ToolTouchScore}, ${map.ent_tsa_tools_ToolViewScore}, ${map.ent_tsa_tools_MaxScore}],
                                          [${map.aver_moTouchCount}, ${map.aver_moToolUseCount}, ${map.aver_moToolInnerCount}, ${map.aver_moToolTouchScore}, ${map.aver_moToolViewScore}, ${map.aver_moToolMaxScore}]
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
                                                      
                  <div class="col-md-6">
                      <div class="chart-inner-content">
                          <h6 class="chart-top-title">종양 절제(TumorRemoval)</h6>
                          <table class="table ev-tbl">
                              <thead class="thead-dark">
                                  <tr>
                                      <th scope="col">목록</th>
                                      <th scope="col">수치</th>
                                  </tr>
                              </thead>
                              <tbody>
                                  <tr>
                                      <th scope="row">단위최고점</th>
                                      <td>100</td>
                                  </tr>
                                  <tr>
                                      <th scope="row">결과 점수</th>
                                      <td>${map.ent_tsa_tumor_removal_Score}</td>
                                  </tr>
                                  <tr>
                                      <th scope="row">기록</th>
                                      <td>${map.ent_tsa_tumor_removal_Note}</td>
                                  </tr>
                                  <tr>
                                      <th scope="row">Position</th>
                                      <td>${map.ent_tsa_tumor_removal_Position}</td>
                                  </tr>
                                  <tr>
                                      <th scope="row">Rotation</th>
                                      <td>${map.ent_tsa_tumor_removal_Rotation}</td>
                                  </tr>
                                  <tr>
                                      <th scope="row">Localcale</th>
                                      <td>${map.ent_tsa_tumor_removal_Localcale}</td>
                                  </tr>
                                  <tr>
                                      <th scope="row">핀 갯수</th>
                                      <td>${map.ent_tsa_tumor_removal_PinCount}</td>
                                  </tr>
                              </tbody>
                          </table>
                      </div>
                  </div>
                  
                  <div class="col-md-6">
                      <div class="chart-inner-content">
                          <h6 class="chart-top-title">종양 절제(TumorRemoval) 도구 정보</h6>
                          <table class="table ev-tbl">
                              <thead class="thead-dark">
                                  <tr>
                                      <th scope="col">도구 수치 목록</th>
                                      <th scope="col">수치</th>
                                  </tr>
                              </thead>
                              <tbody>
                                  <tr>
                                      <th scope="row">충돌횟수</th>
                                      <td>${map.ent_tsa_tumor_removal_Tools_TouchCount}</td>
                                  </tr>
                                  <tr>
                                      <th scope="row">툴 조작 횟수</th>
                                      <td>${map.ent_tsa_tumor_removal_Tools_ToolUseCount}</td>
                                  </tr>
                                  <tr>
                                      <th scope="row">내시경 화면내 정확한 툴 위치횟수</th>
                                      <td>${map.ent_tsa_tumor_removal_Tools_ToolInnerCount}</td>
                                  </tr>
                                  <tr>
                                      <th scope="row">도구 충돌 점수</th>
                                      <td>${map.ent_tsa_tumor_removal_Tools_ToolTouchScore}</td>
                                  </tr>
                                  <tr>
                                      <th scope="row">내시경 화면내 도구 위치 점수</th>
                                      <td>${map.ent_tsa_tumor_removal_Tools_ToolViewScore}</td>
                                  </tr>
                                  <tr>
                                      <th scope="row">각각 최대 툴 점수</th>
                                      <td>${map.ent_tsa_tumor_removal_Tools_MaxScore}</td>
                                  </tr>
                              </tbody>
                          </table>
                      </div>
                  </div>
                  
                  <div class="col-md-6 col-sm-12">
                      <div class="chart-inner-content at-height">
                          <div class="row">
                              <div class="col-md-12">
                                  <h6 class="chart-top-title">종양 절제(TumorRemoval) 도구 점수</h6>
                                  <ul class="chart-color-ul">
                                      <li><span class="chart-color one"></span>전문가 점수</li>
                                      <li><span class="chart-color two"></span>실습자 점수</li>
                                      <li><span class="chart-color three"></span>실습자 평균</li>
                                  </ul>
                              </div>
                              <div class="first-chart">
                                  <div class="first-chart-container">
                                      <div class="ct-chart ct-perfect-fourth" id="tool_tumor_removal_chart"></div>
                                      <script type="text/javascript">
                                      new Chartist.Bar('#tool_tumor_removal_chart', {
                                          labels: ['충돌횟수', '툴 조작 횟수', '내시경 화면내 정확한 툴 위치횟수', '도구 충돌 점수', '내시경 화면내 도구 위치 점수', '각각 최대 툴 점수'],
                                          series: [
                                          [${map.so_ex_TouchCount}, ${map.so_ex_ToolUseCount}, ${map.so_ex_ToolInnerCount}, ${map.so_ex_ToolTouchScore}, ${map.so_ex_ToolViewScore}, ${map.so_ex_MaxScore}],
                                          [${map.ent_tsa_tumor_removal_Tools_TouchCount}, ${map.ent_tumor_removal_duramater_Tools_ToolUseCount}, ${map.ent_tsa_tumor_removal_Tools_ToolInnerCount}, ${map.ent_tsa_tumor_removal_Tools_ToolTouchScore}, ${map.ent_tsa_tumor_removal_Tools_ToolViewScore}, ${map.ent_tsa_tumor_removal_Tools_MaxScore}],
                                          [${map.aver_soTouchCount}, ${map.aver_soToolUseCount}, ${map.aver_soToolInnerCount}, ${map.aver_soToolTouchScore}, ${map.aver_soToolViewScore}, ${map.aver_soToolMaxScore}]
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
                          <h6 class="chart-top-title">종양 절제(TumorRemoval) 핀 그래프</h6>
                          <div class="ct-chart ct-chart-bar" id="tumor_removal_pin_chart"></div>
                          <script>  
                          new Chartist.Line('#tumor_removal_pin_chart', {
                              labels: [],
                              series: [
                            	  		${map.ent_tsa_tumor_removal_Pins},
                            	  		${map.ent_tsa_tumor_removal_TargetPins}
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
                  
                  <div class="col-md-6 col-sm-12">
                      <div class="chart-inner-content">
                          <h6 class="chart-top-title">TSA 수술 부위 도식</h6>
                          <img src="./KVRF/final/images/chart-sub-img.jpg" alt="수술부위도식 이미지" class="img100">
                      </div>
                  </div>
                  <div class="col-md-6 col-sm-12">
                      <div class="chart-inner-content">
                          <h6 class="chart-top-title">총 점수</h6>
                          <div style="width:250px;height:250px;padding:20px" class="mx-auto">
                              <input class="knob" data-min="0" data-max="100" data-linecap="round" data-cgColor="#d7d7d7" data-fgColor="#43b9f6" data-thickness=".2" data-readOnly=true value="${map.sc_tumor_removal}">
                          </div>
                      </div>
                  </div>
              </div>
          </div>
          
          
          <div class="container-fluid bg-light m-container mt-5 pb-5">
          <div class="container">
               <div class="row">
                  <h4 class="title-lg text-center mb-5 mt-5">TSA 전체 결과 정보 및 통계</h4>
                  <div class="col-md-6">
                      <div class="chart-inner-content">
                          <h6 class="chart-top-title">점수 목록</h6>
                          <table class="table ev-tbl">
                              <thead class="thead-dark">
                                  <tr>
                                      <th scope="col">수술 단계 목록</th>
                                      <th scope="col">점수</th>
                                      <th scope="col">평균</th>
                                      <th scope="col">배점</th>
                                  </tr>
                              </thead>
                              <tbody>
                                  <tr>
                                      <th scope="row">외향골절</th>
                                      <td>${map.sc_outer_break}</td>
                                      <td>${map.aver_sc_outer_break}</td>
                                      <td>100</td>
                                  </tr>
                                  <tr>
                                      <th scope="row">비중격피판도안</th>
                                      <td>${map.sc_septal_flap}</td>
                                      <td>${map.aver_sc_septal_flap}</td>
                                      <td>100</td>
                                  </tr>
                                  <tr>
                                      <th scope="row">접형동개방</th>
                                      <td>${map.sc_superior_turbinate}</td>
                                      <td>${map.aver_sc_superior_turbinate}</td>
                                      <td>100</td>
                                  </tr>
                                  <tr>
                                      <th scope="row">터키안개방 및 경막절개</th>
                                      <td>${map.sc_sella_duramater}</td>
                                      <td>${map.aver_sc_sella_duramater}</td>
                                      <td>100</td>
                                  </tr>
                                  <tr>
                                      <th scope="row">종양 절제</th>
                                      <td>${map.sc_tumor_removal}</td>
                                      <td>${map.aver_sc_tumor_removal}</td>
                                      <td>100</td>
                                  </tr>
                              </tbody>
                          </table>
                      </div>
                  </div>
                  
                  <div class="col-md-6 col-sm-12">
                      <div class="chart-inner-content">
                          <h6 class="chart-top-title">TSA 점수 분포 그래프</h6>
                          <div class="ct-chart ct-chart-2" id="tsa_score_reange_chart"></div>
                          <script>
                          var chart = new Chartist.Bar('#tsa_score_reange_chart', {
                              labels: ['0~50', '51~60', '61~70', '71~80', '81~90', '91~100'],
                              series: [
                                  [${map.Rn0_to_50}, ${map.Rn51_to_60}, ${map.Rn61_to_70}, ${map.Rn71_to_80}, ${map.Rn81_to_90}, ${map.Rn91_to_100}],
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
                          <h6 class="chart-top-title">단위수술별점수 그래프</h6>
                          <ul class="chart-color-ul">
                              <li><span class="chart-color three"></span>실습자 점수</li>
                          </ul>
                          <div class="ct-chart ct-chart-04"></div>
                          <script>
                          var chart = new Chartist.Line('.ct-chart-04', {
                              labels: ['외향골절', '비중격피판도안', '접형동개방', '터키안개방 및 경막절개', '종양 절제'],
                              series: [
                                  [${map.sc_outer_break}, ${map.sc_septal_flap}, ${map.sc_superior_turbinate}, ${map.sc_sella_duramater}, ${map.sc_tumor_removal}],
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
                          <h6 class="chart-top-title">총 점수</h6>
                          <div style="width:250px;height:250px;padding:20px" class="mx-auto">
                              <input class="knob normal" data-min="0" data-max="100" data-linecap="round" data-cgColor="#d7d7d7" data-fgColor="#007bff" data-thickness=".2" data-readOnly=true value="${map.tsa_ent_common_TotalScore}">
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
        
        // 1. OuterBreak
        function TSAOuterBreak()
        {
        	window.location.href = "${path}/ViewTSA_OuterBreak?id=${map.no}"; // tsa id 로 보내야됨
        }
        
        // 2. SeptalFlap
        function TSASeptalFlap()
        {
        	window.location.href = "${path}/ViewTSA_SeptalFlap?id=${map.no}";
        }
        
        // 3. Superior Turbinate 
        function TSASuperiorTurbinate()
        {
        	window.location.href = "${path}/ViewTSA_SuperiorTurbinate?id=${map.no}";
        }
        
        // 4. Sella Duramater
        function TSASellaDuramater()
        {
        	window.location.href = "${path}/ViewTSA_SellaDuramater?id=${map.no}";
        }
        
     	// 5. Tumor Removal
        function TSATumorRemoval()
        {
        	window.location.href = "${path}/ViewTSA_TumorRemoval?id=${map.no}";
        }
        
        </script>
        <!--- 하단풋터 끝--->
</body>
</html>