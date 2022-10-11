package appointment;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/confirmidServlet")
public class confirmidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cid = request.getParameter("Submit");
	
		try {
			
			List<appointment> apoid = appointmentDbutil.getappointment(cid); //navigate userRegister form
			request.setAttribute("apoid", apoid);

			RequestDispatcher rs = request.getRequestDispatcher("useraccount.jsp");
			rs.forward(request, response);
		}catch (Exception e) {
				e.printStackTrace();
				System.out.println("aaa");
			}
		RequestDispatcher rs = request.getRequestDispatcher("error.jsp");
		rs.forward(request, response);
		}
		
	}
