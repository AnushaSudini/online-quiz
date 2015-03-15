package edu.memphis.quizemon.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuestionDaoJdbc implements QuestionDao {


	@Override
	public void createQuestion(Question questionObject, Answer answer){
		Question result=null;
		Connection dbConnection=null;
		PreparedStatement preparedStatement=null;
		PreparedStatement preparedStatement1=null;

		ResultSet resultSet=null;
		ResultSet resultSet1=null;
		boolean flag=false;

		String insertQuestion="INSERT INTO `question`"+"(`questionID`,`questionCategory`,`questionContent`,`questionDifficulty`,`questionType`) VALUES"+"(?,?,?,?,?)";


		try
		{
			dbConnection=DriverManager.getConnection(DatabaseConnectionInfo.DB_URL+DatabaseConnectionInfo.DB_NAME,
					DatabaseConnectionInfo.DB_USER,
					DatabaseConnectionInfo.DB_PASSWD);

			preparedStatement = dbConnection.prepareStatement(insertQuestion,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, questionObject.getQuestionId());
			preparedStatement.setString(2, questionObject.getQuestionCategory());
			preparedStatement.setString(3, questionObject.getQuestionContent());
			preparedStatement.setString(4, questionObject.getQuestionDifficulty());
			preparedStatement.setString(5, questionObject.getQuestionType());
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			
			String insertAnswer="INSERT INTO `option_answer`"+"(`questionID`,`option1`,`option2`,`option3`,`option4`,`answer`,`questionType`) VALUES"+"(?,?,?,?,?,?,?)";
			preparedStatement1=dbConnection.prepareStatement(insertAnswer,Statement.RETURN_GENERATED_KEYS);
			preparedStatement1.setInt(1,answer.getQuestionId());
			preparedStatement1.setString(2,answer.getoption1());
			preparedStatement1.setString(3,answer.getoption2());
			preparedStatement1.setString(4,answer.getoption3());
			preparedStatement1.setString(5,answer.getoption4());
			preparedStatement1.setString(6,answer.getanswer());
			preparedStatement1.setString(7,answer.getQuestionType());
			preparedStatement1.executeUpdate();
			
			
			resultSet1 = preparedStatement.getGeneratedKeys();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}


	@Override
	public Question selectQuestionWithID(int questionId) {
		Question result = null;
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String selectTABLESQL = "SELECT * FROM `question` where questionID = ?";
		
		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);
			
			preparedStatement = dbConnection.prepareStatement(selectTABLESQL);
			
			preparedStatement.setInt(1,questionId);

			rs = preparedStatement.executeQuery();
			
			if(rs.next())
			{
				result =new Question(rs.getInt("questionId"), rs.getString("questionCategory"), rs.getString("questionContent"), rs.getString("questionDifficulty"), rs.getString("questionType"));
			}

		} catch (SQLException e) {
			e.printStackTrace();		
			}

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return result;
	
	}

	@Override
	public List<Question> selectAllQuestions() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	@Override
	public int createQuestionId() {
		PreparedStatement prepareStatement=null;
		Connection dbConnection=null;
		ResultSet resultSet=null;
		int questionId = 0;
		String retrieveQuestionId="SELECT max(`questionID`) from `question`";
		try
		{
			dbConnection=DriverManager.getConnection(DatabaseConnectionInfo.DB_URL+DatabaseConnectionInfo.DB_NAME,
					DatabaseConnectionInfo.DB_USER,
					DatabaseConnectionInfo.DB_PASSWD);
			prepareStatement = dbConnection.prepareStatement(retrieveQuestionId);
			resultSet= prepareStatement.executeQuery();

			if(resultSet.next())
			{
				questionId=resultSet.getInt(1);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (prepareStatement != null) {
				try {
					prepareStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return ++questionId;
	}
	
	@Override
	public List<Question> selectTenQuestons(int easyNum,int mediumNum, int hardNum, String topic) {
		List<Question> result = new ArrayList<Question>();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String selectTABLESQL = "(SELECT * FROM `question` WHERE `questionDifficulty` = 'easy' AND `questionCategory` = ? ORDER BY RAND() LIMIT 0,?) "
				+ "union all (SELECT * FROM `question` WHERE `questionDifficulty` = 'medium' AND `questionCategory` = ? ORDER BY RAND() LIMIT 0,?) "
				+ "union all (SELECT * FROM `question` WHERE `questionDifficulty` = 'hard' AND `questionCategory` = ? ORDER BY RAND() LIMIT 0,?)";

		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);
			
			preparedStatement = dbConnection.prepareStatement(selectTABLESQL);
			preparedStatement.setString(1, topic);
			preparedStatement.setInt(2, easyNum);
			preparedStatement.setString(3, topic);
			preparedStatement.setInt(4, mediumNum);
			preparedStatement.setString(5, topic);
			preparedStatement.setInt(6, hardNum);

			
			rs = preparedStatement.executeQuery();
			
			while(rs.next())
			{
				result.add(new Question(rs.getInt("questionId"), rs.getString("questionCategory"), rs.getString("questionContent"), rs.getString("questionDifficulty"),rs.getString("questionType")));
			}
			

		} catch (SQLException e) {
			e.printStackTrace();		
			}

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return result;
		}
	
	@Override
	public Answer selectAnswerWithQuestionId(int questionId) {
		Answer result = null;
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String selectTABLESQL = "SELECT * FROM `option_answer` where questionID = ?";
		
		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);
			
			preparedStatement = dbConnection.prepareStatement(selectTABLESQL);
			
			preparedStatement.setInt(1,questionId);

			rs = preparedStatement.executeQuery();
			
			if(rs.next())
			{
				result =new Answer(rs.getInt("questionId"), rs.getString("option1"), rs.getString("option2"), rs.getString("option3"), rs.getString("option4"), rs.getString("answer"),rs.getString("questionType"));
			}

		} catch (SQLException e) {
			e.printStackTrace();		
			}

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return result;
	}	

	@Override
	public List<Question> selectQuestionsWithCategoryName(String categoryName) {
		List<Question> result = new ArrayList<Question>();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String selectTABLESQL = "(SELECT * FROM `question` WHERE `questionCategory` = ? )";

		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);
			
			preparedStatement = dbConnection.prepareStatement(selectTABLESQL);
			preparedStatement.setString(1, categoryName);
						
			rs = preparedStatement.executeQuery();
			
			while(rs.next())
			{
				result.add(new Question(rs.getInt("questionId"), rs.getString("questionCategory"), rs.getString("questionContent"), rs.getString("questionDifficulty"),rs.getString("questionType")));
			}
			

		} catch (SQLException e) {
			e.printStackTrace();		
			}

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return result;

	}


	@Override
	public void updateQuestion(String qId, String categoryName,
		String questionContent, String difficulty, String type) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		int questionId=Integer.parseInt(qId);
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String updateTableSQL = "UPDATE `question` SET `questionCategory` = ?, `questionContent` = ?, `questionDifficulty` = ?,`questionType` = ? where `questionID` = ?";

		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);


			preparedStatement = dbConnection.prepareStatement(updateTableSQL);

			preparedStatement.setString(1, categoryName);
			preparedStatement.setString(2, questionContent);
			preparedStatement.setString(3, difficulty);
			preparedStatement.setString(4, type);
			preparedStatement.setInt(5, questionId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();		
		}

		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (dbConnection != null) {
			try {
				dbConnection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	
	}


	@Override
	public boolean deleteQuestionWithID(int questionId) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		System.out.println("delete dao");
		String updateTableSQL = "DELETE FROM `question` WHERE `questionID` = ?";

		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);


			preparedStatement = dbConnection.prepareStatement(updateTableSQL);

			preparedStatement.setInt(1, questionId);
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();		
		}

		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (dbConnection != null) {
			try {
				dbConnection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
return true;

	}


	@Override
	public void updateQuestion(Question questionObject, Answer answers) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement1=null;

		
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String updateTableSQL = "UPDATE `question` SET `questionCategory` = ?, `questionContent` = ?, `questionDifficulty` = ?,`questionType` = ? where `questionID` = ?";

		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);
			System.out.println("update dao");
			

			preparedStatement = dbConnection.prepareStatement(updateTableSQL);

			preparedStatement.setString(1, questionObject.getQuestionCategory());
			preparedStatement.setString(2, questionObject.getQuestionContent());
			preparedStatement.setString(3, questionObject.getQuestionDifficulty());
			preparedStatement.setString(4, questionObject.getQuestionType());
			preparedStatement.setInt(5, questionObject.getQuestionId());
			preparedStatement.executeUpdate();
			
			String updateAnswerTable = "UPDATE `option_answer` SET `option1` = ?, `option2` = ?,`option3` = ?,`option4`=?,`answer`=? where `questionID` = ?";
			preparedStatement1 = dbConnection.prepareStatement(updateAnswerTable);
			
			preparedStatement1.setString(1, answers.getoption1());
			preparedStatement1.setString(2, answers.getoption2());
			preparedStatement1.setString(3, answers.getoption3());
			preparedStatement1.setString(4,answers.getoption4());
			preparedStatement1.setString(5,answers.getanswer());
			preparedStatement1.setInt(6, answers.getQuestionId());
			preparedStatement1.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();		
		}

		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (dbConnection != null) {
			try {
				dbConnection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


		
	}


	@Override
	public int countEasy(String name) {
		int easyQue=0;
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String selectEasy = "SELECT count(*) FROM `question` where questionDifficulty = 'easy' and questionCategory= ?";
		
		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);
			
			preparedStatement = dbConnection.prepareStatement(selectEasy);
			
			preparedStatement.setString(1,name);

			rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				easyQue++;
			}
			
			

		} catch (SQLException e) {
			e.printStackTrace();		
			}

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return easyQue;
	}


	@Override
	public int countHard(String name) {
		int hardQue=0;
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String selectHard = "SELECT count(*) FROM `question` where questionDifficulty = 'hard' and questionCategory= ?";
		
		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);
			
			preparedStatement = dbConnection.prepareStatement(selectHard);
			
			preparedStatement.setString(1,name);

			rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				System.out.println("hard question");
				hardQue++;
			}
			
			
			

		} catch (SQLException e) {
			e.printStackTrace();		
			}

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return hardQue;
	}


	@Override
	public int countMedium(String name) {
		int mediumQue=0;
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String selectMedium = "SELECT count(*) FROM `question` where questionDifficulty = 'medium' and questionCategory= ?";
		
		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);
			
			preparedStatement = dbConnection.prepareStatement(selectMedium);
			
			preparedStatement.setString(1,name);

			rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				mediumQue++;
			}
			
			
			

		} catch (SQLException e) {
			e.printStackTrace();		
			}

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return mediumQue;
	}
}


