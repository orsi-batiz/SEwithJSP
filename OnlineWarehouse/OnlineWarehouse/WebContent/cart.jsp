<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome <c:out value="${customer.username}" /></title>
</head>
<body>
	<jsp:include page="headerCustomer.jsp" />
    <jsp:include page="menuCustomer.jsp" />
    	<c:if test="${sessionScope.products != null}">
        <c:forEach var="id" items="${sessionScope.products}" >
            <tr>
                <td>${id.name}</td>
                <td>${id.company}</td>
                <td>${id.category}</td>
                <td>${id.price}</td>
             </tr>
   		</c:forEach>
        <a href="order.jsp">Order</a>
        </c:if>
        <c:if test="${sessionScope.products == null}">
        No products in cart.
        </c:if>
    <jsp:include page="footer.jsp" />
</body>
</html>