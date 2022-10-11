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


@WebServlet("/EmpReportServlet")
public class EmpReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		response.setContentType("text/html");
		
		String nic = request.getParameter("nic");
		Boolean isTrue;
		
		isTrue = finacialDButill.empreport(nic);
		
		if(isTrue==true) {
			
			
			List<EmpSalaryDetails>rep = finacialDButill.getempreport(nic);
			
			request.setAttribute("rep", rep);
			
			
			
		try {
			
			
			RequestDispatcher rs = request.getRequestDispatcher("ReportEmp.jsp");
			
			rs.forward(request, response);
			
			
			
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		}else {
			
		
			out.println("<script type= 'text/javascript'>");
			out.println("alert('Entered Data is invalid ');");
			out.println("location ='EmpSalaryHistory.jsp'");
			out.println("</script>");


			
		}
		
		
		
	
	}

}
