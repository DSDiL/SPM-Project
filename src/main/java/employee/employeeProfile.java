package employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/employeeProfile")
public class employeeProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nic = request.getParameter("submit");
		
		try {
			List<employee> empProf = employeeDB.employeeProfile(nic);
			request.setAttribute("empProf", empProf);
			
			List<leave> empLeav = employeeDB.employeeLeave(nic);
			request.setAttribute("empLeav", empLeav);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("employeeProfile.jsp");
		dis.forward(request, response);
	}

}
