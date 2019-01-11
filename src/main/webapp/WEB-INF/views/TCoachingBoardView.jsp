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
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script src="../KVRF/final/js/bcPicker.js"></script> 
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
                            <video id="v" controls="" loop="" width="100%" class="mx-auto" autoplay="autoplay">
                            	<source src="${pageContext.request.contextPath}/assets${dto.fileName}" type="video/mp4">
                            </video>
                            
                            <div class="video-canvas">
	                            <div class="row">
	                                <div class="col-sm-12">
	                                <h6>평가 남기기</h6>
	                                <div class="video-canvas-innner">
	                                    <canvas id="coaching_canvas"></canvas>
	                                </div>
	                                <div class="board-view-comments-content">
	                                    <div class="board-view-comments-txt">
	                                        <textarea placeholder="내용을 입력하세요" class="form-control" id="replytext"></textarea>
	                                        <div class="board-view-comments-content-bottom">
	                                            <div class="color-container">
	                                                <!--  <div id="bcPicker2" class="color-picker display-inline" ></div> -->
	                                                <input type="color" class="color-picker display-inline" id="sel_color name="sel_color" value="#ee0000" onchange="PenColorChange(this.value);">
	                                            </div>
	                                            <div class="stroke-container">
	                                                <span>Stroke</span>
	                                                <div class="customizing">
	                                                    <input type="range" name="points" min="2" max="25" value="15" step="1" onchange="PenWidthChange(this.value);">
	                                                    <!--  <div class="form-range-control"><input type="range" max="25" min="2" value="15" step="1" onchange="PenWidthChange(this.value);"></div> -->
	                                                  </div>
	                                            </div>
	                                            <a href="#" id="coaching_up" onclick="CoachingUp();" class="btn btn-primary btn-sm float-right width120">올리기</a>
	                                        </div>
	                                    </div>
	                                </div>
	                                </div>
	                            </div>
                        	</div>
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
        <input type="hidden" id="bno" class="form-control" value="${dto.bno}" readonly/>
        <input type="hidden" id="replyer" class="form-control" value="${pageContext.request.remoteUser}" readonly/>
        <input type="hidden" id="writer" class="form-control" value="${dto.writer}" readonly/>
        <input type="hidden" id="content_type" class="form-control" value="${dto.content_type}" readonly/>
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
        		
        		// 스트리밍 비디오 캡쳐관련
        		var v = document.getElementById('v');
        		var canvas = document.getElementById('coaching_canvas');
        		var context = canvas.getContext('2d');
        		var back = document.createElement('canvas');
        		var backcontext = back.getContext('2d');
        		
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
        	
        	function CoachingUp()
        	{
    			var canvas = document.getElementById('coaching_canvas');
    			var img_data_url = canvasDataURL(canvas);
    			var blobBin = atob(img_data_url.split(',')[1]);
    			var array = [];
    			for(var i=0; i<blobBin.length; i++){
    				array.push(blobBin.charCodeAt(i));
    			}
    			var file = new Blob([new Uint8Array(array)], {type: 'image/png'});
    			var formData = new FormData();
    			formData.append("file", file);
    			
    			var ajaxReq = $.ajax({
    				url: "/CSP/upload/uploadAjax",
    				type: "post",
    				data: formData,
    				processData: false,
    				contentType: false,
    			});

    			ajaxReq.done(function(msg){
    				var fileInfo = getFileInfo(msg);
    				fileName = fileInfo.fullName;
    				
    				var bno = $("#bno").val();
    				var replytext = $("#replytext").val();
    				var writer = $("#writer").val();
    				var replyer = $("#replyer").val();
    				var content_type = $("#content_type").val();
    				
    				var param = {"bno":bno, "replytext":replytext, "writer": writer, 
    						"replyer": replyer, "fileName":fileName, "content_type":content_type}; 
    				
    				$.ajax({
    					type: "post",
    					url: "/CSP/insertCoaching",
    					data: param,
    					success: function(result){
    						location.reload();	
    					},
    					error :	function(request, status, error){
    						console.log(request.responseText);
    					}
    				});
    			});
    			
    			function getFileInfo(fullName)
    			{
    				var fileName, imgsrc, getLink, fileLink;
    				fileLink = fullName.substr(12);
    				getLink = "/CSP/upload/displayFile?fileName=" + fullName;
    				fileName = fileLink.substr(fileLink.indexOf("_")+1);
    				return {fileName:fileName, imgsrc:imgsrc, getLink:getLink, fullName:fullName};
    			}
    		}
    		
    		
    	// 첨삭펜 칼라체인지 
    	var pen_color_val = "#FF0000";
    	function PenColorChange(color_val)
    	{
    		pen_color_val = color_val
    		//alert(pen_color_val);
    	}
    	
    	// 첨삭펜 굵기변경
    	var pen_width = 15;
    	function PenWidthChange(width_val)
    	{
    		pen_width = width_val;
    	}
    	
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
    	
    	// 캡쳐되고 편집된 캔버스를 이미지 데이터화
    	function canvasDataURL(canvas)
    	{
    		var dataURL = canvas.toDataURL('image/png');
    		return dataURL;
    	}
    	
    	// 마우스로 그리는 이벤트 처리
    	function getPosition(mouseEvent, canvas)
    	{
    		var x, y;
    		if(mouseEvent.pageX != undefined && mouseEvent.pageY != undefined){
    			x = mouseEvent.pageX;
    			y = mouseEvent.pageY;
    			var nx = x-canvas.offsetLeft - 400;
    			var ny = y-canvas.offsetTop-1000;
    		}
    		else{
    			x = mouseEvent.clientX + document.body.scrollLeft + document.documentElement.scrollLeft;
    			y = mouseEvent.clientY + document.body.scrollTop + document.documentElement.scrollTop;
    			console.log("pageX, pageY undefined");
    		}
    		//console.log(x + ":" + y + "/" + canvas.offsetLeft + ":" + canvas.offsetTop);
    		return {X: nx, Y: ny}; // host server offset
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
    		context.strokeStyle = pen_color_val;//"#FF0000";
    		context.lineWidth = pen_width;
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
	
	<link rel="stylesheet" type="text/css" href="../static/flagship_css/tcoaching.css" />
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>게시글</title>
	
	<style>
	.fileDrop {
		width: 100%;;
		height: 50px;
		border: 1px dotted blue;
	}
	
	small {
		margin-left: 3px;
		font-weight: bold;
		color: gray;
	}
</style>
</head>

<body>
	<div id="top-header" style="top:39px; left:600px;">
		<div id="company-logo">
			<h1><img src="../static/site/images/logo-1.png" alt="BIZZ GROUP" id="logo" style="position:relative; right:65%;"/></h1>
		</div>
		<ul id="main-navigation">
			<li ><a href="/CSP">홈</a></li>
			<li><a href="/CSP/ProductInfo">제품소개</a></li>
			<li><a href="/CSP/ResultEvaluationHome">수술 평가</a></li>
			<li class="active"><a href="/CSP/DashBoard1?id=${pageContext.request.remoteUser}">코칭 커뮤니티</a></li>
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
								<input type="submit" value="다운로드" class="btn btn-info pull-right" />
								<input type="hidden" name="filepath" value="${dto.fileName}" />
								</td>
							</tr>
							<tr>
								<th>영상: </th>
								<td> 
									<video id="v" controls loop width="1280" height="720" controls autoplay="autoplay">
										<source src="${pageContext.request.contextPath}/assets${dto.fileName}" type="video/mp4">
									</video>
									<div id="dash_line" style="border:none; border:5px double blue;"></div>
									<form name="coachingForm" id="coachingForm" action="" method="post">
										<canvas id="coaching_canvas" width="1280" height="720"></canvas>
										<div id="dash_line" style="border:none; border:5px double blue;"></div>
										<div id="tc_color_editor" class="tc_color_editor">
											<p>Color Picker 및 선 두께</p>
											<input type="color" id="sel_color name="sel_color" value="#ee0000" onchange="PenColorChange(this.value);">
											<div class="form-range-control"><input type="range" max="25" min="2" value="15" step="1" onchange="PenWidthChange(this.value);"></div>
										</div>
										<textarea rows="10" style="width:100%;" id="replytext" class="form-control"></textarea>
									</form>
								</td>
							</tr>
							<tr>
								<th>no: </th>
								<td><input type="text" style="width:100%;" id="bno" class="form-control" value="${dto.bno}" readonly/></td>
							</tr>
							<tr>
				                <td colspan="2">
				                 	<button type="button" id="coaching_up" class="btn btn-primary pull-right">코치업</button>
				                </td>
		           			</tr>
							<tr>
								<th>작성자: </th>
									<td><input type="text" id="writer" class="form-control" value="${dto.writer}" readonly /></td>
								</tr>
							<tr>
								<th>평가자: </th>
								<td><input type="text" style="width:100%;" id="replyer" class="form-control" value="${pageContext.request.remoteUser}" readonly /></td>
								</tr>
							<tr>
				                <td colspan="2">
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
	
	<div class="container">
		<table class="table table-bordered">
			<tbody>
				<form name="eval_form" id="eval_form" method="post" action="/CSP/CoachingBoardReply/insert">
				</form>
			</tbody>
		</table>
	</div>    
	
	<div id="uploadProgress"></div>
	
	<script>
	$(document).ready(function(){
		
		var fileName;
		
		listReplyRest("1");	
		
		$("#btnList").click(function(){
			location.href="/CSP/CoachingBoard/TCoachingBoardListHome";
		});
		
		$("#coaching_up").click(function(){
			var canvas = document.getElementById('coaching_canvas');
			var img_data_url = canvasDataURL(canvas);
			var blobBin = atob(img_data_url.split(',')[1]);
			var array = [];
			for(var i=0; i<blobBin.length; i++){
				array.push(blobBin.charCodeAt(i));
			}
			var file = new Blob([new Uint8Array(array)], {type: 'image/png'});
			var formData = new FormData();
			formData.append("file", file);
			
			var ajaxReq = $.ajax({
				url: "/CSP/upload/uploadAjax",
				type: "post",
				data: formData,
				processData: false,
				contentType: false,
			});

			ajaxReq.done(function(msg){
				var fileInfo = getFileInfo(msg);
				fileName = fileInfo.fullName;
				
				var bno = $("#bno").val();
				var replytext = $("#replytext").val();
				var writer = $("#writer").val();
				var replyer = $("#replyer").val();
				
				var param = {"bno":bno, "replytext":replytext, "writer": writer, 
						"replyer": replyer, "fileName":fileName, "content_type":"ENTSurgery"}; 
				
				$.ajax({
					type: "post",
					url: "/CSP/insertCoaching",
					data: param,
					success: function(result){
						location.reload();	
					},
					error :	function(request, status, error){
						console.log(request.responseText);
					}
				});
			});
			
			function getFileInfo(fullName)
			{
				var fileName, imgsrc, getLink, fileLink;
				fileLink = fullName.substr(12);
				getLink = "/CSP/upload/displayFile?fileName=" + fullName;
				fileName = fileLink.substr(fileLink.indexOf("_")+1);
				return {fileName:fileName, imgsrc:imgsrc, getLink:getLink, fullName:fullName};
			}
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
	
	// 첨삭펜 칼라체인지 
	var pen_color_val = "#FF0000";
	function PenColorChange(color_val)
	{
		pen_color_val = color_val
		//alert(pen_color_val);
	}
	
	// 첨삭펜 굵기변경
	var pen_width = 15;
	function PenWidthChange(width_val)
	{
		pen_width = width_val;
	}
	
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
	
	// 캡쳐되고 편집된 캔버스를 이미지 데이터화
	function canvasDataURL(canvas)
	{
		var dataURL = canvas.toDataURL('image/png');
		return dataURL;
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
		// 왠지 모르겠지만 디플로이 서버와 width offset이 211 정도차이남
		//return {X: x-canvas.offsetLeft - 540, Y: y-canvas.offsetTop - 380}; // host server offset
		return {X: x-canvas.offsetLeft - 434, Y: y-canvas.offsetTop - 380}; // host server offset
		//return {X: x-canvas.offsetLeft - 329, Y: y-canvas.offsetTop - 380}; // host server offset
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
		context.strokeStyle = pen_color_val;//"#FF0000";
		context.lineWidth = pen_width;
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
	</script>
</body>
</html>
-->