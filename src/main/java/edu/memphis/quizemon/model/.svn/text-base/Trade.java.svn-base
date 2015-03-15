package edu.memphis.quizemon.model;

import java.io.Serializable;


//create the fist time, but not the most efficient way. Change to another version, But some one used the old version, so leave it here.
public class Trade implements Cloneable, Serializable{
	
	private static final long serialVersionUID = 1L;

	private int id;
	private String user;               
	
	public Trade(int id, String user) {
		this.setID(id);
		this.setUser(user);
	}
	
	public int getID()
	{
		return this.id;
	}
	
	public String getUser()
	{
		return this.user;
	}
	
	public void setID(int id)
	{
		this.id = id;
	}

	public void setUser(String user)
	{
		this.user = user;
	}
	
	
	
	public Object clone(){  
		try {
			return super.clone();  
		} catch (Exception e) { 
			return null;
		}
	}
}
