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

@WebServlet("/CustomeLoginServlet")
public class CustomeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		PrintWriter out = response.getWriter();
//		response.setContentType("text/html");
		
		String Email= request.getParameter("email");
		String password = request.getParameter("pwd1");
		boolean isTrue;
		
		isTrue = customerDButil.login(Email, password);
		
		if (isTrue == true) {
			List<Customer> cusDetails = customerDButil.getCustomer(Email);
			request.setAttribute("cusDetails", cusDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("Customerprofile.jsp");
			dis.forward(request, response);
		} else {
//			out.println("<script type='text/javascript'>");
//			out.println("alert('your username or password is incorrect.\nPleae check again');");
//			out.println("location='customerLogin.jsp'");
//			out.println("</script>");
		
			RequestDispatcher dis2 = request.getRequestDispatcher("customerLogin.jsp");
			dis2.forward(request, response);
		}
		
		
	}

}
