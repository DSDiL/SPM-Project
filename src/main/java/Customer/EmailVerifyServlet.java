package Customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmailVerifyServlet")
public class EmailVerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		String nums = "1234567890";
		int length = 6;
		String code = null;

		try {
			StringBuilder sb = new StringBuilder();
			Random random = new Random();

			for (int i = 0; i < length; i++) {
				sb.append(nums.charAt(random.nextInt(nums.length())));
			}
			code = sb.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String email= request.getParameter("email");
		
		String subject = "New Employee Signup";
		String content = "Dear Customer,\n Your e-mail verificition code is "+code+". Use the code to move on the password change";
		String host = "smtp.gmail.com";
		String port = "587";
		String user = "darkshop.pvt@gmail.com";
		String pass = "kubpjjjdjcmzrvsj";
				
		boolean istrue;
		
		istrue=customerDButil.validateEmail(email);
		
		if(istrue==true) {
			pw.println("<script>alert('This email does not have an account')</script>");
			
			RequestDispatcher dis1=request.getRequestDispatcher("customerLogin.jsp");
			dis1.forward(request,response);
		}
		else {
			try {
				customerDButil.sendEmail(host, port, user, pass, email, subject, content, code);
	        } 
			catch (Exception ex) {
	            ex.printStackTrace();
	        }
			
			List<Verify> verify = customerDButil.getVerify(email);
			request.setAttribute("verify", verify);
						
			RequestDispatcher dis1=request.getRequestDispatcher("verifyCode.jsp");
			dis1.forward(request,response);
		}
	}
}
