<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
$( '.top' ).click( function() {
  $( 'html, body' ).animate( { scrollTop : 0 }, 400 );
  return false;
} );
</script>
<c:choose>
	<c:when test="${sessionScope.membervo!=null}">
			 <div class="well right"  id="RightScrollspy" data-spy="affix">
					<div>
						<c:forEach items="${sessionScope.membervo.cart}" var="c" >
								 <a href="${pageContext.request.contextPath}/DispatcherServlet?command=MovieDetail&movieNo=${c.mNo}">
								 <img id="cartImg" src="${pageContext.request.contextPath}/img/${c.picture}"></a>
								  <br>
						</c:forEach>
					</div>
					<hr>
					<div>
						   <p style="font-size: 20px; text-align: center;"><a href="#" class="top">Top</a></p>
					</div>
						      
			</div>	
	</c:when>
	<c:otherwise>
	
	</c:otherwise>
</c:choose>
