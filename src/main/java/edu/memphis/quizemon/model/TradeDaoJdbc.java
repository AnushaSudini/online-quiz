package edu.memphis.quizemon.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TradeDaoJdbc implements TradeDao {

	@Override
    public Trade createTrade (String user)
	{
		System.out.println("CREATE TRADEEE::: "+user);
		Trade result = null;
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		String insertTableSQL = "INSERT INTO `trade`"
				+ "(`user_name`) VALUES" 
				+ "(?)";

		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);

			preparedStatement = dbConnection.prepareStatement(insertTableSQL, 
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, user);

			preparedStatement.executeUpdate();

			generatedKeys = preparedStatement.getGeneratedKeys();
			if (generatedKeys.next()) {
				result = new Trade (generatedKeys.getInt(1), user);
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
	public Trade selectTradewithID (int ID)
	{
		Trade result = null;
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String selectTABLESQL = "SELECT * FROM `trade` WHERE trade_id = ?";
		
		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);
			
			preparedStatement = dbConnection.prepareStatement(selectTABLESQL);
			preparedStatement.setInt(1,ID);
			rs = preparedStatement.executeQuery();
			if(rs.next()){
				result = new Trade(rs.getInt("trade_id"), rs.getString("user_name"));
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
	public List<Trade> selectTradewithUser(String user)
	{
		List<Trade> result = new ArrayList<Trade>();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String selectTABLESQL = "SELECT * FROM `trade` where user_name = ?";
		
		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);
			
			preparedStatement = dbConnection.prepareStatement(selectTABLESQL);
			
			preparedStatement.setString(1,user);
			//preparedStatement.setString(2, quizemon_name);

			rs = preparedStatement.executeQuery();
			
			while(rs.next())
			{
				result.add(new Trade(rs.getInt("trade_id"), rs.getString("user_name")));
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
	public void deleteTradewithID (int ID)
	{
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String deleteTABLESQL = "DELETE FROM `trade`" + "WHERE trade_id=?";
		
		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);
			System.out.println("Delete Query: "+deleteTABLESQL);
			preparedStatement = dbConnection.prepareStatement(deleteTABLESQL);
			preparedStatement.setInt(1, ID);
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
	public List<TradeBean> selectTradeWithUser(String user) {
		List<TradeBean> result = new ArrayList<TradeBean>();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String selectTABLESQL = "SELECT * FROM `trade` where user_name = ?";
		
		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);
			
			preparedStatement = dbConnection.prepareStatement(selectTABLESQL);
			
			preparedStatement.setString(1,user);
			//preparedStatement.setString(2, quizemon_name);

			rs = preparedStatement.executeQuery();
			
			while(rs.next())
			{
				int trade_id = rs.getInt("trade_id");
				TradeInfoDao tiDao = new TradeInfoDaoJdbc();
				List<Quizemon> quizemon = tiDao.selectTradeInfoWithId(trade_id);
				ArrayList<String> reasons = new ArrayList<String>();
				reasons=tiDao.selectReasonsWithId(trade_id);
				result.add(new TradeBean(rs.getInt("trade_id"), rs.getString("user_name"), quizemon));
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
	public TradeBean selectTradeWithId(int trade_id) {
		TradeBean result = null;
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String selectTABLESQL = "SELECT * FROM `trade` where trade_id = ?";
		
		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);
			
			preparedStatement = dbConnection.prepareStatement(selectTABLESQL);
			
			preparedStatement.setInt(1,trade_id);
			//preparedStatement.setString(2, quizemon_name);

			rs = preparedStatement.executeQuery();
			
			while(rs.next())
			{
				//int trade_id = rs.getInt("trade_id");
				TradeInfoDao tiDao = new TradeInfoDaoJdbc();
				List<Quizemon> quizemon = tiDao.selectTradeInfoWithId(trade_id);
				result  = new TradeBean(trade_id, rs.getString("user_name"), quizemon);
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
