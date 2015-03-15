package edu.memphis.quizemon.model;

import java.io.Serializable;

public class TradeInfo implements Cloneable, Serializable{
	
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
    private String reason;	
	public TradeInfo(int id, String name, String reason) {
		this.setID(id);
		this.setQuizemon(name);
		this.reason=reason;
	}
	
	public int getID()
	{
		return this.id;
	}
	
	public String getQuizemon()
	{
		return this.name;
	}
	
	public String getReason()
	{
		return reason;
	}
	public void setID(int id)
	{
		this.id = id;
	}

	public void setQuizemon(String name)
	{
		this.name = name;
	}
	
	public Object clone(){  
		try {
			return super.clone();  
		} catch (Exception e) { 
			return null;
		}
	}
}
