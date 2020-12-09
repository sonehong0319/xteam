<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var checkId = 0;
		
		//아이디 중복 체크
		$('#confirmId').click(function(){
			if($('#mem_id').val()==''){
				$('#message_id').css('color','red').text('아이디를 입력하세요!');
				$('#mem_id').focus();
				return;
			}
			if($('#mem_id').val().length<4 || $('#mem_id').val().length>10){
				$('#message_id').css('color','red')
				                .text('아이디는 4자이상 10자이하로 입력');
				$('#mem_id').focus();
				return;
			}
			
			$('#message_id').text();//메시지 초기화
			$('#loading').show();//로딩 이미지 노출
			
			$.ajax({
				url:'confirmId.do',
				type:'post',
				data:{id:$('#mem_id').val()},
				dataType:'json',
				cache:false,
				timeout:30000,
				success:function(data){
					$('#loading').hide();//로딩 이미지 감추기
					
					if(data.result == 'idNotFound'){
						$('#message_id').css('color','#000').text('등록가능ID');
						checkId = 1;
					}else if(data.result == 'idDuplicated'){
						$('#message_id').css('color','red').text('중복된 ID');
						$('#mem_id').val('').focus();
						checkId=0;
					}else{
						checkId=0;
						alert('ID중복체크 오류');
					}
				},
				error:function(){
					checkId = 0;
					$('#loading').hide();//로딩 이미지 감추기
					alert('네트워크 오류 발생');
				}
			});
		});
		
		//아이디 중복 안내 메시지 초기화 및 아이디 중복 값 초기화
		$('#register_form #id').keydown(function(){
			checkId = 0;
			$('#message_id').text('');
		});
		
		/* //submit 이벤트 발생시 아이디 중복 체크 여부 확인
		$('#register_form').submit(function(){
			if(checkId==0){
				$('#message_id').css('color','red')
				                .text('아이디 중복 체크 필수');
				$('#mem_id').focus();
				return false;
			}
		}); */
		
		
	});
</script>
<div class="page-main-style">
	<h2>회원 가입</h2>
	<form:form id="register_form" action="registerUser.do" commandName="memberVO">
		<form:errors element="div" cssClass="error-color"/>
		<ul>
			<li>
				<label for="mem_id">아이디</label>
				<form:input path="mem_id"/>
				<input type="button" id="confirmId"
				  value="ID중복체크">
				<img src="${pageContext.request.contextPath}/resources/images/ajax-loader.gif" 
				      width="16" height="16" style="display:none;" id="loading">
				<span id="message_id"></span>
				<form:errors path="mem_id" cssClass="error-color"/>        
			</li>
			<li>
				<label for="mem_name">이름</label>
				<form:input path="mem_name"/>
				<form:errors path="mem_name" cssClass="error-color"/>
			</li>
			<li>
				<label for="mem_passwd">비밀번호</label>
				<form:password path="mem_passwd"/>
				<form:errors path="mem_passwd" cssClass="error-color"/>
			</li>
			<li>
				<label for="mem_phone">전화번호</label>
				<form:input path="mem_phone"/>
				<form:errors path="mem_phone" cssClass="error-color"/>
			</li>
			<li>
				<label for="mem_email">이메일</label>
				<form:input path="mem_email"/>
				<form:errors path="mem_email" cssClass="error-color"/>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="전송">
			<input type="button" value="홈으로"
			    onclick="location.href='${pageContext.request.contextPath}/main/main.do'">
		</div>
	</form:form>
</div>







