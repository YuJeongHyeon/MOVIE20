<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div>
	<form action="DispatcherServlet">
		<input type="hidden" name="command" value="cmdMemberSearch"> 
		<input type="text" name="id" placeholder="회원 아이디 검색" required="required">
		<input type="submit" value="검색"> 
	</form>
</div>


