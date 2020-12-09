	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<div id="main_div">
	<div id="main_swiper">
		<h2>특집 및 추천 제품</h2>
		 <!-- Swiper -->
			<div class="swiper-container">
   				<div class="swiper-wrapper">
    			  <div class="swiper-slide"><a href="#"><img src="${pageContext.request.contextPath}/resources/images/swiper1.jpg" width="900px"></a></div>
    			  <div class="swiper-slide"><a href="#"><img src="${pageContext.request.contextPath}/resources/images/swiper3.jpg" width="900px"></a></div>
				  <div class="swiper-slide"><a href="#"><img src="${pageContext.request.contextPath}/resources/images/swiper2.jpg" width="900px"></a></div>
   				</div>
    			<!-- Add Pagination -->
   				<div class="swiper-pagination"></div>
    			<!-- Add Arrows -->
    			<div class="swiper-button-next"></div>
    			<div class="swiper-button-prev"></div>
  			</div>
  <!-- Swiper JS -->
  <script src="${pageContext.request.contextPath}/resources/js/swiper.js"></script>
  <!-- Initialize Swiper -->
  <script>
    var swiper = new Swiper('.swiper-container', {
      slidesPerView: 1,
      spaceBetween: 0,
      loop: true,
	  autoplay: {
        delay: 2500,
        disableOnInteraction: false,
      },
      pagination: {
        el: '.swiper-pagination',
        clickable: true,
      },
      navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
      },
    });
  </script>
	</div>
	<div>
		<h2>특별 할인</h2>
		<div id="main_div2">
			<div>
				<a><img src="${pageContext.request.contextPath}/resources/images/test3.jpg"
				 width="300px" height="350px"></a><br>
				<strong>기간 특가</strong><br>
				할인 혜택은 2020년 12월 30일에 종료됩니다.
			</div>
			<div>
				<a><img src="${pageContext.request.contextPath}/resources/images/test4.jpg"
				 width="300px" height="350px"></a><br>
				<strong>오늘의 특가</strong><br>
				할인 혜택은 금일 오후 12시까지 입니다.
			</div>
			<div>
				<a><img src="${pageContext.request.contextPath}/resources/images/test5.jpg"
				 width="300px" height="350px"></a><br>
				<strong>주말 특가</strong><br>
				할인 혜택은 태평양 시간을 기준으로 월요일 오전 10시까지 입니다.
			</div>
		</div>
	</div>
	<div>
		<h2>커뮤니티 추천</h2>
	</div>
	<div class="align-center">
		<h3>추천 제품들을 찾고 계십니까?</h3>
		<p>맞춤 추천 제품을 보려면 로그인하세요.</p>
		<p>아직 가입하지 않으셨다면 먼저 <strong><a href="${pageContext.request.contextPath}/member/registerUser.do">가입</a></strong>하신 후 무료로 Xteam을 이용하세요.</p>
	</div>
</div>