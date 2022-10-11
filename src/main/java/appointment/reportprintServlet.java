package appointment;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/reportprintServlet")
public class reportprintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String date = request.getParameter("date");
		
			List<appointment> apoid = appointmentDbutil.getreport(date); 
			request.setAttribute("apoid", apoid);

			
			
			try {

			RequestDispatcher rs = request.getRequestDispatcher("AppointmentReport.jsp");
		
			rs.forward(request, response);
				}catch (Exception e) {
					e.printStackTrace();
						
			}
		
	}

}
