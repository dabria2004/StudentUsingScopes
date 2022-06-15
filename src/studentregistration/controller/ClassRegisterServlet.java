package studentregistration.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentregistration.model.ClassBean;

@WebServlet("/ClassRegisterServlet")
public class ClassRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClassRegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("classname");
		ClassBean cbean = new ClassBean();
		cbean.setCheck(false);
		cbean.setClassname(name);
		if (name.trim().equals("")) {
			request.setAttribute("error", "Fill the blank !!");
			request.setAttribute("data", cbean);
			request.getRequestDispatcher("BUD003.jsp").include(request, response);
		} else {
List<ClassBean> classlist = (ArrayList<ClassBean>) request.getServletContext().getAttribute("classlist");
			if (classlist == null) {
				classlist = new ArrayList<>();
			}
			if (classlist.size() == 0) {

				cbean.setClassid("COU001");

			} else {
				int tempId = Integer.parseInt(classlist.get(classlist.size() - 1).getClassid().substring(3)) + 1;
				String userId = String.format("COU%03d", tempId);
				cbean.setClassid(userId);
			}
			classlist.add(cbean);
			request.getServletContext().setAttribute("classlist", classlist);
			request.setAttribute("success", "Registered Succesfully !!");
			request.getRequestDispatcher("BUD003.jsp").forward(request, response);
		}

	}
}
