package edu.memphis.quizemon.model;
import java.io.Serializable;


public class Question implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;
	private int questionId;
	private String questionCategory;
	private String questionContent;
	private String questionDifficulty;
	private String questionType;

	public Question(int questionId,String questionCategory, String questionContent,String questionDifficulty,String questionType) {
		this.questionId=questionId;
		this.questionCategory=questionCategory;
		this.questionContent=questionContent;
		this.questionDifficulty=questionDifficulty;
		this.questionType=questionType;
	}


	public int getQuestionId() {
		return questionId;
	}


	public String getQuestionType() {
		return questionType;
	}


	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}


	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}


	public String getQuestionCategory() {
		return questionCategory;
	}


	public void setQuestionCategory(String questionCategory) {
		this.questionCategory = questionCategory;
	}


	public String getQuestionContent() {
		return questionContent;
	}


	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}


	public String getQuestionDifficulty() {
		return questionDifficulty;
	}


	public void setQuestionDifficulty(String questionDifficulty) {
		this.questionDifficulty = questionDifficulty;
	}


	public Object clone(){  
		try {
			return super.clone();  
		} catch (Exception e) { 
			return null;
		}
	}


}
