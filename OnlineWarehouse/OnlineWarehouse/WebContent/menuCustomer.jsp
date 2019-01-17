<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="menu-container">
   <a href="${pageContext.request.contextPath}/index.jsp">Home</a>
  	<form action="productServlet" method="post">
				<input type="submit" value="Products" /></form>
   <a href="${pageContext.request.contextPath}/categories.jsp">Categories</a>
   <form action="cartServlet" method="post">
				<input type="submit" value="Cart" /></form>
   <form action="favouritesServlet" method="post">
				<input type="submit" value="Favourites" /></form>
</div>