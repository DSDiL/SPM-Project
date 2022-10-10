package com.Financial;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeliveryInsert")
public class DeliveryInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		String deliverID = request.getParameter("did");
		String cusID = request.getParameter("cid");
		String unitPrice = request.getParameter("unitPrice");
		String qty = request.getParameter("qty");
		String deliverdate = request.getParameter("deliverdate");
		String billdate = request.getParameter("billdate");
		String tax = request.getParameter("tax");
		String cost = request.getParameter("cost");


		


		
		
	

		boolean isTrue;

		isTrue = finacialDButill.insertdeliverybill(deliverID,cusID,unitPrice,qty,deliverdate,billdate,tax,cost);

		if (isTrue == true) {
		RequestDispatcher dis1 = request.getRequestDispatcher("repair_and_deliver.jsp");
		dis1.forward(request, response);
		}
		else {
		RequestDispatcher dis2 = request.getRequestDispatcher("DeliverBillDetails.jsp");
		dis2.forward(request, response);
		}
		
		
	}




}
