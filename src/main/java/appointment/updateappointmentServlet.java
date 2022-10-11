package appointment;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/updateappointmentServlet")
public class updateappointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String Apoid = request.getParameter("apoid");
		String servicetype = request.getParameter("type");
		String des = request.getParameter("des");
		String timeslot = request.getParameter("time");
		String requireddate = request.getParameter("date");
		String cid = request.getParameter("Submit");
				
		boolean isTrue;
		
		isTrue = appointmentDbutil.update_appointment_details(Apoid, servicetype, des, timeslot, requireddate, cid);
		
		if(isTrue == true) {
			List<appointment> apoid = appointmentDbutil.getAppointment(cid); //navigate userRegister form
			request.setAttribute("apoid", apoid);
			
			RequestDispatcher dis = request.getRequestDispatcher("appointment_details.jsp");
			dis.forward(request, response);
		}
		else {
			
			RequestDispatcher dis = request.getRequestDispatcher("error.jsp");
			dis.forward(request, response);
		
	}

}
}