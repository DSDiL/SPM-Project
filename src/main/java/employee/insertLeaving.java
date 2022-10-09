package employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertLeaving")
public class insertLeaving extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nic = request.getParameter("nic");
		String reason = request.getParameter("reason");
		String days = request.getParameter("days");
		String date = request.getParameter("date");
		//String sick = request.getParameter("sick");
		//String casual = request.getParameter("casual");
		String more = request.getParameter("more");
		String status = "pending";
		
		boolean isTrue; //isTrue1;
		
		isTrue = employeeDB.insertLeaving(nic, reason, days, date, more, status);
		
		if (isTrue == true) {
			
			//isTrue1 = employeeDB.updateLeavingInfo(nic, reason, days, sick, casual);
			
			//if (isTrue1 == true)
			//{
				List<employee> empProf = employeeDB.employeeProfile(nic);
				request.setAttribute("empProf", empProf);
				
				RequestDispatcher dis1 = request.getRequestDispatcher("employeeHome.jsp");
				dis1.forward(request, response);
			//}
		}
		else {
			/*List<employee> empProf = employeeDB.employeeProfile(nic);
			request.setAttribute("empProf", empProf);
			
			List<leave> empLeav = employeeDB.employeeLeave(nic);
			request.setAttribute("empLeav", empLeav);*/
			
			RequestDispatcher dis2 = request.getRequestDispatcher("leavingApp.jsp");
			dis2.forward(request, response);
		}
	}
}

