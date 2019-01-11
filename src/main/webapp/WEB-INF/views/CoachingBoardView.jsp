<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

<!doctype html>
<html lang="ko">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
      
    <title>코칭 커뮤니티</title>

    <!-- Bootstrap core CSS -->
    <link href="../KVRF/final/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="../KVRF/final/css/style.css" rel="stylesheet">
      
    <!--fontawesome--->
    <script src="https://use.fontawesome.com/6cf989a115.js"></script>

      
      <link type="text/css" rel="stylesheet" href="../KVRF/final/css/bcPicker.css"/>
		<script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
		<script type="text/javascript" src="../KVRF/final/js/bcPicker.js"></script>
  </head>

  <body>
    <!--- 상단헤더 --->
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
    <!--- 상단헤더 끝 --->
    <!--- 메인 --->
    <main role="main">
      <section class="sub-visual coaching">
        <div class="container">
          <h1 class="main-visual-heading mb-0">코칭 커뮤니티</h1>
        </div>
      </section>
      <div class="sub-nav-wrap">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 sub-nav-wrap-inner clear-after">
                    <div class="sub-nav-home"><a href="index.html"><i class="fa fa-home"></i></a></div>
                    <div class="sub-nav-list"><h3 class="sub-nav-title">코칭 커뮤니티</h3></div>
                </div>
            </div>
        </div>
      </div>
      <div class="album container-pd">
        <div class="container">
          <div class="row">
              <div class="col-sm-12">
                <div class="board-view">
                    <h5>수술영상</h5>
                    <div class="board-view-info">
                        <span></span>
                        <ul>
                            <li><i class="fa fa-clock-o" aria-hidden="true"></i>2018-12-21</li>
                            <li><i class="fa fa-eye" aria-hidden="true"></i>15</li>
                            <li><i class="fa fa-commenting-o" aria-hidden="true"></i>3</li>
                        </ul>
                    </div>
                    <div class="board-view-contents">
                        <div class="board-view-files">
                            <a href="#" class="b-files"><i class="fa fa-download" aria-hidden="true"></i>파일다운</a>
                        </div>
                        <p>내용</p>
                        <div class="video-container">
                            <video id="v" controls="" loop="" width="100%" class="mx-auto">
                            	<source src="${pageContext.request.contextPath}/assets${dto.fileName}" type="video/mp4">
                            </video>
                        </div>
                    </div>
                    <div class="board-view-comments mt-4">
                        <h6 class="board-view-comments-title">전문가 평가<strong></strong></h6>
                        <div class="board-view-comments-contents mb-4">
                            
                            <div id="listReply"></div>
                            
                            <div class="bvc-btn">
                                <a href="/CSP/DashBoard1?id=${pageContext.request.remoteUser}" class="btn btn-outline-primary btn-sm float-left width120">목록으로</a>
                            </div>
                        </div>
                    </div>
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
      
     <!--color picker--->
      <script type="text/javascript">
            $('#bcPicker1').bcPicker();
            $('#bcPicker2').bcPicker({defaultColor: 'ed1c24'});

            $('.bcPicker-palette').on('click', '.bcPicker-color', function(){
                var color = $(this).css('background-color');
                $(this).parent().parent().next().children().text($.fn.bcPicker.toHex(color));
                $(this).parent().parent().next().next().children().text(color);
            })
        </script>
            <script type="text/javascript">

      var _gaq = _gaq || [];
      _gaq.push(['_setAccount', 'UA-36251023-1']);
      _gaq.push(['_setDomainName', 'jqueryscript.net']);
      _gaq.push(['_trackPageview']);

      (function() {
        var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
        ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
        var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
      })();

    </script>
    <!--color picker end--->
      
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script>window.jQuery || document.write('<script src="../KVRF/final/assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../KVRF/final/assets/js/vendor/popper.min.js"></script>
    <script src="../KVRF/final/js/bootstrap.min.js"></script>
    <script src="../KVRF/final/assets/js/vendor/holder.min.js"></script>
       <script>
            $(window).scroll(function(){
                if ($(window).scrollTop() >= 300) {
                   $('#navbar').addClass('fixed-headers');
                }
                else {
                   $('#navbar').removeClass('fixed-headers');
                }
            });
            
            $(document).ready(function(){
        		listReplyRest("1");	
        		
        		$("#btnList").click(function(){
        			location.href="/CSP/CoachingBoard/CoachingBoardListHome";
        		});
        	
        		$("#btnDelete").click(function(){
        			
        			var bno = $("#bno").val();
        			var id = "${pageContext.request.remoteUser}";
        			var content_type = $("#content_type").val();
        			
        			var param = { "bno":bno, "id":id, "content_type":content_type };
        			
        			$.ajax({
        				type: "post",
        				data: param,
        				url: "/CSP/CoachingBoard/CoachingBoardDelete",
        				success: function(data){
        					console.log(data);
        					location.href="/CSP/CoachingBoard/CoachingBoardList?id=${pageContext.request.remoteUser}&content_type=" + content_type;
        				}
        			});
        		});
        	});
        	
            function listReplyRest(num)
        	{
            	console.log("${path}");
            	
        		$.ajax({
        			type: "get",
        			url: "/CSP/CoachingBoardReply/list/${dto.bno}/" + num,
        			success: function(result){
        				console.log(result);
        				$("#listReply").html(result);
        			},
        			error :	function(request, status, error){
        				console.log(request.responseText);
        			}
        		});	
        	}
        	
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
<html>
<head>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css"> 
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
	<link rel="stylesheet" href="../assets/css/styles.min.css">
	<link rel="stylesheet" type="text/css" href="../static/site/css/styles.css" />
	<link rel="stylesheet" type="text/css" href="../assets/CoachingList/Style.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> 
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글</title>
</head>

<body>
	
	<div id="header">
		<div id="top-header">
			<div id="company-logo">
				<h1><img src="../static/site/images/logo-1.png" alt="BIZZ GROUP" id="logo" /></h1>
			</div>
			<ul id="main-navigation">
				<li><a href="/CSP">홈</a></li>
				<li><a href="#">제품소개</a></li>
				<li><a href="/CSP/ResultEvaluationHome">수술 평가 갤러리</a></li>
				<li class="active"><a href="/CSP/DashBoard1?id=${pageContext.request.remoteUser}">코칭 커뮤니티</a></li>
				<li><a href="#">커뮤니티</a></li>
				<li><a href="contacts.html">제품문의</a></li>
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
	</div>
	
	<c:choose>
		<c:when test="${dto.isshow == 'y'}">
			<div class="container">
				<table class="table table-bordered">
					<tbody>
						<c:url var="downloadUrl" value="/download" />
						<form name="form-inline" action="${downloadUrl}" method="get">
							<tr>
								<th>제목: </th>
								<td>${dto.title}</td>
							</tr>
							<tr>
								<th>내용: </th>
								<td>${dto.content}</td>
							</tr>
							<tr>
								<th>영상파일: </th>
								<td> ${dto.fileName}
								
								</td>
							</tr>
							<tr>
								<th>영상: </th>
								<td> 
									<video id="v" controls loop width="1280" height="720" controls autoplay="autoplay">
										<source src="${pageContext.request.contextPath}/assets${dto.fileName}" type="video/mp4">
									</video>
									
								</td>
							</tr>
							<tr>
								<th>등록일자: </th>
								<td><fmt:formatDate value="${dto.regdate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
							</tr>
							<tr>
								<th>조회수: </th>
								<td>${dto.viewcnt}</td>
							</tr>
							<tr>
								<input type="hidden" id="bno" value="${dto.bno}">
							</tr>
							<tr>
								<input type="hidden" id="content_type" value="${dto.content_type}">
							</tr>
							<tr>
				                <td colspan="2">
				                	<button type="button" id="btnDelete" class="btn btn-info pull-left">삭제</button>
				                 	<button type="button" id="btnList" class="btn btn-primary pull-right">리스트</button>
				                </td>
		           			</tr>
						</form>
					</tbody>
				</table>
			</div>
		</c:when>
	</c:choose>
	    
	
	<div id="dash_line" style="border:none; border:5px double orange;"></div>
	
	<div id="listReply"></div>
	
	<div id="dash_line2" style="border:none; border:5px double orange;"></div>
	
	<script>
	$(document).ready(function(){
		listReplyRest("1");	
		
		$("#btnList").click(function(){
			location.href="${path}/CoachingBoard/CoachingBoardListHome";
		});
	
		$("#btnDelete").click(function(){
			
			var bno = $("#bno").val();
			var id = "${pageContext.request.remoteUser}";
			var content_type = $("#content_type").val();
			
			var param = { "bno":bno, "id":id, "content_type":content_type };
			
			$.ajax({
				type: "post",
				data: param,
				url: "/CSP/CoachingBoard/CoachingBoardDelete",
				success: function(data){
					console.log(data);
					location.href="${path}/CoachingBoard/CoachingBoardList?id=${pageContext.request.remoteUser}&content_type=" + content_type;
				}
			});
		});
		
		// 스트리밍 비디오 캡쳐관련, 단 캡쳐된 이미지를 편집하는 객체와 겹치므로 조화를 잘해야함
		var v = document.getElementById('v');
		var canvas = document.getElementById('coaching_canvas');
		var context = canvas.getContext('2d');
		var back = document.createElement('canvas');
		var backcontext = back.getContext('2d');
		
		// 영상의 사이즈는 태그로 지정된 640, 480 처럼 항상 일정한 사이즈로 정형화해야함
		// 아니면 원본 영상파일의 스타일태그 width, height 로 지정된 사이즈 비율만큼 잘려서 나오고
		// 이는 캔버스사이즈와 영상 사이즈의 크기차이가 발생하게됨.
		var cw, ch;
		v.addEventListener('play', function(){
			cw = v.clientWidth;
			ch = v.clientHeight;
			//console.log(cw + "," + ch);
			canvas.width = cw;
			canvas.height = ch;
			back.width = cw;
			back.height = ch;
			draw(v, context, backcontext, cw, ch);
		}, false);
		
		editable_canvas_ready(context, canvas); // 그림판 처럼 편집가능 캔버스 초기화
	});
	
	
	// 플레이 중인 동영상을 실시간 캡쳐하고 캔버스에 그리는 함수
	function draw(v, c, bc, w, h)
	{
		if(v.paused || v.ended)
			return false;
		bc.drawImage(v, 0, 0, w, h);
		var idata = bc.getImageData(0, 0, w, h);
		var data = idata.data;
		
		idata.data = data;
		c.putImageData(idata, 0, 0);
		setTimeout(function(){ draw(v, c, bc, w, h); }, 0);
	}
	
	// 마우스로 그리는 이벤트 처리, 먼가 오프셋이 안맞음
	function getPosition(mouseEvent, canvas)
	{
		var x, y;
		if(mouseEvent.pageX != undefined && mouseEvent.pageY != undefined){
			x = mouseEvent.pageX;
			y = mouseEvent.pageY;
			var nx = x-canvas.offsetLeft;
			var ny = y-canvas.offsetTop;
			//console.log(x + "," + nx + "," + y + "," + ny);
		}
		else{
			x = mouseEvent.clientX + document.body.scrollLeft + document.documentElement.scrollLeft;
			y = mouseEvent.clientY + document.body.scrollTop + document.documentElement.scrollTop;
			console.log("pageX, pageY undefined");
		}
		return {X: x-canvas.offsetLeft - 560, Y: y-canvas.offsetTop - 310};
		//return {X: x-canvas.offsetLeft, Y:y-canvas.offsetTop};
	}
	
	// 캔버스에 캡쳐되는 이미지를 편집가능하게 하기위해 초기화 하는 함수
	function editable_canvas_ready(context, canvas)
	{
		var is_touch_device = 'ontouchstart' in document.documentElement;
		
		if(is_touch_device){
			// 터치 디바이스는 고려x, 구현방법은 있음
		}
		else{
			$("#coaching_canvas").mousedown(function(mouseEvent){
				var position = getPosition(mouseEvent, canvas);
				context.moveTo(position.X, position.Y);
				context.beginPath();
				
				$(this).mousemove(function(mouseEvent){
					drawLine(mouseEvent, canvas, context);
				}).mouseup(function(mouseEvent){
					finishDrawing(mouseEvent, canvas, context);
				}).mouseout(function(mouseEvent){
					finishDrawing(mouseEvent, canvas, context);
				});
			});
		}
	}
	
	function drawLine(mouseEvent, canvas, context)
	{
		context.strokeStyle = "#FF0000";
		context.lineWidth = 15;
		var position = getPosition(mouseEvent, canvas);
		context.lineTo(position.X, position.Y);
		context.stroke();
	}
	
	function finishDrawing(mouseEvent, canvas, context)
	{
		drawLine(mouseEvent, canvas, context);
		context.closePath();
		$(canvas).unbind("mousemove").unbind("mouseup").unbind("mouseout");
	}
	
	function listReplyRest(num)
	{
		$.ajax({
			type: "get",
			url: "${path}/CoachingBoardReply/list/${dto.bno}/" + num,
			success: function(result){
				//console.log(result);
				$("#listReply").html(result);
			},
			error :	function(request, status, error){
				console.log(request.responseText);
			}
		});	
	}
	
	
	
	</script>
</body>

</html>
-->