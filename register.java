package dipu1stServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



// xml annotations
public class register extends HttpServlet 
{
	Connection con;
	public void init()throws ServletException
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","dipu");
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//PrintWriter pw=response.getWriter();
		try {
		String s1=request.getParameter("fname");
		String s2=request.getParameter("lname");
		String s3=request.getParameter("uname");
		String s4=request.getParameter("pawad");
		
			PreparedStatement pstmt=con.prepareStatement("insert into emp values(?,?,?,?)");
			
			pstmt.setString(1, s1);
			pstmt.setString(2, s2);
			pstmt.setString(3, s3);
			pstmt.setString(4, s4);
			
			pstmt.executeUpdate();
			
			PrintWriter pw=response.getWriter();
			
			pw.println("<html><body bgcolor=cyan text=black><center>");
			pw.println("<h1> you have register successfuly</h1>");
			pw.println("<a href=login.html>Login</a>");
			pw.println("</center> </body> </html>");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
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

