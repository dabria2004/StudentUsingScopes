package studentregistration.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentregistration.model.ClassBean;
import studentregistration.model.StudentBean;

@WebServlet("/SeeMoreServlet")
public class SeeMoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SeeMoreServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("studentid");
		List<StudentBean> studentlist = (List<StudentBean>) request.getServletContext().getAttribute("studentlist");
		for (StudentBean student : studentlist) {
			if (student.getStudentid().equals(id)) {
				StudentBean sbean = student;
				String[] attendCourses = sbean.getCourses();
				List<ClassBean> classlist = (ArrayList<ClassBean>) request.getServletContext().getAttribute("classlist");
				for (ClassBean l : classlist) {
					l.setCheck(false);
				}

				for (int i = 0; i < classlist.size(); i++) {
					for (int j = 0; j < attendCourses.length; j++) {
						if (classlist.get(i).getClassname().equals(attendCourses[j])) {
							classlist.get(i).setCheck(true);
						}
					}
				}
				
				request.setAttribute("courses", classlist);				
				request.setAttribute("data", sbean);
				System.out.println("sbean is " + sbean);
				request.getRequestDispatcher("STU002.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
