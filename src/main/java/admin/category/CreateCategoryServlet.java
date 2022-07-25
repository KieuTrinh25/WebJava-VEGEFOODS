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
 * Servlet implementation class CreateCategoryServlet
 */
@WebServlet("/CreateCategoryServlet")
public class CreateCategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   request.getRequestDispatcher("./admin/categories/create.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String name = request.getParameter("name");
	        String description = request.getParameter("description");
	        CategoryDAO categoryDAO = DatabaseDAO.getInstance().getCategoryDAO();
	        Category category = new Category(name, description);
	        
	        categoryDAO.insert(category);
	        response.sendRedirect(URLSite.ADMIN_INDEX_CATEGORY_URL);
	}

}
