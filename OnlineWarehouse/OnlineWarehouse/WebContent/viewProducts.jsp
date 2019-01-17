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
	
           <jsp:include page="headerSupplier.jsp" />
           <jsp:include page="menuSupplier.jsp" />
        <c:forEach var="id" items="${sessionScope.products}" >
            <tr>
                <td>${id.name}</td>
                <td>${id.category}</td>
                <td>${id.price}</td>
                <td>${id.stock}</td>
             </tr>
   		</c:forEach>
    <jsp:include page="footer.jsp" />
</body>
</html>