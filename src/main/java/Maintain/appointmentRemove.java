package techscope;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/appointmentRemove")
public class appointmentRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("submit");
		
		boolean isTrue;
		
		isTrue = repairDButil.deleteAppointment(id);
		
		if (isTrue==true) {
			
			try {
				List<appointment> appointment = repairDButil.getAppointment();
				request.setAttribute("appointment", appointment); 	
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			
			RequestDispatcher dis = request.getRequestDispatcher("repairType.jsp");
			dis.forward(request, response);
		}
		else {
			RequestDispatcher dis = request.getRequestDispatcher("repairType.jsp");
			dis.forward(request, response);
		}
	}

}
