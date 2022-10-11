package appointment;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/displayappointmentServlet")
public class displayappointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String Apo_id = request.getParameter("aid");
		boolean isTrue;
		isTrue = appointmentDbutil.validate1(Apo_id);
		
		if(isTrue== true)
		{
			
		List<appointment> apoid = appointmentDbutil.getappointment(Apo_id); //navigate userRegister form
		request.setAttribute("apoid", apoid);

		
		
		try {

		RequestDispatcher rs = request.getRequestDispatcher("delete_an_appointment.jsp");
	
		rs.forward(request, response);
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("aaa");			}
		}else
		{
		RequestDispatcher rs = request.getRequestDispatcher("error.jsp");
		rs.forward(request, response);
		}
		
	}

}
