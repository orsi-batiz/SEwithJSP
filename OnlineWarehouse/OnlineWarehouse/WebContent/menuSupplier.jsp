<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="menu-container">
   <a href="${pageContext.request.contextPath}/index.jsp">Home</a>
   <a href="${pageContext.request.contextPath}/addProduct.jsp">Add Product</a>
   <a href="${pageContext.request.contextPath}/writeNewsletter.jsp">Write Newsletter</a>
   <form action="viewProductServlet" method="post">
				<input type="submit" value="Own Products" /></form>
</div>