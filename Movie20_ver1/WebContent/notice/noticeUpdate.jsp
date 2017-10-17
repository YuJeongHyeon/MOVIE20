<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
	$(document).read
</script>
<form action="${pageContext.request.contextPath}/DispatcherServlet" method="post" >
 <input type="hidden" name="command" value="cmdUpdateNotice"></input>	
 <input type="hidden" name="nNo" value="${nvo.nNo}"></input>
 <input type="hidden" name="masterId" value="${nvo.masterId}">
   <table class="table">
    <tr>
    <td>제목 &nbsp;&nbsp;
     <input type="text" name="title" value="${nvo.title}" required="required">
    </td>
    </tr>   
    <tr>
     <td>     
     <textarea cols="90" rows="15" name="content" required="required" >${nvo.content}</textarea>
     </td>
    </tr> 
     </table>  
     <input type="radio" id="general" name="important" value="일반">일반
     <input type="radio" id="important" name="important" value="중요">중요 
     <div class="btnArea">
     <button type="submit" class="btn" >수정</button>  
     <button type="reset" class="btn" >취소</button>   
    </div>  
  </form>