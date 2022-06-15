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

import studentregistration.model.ClassBean;
import studentregistration.model.StudentBean;

@WebServlet("/StudentRegisterServlet")
public class StudentRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentRegisterServlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = GenerateId(request);
		String studentid = "STU_" + String.format("%03d", id + 1);
ArrayList<ClassBean> classlist = (ArrayList<ClassBean>) request.getServletContext().getAttribute("classlist");
	request.getServletContext().setAttribute("studentid", studentid);
	request.setAttribute("classlist", classlist);
	request.getRequestDispatcher("STU001.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentid = request.getParameter("studentid");
		String studentname = request.getParameter("studentname");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String education = request.getParameter("education");
		String[] courses = request.getParameterValues("courses");
		StudentBean sbean = new StudentBean(studentid, studentname, dob, gender, phone, education, courses);
		
		System.out.println(sbean.toString());
		if(courses == null) {
			request.setAttribute("error", "Fill the blank !!");
			request.setAttribute("data", sbean);
			request.getRequestDispatcher("STU001.jsp").forward(request, response);
		}
		else if(studentid.isEmpty() || studentname.isEmpty() || dob.isEmpty() || gender.isEmpty() || phone.isEmpty() || education.isEmpty()) {
			
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
			request.setAttribute("error", "Fields cannot be blank!!");
			request.setAttribute("data", sbean);
			request.getRequestDispatcher("STU001.jsp").include(request, response);
		}else {
			List<StudentBean> studentlist = (List<StudentBean>) request.getServletContext().getAttribute("studentlist");
			if (studentlist == null) {
				studentlist = new ArrayList();
			}
			studentlist.add(sbean);
			request.getServletContext().setAttribute("studentlist", studentlist);
//			int id = GenerateId(request);
//			String newid = "STU_" + String.format("%03d", id + 1);
//	
//		request.getServletContext().setAttribute("studentid", newid);
			request.setAttribute("success", "Registered Successfully!!");
			request.getRequestDispatcher("STU001.jsp").forward(request, response);
		}
	}

	public int GenerateId(HttpServletRequest request) {
		int id = 0;
		@SuppressWarnings("unchecked")
		List<StudentBean> studentlist = (List<StudentBean>) request.getServletContext().getAttribute("studentlist");
		if (studentlist != null) {
			Iterator<StudentBean> itr = studentlist.iterator();
			while (itr.hasNext()) {
				String generateId = itr.next().getStudentid();
				int idcount = Integer.parseInt(generateId.split("_")[1].trim());
				if (idcount > id) {
					id = idcount;
				}
			}
		}
		return id;
	}

}
