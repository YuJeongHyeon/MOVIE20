<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<table class="table">
	<thead>
		<tr>
			<th> 이미지 </th> <th>날짜</th> <th>위치</th> <th> 영화제목 </th> <th> 런타임 </th> 
		</tr>
	</thead>
	<tbody>
			<c:forEach items="${meetList}" var="me">
				<tr>
					<td><img src="${pageContext.request.contextPath}/img/${me.picture}"
					style="width: 100px; height: 150px;"></td>
					<td>
<a href="${pageContext.request.contextPath}/DispatcherServlet?command=cmdSeatReservationForm&picture=${me.picture}&title=${me.title}&meetingDate=${me.meetingDate}">
					${me.meetingDate}
					</a></td><td>${me.location}</td>
					<td>${me.title}</td><td>${me.runtime}</td>
				</tr>
			</c:forEach>
	</tbody>

</table>

