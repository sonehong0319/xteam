<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<style>
#wrap{
	overflow:hidden;
}
.item{
	margin: 5px;
	padding: 5px;
	width: 300px;
	height:500px;
	float:left;
}

</style>  
<div class="page-main-style">
	<h2>상점</h2>
	<div class="align-right">
		<c:if test="${!empty user}">
		<input type="button" value="게임등록" 
		       onclick="location.href='write.do'">
		</c:if>
	</div>
	
	<c:if test="${count == 0}">
	<div class="align-center">등록된 게시물이 없습니다.</div>
	</c:if>
	<c:if test="${count > 0}">
	
	<div id="wrap">
		<c:forEach var="game" items="${list}">
		<div class="item">
			<a href="detail.do?gam_num=${game.gam_num}">
				<img src="imageView.do?gam_num=${game.gam_num}" style="max-width:295px;max-height:395px;">
				<br><span>${game.gam_name}</span>
				<br><span>${game.gam_price}</span>
			</a>
		</div>
		</c:forEach>
	</div>
	<div class="align-center">${pagingHtml}</div>
	</c:if>
</div>









