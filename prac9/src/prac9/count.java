package prac9;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.Arrays;

@WebServlet("/count")
public class count extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String input[] = req.getParameterValues("input");
		int value[] = new int[input.length];
		for (int i=0;i<input.length;i++) {
			value[i]=Integer.parseInt(input[i]);
		}
		Arrays.sort(value);
		float arith=0,geo=1,har=0;
		for(int i :value) {
			arith+=i;
			geo*=i;
			har+=1/(float)i;
			
		}
		int l = value.length;
		arith = arith/l;
		geo = (float) Math.pow(geo, 1/(float)l);
		har = l/har;
		
		
		out.println("<html><body> <h3>Arithmetic Mean: "+arith);
		out.println("<br> Geometric Mean: "+geo);
		out.println("<br> Harmonic Mean: "+har+"</h3></body></html>");
		
		
	}

}
