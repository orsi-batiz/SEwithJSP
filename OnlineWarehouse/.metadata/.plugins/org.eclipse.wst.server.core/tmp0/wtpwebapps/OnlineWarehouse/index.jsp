<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Warehouse</title>
</head>
<body>
	<c:if test="${sessionScope.customer != null}">
           <jsp:include page="headerCustomer.jsp" />
           <jsp:include page="menuCustomer.jsp" />
    </c:if>
    <c:if test="${sessionScope.supplier != null}">
           <jsp:include page="headerSupplier.jsp" />
           <jsp:include page="menuSupplier.jsp" />
    </c:if>
    <c:if test="${sessionScope.administrator != null}">
           <jsp:include page="headerAdministrator.jsp" />
           <jsp:include page="menuAdministrator.jsp" />
    </c:if>
    <c:if test="${sessionScope.customer == null && sessionScope.supplier == null && sessionScope.administrator == null}">
           <jsp:include page="header.jsp" />
           <jsp:include page="menu.jsp" />
    </c:if>
	
	
	<jsp:include page="footer.jsp" />
</body>
</html>