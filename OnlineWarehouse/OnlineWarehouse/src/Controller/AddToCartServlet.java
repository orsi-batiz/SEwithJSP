package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.Products;
import models.Customer;
import models.Product;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
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
		Customer c = (Customer) request.getSession(false).getAttribute("customer");
		String id = request.getParameter("id");
	    System.out.println(id);
		Product p = Products.products.get(Integer.parseInt(id));
		System.out.println(p);
		c.addProductToCart(p);
		
		HttpSession oldSession = request.getSession(false);
		if (oldSession != null) {
			oldSession.invalidate();
		}
		//generate a new session
		HttpSession newSession = request.getSession(true);
    	newSession.setAttribute("customer", c);
    	if(c != null && c.isNewsletter()) {
    		newSession.setAttribute("newsletter", true);
    	}
    	System.out.println(c.getCart());
    	newSession.setAttribute("products", c.getCart());
    	RequestDispatcher req = request.getRequestDispatcher("/cart.jsp");
		req.forward(request, response);
	}

}
