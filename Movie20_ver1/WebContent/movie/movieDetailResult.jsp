<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-bordered  table-hover boardlist">
		<thead>		
		<tbody>						
			<c:forEach var="mvo" items="${requestScope.mvo}">
						
			<tr>
				<td rowspan='4'><img src="${pageContext.request.contextPath}/img/${mvo.picture }"></td>
			    <td>영화 제목</td>
				<td>${mvo.title }</td>
				<td>감독</td>
				<td>${mvo.director }</td>				
			</tr>
			<tr>
				<td>장르</td>
				<td>${mvo.genre }</td>
			    <td>출연</td>
				<td>${mvo.character }</td>								
			</tr>
			<tr>
			    <td>상영시간</td>
				<td>${mvo.runtime }</td>
				<td>상영여부</td>
				<td>${mvo.viewingcheck }</td>				
			</tr>
			<tr>
			    <td>개봉일</td>
				<td>${mvo.playdate }</td>
				<td>등급</td>
				<td>${mvo.grade }</td>				
			</tr>
			
			<tr>
			    <td colspan='4'>줄거리</td>
								
			</tr>	
			<tr>
				<td colspan='4'>${mvo.summary }</td>
			</tr>
			</c:forEach>	
			
 

		</tbody>					
	</table>
	<c:if test="${sessionScope.mvo.id!=null}">
<form method="post" action="DispatcherServlet?id=${sessionScope.mvo.id}&title=rtitle&content=rcontent&mno=${mvo.mno }">
		<input type="hidden" name="command" value="reviewWrite">
<table  class="table table-hover">
<tbody>
	<tr>
		<td >제목</td><td><input type="text" id="rtitle"> </td>
		<td >작성자 </td><td>${sessionScope.mvo.id}</td>
	<tr>
		<td colspan='4'>내용</td >
	</tr>
	<tr>
		<td colspan='4'><textarea id="rcontent"> </textarea></td>
	</tr>
	<tr>
	<td><input type="submit" value="리뷰등록"></td>
	</tr>
</tbody>

</table>
</form>
</c:if>
	<table class="table table-bordered  table-hover boardlist">
		<thead>
		<tr class="success">
			<th>번호</th>
			<th class="title">제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회</th>
			</tr>
		</thead>
		<tbody>						
				<c:forEach var="rvo" items="${requestScope.rlist.rvo}">				
			<tr>			
				<td><a href="DispatcherServlet?command=reviewDetail&rno=${rvo.rno }">${rvo.rno }</a></td>
				<td><a href="DispatcherServlet?command=reviewDetail&rno=${rvo.rno }">${rvo.title }</a></td>
				<td><a href="DispatcherServlet?command=reviewDetail&rno=${rvo.rno }">${rvo.id }</a></td>
				<td><a href="DispatcherServlet?command=reviewDetail&rno=${rvo.rno }">${rvo.regdate }</a></td>
				<td><a href="DispatcherServlet?command=reviewDetail&rno=${rvo.rno }">${rvo.hits }</a></td>
				</a>
			</tr>	
			</c:forEach>	
			
 

		</tbody>					
	</table>	
	
	<div class="container" >
		 <ul class="pagination" >
		 
		 <c:choose>
		
		 <c:when test="${requestScope.rlist.pb.isPreviousPageGroup()}">
		  	<li><a href="DispatcherServlet?command=list&listpage=${requestScope.rlist.pb.getStartPageOfPageGroup()-1}">Previous</a></li> 
		  </c:when>
		  	</c:choose>
		  	<c:forEach begin='${requestScope.rlist.pb.getStartPageOfPageGroup()}' end='${requestScope.rlist.pb.getEndPageOfPageGroup()}' var='num'>
	   		<c:choose>
	   		<c:when test="${num==requestScope.rlist.pb.nowPage}">
	   			<li><a>${num}</a></li>
	   		</c:when>
	   		<c:otherwise>
	   		<li><a href="DispatcherServlet?command=list&listpage=${num}">${num}</a></li>
			</c:otherwise>
			</c:choose>
			</c:forEach>
    	<c:choose>
	    	<c:when test="${requestScope.rlist.pb.isNextPageGroup()}">  
	    		<li><a href="DispatcherServlet?command=MovieDetail&mNo=${mvo.mno}&listpage=${requestScope.rlist.pb.getEndPageOfPageGroup()+1}">Next</a></li>
	    	</c:when> 
	    	</c:choose>
	 	 </ul>
	 	
 </div>
 
 