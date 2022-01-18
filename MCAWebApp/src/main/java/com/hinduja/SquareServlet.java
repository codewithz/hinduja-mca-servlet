package com.hinduja;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SquareServlet
 */
@WebServlet("/SquareServlet")
public class SquareServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		
		//Prepare the Writer
			
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		
		//Process the Request
		
			int number=Integer.parseInt(request.getParameter("number"));
			
			int square=number*number;
		
		//Respond Back
			
			pw.println("<html><body>");
			pw.println("<b>Square of "+number+" is "+square);
			pw.println("</body></html>");
	}
	
	
}
