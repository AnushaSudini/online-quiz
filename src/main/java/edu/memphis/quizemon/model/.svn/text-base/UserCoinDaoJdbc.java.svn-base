package edu.memphis.quizemon.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserCoinDaoJdbc implements UserCoinDao{

	@Override
	public UserCoin createUserCoin(String user_name, int coin) {
		UserCoin result = null;
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		String insertTableSQL = "INSERT INTO `user_coin`"
				+ "(`user_name`,`coin`) VALUES"
				+ "(?,?)";

		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);

			preparedStatement = dbConnection.prepareStatement(insertTableSQL, 
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, user_name);
			preparedStatement.setInt(2, coin);

			// execute insert SQL statement
			preparedStatement.executeUpdate();

			generatedKeys = preparedStatement.getGeneratedKeys();
			if (generatedKeys.next()) {
				result = new UserCoin (user_name, coin);
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
	public void updateUserCoin(String user_name, int coin) {
		
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String updateTableSQL = "UPDATE `user_coin` SET `coin` = ? where `user_name` = ?";
		
		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);
			
			preparedStatement = dbConnection.prepareStatement(updateTableSQL);
			
			preparedStatement.setInt(1,coin);
			preparedStatement.setString(2,user_name);

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
	public int selectUserCoinWithName(String user_name) {
		int result = 0;
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String selectTABLESQL = "SELECT `coin` FROM `user_coin` where user_name = ?";
		
		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);
			
			preparedStatement = dbConnection.prepareStatement(selectTABLESQL);
			
			preparedStatement.setString(1,user_name);

			rs = preparedStatement.executeQuery();
			
			if(rs.next())
			{
				result = rs.getInt("coin");
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
