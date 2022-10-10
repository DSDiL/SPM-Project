package com.Financial;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RepairBillReport")
public class RepairBillReport extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out =response.getWriter();
		response.setContentType("text/html");
		
		String date = request.getParameter("date");
		Boolean isTrue;
		
		isTrue = finacialDButill.repairbillreport(date);
		
		if(isTrue==true) {
			
			
			List<computerBillHistory>report = finacialDButill.getrepairbillreport(date);
			
			request.setAttribute("report", report);
			
			
			
		try {
			
			
			RequestDispatcher rs = request.getRequestDispatcher("ReportComputer.jsp");
			
			rs.forward(request, response);
			
			
			
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		}else {
			
		
			out.println("<script type= 'text/javascript'>");
			out.println("alert('Entered Data is invalid ');");
			out.println("location ='RepairBillHistory.jsp'");
			out.println("</script>");


			
		}
		
		
		
	}

}
