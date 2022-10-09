package employee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/profileDelete")
public class profileDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nic = request.getParameter("nic");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String position = request.getParameter("position");
		String dob = request.getParameter("dob");
		String date = request.getParameter("date");
		
		boolean isTrue, isTrue1 ,isTrue2;
		
		isTrue1 = employeeDB.previousEmployee(nic, name, email, mobile, position, dob, date);
		
		isTrue2 = employeeDB.deleteLeaveInfo(nic);
		
		isTrue = employeeDB.deleteProfile(nic);
		
		if (isTrue1 == true && isTrue == true && isTrue2 == true) {
			RequestDispatcher dis1 = request.getRequestDispatcher("employeeManagement.jsp");
			dis1.forward(request, response);
		}
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("employeeLogin.jsp");
			dis2.forward(request, response);
		}
	}
}
