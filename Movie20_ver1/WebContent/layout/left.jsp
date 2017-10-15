<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div  id="myScrollspy" data-spy="affix" >
		      <ul class="nav nav-pills nav-stacked" >
		        <li><a href="DispatcherServlet?command=cmdMainList">영화 홈</a></li>
		        <li><a href="#section2">공지 사항</a></li>
		        <li><a href="DispatcherServlet?command=hitdahit">히트다 히트!</a></li>
		        <li class="dropdown">
		          <a class="dropdown-toggle" id="gerneA" data-toggle="dropdown" href="#">장르별 <span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="#section41">Section 4-1</a></li>
		            <li><a href="#section42">Section 4-2</a></li>
		          </ul>
		        </li>
		      </ul>
	</div>