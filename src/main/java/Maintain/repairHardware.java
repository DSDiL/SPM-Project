package techscope;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/repairHardware")
public class repairHardware extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cID=request.getParameter("cID");
		String appID=request.getParameter("appID");
		String com=request.getParameter("com");
		String date=request.getParameter("date");
		String des=request.getParameter("des");
		String cost=request.getParameter("cost");
		
		boolean istrue;
		
		istrue=repairDButil.insertHardwareRepair(cID,appID,com,date, des, cost);
		
		if(istrue==true)
		{
			RequestDispatcher dis=request.getRequestDispatcher("repairHome.jsp");
			dis.forward(request, response);
		}
		else
		{
			RequestDispatcher dis=request.getRequestDispatcher("repairFormComputer.jsp");
			dis.forward(request, response);
		}
	}
}

