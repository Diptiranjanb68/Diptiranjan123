package dipu1stServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String s=request.getParameter("uname");
		PrintWriter pw=response.getWriter();
		
		pw.println("<html><body bgcolor=lightGreen text=black><h1>");
		pw.println("welcome fulei kukurani, chorani , dahani "+s);
		pw.println("</h1></body></html>");
	}

}
