package com.Financial;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RepairIDServlet")
public class RepairIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rid = request.getParameter("rid");
		boolean isTrue;
			 
			
		
		isTrue = finacialDButill.validate(rid);
		
		if(isTrue== true)
		{
			
		List<repaircomputer> repaircomputer = finacialDButill.getcomputerrepair(rid); 
		request.setAttribute("repaircomputer", repaircomputer);
		
		try {

		RequestDispatcher rs = request.getRequestDispatcher("RepairBillDetails.jsp");
	
		rs.forward(request, response);
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("aaa");			}
		}else
		{
		RequestDispatcher rs = request.getRequestDispatcher("RepairID.jsp");
		rs.forward(request, response);
		}
		

		
		
	}

}
