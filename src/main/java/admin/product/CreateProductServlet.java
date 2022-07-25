package admin.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import dao.Database;
import dao.DatabaseDAO;
import dao.ProductDAO;
import model.Category;
import model.Product;
import utils.URLSite;

/**
 * Servlet implementation class CreateCategoryServlet
 */
@WebServlet("/CreateProductServlet")
public class CreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");  
		DatabaseDAO.init(new Database());
	        CategoryDAO categoryDAO =  DatabaseDAO.getInstance().getCategoryDAO();
	        List<Category> categoryList = categoryDAO.all();
	        
	        request.setAttribute("categoryList", categoryList);
	        request.getRequestDispatcher("./admin/products/create.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String images = request.getParameter("image");
        int categoryId = Integer.parseInt(request.getParameter("Categories_id"));
      
        DatabaseDAO.init(new Database());
        ProductDAO productDAO = DatabaseDAO.getInstance().getProductDAO();
        Product product = new Product(name, price, quantity, images, categoryId);
        
        productDAO.insert(product);
        response.sendRedirect(URLSite.ADMIN_INDEX_PRODUCT_URL);
	}

}
