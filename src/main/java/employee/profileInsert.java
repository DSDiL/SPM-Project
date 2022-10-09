package employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/employeeInsert")
public class profileInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out =response.getWriter(); 
		response.setContentType("text/html");
		
		String nic = request.getParameter("nic");
		String name = request.getParameter("fname");
		String position = request.getParameter("position");
		String salary = request.getParameter("salary");
		String password = request.getParameter("password");
		String section = request.getParameter("section");
		String email = request.getParameter("email");
		
		String subject = "New Employee Signup";
		String content = "Dear "+name+",\n Welcome to the Darkshop Electronics (pvt) ltd!!!\n Your employee profile has been created. \n Use "+password+" to login to Darkshop website as an employee";
		
		String host = "smtp.gmail.com";
		String port = "587";
		String user = "darkshop.pvt@gmail.com";
		String pass = "kubpjjjdjcmzrvsj";
		
		boolean isTrue, isTrue1;
		
		isTrue = employeeDB.insertEmployeeDetails(nic, name, position, salary, password, section, email);
		
		if (isTrue == true) {
			
			try {
	            employeeDB.sendEmail(host, port, user, pass, email, subject, content);
	        } 
			catch (Exception ex) {
	            ex.printStackTrace();
	        }
			
			isTrue1 = employeeDB.insertLeavingDetails(nic);
			
			if (isTrue1 == true) {
				RequestDispatcher dis1 = request.getRequestDispatcher("employeeManagement.jsp");
				dis1.forward(request, response);
			}
		} 
		else {
			out.println("<script type= 'text/javascript'>");   
			out.println("alert('Please check again');");
			out.println("location ='employeeSignup.jsp'");
			out.println("</script>");		}
	}
}
