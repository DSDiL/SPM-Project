package employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/employeeLogin")
public class employeeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out =response.getWriter(); 
		response.setContentType("text/html");

		String nic = request.getParameter("nic");
		String pw = request.getParameter("pw");

		boolean isTrue = employeeDB.validate(nic, pw);

		if (isTrue == true) {

			try {
				List<employee> empProf = employeeDB.getEmployeeDetails(nic, pw);
				request.setAttribute("empProf", empProf);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("aaaa");
			}

			RequestDispatcher dis = request.getRequestDispatcher("employeeHome.jsp");
			dis.forward(request, response);
		} else {
			out.println("<script type= 'text/javascript'>");   
			out.println("alert('your NIC number and password are incorrect please check again');");
			out.println("location ='employeeLogin.jsp'");
			out.println("</script>");
		}
	}

}
