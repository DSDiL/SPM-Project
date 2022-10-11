package appointment;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deleteappointmentServlet")
public class deleteappointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String apoid = request.getParameter("submit");
		String cid = request.getParameter("cid");
	
		boolean isTrue;
		
		isTrue = appointmentDbutil.delete(apoid);
		
		if (isTrue == true) {
			try {
				List<appointment> apoid1 = appointmentDbutil.getappointment(cid); //navigate userRegister form
				request.setAttribute("apoid", apoid1);

				RequestDispatcher rs = request.getRequestDispatcher("useraccount.jsp");
				rs.forward(request, response);
			}catch (Exception e) {
					e.printStackTrace();
					System.out.println("aaa");
				}
		}
		
		else {
		RequestDispatcher dis2 = request.getRequestDispatcher("useraccount.jsp");
		dis2.forward(request, response);
		}
		
	}
	
	

}
