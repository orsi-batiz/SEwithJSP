<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.header-container {
  width: 100%;
  background-color: #555;
  overflow: auto;
}

.header-container a {
  float: left;
  padding: 12px;
  color: white;
  text-decoration: none;
  font-size: 17px;
}

.header-container a:hover {
  background-color: #000;
}

.header-container a:focus {
  background-color: #FFC0CB;
}

.header {
  padding: 80px;
  text-align: center;
  background: #FFC0CB;
  color: #555;
}

/* Increase the font size of the heading */
.header h1 {
  font-size: 40px;
}

</style>
</head>
<body>

<div class="header-container">
 
    <div class="header">
  		<h1>Online Warehouse</h1>
	</div>
 
    <div class="header-bar">
       ${supplier.company}
       <form action="logoutServlet" method="post">
				<input type="submit" value="Logout" /></form>
    </div>
</div>

</body>
</html>