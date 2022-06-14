package studentregistration.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentregistration.model.StudentBean;

@WebServlet("/StudentSearchServlet")
public class StudentSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentSearchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String)request.getParameter("id");
		String name = (String)request.getParameter("name");
		String course = (String)request.getParameter("course");
		
		System.out.println(id + " " + name + " " + course);
		List<StudentBean> studentlist = (List<StudentBean>) request.getServletContext().getAttribute("studentlist");
		List<StudentBean> searchlist = new ArrayList<StudentBean>();
		if(id.isEmpty() && name.isEmpty() && course.isEmpty()) {
			request.setAttribute("studentlist", studentlist);
			request.getRequestDispatcher("STU003.jsp").forward(request, response);
		}else {
			Iterator<StudentBean> itr = studentlist.iterator();
			while(itr.hasNext()) {
				StudentBean sbean = itr.next();
//				boolean contains = Arrays.stream(sbean).anyMatch(course::equals);
				List<String> list = Arrays.asList(sbean.getCourses());
				if(sbean.getStudentid().equals(id) || sbean.getStudentname().equals(name) || list.contains(course)) {
					searchlist.add(sbean);
				}
			}
			request.setAttribute("studentlist", searchlist);
		}
		request.getRequestDispatcher("STU003.jsp").forward(request, response);
	}
}
