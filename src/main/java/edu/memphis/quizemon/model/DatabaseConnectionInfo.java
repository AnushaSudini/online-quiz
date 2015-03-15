
package edu.memphis.quizemon.model;

public class DatabaseConnectionInfo {

	public final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public final static String DB_URL = "jdbc:mysql://141.225.11.129:3306/";
	public final static String DB_NAME = "troika_dbb";
	public final static String DB_USER = "troika_user";
	public final static String DB_PASSWD = "SAI0nts1";

	private Object driverObject = null;

	private static DatabaseConnectionInfo instance = null;

	/**
	 * Use this method to get the singleton instance of this class.
	 */
	public static DatabaseConnectionInfo getInstance() {
		if (instance == null) {
			instance = new DatabaseConnectionInfo();
		}
		if (instance.driverObject == null) {
			try {
				// The newInstance() call is a work around for some broken Java implementations.
				instance.driverObject = Class.forName(instance.JDBC_DRIVER).newInstance();
			} catch (ClassNotFoundException e) {
				// Couldn't find the driver class.
				// TODO Handle the error.
				e.printStackTrace();
			} catch (Exception e) {
				// Other problems with loading the driver class.
				// TODO Handle the error.
				e.printStackTrace();
			}
		}
		return instance;
	}

	/**
	 * Constructor intentionally private.
	 */
	private DatabaseConnectionInfo() { }

}