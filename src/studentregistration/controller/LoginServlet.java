package studentregistration.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import studentregistration.model.UserBean;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private UserService userService = new UserService();

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");
		UserBean userBean = new UserBean();
		userBean.setUseremail(email);
		userBean.setUserpw(password);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());
		String currentDate = formatter.format(date);
		ArrayList<UserBean> userlist = (ArrayList<UserBean>) req.getServletContext().getAttribute("userList");
		if (userlist == null) {
			userlist = new ArrayList<>();
			UserBean user = new UserBean("USR_001", "Admin","admin@gmail.com", "admin", "admin", "Admin");
			userlist.add(user);
			req.getServletContext().setAttribute("userlist", userlist);
			for (UserBean userInfo : userlist) {
				if (userInfo.getUseremail().equals(email) && userInfo.getUserpw().equals(password)) {
					req.getSession().setAttribute("userInfo", userInfo);
					req.getSession().setAttribute("date", currentDate);
					req.getRequestDispatcher("MNU001.jsp").forward(req, res);
				}else{
					req.setAttribute("error", "Email and Password do not match !!");
					req.setAttribute("data", userBean);
					req.getRequestDispatcher("LGN001.jsp").include(req, res);
				}
			}
		}else {
			for (UserBean userInfo : userlist) {
				if (userInfo.getUseremail().equals(email) && userInfo.getUserpw().equals(password)) {
					req.getSession().setAttribute("userInfo", userInfo);
					req.getSession().setAttribute("date", currentDate);
					req.getRequestDispatcher("MNU001.jsp").forward(req, res);
				}else{
					req.setAttribute("error", "Email and Password do not match !!");
					req.setAttribute("data", userBean);
					req.getRequestDispatcher("LGN001.jsp").include(req, res);
				}
			}
		}
	}
}