
<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="/WEB-INF/views/include/header.jsp" %>
<style>
.content-container{
	
}
.problem-container{
	margin : auto;
	align : center;
	width : 80%;
	border : 0.3rem ridge white;
}
.problem-register-title{
	color : #D9951D;
	margin-top : 3rem;
}
.problem-type-title{
	
}
.problem-type-con{
	display : inline-block;
}
.problem-title-con{
	width : 80%;
}
.problem-content-con{
	width : 80%;
}
#content-section{
	background-color : rgba(50,25,4,0.7);
}

#multiple-choice{
	margin-top : 2rem;
}
#short-answer{
	display : none;
}
.choice-answer-table{
	width : 80%;
	margin : 0px auto;
	border : 0.25rem solid rgba(230,230,230);
	border-style : ridge;
}
.choice-content{
	margin : 0px;
	padding : 0px;
	box-sizing: border-box;
}
.choice-content-text{
	box-sizing: border-box;
	width : 100%;
}
.answer-content-text{
	box-sizing : border-box;
	width : 100%;
}
.choice-content-checkbox{
	transform : scale(2);
	box-sizing: border-box;
}
.choice-answer-content-button{
	color: rgba(0,0,0,0.75) !important;
	background-color : #FFF;
	margin : 0px !important;
	padding: 0px 0.3rem !important;
	font-size: 1rem;
	font-weight: 900;
	border: 0.2rem solid #444;
	border-radius: 0.5rem;
	box-sizing: border-box;
}
.choice-answer-content-button:hover {
  background-color: #AAA;
  border-color : #000;
  text-decoration: none;	
}

.choice-answer-content-button:active {
  background-color: #555 !important;
  border-color : #000 !important;
  text-decoration: none !important;
}
#short-answer-text{
	width : 80%;
}
.choice-content > th{
	vertical-align : middle;
	padding : 0.5rem 0px];
}
.choice-content > td{
	vertical-align: middle;
}
#button-container > a{
 	color: rgba(255,255,255, 0.75) !important;
	margin : 1rem 0.5rem !important;
	padding: 0.5rem 1rem;
	font-size: 1rem;
	font-weight: 700;
	border: none;
	border-radius: 0.5rem;
	box-sizing: border-box;
}
</style>

<section class="page-section" id="content-section">
	<div class="content-container">
	  <!-- main container -->
	  <div class="problem-container h-100 align-items-center justify-content-center text-center">
	    <h1 class="text-white-75 font-weight-bold mb-5 problem-register-title" >문제 등록</h1>
	   	<p class="text-white-50 font-weight-bold problem-type-title">문제 유형</p>
	   	<label class="text-white-50 font-weight-light problem-type-con"><input class="radio-btn" type="radio" name="problem-type" value="m" id="radio-multiple" checked="checked"/> 객관식  </label>
	   	<label class="text-white-50 font-weight-light problem-type-con"><input class="radio-btn" type="radio" name="problem-type" value="s" id="radio-short"/> 주관식  </label>
	   	<p class="text-white-50 font-weight-bold mt-5">제목</p>
	   	<input type="text" class="problem-title-con text-black-50" id="problem-title" autofocus/>
	   	<p class="text-white-50 font-weight-bold mt-5">내용</p>
	   	<textarea class="problem-content-con text-black-50" id="problem-content" rows=20></textarea>
		<div id="multiple-choice">
		   	<table class="choice-answer-table" border="1">
				<thead>
					<tr>
				   		<th class="text-white-50 font-weight-bold mt-5">보기</th>
			 			<th class="text-white-50 font-weight-bold mt-5">정답</th>
				   		<th class="text-white-50 font-weight-bold mt-5">추가/제거</th>
					</tr>
				</thead>
				<tbody>
					<tr class="choice-content">
						<td><input type="text" class="choice-content-text text-black-50" /></td>
						<td><input type="checkbox" class="choice-content-checkbox" /></td>
						<td>
						<a class="btn btn-primary choice-answer-content-button" id="plus"> + </a>
						<a class="btn btn-primary choice-answer-content-button" id="minus"> - </a>
						</td>
					</tr>
				</tbody>
		   	</table>
		</div>
		
		<div id="short-answer">
			<table class="choice-answer-table" border="1">
				<thead>
					<tr>
				   		<th class="text-white-50 font-weight-bold mt-5">정답</th>
				   		<th class="text-white-50 font-weight-bold mt-5">추가/제거</th>
					</tr>
				</thead>
				
				<tbody>
					<tr class="answer-content">
						<td><input type="text" class="answer-content-text text-black-50" /></td>
						<td>
							<a class="btn btn-primary choice-answer-content-button" id="plus"> + </a>
							<a class="btn btn-primary choice-answer-content-button" id="minus"> - </a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	   	
	   	
	   	<section id="button-container">
	   		<a class="btn btn-primary" id="problem-register-btn">문제등록</a>	
	   		<a class="btn btn-primary" id="problem-list-btn">목록으로</a>
	   	</section>
	  </div>
	</div>	
