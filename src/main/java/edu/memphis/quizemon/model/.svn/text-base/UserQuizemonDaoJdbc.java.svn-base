package edu.memphis.quizemon.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserQuizemonDaoJdbc implements UserQuizemonDao{

	@Override
	public UserQuizemon createUserQuizemon(String user_name,
			String quizemon_name) {
		UserQuizemon result = null;
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		String insertTableSQL = "INSERT INTO `user_quizemon`"
				+ "(`user_name`,`quizemon`) VALUES"
				+ "(?,?)";

		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);

			preparedStatement = dbConnection.prepareStatement(insertTableSQL, 
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, user_name);
			preparedStatement.setString(2, quizemon_name);

			// execute insert SQL statement
			preparedStatement.executeUpdate();

			generatedKeys = preparedStatement.getGeneratedKeys();
			if (generatedKeys.next()) {
				result = new UserQuizemon (user_name, quizemon_name);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (generatedKeys != null) {
				try {
					generatedKeys.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	@Override
	public void deleteUserQuizemon(String user_name, String quizemon_name) {
		ResultSet result = null;
		Connection dbConnection = null;
		PreparedStatement preparedStatementDelete = null;
		PreparedStatement preparedStatementCount = null;
		PreparedStatement preparedStatementInsert = null;

		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String deleteTABLESQL = "DELETE FROM `user_quizemon`" + "WHERE user_name=? and quizemon = ?";
		String selectTABLESQL = "SELECT * FROM `user_quizemon` WHERE user_name = ? and quizemon = ?";
		String insertTABLESQL = "INSERT INTO `user_quizemon` VALUES(?,?)";
		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);
			//get count
			preparedStatementCount = dbConnection.prepareStatement(selectTABLESQL);
			preparedStatementCount.setString(1, user_name);
			preparedStatementCount.setString(2, quizemon_name);
			result = preparedStatementCount.executeQuery();
			int count = 0;
			while(result.next())
			{
				count++;
			}
			
			preparedStatementDelete = dbConnection.prepareStatement(deleteTABLESQL);
			preparedStatementDelete.setString(1, user_name);
			preparedStatementDelete.setString(2, quizemon_name);

			preparedStatementDelete.executeUpdate();
			
			preparedStatementInsert = dbConnection.prepareStatement(insertTABLESQL);
			preparedStatementInsert.setString(1, user_name);
			preparedStatementInsert.setString(2, quizemon_name);
			
			for(int i=0;i<count-1;i++)
			{
				preparedStatementInsert.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();		
			}

			if (preparedStatementInsert != null) {
				try {
					preparedStatementInsert.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			}
			if (preparedStatementDelete != null) {
				try {
					preparedStatementInsert.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (preparedStatementCount != null) {
				try {
					preparedStatementCount.close();
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
	public List<Quizemon> selectUserQuizemonWithUserName(String user_name) {
		
		List<Quizemon> result = new ArrayList<Quizemon>();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		//joint sql
		String selectTABLESQL = "SELECT * FROM `quizemon`, `user_quizemon` WHERE quizemon.name = user_quizemon.quizemon and user_quizemon.user_name = ?";
		
		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);
			
			preparedStatement = dbConnection.prepareStatement(selectTABLESQL);
			preparedStatement.setString(1, user_name);

			rs = preparedStatement.executeQuery();
			
			while(rs.next())
			{
				result.add(new Quizemon(rs.getString("quizemon.name"), rs.getInt("price"), rs.getString("rareness"), rs.getInt("weight"), rs.getString("specialpower"), rs.getBinaryStream("image")));
				
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
	public List<UserQuizemon> selectUserQuizemonWithUserNames(String user_name) {
		
		List<UserQuizemon> result = new ArrayList<UserQuizemon>();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String selectTABLESQL = "SELECT * FROM `user_quizemon` where user_name = ?";
		
		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);
			
			preparedStatement = dbConnection.prepareStatement(selectTABLESQL);
			preparedStatement.setString(1, user_name);

			rs = preparedStatement.executeQuery();
			
			while(rs.next())
			{
				result.add(new UserQuizemon(rs.getString("user_name"), rs.getString("quizemon")));
				
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
	public List<UserQuizemon> selectUserQuizemonWithQuizmonName(
			String quizmon_name) {
		List<UserQuizemon> result = new ArrayList<UserQuizemon>();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String selectTABLESQL = "SELECT * FROM `user_quizemon` where quizemon = ?";
		
		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);
			
			preparedStatement = dbConnection.prepareStatement(selectTABLESQL);
			preparedStatement.setString(1, quizmon_name);

			rs = preparedStatement.executeQuery();
			
			while(rs.next())
			{
				result.add(new UserQuizemon(rs.getString("user_name"), rs.getString("quizemon")));
				
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


}
