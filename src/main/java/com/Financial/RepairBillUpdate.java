package com.Financial;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RepairBillUpdate")
public class RepairBillUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		


		
			
	
			
			
			
			String billID = request.getParameter("billID");
	
			String date = request.getParameter("billdate");
	
			String spareprice = request.getParameter("spareprice");
			String service = request.getParameter("service");
			String total = request.getParameter("total");
			
			
			
		

			boolean isTrue;

			isTrue = finacialDButill.updatecomputerrepairbill(billID,spareprice,service,total);

			if (isTrue == true) {
				
				List<computerBillHistory> computerBillHistory = finacialDButill.getcomputerhistory(date); 
				
				
				request.setAttribute("computerBillHistory", computerBillHistory);
				
				
				
			RequestDispatcher dis1 = request.getRequestDispatcher("RepairBillHistory.jsp");
			dis1.forward(request, response);
			}
			else {
			RequestDispatcher dis2 = request.getRequestDispatcher("RepairBillUpdate.jsp");
			dis2.forward(request, response);
			}
			
			
			
			
		
	
	}

}
