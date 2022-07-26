package admin.product;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

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
import servlet.BaseServlet;
import utils.URLSite;

/**
 * Servlet implementation class EditCategoryServlet
 */
@WebServlet("/EditProductServlet")
public class EditProductServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("id"));
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");  

        CategoryDAO categoryDAO =  DatabaseDAO.getInstance().getCategoryDAO();
        List<Category> categoryList = categoryDAO.all();
        
        ProductDAO productDAO = DatabaseDAO.getInstance().getProductDAO();
        Product product = productDAO.find(productId);
        
//        Category category = null;
//        for (Category cat: categoryList) {
//            if(cat.getId() == product.getCategories_id()) {
//                category = cat;
//            } 
//        }
//        
        request.setAttribute("categoryList", categoryList);
      //  request.setAttribute("categorySelected", category);
        request.setAttribute("product", product);
        request.getRequestDispatcher("./admin/products/edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");  
		
		int productId = Integer.parseInt(request.getParameter("id"));
	      
        DatabaseDAO.init(new Database());
        ProductDAO productDAO = DatabaseDAO.getInstance().getProductDAO();
        Product product = productDAO.find(productId); 
        
        String name = request.getParameter("name");
        String images = request.getParameter("image");
        float price = Float.parseFloat(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int categoryId = Integer.parseInt(request.getParameter("categories_id"));
        Logger.getLogger("Product").info(categoryId + ": categories_id");
        product.setImages(images);
        product.setName(name);
        product.setQuantity(quantity);
        product.setPrice(price);
        product.setCategories_id(categoryId);
        
        productDAO.update(product);
        
        response.sendRedirect(URLSite.ADMIN_INDEX_PRODUCT_URL);
	}

}
