package edu.memphis.quizemon.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

public interface QuizemonDao {

	public Quizemon createQuizemon(String name, int price, String rareness, int weight, String specialpower, InputStream image);
	
	public Quizemon selectQuizemonWithName(String name);
	
	public void updateQuizemon(String originname, String name, int price, String rareness, int weight, String specialpower, InputStream image);
	
	public void deleteQuizemon(String name);

	public List<Quizemon> selectAllQuizemon();

	public List<Quizemon> selectTenQuizemon();

	public byte[] getImage(String imageId) throws Exception;


}
