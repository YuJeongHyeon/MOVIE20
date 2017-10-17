<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<script type="text/javascript">

	$(document).ready(function() {
		$("#searchInput").keyup(function() {	
				//ajax 통신으로 서버에서 사원과 부서정보를 응답받는다.
				//alert(eno+ " 사번의 사원정보를 요청");		
				var idValue = $(this).val();
				if(idValue == ""){
					$("#checkResult").html("");
				}
			 	$.ajax({
					type:"get",
					url:"DispatcherServlet",
					data:"command=cmdCheckId&id="+idValue,
					dataType:"json",
					success:function(data){
						if(data.flag==1){
							$("#checkResult").html("해당 아이디 존재!").css("background-color", "pink");
						}
						else if(data.flag==0){
							$("#checkResult").html("해당 아이디 없음!!");
						} 
					}
				}); 
		});// keyup
		
	});
</script>

<div>
	<form action="DispatcherServlet" id="idForm">
		<input type="hidden" name="command" value="cmdMemberSearch"> 
		<input type="text" id="searchInput" name="id" placeholder="회원 아이디 검색" required="required" autocomplete="off">
		<input type="submit" value="검색"> 
			<span id="checkResult"></span>
	</form>

</div>


