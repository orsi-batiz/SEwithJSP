<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create account</title>

<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

  input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for all buttons */
button {
  background-color: #FFC0CB;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

button:hover {
  opacity:1;
}

/* Extra styles for the cancel button */
.cancelbtn {
  padding: 14px 20px;
  background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
  float: left;
  width: 50%;
}

/* Add padding to container elements */
.container {
  padding: 16px;
}

/* Clear floats */
.clearfix::after {
  content: "";
  clear: both;
  display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
  .cancelbtn, .signupbtn {
    width: 100%;
  }
}

</style>
</head>
<body>
<jsp:include page="headerAdministrator.jsp" />
<jsp:include page="menuAdministrator.jsp" />

<form action="addSupplierServlet" method="post">

<div class="container">
    <h1>Create a supplier account</h1>
    <hr>

	<c:if test="${sessionScope.error != null}">
           <label for="error"><b>Error: ${sessionScope.error}</b></label>
    </c:if>
    
    <label for="username"><b>Supplier</b></label>
    <input type="text" placeholder="Enter Username" name="username"  required>

    <label for="company"><b>Company</b></label>
    <input type="text" placeholder="Enter Company" name="company"  required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
    
    
    
    

    <div class="clearfix">
      <a href="index.jsp">Cancel</a>
      <button type="submit" class="signupbtn" value="Create">Add</button>
    </div> 
  </div>
  
</form>

<jsp:include page="footer.jsp" />
</body>
</html>