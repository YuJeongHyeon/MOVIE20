<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
  <!-- Bootstrap core CSS-->
  <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="../css/sb-admin.css" rel="stylesheet">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script type="text/javascript">
  $(document).ready(function(){
	     var ticket = [];
		   var table = $("#ticketTable td");
		   //alert(table.length);
	      var seatList = ${requestScope.seatList};
	       for(var i=0; i<seatList.length; i++){
		   
	    	   //에러 나는 위치
		     for(var j=1; j<=table.length; j++){
		    	// alert($("#"+j).text());
		    	 if($("#"+j).text()==seatList[i].toString()){
		    		
		    		 $("#"+j).css('background-color', 'red');
		    		// alert($("#"+j).css("background-color"));
		    	 }//if 
	    	  }//for j
	      }//for i
	       
	       
	       
	      $("#ticketTable td").click(function(){
	         
	    	  if($(this).css("background-color")== "rgb(255, 0, 0)"){    		  
	    		  alert("이미 예약된 좌석입니다.!");
	    	  }else{
	    		   if($(this).css("background-color")=="rgb(255, 255, 255)"){
			            if($("#ticketInfo").text() == ""){
			                 $(this).css("background-color", "#0059b3")
			                 ticket.push($(this).text());
			            }
		          }else{
		              $(this).css("background-color", "white")
		              var remove = $(this).text();
		              ticket = $.grep(ticket, function(data){
		                 return remove!=data;
		              });
		          }
		         
		           $("#ticketInfo").text(ticket.toString());
		           $("#seatChk").val(ticket.toString());
	    	  }	      

	      });
	     });
  </script>


<div class="bg-dark">
  <div class="seat-container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">좌석 예약</div>
      
      <div class="card-body">
      
      <div  style="size: inherit;">
      
          
          <div class="form-group">
             
           <table class="table table-bordered" id="ticketTableForm">
             <tbody>
   
                  <tr>
                     <td align="center">
                      <img src="${pageContext.request.contextPath}/img/${meetingData.picture}" width=300 height=400>
                   </td>
                   <td>
                      <table class="table table-bordered" id="ticketTable">
                      	<tr ><th colspan="6" style="text-align: center;">스크린</th> </tr>
                         <tr>
                            <td id="1">1</td>
                            <td id="2">2</td>
                            <td id="3">3</td>
                            <td id="4">4</td>
                            <td id="5">5</td>
                         </tr>
                         <tr>
                            <td id="6">6</td>
                            <td id="7">7</td>
                            <td id="8">8</td>
                            <td id="9">9</td>
                            <td id="10">10</td>
                         </tr>
                         <tr>
                            <td id="11">11</td>
                            <td id="12">12</td>
                            <td id="13">13</td>
                            <td id="14">14</td>
                            <td id="15">15</td>
                         </tr>
                         <tr>
                            <td id="16">16</td>
                            <td id="17">17</td>
                            <td id="18">18</td>
                            <td id="19">19</td>
                            <td id="20">20</td>
                         </tr>
                         <tr>
                            <td id="21">21</td>
                            <td id="22">22</td>
                            <td id="23">23</td>
                            <td id="24">24</td>
                            <td id="25">25</td>
                         </tr>
                           
                      </table>
                      
                      <table>
                      		<tbody>
                      			<tr>
                         			<th style="background-color: #0059b3;"> 선택 좌석 </th> &nbsp;<th style="background-color: red;"> 예          약 </th>
                     			  </tr>
                      		</tbody>
                      </table>
                      
                  <tr>
                     <td colspan="3">
                           영화명 : ${requestScope.meetingData.title}  &nbsp;&nbsp;&nbsp;&nbsp;
                           장소: ${requestScope.meetingData.location} &nbsp;&nbsp;&nbsp;&nbsp;
                           일시: ${requestScope.meetingData.meetingDate} &nbsp;&nbsp;&nbsp;&nbsp;
                     </td>
                  </tr>
             </tbody>
           </table>
           
           <div>
              예약좌석: ${requestScope.seatNum}
           </div>
           
           <div align="right">
              <span id="ticketInfo"></span>
           </div>
          </div>
         <c:choose>
         	<c:when test="${requestScope.seatNum eq null}">
         		<form action="${pageContext.request.contextPath}/DispatcherServlet" method="post">  
		          <div align="right">
		          	<input type="hidden" value="cmdSeatReservation" name="command"> 
		               <input type="hidden" id="seatChk" value="" name="seatNum"> 
		               <input type="hidden"  value="${requestScope.meetingData.meetingDate}" name="meetingDate"> 
		             	<input type="submit" value="예약" class="btn btn-primary active">
		          </div>
        		</form>
         	</c:when>
         	<c:otherwise>
			 	<form action="${pageContext.request.contextPath}/DispatcherServlet" method="post">  
			        <div align="right">
			          	<input type="hidden" value="cmdUpdateSeatReservation" name="command"> 
			            <input type="hidden" id="seatChk" value="" name="seatNum"> 
			            <input type="hidden"  value="${requestScope.meetingData.meetingDate}" name="meetingDate"> 
			            <input type="submit" value="수정" class="btn btn-primary active">
			         </div>
			    </form>
			    <form action="${pageContext.request.contextPath}/DispatcherServlet" method="post">  
			        <div align="right">
			          	<input type="hidden" value="cmdDeleteSeatReservation" name="command"> 
			            <input type="hidden" id="seatChk" value="${requestScope.seatNum}" name="seatNum"> 
			            <input type="hidden"  value="${requestScope.meetingData.meetingDate}" name="meetingDate"> 
			            <input type="submit" value="예약취소" class="btn btn-primary active">
			         </div>
			    </form>            	
         	</c:otherwise>
         </c:choose>
         
        </div>
      </div>
      
    </div>
  </div>
  <!-- Bootstrap core JavaScript-->
  <script src="../vendor/jquery/jquery.min.js"></script>
  <script src="../vendor/popper/popper.min.js"></script>
  <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="../vendor/jquery-easing/jquery.easing.min.js"></script>
</div>