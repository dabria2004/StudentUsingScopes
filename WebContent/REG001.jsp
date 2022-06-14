<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="test.css">
<title> Student Registration LGN001 </title>
</head>
<body class="login-page-body"> 
  
    <div class="login-page">
      <div class="form">
        <div class="login">
          <div class="login-header">
            <h1>Welcome!</h1>
            <!-- <p>Please check your data again.</p> -->
          </div>
        </div>
        <form class="login-form" action="RegisterServlet" method="post" name="confirm">
          <input type="text" placeholder="ID" name="userid"/>
          <input type="text" placeholder="Name" name="username"/>
          <input type="text" placeholder="Email" name="useremail"/>
          <input type="password" placeholder="Password" name="userpw"/>
          <input type = "submit" value = "submit">
          <p class="message">Already registered? <a href="LGN001.jsp">Login</a></p>
        </form>
      </div>
    </div>
</body>

</html>