package pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
//@WebServlet("/fetchdetail")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//settig the file type
		response.setContentType("text/html");
		//getting the username and password from html file and setting it into String variable
		String userName=request.getParameter("un");
		String passWord=request.getParameter("pw");
		
		PrintWriter pw=response.getWriter();
		
		//getting the username from web xml file
		ServletContext ctx=getServletContext();
		String user=(String)ctx.getInitParameter("username");
		String pass=(String)ctx.getInitParameter("password");
		
		//checking the condition
		if (userName.equals(user) && passWord.equals(pass)) {
			response.sendRedirect("https://www.cybersuccess.biz/");
		} else {
			response.sendRedirect("error.html");
		}
		
//		pw.println("<h3> html username"+userName+" "+passWord+"</h3>");
//		pw.println("<h3> web username"+user+" "+pass+"</h3>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		}

}