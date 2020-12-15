<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<style>
#wrap{
	overflow:hidden;
}
.item_form{
	
}
.item_tap{
	margin: 5px;
	float: left;
	display: flex;
	height: 75px;
	width: 863px;
	
}
.item_image{
	
	
}
.item_detail{
	overflow:hidden;
	margin-left: 20px;
	color: black;
}

</style>  
<div class="page-main-style">
	<h2>게임 상점</h2>
	<div class="align-right">
		<c:if test="${ !empty user }">
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
		<div class="item_form">
			<div><a class="item_tap" href="gameDetail.do?gam_num=${game.gam_num}">
				<div>
				<img class="item_image" src="imageView.do?gam_num=${game.gam_num}" style="width:184px; height:69px;">
				</div>
				<div class="item_detail">
					 <div><strong>${game.gam_name}</strong></div>
					 <div>${game.gam_price}원</div>
					 <div>${game.gam_detail}</div>
				</div>
			</a></div>
		</div>
		</c:forEach>
	</div>
	<div class="align-center">${pagingHtml}</div>
	</c:if>
</div>









