package employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/profileUpdate")
public class profileUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String position = request.getParameter("position");
		String basicSalary = request.getParameter("basicSalary");
		String nic = request.getParameter("nic");
		String section = request.getParameter("section");

		boolean isTrue;
		
		isTrue = employeeDB.profileChange(position, basicSalary, section, nic);
		
		if (isTrue == true) {
			List<employee> empProf = employeeDB.employeeProfile(nic);
			request.setAttribute("empProf", empProf);
			
			RequestDispatcher dis1 = request.getRequestDispatcher("profileChange.jsp");
			dis1.forward(request, response);
		}
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("profileUpdate.jsp");
			dis2.forward(request, response);
		}
	}

}
