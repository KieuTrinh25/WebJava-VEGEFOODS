package impl;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

 
import db.MySQLDriver;
import dao.OrderDetailDAO;
import model.OrderDetail;

public class OrderDetailDAOImpl implements OrderDetailDAO{

	@Override
	public boolean insert(OrderDetail orderDetail) {
		Connection conn = MySQLDriver.getInstance().getConnection();
        try {
            String sql = "INSERT INTO ORDERS_DETAILS VALUES(null,?,?,?,?)";            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, orderDetail.getOrders_code());
            stmt.setInt(2, orderDetail.getProducts_id());
            stmt.setString(3, orderDetail.getProducts_name());
            stmt.setInt(4, orderDetail.getQuantity());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger("OrderDetailDAO").info(ex.toString());
            return false;
        }
        return true;
	}

	@Override
	public boolean update(OrderDetail orderDetail) {
		Connection conn = MySQLDriver.getInstance().getConnection();
        try {
            String sql = "UPDATE ORDERS_DETAILS SET ORDERS_CODE=?, PRODUCTS_ID=?, PRODUCTS_NAME=?, QUANTITY=? WHERE ID=?";            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, orderDetail.getOrders_code());
            stmt.setInt(2, orderDetail.getProducts_id());
            stmt.setString(3, orderDetail.getProducts_name());
            stmt.setInt(4, orderDetail.getQuantity());
            stmt.setInt(5, orderDetail.getId());
            stmt.execute();
        } catch (SQLException ex) {
            return false;
        }
        return true;
	}

	@Override
	public boolean delete(int orderDetailId) {
		Connection conn = MySQLDriver.getInstance().getConnection();
        try {
            String sql = "DELETE FROM ORDERS_DETAILS WHERE ID=?";            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, orderDetailId);
            stmt.execute();
        } catch (SQLException ex) {
            return false;
        }
        return true;
	}

	@Override
	public List<OrderDetail> all() {
		 List<OrderDetail> orderDetailList = new ArrayList<>();
	        Connection conn = MySQLDriver.getInstance().getConnection();
	        try {
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery("SELECT * FROM ORDERS_DETAILS");
	            while(rs.next()){
	                int id = rs.getInt("id");
	                String orders_code = rs.getString("orders_code");
	                int productId = rs.getInt("products_id");
	                String productName = rs.getString("Products_name");
	                int quantity = rs.getInt("quantity");
	                orderDetailList.add(new OrderDetail(id, orders_code, productId, productName, quantity));
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(OrderDetailDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return orderDetailList;
	}

	@Override
	public OrderDetail find(int id) {
		 Connection conn = MySQLDriver.getInstance().getConnection();
	        try {
	            String sql = "SELECT * FROM ORDERS_DETAILS WHERE ID=? LIMIT 1";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, id);
	            
	            ResultSet rs = stmt.executeQuery();
	            while(rs.next()){
	                String orders_code = rs.getString("orders_code");
	                int productId = rs.getInt("products_id");
	                String productName = rs.getString("Products_name");
	                int quantity = rs.getInt("quantity");
	                return new OrderDetail(id, orders_code, productId, productName, quantity);
	            }
	        } catch (SQLException ex) {
	            return null;
	        }
	        return null;
	}

	@Override
	public List<OrderDetail> findByProperty(String column, Object value) {
		List<OrderDetail> orderDetailList = new ArrayList<>();
        Connection conn = MySQLDriver.getInstance().getConnection();
        try {
            String sql = "SELECT * FROM ORDERS_DETAILS WHERE ?=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, column);
            stmt.setString(2, value.toString());
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            	int id = rs.getInt("id");
                String orders_code = rs.getString("orders_code");
                int productId = rs.getInt("products_id");
                String productName = rs.getString("Products_name");
                int quantity = rs.getInt("quantity");
                orderDetailList.add(new OrderDetail(id, orders_code, productId, productName, quantity));
            }
        } catch (SQLException ex) {
        	Logger.getLogger(OrderDetailDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderDetailList;
	}

	@Override
	public List<OrderDetail> findByOrderName(String orderCode) {
		 List<OrderDetail> orderDetailList = new ArrayList<>();
	        Connection conn = MySQLDriver.getInstance().getConnection();
	        try {
	            String sql = "SELECT * FROM ORDERS_DETAILS WHERE ORDERS_CODE=?";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, orderCode);
	            ResultSet rs = stmt.executeQuery();
	            while(rs.next()){
	            	int id = rs.getInt("id");
	                String orders_code = rs.getString("orders_code");
	                int productId = rs.getInt("products_id");
	                String productName = rs.getString("Products_name");
	                int quantity = rs.getInt("quantity");
	                orderDetailList.add(new OrderDetail(id, orders_code, productId, productName, quantity));
	            }
	        } catch (SQLException ex) {
	        	Logger.getLogger(OrderDetailDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return orderDetailList;
	}

}
