<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
   
   function checkUpdate(){
	   return confirm("모임을 등록 하시겠습니까?");
   }
</script>

	<form action="DispatcherServlet" onsubmit="return checkUpdate()">
		<input type="hidden" name="command" value="cmdMeetingRegister">
		<input type="hidden" name="mNo" value="${mNo}">
		영화 제목: ${title} <br>
		모임 날짜:<input type="text" name="meetingDate" required="required"><br>
		장소:<input type="text" name="location" required="required">
		
		<input type="submit" value="등록">
	</form>
