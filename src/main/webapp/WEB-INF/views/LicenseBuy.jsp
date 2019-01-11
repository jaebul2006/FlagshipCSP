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

        <title>라이센스 구매</title>
        <link href="./KVRF/final/css/bootstrap.min.css" rel="stylesheet">
        <link href="./KVRF/final/css/style.css" rel="stylesheet">
        <script src="https://use.fontawesome.com/6cf989a115.js"></script>
        <script type="text/javascript" src="./static/site/js/jquery/jquery-1.4.2.min.js"></script>
        <script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
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
                            <a class="nav-link" href="/CSP">홈</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/CSP/Product">제품소개</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">커뮤니티</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="/CSP/LicenseBuy">라이센스 구매<span class="sr-only">(current)</span></a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <main role="main">
            <section class="sub-visual license">
                <div class="container">
                    <h1 class="main-visual-heading mb-0">라이센스 구매</h1>
                </div>
            </section>
            <div class="sub-nav-wrap bg-light-blue">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12 sub-nav-wrap-inner clear-after">
                            <div class="sub-nav-home"><a href="index.html"><i class="fa fa-home"></i></a></div>
                            <div class="sub-nav-list">
                                <h3 class="sub-nav-title">라이센스 구매</h3>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="album container-pd">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12 text-center mb-5">
                            <span class="title-sm">나에게 적합한 라이센스를 통해 다양한 수술을 반복적으로 경험할 수 있습니다.</span>
                        </div>
                        <div class="col-md-6">
                            <div class="card flex-md-row mb-4 shadow-sm h-md-250">
                                <img class="card-img-right flex-auto d-none d-lg-block" alt="Thumbnail [200x250]" style="width:250px; height: 200px;" src="./KVRF/final/images/lc_01.jpg">
                                <div class="card-body d-flex flex-column align-items-start">
                                    <strong class="d-inline-block mb-2 text-primary">초급</strong>
                                    <h5 class="mb-3">
                                        이비인후과 종양 제거 수술
                                    </h5>
                                    <p class="card-text mb-auto">이비인후과 종양 제거 수술<br> 초급용 라이센스입니다.</p>
                                    <a href="#" class="btn btn-primary btn-sm float-right width120" id="BtnENTLicense" onclick="BuyLicense('${pageContext.request.remoteUser}', 'ENTLicense', '1100');">구매하기</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="card flex-md-row mb-4 shadow-sm h-md-250">
                                <img class="card-img-right flex-auto d-none d-lg-block" alt="Thumbnail [200x250]" style="width:250px; height: 200px;" src="./KVRF/final/images/lc_02.jpg">
                                <div class="card-body d-flex flex-column align-items-start">
                                    <strong class="d-inline-block mb-2 text-primary">초급</strong>
                                    <h5 class="mb-3">
                                        고관절 치환 수술
                                    </h5>
                                    <p class="card-text mb-auto">고관절 치환 수술<br> 초급용 라이센스입니다.</p>
                                    <a href="#" class="btn btn-primary btn-sm float-right width120" id="BtnHipLicense" onclick="BuyLicense('${pageContext.request.remoteUser}', 'HipLicense', '1200')">구매하기</a>
                                </div>
                            </div>
                        </div>
                       <div class="col-md-6">
                            <div class="card flex-md-row mb-4 shadow-sm h-md-250">
                                <img class="card-img-right flex-auto d-none d-lg-block" alt="Thumbnail [200x250]" style="width:250px; height: 200px;" src="./KVRF/final/images/lc_01.jpg">
                                <div class="card-body d-flex flex-column align-items-start">
                                    <strong class="d-inline-block mb-2 text-success">중급</strong>
                                    <h5 class="mb-3 md-color">
                                        이비인후과 종양 제거 수술
                                    </h5>
                                    <p class="card-text mb-auto">이비인후과 종양 제거 수술<br> 중급용 라이센스입니다.</p>
                                    <a href="#" class="btn btn-primary btn-sm float-right width120" id="BtnENTLicense" onclick="BuyLicense('${pageContext.request.remoteUser}', 'ENTLicense', '1100');">구매하기</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="card flex-md-row mb-4 shadow-sm h-md-250">
                                <img class="card-img-right flex-auto d-none d-lg-block" alt="Thumbnail [200x250]" style="width:250px; height: 200px;" src="./KVRF/final/images/lc_02.jpg">
                                <div class="card-body d-flex flex-column align-items-start">
                                    <strong class="d-inline-block mb-2 text-success">중급</strong>
                                    <h5 class="mb-3">
                                        고관절 치환 수술
                                    </h5>
                                    <p class="card-text mb-auto">고관절 치환 수술<br> 중급용 라이센스입니다.</p>
                                    <a href="#" class="btn btn-primary btn-sm float-right width120" id="BtnHipLicense" onclick="BuyLicense('${pageContext.request.remoteUser}', 'HipLicense', '1200')">구매하기</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <footer class="text-muted">
            <div class="container">
                <p class="text-white text-center">ⓒ Solideng all rights reserved.</p>
            </div>
        </footer>

        <script>
        
        </script>
        <script src="./KVRF/final/assets/js/vendor/popper.min.js"></script>
        <script src="./KVRF/final/js/bootstrap.min.js"></script>
        <script src="./KVRF/final/assets/js/vendor/holder.min.js"></script>
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
        
        $(document).ready(function(){	
			IMP.init('imp98200547'); // 가맹점 식별코드
			
			// 해당 계정의 라이센스 상태 DB로 부터 가져오기
			CheckLicense("${pageContext.request.remoteUser}");
			//console.log("${pageContext.request.remoteUser}");
		});
        
        function BuyLicense(user_id, content, price)
		{
			IMP.request_pay({
			    pg : 'inicis', // version 1.1.0부터 지원.
			    pay_method : 'card',
			    merchant_uid : 'merchant_' + new Date().getTime(),
			    name : '주문명:' + content + '(결제테스트)',
			    amount : price,
			    buyer_email : 'jaebul2006@naver.com',
			    buyer_name : user_id,
			    buyer_tel : '010-1234-5678',
			    buyer_addr : '인천광역시 연수구 송도동',
			    buyer_postcode : '123-456',
			    m_redirect_url : ''
			}, function(rsp) {
			    if ( rsp.success ) {
			        var msg = '결제가 완료되었습니다.';
			        msg += '고유ID : ' + rsp.imp_uid;
			        msg += '상점 거래ID : ' + rsp.merchant_uid;
			        msg += '결제 금액 : ' + rsp.paid_amount;
			        msg += '카드 승인번호 : ' + rsp.apply_num;
			        // 가맹점 서버와 고유ID로 유효결제 검증체크는 일단 뒤로
			        // DB 에 정보 반영
			        RegistLicense(user_id, content, rsp.imp_uid, rsp.merchant_uid, rsp.paid_amount, rsp.apply_num);
			    } else {
			        var msg = '결제에 실패하였습니다.';
			        msg += '에러내용 : ' + rsp.error_msg;
			    }
			    alert(msg);
			});
		}
		
		// 서버에 라이센스 구매 등록
		function RegistLicense(user_id, content, imp_uid, merchant_uid, paid_amount, apply_num)
		{
			var license_param = {"user_id":user_id, "content":content, "imp_uid": imp_uid, "merchant_uid": merchant_uid,
					"paid_amount": paid_amount, "apply_num":apply_num};
			
			$.ajax({
				type: "post",
				url: "/CSP/registLicense",
				data: license_param,
				success: function(result){
					console.log(result);
				},
				error :	function(request, status, error){
					console.log(request.responseText);
				}
			});
		}
		
		// 유저의 라이센스 체크
		function CheckLicense(user_id)
		{
			var license_param = {"user_id": user_id};
			$.ajax({
				type: "get",
				url: "/CSP/checkLicense",
				data: license_param,
				success: function(result){
					//console.log(result);
					LicenseUI(result); // 라이센스 가지고있는 목록에 따라 UI 활성화 비활성화
				},
				error :	function(request, status, error){
					console.log(request.responseText);
				}
			});
		}
		
		function LicenseUI(license_list)
		{
			//console.log(license_list);
			
			if(license_list.length < 1)
				return;
			
			for(i=0; i<license_list.length; i++){
				console.log(license_list[i]);
				if(license_list[i].content === "ENTLicense"){
					document.getElementById("BtnENTLicense").innerText = "구매완료";
					//document.getElementById("ENTSurgeryLicensePrice").innerText = "이미 구매함";
					//document.getElementById("BtnENTLicense").style.display = "none";
				}
				else if(license_list[i].content === "HipLicense"){
					document.getElementById("BtnHipLicense").innerText = "구매완료";
					//document.getElementById("HipSurgeryLicensePrice").innerText = "이미 구매함";
					//document.getElementById("BtnHipLicense").style.display = "none";
				}
			}
		}
        </script>
    </body>
