package admin.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DatabaseDAO;
import dao.OrderDAO;
import dao.OrderDetailDAO;
import model.Order;
import model.OrderDetail;
import servlet.BaseServlet;
import utils.URLSite;

/**
 * Servlet implementation class DeleteOrderServlet
 */
@WebServlet("/DeleteOrderServlet")
public class DeleteOrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("id"));
        OrderDAO orderDAO = DatabaseDAO.getInstance().getOrderDAO();
        OrderDetailDAO orderDetailDAO = DatabaseDAO.getInstance().getOrderDetailDAO();
        Order order = orderDAO.find(orderId);
        if (order != null) {
            List<OrderDetail> orderDetailList = orderDetailDAO.findByProperty("name", order.getDescription());
            if (orderDetailList != null && !orderDetailList.isEmpty()) {
                for(OrderDetail orderDetail: orderDetailList) {
                    orderDetailDAO.delete(orderDetail.getId());
                }
            }
        }
        log(orderId + ": order Id");
        boolean isDelete = orderDAO.delete(orderId);
         log(isDelete + ": delete");
        
        response.sendRedirect(URLSite.ADMIN_INDEX_ORDER_URL);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
