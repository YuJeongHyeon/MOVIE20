<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>home</title>
	
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">

  
</head>

<body>


<!--  left -->		
	
	  <div class="col-sm-2 left" data-spy="scroll" data-target="#myScrollspy" >
		<jsp:include page="left.jsp"></jsp:include>
	  </div>
	    
<!--  header -->	
		<div class="col-sm-8">
			
			<div class="container-fluid">
		 		<div class="collapse navbar-collapse" id="myNavbar">
		 		
					<jsp:include page="header.jsp"></jsp:include>
					
				</div>
			</div>				
					
<!--  main -->							
		 <div class="main"> 
		 dd
					<%--  <c:import url="${requestScope.url}"></c:import> --%> 
		 </div>
			    
<!--  footer -->				    
		<footer class="container-fluid text-center">
	  			<jsp:include page="footer.jsp"></jsp:include>
		</footer>
			   
		</div>
			  
<!--  right -->		  
		<div class="col-sm-2 rigth" data-spy="scroll" data-target="#RightScrollspy" >
			     
			<jsp:include page="right.jsp"></jsp:include>
	    </div>


</body>
</html>

