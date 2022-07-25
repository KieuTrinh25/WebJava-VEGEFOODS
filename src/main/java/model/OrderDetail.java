package model;

public class OrderDetail {
	private int id;
	private String orders_code;
	private int products_id;
	private String products_name;
	private int quantity;
	public OrderDetail(int id, String orders_code, int products_id, String products_name, int quantity) {
		super();
		this.id = id;
		this.orders_code = orders_code;
		this.products_id = products_id;
		this.products_name = products_name;
		this.quantity = quantity;
	}
	public OrderDetail(String orders_code, int products_id, String products_name, int quantity) {
		super();
		this.orders_code = orders_code;
		this.products_id = products_id;
		this.products_name = products_name;
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrders_code() {
		return orders_code;
	}
	public void setOrders_code(String orders_code) {
		this.orders_code = orders_code;
	}
	public int getProducts_id() {
		return products_id;
	}
	public void setProducts_id(int products_id) {
		this.products_id = products_id;
	}
	public String getProducts_name() {
		return products_name;
	}
	public void setProducts_name(String products_name) {
		this.products_name = products_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
