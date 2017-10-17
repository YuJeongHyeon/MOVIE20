<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	function checkUpdate(){
		return confirm("수정하시겠습니까?");
	}	
</script>    
    
    
<form action="DispatcherServlet" method="post">
	<input type="hidden" value="movieUpdate" name="command">
	<input type="hidden" value="${requestScope.movieupdatevo.mNo}" name="mNo">
	<table class="table table-bordered  table-hover boardlist">
		<thead>		
		<tbody>
			<tr>						
			<tr>
				<td rowspan='4'><img src="${pageContext.request.contextPath}/img/${movieupdatevo.picture }" id="imgDetail"></td>
			    <td>영화 제목</td>
				<td><input type="text" value="${requestScope.movieupdatevo.title}" name="title"></td>
				<td>감독</td>
				<td><input type="text" value="${requestScope.movieupdatevo.director}" name="director"></td>				
			</tr>
			<tr>
				<td>장르</td>
				<td><input type="text" value="${requestScope.movieupdatevo.genre}" name="genre"></td>
			    <td>출연</td>
				<td><input type="text" value="${requestScope.movieupdatevo.character}" name="character"></td>								
			</tr>
			<tr>
			    <td>상영시간</td>
				<td><input type="text" value="${requestScope.movieupdatevo.runtime}" name="runtime"></td>
				<td>상영여부</td>
				<td><input type="text" value="${requestScope.movieupdatevo.viewingcheck}" name="viewingcheck"></td>				
			</tr>
			<tr>
			    <td>개봉일</td>
				<td><input type="text" value="${requestScope.movieupdatevo.playdate}" name="playdate"></td>
				<td>등급</td>
				<td><input type="text" value="${requestScope.movieupdatevo.grade}" name="grade"></td>				
			</tr>
			
			<tr>
			    <td colspan='5'>줄거리</td>
			</tr>	
			<tr>
				<td colspan="5"><input type="text" value="${requestScope.movieupdatevo.summary}" name="summary"></td>								
			</tr>
			<tr>
				<td colspan="5" align="right">
					<input type="submit" value="수정" onsubmit="return checkUpdate()" class="btn btn-primary" width="10%">
				</td>
			</tr>
		</tbody>
	</table>
</form>    