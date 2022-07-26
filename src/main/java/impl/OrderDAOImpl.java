package impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.OrderDAO;
import db.MySQLDriver;
import model.Order;
import utils.StringHelper;

public class OrderDAOImpl implements OrderDAO{

	@Override
	public Order insert(Order order) {
		 Connection conn = MySQLDriver.getInstance().getConnection();
	        try {
	            String sql = "INSERT INTO Orders(name, description, status, users_id, code) VALUES(?,?,?,?,?)";            
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, order.getName());
	            stmt.setString(2, order.getDescription());
	            stmt.setString(3, order.getStatus());
	            stmt.setInt(4, order.getUsers_id());
	            String code = StringHelper.randomString(8);
	            stmt.setString(5, code);

	            stmt.execute();
	            
	            //Query select order inserted.
	            sql = "SELECT * FROM Orders WHERE name=? LIMIT 1";
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, order.getName());
	            
	            ResultSet rs = stmt.executeQuery();
	            while(rs.next()){
	                int id = rs.getInt("id");
	                String name = rs.getString("name");
	                String description = rs.getString("description");
	                String status = rs.getString("status");
	                int users_id = rs.getInt("users_id");
	              //  Date created_at = rs.getDate("created_at");
	                return new Order(id, name, description, status, users_id);
	            }
	            
	        } catch (SQLException ex) {
	        	ex.printStackTrace();

	        }
	        return null;
	}

	@Override
	public boolean update(Order order) {
		 Connection conn = MySQLDriver.getInstance().getConnection();
	        try {
	            String sql = "UPDATE ORDERS SET NAME=?, DESCRIPTION=?, STATUS=?, USERS_ID=? WHERE ID=?";            
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, order.getName());
	            stmt.setString(2, order.getDescription());
	            stmt.setString(3, order.getStatus());
	            stmt.setInt(4, order.getUsers_id());
	            stmt.setInt(5, order.getId());
	            stmt.execute();
	        } catch (SQLException ex) {
	            return false;
	        }
	        return true;
	}

	@Override
	public boolean delete(int orderId) {
		 Logger.getLogger("OrderDAO").info(orderId + ": order delete");
	       Connection conn = MySQLDriver.getInstance().getConnection();
	        try {
	            String sql = "DELETE FROM ORDERS WHERE ID=?";            
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, orderId);
	            stmt.execute();
	        } catch (SQLException ex) {
	            Logger.getLogger("OrderDAO").info(ex.toString());
	            return false;
	        }
	        return true;
	}

	@Override
	public List<Order> all() {
		 List<Order> orderList = new ArrayList<>();
	        Connection conn = MySQLDriver.getInstance().getConnection();
	        try {
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery("SELECT * FROM ORDERS");
	            while(rs.next()){
	                int id = rs.getInt("id");
	                String name = rs.getString("name");
	                String description = rs.getString("description");
	                String status = rs.getString("status");
	                int users_id = rs.getInt("users_id");
	                 
	                orderList.add(new Order(id, name, description, status, users_id));
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return orderList;
	}

	@Override
	public Order find(int id) {
		Connection conn = MySQLDriver.getInstance().getConnection();
        try {
            String sql = "SELECT * FROM ORDERS WHERE ID=? LIMIT 1";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){           	 
                String name = rs.getString("name");
                String description = rs.getString("description");
                String status = rs.getString("status");
                int users_id = rs.getInt("users_id");
                return new Order(id, name, description, status, users_id);
            }
        } catch (SQLException ex) {
            return null;
        }
        return null;
	}

	@Override
	public List<Order> findByProperty(String column, Object value) {
		List<Order> orderList = new ArrayList<>();
        Connection conn = MySQLDriver.getInstance().getConnection();
        try {
            String sql = "SELECT * FROM ORDERS WHERE ?=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, column);
            stmt.setString(2, value.toString());
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String status = rs.getString("status");
                int users_id = rs.getInt("users_id");
                orderList.add(new Order(id, name, description, status, users_id));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderList;
	}

	@Override
	public List<Order> findByStatus(String status) {
		List<Order> orderList = new ArrayList<>();
        Connection conn = MySQLDriver.getInstance().getConnection();
        try {
            String sql = "SELECT * FROM ORDERS WHERE status=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, status);
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                int users_id = rs.getInt("users_id");
                orderList.add(new Order(id, name, description, status, users_id));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderList;
	}

}
