<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
 
 
 <h4>' <b class="searchWord"> ${requestScope.searchWord} </b> '에 대한 영화 통합검색결과 입니다.</h4>
    
<br>

<p>영화 ( ${requestScope.totalCount} 건)</p>
	<table class="searchTable" >
		<tbody >	
		<c:forEach items="${requestScope.serchListVO.list}" var="s">
				<tr>
				<th rowspan="3" class="searchImgTh">
				<a href="DispatcherServlet?command=MovieDetail&movieNo=${s.mNo}">
				<img class="searchImg" src="${pageContext.request.contextPath}/img/${s.picture}">
				</a>
				</th>
				<td> <a href="DispatcherServlet?command=MovieDetail&movieNo=${s.mNo}">${s.title}</a> </td>
				</tr>				
				<tr><td>${s.genre}  |  ${s.runtime}  |  ${s.playdate} </td></tr>
				<tr><td>감독: ${s.director}  |  출연: ${s.character}  |  등급: ${s.grade}</td></tr>	
		</c:forEach>		
		
		</tbody>	
				
	</table>
 	<br>	
 	<hr>
<div class="pagingInfo pagingDiv" style="text-align: center;">
	<%-- 코드를 줄이기 위해 pb 변수에 pagingBean을 담는다. --%>
	<c:set var="pb" value="${requestScope.serchListVO.pb}"></c:set>
	<!-- 
			step2 1) 이전 페이지 그룹이 있으면 화살표 보여준다
				   		페이징빈의 previousPageGroup 이용 
				   2)  이미지에 이전 그룹의 마지막 페이지번호를 링크한다. 
				   	    hint)   startPageOfPageGroup-1 하면 됨 		 
	 -->  
	<!-- step1. 1)현 페이지 그룹의 startPage부터 endPage까지 forEach 를 이용해 출력한다
				   2) 현 페이지가 아니면 링크를 걸어서 서버에 요청할 수 있도록 한다.
				      현 페이지이면 링크를 처리하지 않는다.  
				      PagingBean의 nowPage
				      jstl choose 를 이용  
				      예) <a href="DispatcherServlet?command=list&pageNo=...">				   
	 -->	
	<ul class="pagination">
		<c:if test="${pb.previousPageGroup}">	
		<li><a href="DispatcherServlet?command=cmdMovieSearch&pageNo=${pb.startPageOfPageGroup-1}&searchWord=${requestScope.searchWord}">&laquo;</a></li>
		</c:if>
		<c:forEach var="i" begin="${pb.startPageOfPageGroup}" 
		end="${pb.endPageOfPageGroup}">
		<c:choose>
		<c:when test="${pb.nowPage!=i}">
		<li><a href="DispatcherServlet?command=cmdMovieSearch&pageNo=${i}&searchWord=${requestScope.searchWord}">${i}</a></li> 
		</c:when>
		<c:otherwise>
		<li class="active"><a href="#" >${i}</a></li>
		</c:otherwise>
		</c:choose>
		&nbsp;
		</c:forEach>
		<c:if test="${pb.nextPageGroup}">	
		<li><a href="DispatcherServlet?command=cmdMovieSearch&pageNo=${pb.endPageOfPageGroup+1}&searchWord=${requestScope.searchWord}">&raquo;</a></li>
		</c:if>
	</ul>	 		
	</div> 	
	<!-- 
			step3 1) 다음 페이지 그룹이 있으면 화살표 보여준다. 
				   		페이징빈의 nextPageGroup 이용 
				   2)  이미지에 이전 그룹의 마지막 페이지번호를 링크한다. 
				   	    hint)   endPageOfPageGroup+1 하면 됨 		 
	 -->   