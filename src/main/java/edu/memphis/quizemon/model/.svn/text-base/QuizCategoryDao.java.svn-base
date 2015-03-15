package edu.memphis.quizemon.model;

import java.util.List;


public interface QuizCategoryDao {

	public Category createCategory(String name, String description);

	public Category selectCategoryWithName(String name);

	public List<Category> selectAllCategories();

	public void updateCategory(String categoryName, String name, String description);

	public void deleteCategory(String name);

	public List<Category>  selectActiveCategories();

	public boolean deactivateCategory(String name);
	
	public boolean activateCategory(String name);
	

	
}
