package prac10;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/see")
public class SeeCookie extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		Cookie co[]= req.getCookies();
		for(int i=0;i<2;i++) {
		out.print("<h3>"+co[i].getName()+" : "+co[i].getValue()+"</h3><br>");
		}
	}

}
