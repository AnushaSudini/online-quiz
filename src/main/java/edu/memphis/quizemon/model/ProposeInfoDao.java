package edu.memphis.quizemon.model;

import java.util.ArrayList;
import java.util.List;

public interface ProposeInfoDao {

	public ProposeInfo createProposeInfo(int ID, String name, String reason);
	
	public List<ProposeInfo> selectProposeInfoWithID(int ID);
	
	public List<Quizemon> selectProposeInfoWithId(int ID);

	public List<ProposeInfo> selectProposeInfo();

	public ArrayList<String> selectReasonsWithProposeId(int ID);

	public List<String> selectReasonsWithProposeId(String name);

	public void deleteProposeInfoWithProposeID(int ID);

	
	
	
}
