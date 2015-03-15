package edu.memphis.quizemon.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.memphis.quizemon.model.DatabaseConnectionInfo;

public class QuizCategoryDaoJdbc implements QuizCategoryDao{
	@Override
	public Category createCategory(String name, String description) {
		Category result=null;
		Connection dbConnection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		String status="inactive";
		String insertCategory="INSERT INTO `category`"+"(`categoryName`,`description`,`status`) VALUES"+"(?,?,?)";
		try
		{
			dbConnection=DriverManager.getConnection(DatabaseConnectionInfo.DB_URL+DatabaseConnectionInfo.DB_NAME,
					DatabaseConnectionInfo.DB_USER,
					DatabaseConnectionInfo.DB_PASSWD);
			preparedStatement = dbConnection.prepareStatement(insertCategory,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, description);
			preparedStatement.setString(3, status);
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				result = new Category(name, description,status);
			}

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
		return result;
	}

	@Override
	public Category selectCategoryWithName(String name) {

		Category result = null;
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		ResultSet rs = null;

		String selectTABLESQL = "SELECT * FROM `category` WHERE `categoryName`=?";

		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);

			preparedStatement = dbConnection.prepareStatement(selectTABLESQL);
			preparedStatement.setString(1, name);
			rs = preparedStatement.executeQuery();

			while(rs.next()) {
				result = new Category(rs.getString("categoryName"), rs.getString("description"),rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		return result;
	}

	@Override
	public List<Category> selectAllCategories() {

		List<Category> result = new ArrayList<Category>();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();

		String selectTABLESQL = "SELECT * FROM `category`";

		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);

			preparedStatement = dbConnection.prepareStatement(selectTABLESQL);

			resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{

				result.add(new Category(resultSet.getString("categoryName"), resultSet.getString("description"),resultSet.getString("status")));

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
	public List<Category> selectActiveCategories() {

		List<Category> result = new ArrayList<Category>();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();

		String selectTABLESQL = "SELECT * FROM `category` where status='active'";

		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);

			preparedStatement = dbConnection.prepareStatement(selectTABLESQL);

			resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{

				result.add(new Category(resultSet.getString("categoryName"), resultSet.getString("description"),resultSet.getString("status")));

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
	public boolean deactivateCategory(String name) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();

		String updateTableSQL = "UPDATE `category` SET `status`= ? where `categoryName` = ?";

		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);


			preparedStatement = dbConnection.prepareStatement(updateTableSQL);

			preparedStatement.setString(1, "inactive");
			preparedStatement.setString(2, name);

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
	public void updateCategory(String oldName, String name, String description) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		System.out.println("update dao");
		String updateTableSQL = "UPDATE `category` SET `categoryName` = ?, `description` = ? where `categoryName` = ?";

		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);


			preparedStatement = dbConnection.prepareStatement(updateTableSQL);

			preparedStatement.setString(1, name);
			preparedStatement.setString(2, description);
			preparedStatement.setString(3, oldName);
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
	public void deleteCategory(String name){
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();

		String deleteTABLESQL = "DELETE FROM `category`" + "WHERE categoryName=?";

		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);

			preparedStatement = dbConnection.prepareStatement(deleteTABLESQL);
			preparedStatement.setString(1, name);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
	public boolean activateCategory(String name) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();

		String updateTableSQL = "UPDATE `category` SET `status`= ? where `categoryName` = ?";

		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);


			preparedStatement = dbConnection.prepareStatement(updateTableSQL);

			preparedStatement.setString(1, "active");
			preparedStatement.setString(2, name);

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

}


