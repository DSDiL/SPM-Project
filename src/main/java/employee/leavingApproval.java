package employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/leavingApproval")
public class leavingApproval extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("Approve");
		String status = request.getParameter("status");
		String more = request.getParameter("more");
		String sick = request.getParameter("sick");
		String casual = request.getParameter("casual");
		String nic = request.getParameter("nic");
		String period = request.getParameter("period");
		String reason = request.getParameter("reason");
		
		boolean isTrue, isTrue1;
		
		isTrue = employeeDB.leavingApproving(id, status, more);
		
		if (isTrue == true && status.equals("Approved")) {
			
			isTrue1 = employeeDB.updateLeavingInfo(nic, reason, period, sick, casual);
			
			if (isTrue1 == true) {
				
				List<leaveApply> leave = employeeDB.leavingApprovalDetails();
				request.setAttribute("leave", leave);
				
				RequestDispatcher dis1 = request.getRequestDispatcher("leaveApproveDetails.jsp");
				dis1.forward(request, response);
			}
		}
		else {
			List<leaveApply> leave = employeeDB.leavingApprovalDetails();
			request.setAttribute("leave", leave);
			
			RequestDispatcher dis2 = request.getRequestDispatcher("leaveApproveDetails.jsp");
			dis2.forward(request, response);
		}	
	}
}
