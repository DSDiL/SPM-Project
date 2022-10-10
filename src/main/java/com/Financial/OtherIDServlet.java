package com.Financial;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OtherIDServlet")
public class OtherIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String oid = request.getParameter("rid");
		
		
		List<repairOther> repairOther = finacialDButill.getotherdetails(oid); 
		
	
		request.setAttribute("repairOther", repairOther);
		
		
		
		RequestDispatcher rs = request.getRequestDispatcher("otherDetails.jsp");
		
		rs.forward(request, response);
	}

}
