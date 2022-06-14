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


@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid=request.getParameter("userid");
		@SuppressWarnings("unchecked")
		List<UserBean> userlist=(List<UserBean>) request.getServletContext().getAttribute("userlist");
		Iterator<UserBean> itr=userlist.iterator();
		while(itr.hasNext()) {
			if(itr.next().getUserid().contentEquals(userid)) {
				itr.remove();
			}
		}
		request.getRequestDispatcher("USR003.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
