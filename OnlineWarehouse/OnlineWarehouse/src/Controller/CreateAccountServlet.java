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
import models.Customer;

/**
 * Servlet implementation class CreateAccountServlet
 */
@WebServlet("/CreateAccountServlet")
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccountServlet() {
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
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		boolean newsletter = request.getParameter("newsletter") != null;
				
		PrintWriter out = response.getWriter();
		int i = 0;
		String error = null;
		boolean used = false;
		while(i < 1) {
			for(Customer c : Customers.customers.values()) {
				if (c.getUsername().equals(username)) {
					error = "The username you chose is already in use, please pick another one!";
					used = true;
				}
			}
			if(used) {
				break;
			}
			for(Customer c : Customers.customers.values()) {
				if (c.getEmail().equals(email)) {
					error = "The e-mail you entered is already in use, please pick another one!";
					used = true;
				}
			}
			if(used) {
				break;
			}
			if(!email.contains("@")) {
				error = "Invalid e-mail format.";
				break;
			}
			if(!email.contains(".")) {
				error = "Invalid e-mail format.";
				break;
			}
			if(password.length() < 8) {
				error = "Password should be at least 8 characters long.";
				break;
			}
			++i;
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
        	RequestDispatcher req = request.getRequestDispatcher("/createAccount.jsp");
			req.forward(request, response);
		} else {
			Customer c = new Customer();
			c.setUsername(username);
			c.setPassword(password);
			c.setFirstName(firstName);
			c.setLastName(lastName);
			c.setEmail(email);
			c.setGender(gender);
			c.setNewsletter(newsletter);
			int id = Customers.customers.keySet().size() + 1;
			Customers.customers.put(id, c);
			HttpSession oldSession = request.getSession(false);
			if (oldSession != null) {
				oldSession.invalidate();
			}
			//generate a new session
			HttpSession newSession = request.getSession(true);
        	newSession.setAttribute("customer", c);
        	if(newsletter) {
        		newSession.setAttribute("newsletter", true);
        	}
        	RequestDispatcher req = request.getRequestDispatcher("/index.jsp");
			req.forward(request, response);
		}
	}

}
