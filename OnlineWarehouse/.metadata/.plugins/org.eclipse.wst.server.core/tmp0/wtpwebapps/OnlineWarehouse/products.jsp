<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome </title>
</head>
<body>
	<c:if test="${sessionScope.customer != null}">
           <jsp:include page="headerCustomer.jsp" />
           <jsp:include page="menuCustomer.jsp" />
    </c:if>
    <c:if test="${sessionScope.customer == null}">
           <jsp:include page="header.jsp" />
           <jsp:include page="menu.jsp" />
    </c:if>
        <c:forEach var="id" items="${sessionScope.products}" >
            <tr>
                <td>${id.name}</td>
                <td>${id.company}</td>
                <td>${id.category}</td>
                <td>${id.price}</td>
             </tr>
            <c:if test="${sessionScope.customer != null}">
           <form action="addToCartServlet" method="post">
             	<input type=hidden name="id" value="${id.id}"/>
				<input type="submit" value="Add to cart" /></form>
			<form action="addToFavouritesServlet" method="post">
             	<input type=hidden name="id" value="${id.id}"/>
				<input type="submit" value="Add to favourites" /></form>
			
    </c:if>
   		</c:forEach>
    <jsp:include page="footer.jsp" />
</body>
</html>