package edu.memphis.quizemon.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProposeDaoJdbc implements ProposeDao {

	@Override
	public Propose createPropose(String user, int trade_id) {
		
		Propose result = null;
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		String insertTableSQL = "INSERT INTO `propose`"
				+ "(`user_name`, `trade_id`) VALUES"
				+ "(?,?)";

		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);

			preparedStatement = dbConnection.prepareStatement(insertTableSQL, 
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, user);
			preparedStatement.setInt(2, trade_id);


			preparedStatement.executeUpdate();

			generatedKeys = preparedStatement.getGeneratedKeys();
			if (generatedKeys.next()) {
				result = new Propose (generatedKeys.getInt(1), user, trade_id);
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
	
	
	
public Propose createProposeInfo(int id, String name, String reason) {
		
		Propose result = null;
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		String insertTableSQL = "INSERT INTO `propose_info`"
				+ "(`propose_id`,`quizemon_name`,`propose_reason`) VALUES"
				+ "(?,?,?)";
		String insertTableSQL1 = "INSERT INTO `propose`"
				+ "(`user_name`, `trade_id`) VALUES"
				+ "(?,?)";

		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);

			preparedStatement = dbConnection.prepareStatement(insertTableSQL, 
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, reason);
System.out.println("Im here rey");
			preparedStatement.executeUpdate();

			//generatedKeys = preparedStatement.getGeneratedKeys();
			//if (generatedKeys.next()) {
			//	result = new Propose (generatedKeys.getInt(1), user, trade_id);
			//}
			
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
	public Propose selectProposeWithProposeID(int propose_id) {
		
		Propose result = null;
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String selectTABLESQL = "SELECT * FROM `propose` WHERE propose_id = ?";
		
		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);
			
			preparedStatement = dbConnection.prepareStatement(selectTABLESQL);
			preparedStatement.setInt(1,propose_id);
			rs = preparedStatement.executeQuery();
			if(rs.next()){
				result = new Propose(rs.getInt("propose_id"), rs.getString("user_name"),rs.getInt("trade_id"));
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
	public List<Propose> selectProposeWithTradeID(int trade_id) {
		
		List<Propose> result = new ArrayList<Propose>();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String selectTABLESQL = "SELECT * FROM `propose` where trade_id = ?";
		
		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);
			
			preparedStatement = dbConnection.prepareStatement(selectTABLESQL);
			
			preparedStatement.setInt(1,trade_id);

			rs = preparedStatement.executeQuery();
			
			while(rs.next())
			{
				result.add(new Propose(rs.getInt("propose_id"), rs.getString("user_name"),rs.getInt("trade_id")));
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
	public List<Propose> selectProposeWithUser(String user) {
		
		List<Propose> result = new ArrayList<Propose>();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String selectTABLESQL = "SELECT * FROM `propose` where user_name = ?";
		
		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);
			
			preparedStatement = dbConnection.prepareStatement(selectTABLESQL);
			
			preparedStatement.setString(1,user);

			rs = preparedStatement.executeQuery();
			
			while(rs.next())
			{
				result.add(new Propose(rs.getInt("propose_id"), rs.getString("user_name"),rs.getInt("trade_id")));
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
	public void deleteProposeWithProposeID(int propose_id) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String deleteTABLESQL = "DELETE FROM `propose` WHERE propose_id=?";
		
		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);
			
			preparedStatement = dbConnection.prepareStatement(deleteTABLESQL);
			preparedStatement.setInt(1, propose_id);
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
	public List<ProposeBean> selectProposeWithTradeId(int trade_id) {
		List<ProposeBean> result = new ArrayList<ProposeBean>();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String selectTABLESQL = "SELECT propose_id, user_name FROM `propose` where trade_id = ?";
		
		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);
			
			preparedStatement = dbConnection.prepareStatement(selectTABLESQL);
			
			preparedStatement.setInt(1,trade_id);

			rs = preparedStatement.executeQuery();
			
			
			while(rs.next())
			{
				int propose_id = rs.getInt("propose_id");
				
				ProposeInfoDao piDao = new ProposeInfoDaoJdbc();
				List <Quizemon> ProposeQuizemon = piDao.selectProposeInfoWithId(propose_id);
				
				result.add(new ProposeBean(propose_id, rs.getString("user_name"), trade_id, ProposeQuizemon));
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
	public List <Quizemon> acceptProposeWithProposeID(int propose_id) {
		List<Quizemon> quizemonPropose = new ArrayList<Quizemon>();
		ProposeInfoDao dao = new ProposeInfoDaoJdbc();
		quizemonPropose = dao.selectProposeInfoWithId(propose_id);
		ProposeDao pDao = new ProposeDaoJdbc();

		Propose propose = pDao.selectProposeWithProposeID(propose_id);
		//get ProposeUser
		String usernamePropose = propose.getUser();
		//get TradeId
		int trade_id = propose.getTradeID();
		//get TradeUser
		TradeDao tDao = new TradeDaoJdbc();
		TradeBean trade = tDao.selectTradeWithId(trade_id);
		String usernameTrade = trade.getUser();
		
		List<Quizemon> quizemonTrade = trade.getQuizemon();

		UserQuizemonDao uqDao = new UserQuizemonDaoJdbc();
		for(Quizemon q: quizemonTrade)
		{
			uqDao.createUserQuizemon(usernamePropose, q.getName());
			uqDao.deleteUserQuizemon(usernameTrade, q.getName());
		}
		
		for(Quizemon qq: quizemonPropose)
		{
			uqDao.createUserQuizemon(usernameTrade, qq.getName());
			uqDao.deleteUserQuizemon(usernamePropose, qq.getName());
		}
				
		tDao.deleteTradewithID(trade_id);
		
		return quizemonPropose;
	}

	@Override
	public List<ProposeBean> selectProposeWithUserName(String username) {
		List<ProposeBean> result = new ArrayList<ProposeBean>();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String selectTABLESQL = "SELECT propose_id, user_name, trade_id FROM `propose` where user_name = ?";
		
		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);
			
			preparedStatement = dbConnection.prepareStatement(selectTABLESQL);
			
			preparedStatement.setString(1,username);

			rs = preparedStatement.executeQuery();
			
			
			while(rs.next())
			{
				int propose_id = rs.getInt("propose_id");
				
				ProposeInfoDao piDao = new ProposeInfoDaoJdbc();
				List <Quizemon> ProposeQuizemon = piDao.selectProposeInfoWithId(propose_id);
				
				result.add(new ProposeBean(propose_id, rs.getString("user_name"), rs.getInt("trade_id"), ProposeQuizemon));
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
