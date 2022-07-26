package model;

import java.util.Date;

public class Order {
	public static String PENDING_STATUS = "pending";
    public static String FINISHED_STATUS = "finished";
    public static String BOOM_STATUS = "boom";
    public static int CODE_LENGHT = 8;
    
	private int id;
	private String name;
	private String description;
	private String status;
	private int users_id;
	public Order(int id, String name, String description, String status, int users_id) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.status = status;
		this.users_id = users_id;
	}
	
	public Order(String name, String description, String status, int users_id) {
		super();
		this.name = name;
		this.description = description;
		this.status = status;
		this.users_id = users_id;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getUsers_id() {
		return users_id;
	}
	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}


}