</html>



<!--  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Flagship CSP</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="./static/site/css/styles.css" />

<script type="text/javascript" src="./static/site/js/jquery/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>

</head>

<body>	
<div id="header">
	<div id="top-header">
		<div id="company-logo">
			<h1><img src="./static/site/images/logo-1.png" alt="BIZZ GROUP" id="logo" style="position:relative; right:65%;"/></h1>
		</div>
		<ul id="main-navigation">
			<li><a href="/CSP">홈</a></li>
			<li><a href="/CSP/ProductInfo">제품소개</a></li>
			<li><a href="/CSP/ResultEvaluationHome">수술 평가 갤러리</a></li>
			<li><a href="/CSP/DashBoard1?id=${pageContext.request.remoteUser}">코칭 대시보드</a></li>
			<li><a href="#">커뮤니티</a></li>
			<li class="active"><a href="/CSP/LicenseBuy">라이센스구매</a></li>
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
	
<div id="content">
	<div class="wide-wrapper">
		<div class="content-container">
			<div class="clear"></div>
		</div>
	</div>
	<div class="content-container middle-side">
		<div class="info-box">
			<h4>이비인후과 <br>종양 제거 수술</h4>
			<div class="align-content">
				<p><img src="./assets/img/surgical1.JPG" class="photo" alt="" /></p>
				<p id="ENTSurgeryLicensePrice">1100 원</p>
			</div>
			<a href="#" id="BtnENTLicense" class="buy-small" onclick="BuyLicense('${pageContext.request.remoteUser}', 'ENTLicense', '1100');">
			<img src="./static/site/images/buybtn.png" alt="" /></a>
		</div>
		<div class="info-box">
			<h4>고관절 <br>치환 수술 </h4>
			<div class="align-content">
				<p><img src="./assets/img/surgical2.jpg" class="photo" alt="" /></p>
				<p id="HipSurgeryLicensePrice">1200 원</p>
			</div>
			<a href="#" id="BtnHipLicense" class="buy-small" onclick="BuyLicense('${pageContext.request.remoteUser}', 'HipLicense', '1200')">
			<img src="./static/site/images/buybtn.png" alt="" /></a> 
		</div>
		<div class="info-box">
			<h4>치과 <br>치석 제거 </h4>
			<div class="align-content">
				<p><img src="./assets/img/surgical3.jpg" class="photo" alt="" /></p>
				<p id="ToothSurgeryLicensePrice">1500 원</p>
			</div>
			<a href="#" id="BtnToothLicense" class="buy-small" onclick="BuyLicense('${pageContext.request.remoteUser}', 'ToothLicense', '1500');">
			<img src="./static/site/images/buybtn.png" alt="" /></a>
		</div>
		<div class="info-box">
			<h4>업데이트 &amp; <br>개발중인 컨텐츠 1</h4>
			<div class="align-content">
				<p><img src="./assets/img/surgical4.jpg" class="photo" alt="" /></p>
				<p>- 원</p>
			</div>
		</div>
		<div class="info-box">
			<h4>업데이트 &amp; <br>개발중인 컨텐츠 2</h4>
			<div class="align-content">
				<p><img src="./assets/img/surgical5.jpg" class="photo" alt="" /></p>
				<p>- 원</p>
			</div>
		</div>
		<div class="info-box">
			<h4>업데이트 &amp; <br>개발중인 컨텐츠 3</h4>
			<div class="align-content">
				<p><img src="./assets/img/surgical6.jpg" class="photo" alt="" /></p>
				<p>- 원</p>
			</div>
		</div>
		<div class="clear"></div>
	</div>
