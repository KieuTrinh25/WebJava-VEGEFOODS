package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Database;
import dao.DatabaseDAO;
import dao.ProductDAO;
import model.Product;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String name = String.valueOf(request.getParameter("name"));
	        int categoryId = 0;
	        if (request.getParameter("categoryId") != null) {
	            categoryId = Integer.parseInt(request.getParameter("categoryId"));
	        }
	        ProductDAO productDAO = DatabaseDAO.getInstance().getProductDAO();
	        List<Product> productList = productDAO.all();
	        if (categoryId > 0 && name != null && !name.equals("")) {
	            productList = productDAO.findByNameAndCategoryId(name, categoryId);
	        } else if (name != null && !name.equals("")) {
	            productList = productDAO.findByName(name);
	        } else {
	            productList = productDAO.all();
	        }
	        
	        request.setAttribute("name", name);
	        request.setAttribute("productList", productList);
	        request.getRequestDispatcher("search.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
