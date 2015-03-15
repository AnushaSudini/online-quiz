package edu.memphis.quizemon.model;

public class UserCoin {
	private String user_name;
	private int coin;
	
	UserCoin(String user_name, int coin)
	{
		this.setUser(user_name);
		this.setCoin(coin);
	}
	
	public void setUser(String user_name)
	{
		this.user_name = user_name;
	}
	
	public void setCoin(int coin)
	{
		this.coin = coin;
	}
	
	public String getUser()
	{
		return this.user_name;
	}
	
	public int getCoin()
	{
		return this.coin;
	}
}

