package Customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VerifyCodeServlet")
public class VerifyCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email= request.getParameter("email");
		String code= request.getParameter("code");
				
		boolean istrue;
		
		istrue = customerDButil.validateCode(email, code);
		
		if (istrue == true) {
			try {
				List<Verify> verify = customerDButil.getVerify(email);
				request.setAttribute("verify", verify);
				
				System.out.println(verify);
							
				RequestDispatcher dis1=request.getRequestDispatcher("customerChangePassword.jsp");
				dis1.forward(request,response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		else {
			RequestDispatcher dis1=request.getRequestDispatcher("customerEmailVerify.jsp");
			dis1.forward(request,response);
		}
	}
}
