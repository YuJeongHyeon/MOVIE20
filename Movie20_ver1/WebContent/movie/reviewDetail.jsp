<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table  class="table table-hover">
<tbody>
<tr>
<td >제목</td><td>${rvo.title }</td>
<td >작성자 </td><td>${rvo.id }</td>
<tr>
<td colspan="4">내용</td></tr>
<tr>
<td colspan="4">${rvo.content }</td>
</tr>
<%--  <c:if test=(${sessionScope.mvo.id!=null&&sessionScope.mvo.id==rvo.id})>
 
	<tr>	
		<td><input type="button" value="수정" id="updateReview" onClick="location.href='DispatcherServlet?command=updateReviewform&rno=${rvo.rno}'"
></td>
		<td><input type="button" value="삭제" id="deleteReview" onClick="location.href='DispatcherServlet?command=deleteReview&rno=${rvo.rno}'">	</td>
	<tr>
</c:if>  --%>
 <tr>
	<td colspan="4"><input type="button" value="뒤로가기" id="back" onClick="location.href='DispatcherServlet?command=MovieDetail&movieNo=${rvo.mno}'">	</td>
	
</tr>
</tbody>

</table>
