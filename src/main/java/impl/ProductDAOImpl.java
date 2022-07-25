package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connect.ConnectMySQL;
import dao.ProductDAO;
import db.MySQLDriver;
import model.Product;
import model.User;

public class ProductDAOImpl implements ProductDAO{

	@Override
	public boolean insert(Product product) {
		Connection conn = MySQLDriver.getInstance().getConnection();
	    try {
	        String sql = "INSERT INTO PRODUCTS VALUES(null,?,?,?,?,?)";            
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setString(1, product.getName());
	        stmt.setFloat(2, product.getPrice());
	        stmt.setInt(3, product.getQuantity());
	        stmt.setString(4, product.getImages());
	        stmt.setInt(5, product.getCategories_id());
	         
	        stmt.execute();
	    } catch (SQLException ex) {
	        return false;
	    }
	    return true;
	}

	@Override
	public boolean update(Product product) {
		Connection conn = MySQLDriver.getInstance().getConnection();
	    try {
	        String sql = "UPDATE PRODUCTS SET NAME = ?, PRICE = ?, QUANTITY = ?, IMAGES = ?, categoriesId = ? WHERE ID = ?";            
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setString(1, product.getName());
	        stmt.setFloat(2, product.getPrice());
	        stmt.setInt(3, product.getQuantity());
	        stmt.setString(4, product.getImages());
	        stmt.setInt(5, product.getCategories_id());
	        stmt.setInt(6, product.getId());
	        stmt.execute();
	    } catch (SQLException ex) {
//	    	ex.printStackTrace();
	        return false;
	    }
	    return true;
	}

	@Override
	public boolean delete(int productId) {
		Connection conn = MySQLDriver.getInstance().getConnection();
	    try {
	        String sql = "DELETE FROM PRODUCTS WHERE ID = ?";            
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, productId);
	        
	         
	        stmt.execute();
	    } catch (SQLException ex) {
	        return false;
	    }
	    return true;
	}

	@Override
	public List<Product> all() {
		 List<Product> productList = new ArrayList<>();
	        Connection conn = MySQLDriver.getInstance().getConnection();
	        try {
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUCTS");
	            while(rs.next()){
	                int id = rs.getInt("id");
	                String name = rs.getString("name");
	                float price = rs.getFloat("price");
	                int quantity = rs.getInt("quantity");
	                String images = rs.getString("images");
	                int categoryId = rs.getInt("categoriesId");
	                productList.add(new Product(id, name, price, quantity, images, categoryId));
	            }
	        } catch (SQLException ex) {
//	            List.getLogger(CRUDServlet.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return productList;
	}

	@Override
	public Product find(int id) {
		 Connection conn = MySQLDriver.getInstance().getConnection();
	        try {
	            String sql = "SELECT * FROM PRODUCTS WHERE ID=? LIMIT 1";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, id);
	            
	            ResultSet rs = stmt.executeQuery();
	            while(rs.next()){
	            	String name = rs.getString("name");
	                float price = rs.getFloat("price");
	                int quantity = rs.getInt("quantity");
	                String images = rs.getString("images");
	                int categoryid = rs.getInt("categoriesId");
	                
	                return new Product(id, name, price, quantity, images, categoryid);
	            }
	        } catch (SQLException ex) {
	            return null;
	        }
	        return null;
	}

	@Override
	public List<Product> findByProperty(String column, Object value) {
		List<Product> productList = new ArrayList<>();
        Connection conn = MySQLDriver.getInstance().getConnection();
        try {
        	String sql = "select * from products where id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, column);
			stmt.setString(2, value.toString());
			 ResultSet rs = stmt.executeQuery();
			 while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
                float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                String images = rs.getString("images");
                int categoryId = rs.getInt("categoriesId");
				 
				 productList.add(new Product(id, name, price, quantity, images, categoryId));
			 }
		}catch(SQLException ex) {
			 Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return productList;
	}

	@Override
	public List<Product> findByNameAndCategoryId(String name, int categoryId) {
		List<Product> productList = new ArrayList<>();
        Connection conn = MySQLDriver.getInstance().getConnection();
        try {
           
            String sql = "SELECT * FROM PRODUCTS WHERE categories_id=? AND name LIKE ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, categoryId);
            stmt.setString(2, name);
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            	int id = rs.getInt("id");
                String nameProduct = rs.getString("name");
                float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                String images = rs.getString("images");
                int categoryid = rs.getInt("categoriesId");
	                productList.add(new Product(id, name, price, quantity, images, categoryid));}
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productList;
	}

	@Override
	public List<Product> findByName(String name) {
		List<Product> productList = new ArrayList<>();
        Connection conn = MySQLDriver.getInstance().getConnection();
        try {
           
            String sql = "SELECT * FROM PRODUCTS WHERE name LIKE ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + name + "%");
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            	int id = rs.getInt("id");
                String nameProduct = rs.getString("name");
                float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                String images = rs.getString("images");
                int categoryid = rs.getInt("categoriesId");
                
                productList.add(new Product(id, nameProduct, price, quantity, images, categoryid));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productList;
	}

	@Override
	public List<Product> findByCategoryId(int categoryId) {
	     List<Product> productList = new ArrayList<>();
	        Connection conn = MySQLDriver.getInstance().getConnection();
	        try {
	           
	            String sql = "SELECT * FROM PRODUCTS WHERE categories_id=?";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, categoryId);
	            
	            ResultSet rs = stmt.executeQuery();
	            while(rs.next()){
	            	int id = rs.getInt("id");
	                String nameProduct = rs.getString("name");
	                float price = rs.getFloat("price");
	                int quantity = rs.getInt("quantity");
	                String images = rs.getString("images");
	                int categoryid = rs.getInt("categoriesId");
	                
	                
	                productList.add(new Product(id, nameProduct, price, quantity, images, categoryid));
	                }
	        } catch (SQLException ex) {
	            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return productList;
	}

}
