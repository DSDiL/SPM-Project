package techscope;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchCompleted")
public class searchCompleted extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rid=request.getParameter("rid");
		String type=request.getParameter("type");
				
		try {
			if (type.equals("Air Conditions")) {
				List<completedAir> completedAir = repairDButil.searchCompletedAir(rid,type);
				request.setAttribute("completedAir", completedAir);
			}else if (type.equals("Computers")) {
				List<completedComputer> completedComputer = repairDButil.searchCompletedComputer(rid,type);
				request.setAttribute("completedComputer", completedComputer);
			}else {
				List<completedOther> completedOther = repairDButil.searchCompletedOther(rid,type);
				request.setAttribute("completedOther", completedOther);
			}	 	
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dis = request.getRequestDispatcher("CompletedRepairInfo.jsp");
		dis.forward(request, response);
	}	
}

