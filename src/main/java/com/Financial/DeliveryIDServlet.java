package com.Financial;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeliveryIDServlet")
public class DeliveryIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String did = request.getParameter("rid");
		
		
		List<repairAir> repairAir = finacialDButill.getAirdetails(did); 
		
	
		request.setAttribute("repairAir", repairAir);
		
		
		
		RequestDispatcher rs = request.getRequestDispatcher("AirDetails.jsp");
		
		rs.forward(request, response);

	}

}
