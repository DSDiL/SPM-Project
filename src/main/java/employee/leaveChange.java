package employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/leaveChange")
public class leaveChange extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nic = request.getParameter("nic");
		System.out.print(nic);
		try {
			List<leaveApply> app = employeeDB.leavingAppDetails(nic);
			request.setAttribute("app", app);
			
			List<leave> empLeav = employeeDB.employeeLeave(nic);
			request.setAttribute("empLeav", empLeav);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("leavingDetails.jsp");
		dis.forward(request, response);
	}	
}

