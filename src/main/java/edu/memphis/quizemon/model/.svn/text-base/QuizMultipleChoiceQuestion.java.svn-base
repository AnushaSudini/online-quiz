package edu.memphis.quizemon.model;
import java.io.Serializable;
import java.util.List;

public class QuizMultipleChoiceQuestion implements Cloneable, Serializable{
	private static final long serialVersionUID = 1L;
	private Question question;
	private Answer Answers;
	
	public QuizMultipleChoiceQuestion(Question question, Answer Answers) {
		this.question=question;
		this.Answers = Answers;
	}

	public Question getQuestion() { return question; }
	public Answer getAnswers() { return Answers; }

	public void setQuestion(Question question) { this.question = question; }
	public void setAnswers(Answer Answers) { this.Answers = Answers; }
	
	public Object clone(){  
		try {
			return super.clone();  
		} catch (Exception e) { 
			return null;
		}
	}
}
