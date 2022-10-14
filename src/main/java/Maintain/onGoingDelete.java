package techscope;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/onGoingDelete")
public class onGoingDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String raID = request.getParameter("raID");
		String rcID = request.getParameter("rcID");
		String roID = request.getParameter("roID");
		String type = request.getParameter("type");
		
		boolean istrue1;
		
		if (type.equals("Air Conditions")) {
			istrue1=repairDButil.removeOngoingAir(raID);
			
		}else if (type.equals("Computers")) {
			istrue1=repairDButil.removeOngoingComputer(rcID);

		}else {
			istrue1=repairDButil.removeOngoingOther(roID);
		}
		if (istrue1 == true) {
			RequestDispatcher dis = request.getRequestDispatcher("repairHome.jsp");
			dis.forward(request, response);
		}else {
			RequestDispatcher dis = request.getRequestDispatcher("onGoingDelete.jsp");
			dis.forward(request, response);
		}
	}

}
