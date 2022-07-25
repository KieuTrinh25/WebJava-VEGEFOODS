package model;

import java.io.Serializable;

public class OrderDetailSession implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int productId;
	private String images;
    private String productName;
    private int quantity;
    private float price;
    
	public OrderDetailSession() {
		super();
	}

	public OrderDetailSession(int productId,String images, String productName, int quantity, float price) {
		super();
		this.productId = productId;
		this.images = images;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
    
}
