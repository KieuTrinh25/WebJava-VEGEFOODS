package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Database;
import  dao.DatabaseDAO;
import com.mysql.cj.Session;

import dao.UserDAO;
import model.User;
import utils.URLSite;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if (session.getAttribute("logged") != null) {
            response.sendRedirect(URLSite.HOME_URL);
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	String phone = request.getParameter("phone");
	        String password = request.getParameter("password");
	        UserDAO userDAO = DatabaseDAO.getInstance().getUserDAO();
	        User user = userDAO.login(phone, password);
	        if (user != null) {
	            System.out.println("Login successfully.");
	            HttpSession session = request.getSession(true);
	            
	            session.setAttribute("logged", true);
	            session.setAttribute("user", user);
	            String url = (String) session.getAttribute("urlBack");
	            if (url != null) response.sendRedirect(url);
	            else
	            response.sendRedirect(URLSite.ADMIN_INDEX_DASHBOARD_URL);
	        } else {
	            System.out.println("Login failed.");
	            response.sendRedirect(URLSite.LOGIN_URL);
	        }
	}

}
