<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
 <script type="text/javascript">
   function checkDelete(){	   
	   return confirm("삭제하시겠습니까?");
   }
   function checkUpdate(){
	   var temp = document.updateForm.authority;
	   return confirm(temp.value+"로 권한을 설정하시겠습니까?");
   }
</script>
 
 <c:set value="${sessionScope.searchMember}" var="m"></c:set>
	<table class="table table-inverse table-bordered">
		<thead class="">
		<tr>
		<th>id</th><th>name</th><th>nick</th><th>address</th>
		<th>birth</th><th>tel</th><th>favoriteGenre</th><th>authority</th>
		</tr>
		</thead>
		<tbody>
			<tr>
		<th>${m.id}</th><th>${m.name}</th><th>${m.nick}</th><th>${m.address}</th>
		<th>${m.birthday}</th><th>${m.tel}</th><th>${m.favoriteGenre}</th>
		<th>${m.authority}</th>
			</tr>
		</tbody>
	</table>
		
		<form name="updateForm" action="DispatcherServlet" method="post" onsubmit="return checkUpdate()">
			<input type="hidden" name="command" value="cmdUpdateAuthority">
			<input type="hidden" name="id" value="${m.id}">
				<select name="authority">
					 <option>비매너</option>
                     <option>일반</option>
                     <option>관리자</option>
                </select>
			<input id="btnReviseMember" type="submit" class="btn btn-primary btn-block" value="권한 수정">
		</form>
		<hr>
		<form action="DispatcherServlet" onsubmit="return checkDelete()">
			<input type="hidden" name="command" value="cmdDeleteMember">
			<input type="hidden" name="id" value="${m.id}">
			<input id="btnDeleteMember" type="submit" class="btn btn-primary btn-block" value="회원 삭제">
		</form>
		