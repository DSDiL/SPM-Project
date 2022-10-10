package com.Financial;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmpSalaryDelete")
public class EmpSalaryDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String nic = request.getParameter("nic");
		String salid = request.getParameter("salID");
		
		
		
		boolean IsTrue;
		
		

		IsTrue = finacialDButill.deletesalary(salid);
		
		
		if (IsTrue == true) {
			
			
			List<EmpSalaryDetails> emp = finacialDButill.getemphistroy(nic); 
			
			
			request.setAttribute("emp", emp);
			
			
			
		RequestDispatcher dis1 = request.getRequestDispatcher("EmpSalaryHistory.jsp");
		dis1.forward(request, response);
		}
		
		
		else {
		RequestDispatcher dis2 = request.getRequestDispatcher("error.jsp");
		dis2.forward(request, response);
		}
		
		
		
	}

}
