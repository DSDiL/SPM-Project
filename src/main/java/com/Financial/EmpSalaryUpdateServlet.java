package com.Financial;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmpSalaryUpdateServlet")
public class EmpSalaryUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String salID = request.getParameter("salID");
		String nic = request.getParameter("nic");
		String basicsalary = request.getParameter("basicsalary");
		String etf = request.getParameter("etf");
		String epf = request.getParameter("epf");
		String ot = request.getParameter("ot");
		String bonus = request.getParameter("bonus");
		String total = request.getParameter("total");
		String date = request.getParameter("date");
		
		
		
	

		boolean isTrue;

		isTrue = finacialDButill.updatdeliverbill(salID,nic,basicsalary,etf,epf,ot,bonus,total,date);

		if (isTrue == true) {
			List<EmpSalaryDetails> emp = finacialDButill.getemphistroy(nic); 
			
			
			request.setAttribute("emp", emp);
			
			
			
			
		RequestDispatcher dis1 = request.getRequestDispatcher("EmpSalaryHistory.jsp");
		dis1.forward(request, response);
		}
		else {
		RequestDispatcher dis2 = request.getRequestDispatcher("EmpSalaryUpdateServlet.jsp");
		dis2.forward(request, response);
		}
		
		
		
		
	}

}
