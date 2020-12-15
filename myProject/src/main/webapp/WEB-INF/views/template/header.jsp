<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<div class="align-right">
	<c:if test="${!empty user && !empty user.mem_photoname}">
	<img src="${pageContext.request.contextPath}/member/photoView.do" width="25" height="25" class="my-photo">
	</c:if>
	<c:if test="${!empty user && empty user.mem_photoname}">
	<img src="${pageContext.request.contextPath}/resources/images/blank.jpg" width="25" height="25" class="my-photo">
	</c:if>
	<c:if test="${!empty user}">
	[<span>${user.mem_id}</span>]
	<a class="i"href="${pageContext.request.contextPath}/member/logout.do">로그아웃</a>
	<a class="i"href="${pageContext.request.contextPath}/member/myPage.do">MY페이지</a>
	</c:if>
	<c:if test="${empty user}">
	<a class="i"href="${pageContext.request.contextPath}/member/registerUser.do">회원가입</a>
	<a class="i"href="${pageContext.request.contextPath}/member/login.do">로그인</a>	
	</c:if>
</div>
<div>
	<a href="${pageContext.request.contextPath}/main/main.do"><img id="header_logo" src="${pageContext.request.contextPath}/resources/images/xteam_logo.png" width="250" height="113" alt="xteam로고 이미지"></a>	
	<h1 class="align-center">XTEAM 온라인 게임 유통 플랫폼	</h1>
</div>
<div id="header_menu" class="align-center">
	<a class="i"href="${pageContext.request.contextPath}/main/main.do">홈으로</a>	
	<a class="i"href="${pageContext.request.contextPath}/game/gameList.do">게임 상점</a>
	<a class="i"href="${pageContext.request.contextPath}/board/list.do">커뮤니티</a>
</div>










