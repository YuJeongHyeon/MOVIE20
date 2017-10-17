<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
 <form action="DispatcherServlet" method="post" >
 <input type="hidden" name="command" value="updateReview"></input>
 <input type="hidden" name="rno" value="${requestScope.rvo.rno}"></input>
  
   <table class="table" >
    <tr>
    <td>제목 &nbsp;&nbsp;
     <input type="text" value="${requestScope.rvo.title}" name="title"required="required">
    </td>
    </tr>   
    <tr>
     <td>     
     <textarea cols="90" rows="15" required="required" name="content">${requestScope.rvo.content }</textarea>
     </td>
    </tr> 
     </table>    
     <div class="btnArea">
     <button type="submit" class="btn" >수정</button>  
     <button type="reset" class="btn" >취소</button>   
    </div>  
  </form>