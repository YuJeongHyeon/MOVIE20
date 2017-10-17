<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    

<meta charset="UTF-8">
<title>회원 정보 수정</title>
<script type="text/javascript">
$(document).ready(function(){ 
	
	 $("#favoriteGenre").val("${memberVo.favoriteGenre}").attr("selected", "selected");
	
	
	   $("#registerForm").submit(function() {
	      var rf=document.registerForm;
	      var password=rf.password.value;
	      var repeatPassword=rf.repeatPassword.value;
	      if(password!=repeatPassword){
	         alert("패스워드와 패스워드 확인이 일치하지 않습니다");
	         return false;
	      }
	     
	   });//submit
	  
	});//ready

</script>




   <div class="container">
      <div class="card card-login mx-auto mt-5">
         <div class="card-body">
            <form method="post" name="registerForm" action="DispatcherServlet">
               <input type="hidden" name="command" value="cmdMemberUpdate">
               <input type="hidden" name="id" value="${requestScope.memberVo.id}">
               <div class="form-group">
                   
                  <font color="#0059b3">아이디 : ${requestScope.memberVo.id}</font> <br>
                  <span id="checkResult"></span><br>
                  <font color="#0059b3">패스워드:</font> <input type="password" class="register-control" name="password"  id="password"required="required" value="${requestScope.memberVo.password}"><br>
                  <font color="#0059b3">패스워드 확인:</font> <input type="password" class="register-control" name="repeatPassword" id="repeatPassword" required="required" value="${requestScope.memberVo.password}"><br>
                  <font color="#0059b3">닉네임:</font> <input type="text" class="register-control" name="nick" id="nick" required="required" value="${memberVo.nick}"><br>
                  <font color="#0059b3">이름:</font> <input type="text" class="register-control" name="name" id="name" required="required" value="${memberVo.name}"><br>
                  <font color="#0059b3">주소:</font> <input type="text" class="register-control" name="address" id="address" required="required" value="${memberVo.address}"> <br>
                  <font color="#0059b3">생일 : ${memberVo.birthday}</font><br>
                  <font color="#0059b3">번호:</font> <input type="tel" class="register-control" name="tel" id="tel" required="required" value="${memberVo.tel}"> <br>
                  <br> 
                  <strong>[선호장르]</strong><br>
                  <select name="favoriteGenre" id="favoriteGenre" >
                     <option value="공포" >공포</option>
                     <option value="로맨스">로맨스</option>
                     <option value="액션">액션</option>
                     <option value="코믹">코믹</option>
                     <option value="19">19</option>
                  </select>
                  <br><br><br>
                  <input type="submit" value="회원 정보 수정" class="btn btn-primary btn-block">
               </div>
            </form>

            <!-- Bootstrap core JavaScript-->
            <script src="../vendor/jquery/jquery.min.js"></script>
            <script src="../vendor/popper/popper.min.js"></script>
            <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>
            <!-- Core plugin JavaScript-->
            <script src="../vendor/jquery-easing/jquery.easing.min.js"></script>
         </div>
      </div>
   </div>
