package Customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

;


@WebServlet("/CustomerUpdateServlet")
public class CustomerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String add=request.getParameter("add");
		String oldEmail=request.getParameter("submit");
			
		boolean istrue, istrue2;
		
		if (oldEmail.equals(email)) {
			istrue2=customerDButil.UpdateCustomer(id, name, email, phone, add);
			
			if(istrue2==true)
			{
				List<Customer>cusDetails=customerDButil.getUpdateDetails(email);
				request.setAttribute("cusDetails", cusDetails);
				RequestDispatcher dis=request.getRequestDispatcher("Customerprofile.jsp");
				dis.forward(request,response);
			}
			else
			{
				RequestDispatcher dis2=request.getRequestDispatcher("CustomerUpdate.jsp");
				dis2.forward(request,response);
			}	
		}
		else {
			istrue=customerDButil.validateEmail(email);
			
			if(istrue==true) {
				istrue2=customerDButil.UpdateCustomer(id, name, email, phone, add);
				
				if(istrue2==true)
				{
					List<Customer>cusDetails=customerDButil.getUpdateDetails(email);
					request.setAttribute("cusDetails", cusDetails);
					RequestDispatcher dis=request.getRequestDispatcher("Customerprofile.jsp");
					dis.forward(request,response);
				}
				else
				{
					RequestDispatcher dis2=request.getRequestDispatcher("CustomerUpdate.jsp");
					dis2.forward(request,response);
				}	
			}
			else {
				pw.println("<script>alert('This email already has an account')</script>");
				
				RequestDispatcher dis1=request.getRequestDispatcher("CustomerUpdate.jsp");
				dis1.include(request,response);
			}
		}
	}
}
