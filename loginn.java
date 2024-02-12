package dipu1stServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class loginn extends HttpServlet 
{
	Connection con;
	public void init(ServletConfig config)
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","dipu");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
    	
		try
		{	
		String s1 = request.getParameter("uname");
		String s2 = request.getParameter("pawad");
	
		PreparedStatement pstmt=con.prepareStatement("select*from emp where uname=? and pawad=?");
		pstmt.setString(1, s1);
		pstmt.setString(2, s2);
		
		ResultSet rs=pstmt.executeQuery();
		
		
		PrintWriter pw=response.getWriter();
		pw.println("<html><body bgcolor=orange text=black><center><h1>");
		if(rs.next())
		{
			RequestDispatcher rd=request.getRequestDispatcher("/Welcome");
			rd.forward(request, response);
		}
		else
		{
			pw.println("invalid the user name/password");
			RequestDispatcher rd=request.getRequestDispatcher("/login.html");
			rd.include(request, response);
		}
		pw.println("</h1></center></body></html>");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		} finally {
		}
	}
    public void destroy()
    {
    	try
    	{
    		con.close();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

}
