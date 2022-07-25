package admin.user;

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
import dao.UserDAO;
import model.User;
import servlet.BaseServlet;
import utils.URLSite;

/**
 * Servlet implementation class ShowUserServlet
 */
@WebServlet("/ShowUserServlet")
public class CreateUserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.getRequestDispatcher("./admin/users/create.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        UserDAO userDAO = DatabaseDAO.getInstance().getUserDAO();
        User user = new User(phone, password, User.ROLE_USER);
        
        userDAO.insert(user);
        response.sendRedirect(URLSite.ADMIN_INDEX_USER_URL);
	}

}
