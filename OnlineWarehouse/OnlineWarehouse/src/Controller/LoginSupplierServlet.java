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

import data.Customers;
import data.Suppliers;
import models.Customer;
import models.Supplier;

/**
 * Servlet implementation class LoginSupplierServlet
 */
@WebServlet("/LoginSupplierServlet")
public class LoginSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSupplierServlet() {
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
		PrintWriter out = response.getWriter(); 
		
		String error = null;
		boolean used = false;
		int id = 0;
		for(Supplier s : Suppliers.suppliers.values()) {
			if (s.getUsername().equals(username)) {
				id = s.getId();
				used = true;
			}
		}
		if(used) {
			if(!Suppliers.suppliers.get(id).getPassword().equals(password)) {
				error = "Wrong password.";
			}
		} else {
			error = "No such supplier exists.";
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
			RequestDispatcher req1 = request.getRequestDispatcher("loginSupplier.jsp");
			req1.forward(request, response);
		} else {
			Supplier s = Suppliers.suppliers.get(id);
			HttpSession oldSession = request.getSession(false);
			if (oldSession != null) {
				oldSession.invalidate();
			}
			//generate a new session
			HttpSession newSession = request.getSession(true);
        	newSession.setAttribute("supplier", s);
        	RequestDispatcher req = request.getRequestDispatcher("/index.jsp");
			req.forward(request, response);
		}
	}

}
