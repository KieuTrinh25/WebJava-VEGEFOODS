package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.MySQLDriver;

/**
 * Servlet implementation class CRUDServlet
 */
@WebServlet("/CRUDServlet")
public class CRUDServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CRUDServlet() {
        super();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CRUDServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CRUDServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Connection conn = MySQLDriver.getInstance().getConnection();
		String action = request.getParameter("action");
		switch (action) {
			 case "select":
				select(conn, out);
				break;
			 case "insert":
	             insert(conn, out);
	             break;
	         case "delete":
	             delete(conn, out);
	             break;
	         case "update":
	             update(conn, out);
	             break;
	         default:
	             throw new AssertionError();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void update(Connection conn, PrintWriter out) {
		// TODO Auto-generated method stub
		
	}
	private void delete(Connection conn, PrintWriter out) {
		// TODO Auto-generated method stub
		
	}
	private void insert(Connection conn, PrintWriter out) {
		// TODO Auto-generated method stub
		
	}
	private void select(Connection conn, PrintWriter out) {
		 try {
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery("SELECT * FROM CATEGORIES");
			 while(rs.next()) {
				 String str = String.format("id:%d - name:%s - description:%s", rs.getInt("id"), rs.getString("name"), rs.getString("description"));
				 out.print(str);
			 }
		 }catch (SQLException ex) {
			  Logger.getLogger(CRUDServlet.class.getName()).log(Level.SEVERE, null, ex);
		 }
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
