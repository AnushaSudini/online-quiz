package edu.memphis.quizemon.model;

import java.util.List;

public interface UserQuizemonDao {
	
	public UserQuizemon createUserQuizemon(String user_name, String quizemon_name);
	public void deleteUserQuizemon(String user_name, String quizemon_name);
	public List <Quizemon> selectUserQuizemonWithUserName(String user_name);
	public List <UserQuizemon> selectUserQuizemonWithUserNames(String user_name);
	public List<UserQuizemon> selectUserQuizemonWithQuizmonName(String quizmon_name);
}
