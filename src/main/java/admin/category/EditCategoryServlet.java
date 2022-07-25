package admin.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import dao.Database;
import dao.DatabaseDAO;
import model.Category;
import servlet.BaseServlet;
import utils.URLSite;

/**
 * Servlet implementation class EditCategoryServlet
 */
@WebServlet("/EditCategoryServlet")
public class EditCategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int categoryId = Integer.parseInt(request.getParameter("id"));
	        
	        DatabaseDAO.init(new Database());
	        CategoryDAO categoryDAO = DatabaseDAO.getInstance().getCategoryDAO();
	        Category category = categoryDAO.find(categoryId);
	        
	        request.setAttribute("category", category);
	        request.getRequestDispatcher("./admin/categories/edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  int categoryId = Integer.parseInt(request.getParameter("id"));
	        CategoryDAO categoryDAO = DatabaseDAO.getInstance().getCategoryDAO();
	        Category category = categoryDAO.find(categoryId);        
	        
	        String name = request.getParameter("name");
	        String description = request.getParameter("description");
	        
	        category.setName(name);
	        category.setDescription(description);
	        
	        categoryDAO.update(category);
	        
	        response.sendRedirect(URLSite.ADMIN_INDEX_CATEGORY_URL);
	}

}
