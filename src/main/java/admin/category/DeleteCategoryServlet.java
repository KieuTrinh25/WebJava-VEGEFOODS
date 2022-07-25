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
import servlet.BaseServlet;
import utils.URLSite;

/**
 * Servlet implementation class DeleteCategoryServlet
 */
@WebServlet("/DeleteCategoryServlet")
public class DeleteCategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	int categoryId = Integer.parseInt(request.getParameter("id"));
	        CategoryDAO categoryDAO = DatabaseDAO.getInstance().getCategoryDAO();
	        System.out.println("cbi xoa id => " + categoryId);
	        if (categoryDAO.delete(categoryId)) {
	        	System.out.println("xoa dc roi");
	        } else {
	        	System.out.println("kh xoa dc");
	        }
	        
	        response.sendRedirect(URLSite.ADMIN_INDEX_CATEGORY_URL);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
