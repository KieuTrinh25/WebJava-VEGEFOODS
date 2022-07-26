package admin.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.Auth;
import dao.Database;
import dao.DatabaseDAO;
import dao.ProductDAO;
import model.Product;
import servlet.BaseServlet;
import utils.URLSite;

/**
 * Servlet implementation class IndexProductServlet
 */
@WebServlet("/IndexProductServlet")
public class IndexProductServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
	        session.setAttribute("urlBack", URLSite.ADMIN_INDEX_PRODUCT_URL);
	        Auth.init(request.getSession());
	        if(!Auth.isAdmin()) response.sendRedirect("LoginServlet");
	        else {
	            ProductDAO productDAO = DatabaseDAO.getInstance().getProductDAO();

	            List<Product> productList = productDAO.all();
	            request.setAttribute("productList", productList);
	            request.getRequestDispatcher("./admin/products/index.jsp").forward(request, response);
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
