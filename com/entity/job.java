package com.entity;

public class job {
     private int id;
     private String title;
     private String description;
     private String catergory;
     private String location;
     private String pdate;
	public job() {
		super();
		// TODO Auto-generated constructor stub
	}
	public job(String title, String description, String catergory, String location, String pdate) {
		super();
		this.title = title;
		this.description = description;
		this.catergory = catergory;
		this.location = location;
		this.pdate = pdate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCatergory() {
		return catergory;
	}
	public void setCatergory(String catergory) {
		this.catergory = catergory;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
     
     
}
