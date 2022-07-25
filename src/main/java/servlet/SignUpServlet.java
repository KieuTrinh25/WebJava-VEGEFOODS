package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DatabaseDAO;
import dao.UserDAO;
import utils.URLSite;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignUpServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone = request.getParameter("phone");
        String password = request.getParameter("password"); 
        UserDAO userDAO = DatabaseDAO.getInstance().getUserDAO();
        boolean isRegister = userDAO.register(phone, password);
        
        if (isRegister) {
            System.out.println("Register successfully.");
            HttpSession session = request.getSession(true);
            session.setAttribute("logged", true);
            response.sendRedirect(URLSite.LOGIN_URL);
        } else {
            System.out.println("Register failed.");
            response.sendRedirect(URLSite.SIGNUP_URL);
        }
	}

}
