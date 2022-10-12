package com.Financial;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmpSalaryInsertServlet")
public class EmpSalaryInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		
		String nic = request.getParameter("nic");
		String epf = request.getParameter("epf");
		String etf = request.getParameter("etf");
		String ot = request.getParameter("ot");
		String bonus = request.getParameter("bonus");
		String basicsalary = request.getParameter("basicsalary");
		String date = request.getParameter("date");
	

		boolean isTrue;

		isTrue = finacialDButill.insertdeliverybill(nic,epf,etf,ot,bonus,basicsalary,date);

		if (isTrue == true) {
			List<Empdetails> emp = finacialDButill.getemp(); 
			
			
			request.setAttribute("emp", emp);
		RequestDispatcher dis1 = request.getRequestDispatcher("EmpID.jsp");
		dis1.forward(request, response);
		}
		else {
		RequestDispatcher dis2 = request.getRequestDispatcher("error.jsp");
		dis2.forward(request, response);
		}
		
		
	}
	}


