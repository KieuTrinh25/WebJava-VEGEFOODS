package admin.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.Auth;
import dao.DatabaseDAO;
import dao.OrderDAO;
import model.Order;
import servlet.BaseServlet;
import utils.URLSite;

/**
 * Servlet implementation class IndexOrderServlet
 */
@WebServlet("/IndexOrderServlet")
public class IndexOrderServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
	        session.setAttribute("urlBack", URLSite.ADMIN_INDEX_ORDER_URL);
	        Auth.init(request.getSession());
	        if(!Auth.isAdmin()) response.sendRedirect("LoginServlet");
	        else {
	            OrderDAO orderDAO = DatabaseDAO.getInstance().getOrderDAO();
	            List<Order> orderList = orderDAO.all();
	            request.setAttribute("orderList", orderList);
	            request.getRequestDispatcher("./admin/orders/index.jsp").forward(request, response);
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
