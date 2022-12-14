package com.Financial;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OtherBillUpdateServlet")
public class OtherBillUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String billID = request.getParameter("billID");
		String date = request.getParameter("billdate");
		String spareprice = request.getParameter("spareprice");
		String service = request.getParameter("service");
		String total = request.getParameter("total");
		String qty = request.getParameter("qty");
		
		boolean isTrue;

		isTrue = finacialDButill.updateotherrepairbill(billID, date, spareprice,service,total,qty);
		String date1 = date;
		 

		if (isTrue == true) {
			
			List<otherBillHistroy> otherBill = finacialDButill.getotherbillhistory(date1); 
			
			request.setAttribute("otherBill", otherBill);
			
			
		RequestDispatcher dis1 = request.getRequestDispatcher("OtherBillHistory.jsp");
		dis1.forward(request, response);
		}
		else {
		RequestDispatcher dis2 = request.getRequestDispatcher("OtherBillUpdateServlet.jsp");
		dis2.forward(request, response);
		}
		
	}

}
