package com.Financial;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmpSalaryServlet")
public class EmpSalaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nic = request.getParameter("nic");
		
		List<EmpSalaryDetails> emp = finacialDButill.getemphistroy(nic); 
		request.setAttribute("emp", emp);
		
		RequestDispatcher rs = request.getRequestDispatcher("EmpSalaryHistory.jsp");
		rs.forward(request, response);
		
	}

}
