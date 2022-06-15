package studentregistration.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentregistration.model.ClassBean;
import studentregistration.model.StudentBean;


@WebServlet("/StudentUpdateServlet")
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String id=request.getParameter("studentid");
		String studentid = request.getParameter("studentid");
		String studentname = request.getParameter("studentname");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String education = request.getParameter("education");
		String[] courses = request.getParameterValues("courses");
		StudentBean studentbean = new StudentBean(studentid, studentname, dob, gender, phone, education, courses);
//		if(courses == null) {
//			request.setAttribute("error", "Fill the blank !!");
//			request.setAttribute("data", studentbean);
//			request.getRequestDispatcher("STU002.jsp").forward(request, response);
//		}else {
		System.out.println(studentbean.toString());
			if (studentname.equals("") || dob.equals("") || gender.equals("") || phone.equals("") || education.equals("") || (courses==null)) {
				String[] attendCourses = studentbean.getCourses();
				List<ClassBean> classlist = (ArrayList<ClassBean>)request.getServletContext().getAttribute("classlist");

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
				request.setAttribute("error", "Fill the blank !!");
				request.setAttribute("data", studentbean);
				request.getRequestDispatcher("STU002.jsp").include(request, response);				
			}else {
List<StudentBean> studentlist = (ArrayList<StudentBean>) request.getServletContext().getAttribute("studentlist");
				Iterator<StudentBean> itr = studentlist.iterator();
				while (itr.hasNext()) {
					if (itr.next().getStudentid().equals(studentid)) {
						itr.remove();
					}
				}
				studentlist.add(studentbean);
				request.getServletContext().setAttribute("studentlist", studentlist);
				request.getRequestDispatcher("STU003.jsp").forward(request, response);
				
//			}
		}
	}
}

