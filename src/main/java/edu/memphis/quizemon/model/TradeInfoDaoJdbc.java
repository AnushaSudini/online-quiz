package edu.memphis.quizemon.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TradeInfoDaoJdbc implements TradeInfoDao {

	@Override
	public TradeInfo createTradeInfo(int ID, String name, String reason) {
		
		TradeInfo result = null;
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		String insertTableSQL = "INSERT INTO `trade_info`"
				+ "(`trade_id`,`quizemon_name`,`trade_reason`) VALUES"
				+ "(?,?,?)";

		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);

			preparedStatement = dbConnection.prepareStatement(insertTableSQL, 
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setInt(1, ID);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, reason);

			// execute insert SQL statement
			preparedStatement.executeUpdate();

			generatedKeys = preparedStatement.getGeneratedKeys();
			if (generatedKeys.next()) {
				result = new TradeInfo (ID, name,reason);
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
	public List<TradeInfo> selectTradeInfo() {
		
		List<TradeInfo> result = new ArrayList<TradeInfo>();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String selectTABLESQL = "SELECT * FROM `trade_info`";
		
		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);
			
			preparedStatement = dbConnection.prepareStatement(selectTABLESQL);
			
			//preparedStatement.setInt(1,ID);

			rs = preparedStatement.executeQuery();
			
			while(rs.next())
			{
				result.add(new TradeInfo(rs.getInt("trade_id"), rs.getString("quizemon_name"), rs.getString("trade_reason")));
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
public List<TradeInfo> selectTradeInfoWithID(int ID) {
	
	List<TradeInfo> result = new ArrayList<TradeInfo>();
	Connection dbConnection = null;
	PreparedStatement preparedStatement = null;
	ResultSet rs = null;
	DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
	
	String selectTABLESQL = "SELECT * FROM `trade_info` where trade_id = ?";
	
	try {
		dbConnection = DriverManager.getConnection(
				dbInfo.DB_URL+dbInfo.DB_NAME,
				dbInfo.DB_USER,
				dbInfo.DB_PASSWD);
		
		preparedStatement = dbConnection.prepareStatement(selectTABLESQL);
		
		preparedStatement.setInt(1,ID);

		rs = preparedStatement.executeQuery();
		
		while(rs.next())
		{
			result.add(new TradeInfo(rs.getInt("trade_id"), rs.getString("quizemon_name"), rs.getString("trade_reason")));
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
public List<Quizemon> selectTradeInfoWithId(int Id) {
	List<Quizemon> result = new ArrayList<Quizemon>();
	Connection dbConnection = null;
	PreparedStatement preparedStatement = null;
	ResultSet rs = null;
	DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
	
	String selectTABLESQL = "SELECT * FROM `trade_info`, `quizemon` where trade_info.quizemon_name = quizemon.name and trade_id = ?";
	
	try {
		dbConnection = DriverManager.getConnection(
				dbInfo.DB_URL+dbInfo.DB_NAME,
				dbInfo.DB_USER,
				dbInfo.DB_PASSWD);
		
		preparedStatement = dbConnection.prepareStatement(selectTABLESQL);
		
		preparedStatement.setInt(1,Id);

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
public ArrayList<String> selectReasonsWithId(String name) {
	// TODO Auto-generated method stub
	ArrayList<String> result = new ArrayList<String>();
	Connection dbConnection = null;
	PreparedStatement preparedStatement = null;
	ResultSet rs = null;
	DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
	
	String selectTABLESQL = "SELECT trade_reason FROM `trade_info` where trade_id in (select `trade_id` from `trade` where trade.user_name = ?)";
	
	try {
		dbConnection = DriverManager.getConnection(
				dbInfo.DB_URL+dbInfo.DB_NAME,
				dbInfo.DB_USER,
				dbInfo.DB_PASSWD);
		
		preparedStatement = dbConnection.prepareStatement(selectTABLESQL);
		
		preparedStatement.setString(1,name);

		rs = preparedStatement.executeQuery();
		
		while(rs.next())
		{
			result.add(rs.getString("trade_reason"));
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
		System.out.println("rbvbvkbvbfvf:"+result.get(0));
		return result;
}

@Override
public ArrayList<String> selectReasonsWithId(int id) {
	// TODO Auto-generated method stub
	return null;
}

public void deleteTradewithID(int intValue) {
	// TODO Auto-generated method stub
	Connection dbConnection = null;
	PreparedStatement preparedStatement = null;
	DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
	
	String deleteTABLESQL = "DELETE FROM `trade_info`" + "WHERE trade_id=?";
	
	try {
		dbConnection = DriverManager.getConnection(
				dbInfo.DB_URL+dbInfo.DB_NAME,
				dbInfo.DB_USER,
				dbInfo.DB_PASSWD);
		System.out.println("Delete Query: "+deleteTABLESQL);
		preparedStatement = dbConnection.prepareStatement(deleteTABLESQL);
		preparedStatement.setInt(1, intValue);
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







}

