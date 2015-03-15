package edu.memphis.quizemon.model;

import java.io.Serializable;
import java.util.List;

public class ProposeBean implements Cloneable, Serializable{
	
	private static final long serialVersionUID = 1L;

	private int Propose_id;
	private String user;
	private int trade_id;
	private List<Quizemon> ProposeQuizemon;
	
	public ProposeBean(int Propose_id, String user, int trade_id, List<Quizemon> ProposeQuizemon) {
		this.setProposeID(Propose_id);
		this.setUser(user);
		this.setTradeID(trade_id);
		this.setProposeQuizemon(ProposeQuizemon);
	}
	
	public int getProposeID()
	{
		return this.Propose_id;
	}
	
	public String getUser()
	{
		return this.user;
	}
	
	public int getTradeID()
	{
		return this.trade_id;
	}
	
	public List<Quizemon> getProposeQuizemon()
	{
		return this.ProposeQuizemon;
	}
	
	public void setProposeID(int Propose_id)
	{
		this.Propose_id = Propose_id;
	}

	public void setUser(String user)
	{
		this.user = user;
	}
	
	public void setTradeID(int trade_id)
	{
		this.trade_id = trade_id;
	}
	
	public void setProposeQuizemon(List <Quizemon> ProposeQuizemon)
	{
		this.ProposeQuizemon = ProposeQuizemon;
	}
	
	public Object clone(){  
		try {
			return super.clone();  
		} catch (Exception e) { 
			return null;
		}
	}
}