</div>
<div id="footer">
	Website designed by <a href="http://www.solideng.co.kr/" target="_blank" rel="nofollow">http://www.solideng.co.kr</a><br/>
</div>

	<script>
		$(document).ready(function(){	
			IMP.init('imp98200547'); // 가맹점 식별코드
			
			// 해당 계정의 라이센스 상태 DB로 부터 가져오기
			CheckLicense("${pageContext.request.remoteUser}");
			//console.log("${pageContext.request.remoteUser}");
		});
		
		function BuyLicense(user_id, content, price)
		{
			IMP.request_pay({
			    pg : 'inicis', // version 1.1.0부터 지원.
			    pay_method : 'card',
			    merchant_uid : 'merchant_' + new Date().getTime(),
			    name : '주문명:' + content + '(결제테스트)',
			    amount : price,
			    buyer_email : 'jaebul2006@naver.com',
			    buyer_name : user_id,
			    buyer_tel : '010-1234-5678',
			    buyer_addr : '인천광역시 연수구 송도동',
			    buyer_postcode : '123-456',
			    m_redirect_url : ''
			}, function(rsp) {
			    if ( rsp.success ) {
			        var msg = '결제가 완료되었습니다.';
			        msg += '고유ID : ' + rsp.imp_uid;
			        msg += '상점 거래ID : ' + rsp.merchant_uid;
			        msg += '결제 금액 : ' + rsp.paid_amount;
			        msg += '카드 승인번호 : ' + rsp.apply_num;
			        // 가맹점 서버와 고유ID로 유효결제 검증체크는 일단 뒤로
			        // DB 에 정보 반영
			        RegistLicense(user_id, content, rsp.imp_uid, rsp.merchant_uid, rsp.paid_amount, rsp.apply_num);
			    } else {
			        var msg = '결제에 실패하였습니다.';
			        msg += '에러내용 : ' + rsp.error_msg;
			    }
			    alert(msg);
			});
		}
		
		// 서버에 라이센스 구매 등록
		function RegistLicense(user_id, content, imp_uid, merchant_uid, paid_amount, apply_num)
		{
			var license_param = {"user_id":user_id, "content":content, "imp_uid": imp_uid, "merchant_uid": merchant_uid,
					"paid_amount": paid_amount, "apply_num":apply_num};
			
			$.ajax({
				type: "post",
				url: "/CSP/registLicense",
				data: license_param,
				success: function(result){
					console.log(result);
				},
				error :	function(request, status, error){
					console.log(request.responseText);
				}
			});
		}
		
		// 유저의 라이센스 체크
		function CheckLicense(user_id)
		{
			var license_param = {"user_id": user_id};
			$.ajax({
				type: "get",
				url: "/CSP/checkLicense",
				data: license_param,
				success: function(result){
					//console.log(result);
					LicenseUI(result); // 라이센스 가지고있는 목록에 따라 UI 활성화 비활성화
				},
				error :	function(request, status, error){
					console.log(request.responseText);
				}
			});
		}
		
		function LicenseUI(license_list)
		{
			//console.log(license_list);
			
			if(license_list.length < 1)
				return;
			
			for(i=0; i<license_list.length; i++){
				console.log(license_list[i]);
				if(license_list[i].content === "ENTLicense"){
					document.getElementById("ENTSurgeryLicensePrice").innerText = "이미 구매함";
					document.getElementById("BtnENTLicense").style.display = "none";
				}
				else if(license_list[i].content === "HipLicense"){
					document.getElementById("HipSurgeryLicensePrice").innerText = "이미 구매함";
					document.getElementById("BtnHipLicense").style.display = "none";
				}
				else if(license_list[i].content === "ToothLicense"){
					document.getElementById("ToothSurgeryLicensePrice").innerText = "이미 구매함";
					document.getElementById("BtnToothLicense").style.display = "none";
				}
			}
		}
	</script>
</body>
</html>
-->