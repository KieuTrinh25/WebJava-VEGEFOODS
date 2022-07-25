package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.OrderDetailSession;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
        switch (action) {
            case "create":
                createOrder(request, response);
                break;
            case "delete":
                deleteOrder(request, response);
                break;                
            case "update":
                updateOrder(request, response);
                break;
            default:
                throw new AssertionError();
        }
	}

	private void updateOrder(HttpServletRequest request, HttpServletResponse response) {
		 throw new UnsupportedOperationException("Not supported yet.");
		
	}

	private void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int productId = Integer.parseInt(request.getParameter("productId"));
        HttpSession session = request.getSession();
        List<OrderDetailSession> orderDetailSessionList = null;
        if(session.getAttribute("cart") != null){
            //Ton tai gio hang
            orderDetailSessionList = (List<OrderDetailSession>) session.getAttribute("cart");
            for (OrderDetailSession ods : orderDetailSessionList) {
                if(ods.getProductId() == productId){
                    orderDetailSessionList.remove(ods);
                    break;
                }
            }
        }
        
        session.setAttribute("cart", orderDetailSessionList);
        response.sendRedirect("CartServlet");
		
	}

	private void createOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int productId = Integer.parseInt(request.getParameter("productId"));
		String images = request.getParameter("images");
        String productName = request.getParameter("productName");
        float price = Float.parseFloat(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        
        HttpSession session = request.getSession();
        List<OrderDetailSession> orderDetailSessionList = null;
        
        boolean isProductExist = false;
        if(session.getAttribute("cart") != null){
        	
            //Ton tai gio hang
            orderDetailSessionList = (List<OrderDetailSession>) session.getAttribute("cart");
            for (OrderDetailSession ods : orderDetailSessionList) {
                if(ods.getProductId() == productId){
                    ods.setQuantity(ods.getQuantity() + quantity);
                    isProductExist = true;
                    break;
                }
            }
        }else{
            //Gio hang chua ton tai
            orderDetailSessionList = new ArrayList<OrderDetailSession>();
        }
        
        if(!isProductExist){
            OrderDetailSession orderDetailSession = new OrderDetailSession(productId,images, productName, quantity, price);
            orderDetailSessionList.add(orderDetailSession);
        }
        
        session.setAttribute("cart", orderDetailSessionList);
        Logger.getLogger(OrderServlet.class.getName()).info(orderDetailSessionList.size() + ":" + productId);
        response.sendRedirect("CartServlet");		
	}

}
