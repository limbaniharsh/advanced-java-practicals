package prac9;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/total")
public class total extends HttpServlet {
	public void doPost( HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		res.setContentType("text/html");
		int total = Integer.parseInt(req.getParameter("input"));
		PrintWriter out = res.getWriter();
		out.println("<html><head></head><body><form action=\"count\" method=\"post\"><h3>Enter Number</h3>");
		for(int i=1;i<=total;i++) {
			
			out.print(i+" <input type=\"number\" name=\"input\"><br><br>");
		}
		out.print("<input type=\"submit\" name=\"submit\"></form></body></html>");
		
	}
	
	
	

}
