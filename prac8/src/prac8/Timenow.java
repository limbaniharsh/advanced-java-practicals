package prac8;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.io.*;


@WebServlet("/timenow")
public class Timenow extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setIntHeader("Refresh", 1);
		res.setContentType("text/html");
		Date now =new Date();
		SimpleDateFormat f= new SimpleDateFormat("hh:mm:ss E dd MMMM yyyy");
		String out_str = f.format(now);
		PrintWriter out = res.getWriter();
		
		out.println("<h3>"+out_str+"</h3");
		
		
	}

}
