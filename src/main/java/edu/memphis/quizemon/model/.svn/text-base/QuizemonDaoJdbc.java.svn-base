package edu.memphis.quizemon.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.commons.io.output.ByteArrayOutputStream;

import edu.memphis.quizemon.model.DatabaseConnectionInfo;
import edu.memphis.quizemon.model.Quizemon;

public class QuizemonDaoJdbc implements QuizemonDao {

	@Override
	public Quizemon createQuizemon(String name, int price, String rareness,
			int weight, String specialpower, InputStream image) {
		Quizemon result = null;
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		String insertTableSQL = "INSERT INTO `quizemon`"
				+ "(`name`, `price`, `rareness`, `weight`, `specialpower`, `image`) VALUES"
				+ "(?,?,?,?,?,?)";
//		InputStream imageStream = ImageUtil.getImageByte(image); 
		
		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);
 
			preparedStatement = dbConnection.prepareStatement(insertTableSQL, 
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, price);
			preparedStatement.setString(3, rareness);
			preparedStatement.setInt(4, weight);
			preparedStatement.setString(5, specialpower);
			preparedStatement.setBinaryStream(6, image);

			// execute insert SQL statement
			preparedStatement.executeUpdate();

			generatedKeys = preparedStatement.getGeneratedKeys();
			if (generatedKeys.next()) {
				result = new Quizemon( name, price,
						rareness, weight, specialpower, image);
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
	public Quizemon selectQuizemonWithName(String name) {
		Quizemon result = null;
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String selectTABLESQL = "SELECT * FROM `quizemon` where name = ?";
		
		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);
			
			preparedStatement = dbConnection.prepareStatement(selectTABLESQL);
			
			preparedStatement.setString(1,name);

			rs = preparedStatement.executeQuery();
			
			if(rs.next())
			{
				result =new Quizemon(name, rs.getInt("price"), rs.getString("rareness"), rs.getInt("weight"), rs.getString("specialpower"), rs.getBinaryStream("image"));
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
	public void updateQuizemon(String originname, String name, int price, String rareness,
			int weight, String specialpower, InputStream image){
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();	
//		String updateTableSQL = "UPDATE `quizemon` SET `price` = ?, `rareness` = ?, `weight` = ?, `specialpower` = ?, `image` = ?  where `name` = ?";
//		String deleteTABLESQL = "DELETE FROM `quizemon` where name = ?";
		if (image != null){
			System.out.println("delete");
			deleteQuizemon(originname);
			System.out.println("insert begin");
			System.out.println("insert end");
			Quizemon quizmon = createQuizemon(name, price, rareness,
				 weight, specialpower, image);
			System.out.println("insert success");
		} else {
			System.out.println("not delete");
			String updateTableSQL = "UPDATE `quizemon` SET `price` = ?, `rareness` = ?, `weight` = ?, `specialpower` = ?, `name` = ?  where `name` = ?";
			try {
				dbConnection = DriverManager.getConnection(
						dbInfo.DB_URL+dbInfo.DB_NAME,
						dbInfo.DB_USER,
						dbInfo.DB_PASSWD);
				
				preparedStatement = dbConnection.prepareStatement(updateTableSQL);
				preparedStatement.setInt(1, price);
				preparedStatement.setString(2, rareness);
				preparedStatement.setInt(3, weight);
				preparedStatement.setString(4, specialpower);
				preparedStatement.setString(5, name);
				preparedStatement.setString(6, originname);
				preparedStatement.executeUpdate();
			}	catch (SQLException e) {
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

	@Override
	public void deleteQuizemon(String name) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String deleteTABLESQL = "DELETE FROM `quizemon` where name = ?";
		
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
	public List<Quizemon> selectAllQuizemon() {
		List<Quizemon> result = new ArrayList<Quizemon>();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String selectTABLESQL = "SELECT * FROM `quizemon`";
		
		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);
			
			preparedStatement = dbConnection.prepareStatement(selectTABLESQL);
			
			rs = preparedStatement.executeQuery();
			
			while(rs.next())
			{
				result.add(new Quizemon(rs.getString("name"), rs.getInt("price"), rs.getString("rareness"), rs.getInt("weight"), rs.getString("specialpower"), rs.getBinaryStream("image")));
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
	public List<Quizemon> selectTenQuizemon() {
		List<Quizemon> result = new ArrayList<Quizemon>();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
		
		String selectTABLESQL = "(SELECT * FROM `quizemon` WHERE rareness = 'Common' ORDER BY RAND() LIMIT 0,6) "
				+ "union all (SELECT * FROM `quizemon` WHERE rareness = 'Medium' ORDER BY RAND() LIMIT 0,3) "
				+ "union all (SELECT * FROM `quizemon` WHERE rareness = 'Rare' ORDER BY RAND() LIMIT 0,1)";

		try {
			dbConnection = DriverManager.getConnection(
					dbInfo.DB_URL+dbInfo.DB_NAME,
					dbInfo.DB_USER,
					dbInfo.DB_PASSWD);
			
			preparedStatement = dbConnection.prepareStatement(selectTABLESQL);
			
			rs = preparedStatement.executeQuery();
			
			while(rs.next())
			{
				result.add(new Quizemon(rs.getString("name"), rs.getInt("price"), rs.getString("rareness"), rs.getInt("weight"), rs.getString("specialpower"), rs.getBinaryStream("image")));
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
	public byte[] getImage(String imageId) throws Exception {
		
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			InputStream binaryStream = null;
			byte[] result = null;
			DatabaseConnectionInfo dbInfo = DatabaseConnectionInfo.getInstance();
			String selectTABLESQL = "SELECT * FROM `quizemon` where name = ?";
			
			try {									
				connection = DriverManager.getConnection(
						dbInfo.DB_URL+dbInfo.DB_NAME,
						dbInfo.DB_USER,
						dbInfo.DB_PASSWD);
				preparedStatement = connection.prepareStatement(selectTABLESQL);
				preparedStatement.setString(1,imageId);
				
				resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {
					binaryStream = resultSet.getBinaryStream("image");
					ByteArrayOutputStream bos = new ByteArrayOutputStream();
					int next = binaryStream.read();
					while (next > -1) {
					    bos.write(next);
					    next = binaryStream.read();
					}
					bos.flush();
					result = bos.toByteArray();


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

				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			return result;
		}
}
