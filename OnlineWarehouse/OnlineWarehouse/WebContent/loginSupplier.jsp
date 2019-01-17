<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #FFC0CB;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

img.avatar {
  width: 40%;
  border-radius: 50%;
}

.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}

</style>
</head>



<body>
<jsp:include page="header.jsp" />
<jsp:include page="menu.jsp" />
<form action="loginSupplierServlet" method="post">
	
  <div class="imgcontainer">
    <img src="C:\Users\petru\OneDrive\Desktop\OnlineWarehouse\OnlineWarehouse\WebContent\avatar.png" alt="Avatar" class="avatar">
  </div>
  
  <c:if test="${sessionScope.error != null}">
           <label for="error"><b>Error: ${sessionScope.error}</b></label>
  </c:if>
  
  <div class="container">
    <label for="uname"><b>Supplier</b></label>
    <input type="text" placeholder="Enter Username" name="username" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
        
    <button type="submit" value="Login">Login</button>
    
  </div>

<a href="login.jsp">Login as customer</a>
<a href="loginAdministrator.jsp">Login as administrator</a>

  <div class="container" style="background-color:#f1f1f1">
   <a href="index.jsp">Cancel</a>
    <span class="psw">Forgot <a href="#">password?</a></span>
  </div>
  </form>
<jsp:include page="footer.jsp" />
</body>
</html>