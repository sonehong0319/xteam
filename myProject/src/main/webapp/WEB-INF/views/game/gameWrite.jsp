<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div id="test">
	<form:form commandName="gameVO" action="write.do"
	                        enctype="multipart/form-data">
		<form:errors element="div" cssClass="error-color"/>

			<div id="gamewrite-title">
				<label for="cate_num">카테고리</label>
				<form:select path="cate_num">
					<form:option value="1">액션</form:option>
					<form:option value="2">어드벤처</form:option>
					<form:option value="3">전략</form:option>
					<form:option value="4">대규모 멀티플레이어</form:option>
					<form:option value="5">레이싱</form:option>
					<form:option value="6">롤플레잉</form:option>
					<form:option value="7">스포츠</form:option>
					<form:option value="8">시뮬레이션</form:option>
					<form:option value="9">인디</form:option>
					<form:option value="10">전략</form:option>
					<form:option value="11">캐주얼</form:option>
				</form:select>
				<form:errors path="cate_num" cssClass="error-color"/>
			</div>
			<div id="gamewrite-title">
				<label for="gam_name">게임명</label>
				<form:input path="gam_name"/>
				<form:errors path="gam_name" cssClass="error-color"/>
			</div>
			<div id="bordwrite-title">
				<label for="gam_price">게임 가격</label>
				<form:input path="gam_price"/>
				<form:errors path="gam_price" cssClass="error-color"/>
			</div>
			<div id="bordwrite-title">
				<label for="gam_date">출시 일</label>
				<input type="date" name="gam_date" id="gam_date" value="${gameVO.gam_date}"/>
				<form:errors path="gam_date" cssClass="error-color"/>
			</div>
			<div>
				<label for="gam_">내용</label><br>
				<form:textarea path="gam_detail"/>
				<form:errors path="gam_detail" cssClass="error-color"/>
			</div><br>
			<div>
				<label for="upload">이미지 업로드</label>
				<input type="file" name="upload" id="upload"
				                     accept="image/gif,image/png,image/jpeg">
			</div>
		<div class="align-center">
			<input type="submit" value="전송">
			<input type="button" value="목록"
			       onclick="location.href='list.do'">
		</div>
	</form:form>
</div>







