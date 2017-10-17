<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
function writeNotice(){
	if(confirm("공지사항을 작성하시겠습니까?")){
		document.writeForm.submit();
	}
}
</script>
<table class="table table-striped">
	<thead>
		<tr>
			<th>NO</th>
			<th>제목</th>
			<th>조회수</th>
			<th>작성일</th>
		</tr>
		<c:forEach var="importnvo" items="${requestScope.importList}">
				<tr>
					<th><font color="red">중요</font></th>
					<th><a
						href="${pageContext.request.contextPath}/DispatcherServlet?command=cmdNoticeDetail&nNo=${importnvo.nNo}"><font color="red">${importnvo.title}</font></a></th>
					<th>${importnvo.hits}</th>
					<th>${importnvo.regdate}</th>
				</tr>
		</c:forEach>
	</thead>
	<tbody>
		<c:forEach var="nvo" items="${requestScope.lvo.list}" varStatus="cnt">
			<tr>
				<th>${nvo.nNo}</th>
				<th><a
					href="${pageContext.request.contextPath}/DispatcherServlet?command=cmdNoticeDetail&nNo=${nvo.nNo}">${nvo.title}</a></th>
				<th>${nvo.hits}</th>
				<th>${nvo.regdate}</th>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4" class="btnArea">
				<c:if test="${sessionScope.membervo.authority eq '관리자'}">
					<form name="writeForm" action="${pageContext.request.contextPath}/DispatcherServlet" method="post">
					<input type="hidden" name="command" value="cmdWriteFormNotice">
					<button type="button" class="btn" onclick="writeNotice()">공지사항작성</button>
					</form>
				</c:if>
			</td>
		<tr>
	</tbody>
</table>
<br>
<hr>
<br>
<div class="pagingInfo">
	<c:set var="pb" value="${requestScope.lvo.npb}"></c:set>
	<ul class="pagination">
		<c:if test="${pb.previousPageGroup}">
			<li><a
				href="DispatcherServlet?command=cmdNoticeList&pageNo=${pb.startPageOfPageGroup-1}">&laquo;</a></li>
		</c:if>
		<c:forEach var="i" begin="${pb.startPageOfPageGroup}"
			end="${pb.endPageOfPageGroup}">
			<c:choose>
				<c:when test="${pb.nowPage!=i}">
					<li><a
						href="DispatcherServlet?command=cmdNoticeList&pageNo=${i}">${i}</a></li>
				</c:when>
				<c:otherwise>
					<li class="active"><a href="#">${i}</a></li>
				</c:otherwise>
			</c:choose>
	&nbsp;
	</c:forEach>
		<c:if test="${pb.nextPageGroup}">
			<li><a
				href="DispatcherServlet?command=cmdNoticeList&pageNo=${pb.endPageOfPageGroup+1}">&raquo;</a></li>
		</c:if>
	</ul>
</div>

