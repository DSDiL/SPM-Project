package techscope;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/onGoingUpdate")
public class onGoingUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String raID = request.getParameter("raID");
		String rcID = request.getParameter("rcID");
		String roID = request.getParameter("roID");
		String cID = request.getParameter("cID");
		String com = request.getParameter("com");
		String des = request.getParameter("des");
		String date = request.getParameter("date");
		String cost = request.getParameter("cost");
		String type = request.getParameter("type");
		String status = request.getParameter("status");
		
		LocalDate comDate = java.time.LocalDate.now();
		System.out.println(comDate);
		
		if (status.equals("Ongoing")) {
			
			boolean istrue;
			
			if (type.equals("Software")) {
				istrue=repairDButil.updateSoftwareRepair(raID, cID, com, date, des, cost);
				
			}else if (type.equals("Hardware")) {
				istrue=repairDButil.updateHardwareRepair(rcID, cID, com,  date, des, cost);
				
			}else {
				istrue=repairDButil.updateOtherRepair(roID, cID, com, date, des, cost);
				
			}
			if (istrue == true) {
				if (type.equals("Software")) {
					List<onGoingSoftware> onGoingSoftware = repairDButil.searchOngoingSoftware(raID,type);
					request.setAttribute("onGoingSoftware", onGoingSoftware);
					
				}else if (type.equals("Hardware")) {
					List<onGoingHardware> onGoingHardware = repairDButil.searchOngoingHardware(rcID,type);
					request.setAttribute("onGoingHardware", onGoingHardware);
					
				}else {
					List<onGoingOther> onGoingOther = repairDButil.searchOngoingOther(roID,type);
					request.setAttribute("onGoingOther", onGoingOther);
					
				}
				RequestDispatcher dis = request.getRequestDispatcher("onGoingRepairInfo.jsp");
				dis.forward(request, response);
			}else {
				RequestDispatcher dis2 = request.getRequestDispatcher("ongoingUpdate.jsp");
				dis2.forward(request, response);
				
			}
		}else {

			boolean istrue, istrue1;
			
			if (type.equals("Software")) {
				istrue=repairDButil.insertCompletedSoftware(raID, cID, com, date, des,  cost, comDate);
				istrue1=repairDButil.removeOngoingSoftware(raID);
				
			}else if (type.equals("Hardware")) {
				istrue=repairDButil.insertCompletedHardware(rcID, cID,com,date, des, cost, comDate);
				istrue1=repairDButil.removeOngoingHardware(rcID);

			}else {
				istrue=repairDButil.insertComputerOtherRepair(roID, cID, com, date, des,  cost, comDate);
				istrue1=repairDButil.removeOngoingOther(roID);
			}
			if (istrue == true && istrue1 == true) {
				RequestDispatcher dis1 = request.getRequestDispatcher("repairHome.jsp");
				dis1.forward(request, response);
			}
			else {
				RequestDispatcher dis2 = request.getRequestDispatcher("ongoingUpdate.jsp");
				dis2.forward(request, response);
			}
		}	
	}

}
