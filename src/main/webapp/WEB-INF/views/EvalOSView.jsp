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




<!--  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>OS 수술 평가정보</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link rel="stylesheet" href="./KVRF/chartist-js-master/dist/chartist.min.css">
	<script src="./KVRF/chartist-js-master/dist/chartist.min.js"></script>
	<link rel="stylesheet" href="./static/MDBFree/css/bootstrap.min.css">
	<link rel="stylesheet" href="./static/MDBFree/css/style.min.css">
	<link rel="stylesheet" href="./static/MDBFree/css/mdb.min.css">
	<link rel="stylesheet" type="text/css" href="./static/site/css/styles.css" />
	
	<link rel="stylesheet" type="text/css" href="./static/flagship_css/evaluation.css" />
	<link rel="stylesheet" href="./KVRF/chartist-js-master/dist/chartist.min.css">
	<script src="./KVRF/chartist-js-master/dist/chartist.min.js"></script>
</head>
<body>	
	<div id="top-header" style="top:39px; left:600px;">
		<div id="company-logo">
			<h1><img src="./static/site/images/logo-1.png" alt="BIZZ GROUP" id="logo" style="position:relative; right:65%;"/></h1>
		</div>
		<ul id="main-navigation">
			<li><a href="/CSP">홈</a></li>
			<li><a href="/CSP/ProductInfo">제품소개</a></li>
			<li class="active"><a href="/CSP/ResultEvaluationHome">수술 평가</a></li>
			<li><a href="/CSP/CoachingBoard/CoachingBoardListHome">코칭 커뮤니티</a></li>
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

	<div id="os_eval_mother" class="os_eval_mother">
		<div id="os_eval_common_main" class="os_eval_common_main">
			<div id="os_eval_common_title" class="os_eval_common_title">
				<div class="view view-cascade py-3 gradient-card-header info-color-dark">
					<h5 class="mb-0">일반 정보</h5>
				</div>
			</div>
			<div id="os_eval_common_table" class="os_eval_common_table">
				<table class="table">
					<thead>
						<tr>
							<th scope="col"></th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<tr><td><h6>실습 날짜</td><td>${map.date}</h6></td></tr>
						<tr><td><h6>실습 횟수</td><td>${map.ActionCount}</h6></td></tr>
						<tr><td><h6>총 점수</td><td>${map.totalScore}</h6></td></tr>
						<tr><td><h6>raw file</td><td><a href="/CSP/EvalOS_RawDown?os_raw_id=${map.ID}">${map.file_name}</a></h6></td></tr>
					</tbody>
				</table>
			</div>
		</div>
	
		<div id="femur_neck_cutting_main" class="femur_neck_cutting_main">
			<div id="femur_neck_cutting_title" class="femur_neck_cutting_title">
				<div class="view view-cascade py-3 gradient-card-header info-color-dark">
					<h5 class="mb-0">1. Femur neck cutting</h5>
				</div>
			</div>
		
			<div id="femur_neck_cutting_table" class="femur_neck_cutting_table">
				<table class="table">
					<thead>
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
							<td>거리1(d)</td>
							<td>5mm</td>
							<td>${map.hip01_distance}</td>
							<td>${map.hip01_distanceScore}/5</td>
							<td rowspan="4"></td>
							<td rowspan="4">${map.hip01Score}/20</td>
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
					</tbody>
				</table>
			</div>
		
			<div class="femur_neck_cutting_graph_caption">
				<div class="femur_neck_cutting_graph_caption one">Ax</div>
				<div class="femur_neck_cutting_graph_caption two">Az</div>
				<div class="femur_neck_cutting_graph_caption three">Bx</div>
				<div class="femur_neck_cutting_graph_caption four">Bz</div>
			</div>
		
			<div id="femur_neck_cutting_graph" class="femur_neck_cutting_graph">
				<div class="ct-chart ct-golden-section" id="chart1"></div>
				<script>
					var pin_cnt = ${map.hip01_pinCountAx}; 
					var pin_cnts = [];
					for(i=0; i<pin_cnt; i++){
						pin_cnts.push(i);
					}
						
					new Chartist.Line('#chart1', {
					    labels: pin_cnts,
					    series: [${map.hip01_graphAx}, ${map.hip01_graphAz}, ${map.hip01_graphBx}, ${map.hip01_graphBz}],
					  });
				</script>
			</div>
		
			<div id="femur_neck_cutting_img" class="femur_neck_cutting_img">
				<img src="./static/flagship_img/neck_cutting_1.png" style="width:250px; height:450px;">
			</div>
		
			<div id="femur_neck_cutting_img2" class="femur_neck_cutting_img2">
				<img src="./static/flagship_img/neck_cutting_2.png" style="width:500px; height:300px;">
			</div>
		</div>
		
		<div id="acetabulum_reaming_main" class="acetabulum_reaming_main">
			<div id="acetabulum_reaming_title" class="acetabulum_reaming_title">
				<div class="view view-cascade py-3 gradient-card-header info-color-dark">
					<h5 class="mb-0">2. Acetabulum Reaming</h5>
				</div>
			</div>
			
			<div id="acetabulum_reaming_table" class="acetabulum_reaming_table">
				<table class="table">
					<thead>
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
							<td>거리1</td>
							<td>5mm</td>
							<td>${map.hip02_cupDiatance}</td>
							<td>${map.hip02_distance_score}/5</td>
							<td rowspan="3"></td>
							<td rowspan="3">${map.hip02_ResScore}/25</td>
						</tr>
						<tr>
							<td>각도1</td>
							<td>40</td>
							<td></td>
							<td>${map.hip02_degree_score1}/10</td>
						</tr>
						<tr>
							<td>각도2</td>
							<td>15</td>
							<td></td>
							<td>${map.hip02_degree_score1}/10</td>
						</tr>
					</tbody>
				</table>
			</div>
			
			<div class="acetabulum_reaming_graph_caption">
				<div class="acetabulum_reaming_graph_caption one">PointsX</div>
				<div class="acetabulum_reaming_graph_caption two">PointsY</div>
				<div class="acetabulum_reaming_graph_caption three">PointsZ</div>
			</div>
			
			<div id="acetabulum_reaming_graph" class="acetabulum_reaming_graph">
				<div class="ct-chart ct-golden-section" id="chart2"></div>
				<script>
					var pointsXArr = ${map.hip02_pointsX};
					var pointsXCnt = [];
					for(i=0; i<pointsXArr.length; i++){
						pointsXCnt.push(i);
					}
					
					new Chartist.Line('#chart2', {
				    labels: pointsXCnt, 
				    series: [${map.hip02_pointsX}, ${map.hip02_pointsY}, ${map.hip02_pointsZ}]
				  });
				</script>
			</div>
			
			<div id="acetabulum_reaming_img" class="acetabulum_reaming_img">
				<img src="./static/flagship_img/acetabulum_reaming_1.png" style="width:350px; height:350px;">
			</div>
		
			<div id="acetabulum_reaming_img2" class="acetabulum_reaming_img2">
				<img src="./static/flagship_img/acetabulum_reaming_2.png" style="width:500px; height:300px;">
			</div>
		</div>
		
		<div id="cup_insertion_main" class="cup_insertion_main">
			<div id="cup_insertion_title" class="cup_insertion_title">
				<div class="view view-cascade py-3 gradient-card-header info-color-dark">
					<h5 class="mb-0">3. Cup Insertion</h5>
				</div>
			</div>
			
			<div id="cup_insertion_table" class="cup_insertion_table">
				<table class="table">
					<thead>
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
							<td>각도1</td>
							<td>40</td>
							<td>${map.hip03_cupDiatance}</td>
							<td>${map.hip03_score1}/5</td>
							<td rowspan="2"></td>
							<td rowsapn="2">${map.hip03_ResScore}/10</td>
						</tr>
						<tr>
							<td>각도2</td>
							<td>15</td>
							<td>${map.hip03_cupRotation}</td>
							<td>${map.hip03_score2}/5</td>
						</tr>
					</tbody>
				</table>
			</div>
			
			<div id="cup_insertion_img" class="cup_insertion_img">
				<img src="./static/flagship_img/acetabulum_reaming_1.png" style="width:350px; height:350px;">
			</div>
		
			<div id="cup_insertion_img2" class="cup_insertion_img2">
				<img src="./static/flagship_img/acetabulum_reaming_2.png" style="width:500px; height:300px;">
			</div>
		</div>
		
		<div id="box_chisel_main" class="box_chisel_main">
			<div id="box_chisel_title" class="box_chisel_title">
				<div class="view view-cascade py-3 gradient-card-header info-color-dark">
					<h5 class="mb-0">4. Box chisel</h5>
				</div>
			</div>
			
			<div id="box_chisel_table" class="box_chisel_table">
				<table class="table">
					<thead>
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
							<td>거리1</td>
							<td>5mm</td>
							<td>${map.hip04_entryPointDiatance}</td>
							<td>${map.hip04_score1}/5</td>
							<td rowspan="3"></td>
							<td rowspan="3">${map.hip04_ResScore}/15</td>
						</tr>
						<tr>
							<td>각도1</td>
							<td>15</td>
							<td></td>
							<td>${map.hip04_score2}/5</td>
						</tr>
						<tr>
							<td>각도2</td>
							<td>0</td>
							<td></td>
							<td>${map.hip04_score3}/5</td>
						</tr>
					</tbody>
				</table>
			</div>
			
			<div class="box_chisel_graph_caption">
				<div class="box_chisel_graph_caption one">X</div>
				<div class="box_chisel_graph_caption two">Y</div>
				<div class="box_chisel_graph_caption three">Z</div>
			</div>
			
			<div id="box_chisel_graph" class="box_chisel_graph">
				<div class="ct-chart ct-golden-section" id="chart3"></div>
				<script>
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
					
					new Chartist.Line('#chart3', {
					    labels: hip04_points_labels,
					    series: [hip04_x_arr, hip04_y_arr, hip04_z_arr]
					  });
				</script>
			</div>
			
			<div id="box_chisel_img" class="box_chisel_img">
				<img src="./static/flagship_img/box_chisel_img.png" style="width:360px; height:180px;">
			</div>
		
			<div id="box_chisel_img2" class="box_chisel_img2">
				<img src="./static/flagship_img/box_chisel_img2.png" style="width:440px; height:280px;">
			</div>
		</div>
		
		<div id="trail_stem_main" class="trail_stem_main">
			<div id="trail_stem_title" class="trail_stem_title">
				<div class="view view-cascade py-3 gradient-card-header info-color-dark">
					<h5 class="mb-0">5. Trail stem</h5>
				</div>
			</div>
			
			<div id="trail_stem_table" class="trail_stem_table">
				<table class="table">
					<thead>
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
							<td>거리1</td>
							<td>0mm</td>
							<td>${map.hip05_entryPointDiatance}</td>
							<td>/10</td>
							<td rowspan="3"></td>
							<td rowspan="3">/25</td>
						</tr>
						<tr>
							<td>각도1</td>
							<td>15</td>
							<td></td>
							<td>/5</td>
						</tr>
						<tr>
							<td>각도2</td>
							<td>0</td>
							<td></td>
							<td>/5</td>
						</tr>
					</tbody>
				</table>
			</div>
			
			<div class="trail_stem_graph_caption">
				<div class="trail_stem_graph_caption one">X</div>
				<div class="trail_stem_graph_caption two">Y</div>
				<div class="trail_stem_graph_caption three">Z</div>
			</div>
			
			<div id="trail_stem_graph" class="trail_stem_graph">
				<div class="ct-chart ct-golden-section" id="chart4"></div>
				<script>
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
				
				new Chartist.Line('#chart4', {
				    labels: hip05_points_labels,
				    series: [hip05_x_arr, hip05_y_arr, hip05_z_arr]
				  });
				</script>
			</div>
			
			<div id="trail_stem_img" class="trail_stem_img">
				<img src="./static/flagship_img/box_chisel_img.png" style="width:360px; height:180px;">
			</div>
		
			<div id="trail_stem_img2" class="trail_stem_img2">
				<img src="./static/flagship_img/box_chisel_img2.png" style="width:440px; height:280px;">
			</div>
		</div>
		
		<div id="real_stem_main" class="real_stem_main">
			<div id="real_stem_title" class="real_stem_title">
				<div class="view view-cascade py-3 gradient-card-header info-color-dark">
					<h5 class="mb-0">6. Real stem</h5>
				</div>
			</div>
			
			<div id="real_stem_table" class="real_stem_table">
				<table class="table">
					<thead>
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
							<td>거리1</td>
							<td>0mm</td>
							<td></td>
							<td>/10</td>
							<td rowspan="3"></td>
							<td rowspan="3">/25</td>
						</tr>
						<tr>
							<td>각도1</td>
							<td>15</td>
							<td></td>
							<td>/5</td>
						</tr>
						<tr>
							<td>각도2</td>
							<td>0</td>
							<td></td>
							<td>/5</td>
						</tr>
					</tbody>
				</table>
			</div>
			
			<div class="real_stem_graph_caption">
				<div class="real_stem_graph_caption one">X</div>
				<div class="real_stem_graph_caption two">Y</div>
				<div class="real_stem_graph_caption three">Z</div>
			</div>
			
			<div id="real_stem_graph" class="real_stem_graph">
				<div class="ct-chart ct-golden-section" id="chart5"></div>
				<script>
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
				
				new Chartist.Line('#chart5', {
				    labels: hip06_points_labels,
				    series: [hip06_x_arr, hip06_y_arr, hip06_z_arr]
				  });
				</script>
			</div>
			
			<div id="real_stem_img" class="real_stem_img">
				<img src="./static/flagship_img/box_chisel_img.png" style="width:360px; height:180px;">
			</div>
		
			<div id="real_stem_img2" class="real_stem_img2">
				<img src="./static/flagship_img/box_chisel_img2.png" style="width:440px; height:280px;">
			</div>
		</div>
		
		<div id="final_result_main" class="final_result_main">
			<div id="final_result_title" class="final_result_title">
				<div class="view view-cascade py-3 gradient-card-header info-color-dark">
					<h5 class="mb-0">7. Final Result</h5>
				</div>
			</div>
			
			<div id="final_result_table" class="final_result_table">
				<table class="table">
					<thead>
						<tr>
							<th scope="col"  colspan="2">단계</th>
							<th scope="col">평가항목</th>
							<th scope="col">수치</th>
							<th scope="col">결과</th>
							<th scope="col">점수/배점</th>
							<th scope="col">Total</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td rowspan="4">1</td>
							<td rowspan="4">Femur neck cutting</td>
							<td>거리1</td>
							<td>5mm</td>
							<td>${map.hip01_distance}</td>
							<td>${map.hip01_distanceScore}/5</td>
							<td rowspan="4">${map.hip01Score}</td>
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
							<td rowspan="3">2</td>
							<td rowspan="3">Acetabulum Reaming</td>
							<td>거리1</td>
							<td>10mm</td>
							<td>10mm</td>
							<td>2/5</td>
							<td rowspan="3">20</td>
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
							<td rowspan="2">3</td>
							<td rowspan="2">Cup</td>
							<td>각도1</td>
							<td>40</td>
							<td>40</td>
							<td>2/5</td>
							<td rowspan="2">20</td>
						</tr>
						<tr>
							<td>각도2</td>
							<td>15</td>
							<td>15</td>
							<td>5/5</td>
						</tr>
						
						<tr>
							<td rowspan="3">4</td>
							<td rowspan="3">Box chisel</td>
							<td>거리1</td>
							<td>10mm</td>
							<td>10mm</td>
							<td>2/5</td>
							<td rowspan="3">20</td>
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
							<td rowspan="2">5</td>
							<td rowspan="2">Trail stem</td>
							<td>각도1</td>
							<td>40</td>
							<td>40</td>
							<td>2/5</td>
							<td rowspan="2">20</td>
						</tr>
						<tr>
							<td>각도2</td>
							<td>15</td>
							<td>15</td>
							<td>5/5</td>
						</tr>
						
						<tr>
							<td rowspan="2">6</td>
							<td rowspan="2">Real stem</td>
							<td>각도1</td>
							<td>40</td>
							<td>40</td>
							<td>2/5</td>
							<td rowspan="2">20</td>
						</tr>
						<tr>
							<td>각도2</td>
							<td>15</td>
							<td>15</td>
							<td>5/5</td>
						</tr>
						
						<tr>
							<td></td>
							<td>Total</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>100</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	
</body>
</html>
-->