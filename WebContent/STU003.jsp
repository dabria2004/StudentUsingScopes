<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="test.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    
        <title>Course Registration</title>
</head>

<body>
   <%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if (session.getAttribute("userInfo") == null) {
		response.sendRedirect("LGN001.jsp");
	}
	%>  
    <div id="testheader">
        <div class="container">
            <div class=row>        
                <div class="col-md-5 ">
            <a href="MNU001.jsp"><h3>Student Registration</h3></a>
        </div>  
        <div class="col-md-6">
            <p>User: ${userInfo.userid} ${userInfo.username}</p>
                    <p>Current Date : ${date} </p>
        </div>  
        <div class="col-md-1">
                    <input type="button" class="btn-basic" id="lgnout-button" value="Log Out"
                        onclick="location.href='/Student_Registration/LogoutServlet'">
                </div>          
</div>
</div>

</div>
    <!-- <div id="testsidebar">Hello World </div> -->
    <div class="container">
    <div class="sidenav">
        
        <button class="dropdown-btn" > Class Management <i class="fa fa-caret-down"></i></button>
        
            <div class="dropdown-container">
          <a href="BUD003.jsp">Course Registration </a>
          <a href="StudentRegisterServlet">Student Registration </a>
          <a href="STU003.jsp">Student Search </a>
        </div>
        <a href="USR003.jsp">Users Management</a>
      </div>
      <div class="main_contents">
    <div id="sub_content">
      <form action = "StudentSearchServlet" method = "post" class="row g-3 mt-3 ms-2">
        <div class="col-auto">
          <label for="staticEmail2" class="visually-hidden">studentID</label>
          <input type="text"  class="form-control" id="staticEmail2" placeholder="Student ID" name = "id">
        </div>
        <div class="col-auto">
          <label for="inputPassword2" class="visually-hidden">studentName</label>
          <input type="text" class="form-control" id="inputPassword2" placeholder="Student Name" name = "name">
        </div>
        <div class="col-auto">
            <label for="inputPassword2" class="visually-hidden">Course</label>
            <input type="text" class="form-control" id="inputPassword2" placeholder="Course" name = "course">
          </div>
        <div class="col-auto">
        <input type="submit" value="Search" class="btn btn-success mb-3">
          <!-- <button type="submit" class="btn btn-success mb-3">Search</button> -->
        </div>
        <div class="col-auto">
	<button type="button" class="btn btn-secondary mb-3" onclick="location.href = 'STU003.jsp';">Reset</button>
        </div>
      </form>
<div>
      <table class="table table-striped" id="stduentTable">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Student ID</th>
            <th scope="col">Name</th>
            <th scope="col">Course Name</th>
            <th scope="col">Details</th>
          </tr>
        </thead>
        <tbody>
        <c:set var = "count" value = "0" scope = "page"/>
        <c:forEach var = "data" items = "${studentlist}">
          <tr>
          <c:set var = "count" value = "${count+1 }" scope = "page"/>
            <td>${count}</td>
            <td>${data.studentid}</td>
            <td>${data.studentname}</td>
            <td><c:forEach var = "courses" items = "${data.courses}">${courses},</c:forEach></td>
            <td>
              <a href="SeeMoreServlet?studentid=${data.studentid}"><button type="submit" class="btn btn-secondary mb-2">See More</button></a> 
            </td>
          </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
    </div>
</div>
</div>
        <div id="testfooter">
            <span>Copyright &#169; ACE Inspiration 2022</span>
        </div>
        <script>
            /* Loop through all dropdown buttons to toggle between hiding and showing its dropdown content - This allows the user to have multiple dropdowns without any conflict */
            var dropdown = document.getElementsByClassName("dropdown-btn");
            var i;
            
            for (i = 0; i < dropdown.length; i++) {
              dropdown[i].addEventListener("click", function() {
              this.classList.toggle("active");
              var dropdownContent = this.nextElementSibling;
              if (dropdownContent.style.display === "block") {
              dropdownContent.style.display = "none";
              } else {
              dropdownContent.style.display = "block";
              }
              });
            }
            </script>
</body>

</html>



