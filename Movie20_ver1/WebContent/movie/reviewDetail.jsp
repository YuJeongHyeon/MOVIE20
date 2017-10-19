<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">    
    
<table  class="table table-hover">
<tbody>
<tr>
	<td >제목</td><td colspan="2">${rvo.title }</td>
	<td >작성자 </td><td>${rvo.id }</td>
<tr>
	<td colspan="5">내용</td></tr>
<tr>
	<td colspan="5">${rvo.content }</td>
</tr>
 <c:if test="${sessionScope.membervo.id==rvo.id}">
 
	<tr>	
		<td colspan="1"><input type="button" value="리뷰 수정" id="updateReview" onClick="location.href='DispatcherServlet?command=updateReviewform&rno=${rvo.rno}'" class="btn btn-primary" width="10%"
></td>
		<td colspan="4"><input type="button" value="삭제" id="deleteReview" onClick="location.href='DispatcherServlet?command=deleteReview&rno=${rvo.rno}&movieno=${rvo.mno}'" class="btn btn-primary" width="10%">	</td>
	<tr>
</c:if>
 <tr>
	<td colspan="5"><input type="button" value="뒤로가기" id="back" onClick="location.href='DispatcherServlet?command=MovieDetail&movieNo=${rvo.mno}'" class="btn btn-primary" width="10%">	</td>
	
</tr>
</tbody>

<c:if test="${sessionScope.membervo.id!=null}">
	<form method="post" action="DispatcherServlet?id=${sessionScope.membervo.id}&rno=${rvo.rno}&mno=${requestScope.rvo.mno }">
		<input type="hidden" name="command" value="cmdCommentWrite">
	<table  class="table table-hover">
	<tbody>
		<tr>
			<td >작성자 </td><td>${sessionScope.membervo.id}</td>
			<td>댓글</td><td><input type='text' name="content" ></td>
			<td align="left"><input type="submit" value="댓글등록" class="btn btn-primary" width="15%"></td>
		</tr>
		
	</tbody>

	</table>
	</form>
</c:if>

</table>


<table class="table table-bordered  table-hover boardlist">
		<thead>
		<tr class="success">
			<th>번호</th>
			<th class="comment">댓글내용</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>기타</th>
			</tr>
		</thead>
		<tbody>						
			<c:forEach var="cvo" items="${requestScope.clist}">
							
			<tr>			
				<td id='cno'>
										${cvo.cno }
				</td>
			<td class='comment' >${cvo.content }</td>
				<td>${cvo.id }</td>
				<td>${cvo.writetime }</td>
				<c:choose>
				<c:when test="${sessionScope.membervo.id==cvo.id}">
					<td>
						<input type="button" value="삭제" id="cmddeleteComment" onClick="location.href='DispatcherServlet?command=cmddeleteComment&cno=${cvo.cno}&rno=${requestScope.rvo.rno }&mno=${requestScope.rvo.mno }'">
					</td>
				</c:when>
				<c:otherwise>
					<td></td>
				</c:otherwise>
				</c:choose>
			</tr>	
			</c:forEach>	
			
 

		</tbody>					
	</table>	
