<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
	var important = "${requestScope.nvo.important}";
	$(document).ready(function() {
		if(important==$("#general").val()){
			$("#general").prop("checked",true);
		}else{
			$("#important").prop("checked",true);
		}
	});
	function noticeList(){
		location.href="${pageContext.request.contextPath}/DispatcherServlet?command=cmdNoticeList";
	}
</script>
<form action="${pageContext.request.contextPath}/DispatcherServlet" method="post" >
 <input type="hidden" name="command" value="cmdUpdateNotice"></input>	
 <input type="hidden" name="nNo" value="${nvo.nNo}"></input>
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
     <input type="radio" id="general" class="radio1" name="important" value="일반">일반
     <input type="radio" id="important" class="radio1" name="important" value="중요">중요 
     <div class="btnArea">
     <button type="submit" class="btn" >수정</button>  
     <button type="reset" class="btn" >되돌리기</button>  
     <button type="button" id="listBtn" class="btn" onclick="noticeList()">목록</button> 
    </div>  
  </form>