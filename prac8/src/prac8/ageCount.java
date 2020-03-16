package prac8;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.text.*;
import java.time.*;
import java.util.*;

@WebServlet("/countage")
public class ageCount extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException   {
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String bdate = req.getParameter("birthdate");
		String test[]= bdate.split("-");
		LocalDate birth= LocalDate.of(Integer.parseInt(test[0]), Integer.parseInt(test[1]), Integer.parseInt(test[2]));
		LocalDate now = LocalDate.now();
		Period age = Period.between(birth, now);
		out.println("<h3>Age:");
		out.println(age.getYears()+" Years ");
		out.println(age.getMonths()+ " Months ");
		out.println(age.getDays()+" Days</h3>");
		
	
	}

}
