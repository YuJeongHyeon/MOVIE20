<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script type="text/javascript">

	function searchMovie(){
		
		//alert("111");
	}

</script>
    
	
	<ul class="nav navbar-nav navbar-left">
		<li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	</ul>
	
	
	<form class="navbar-form navbar-right" action="DispatcherServlet" onclick="searchMovie()"
	name="searchForm">
	<input type="hidden" value="cmdMovieSearch" name="command">
      <div class="form-group searchForm">
        <input type="text" class="form-control search" placeholder="영화 검색"  autocomplete="name"
        name="searchWord" required="required">
      </div>
      <button type="submit" class="btn btn-default">검색</button>
    </form>
	
    
	
<br>
	 <hr>