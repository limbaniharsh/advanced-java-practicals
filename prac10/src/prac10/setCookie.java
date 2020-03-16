package prac10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/cookie")
public class setCookie extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		
		Cookie name = new Cookie("name", req.getParameter("name"));
		Cookie age = new Cookie("age", req.getParameter("age"));
		
		res.addCookie(name);
		res.addCookie(age);
		//out.print("<html><body>");
		out.print("<h3>Cookie is added</h3>");
		out.print("<form action=\"see\" method=\"post\"><input type=\"submit\" value=\"See Cookie\"></form>");
		

	}
	
}
