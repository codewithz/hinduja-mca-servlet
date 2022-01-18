package com.hinduja;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class NameAgeServlet
 */
@WebServlet("/NameAgeServlet")
public class NameAgeServlet extends GenericServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public NameAgeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		// --------- Configure the Response Writer
			PrintWriter pw=response.getWriter();
			response.setContentType("text/html");
			
		
		//----------- Process the request parameters
			
			String name=request.getParameter("name");
			String a=request.getParameter("age");
			
			int age=Integer.parseInt(a);
			
			
			
		//----------- Respond back
		
			pw.println("<html><body>");
			pw.println("<b>Hello "+name+"<br>");
			pw.println("You are "+age+" years old, Next year you will be "+(age+1)+" years old");
			pw.println("</body></html>");
			
			pw.close();
	}

}
