package persistLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DatabaseAccess {
	protected static Connection connection = null;
	protected static Statement statement = null;
	protected static PreparedStatement preparedStatement = null;
	protected static ResultSet result = null;
	
	
	/**
	 * Starts a connection to the database based on the static final strings in DatabaseAccessConfiguration
	 * @return the connection object used to create queries
	 */
	public static Connection connect() {
		try {
			Class.forName(DatabaseAccessConfiguration.DB_DRIVE_NAME);
			connection = DriverManager.getConnection(DatabaseAccessConfiguration.DB_CONNECTION_URL, DatabaseAccessConfiguration.DB_CONNECTION_USERNAME, DatabaseAccessConfiguration.DB_CONNECTION_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} // try-catch
		
		return connection;
	}
	
	/**
	 * Close a connection to the database
	 */
	public static void disconnect() {
		try {
			if (connection != null) {
				connection.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (result != null) {
				result.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}//try catch
	}
	
	/**
	 *	Retrieves results from database based on query
	 * @param query SQL select query
	 * @return the result set
	 */
	public static ResultSet retrieve (String query) {
		ResultSet result = null;
		try {
			connection = connect();
			
			Statement statement = connection.createStatement();
			result = statement.executeQuery(query);
		} catch (SQLException e){
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Adds an item to the database
	 * @param query SQL insert query
	 * @return the number of rows affected
	 */
	public static int create (String query) {
		int rows = 0;
		try {
			connection = connect();
			preparedStatement = connection.prepareStatement(query);
			rows = preparedStatement.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return rows;
	}
	
	/**
	 * Updates an item in the database
	 * @param query an SQL replace or update statement
	 * @return the number of rows affected
	 */
	public static int update (String query) {
		int rows = 0;
		
		try {
			connection = connect();
			preparedStatement = connection.prepareStatement(query);
			rows = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return rows;
	}
	
	/**
	 * Deletes an item from the database
	 * @param query an SQL delete statement
	 * @return the amount of rows affected
	 */
	public static int delete (String query) {
		int rows = 0;
		
		try {
			connection = connect();
			preparedStatement = connection.prepareStatement(query);
			rows = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return rows;
	}
	
	
}




























