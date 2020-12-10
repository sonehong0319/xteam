<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div id="test">
	<form:form commandName="boardVO" action="write.do"
	                        enctype="multipart/form-data">
		<form:errors element="div" cssClass="error-color"/>

			<div id="bordwrite-title">
				<label for="board_title">제목</label>
				<form:input path="board_title"/>
				<form:errors path="board_title" cssClass="error-color"/>
			</div>
			<div>
				<label for="board_content">내용</label><br>
				<form:textarea path="board_content"/>
				<form:errors path="board_content" cssClass="error-color"/>
			</div><br>
			<div> 
				<label for="upload">파일업로드</label>
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







