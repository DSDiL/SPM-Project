package employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteLeaving")
public class deleteLeaving extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String nic = request.getParameter("nic");
		String reason = request.getParameter("reason");
		String days = request.getParameter("period");
		String sick = request.getParameter("sick");
		String casual = request.getParameter("casual");
		String status = request.getParameter("status");
		
		boolean isTrue, isTrue1;
		
		if(status.equals("Approved")) {
			
			isTrue1 = employeeDB.updateLeavingInfo2(nic, reason, days, sick, casual);
		}
		else{
			isTrue1 =true;
		}
		if (isTrue1 == true) {
			
			isTrue = employeeDB.deleteLeave(id);
			
			if (isTrue == true)
			{
				List<employee> empProf = employeeDB.employeeProfile(nic);
				request.setAttribute("empProf", empProf);
				
				RequestDispatcher dis1 = request.getRequestDispatcher("employeeHome.jsp");
				dis1.forward(request, response);
			}
		}
		else {
			List<employee> empProf = employeeDB.employeeProfile(nic);
			request.setAttribute("empProf", empProf);
			
			List<leave> empLeav = employeeDB.employeeLeave(nic);
			request.setAttribute("empLeav", empLeav);
			
			RequestDispatcher dis2 = request.getRequestDispatcher("leavingDetails.jsp");
			dis2.forward(request, response);
		}
		
	}

}
