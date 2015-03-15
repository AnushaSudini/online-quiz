package edu.memphis.quizemon.model;

import java.io.Serializable;

public class Propose implements Cloneable, Serializable{
	
	private static final long serialVersionUID = 1L;

	private int propose_id;
	private String user;
	private int trade_id;
	
	public Propose(int propose_id, String user, int trade_id) {
		this.setProposeID(propose_id);
		this.setUser(user);
		this.setTradeID(trade_id);
	}
	
	public int getProposeID()
	{
		return this.propose_id;
	}
	
	public String getUser()
	{
		return this.user;
	}
	
	public int getTradeID()
	{
		return this.trade_id;
	}
	
	public void setProposeID(int propose_id)
	{
		this.propose_id = propose_id;
	}

	public void setUser(String user)
	{
		this.user = user;
	}
	
	public void setTradeID(int trade_id)
	{
		this.trade_id = trade_id;
	}
	
	public Object clone(){  
		try {
			return super.clone();  
		} catch (Exception e) { 
			return null;
		}
	}
}
