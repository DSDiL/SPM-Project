package techscope;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/repairReport")
public class repairReport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("type");
		String month = request.getParameter("month");
		
		if (type.equals("ongoing")) {
			try {
				List<onGoingSoftware> onGoingSoftware = repairDButil.ongoingReportSoftware(month, type);
				request.setAttribute("onGoingSoftware", onGoingSoftware);
				
				List<onGoingHardware> onGoingHardware = repairDButil.ongoingReportHardware(month, type);
				request.setAttribute("onGoingHardware", onGoingHardware);
				
				List<onGoingOther> onGoingOther = repairDButil.ongoingReportOther(month, type);
				request.setAttribute("onGoingOther", onGoingOther);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher dis = request.getRequestDispatcher("ongoingRepairReport.jsp");
			dis.forward(request, response);
		
		}else {
			try {
				List<completedSoftware> completedSoftware = repairDButil.completedReportSoftware(month, type);
				request.setAttribute("completedSoftware", completedSoftware);
				
				List<completedHardware> completedHardware = repairDButil.completedReportHardware(month, type);
				request.setAttribute("completedHardware", completedHardware);
				
				List<completedOther> completedOther = repairDButil.completedReportOther(month, type);
				request.setAttribute("completedOther", completedOther);	
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher dis = request.getRequestDispatcher("completedRepairReport.jsp");
			dis.forward(request, response);
		}	 		
	}
}
