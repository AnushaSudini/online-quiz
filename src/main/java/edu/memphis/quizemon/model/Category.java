package edu.memphis.quizemon.model;
import java.io.Serializable;


public class Category implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String description;
	private String status;
	
	public Category(String name, String description,String status) {
		this.setName(name);
		this.setDescription(description);
		this.setStatus(status);
	}

	public String getName() { return name; }
	public String getDescription() { return description; }
	
	public void setName(String name) { this.name = name; }
	public void setDescription(String description) { this.description = description; }
	
	public Object clone(){  
		try {
			return super.clone();  
		} catch (Exception e) { 
			return null;
		}
	}


}
