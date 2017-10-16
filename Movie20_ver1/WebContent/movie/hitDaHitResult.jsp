<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table id="mainTable">
	<tr>
		<c:forEach items="${requestScope.lvo.list}" var="mvo" varStatus="cnt">
			<c:if test="${cnt.count<5}">
				<td align="center"><img class="mainImg" src="img/${mvo.picture}"><br>${mvo.hits}</td>
			</c:if>
		</c:forEach>
	</tr>
	<tr>
		<c:forEach items="${requestScope.lvo.list}" var="mvo" varStatus="cnt">
			<c:if test="${cnt.count>4}">
				hit: <td align="center"><img class="mainImg" src="img/${mvo.picture}"><br>${mvo.hits}</td>
			</c:if>
		</c:forEach>
	</tr>
</table>

<br>
<hr>
<br>
<div class="pagingInfo pagingDiv">
	<c:set var="pb" value="${requestScope.lvo.mpb}"></c:set>
	<ul class="pagination">
		<c:if test="${pb.previousPageGroup}">
			<li><a
				href="DispatcherServlet?command=cmdMainList&pageNo=${pb.startPageOfPageGroup-1}">&laquo;</a></li>
		</c:if>
		<c:forEach var="i" begin="${pb.startPageOfPageGroup}"
			end="${pb.endPageOfPageGroup}">
			<c:choose>
				<c:when test="${pb.nowPage!=i}">
					<li><a
						href="DispatcherServlet?command=cmdMainList&pageNo=${i}">${i}</a></li>
				</c:when>
				<c:otherwise>
					<li class="active"><a href="#">${i}</a></li>
				</c:otherwise>
			</c:choose>
	&nbsp;
	</c:forEach>
		<c:if test="${pb.nextPageGroup}">
			<li><a
				href="DispatcherServlet?command=cmdMainList&pageNo=${pb.endPageOfPageGroup+1}">&raquo;</a></li>
		</c:if>
	</ul>
</div>