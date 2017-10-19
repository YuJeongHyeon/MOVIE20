<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
	function checkUpdate(){
		location.href="${pageContext.request.contextPath}/DispatcherServlet?command=movieUpdateForm&mNo=${requestScope.movievo.mNo}";
	}
	
	function checkDelete(){
		if(confirm("영화를 삭제하시겠습니까?")){
			document.deleteForm.submit();
		}
	}
	
	function registerScore(){
		if(confirm("평점을 등록하시겠습니까?")){
			document.registerScoreForm.submit();
		}
	}
	
</script>

<table class="table table-bordered  table-hover boardlist">
		<thead>		
		<tbody>						
								
			<tr>
				<td rowspan='5'><img src="${pageContext.request.contextPath}/img/${movievo.picture }" id="imgDetail"></td>
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
			    <td>영화<br>전체<br>평점</td>
				<td>${movievo.averageScore} 점</td>
				<c:choose>
					<c:when test="${sessionScope.membervo==null}">
						<td></td>
						<td></td>
					</c:when>
					<c:otherwise>
						<%-- <td><font id="name" style="color: #0066ff;">${sessionScope.membervo.name}</font><br>님의<br>평점</td> --%>
						<td>회원<br>평점</td>
						<td>
							<table class="table">
							<c:choose>
								<c:when test="${svo.score != -1}">
								<tbody>
									<tr>
										<td>
											<font id="name" style="color: #0066ff;">${sessionScope.membervo.name}</font> 님의 평점 : ${svo.score} 점
										</td>
									</tr>
								</tbody>
								</c:when>
								<c:otherwise>
								<tbody>
									<tr>
										<td>
											<form name="registerScoreForm" action="${pageContext.request.contextPath}/DispatcherServlet">
											<input type="hidden" name="command" value="cmdRegisterScore">
											<input type="hidden" name="mNo" value="${requestScope.movievo.mNo }">
											<input type="radio" name="score" value="1">1점
											<input type="radio" name="score" value="2">2점
											<input type="radio" name="score" value="3">3점
											<input type="radio" name="score" value="4">4점
											<input type="radio" name="score" value="5">5점
											<button type="button" id="scoreBtn" class="btn" onclick="registerScore()">평점 등록</button>
											</form>
										</td>
									</tr>
								</tbody>
								</c:otherwise>
								</c:choose>
							</table> 
							<%-- <form name="registerScoreForm" action="${pageContext.request.contextPath}/DispatcherServlet">
							<input type="hidden" name="command" value="cmdRegisterScore">
							<input type="hidden" name="mNo" value="${requestScope.movievo.mNo }">
							<input type="radio" name="score" value="1">1점
							<input type="radio" name="score" value="2">2점
							<input type="radio" name="score" value="3">3점
							<input type="radio" name="score" value="4">4점
							<input type="radio" name="score" value="5">5점
							<button type="button" class="btn" onclick="registerScore()">평점 등록</button>
							</form> --%>
						</td>
					</c:otherwise>
				</c:choose>		
			</tr>
			
			<tr>
			    <td colspan='5'>줄거리</td>
								
			</tr>	
			<tr>
				<td colspan='5'>${requestScope.movievo.summary }</td>
			</tr>
			
			<tr>
				<td colspan="5" align="right">
					<div>
						<c:if test="${sessionScope.membervo.authority eq '관리자'}">
							 <form name="deleteForm" action="${pageContext.request.contextPath}/DispatcherServlet" method="post">
							 	<input type="hidden" name="command" value="movieDelete">
							 	<input type="hidden" name="mNo" value="${requestScope.movieupdatevo.mNo}">
							 </form>
								<input type="button" value="수정" onclick="checkUpdate()" class="btn btn-primary" width="10%">
								<input type="button" value="삭제" onclick="checkDelete()" class="btn btn-primary" width="10%">
						</c:if>
					</div>
				</td>
			</tr>

		</tbody>					
	</table>
	<c:if test="${sessionScope.membervo.id!=null}">
<form method="post" action="DispatcherServlet">
		<input type="hidden" name="command" value="reviewWrite">
		<input type="hidden" name="id" value="${sessionScope.membervo.id}">
		<input type="hidden" name="movieno" value="${movievo.mNo }">
<table  class="table table-hover">
<tbody>
	<tr>
		<td >제목</td><td><input type="text" name="title"> </td>
		<td >작성자 </td><td>${sessionScope.membervo.id}</td>
	<tr>
		<td colspan='5'>내용</td >
	</tr>
	<tr>
		<td colspan='5'><textarea name="content" cols="120"rows="10"> </textarea></td>
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
				<td><a href="DispatcherServlet?command=reviewDetail&rno=${rvo.rno }&movieno=${movievo.mNo }">${rvo.mno }</a></td>
				<td><a href="DispatcherServlet?command=reviewDetail&rno=${rvo.rno }&movieno=${movievo.mNo }">${rvo.title }</a></td>
				<td><a href="DispatcherServlet?command=reviewDetail&rno=${rvo.rno }&movieno=${movievo.mNo }">${rvo.id }</a></td>
				<td><a href="DispatcherServlet?command=reviewDetail&rno=${rvo.rno }&movieno=${movievo.mNo }">${rvo.regdate }</a></td>
				<td><a href="DispatcherServlet?command=reviewDetail&rno=${rvo.rno }&movieno=${movievo.mNo }">${rvo.hits }</a></td>
				
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
 
 