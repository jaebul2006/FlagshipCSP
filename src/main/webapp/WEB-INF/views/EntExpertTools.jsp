<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   	<meta name="description" content="">
   	<meta name="author" content="">
   	<link rel="icon" href="./KVRF/final/images/favicon.ico">

	<title>이비인후과 전문가 도구 점수 편집</title>

    <!-- Bootstrap core CSS -->
    <link href="./KVRF/final/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./KVRF/final/css/signin.css" rel="stylesheet">
      
    <style>
        .form-sign-in {margin: 0 auto; max-width: 465px;}
    </style>

	<script>
		$(document).ready(function(){
			
			$("#BtnUpdateExpertToolsUpdate").click(function(){
				
				var oper_name = "";
				
				if(document.getElementById('tsa').checked){
					oper_name = "tsa";
				}
				else if(document.getElementById('outer_break').checked){
					oper_name = "outer_break";
				} 
				else if(document.getElementById('septal_flap').checked){
					oper_name = "septal_flap";
				}
				else if(document.getElementById('superior_turbinate').checked){
					oper_name = "superior_turbinate";
				}
				else if(document.getElementById('sella_duramater').checked){
					oper_name = "sella_duramater";
				}
				else if(document.getElementById('tumor_removal').checked){
					oper_name = "tumor_removal";
				}
				else if(document.getElementById('transclival_approach').checked){
					oper_name = "transclival_approach";
				}
				else if(document.getElementById('sphenoid_cells_removal').checked){
					oper_name = "sphenoid_cells_removal";
				}
				else if(document.getElementById('transclival_drilling').checked){
					oper_name = "transclival_drilling";
				}
				else if(document.getElementById('acidosis_maxillary_sinus').checked){
					oper_name = "acidosis_maxillary_sinus";
				}
				else if(document.getElementById('uncinectomy').checked){
					oper_name = "uncinectomy";
				}
				else if(document.getElementById('anterior_ethmoidectomy').checked){
					oper_name = "anterior_ethmoidectomy";
				}
				else if(document.getElementById('anterior_sinus').checked){
					oper_name = "anterior_sinus";
				}
				else if(document.getElementById('anterior_ethmoidal_air_cell_removal').checked){
					oper_name = "anterior_ethmoidal_air_cell_removal";
				}
				else if(document.getElementById('posterior_air_cell_removal').checked){
					oper_name = "posterior_air_cell_removal";
				}
				
				var touchCount = $("#touchCount").val();
				var toolUseCount = $("#toolUseCount").val();
				var toolInnerCount = $("#toolInnerCount").val();
				var toolTouchScore = $("#toolTouchScore").val();
				var toolViewScore = $("#toolViewScore").val();
				var maxScore = $("#maxScore").val();
				
				var param = {"oper_name":oper_name, "touchCount":touchCount, "toolUseCount":toolUseCount, "toolInnerCount":toolInnerCount, "toolTouchScore":toolTouchScore, "toolViewScore":toolViewScore, "maxScore":maxScore};
				console.log(param);
				
				$.ajax({	
					type: "post",
					data: param,
					url: "${path}/Ent_Expert_Tools_Update",
					
					success: function(data){
						console.log(data);
					}
				});
			});
			
			$("#tsa").click(function(){
				var param = {"oper_name":"tsa"};
				$.ajax({	
					type: "get",
					data: param,
					url: "/CSP/Ent_Expert_ToolsEach",
					
					success: function(data){
						console.log(data);
						$("#touchCount").val(data.touchCount.toString());
						$("#toolUseCount").val(data.toolUseCount.toString());
						$("#toolInnerCount").val(data.toolInnerCount.toString());
						$("#toolTouchScore").val(data.toolTouchScore.toString());
						$("#toolViewScore").val(data.toolViewScore.toString());
						$("#maxScore").val(data.maxScore.toString());
					}
				});
			});
			
			$("#outer_break").click(function(){
				var param = {"oper_name":"outer_break"};
				$.ajax({	
					type: "get",
					data: param,
					url: "/CSP/Ent_Expert_ToolsEach",
					
					success: function(data){
						console.log(data);
						$("#touchCount").val(data.touchCount.toString());
						$("#toolUseCount").val(data.toolUseCount.toString());
						$("#toolInnerCount").val(data.toolInnerCount.toString());
						$("#toolTouchScore").val(data.toolTouchScore.toString());
						$("#toolViewScore").val(data.toolViewScore.toString());
						$("#maxScore").val(data.maxScore.toString());
					}
				});
			});
			
			$("#septal_flap").click(function(){
				var param = {"oper_name":"septal_flap"};
				$.ajax({	
					type: "get",
					data: param,
					url: "/CSP/Ent_Expert_ToolsEach",
					
					success: function(data){
						console.log(data);
						$("#touchCount").val(data.touchCount.toString());
						$("#toolUseCount").val(data.toolUseCount.toString());
						$("#toolInnerCount").val(data.toolInnerCount.toString());
						$("#toolTouchScore").val(data.toolTouchScore.toString());
						$("#toolViewScore").val(data.toolViewScore.toString());
						$("#maxScore").val(data.maxScore.toString());
					}
				});
			});
			
			$("#superior_turbinate").click(function(){
				var param = {"oper_name":"superior_turbinate"};
				$.ajax({	
					type: "get",
					data: param,
					url: "/CSP/Ent_Expert_ToolsEach",
					
					success: function(data){
						console.log(data);
						$("#touchCount").val(data.touchCount.toString());
						$("#toolUseCount").val(data.toolUseCount.toString());
						$("#toolInnerCount").val(data.toolInnerCount.toString());
						$("#toolTouchScore").val(data.toolTouchScore.toString());
						$("#toolViewScore").val(data.toolViewScore.toString());
						$("#maxScore").val(data.maxScore.toString());
					}
				});
			});
			
			$("#sella_duramater").click(function(){
				var param = {"oper_name":"sella_duramater"};
				$.ajax({	
					type: "get",
					data: param,
					url: "/CSP/Ent_Expert_ToolsEach",
					
					success: function(data){
						console.log(data);
						$("#touchCount").val(data.touchCount.toString());
						$("#toolUseCount").val(data.toolUseCount.toString());
						$("#toolInnerCount").val(data.toolInnerCount.toString());
						$("#toolTouchScore").val(data.toolTouchScore.toString());
						$("#toolViewScore").val(data.toolViewScore.toString());
						$("#maxScore").val(data.maxScore.toString());
					}
				});
			});
			
			$("#tumor_removal").click(function(){
				var param = {"oper_name":"tumor_removal"};
				$.ajax({	
					type: "get",
					data: param,
					url: "/CSP/Ent_Expert_ToolsEach",
					
					success: function(data){
						console.log(data);
						$("#touchCount").val(data.touchCount.toString());
						$("#toolUseCount").val(data.toolUseCount.toString());
						$("#toolInnerCount").val(data.toolInnerCount.toString());
						$("#toolTouchScore").val(data.toolTouchScore.toString());
						$("#toolViewScore").val(data.toolViewScore.toString());
						$("#maxScore").val(data.maxScore.toString());
					}
				});
			});
			
			$("#transclival_approach").click(function(){
				var param = {"oper_name":"transclival_approach"};
				$.ajax({	
					type: "get",
					data: param,
					url: "/CSP/Ent_Expert_ToolsEach",
					
					success: function(data){
						console.log(data);
						$("#touchCount").val(data.touchCount.toString());
						$("#toolUseCount").val(data.toolUseCount.toString());
						$("#toolInnerCount").val(data.toolInnerCount.toString());
						$("#toolTouchScore").val(data.toolTouchScore.toString());
						$("#toolViewScore").val(data.toolViewScore.toString());
						$("#maxScore").val(data.maxScore.toString());
					}
				});
			});
			
			$("#sphenoid_cells_removal").click(function(){
				var param = {"oper_name":"sphenoid_cells_removal"};
				$.ajax({	
					type: "get",
					data: param,
					url: "/CSP/Ent_Expert_ToolsEach",
					
					success: function(data){
						console.log(data);
						$("#touchCount").val(data.touchCount.toString());
						$("#toolUseCount").val(data.toolUseCount.toString());
						$("#toolInnerCount").val(data.toolInnerCount.toString());
						$("#toolTouchScore").val(data.toolTouchScore.toString());
						$("#toolViewScore").val(data.toolViewScore.toString());
						$("#maxScore").val(data.maxScore.toString());
					}
				});
			});
			
			$("#transclival_drilling").click(function(){
				var param = {"oper_name":"transclival_drilling"};
				$.ajax({	
					type: "get",
					data: param,
					url: "/CSP/Ent_Expert_ToolsEach",
					
					success: function(data){
						console.log(data);
						$("#touchCount").val(data.touchCount.toString());
						$("#toolUseCount").val(data.toolUseCount.toString());
						$("#toolInnerCount").val(data.toolInnerCount.toString());
						$("#toolTouchScore").val(data.toolTouchScore.toString());
						$("#toolViewScore").val(data.toolViewScore.toString());
						$("#maxScore").val(data.maxScore.toString());
					}
				});
			});
			
			$("#uncinectomy").click(function(){
				var param = {"oper_name":"uncinectomy"};
				$.ajax({	
					type: "get",
					data: param,
					url: "/CSP/Ent_Expert_ToolsEach",
					
					success: function(data){
						console.log(data);
						$("#touchCount").val(data.touchCount.toString());
						$("#toolUseCount").val(data.toolUseCount.toString());
						$("#toolInnerCount").val(data.toolInnerCount.toString());
						$("#toolTouchScore").val(data.toolTouchScore.toString());
						$("#toolViewScore").val(data.toolViewScore.toString());
						$("#maxScore").val(data.maxScore.toString());
					}
				});
			});
			
			$("#anterior_ethmoidectomy").click(function(){
				var param = {"oper_name":"anterior_ethmoidectomy"};
				$.ajax({	
					type: "get",
					data: param,
					url: "/CSP/Ent_Expert_ToolsEach",
					
					success: function(data){
						console.log(data);
						$("#touchCount").val(data.touchCount.toString());
						$("#toolUseCount").val(data.toolUseCount.toString());
						$("#toolInnerCount").val(data.toolInnerCount.toString());
						$("#toolTouchScore").val(data.toolTouchScore.toString());
						$("#toolViewScore").val(data.toolViewScore.toString());
						$("#maxScore").val(data.maxScore.toString());
					}
				});
			});
			
			$("#anterior_sinus").click(function(){
				var param = {"oper_name":"anterior_sinus"};
				$.ajax({	
					type: "get",
					data: param,
					url: "/CSP/Ent_Expert_ToolsEach",
					
					success: function(data){
						console.log(data);
						$("#touchCount").val(data.touchCount.toString());
						$("#toolUseCount").val(data.toolUseCount.toString());
						$("#toolInnerCount").val(data.toolInnerCount.toString());
						$("#toolTouchScore").val(data.toolTouchScore.toString());
						$("#toolViewScore").val(data.toolViewScore.toString());
						$("#maxScore").val(data.maxScore.toString());
					}
				});
			});
			
			$("#anterior_ethmoidal_air_cell_removal").click(function(){
				var param = {"oper_name":"anterior_ethmoidal_air_cell_removal"};
				$.ajax({	
					type: "get",
					data: param,
					url: "/CSP/Ent_Expert_ToolsEach",
					
					success: function(data){
						console.log(data);
						$("#touchCount").val(data.touchCount.toString());
						$("#toolUseCount").val(data.toolUseCount.toString());
						$("#toolInnerCount").val(data.toolInnerCount.toString());
						$("#toolTouchScore").val(data.toolTouchScore.toString());
						$("#toolViewScore").val(data.toolViewScore.toString());
						$("#maxScore").val(data.maxScore.toString());
					}
				});
			});
			
			$("#posterior_air_cell_removal").click(function(){
				var param = {"oper_name":"posterior_air_cell_removal"};
				$.ajax({	
					type: "get",
					data: param,
					url: "/CSP/Ent_Expert_ToolsEach",
					
					success: function(data){
						console.log(data);
						$("#touchCount").val(data.touchCount.toString());
						$("#toolUseCount").val(data.toolUseCount.toString());
						$("#toolInnerCount").val(data.toolInnerCount.toString());
						$("#toolTouchScore").val(data.toolTouchScore.toString());
						$("#toolViewScore").val(data.toolViewScore.toString());
						$("#maxScore").val(data.maxScore.toString());
					}
				});
			});
			
		});
	</script>
