package com.Financial;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AirInsert")
public class AirInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String raID = request.getParameter("raID");
		String cID = request.getParameter("cID");
		String company = request.getParameter("company");
		String date = request.getParameter("date");
		String description = request.getParameter("description");
		String spare = request.getParameter("spare");
		String qty = request.getParameter("qty");
		String cost = request.getParameter("cost");
		String sparepart = request.getParameter("sparepart");
		String billdate = request.getParameter("billdate");
		String service = request.getParameter("service");

		
		
		boolean isTrue;

		isTrue = finacialDButill.insert_air_bill(raID,cID,company,date,description,spare,qty,cost,sparepart,billdate,service);

		if (isTrue == true) {
		RequestDispatcher dis1 = request.getRequestDispatcher("repair_and_deliver.jsp");
		dis1.forward(request, response);
		}
		else {
		RequestDispatcher dis2 = request.getRequestDispatcher("AirDetails.jsp");
		dis2.forward(request, response);
		}

	}

}
