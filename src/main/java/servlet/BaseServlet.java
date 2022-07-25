package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import dao.Database;
import dao.DatabaseDAO;

public class BaseServlet extends HttpServlet{
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);

		DatabaseDAO.init(new Database());
	}

}
