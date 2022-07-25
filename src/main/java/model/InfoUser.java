package model;

public class InfoUser {
	private int id;
	private String full_name;
	private String address;
	private String note;
	private int users_id;
	public InfoUser(int id, String full_name, String address, String note, int users_id) {
		super();
		this.id = id;
		this.full_name = full_name;
		this.address = address;
		this.note = note;
		this.users_id = users_id;
	}
	public InfoUser(String full_name, String address, String note, int users_id) {
		super();
		this.full_name = full_name;
		this.address = address;
		this.note = note;
		this.users_id = users_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getUsers_id() {
		return users_id;
	}
	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}
	
}
