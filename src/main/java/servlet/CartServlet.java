package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategoryDAO;
import dao.DatabaseDAO;
import model.Category;
import model.OrderDetailSession;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	
		CategoryDAO categoryDAO =  DatabaseDAO.getInstance().getCategoryDAO();
	    List<Category> categoryList = categoryDAO.all();	    	 
		request.setAttribute("categoryList", categoryList);		 
		  
		HttpSession session = request.getSession();
        List<OrderDetailSession> orderDetailSesionList = null;
        double total = 0D;
        if(session.getAttribute("cart") != null){
            orderDetailSesionList = (List <OrderDetailSession>)session.getAttribute("cart");
            for (OrderDetailSession orderDetailSession: orderDetailSesionList) {
                total += orderDetailSession.getPrice()*orderDetailSession.getQuantity();
            }
        }else{
            orderDetailSesionList = new ArrayList<OrderDetailSession>();
        }
        
        request.setAttribute("total", total);
        request.setAttribute("orderDetailSesionList", orderDetailSesionList);
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	         
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
