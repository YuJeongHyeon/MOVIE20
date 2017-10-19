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
      
      $("#ticketTable td").click(function(){
         $().text($(this).text()).css("background-color", "#0059b3");
         
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
                      <tr> <th colspan="6" style="text-align: center;">스 크 린</th> </tr>
                         <tr>
                            <td>1</td>
                            <td>2</td>
                            <td>3</td>
                            <td>4</td>
                            <td>5</td>
                         </tr>
                         <tr>
                            <td>6</td>
                            <td>7</td>
                            <td>8</td>
                            <td>9</td>
                            <td>10</td>
                         </tr>
                         <tr>
                            <td>11</td>
                            <td>12</td>
                            <td>13</td>
                            <td>14</td>
                            <td>15</td>
                         </tr>
                         <tr>
                            <td>16</td>
                            <td>17</td>
                            <td>18</td>
                            <td>19</td>
                            <td>20</td>
                         </tr>
                         <tr>
                            <td>21</td>
                            <td>22</td>
                            <td>23</td>
                            <td>24</td>
                            <td>25</td>
                         </tr>
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