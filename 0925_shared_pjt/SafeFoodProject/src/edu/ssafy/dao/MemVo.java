package edu.ssafy.dao;

public class MemVo {
	private String id;
	private String password;
	private String name;
	private String address;
	private String phone;
	private String allergy;
	
	
	public MemVo(String id, String password, String name, String address, String phone, String allergy) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.allergy = allergy;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAllergy() {
		return allergy;
	}
	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}
	
	
	@Override
	public String toString() {
		return "MemVo [id=" + id + ", password=" + password + ", name=" + name + ", address=" + address + ", phone="
				+ phone + ", allergy=" + allergy + "]";
	}
	


	
	
}
