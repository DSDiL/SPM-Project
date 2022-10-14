package techscope;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchOngoing")
public class searchOngoing extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rid=request.getParameter("rid");
		String type=request.getParameter("type");
				
		try {
			if (type.equals("Air Conditions")) {
				List<onGoingAir> onGoingAir = repairDButil.searchOngoingAir(rid,type);
				request.setAttribute("onGoingAir", onGoingAir);
			}else if (type.equals("Computers")) {
				List<onGoingComputer> onGoingComputer = repairDButil.searchOngoingComputer(rid,type);
				request.setAttribute("onGoingComputer", onGoingComputer);
			}else {
				List<onGoingOther> onGoingOther = repairDButil.searchOngoingOther(rid,type);
				request.setAttribute("onGoingOther", onGoingOther);
			}	 	
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dis = request.getRequestDispatcher("onGoingRepairInfo.jsp");
		dis.forward(request, response);
	}	
}

