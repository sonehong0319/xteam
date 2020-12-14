<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#photo_btn').click(function(){
			//이미지 파일 선택 태그가 노출
			$('#photo_choice').show();
			//수정 버튼을 숨김
			$(this).hide();
		});
		
		//원래 이미지를 보관
		var photo_path;
		//변경 이미지를 보관
		var my_photo;
		$('#upload').change(function(){
			var upload = document.getElementById('upload');
			my_photo = upload.files[0];
			if(my_photo){
				var reader = new FileReader();
				reader.readAsDataURL(my_photo);
				
				//사진 업로드전 미리보기 처리
				reader.onload = function(){
					//원래 이미지 보관
					photo_path = $('.my-photo').attr('src');
					//변경된 이미지를 미리보기 셋팅
					$('.my-photo').attr('src',reader.result);
				};
			}
		});
		
		//이미지 초기화
		$('#photo_reset').click(function(){
			$('.my-photo').attr('src',photo_path);
			$('#upload').val('');
			$('#photo_choice').hide();
			$('#photo_btn').show();
		});
		
		$('#photo_submit').click(function(){
			if($('#upload').val()==''){
				alert('파일을 선택하세요');
				$('#upload').focus();
				return;
			}
			//파일 전송
			var form_data = new FormData();
			form_data.append('upload',my_photo);
			$.ajax({
				data:form_data,
				type:'POST',
				url:'updateMyPhoto.do',
				dataType:'json',
				cache:false,
				contentType:false,
				enctype:'multipart/form-data',
				processData:false,
				success:function(data){
					if(data.result == 'logout'){
						alert('로그인 후 사용하세요!');
					}else if(data.result == 'success'){
						alert('프로필 사진이 수정되었습니다.');
						$('#upload').val('');
						$('#photo_choice').hide();
						$('#photo_btn').show();
					}else{
						alert('파일 전송 오류 발생');
					}
				},
				error:function(){
					alert('네트워크 오류 발생');
				}
			});
		});
		
	
	});
</script>
<div class="page-main-style">
	<h2>프로필 사진</h2>
	<ul>
		<li>
			<c:if test="${empty member.mem_photoname}">
			<img src="${pageContext.request.contextPath}/resources/images/blank.jpg" width="100" height="100" class="my-photo">	
			</c:if>
			<c:if test="${!empty member.mem_photoname}">
			<img src="${pageContext.request.contextPath}/member/photoView.do" width="100" height="100" class="my-photo">
			</c:if>
		</li>
		<li>
			<div class="align-center">
				<input type="button" value="수정" id="photo_btn">
			</div>
			<div id="photo_choice" style="display:none;">
				<input type="file" id="upload"
				      accept="image/gif,image/png,image/jpeg">
				<input type="button" value="전송" id="photo_submit">
				<input type="button" value="취소" id="photo_reset">      
			</div>
		</li>
	</ul>
	<h2>회원상세정보</h2>
	<ul>
		<li>이름 : ${member.mem_name}</li>
		<li>전화번호 : ${member.mem_phone}</li>
		<li>이메일 : ${member.mem_email}</li>
		<li>가입날짜 : ${member.reg_date}</li>
	</ul>
	<div>
	</div>
	<h2>구매 목록</h2>
	<div>
		
	</div>
	
	
	<hr size="1" width="100%">
	<p class="align-right">
		<input type="button" value="회원상세정보 수정"
		      onclick="location.href='update.do'">
		<input type="button" value="비밀번호변경"
		      onclick="location.href='changePassword.do'">
		<input type="button" value="회원탈퇴"
		      onclick="location.href='delete.do'">            
	</p>
</div>






