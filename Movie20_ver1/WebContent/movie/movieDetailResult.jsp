<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-bordered  table-hover boardlist">
		<thead>		
		<tbody>						
								
			<tr>
				<td rowspan='4'><img src="${pageContext.request.contextPath}/img/${movievo.picture }"></td>
			    <td>영화 제목</td>
				<td>${requestScope.movievo.title }</td>
				<td>감독</td>
				<td>${requestScope.movievo.director }</td>				
			</tr>
			<tr>
				<td>장르</td>
				<td>${requestScope.movievo.genre }</td>
			    <td>출연</td>
				<td>${requestScope.movievo.character }</td>								
			</tr>
			<tr>
			    <td>상영시간</td>
				<td>${requestScope.movievo.runtime }</td>
				<td>상영여부</td>
				<td>${requestScope.movievo.viewingcheck }</td>				
			</tr>
			<tr>
			    <td>개봉일</td>
				<td>${requestScope.movievo.playdate }</td>
				<td>등급</td>
				<td>${requestScope.movievo.grade }</td>				
			</tr>
			
			<tr>
			    <td colspan='4'>줄거리</td>
								
			</tr>	
			<tr>
				<td colspan='4'>${requestScope.movievo.summary }</td>
			</tr>
			
			
 

		</tbody>					
	</table>
	<c:if test="${sessionScope.membervo.id!=null}">
<form method="post" action="DispatcherServlet?id=${sessionScope.membervo.id}&title=rtitle&content=rcontent&movieno=${movievo.mNo }">
		<input type="hidden" name="command" value="reviewWrite">
<table  class="table table-hover">
<tbody>
	<tr>
		<td >제목</td><td><input type="text" id="rtitle"> </td>
		<td >작성자 </td><td>${sessionScope.membervo.id}</td>
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
			<c:forEach var="rvo" items="${requestScope.listVO.list}">				
			<tr>			
				<td><a href="DispatcherServlet?command=reviewDetail&rno=${rvo.rno }">${rvo.rno }</a></td>
				<td><a href="DispatcherServlet?command=reviewDetail&rno=${rvo.rno }">${rvo.title }</a></td>
				<td><a href="DispatcherServlet?command=reviewDetail&rno=${rvo.rno }">${rvo.id }</a></td>
				<td><a href="DispatcherServlet?command=reviewDetail&rno=${rvo.rno }">${rvo.regdate }</a></td>
				<td><a href="DispatcherServlet?command=reviewDetail&rno=${rvo.rno }">${rvo.hits }</a></td>
				
			</tr>	
			</c:forEach>	
			
 

		</tbody>					
	</table>	
	
	<div class="container" >
		 <ul class="pagination" >
		 
		 <c:choose>
		
		 <c:when test="${requestScope.listVO.pb.isPreviousPageGroup()}">
		  	<li><a href="DispatcherServlet?command=MovieDetail&movieNo=${movievo.mNo}&pageNo=${requestScope.listVO.pb.getStartPageOfPageGroup()-1}">Previous</a></li> 
		  </c:when>
		  	</c:choose>
		  	<c:forEach begin='${requestScope.listVO.pb.getStartPageOfPageGroup()}' end='${requestScope.listVO.pb.getEndPageOfPageGroup()}' var='num'>
	   		<c:choose>
	   		<c:when test="${num==requestScope.listVO.pb.nowPage}">
	   			<li><a>${num}</a></li>
	   		</c:when>
	   		<c:otherwise>
	   		<li><a href="DispatcherServlet?command=MovieDetail&movieNo=${movievo.mNo}&pageNo=${num}">${num}</a></li>
			</c:otherwise>
			</c:choose>
			</c:forEach>
    	<c:choose>
	    	<c:when test="${requestScope.listVO.pb.isNextPageGroup()}">  
	    		<li><a href="DispatcherServlet?command=MovieDetail&movieNo=${movievo.mNo}&pageNo=${requestScope.listVO.pb.getEndPageOfPageGroup()+1}">Next</a></li>
	    	</c:when> 
	    	</c:choose>
	 	 </ul>
	 	
 </div> 
 
 