</section >

<script id=choice-template type=text/template>
	<tr class="choice-content">
		<td><input type="text" class="choice-content-text text-black-50" /></td>
		<td><input type="checkbox" class="choice-content-checkbox" /></td>
		<td>
			<a class="btn btn-primary choice-answer-content-button" id="plus"> + </a>
			<a class="btn btn-primary choice-answer-content-button" id="minus"> - </a>
		</td>
	</tr>
</script>

<script id=answer-template type=text/template>
	<tr class="answer-content">
		<td><input type="text" class="answer-content-text text-black-50" /></td>
		<td>
			<a class="btn btn-primary choice-answer-content-button" id="plus"> + </a>
			<a class="btn btn-primary choice-answer-content-button" id="minus"> - </a>
		</td>
	</tr>
</script>

<script>
document.addEventListener("DOMContentLoaded", function(){
	const MAXCOUNT = 6;
	var choiceCount = 1;
	var answerCount = 1;
	var radioBtnList = document.querySelectorAll(".radio-btn");
	var mBtn = radioBtnList[0];
	var sBtn= radioBtnList[1];
	var status = mBtn.checked?'m':'s';
	
	mBtn.addEventListener("click", function(evt){
		if(status==='m') return;
		status = 'm';
		var multipleContainer = document.querySelector("#multiple-choice");
		var shortContainer =document.querySelector("#short-answer");
		multipleContainer.style.display = "";
		shortContainer.style.display = "none";
		
	});
	sBtn.addEventListener("click", function(evt){
		if(status==='s') return;
		status = 's';
		var multipleContainer = document.querySelector("#multiple-choice");
		var shortContainer =document.querySelector("#short-answer");
		multipleContainer.style.display = "none";
		shortContainer.style.display = "block";
	});
	
	var mutipleChoiceTableBody = document.querySelector("#multiple-choice tbody");
	var shortAnswerTableBody = document.querySelector("#short-answer  tbody");
	mutipleChoiceTableBody.addEventListener("click", tableBodyClick);
	shortAnswerTableBody.addEventListener("click", tableBodyClick);
	
	function tableBodyClick(evt){
		var tagName = evt.target.tagName;
		if(tagName!=="A") return;
		var buttonType = evt.target.getAttribute("id");
		if(buttonType === "plus") appendTableRow(evt.target);
		else if(buttonType === "minus") removeTableRow(evt.target);
	}
	
	function appendTableRow(btn){
		var templateHTML, currentCount;
		if(status==='m'){
			currentCount = choiceCount;
			templateHTML = document.querySelector("#choice-template").innerText;
		}
		else {
			currentCount = answerCount;
			templateHTML = document.querySelector("#answer-template").innerText;
		}
		if(currentCount>=MAXCOUNT){
			alert(`최대 {MAXCOUNT}개 까지 추가 가능합니다.`);
 			return;
		}
		var clickedRow = btn.closest("tr");
		clickedRow.insertAdjacentHTML("afterend", templateHTML);
		if(status==='m') ++choiceCount;
		else ++answerCount;
	}
	
	function removeTableRow(btn){
		var currentCount;
		if(status==='m') currentCount = choiceCount;
		else currentCount = answerCount;
		
		if(currentCount<=1){
			alert("적어도 1개 있어야 합니다.")
			return;
		}
		var deleteRow = btn.closest("tr");
		tableBody.removeChild(deleteRow);
		if(status==='m') --choiceCount;
		else --answerCount;
	}
	
	var registerBtn = document.querySelector("#problem-register-btn");
	registerBtn.addEventListener("click", function(){
		var dto, url;
		if(status === 'm'){
			dto = makeMultipleChoiceDto(); 
			url = "problem/multiplechoice";
		}
		else if(status === 's'){
			dto = makeShortAnswerDto();
			url = "problem/shortanswer";
		}
		console.log(dto, url);
		if(dto==null) return;
		sendAjaxRegisterBtn(dto, url);
	});
	
	function makeMultipleChoiceDto(){
		var problemObj = makeProblemObject();
		if(problemObj==null) return;
		var choiceObjList = makeChoiceObjectList();
		if(choiceObjList==null) return;
		return {
			"problem_vo" : problemObj,
			"choice_vo_list" : choiceObjList
		};
	}
	
	function makeShortAnswerDto(){
		var problemObj = makeProblemObject();
		if(problemObj==null) return;
		var answerObjList = makeAnswerObjectList();
		if(answerObjList == null) return;
		return {
			"problem_vo" : problemObj,
			"answer_vo_list" : answerObjList
		};
	}
	
	function makeProblemObject(){
		var title = document.querySelector(".problem-title-con").value.trim();
		var content = document.querySelector(".problem-content-con").value.trim();
		if(title==="" || content==="")	{
			alert("제목과 내용을 채워야 합니다.");
			return null;
		}
		return {
				problem_title : title,
				problem_content : content,
				// 로그인 추가 후 수정 해야함
				user_id : "user00",
				user_name : "유저00",
				problem_type : status
		};
	}
	
	function makeChoiceObjectList(){
		var choiceObjList = [];
		var choiceTrList = document.querySelectorAll("#multiple-choice .choice-content");
		var choiceCount = 0;
		var ansCount = 0;
		choiceTrList.forEach(function(val){
			var choice_content = val.querySelector(".choice-content-text").value.trim();
			var chk_answer = val.querySelector(".choice-content-checkbox").checked;
			if(choice_content != ""){
				++choiceCount;
				if(chk_answer) ++ansCount;
				choiceObjList.push({choice_content : choice_content, chk_answer : chk_answer});
			}
		});
		if(choiceCount < 2){
			alert("적어도 보기는 2개 이상이어야 합니다.");
			return null;
		}
		if(ansCount == 0){	
			alert("적어도 정답은 1개 이상이어야 합니다.");
			return null;
		}
		return choiceObjList;
	}
	
	function makeAnswerObjectList(){
		var answerObjList = [];
		var answerTrList = document.querySelectorAll("#short-answer .answer-content");
		var answerCount = 0;
		answerTrList.forEach(function(val){
			var answer_content = val.querySelector(".answer-content-text").value.trim();
			if(answer_content != ""){
				++answerCount;
				answerObjList.push({answer_content : answer_content});
			}
		});
		if(answerCount <= 0){
			alert("적어도 정답은 1개 이상이어야 합니다.");
			return null;
		}
		return answerObjList;
	}
	
	function sendAjaxRegisterBtn(dto, url){
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState === XMLHttpRequest.DONE){
				if(xhr.status === 200){
					var result = JSON.parse(xhr.responseText).result;
					if(result === "success"){
						alert("문제 등록 성공!");
						location.href = "problem/list";
					}
					else if(result === "fail"){
						alert("문제 등록 실패! 잠시 후 다시 시도해주세요.");
					}
				}
			}
		};
		xhr.open("POST", url);
		xhr.setRequestHeader("content-type", "application/json");
		xhr.send(JSON.stringify(dto));
	}
});

</script>


<!-- Bootstrap core JavaScript -->
<script src="/resources/vendor/jquery/jquery.min.js"></script>
<script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Plugin JavaScript -->
<script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>
<script src="/resources/vendor/magnific-popup/jquery.magnific-popup.min.js"></script>
<!-- Custom scripts for this template -->
 <script src="/resources/js/creative.min.js"></script>
</body>
</html>