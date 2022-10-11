package appointment;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Appointmentinsert")
public class Appointmentinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Service_type = request.getParameter("type");
		String des = request.getParameter("des");
		String Time_slot = request.getParameter("time");
		String Required_date = request.getParameter("date");
		String Cid = request.getParameter("cid");
		
		boolean isTrue;
		
		isTrue = appointmentDbutil.insertappointment(Service_type,des,Time_slot,Required_date,Cid);		
		
		if(isTrue == true) { 
			
			List<appointment> apoid = appointmentDbutil.getAppointment(Cid); //navigate userRegister form
			request.setAttribute("apoid", apoid);
			
			RequestDispatcher dis = request.getRequestDispatcher("appointment_details.jsp");
			dis.forward(request, response);

		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("userAcc.jsp");
			dis2.forward(request, response);
	
		}
		
	}

}
