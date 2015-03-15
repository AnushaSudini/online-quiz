package edu.memphis.quizemon.model;

import java.util.ArrayList;
import java.util.List;

public interface TradeInfoDao {
	
	public TradeInfo createTradeInfo(int ID, String name, String reason);
	
	public List<TradeInfo> selectTradeInfoWithID(int ID);
	
	public List<Quizemon> selectTradeInfoWithId(int Id);
	
	public ArrayList<String> selectReasonsWithId(int id);
	
	public List<TradeInfo> selectTradeInfo();

	public ArrayList<String> selectReasonsWithId(String name);

}
