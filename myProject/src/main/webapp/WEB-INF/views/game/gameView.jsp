<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div id="game_detailform">
	<div class="game_left">
		<div>${game.gam_uploadfile2}</div>
	</div>
	<div class="game_right">
		<img class="item_image" src="imageView.do?gam_num=${game.gam_num}"
			style="width: 230px; height: 69px;">
		<div class="game_name">${game.gam_name}</div>
		<div>장르 : ${game.cate_name}</div>
		<div>출시 날짜 : ${game.gam_date}</div>
		<div>${game.gam_detail}</div>
	</div>
	<div class="game_price">
		가격 : ${game.gam_price} 원 
		<input type="button" value="구매 하기" onclick="location.href='list.do'" > 
	</div>


</div>













