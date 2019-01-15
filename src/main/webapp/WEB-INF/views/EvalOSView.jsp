<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

<!doctype html>
<html lang="ko">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>수술 평가 - 정형외과</title>

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
            <div class="sub-nav-wrap bg-light-blue mb75">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12 sub-nav-wrap-inner clear-after">
                            <div class="sub-nav-home"><a href="index.html"><i class="fa fa-home"></i></a></div>
                            <div class="sub-nav-list">
                                <h3 class="sub-nav-title">수술 평가</h3>
                            </div>
                            <div class="sub-nav-list">
                                <h3 class="sub-nav-title">정형외과</h3>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="board-view">
                            <h5>수술평가 - 정형외과</h5>
                            <div class="board-view-info">
                                <span></span>
                                <ul>
                                    <li><i class="fa fa-clock-o" aria-hidden="true"></i>${map.date}</li>
                                    <li><i class="fa fa-wrench" aria-hidden="true"></i><strong>실습횟수</strong>${map.ActionCount}회</li>
                                    <li><i class="fa fa-star" aria-hidden="true"></i><strong>실습점수</strong>${map.totalScore}점</li>
                                    <li><i class="fa fa-bar-chart" aria-hidden="true"></i><strong>총 점수</strong>${map.totalScore}점</li>
                                </ul>
                            </div>
                        <div class="board-view-files">
                            <a href="/CSP/EvalOS_RawDown?os_raw_id=${map.ID}" class="b-files">${map.file_name}<i class="fa fa-download" aria-hidden="true"></i>Raw파일</a>
                        </div>

                        </div>
                    </div>
                    <div class="col-sm-12"><h4 class="title-lg-otp mb-3 mt-4 first-of-type">1. Femur neck cutting</h4></div>
                    <div class="col-md-8">
                        <div class="chart-inner-content">
                            <div class="chart-inner-content-2">
                                <table class="table ev-tbl mb-4">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th scope="col">평가항목</th>
                                            <th scope="col">목표수치</th>
                                            <th scope="col">결과치</th>
                                            <th scope="col">점수/배점</th>
                                            <th scope="col">백분위점수</th>
                                            <th scope="col">과정 총점/배점</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row">거리1</th>
                                            <td>5mm</td>
                                            <td>${map.hip01_distance}</td>
                                            <td>${map.hip01_distanceScore}/5</td>
                                            <td rowspan="4" class="align-middle">5</td>
                                            <td rowspan="4" class="align-middle total-score-txt">${map.hip01Score} / 20</td>
                                        </tr>
                                        <tr>
                                           <th scope="row">각도1</th>
                                            <td>135˚</td>
                                            <td>${map.hip01_degree1}</td>
                                            <td>${map.hip01_degreeScore1}/5</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">각도2</th>
                                            <td>45˚</td>
                                            <td>${map.hip01_degree2}</td>
                                            <td>${map.hip01_degreeScore2}/5</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">각도3</th>
                                            <td>0˚</td>
                                            <td>${map.hip01_degree3}</td>
                                            <td>${map.hip01_degreeScore3}/5</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="chart-inner-content-2 at-height">
                                <div class="row">
                                    <div class="col-md-12">
                                        <ul class="chart-color-ul otp">
                                            <li><span class="chart-color one"></span>Ax</li>
                                            <li><span class="chart-color two"></span>Az</li>
                                            <li><span class="chart-color three"></span>Bx</li>
                                            <li><span class="chart-color four"></span>Bz</li>
                                        </ul>
                                    </div>
                                    <div class="col-md-12">
                                            <div class="ct-chart-j1 ct-chart-otp"></div>
                                            <script type="text/javascript">
                                           //var pin_cnt = ${map.hip01_pinCountAx};
                                           var pin_cnt = ${map.hip01_graphAx}.length;
                                           var pin_cnts = [];
                                           for(i=0; i<pin_cnt; i++){
                                        	   pin_cnts.push(i);
                                           }
                                            
                                           var chart = new Chartist.Line('.ct-chart-j1', {
                                              labels: pin_cnts,
                                              series: [
                                                ${map.hip01_graphAx},
                                                ${map.hip01_graphAz},
                                                ${map.hip01_graphBx},
                                                ${map.hip01_graphBz}
                                              ]
                                            }, {
                                                height: 260,
                                              fullWidth: true,
                                              chartPadding: {
                                                right: 10
                                              },
                                              lineSmooth: Chartist.Interpolation.cardinal({
                                                fillHoles: true,
                                              }),
                                              low: 0
                                            });
                                            </script>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 text-center">
                        <div class="chart-inner-content">
                            <img src="./KVRF/final/images/otp-img-01.jpg" alt="관절" class="img100">
                            <img src="./KVRF/final/images/otp-img-02.jpg" alt="관절" class="img100">
                        </div>
                    </div>
                </div>
            </div>
            <div class="container-fluid m-container mt-5 pb-5">
            <div class="container">
                 <div class="row">
                     <div class="col-sm-12"><h4 class="title-lg-otp mb-3 mt-4">2. Acetabulum Reaming</h4></div>
                    <div class="col-md-8">
                        <div class="chart-inner-content">
                            <div class="chart-inner-content-2">
                                <table class="table ev-tbl mb-4">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th scope="col">평가항목</th>
                                            <th scope="col">목표수치</th>
                                            <th scope="col">결과치</th>
                                            <th scope="col">점수/배점</th>
                                            <th scope="col">백분위점수</th>
                                            <th scope="col">과정 총점/배점</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row">거리1</th>
                                            <td>5mm</td>
                                            <td>${map.hip02_cupDistance}</td>
                                            <td>${map.hip02_distance_score}/5</td>
                                            <td rowspan="4" class="align-middle"></td>
                                            <td rowspan="4" class="align-middle total-score-txt">${map.hip02_ResScore} / 25</td>
                                        </tr>
                                        <tr>
                                           <th scope="row">각도1</th>
                                            <td>40˚</td>
                                            <td></td>
                                            <td>${map.hip02_degree_score1}/10</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">각도2</th>
                                            <td>15˚</td>
                                            <td></td>
                                            <td>${map.hip02_degree_score2}/10</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="chart-inner-content-2 at-height">
                                <div class="row">
                                    <div class="col-md-12">
                                        <ul class="chart-color-ul otp">
                                            <li><span class="chart-color" style="background: #43b9f6;"></span>각도1</li>
                                            <li><span class="chart-color" style="background: #f6435f;"></span>각도2</li>
                                            <li><span class="chart-color" style="background: #43f681;"></span>각도3</li>
                                        </ul>
                                    </div>
                                    <div class="col-md-12">
                                            <div class="ct-chart-j2 ct-chart-otp"></div>
                                            <script type="text/javascript">
                                          	var pointsXArr = ${map.hip02_pointsX};
                                          	var pointsXCnt = [];
                                          	for(i=0; i<pointsXArr.length; i++){
                        						pointsXCnt.push(i);
                        					}
                                          	
                                           var chart = new Chartist.Line('.ct-chart-j2', {
                                              labels: pointsXCnt,
                                              series: [
                                            	  ${map.hip02_pointsX}, ${map.hip02_pointsY}, ${map.hip02_pointsZ}
                                              ]
                                            }, {
                                                height: 250,
                                              fullWidth: true,
                                              chartPadding: {
                                                right: 10
                                              },
                                              lineSmooth: Chartist.Interpolation.cardinal({
                                                fillHoles: true,
                                              }),
                                              low: 0
                                            });
                                            </script>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="chart-inner-content text-center">
                            <img src="./KVRF/final/images/otp-img-03.jpg" alt="관절" class="img100">
                            <img src="./KVRF/final/images/otp-img-04.jpg" alt="관절" class="img100">
                        </div>
                    </div>
                </div><!--row-end--->
            </div>
                <div class="container">
                 <div class="row">
                     <div class="col-sm-12"><h4 class="title-lg-otp mt-4">3. Cup Insertion</h4></div>
                    <div class="col-md-8">
                        <div class="chart-inner-content">
                            <div class="chart-inner-content-2">
                                <table class="table ev-tbl mb-0">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th scope="col">평가항목</th>
                                            <th scope="col">목표수치</th>
                                            <th scope="col">결과치</th>
                                            <th scope="col">점수/배점</th>
                                            <th scope="col">백분위점수</th>
                                            <th scope="col">과정 총점/배점</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row">각도1(θ1)</th>
                                            <td>40˚</td>
                                            <td>${map.hip03_cupDiatance}</td>
                                            <td>${map.hip03_score1}/5</td>
                                            <td rowspan="4" class="align-middle"></td>
                                            <td rowspan="4" class="align-middle total-score-txt">${map.hip03_ResScore} / 10</td>
                                        </tr>
                                        <tr>
                                           <th scope="row">각도2(θ2)</th>
                                            <td>15˚</td>
                                            <td>${map.hip03_cupRotation}</td>
                                            <td>${map.hip03_score2}/5</td>
                                        </tr>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="chart-inner-content text-center">
                            <img src="./KVRF/final/images/otp-img-03.jpg" alt="관절" class="img100">
                            <img src="./KVRF/final/images/otp-img-04.jpg" alt="관절" class="img100">
                        </div>
                    </div>
                </div><!--row-end--->
            </div>
                <div class="container">
                 <div class="row">
                     <div class="col-sm-12"><h4 class="title-lg-otp mb-3 mt-4">4. Box chisel</h4></div>
                    <div class="col-md-8">
                        <div class="chart-inner-content">
                            <div class="chart-inner-content-2">
                                <table class="table ev-tbl mb-4">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th scope="col">평가항목</th>
                                            <th scope="col">목표수치</th>
                                            <th scope="col">결과치</th>
                                            <th scope="col">점수/배점</th>
                                            <th scope="col">백분위점수</th>
                                            <th scope="col">과정 총점/배점</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row">거리1</th>
                                            <td>5mm</td>
                                            <td>${map.hip04_entryPointDiatance}</td>
                                            <td>${map.hip04_score1}/5</td>
                                            <td rowspan="4" class="align-middle"></td>
                                            <td rowspan="4" class="align-middle total-score-txt">${map.hip04_ResScore} / 15</td>
                                        </tr>
                                        <tr>
                                           <th scope="row">각도1</th>
                                            <td>15˚</td>
                                            <td></td>
                                            <td>${map.hip04_score2}/5</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">각도2</th>
                                            <td>0˚</td>
                                            <td></td>
                                            <td>${map.hip04_score3}/5</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="chart-inner-content-2 at-height">
                                <div class="row">
                                    <div class="col-md-12">
                                        <ul class="chart-color-ul otp">
                                            <li><span class="chart-color one"></span>X</li>
                                            <li><span class="chart-color two"></span>Y</li>
                                            <li><span class="chart-color three"></span>Z</li>
                                        </ul>
                                    </div>
                                    <div class="col-md-12">
                                            <div class="ct-chart-j3 ct-chart-otp"></div>
                                            <script type="text/javascript">
                                            var hip04_points_labels = [];
                        					var hip04_label_idx = 0;
                        					var hip04_x_arr = [];
                        					var hip04_y_arr = [];
                        					var hip04_z_arr = [];
                        					
                        					<c:forEach var="row" items="${map.hip04_points}">
                        						hip04_points_labels.push(hip04_label_idx);
                        						hip04_label_idx++;
                        						hip04_x_arr.push(${row.positionA}[0]);
                        						hip04_y_arr.push(${row.positionA}[1]);
                        						hip04_z_arr.push(${row.positionA}[2]);
                        					</c:forEach>
                                            
                                           var chart = new Chartist.Line('.ct-chart-j3', {
                                              labels: hip04_points_labels,
                                              series: [
                                            	  hip04_x_arr, hip04_y_arr, hip04_z_arr
                                              ]
                                            }, {
                                                height: 250,
                                              fullWidth: true,
                                              chartPadding: {
                                                right: 10
                                              },
                                              lineSmooth: Chartist.Interpolation.cardinal({
                                                fillHoles: true,
                                              }),
                                              low: 0
                                            });
                                            </script>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="chart-inner-content text-center">
                            <img src="./KVRF/final/images/otp-img-05.jpg" alt="관절" class="img100">
                            <img src="./KVRF/final/images/otp-img-06.jpg" alt="관절" class="img100">
                        </div>
                    </div>
                </div><!--row-end--->
            </div>
                <div class="container">
                 <div class="row">
                     <div class="col-sm-12"><h4 class="title-lg-otp mb-3 mt-4">5. Trail stem</h4></div>
                    <div class="col-md-8">
                        <div class="chart-inner-content">
                            <div class="chart-inner-content-2">
    
                                <table class="table ev-tbl mb-4">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th scope="col">평가항목</th>
                                            <th scope="col">목표수치</th>
                                            <th scope="col">결과치</th>
                                            <th scope="col">점수/배점</th>
                                            <th scope="col">백분위점수</th>
                                            <th scope="col">과정 총점/배점</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row">거리1</th>
                                            <td>0mm</td>
                                            <td>${map.hip05_entryPointDiatance}</td>
                                            <td>7/5</td>
                                            <td rowspan="4" class="align-middle"></td>
                                            <td rowspan="4" class="align-middle total-score-txt"> / 25</td>
                                        </tr>
                                        <tr>
                                           <th scope="row">각도1</th>
                                            <td>15˚</td>
                                            <td></td>
                                            <td>/5</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">각도2</th>
                                            <td>0˚</td>
                                            <td></td>
                                            <td>/5</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="chart-inner-content-2 at-height">
                                <div class="row">
                                    <div class="col-md-12">
                                        <ul class="chart-color-ul otp">
                                            <li><span class="chart-color one"></span>X</li>
                                            <li><span class="chart-color two"></span>Y</li>
                                            <li><span class="chart-color three"></span>Z</li>
                                        </ul>
                                    </div>
                                    <div class="col-md-12">
                                            <div class="ct-chart-j4 ct-chart-otp"></div>
                                            <script type="text/javascript">
                                            var hip05_points_labels = [];
                            				var hip05_label_idx = 0;
                            				var hip05_x_arr = [];
                            				var hip05_y_arr = [];
                            				var hip05_z_arr = [];
                            				
                            				<c:forEach var="row" items="${map.hip05_points}">
                            					hip05_points_labels.push(hip05_label_idx);
                            					hip05_label_idx++;
                            					hip05_x_arr.push(${row.positionA}[0]);
                            					hip05_y_arr.push(${row.positionA}[1]);
                            					hip05_z_arr.push(${row.positionA}[2]);
                            				</c:forEach>
                                            
                                           var chart = new Chartist.Line('.ct-chart-j4', {
                                              labels: hip05_points_labels,
                                              series: [
                                                hip05_x_arr, hip05_y_arr, hip05_z_arr
                                              ]
                                            }, {
                                                height: 250,
                                              fullWidth: true,
                                              chartPadding: {
                                                right: 10
                                              },
                                              lineSmooth: Chartist.Interpolation.cardinal({
                                                fillHoles: true,
                                              }),
                                              low: 0
                                            });
                                            </script>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="chart-inner-content text-center">
                            <img src="./KVRF/final/images/otp-img-05.jpg" alt="관절" class="img100">
                            <img src="./KVRF/final/images/otp-img-06.jpg" alt="관절" class="img100">
                        </div>
                    </div>
                </div><!--row-end--->
            </div>
                <div class="container">
                 <div class="row">
                     <div class="col-sm-12"><h4 class="title-lg-otp mb-3 mt-4">6. Real stem</h4></div>
                    <div class="col-md-8">
                        <div class="chart-inner-content">
                            <div class="chart-inner-content-2">
                                <table class="table ev-tbl mb-4">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th scope="col">평가항목</th>
                                            <th scope="col">목표수치</th>
                                            <th scope="col">결과치</th>
                                            <th scope="col">점수/배점</th>
                                            <th scope="col">백분위점수</th>
                                            <th scope="col">과정 총점/배점</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row">거리1</th>
                                            <td>0mm</td>
                                            <td></td>
                                            <td>/10</td>
                                            <td rowspan="4" class="align-middle"></td>
                                            <td rowspan="4" class="align-middle total-score-txt"> / 25</td>
                                        </tr>
                                        <tr>
                                           <th scope="row">각도1</th>
                                            <td>15˚</td>
                                            <td></td>
                                            <td>/5</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">각도2</th>
                                            <td>0˚</td>
                                            <td></td>
                                            <td>/5</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="chart-inner-content-2 at-height">
                                <div class="row">
                                    <div class="col-md-12">
                                        <ul class="chart-color-ul otp">
                                            <li><span class="chart-color one"></span>X</li>
                                            <li><span class="chart-color two"></span>Y</li>
                                            <li><span class="chart-color three"></span>Z</li>
                                        </ul>
                                    </div>
                                    <div class="col-md-12">
                                            <div class="ct-chart-j5 ct-chart-otp"></div>
                                            <script type="text/javascript">
                                            var hip06_points_labels = [];
                            				var hip06_label_idx = 0;
                            				var hip06_x_arr = [];
                            				var hip06_y_arr = [];
                            				var hip06_z_arr = [];
                            				
                            				<c:forEach var="row" items="${map.hip06_points}">
                            					hip06_points_labels.push(hip06_label_idx);
                            					hip06_label_idx++;
                            					hip06_x_arr.push(${row.positionA}[0]);
                            					hip06_y_arr.push(${row.positionA}[1]);
                            					hip06_z_arr.push(${row.positionA}[2]);
                            				</c:forEach>
                                            
                                           var chart = new Chartist.Line('.ct-chart-j5', {
                                              labels: hip06_points_labels,
                                              series: [
                                                hip06_x_arr, hip06_y_arr, hip06_z_arr
                                              ]
                                            }, {
                                                height: 250,
                                              fullWidth: true,
                                              chartPadding: {
                                                right: 10
                                              },
                                              lineSmooth: Chartist.Interpolation.cardinal({
                                                fillHoles: true,
                                              }),
                                              low: 0
                                            });
                                            </script>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="chart-inner-content text-center">
                            <img src="./KVRF/final/images/otp-img-05.jpg" alt="관절" class="img100">
                            <img src="./KVRF/final/images/otp-img-06.jpg" alt="관절" class="img100">
                        </div>
                    </div>
                </div><!--row-end--->
            </div>
                <div class="container">
                 <div class="row">
                     <div class="col-sm-12"><h4 class="title-lg-otp mb-3 mt-4">7. Final Result</h4></div>
                    <div class="col-md-12">
                        <div class="chart-inner-content">
                            <div class="chart-inner-content-2 scroll-x">
                                <table class="table otp-tbl otp-tbl-sizing mb-0">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th scope="col">No</th>
                                            <th scope="col">단계</th>
                                            <th scope="col">평가항목</th>
                                            <th scope="col">수치</th>
                                            <th scope="col">결과</th>
                                            <th scope="col">점수/배점</th>
                                            <th scope="col">Total</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                            <tr>
                                            <th rowspan="4" scope="row">1</th>
                                            <th rowspan="4">Femur neck cutting</th>
                                            <td>거리1</td>
                                            <td>5mm</td>
                                            <td>${map.hip01_distance}</td>
                                            <td>${map.hip01_distanceScore}/5</td>
                                            <td rowspan="4" class="total-score-txt">${map.hip01Score}</td>
                                          </tr>
                                          <tr>
                                            <td>각도1</td>
                                            <td>135</td>
                                            <td>${map.hip01_degree1}</td>
                                            <td>${map.hip01_degreeScore1}/5</td>
                                          </tr>
                                          <tr>
                                            <td>각도2</td>
                                            <td>45</td>
                                            <td>${map.hip01_degree2}</td>
                                            <td>${map.hip01_degreeScore2}/5</td>
                                          </tr>
                                          <tr>
                                            <td>각도3</td>
                                            <td>0</td>
                                            <td>${map.hip01_degree3}</td>
                                            <td>${map.hip01_degreeScore3}/5</td>
                                          </tr>
                                          <tr>
                                            <th rowspan="3" scope="row">2</th>
                                            <th rowspan="3">Acetabulum Reaming</th>
                                            <td>거리1</td>
                                            <td>10mm</td>
                                            <td>10mm</td>
                                            <td>/5</td>
                                            <td rowspan="3" class="total-score-txt">20</td>
                                          </tr>
                                          <tr>
                                            <td>각도1</td>
                                            <td>45</td>
                                            <td>45</td>
                                            <td>/5</td>
                                          </tr>
                                          <tr>
                                            <td>각도2</td>
                                            <td>135</td>
                                            <td>135</td>
                                            <td>/5</td>
                                          </tr>
                                          <tr>
                                            <th rowspan="2" scope="row">3</th>
                                            <th rowspan="2">Cup</th>
                                            <td>각도1</td>
                                            <td>40</td>
                                            <td>40</td>
                                            <td>/5</td>
                                            <td rowspan="2" class="total-score-txt">20</td>
                                          </tr>
                                          <tr>
                                            <td>각도2</td>
                                            <td>15</td>
                                            <td>15</td>
                                            <td>/5</td>
                                          </tr>
                                          <tr>
                                            <th rowspan="3" scope="row">4</th>
                                            <th rowspan="3">Box chisel</th>
                                            <td>거리1</td>
                                            <td>10mm</td>
                                            <td>10mm</td>
                                            <td>/5</td>
                                            <td rowspan="3" class="total-score-txt">20</td>
                                          </tr>
                                          <tr>
                                            <td>각도1</td>
                                            <td>45</td>
                                            <td>45</td>
                                            <td>5/5</td>
                                          </tr>
                                          <tr>
                                            <td>각도2</td>
                                            <td>135</td>
                                            <td>135</td>
                                            <td>5/5</td>
                                          </tr>
                                          <tr>
                                            <th rowspan="2" scope="row">5</th>
                                            <th rowspan="2">Trail stem</th>
                                            <td>각도1</td>
                                            <td>40</td>
                                            <td>40</td>
                                            <td>2/5</td>
                                            <td rowspan="2" class="total-score-txt">20</td>
                                          </tr>
                                          <tr>
                                            <td>각도2</td>
                                            <td>15</td>
                                            <td>15</td>
                                            <td>5/5</td>
                                          </tr>
                                          <tr>
                                            <th rowspan="2" scope="row">6</th>
                                            <th rowspan="2">Real stem</th>
                                            <td>각도1</td>
                                            <td>40</td>
                                            <td>40</td>
                                            <td>2/5</td>
                                            <td rowspan="2" class="total-score-txt">20</td>
                                          </tr>
                                          <tr>
                                            <td>각도2</td>
                                            <td>15</td>
                                            <td>15</td>
                                            <td>5/5</td>
                                          </tr>
                                          <tr class="total-td">
                                            <td>&nbsp;</td>
                                            <td>Total</td>
                                            <td>&nbsp;</td>
                                            <td>&nbsp;</td>
                                            <td>&nbsp;</td>
                                            <td>&nbsp;</td>
                                            <td>100</td>
                                          </tr>
                                    </tbody>
                                </table>
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
        </script>
        <!--- 하단풋터 끝--->
    </body>
</html>




