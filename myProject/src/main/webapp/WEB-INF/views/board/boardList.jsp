<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<div class="page-main-style">
   <h2>자유 게시판</h2>
   <form action="list.do" id="search_form" method="get">
      <ul class="search">
         <li>
            <select name="keyfield" id="keyfield">
               <option value="1">제목</option>
               <option value="2">ID</option>
               <option value="3">내용</option>
               <option value="4">전체</option>
            </select>
         </li>
         <li>
            <input type="text" name="keyword" id="keyword">
         </li>
         <li>
            <input type="submit" value="찾기">
            <input type="button" value="목록" onclick="location.href='list.do'">
         </li>
      </ul>
   </form>
   <div class="align-right">
      <c:if test="${!empty user}">
      <input type="button" value="글쓰기" 
             onclick="location.href='write.do'">
      </c:if>
     <br><br>
   </div>
   
   <c:if test="${count == 0}">
   <div class="align-center">등록된 게시물이 없습니다.</div>
   </c:if>
   <c:if test="${count > 0}">
   
   <div>
      <div id="boardlist-head">
         <span class="boardcount_1">번호</span>
         <span class="boardtitle_1">제목</span>
         <span class="boardwriter_1">작성자</span>
         <span class="boardregdate_1">작성일</span>
         <span class="boardhit_1">조회수</span>
      </div>
      <c:forEach var="board" items="${list}">
      <div id="boardlist-content">
         <span class="boardcount_1">${board.board_num}</span>
         <span class="boardtitle_1"><a href="detail.do?board_num=${board.board_num}">${board.board_title}</a></span>
         <span class="boardwriter_1">${board.mem_id}</span>
         <span class="boardregdate_1">${board.board_modify_date}</span>
         <span class="boardhit_1">${board.board_hit}</span>
      </div>
      </c:forEach>
   </div>
   <div class="boardwrite-submit">${pagingHtml}</div>
   </c:if>
</div>








