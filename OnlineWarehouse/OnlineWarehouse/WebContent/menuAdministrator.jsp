<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="menu-container">
   <a href="${pageContext.request.contextPath}/index.jsp">Home</a>
   <a href="${pageContext.request.contextPath}/addSupplier.jsp">Add Supplier</a>
   <a href="${pageContext.request.contextPath}/manageNewsletter.jsp">Manage Newsletter Requests</a>
   <form action="manageSales" method="post">
				<input type="submit" value="Manage Sales" /></form>
</div>