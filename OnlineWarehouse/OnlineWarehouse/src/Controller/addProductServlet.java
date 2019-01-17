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
import data.Products;
import models.Customer;
import models.Product;
import models.Supplier;

/**
 * Servlet implementation class addProductServlet
 */
@WebServlet("/addProductServlet")
public class addProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addProductServlet() {
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
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String price = request.getParameter("price");
		String stock = request.getParameter("stock");
				
		PrintWriter out = response.getWriter();
		int i = 0;
		String error = null;
		if(Integer.parseInt(stock) < 0) {
			error = "Stock must be positive!";
		} else if(Double.parseDouble(price) < 0) {
			error = "Price can't be negative!";
		}
		Supplier s = (Supplier) request.getSession(false).getAttribute("supplier");
		
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
        	newSession.setAttribute("supplier", s);
        	RequestDispatcher req = request.getRequestDispatcher("/addProduct.jsp");
			req.forward(request, response);
		} else {
			Product p = new Product();
			p.setName(name);
			p.setSupplierId(s.getId());
			p.setCompany(s.getCompany());
			p.setPrice(Double.parseDouble(price));
			p.setStock(Integer.parseInt(stock));
			p.setOnDiscount(0);
			p.setSold(0);
			int id = Products.products.keySet().size() + 1;
			Products.products.put(id, p);
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
