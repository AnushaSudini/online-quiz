package edu.memphis.quizemon.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProposeInfoDaoJdbc implements ProposeInfoDao{

	@Override
	public ProposeInfo createProposeInfo(int ID, String name, String reason) {
	
		ProposeInfo result = null;
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		String insertTableSQL = "INSERT INTO `propose_info`"
				+ "(`propose_id`,`quizemon_name`,'propose_reason') VALUES"
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
				result = new ProposeInfo (ID, name, reason);
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
	public List<ProposeInfo> selectProposeInfoWithID(int ID) {
		
		List<ProposeInfo> result = new ArrayList<ProposeInfo>();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String selectTABLESQL = "SELECT * FROM `propose_info` where propose_id = ?";
		
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
				result.add(new ProposeInfo(rs.getInt("propose_id"), rs.getString("quizemon_name"), rs.getString("propose_reason")));
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
	public List<Quizemon> selectProposeInfoWithId(int ID) {
		List<Quizemon> result = new ArrayList<Quizemon>();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String selectTABLESQL = "SELECT * FROM `propose_info`, `quizemon` where propose_info.quizemon_name = quizemon.name and propose_id = ?";
		
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
	public List<ProposeInfo> selectProposeInfo() {
		
		List<ProposeInfo> result = new ArrayList<ProposeInfo>();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String selectTABLESQL = "SELECT * FROM `propose_info`";
		
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
				result.add(new ProposeInfo(rs.getInt("propose_id"), rs.getString("quizemon_name"),rs.getString("propose_reason")));
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
	public ArrayList<String> selectReasonsWithProposeId(int ID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<String> selectReasonsWithProposeId(String name) {
		// TODO Auto-generated method stub
		ArrayList<String> result = new ArrayList<String>();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String selectTABLESQL = "SELECT propose_reason FROM `propose_info` where propose_id in (select `propose_id` from `propose` where propose.user_name = ?)";
		
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
				result.add(rs.getString("propose_reason"));
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
	public void deleteProposeInfoWithProposeID(int ID) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String deleteTABLESQL = "DELETE FROM `propose_info` WHERE propose_id=?";
		
		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);
			
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

}
