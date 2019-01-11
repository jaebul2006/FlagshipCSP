<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" href="images/favicon.ico" type="image/ico" />

    <title>코칭 대시보드  </title>

    <!-- Bootstrap -->
    <link href="../CSP/dashboard/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../CSP/dashboard/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../CSP/dashboard/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../CSP/dashboard/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
	
    <!-- bootstrap-progressbar -->
    <link href="../CSP/dashboard/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- JQVMap -->
    <link href="../CSP/dashboard/vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet"/>
    <!-- bootstrap-daterangepicker -->
    <link href="../CSP/dashboard/vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <!--  <link href="../CSP/dashboard/build/css/custom.min.css" rel="stylesheet"> -->
    <link href="../CSP/dashboard/build/css/custom.css" rel="stylesheet">
  
  
  	<script>
	  	$(document).ready(function(){
			
		});
	</script>
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="/CSP" class="site_title"><i class="fa fa-home"></i> <span>Main</span></a>
            </div>

            <div class="clearfix"></div> 

            <!-- menu profile quick info -->
            <div class="profile clearfix">
              <div class="profile_pic">
                <img src="../CSP/dashboard/production/images/user.png" alt="..." class="img-circle profile_img">
              </div>
              <div class="profile_info">
                <span>안녕하세요,</span>
                <c:choose>
					<c:when test="${session_login != null}">
						<h2><c:out value="${pageContext.request.remoteUser}"/></h2>
					</c:when>
				</c:choose>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-bar-chart-o"></i> 평가 시스템 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a id="ENTSurgery" href="/CSP/ResultEvaluationHome">TSA 수술</a></li>
                      <li><a id="HipSurgery" href="/CSP/ResultEvaluationHome">OS 수슬</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-edit"></i> 코칭 커뮤니티 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      
                      <!--  <li><a href="/CSP/CoachingBoard/CoachingBoardList?id=${pageContext.request.remoteUser}">업로드 게시판</a></li> -->
                      <li><a href="/CSP/CoachingBoard/CoachingBoardListHome">TSA 코칭</a></li>	
                      	
                      <!--  <li><a href="form_advanced.html">Advanced Components</a></li>
                      <li><a href="form_validation.html">Form Validation</a></li>
                      <li><a href="form_wizards.html">Form Wizard</a></li>
                      <li><a href="form_upload.html">Form Upload</a></li>
                      <li><a href="form_buttons.html">Form Buttons</a></li> -->
                    </ul>
                  </li>
                  <li><a><i class="fa fa-desktop"></i> UI Elements <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="general_elements.html">General Elements</a></li>
                      <li><a href="media_gallery.html">Media Gallery</a></li>
                      <li><a href="typography.html">Typography</a></li>
                      <li><a href="icons.html">Icons</a></li>
                      <li><a href="glyphicons.html">Glyphicons</a></li>
                      <li><a href="widgets.html">Widgets</a></li>
                      <li><a href="invoice.html">Invoice</a></li>
                      <li><a href="inbox.html">Inbox</a></li>
                      <li><a href="calendar.html">Calendar</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-table"></i> Tables <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="tables.html">Tables</a></li>
                      <li><a href="tables_dynamic.html">Table Dynamic</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-bar-chart-o"></i> Data Presentation <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="chartjs.html">Chart JS</a></li>
                      <li><a href="chartjs2.html">Chart JS2</a></li>
                      <li><a href="morisjs.html">Moris JS</a></li>
                      <li><a href="echarts.html">ECharts</a></li>
                      <li><a href="other_charts.html">Other Charts</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-clone"></i>Layouts <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="fixed_sidebar.html">Fixed Sidebar</a></li>
                      <li><a href="fixed_footer.html">Fixed Footer</a></li>
                    </ul>
                  </li>
                </ul>
              </div>
              <div class="menu_section">
                <h3>Live On</h3>
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-bug"></i> Additional Pages <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="e_commerce.html">E-commerce</a></li>
                      <li><a href="projects.html">Projects</a></li>
                      <li><a href="project_detail.html">Project Detail</a></li>
                      <li><a href="contacts.html">Contacts</a></li>
                      <li><a href="profile.html">Profile</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-windows"></i> Extras <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="page_403.html">403 Error</a></li>
                      <li><a href="page_404.html">404 Error</a></li>
                      <li><a href="page_500.html">500 Error</a></li>
                      <li><a href="plain_page.html">Plain Page</a></li>
                      <li><a href="login.html">Login Page</a></li>
                      <li><a href="pricing_tables.html">Pricing Tables</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-sitemap"></i> Multilevel Menu <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                        <li><a href="#level1_1">Level One</a>
                        <li><a>Level One<span class="fa fa-chevron-down"></span></a>
                          <ul class="nav child_menu">
                            <li class="sub_menu"><a href="level2.html">Level Two</a>
                            </li>
                            <li><a href="#level2_1">Level Two</a>
                            </li>
                            <li><a href="#level2_2">Level Two</a>
                            </li>
                          </ul>
                        </li>
                        <li><a href="#level1_2">Level One</a>
                        </li>
                    </ul>
                  </li>                  
                  <li><a href="javascript:void(0)"><i class="fa fa-laptop"></i> Landing Page <span class="label label-success pull-right">Coming Soon</span></a></li>
                </ul>
              </div>
            </div>

            <div class="sidebar-footer hidden-small">
              <a data-toggle="tooltip" data-placement="top" title="Settings">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Lock">
                <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Logout" href="login.html">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
              </a>
            </div>
          </div>
        </div>

        <div class="top_nav">
          <div class="nav_menu">
			<nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>
            </nav> 
          </div>
        </div>

        
        <div class="right_col" role="main">  
          <div class="col-md-3">
			<div class="card">
				<img class="card-img-top" src="./assets/img/HipTitle.png">
				<div class="card-block">
					<h4 class="card-title mt-3">2018-01-01</h4>
				</div>
				<div class="card-text">총점수: 99</div>
				<div class="card-text">수술횟수: 12</div>
					<div class="card-footer">
						<button class="btn btn-secondary btn-sm" onclick="#">결과상세</button>
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
		          
        <footer>
          <div class="pull-right">
            
          </div>
          <div class="clearfix"></div>
        </footer>
        
      </div>
      
    </div>

    <!-- jQuery -->
    <script src="../CSP/dashboard/vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="../CSP/dashboard/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="../CSP/dashboard/vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="../CSP/dashboard/vendors/nprogress/nprogress.js"></script>
    <!-- Chart.js -->
    <script src="../CSP/dashboard/vendors/Chart.js/dist/Chart.min.js"></script>
    <!-- gauge.js -->
    <script src="../CSP/dashboard/vendors/gauge.js/dist/gauge.min.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="../CSP/dashboard/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    <!-- iCheck -->
    <script src="../CSP/dashboard/vendors/iCheck/icheck.min.js"></script>
    <!-- Skycons -->
    <script src="../CSP/dashboard/vendors/skycons/skycons.js"></script>
    <!-- Flot -->
    <script src="../CSP/dashboard/vendors/Flot/jquery.flot.js"></script>
    <script src="../CSP/dashboard/vendors/Flot/jquery.flot.pie.js"></script>
    <script src="../CSP/dashboard/vendors/Flot/jquery.flot.time.js"></script>
    <script src="../CSP/dashboard/vendors/Flot/jquery.flot.stack.js"></script>
    
    <!-- 현재 아래의 리사이즈 기능이 문제가 있음. 스크롤이 계속 늘어나는 현상 -->
    <!--  <script src="../CSP/dashboard/vendors/Flot/jquery.flot.resize.js"></script> -->
    
    
    <!-- Flot plugins -->
    <script src="../CSP/dashboard/vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
    <script src="../CSP/dashboard/vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
    <script src="../CSP/dashboard/vendors/flot.curvedlines/curvedLines.js"></script>
    <!-- DateJS -->
    <script src="../CSP/dashboard/vendors/DateJS/build/date.js"></script>
    <!-- JQVMap -->
    <script src="../CSP/dashboard/vendors/jqvmap/dist/jquery.vmap.js"></script>
    <script src="../CSP/dashboard/vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
    <script src="../CSP/dashboard/vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="../CSP/dashboard/vendors/moment/min/moment.min.js"></script>
    <script src="../CSP/dashboard/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>

    <!-- Custom Theme Scripts -->
    <!--  <script src="../CSP/dashboard/build/js/custom.min.js"></script> -->
	<script src="../CSP/dashboard/build/js/custom.js"></script> 
	
		
	
  </body>
</html>
