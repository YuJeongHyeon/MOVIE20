<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
	<c:when test="${sessionScope.membervo.authority eq '관리자'}">
		<div id="myScrollspy" data-spy="affix" >
		       <ul class="nav nav-pills nav-stacked" >
		        <li><a href="${pageContext.request.contextPath}/DispatcherServlet?command=cmdMainList">영화 홈</a></li>
		        <li><a href="${pageContext.request.contextPath}/DispatcherServlet?command=cmdNoticeList">공지 사항</a></li>
		        <li><a href="DispatcherServlet?command=hitdahit">히트 다 히트!</a></li>
		        <li class="dropdown">
		          <a class="dropdown-toggle gerneA" data-toggle="dropdown" href="#"> 장르별 <span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="${pageContext.request.contextPath}/DispatcherServlet?command=genre&genre=액션">액션</a></li>
			            <li><a href="${pageContext.request.contextPath}/DispatcherServlet?command=genre&genre=코미디">코미디</a></li>
			            <li><a href="${pageContext.request.contextPath}/DispatcherServlet?command=genre&genre=멜로">멜로</a></li>
			            <li><a href="${pageContext.request.contextPath}/DispatcherServlet?command=genre&genre=로맨스">로맨스</a></li>
			            <li><a href="${pageContext.request.contextPath}/DispatcherServlet?command=genre&genre=19">19</a></li>
		          </ul>
		        </li>
		        <li class="dropdown">
		          <a class="dropdown-toggle gerneA" data-toggle="dropdown" href="#"> 관리 <span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="#section41">공지사항 관리</a></li>
		            <li><a href="${pageContext.request.contextPath}/DispatcherServlet?command=cmdMemberSearchForm">회원 관리</a></li>
		            <li><a href="#section42">영화 관리</a></li>
		          </ul>
		        </li>
		         <li class="dropdown">
		          <a class="dropdown-toggle gerneA" data-toggle="dropdown" href="#"> 영화 모임 <span class="caret"></span></a>
		          <ul class="dropdown-menu">

		            <li><a href="${pageContext.request.contextPath}/DispatcherServlet?command=cmdMeetingListInfo">정모 정보</a></li>
		
		          </ul>
		        </li>
		      </ul>
		</div>
	</c:when>
	<c:otherwise>
		<div id="myScrollspy" data-spy="affix" >
			      <ul class="nav nav-pills nav-stacked" >
			        <li><a href="${pageContext.request.contextPath}/DispatcherServlet?command=cmdMainList">영화 홈</a></li>
			        <li><a href="${pageContext.request.contextPath}/DispatcherServlet?command=cmdNoticeList">공지 사항</a></li>
			        <li><a href="DispatcherServlet?command=hitdahit">히트 다 히트!</a></li>
			        <li class="dropdown">
			          <a class="dropdown-toggle gerneA" data-toggle="dropdown" href="#"> 장르별 <span class="caret"></span></a>
			          <ul class="dropdown-menu">
			            <li><a href="${pageContext.request.contextPath}/DispatcherServlet?command=genre&genre=액션">액션</a></li>
			            <li><a href="${pageContext.request.contextPath}/DispatcherServlet?command=genre&genre=코미디">코미디</a></li>
			            <li><a href="${pageContext.request.contextPath}/DispatcherServlet?command=genre&genre=멜로">멜로</a></li>
			            <li><a href="${pageContext.request.contextPath}/DispatcherServlet?command=genre&genre=로맨스">로맨스</a></li>
			            <li><a href="${pageContext.request.contextPath}/DispatcherServlet?command=genre&genre=19">19</a></li>
			          </ul>
			        </li>
			         <li class="dropdown">
		          <a class="dropdown-toggle gerneA" data-toggle="dropdown" href="#"> 영화 모임 <span class="caret"></span></a>
		          <ul class="dropdown-menu">

		            <li><a href="${pageContext.request.contextPath}/DispatcherServlet?command=cmdMeetingListInfo">정모 정보</a></li>
		
		          </ul>
		        </li>
			        
			      </ul>
			</div>
	</c:otherwise>
</c:choose>
		
	