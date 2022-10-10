package com.Financial;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AirBillHistoryServlet")
public class AirBillHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String airdate = request.getParameter("airdate");
			
		List<airBillHistroy> airBill = finacialDButill.getairbillhistory(airdate); 
	
		request.setAttribute("airBill", airBill);
		
		RequestDispatcher rs = request.getRequestDispatcher("AirBillHistory.jsp");
		
		rs.forward(request, response);
		
	}

}
