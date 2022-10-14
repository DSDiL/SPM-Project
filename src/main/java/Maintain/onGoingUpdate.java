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
		String spare = request.getParameter("spare");
		String qty = request.getParameter("qty");
		String cost = request.getParameter("cost");
		String deliver = request.getParameter("deliver");
		String devices = request.getParameter("devices");
		String type = request.getParameter("type");
		String status = request.getParameter("status");
		
		LocalDate comDate = java.time.LocalDate.now();
		System.out.println(comDate);
		
		if (status.equals("Ongoing")) {
			
			boolean istrue;
			
			if (type.equals("Air Conditions")) {
				istrue=repairDButil.updateAirRepair(raID, cID, com, date, des, spare, qty, cost);
				
			}else if (type.equals("Computers")) {
				istrue=repairDButil.updateComputerRepair(rcID, cID, com, deliver, date, des, spare, qty, cost);
				
			}else {
				istrue=repairDButil.updateOtherRepair(roID, cID, com, date, devices, des, spare, qty, cost);
				
			}
			if (istrue == true) {
				if (type.equals("Air Conditions")) {
					List<onGoingAir> onGoingAir = repairDButil.searchOngoingAir(raID,type);
					request.setAttribute("onGoingAir", onGoingAir);
					
				}else if (type.equals("Computers")) {
					List<onGoingComputer> onGoingComputer = repairDButil.searchOngoingComputer(rcID,type);
					request.setAttribute("onGoingComputer", onGoingComputer);
					
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
			
			if (type.equals("Air Conditions")) {
				istrue=repairDButil.insertCompletedAirRepair(raID, cID, com, date, des, spare, qty, cost, comDate);
				istrue1=repairDButil.removeOngoingAir(raID);
				
			}else if (type.equals("Computers")) {
				istrue=repairDButil.insertCompletedComputerRepair(rcID, cID,com,deliver,date, des, spare, qty, cost, comDate);
				istrue1=repairDButil.removeOngoingComputer(rcID);

			}else {
				istrue=repairDButil.insertComputerOtherRepair(roID, cID, com, date, devices, des, spare, qty, cost, comDate);
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
