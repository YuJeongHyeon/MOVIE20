<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){ 
	$("#registerForm").submit(function() {
		var rf=document.registerForm;
		var password=rf.password.value;
		var repeatPassword=rf.repeatPassword.value;
		if(password!=repeatPassword){
			alert("패스워드와 패스워드 확인이 일치하지 않습니다");
			return false;
		}
		if($("#checkResult").text()=="사용불가" || $("#checkResult").text()=="아이디는 4자이상 10자 이하이여만 합니다"){
			alert("인증받은 아이디가 아닙니다");
			return false;
		}
	});//submit
	$("#id").keyup(function() {
			var idValue=$(this).val();
			if(idValue.length<4||idValue.length>10){
				$("#checkResult").html("아이디는 4자이상 10자 이하이여만 합니다").css("background-color","pink");
			}else{
				$.ajax({
				type:"get",
				url:"${pageContext.request.contextPath}/DispatcherServlet",
				data:"command=idCheck&id="+idValue,
				success:function(data){
					if(data=="ok"){
						$("#checkResult").html("사용가능").css("background-color","yellow");
					}else{
						$("#checkResult").html("사용불가").css("background-color","red");
					}//else
				}//success
			});//ajax
			}//else
	});//keyup
});//ready
</script>
</head>
<body class="bg-dark">
    <div class="card mb-3">
   <div class="card-header">
         <i class="fa fa-table"></i>회원 가입
      </div>
   <div class="card-body">
    <div class="table-responsive">
     	 <form method="post" id="registerForm" name="registerForm" action="${pageContext.request.contextPath}/DispatcherServlet" onsubmit="return checkForm()">
               <input type="hidden" name="command" value="register">
          <table class="table table-bordered" id="dataTable" style="width:100%;cellspacing:20px;">
            <tr>
               <th width="200">아이디</th>
               <td colspan="3">
               <input type="hidden" name="command" value="idcheck">
               <input type="text" class="register-control" id="id" name="id" required="required">
               <span id="checkResult"></span>
               </td>
            </tr>
            <tr>
               <th>패스워드</th>
               <td colspan="3"><input type="password" class="register-control" name="password" required="required"></td>
            </tr>
            <tr>
               <th>패스워드 확인</th>
               <td colspan="3"><input type="password" class="register-control" name="repeatPassword" required="required"></td>
            </tr>
            <tr>
               <th>닉네임</th>
               <td colspan="3"> <input type="text" class="register-control" name="nick" required="required">
                  </td>
            </tr>
            <tr>
               <th>이름</th>
               <td colspan="3"><input type="text" class="register-control" name="name" required="required"></td>
            </tr>
            <tr>
               <th>주소 </th>
               <td colspan="3"><input type="text" class="register-control" name="address" required="required"> </td>
            </tr>
            <tr>
               <th>생일</th>
               <td colspan="3"><input type="date" class="register-control" name="birth" required="required"></td>
            </tr>
            <tr>
               <th>번호 </th>
               <td colspan="3"><input type="tel" class="register-control" name="tel" required="required"></td>
            </tr>
            <tr>
               <th>  선호장르</th>
               <td colspan="3">
                  <select name="favoriteGenre">
                  	<option>공포</option>
                  	<option>로맨스</option>
                  	<option>액션</option>
                  	<option>코믹</option>
                  	<option>19</option>
                  </select></td>
            </tr>
            <tr>
               <td colspan="4">
                  <input type="submit" value="회원가입" id="registersubmit">
               </td>
            </tr>
         </table>
      </form>
            <!-- Bootstrap core JavaScript-->
            <script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
            <script src="${pageContext.request.contextPath}/vendor/popper/popper.min.js"></script>
            <script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>
            <!-- Core plugin JavaScript-->
            <script src="${pageContext.request.contextPath}/vendor/jquery-easing/jquery.easing.min.js"></script>
         </div>
      </div>
   </div>
</body>
</html>