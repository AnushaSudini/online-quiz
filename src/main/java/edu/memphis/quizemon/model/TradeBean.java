package edu.memphis.quizemon.model;

import java.io.Serializable;
import java.util.List;


//create the fist time, but not the most efficient way. Change to another version, But some one used the old version, so leave it here.
public class TradeBean implements Cloneable, Serializable{
	
	private static final long serialVersionUID = 1L;

	private int id;
	private String user;               
	private List <Quizemon> userQuizemon;
	
	public TradeBean(int id, String user, List<Quizemon> userQuizemon) {
		this.setID(id);
		this.setUser(user);
		this.setQuizemon(userQuizemon);
	}
	
	public int getID()
	{
		return this.id;
	}
	
	public String getUser()
	{
		return this.user;
	}
	
	public List<Quizemon> getQuizemon()
	{
		return this.userQuizemon;
	}
	
	public void setID(int id)
	{
		this.id = id;
	}

	public void setUser(String user)
	{
		this.user = user;
	}
	
	public void setQuizemon(List <Quizemon> userQuizemon)
	{
		this.userQuizemon = userQuizemon;
	}
	
	public Object clone(){  
		try {
			return super.clone();  
		} catch (Exception e) { 
			return null;
		}
	}
}
