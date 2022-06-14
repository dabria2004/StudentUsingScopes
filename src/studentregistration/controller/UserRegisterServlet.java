package studentregistration.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import studentregistration.model.UserBean;

@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserRegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = GenerateId(request);
		String userid = "USR_" + String.format("%03d", id + 1);
		String username = request.getParameter("username");
		String useremail = request.getParameter("useremail");
		String userpw = request.getParameter("userpw");
		String conpw = request.getParameter("conpw");
		String role = request.getParameter("role");
		UserBean ubean = new UserBean(userid, username, useremail, userpw, conpw, role);
		if (ubean.getUserid().equals("") || ubean.getUsername().equals("") || ubean.getUseremail().equals("")
				|| ubean.getUserpw().equals("") || ubean.getConpw().equals("") || ubean.getRole().equals("")) {
			request.setAttribute("error", "Fields cannot be balnk.");
			request.setAttribute("ubean", ubean);
			request.getRequestDispatcher("USR001.jsp").include(request, response);
		} else {
			@SuppressWarnings("unchecked")
			List<UserBean> userlist = (List<UserBean>) request.getServletContext().getAttribute("userlist");
			if (userlist == null) {
				userlist = new ArrayList();
			}
			userlist.add(ubean);
			request.getServletContext().setAttribute("userlist", userlist);
			request.setAttribute("success", "Registered Successfully!!");
			request.getRequestDispatcher("USR001.jsp").forward(request, response);
		}
	}

	public int GenerateId(HttpServletRequest request) {
		int id = 1;
		@SuppressWarnings("unchecked")
		List<UserBean> userlist = (List<UserBean>) request.getServletContext().getAttribute("userlist");
		if (userlist != null) {
			Iterator<UserBean> itr = userlist.iterator();
			while (itr.hasNext()) {
				String generateId = itr.next().getUserid();
				int idcount = Integer.parseInt(generateId.split("_")[1]);
				if (idcount > id) {
					id = idcount;

				}
			}
		}
		return id;
	}
}
