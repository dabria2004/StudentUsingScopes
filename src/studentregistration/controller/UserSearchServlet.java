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

@WebServlet("/UserSearchServlet")
public class UserSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserSearchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String)request.getParameter("id");
		String name = (String)request.getParameter("name");
		List<UserBean> userlist=(List<UserBean>) request.getServletContext().getAttribute("userlist");
		List<UserBean> searchlist = new ArrayList<UserBean>();
		if((id.isBlank()) && (name.isBlank())) {
			request.setAttribute("userlist", userlist);			
			request.getRequestDispatcher("USR003.jsp").forward(request, response);
			System.out.println("Both blank" + userlist);
			}else if((!id.isBlank()) && (!name.isBlank())){
				for (UserBean user : userlist) {
					if (user.getUsername().replaceAll("\\s+", "").toLowerCase()
							.contains(name.replaceAll("\\s+", "").toLowerCase())
							&& user.getUserid().toLowerCase().contains(id.toLowerCase())) {
						searchlist.add(user);
						System.out.println("Both not blank" + searchlist);
						request.setAttribute("userlist", searchlist);
						request.getRequestDispatcher("USR003.jsp").forward(request, response);
				}
			}
		}else if(id.isBlank() && !name.isBlank()) {
			for (UserBean user : userlist) {
				if (user.getUsername().replaceAll("\\s+", "").toLowerCase()
						.contains(name.replaceAll("\\s+", "").toLowerCase())) {
					searchlist.add(user);
					System.out.println("Id blank" + searchlist);
					request.setAttribute("userlist", searchlist);
					request.getRequestDispatcher("USR003.jsp").forward(request, response);
				}
			}
		}else if(!id.isBlank() && name.isBlank()) {
			for (UserBean user : userlist) {
				if (user.getUserid().toLowerCase().contains(id.toLowerCase())) {
					searchlist.add(user);
					System.out.println("Name blank" + searchlist);
					request.setAttribute("userlist", searchlist);
					request.getRequestDispatcher("USR003.jsp").forward(request, response);
				}
			}
		}
//		else {
//			for(UserBean user : userlist) {
//				if((!user.getUserid().equals(id)) || (!user.getUsername().equals(name))) {
//					request.setAttribute("error", "Data not found");
//					request.getRequestDispatcher("USR003.jsp").include(request, response);
//					
//				}
//			}
//		}
	}
}
		
		
		
		
//		boolean find = false;
//		String id = request.getParameter("id");
//		String name = request.getParameter("name");
//		List<UserBean> userlist=(List<UserBean>) request.getServletContext().getAttribute("userlist");
//		
//		List<UserBean> searchlist = new ArrayList<UserBean>();
//		if(id.equals("") || name.equals("")) {
//		request.getSession().setAttribute("userlist", userlist);
//		request.getRequestDispatcher("USR003.jsp").include(request, response);
//		}else {
			
			
//			Iterator<UserBean> itr=userlist.iterator();
//			while(itr.hasNext()) {
//				if(itr.next().getUserid().equals(id) || itr.next().getUsername().equals(name)) {
//					find = true;
//					searchList.add(itr.next());
//				}
//		}request.getSession().setAttribute("searchresult", userlist);
//	if(find == false) {
//		request.setAttribute("notfound", "User not found");
//		request.getRequestDispatcher("USR003.jsp").include(request, response);
//	}
//	}
//}

//String id = request.getParameter("id");
//String name = request.getParameter("name");
//List<UserBean> userlist=(List<UserBean>) request.getServletContext().getAttribute("userlist");
//List<UserBean> searchlist = new ArrayList<UserBean>();
//if(id.isBlank() || name.isBlank()) {
//	request.setAttribute("userlist", userlist);			
//	request.getServletContext().setAttribute("userlist", userlist);
//	request.getRequestDispatcher("USR003.jsp").include(request, response);
//	System.out.println("If block" + userlist);
//	}else if(!id.isBlank() && !name.isBlank()){
//		for (UserBean user : userlist) {
//			if (user.getUsername().replaceAll("\\s+", "").toLowerCase()
//					.contains(name.replaceAll("\\s+", "").toLowerCase())
//					|| user.getUserid().toLowerCase().contains(id.toLowerCase())) {
//				searchlist.add(user);
//				System.out.println("Else block" + searchlist);
////				request.setAttribute("userlist", searchlist);
//				request.getServletContext().setAttribute("userlist", searchlist);
//				request.getRequestDispatcher("USR003.jsp").include(request, response);
//			}
//		}
//	return;
//}