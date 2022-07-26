package admin.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Database;
import dao.InfoUserDAO;
import dao.OrderDAO;
import dao.OrderDetailDAO;
import model.InfoUser;
import model.Order;
import model.OrderDetail;
import servlet.BaseServlet;

/**
 * Servlet implementation class ShowOrderServlet
 */
@WebServlet("/ShowOrderServlet")
public class ShowOrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oid = request.getParameter("orderId");
		if (oid.equals("")) oid = "0";
		int orderId = Integer.parseInt(oid);		
        OrderDetailDAO orderDetailDAO = Database.getInstance().getOrderDetailDAO();
        OrderDAO orderDAO = Database.getInstance().getOrderDAO();
      
        Order order = orderDAO.find(orderId);
        log(orderId + ": orderId");
        log(order.getName() + ": orderName");
        
        List<OrderDetail> orderDetailList = orderDetailDAO.findByOrderName(order.getName());
       
        request.setAttribute("order", order);
        request.setAttribute("orderDetailList", orderDetailList);

        request.getRequestDispatcher("./admin/orders/show.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
