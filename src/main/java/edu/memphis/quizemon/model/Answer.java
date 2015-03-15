package edu.memphis.quizemon.model;

import java.io.Serializable;

public class Answer implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;
	private int questionId;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String answer;
	private String questionType;
	
	
	
	public Answer(int questionId, String option1, String option2, String option3, String option4, String answer,String questionType) {
		this.questionId=questionId;
		this.option1=option1;
		this.option2=option2;
		this.option3=option3;
		this.option4=option4;
		this.answer=answer;
		this.questionType=questionType;
	}
	
	public int getQuestionId() { return questionId; }
	public String getoption1() { return option1; }
	public String getoption2() { return option2; }
	public String getoption3() { return option3; }
	public String getoption4() { return option4; }
	public String getanswer() { return answer; }
	public String getQuestionType() { return questionType;	}

	public void setQuestionId(int questionId) { this.questionId = questionId; }
	public void setoption1(String option1) { this.option1 = option1; }
	public void setoption2(String option2) { this.option2 = option2; }
	public void setoption3(String option3) { this.option3 = option3; }
	public void setoption4(String option4) { this.option4 = option4; }
	public void setanswer(String answer) { this.answer = answer; }
	public void setQuestionType(String questionType) {	this.questionType = questionType;	}


	public Object clone(){  
		try {
			return super.clone();  
		} catch (Exception e) { 
			return null;
		}
	}
}
