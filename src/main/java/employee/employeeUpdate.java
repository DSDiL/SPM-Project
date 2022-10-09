package employee;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/employeeUpdate")
public class employeeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String nic = request.getParameter("nic");
		String dob = request.getParameter("date");

		boolean isTrue;
		
		isTrue = employeeDB.updateProfile(name, mobile, email, dob, nic);
				
		if (isTrue == true) {
			List<employee> empProf = employeeDB.employeeProfile(nic);
			request.setAttribute("empProf", empProf);
			
			List<leave> empLeav = employeeDB.employeeLeave(nic);
			request.setAttribute("empLeav", empLeav);
			
			RequestDispatcher dis1 = request.getRequestDispatcher("employeeProfile.jsp");
			dis1.forward(request, response);
		}
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("error.jsp");
			dis2.forward(request, response);
		}
	}

}
