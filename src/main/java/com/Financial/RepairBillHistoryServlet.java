package com.Financial;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RepairBillHistoryServlet")
public class RepairBillHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String date = request.getParameter("date");
				
				
		List<computerBillHistory> computerBillHistory = finacialDButill.getcomputerhistory(date); 
		
	
		request.setAttribute("computerBillHistory", computerBillHistory);
		
		
		
		RequestDispatcher rs = request.getRequestDispatcher("RepairBillHistory.jsp");
		
		rs.forward(request, response);
		
		
	}

}
