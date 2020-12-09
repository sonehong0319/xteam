<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div style="height:500px;
	width:750px;
	border:2px solid blue; align:center;">
	<form:form commandName="boardVO" action="write.do" enctype="multipart/form-data">
		<form:errors element="div" cssClass="error-color"/>
		<ul>
			<li style="border:2px solid red; background-color:#EEEEEE; width:595px;">
				<label for="title">제목</label>
				<form:input path="title"/>
				<form:errors path="title" cssClass="error-color"/>
			</li>
			<li>
				<label for="content"></label>
				<form:textarea path="content"  cols="80" rows="30"/>
				<form:errors path="content" cssClass="error-color"/>
			</li>
			<li>
				<label for="upload">이미지 파일업로드</label>
				<input type="file" name="upload" id="upload" accept="image/gif,image/png,image/jpeg">
			</li>
		</ul>	
		<div class="align-center">
			<input type="submit" value="전송">
			<input type="button" value="목록"
			       onclick="location.href='list.do'">
		</div>
	</form:form>
</div>







