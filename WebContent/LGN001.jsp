<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            <p>${error}</p>
          </div>
        </div>
        <form class="login-form" action="LoginServlet" method="post" name="confirm">
          <input type="email" placeholder="Email" value="${data.useremail}" name="email"/>
          <input type="password" placeholder="Password" value="${data.userpw}" name="password"/>
          <button>login</button>
        </form>
      </div>
    </div>
</body>

</html>