</head>

<body>
	<form class="form-signin" class="needs-validation">
        <div class="form-container">
          <h4 class="mb-3">이비인후과 전문가 도구 점수 편집</h4>
            <hr class="mb-4">
            
            <h5 class="mb-3">수술 타입</h5>
            <div class="d-block my-3">
              <div class="custom-control custom-radio d-inline mr-4">
                <input id="tsa" name="opertype" type="radio" class="custom-control-input" value="tsa">
                <label class="custom-control-label" for="tsa">tsa</label>
              </div>
              <div class="custom-control custom-radio d-inline">
                <input id="outer_break" name="opertype" type="radio" class="custom-control-input" value="outer_break">
                <label class="custom-control-label" for="outer_break">outer_break</label>
              </div>
              <div class="custom-control custom-radio d-inline">
                <input id="septal_flap" name="opertype" type="radio" class="custom-control-input" value="septal_flap">
                <label class="custom-control-label" for="septal_flap">septal_flap</label>
              </div>
              <div class="custom-control custom-radio d-inline">
                <input id="superior_turbinate" name="opertype" type="radio" class="custom-control-input" value="superior_turbinate">
                <label class="custom-control-label" for="superior_turbinate">superior_turbinate</label>
              </div>
              <div class="custom-control custom-radio d-inline">
                <input id="sella_duramater" name="opertype" type="radio" class="custom-control-input" value="sella_duramater">
                <label class="custom-control-label" for="sella_duramater">sella_duramater</label>
              </div>
              <div class="custom-control custom-radio d-inline">
                <input id="tumor_removal" name="opertype" type="radio" class="custom-control-input" value="tumor_removal">
                <label class="custom-control-label" for="tumor_removal">tumor_removal</label>
              </div>
              <div class="custom-control custom-radio d-inline">
                <input id="transclival_approach" name="opertype" type="radio" class="custom-control-input" value="transclival_approach">
                <label class="custom-control-label" for="transclival_approach">transclival_approach</label>
              </div>
              <div class="custom-control custom-radio d-inline">
                <input id="sphenoid_cells_removal" name="opertype" type="radio" class="custom-control-input" value="sphenoid_cells_removal">
                <label class="custom-control-label" for="sphenoid_cells_removal">sphenoid_cells_removal</label>
              </div>
              <div class="custom-control custom-radio d-inline">
                <input id="transclival_drilling" name="opertype" type="radio" class="custom-control-input" value="transclival_drilling">
                <label class="custom-control-label" for="transclival_drilling">transclival_drilling</label>
              </div>
              <div class="custom-control custom-radio d-inline">
                <input id="acidosis_maxillary_sinus" name="opertype" type="radio" class="custom-control-input" value="acidosis_maxillary_sinus">
                <label class="custom-control-label" for="acidosis_maxillary_sinus">acidosis_maxillary_sinus</label>
              </div>
              <div class="custom-control custom-radio d-inline">
                <input id="uncinectomy" name="opertype" type="radio" class="custom-control-input" value="uncinectomy">
                <label class="custom-control-label" for="uncinectomy">uncinectomy</label>
              </div>
              <div class="custom-control custom-radio d-inline">
                <input id="anterior_ethmoidectomy" name="opertype" type="radio" class="custom-control-input" value="anterior_ethmoidectomy">
                <label class="custom-control-label" for="anterior_ethmoidectomy">anterior_ethmoidectomy</label>
              </div>
              <div class="custom-control custom-radio d-inline">
                <input id="anterior_sinus" name="opertype" type="radio" class="custom-control-input" value="anterior_sinus">
                <label class="custom-control-label" for="anterior_sinus">anterior_sinus</label>
              </div>
              <div class="custom-control custom-radio d-inline">
                <input id="anterior_ethmoidal_air_cell_removal" name="opertype" type="radio" class="custom-control-input" value="anterior_ethmoidal_air_cell_removal">
                <label class="custom-control-label" for="anterior_ethmoidal_air_cell_removal">anterior_ethmoidal_air_cell_removal</label>
              </div>
              <div class="custom-control custom-radio d-inline">
                <input id="posterior_air_cell_removal" name="opertype" type="radio" class="custom-control-input" value="posterior_air_cell_removal">
                <label class="custom-control-label" for="posterior_air_cell_removal">posterior_air_cell_removal</label>
              </div>
            </div>
            
            <div class="row">
              <div class="col-md-12 mb-3">
                <label for="touchCount">충돌횟수</label>
                <input type="text" class="form-control" id="touchCount" placeholder="0" value="" required="">
              </div>
            </div>
            
            <div class="row">
              <div class="col-md-12 mb-3">
                <label for="toolUseCount">툴 조작 횟수</label>
                <input type="text" class="form-control" id="toolUseCount" placeholder="0" value="" required="">
              </div>
            </div>
            
            <div class="row">
              <div class="col-md-12 mb-3">
                <label for="toolInnerCount">내시경 화면내 정확한 툴의 위치횟수</label>
                <input type="text" class="form-control" id="toolInnerCount" placeholder="0" value="" required="">
              </div>
            </div>
            
            <div class="row">
              <div class="col-md-12 mb-3">
                <label for="toolTouchScore">도구 충돌 점수</label>
                <input type="text" class="form-control" id="toolTouchScore" placeholder="0" value="" required="">
              </div>
            </div>
            
            <div class="row">
              <div class="col-md-12 mb-3">
                <label for="toolViewScore">내시경 화면내 도구 위치 점수</label>
                <input type="text" class="form-control" id="toolViewScore" placeholder="0" value="" required="">
              </div>
            </div>
            
            <div class="row">
              <div class="col-md-12 mb-3">
                <label for="maxScore">각각 최대 툴 점수</label>
                <input type="text" class="form-control" id="maxScore" placeholder="0" value="" required="">
              </div>
            </div>
            
            <hr class="mb-4">
            <button class="btn btn-lg btn-primary p-btn btn-block" type="submit" id="BtnUpdateExpertToolsUpdate">업데이트</button>
        </div>
       <p class="login-copyright col-sm-12 text-center">© Solideng all rights reserved.</p>
    </form>
</body>

</html>