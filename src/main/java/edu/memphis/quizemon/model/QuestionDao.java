package edu.memphis.quizemon.model;

import java.util.List;

public interface QuestionDao {
	
	public Question selectQuestionWithID(int id);

	public List<Question> selectAllQuestions();

	public int createQuestionId();

	public void createQuestion(Question questionObject, Answer answer);

	public List<Question> selectTenQuestons(int easyNum, int mediumNum, int hardNum, String topic);

	public Answer selectAnswerWithQuestionId(int questionId);

	public List<Question> selectQuestionsWithCategoryName(String categoryName);

	public void updateQuestion(String questionId, String categoryName,
			String questionContent, String difficulty, String type);

	public boolean deleteQuestionWithID(int questionId);

	public void updateQuestion(Question questionObject, Answer answers);
	
	public int countEasy(String name);
	
	public int countHard(String name);

	public int countMedium(String string);

}
