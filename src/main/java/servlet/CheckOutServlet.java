package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.Auth;
import dao.DatabaseDAO;
import dao.InfoUserDAO;
import dao.OrderDAO;
import dao.OrderDetailDAO;
import model.InfoUser;
import model.Order;
import model.OrderDetail;
import model.OrderDetailSession;
import model.User;
import utils.StringHelper;
import utils.URLSite;

import java.util.List;
import java.util.logging.Logger;
/**
 * Servlet implementation class ChechOutServlet
 */
@WebServlet("/CheckOutServlet")
public class CheckOutServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger("CheckOutServlet");
       
 
    public CheckOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
	        session.setAttribute("urlBack", URLSite.HOME_URL);
	        Auth.init(request.getSession());
	        if(!Auth.isLogin()) response.sendRedirect("LoginServlet");
	        else
	        checkOut(request, response);
	}

 
	private void checkOut(HttpServletRequest request, HttpServletResponse response) throws IOException {		
	        OrderDAO orderDAO = DatabaseDAO.getInstance().getOrderDAO();
	        String name = StringHelper.randomString(Order.CODE_LENGHT);
	        String description = "Order san pham";
	        HttpSession session = request.getSession();
	        User user = (User)session.getAttribute("user");	     
			Order order = new Order( name, description, Order.PENDING_STATUS, user.getId());
	        order = orderDAO.insert(order);
	       
	        InfoUserDAO infoUserDAO = DatabaseDAO.getInstance().getInfoUserDAO();
	        String fullName = request.getParameter("full_name");
	        String address = request.getParameter("address");
	        String note = request.getParameter("note");

	        InfoUser infoUser = new InfoUser(fullName, address, note, user.getId());
	        infoUserDAO.insert(infoUser);

	        OrderDetailDAO orderDetailDAO = DatabaseDAO.getInstance().getOrderDetailDAO();
	        
	        List<OrderDetailSession> orderDetailSessionList = null;
	        
	        boolean isSuccess = true;
	        if(session.getAttribute("cart") != null){
	            //Ton tai gio hang
	            orderDetailSessionList = (List<OrderDetailSession>) session.getAttribute("cart");
	            for (OrderDetailSession ods : orderDetailSessionList) {
	                OrderDetail orderDetail = new OrderDetail(name, ods.getProductId(), ods.getProductName(), ods.getQuantity());
	                boolean created = orderDetailDAO.insert(orderDetail);
	                if (!created) {
	                    isSuccess = false;
	                    logger.info("order failed");
	                    break;
	                }
	            }
	        }
	        
	        response.sendRedirect("HomeServlet");
	        
	        //Xoa gio hang
	        if (isSuccess)
	            session.removeAttribute("cart");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   response.setContentType("text/html;charset=UTF-8");
	}
}

