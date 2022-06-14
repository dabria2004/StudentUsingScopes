package studentregistration.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentregistration.model.StudentBean;

@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteStudentServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentid=request.getParameter("studentid");
		@SuppressWarnings("unchecked")
		List<StudentBean> studentlist = (List<StudentBean>) request.getServletContext().getAttribute("studentlist");
		Iterator<StudentBean> itr=studentlist.iterator();
		while(itr.hasNext()) {
			if(itr.next().getStudentid().contentEquals(studentid)) {
				itr.remove();
			}
		}
		request.getRequestDispatcher("STU003.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
