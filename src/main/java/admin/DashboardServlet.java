package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.Auth;
import dao.Database;
import dao.OrderDAO;
import servlet.BaseServlet;
import utils.URLSite;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/DashboardServlet")
public class DashboardServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
	        session.setAttribute("urlBack", URLSite.ADMIN_INDEX_DASHBOARD_URL);
	        Auth.init(request.getSession());
	        if(!Auth.isAdmin()) response.sendRedirect("LoginServlet");
	        else {
	        	OrderDAO orderDAO = Database.getInstance().getOrderDAO();
	        	int pendingCount = orderDAO.findByStatus("pending").size();
	        	int finishedCount = orderDAO.findByStatus("finished").size();
	        	int boomCount = orderDAO.findByStatus("boom").size();
	        	request.setAttribute("pending", pendingCount);
	        	request.setAttribute("finished", finishedCount);
	        	request.setAttribute("boom", boomCount);
	        	request.getRequestDispatcher("./admin/index.jsp").forward(request, response);
	      
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
