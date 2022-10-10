package com.Financial;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OtherBillHistoryServlet")
public class OtherBillHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String otherdate = request.getParameter("otherdate");
		
		List<otherBillHistroy> otherBill = finacialDButill.getotherbillhistory(otherdate); 
	
		request.setAttribute("otherBill", otherBill);
		
		RequestDispatcher rs = request.getRequestDispatcher("OtherBillHistory.jsp");
		rs.forward(request, response);
	}

}
