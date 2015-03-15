package edu.memphis.quizemon.model;

import java.util.List;

public interface ProposeDao {
	
	public Propose createPropose(String user, int trade_id);
	
	public Propose selectProposeWithProposeID(int propose_id);
	
	public List<Propose> selectProposeWithTradeID(int trade_id);
	
	public List<Propose> selectProposeWithUser(String user);
	
	public List<ProposeBean> selectProposeWithTradeId(int trade_id);
	
	public List<ProposeBean> selectProposeWithUserName(String userName);
		
	public void deleteProposeWithProposeID(int propose_id);
	
	public List <Quizemon> acceptProposeWithProposeID(int propose_id);
}
