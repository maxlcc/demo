package com.jxust.svsh.model;
import java.io.Serializable;
import java.util.Map;

public class StudentPageSize implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;//学生id
	private String nema;//学生姓名
	private int age; //学生年龄
	private int gender;//学生性别
	private String address;//学生地址
	
	
	
	public StudentPageSize() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentPageSize(int id, String nema, int age, int gender,
			String address) {
		super();
		this.id = id;
		this.nema = nema;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}
	public StudentPageSize(Map<String, Object> map){
		
		this.id = (int)map.get("id");
		this.nema = (String)map.get("nema");
		this.age = (int)map.get("age");
		this.gender = (int)map.get("gender");
		this.address = (String)map.get("address");
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNema() {
		return nema;
	}
	public void setNema(String nema) {
		this.nema = nema;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "StudentPageSize [id=" + id + ", nema=" + nema + ", age=" + age
				+ ", gender=" + gender + ", address=" + address + "]";
	}
	
	

}
