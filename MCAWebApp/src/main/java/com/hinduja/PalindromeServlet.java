package com.hinduja;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PalindromeServlet
 */
@WebServlet("/PalindromeServlet")
public class PalindromeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		//Prepare the Writer
			
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		
		//Process the Request
		
		String name=request.getParameter("name");
		StringBuffer sb=new StringBuffer(name);
		sb=sb.reverse();
		String reverse=sb.toString();
		
		boolean isPalindrome=name.equalsIgnoreCase(reverse);
		
		//Respond Back
			
			pw.println("<html><body>");
			pw.println("Palindrome Status for "+name+" is "+isPalindrome);
			pw.println("</body></html>");
		
		
	}

}
