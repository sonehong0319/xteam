<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<div style="margin-right:5%;">
	<div
	style="
	background-color:#EEEEEE; 
	height:30px; 
	border-bottom:1px solid gray; 
	border-top:1px solid gray;
	text-align: center;">
		<span style="margin:30px 180px 30px 30px;">${board.id}</span>
		<span style="margin:30px 180px 30px 30px;">${board.board_reg_date}</span>
		조회 : ${board.board_hit}
	</div>
	
	<p style="color:darkred; font-size:18px; padding-top:50px; padding-bottom:50px;">${board.board_title}</p>
	<c:if test="${!empty board.board_filename}">
	<div class="align-center">
		<img src="imageView.do?board_num=${board.board_num}" style="max-width:500px;">
	</div>
	</c:if>
	<p style="height:200px; padding-top: 50px;">
		${board.board_content}
	</p>
	<hr size="1" width="100%">
	<div class="align-right">
	    <%--수정 삭제의 경우는 로그인이 되어있고 로그인한 회원번호와 작성자 회원번호가
	               일치해야 함 --%>
		<c:if test="${!empty user && user.mem_num == board.mem_num}">
		<input type="button" value="수정"
		       onclick="location.href='update.do?board_num=${board.board_num}'">
		<input type="button" value="삭제" id="delete_btn">
		<script>
			var delete_btn = document.getElementById('delete_btn');
			//이벤트 연결
			delete_btn.onclick=function(){
				var choice = window.confirm('삭제하시겠습니까?');
				if(choice){
					location.href='delete.do?board_num=${board.board_num}';
				}
			};
		</script>              
		</c:if>
		<input type="button" value="목록" onclick="location.href='list.do'">
	</div>

	<!-- 댓글 -->



</div>







