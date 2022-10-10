package com.Financial;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RepairInsert")
public class RepairInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String rcID = request.getParameter("rcID");
		String company = request.getParameter("company");
		String comdate = request.getParameter("comdate");
		String deliver = request.getParameter("deliver");
		String description = request.getParameter("description");
		String spare = request.getParameter("spare");
		String qty = request.getParameter("qty");
		String sparepart = request.getParameter("sparepart");
		String date = request.getParameter("date");
		String service = request.getParameter("service");
		
		
	

		boolean isTrue;

		isTrue = finacialDButill.insertrepairbill(rcID,company,comdate,deliver,description,spare,qty,sparepart,date,service);

		if (isTrue == true) {
		RequestDispatcher dis1 = request.getRequestDispatcher("repair_and_deliver.jsp");
		dis1.forward(request, response);
		}
		else {
		RequestDispatcher dis2 = request.getRequestDispatcher("RepairBillDetails.jsp");
		dis2.forward(request, response);
		}
		
		
		
		
	}

}
