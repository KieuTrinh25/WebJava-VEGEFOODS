package model;

public class Product {

	private int id;
	private String name;
	private float price;
	private int quantity;
	private String images;
	private int categories_id;
	
	public Product(int id, String name, float price, int quantity, String images, int categories_id) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.images = images;
		this.categories_id = categories_id;
	}

	public Product() {
		super();
	}

	public Product(String name, float price, int quantity, String images, int categories_id) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.images = images;
		this.categories_id = categories_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public int getCategories_id() {
		return categories_id;
	}

	public void setCategories_id(int categories_id) {
		this.categories_id = categories_id;
	}
	
	
}
