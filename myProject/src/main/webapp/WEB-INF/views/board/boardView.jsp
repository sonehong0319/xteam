<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<div class="page-main-style">
	<div id="boardview-style">
		<span>${board.mem_id}</span>
		<span>${board.board_reg_date}</span>
		<span>${board.board_hit}</span>
	</div><br><br>
	<h2>${board.board_title}</h2>
	<c:if test="${!empty board.board_filename}">
	<div class="align-center">
		<img src="imageView.do?board_num=${board.board_num}" style="max-width:500px;">
	</div>
	</c:if>
	<p>
		<br><br><br><br>${board.board_content}<br><br><br><br>
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
		<input type="button" value="목록"
		       onclick="location.href='list.do'">
	</div>
</div>







