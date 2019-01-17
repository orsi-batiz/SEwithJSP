package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginAdministratorServlet
 */
@WebServlet("/LoginAdministratorServlet")
public class LoginAdministratorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAdministratorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String securitykey = request.getParameter("securitykey");
		PrintWriter out = response.getWriter(); 
		
		String error = null;
		if(!username.equals("admin")) {
			error = "Not an administrator user.";
		} else if (!password.equals("Pa$$w0rd")){
			error = "Administrator password incorrect.";
		} else if (!securitykey.equals("531135")) {
			error = "Security key incorrect.";
		}
		if(error != null) {
			out.println("<html><head>");
			out.println("<script type='text/javascript'>");
			out.println("alert(" + "'" + error + "'" + ");</script>");
			out.println("</head><body></body></html>");
			HttpSession oldSession = request.getSession(false);
			if (oldSession != null) {
				oldSession.invalidate();
			}
			HttpSession newSession = request.getSession(true);
        	newSession.setAttribute("error", error);
			RequestDispatcher req1 = request.getRequestDispatcher("loginAdministrator.jsp");
			req1.forward(request, response);
		} else {
			HttpSession oldSession = request.getSession(false);
			if (oldSession != null) {
				oldSession.invalidate();
			}
			//generate a new session
			HttpSession newSession = request.getSession(true);
        	newSession.setAttribute("administrator", true);
        	RequestDispatcher req = request.getRequestDispatcher("/index.jsp");
			req.forward(request, response);
		}
		//doGet(request, response);
	}

}
