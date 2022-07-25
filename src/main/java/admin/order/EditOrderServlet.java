package admin.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Database;
import dao.DatabaseDAO;
import dao.OrderDAO;
import model.Order;
import servlet.BaseServlet;
import utils.URLSite;

/**
 * Servlet implementation class EditOrderServlet
 */
@WebServlet("/EditOrderServlet")
public class EditOrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("id"));
        
        DatabaseDAO.init(new Database());
        OrderDAO orderDAO = DatabaseDAO.getInstance().getOrderDAO();
        Order order = orderDAO.find(orderId);
        
        request.setAttribute("order", order);
        request.getRequestDispatcher("./admin/orders/edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("id"));

        OrderDAO orderDAO = DatabaseDAO.getInstance().getOrderDAO();
        Order order = orderDAO.find(orderId);        
    
        String status = request.getParameter("status");
        
        order.setStatus(status);
        
        orderDAO.update(order);
        
        response.sendRedirect(URLSite.ADMIN_INDEX_ORDER_URL);
	}

}
