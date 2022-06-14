package studentregistration.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentregistration.model.UserBean;

@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("userid");
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String useremail = request.getParameter("useremail");
		String userpw = request.getParameter("userpw");
		String conpw = request.getParameter("conpw");
		String role = request.getParameter("role");
		UserBean ubean = new UserBean(userid,username,useremail,userpw,conpw,role);
		if(ubean.getUsername().equals("") || ubean.getUseremail().equals("") || ubean.getUserpw().equals("") || ubean.getConpw().equals("") || ubean.getRole().equals("")) {
			request.setAttribute("error","Update Failed!!");
			request.setAttribute("ubean", ubean);
			request.getRequestDispatcher("USR002.jsp").include(request, response);
		}else {
			@SuppressWarnings("unchecked")
			List<UserBean> userlist=(List<UserBean>) request.getServletContext().getAttribute("userlist");
			Iterator<UserBean> itr=userlist.iterator();
			while(itr.hasNext()) {
				if(itr.next().getUserid().equals(id)) {
					itr.remove();
				}
			}
			userlist.add(ubean);
			request.getServletContext().setAttribute("userlist",userlist);
			request.setAttribute("success", "Updated Successfully!!");
			request.getRequestDispatcher("USR002.jsp").forward(request, response);
		}
	}

}
