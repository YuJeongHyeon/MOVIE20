<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<body>

<table>
	<thead>
		<tr>
			<th>날짜</th> <th>위치</th> <th>영화제목</th> <th>런타임</th> <th>이미지</th>
		</tr>
	</thead>
	<tbody>
			<c:forEach items="${meetList}" var="me">
				<tr>
					<td><a href="승찬이형 페이지로 이동">${me.meetingDate}</a></td><td>${me.location}</td>
					<td>${me.title}</td><td>${me.runtime}</td><td><img src="${pageContext.request.contextPath}/img/${me.picture}"
					style="width: 100px; height: 150px;"></td>
				</tr>
			</c:forEach>
	</tbody>

</table>

	
</body>
</html>