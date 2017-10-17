<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
function deleteNotice(){
	if(confirm("공지사항 삭제하시겠습니까?")){
		document.deleteForm.submit();
	}
}
function updateNotice(){
	if(confirm("공지사항을 수정하시겠습니까?")){
		location.href="${pageContext.request.contextPath}/DispatcherServlet?command=cmdUpdateFormNotice&nNo=${requestScope.nvo.nNo }";
	}
}
function noticeList(){
	location.href="${pageContext.request.contextPath}/DispatcherServlet?command=cmdNoticeList";
}
</script>
<table class="table table-striped">
		<tr>
			<td>글번호 ${requestScope.nvo.nNo }</td>
			<td>제목: ${requestScope.nvo.title} </td>
			<td align="right">조회수 : ${requestScope.nvo.hits }</td>
			<td align="right">${requestScope.nvo.regdate }</td>
		</tr>		
		<tr>
			<td colspan="4" class="content">
			<pre>${requestScope.nvo.content}</pre>
			</td>
		</tr>
		<tr>
			<td colspan="4" class="btnArea">
			 <c:if test="${sessionScope.membervo.authority eq '관리자'}">
			 <form name="deleteForm" action="${pageContext.request.contextPath}/DispatcherServlet" method="post">
			 	<input type="hidden" name="command" value="cmdDeleteNotice">
			 	<input type="hidden" name="nNo" value="${requestScope.nvo.nNo}">
			 </form>
			 <button type="button" class="btn" onclick="deleteNotice()">삭제</button>
			 <button type="button" class="btn" onclick="updateNotice()">수정</button>
			 <button type="button" id="listBtn" class="btn" onclick="noticeList()">목록</button>
			 </c:if>
			 </td>
		</tr>
</table>