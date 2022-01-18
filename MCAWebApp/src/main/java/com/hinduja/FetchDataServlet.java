package com.hinduja;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FetchDataServlet
 */
@WebServlet("/FetchDataServlet")
public class FetchDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Prepare the Writer
		
				PrintWriter pw=response.getWriter();
				response.setContentType("text/html");
				pw.println("<html><body>");
				//Process the Request
				
				try {
				
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					String url="jdbc:mysql://localhost:3306/hinduja_mca_2021";
					String user="root";
					String password="admin";
					
					Connection con=DriverManager.getConnection(url, user, password);
					System.out.println("Connection Acquired");
					
					String query="Select id,name,dept,designation,salary,doj from employee";
					Statement stmt=con.createStatement();
					
					ResultSet rs=stmt.executeQuery(query);
					
					pw.println("<table border=1>");
					pw.println("<tr>");
					pw.println("<th>ID</th>");
					pw.println("<th>Name</th>");
					pw.println("<th>Dept</th>");
					pw.println("<th>Designation</th>");
					pw.println("<th>Salary</th>");
					pw.println("<th>DOJ</th>");
					pw.println("</tr>");
					
					while(rs.next()) {
						
						int id=rs.getInt("id");
						String name=rs.getString("name");
						String dept=rs.getString("dept");
						String designation=rs.getString("designation");
						float salary=rs.getFloat("salary");
						String doj=rs.getString("doj");
						
						pw.println("<tr>");
						
						pw.println("<td>"+id+"</td>");
						pw.println("<td>"+name+"</td>");
						pw.println("<td>"+dept+"</td>");
						pw.println("<td>"+designation+"</td>");
						pw.println("<td>"+salary+"</td>");
						pw.println("<td>"+doj+"</td>");
						pw.println("</tr>");
						
					}
					
					pw.println("</table>");
					pw.println("</body></html>");
					
					pw.close();
					
				}
				catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			
				//Respond Back
					
					
				
					pw.println("</body></html>");
	}


}
