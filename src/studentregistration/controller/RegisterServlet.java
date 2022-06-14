package studentregistration.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if(id.equals("") || name.equals("") || email.equals("") || password.equals("")) {
			request.setAttribute("regerror", "Fields cannot be blank");
			request.getRequestDispatcher("REG001.jsp").include(request, response);
		}else {
//			RegisterUser reguser = new RegisterUser();
//			request.getSession().setAttribute("reguser", reguser);
		}
	}

}
