<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
function deleteBoard(){
	if(confirm("게시글을 삭제하시겠습니까?")){
		document.deleteForm.submit();
	}
}
function updateBoard(){
	if(confirm("게시글을 수정하시겠습니까?")){
		location.href="${pageContext.request.contextPath}/DispatcherServlet?command=cmdUpdateFormNotice&nNo=${requestScope.nvo.nNo}";
	}
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
			 <button type="button" class="btn" onclick="deleteBoard()">삭제</button>
			 <button type="button" class="btn" onclick="updateBoard()">수정</button>
			 </c:if>
			 </td>
		</tr>
</table>