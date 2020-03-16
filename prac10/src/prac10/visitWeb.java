package prac10;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/visit")

public class visitWeb extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		PrintWriter out= res.getWriter();
		res.setContentType("text/html");
		Cookie co[]= req.getCookies(),v=null;
		int visit;
		if(co!=null) {
			for(Cookie i :co) {
				if(i.getName().equals("visit"))
				{ v= i;
				}
			}
		}
		if(v==null) {
			 visit=1;
		}else { 
			visit=Integer.parseInt(v.getValue());
		}
		out.print("<h3>Web Visit Number : "+visit+"</h3>");
		
		Cookie new_v = new Cookie("visit", Integer.toString(visit+1));
		res.addCookie(new_v);
		
		
	}
}
