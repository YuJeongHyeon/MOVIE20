<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#general").prop("checked",true);
	});
</script>
<form action="${pageContext.request.contextPath}/DispatcherServlet"
	method="post">
	<input type="hidden" name="command" value="cmdNoticeWrite">
	<table>
		<tr>
			<td>제목 &nbsp;&nbsp; <input type="text" name="title"
				placeholder="공지사항 제목을 입력하세요" required="required">
			</td>
		</tr>
		<tr>
			<td><textarea cols="90" rows="15" name="content"
					required="required" placeholder="공지사항 내용을 입력하세요"></textarea></td>
		</tr>
	</table>
	<input type="radio" id="general" name="important" value="일반">일반
	<input type="radio" id="important" name="important" value="중요">중요
    <input type="submit" value="등록">
</form>















