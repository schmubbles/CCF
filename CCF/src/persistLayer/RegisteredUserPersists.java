package persistLayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import objectLayer.RegisteredUser;

public class RegisteredUserPersists {

	public int insertRegisteredUser(RegisteredUser p) {
		String query = "INSERT INTO RegisteredUser (fName, lName, username, password, email, type)"
				+ "VALUES ('" + p.getfName()
				+ "', '" + p.getlName()
				+ "', '" + p.getUsername()
				+ "', '" + p.getPassword()
				+ "', '" + p.getEmail()
				+ "', '" + p.getType()
				+ "')";
			
		
		int ret = DatabaseAccess.create(query);
		
		DatabaseAccess.disconnect();
		
		return ret;
	}
	
	public int deleteRegisteredUser(int id) {
		String query = "DELETE FROM RegisteredUser WHERE id = " + id + ";";
		return DatabaseAccess.delete(query);
	}
	
	/**
	 * get a RegisteredUser based on ID
	 * @param userId the ID of the RegisteredUser
	 * @return RegisteredUser object with id userID
	 */
	public RegisteredUser getRegisteredUser(int userId) {
		String query = "SELECT fName, lName, username, password, email, type FROM RegisteredUser WHERE id = " + userId + ";";
		ResultSet result = DatabaseAccess.retrieve(query);
		RegisteredUser RegisteredUser = null;
		try {
			while (result.next()) {
				RegisteredUser = new RegisteredUser(userId, 			
						result.getString("fName"), 
						result.getString("lName"),
						result.getString("username"),
						result.getString("password"),
						result.getString("email"),
						result.getInt("type")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		DatabaseAccess.disconnect();
		return RegisteredUser;
	}
	
	/**
	 * get a RegisteredUser based on username
	 * @param username is username of the RegisteredUser
	 * @return RegisteredUser object with username username
	 */
	public RegisteredUser getRegisteredUser(String username) {
		String query = "SELECT id, fname, lName, password, email, type FROM RegisteredUser WHERE username = " + username + ";";
		ResultSet result = DatabaseAccess.retrieve(query);
		RegisteredUser RegisteredUser = null;
		try {
			while (result.next()) {
				RegisteredUser = new RegisteredUser(result.getInt("id"), 
						result.getString("fName"), 
						result.getString("lName"),
						username,
						result.getString("password"),
						result.getString("email"),
						result.getInt("type")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		DatabaseAccess.disconnect();
		return RegisteredUser;		
	}
	
	/**
	 * get a list of all RegisteredUsers
	 * @return a list of RegisteredUsers
	 */
	public List<RegisteredUser> getAllRegisteredUsers(){
		String query = "SELECT * FROM RegisteredUser";
		ResultSet result = DatabaseAccess.retrieve(query);
		ArrayList<RegisteredUser> ret = new ArrayList<RegisteredUser>();
		
		try {
			while (result.next()) {
				RegisteredUser RegisteredUser = new RegisteredUser(result.getInt("id"), 
						result.getString("fName"), 
						result.getString("lName"),
						result.getString("username"),
						result.getString("password"),
						result.getString("email"),
						result.getInt("type")
						);
				ret.add(RegisteredUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	/**
	 * Return a RegisteredUserID based on a username
	 * @param username the username of the RegisteredUser we wish to get the id of
	 * @return the RegisteredUser's Id, or -1 if no username matches
	 */
	public int getRegisteredUserId(String username) {
		String query = "SELECT id FROM RegisteredUser WHERE username = " + username + ";";
		ResultSet result = DatabaseAccess.retrieve(query);
		
		int id = -1;
		try {
			while (result.next()) {
				id = result.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
	}
	
	/**
	 * Update a rankValue based on a RegisteredUser's id
	 * @param rankValue the rank value we are to update this RegisteredUser's rankValue to 
	 * @param userId the userId of the RegisteredUser
	 * @return number of rows affected
	 */
	public int updateRankValue(int rankValue, int userId){
		int ret = -1;
		
		String query = "UPDATE RegisteredUser SET rankValue = " + rankValue + " WHERE id = " + userId + ";";
		ret = DatabaseAccess.update(query);
		DatabaseAccess.disconnect();
		
		return ret;
	}
	
	/**
	 * update the first name of a row in the RegisteredUser table
	 * @param fName the new fName to use
	 * @param userId the ID to set fName to
	 * @return number of rows affected
	 */
	public int updateFirstName(String fName, int userId) {
		int ret = -1;
		
		String query = "UPDATE RegisteredUser SET fName = '" + fName + "' WHERE id = " + userId + ";";
		ret = DatabaseAccess.update(query);
		DatabaseAccess.disconnect();
		return ret;
	}

	/**
	 * update the last name of a row in the RegisteredUser table
	 * @param lName the new lName to use
	 * @param userId the ID to set fName to
	 * @return number of rows affected
	 */
	public int updateLastName(String lName, int userId) {
		int ret = -1;
		
		String query = "UPDATE RegisteredUser SET lName = '" + lName + "' WHERE id = " + userId + ";";
		ret = DatabaseAccess.update(query);
		DatabaseAccess.disconnect();
		return ret;		
	}
	
	/**
	 * update the username of a row in the RegisteredUser table
	 * @param username the new username to use
	 * @param userId the ID to set username to
	 * @return the number of rows affected
	 */
	public int updateRegisteredUserUsername(String username, int userId) {
		int ret = -1;
		
		String query = "UPDATE RegisteredUser SET username = '" + username + "' WHERE id = " + userId + ";";
		ret = DatabaseAccess.update(query);
		DatabaseAccess.disconnect();
		return ret;		
	}
	
	/**
	 * Get a RegisteredUser's username based on their ID
	 * @param userId the ID of the user
	 * @return the username of the RegisteredUser
	 */
	public String getRegisteredUserUsername(int userId) {
		String query = "SELECT username FROM RegisteredUser WHERE id = " + userId + ";";
		ResultSet result = DatabaseAccess.retrieve(query);
		String username = null;
		try {
			while (result.next()) {
				username = result.getString("username");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DatabaseAccess.disconnect();
		return username;
	}
	
	public int updateRegisteredUserPassword(String password, int userId) {
		int ret = -1;
		
		String query = "UPDATE RegisteredUser SET password = '" + password + "' WHERE id = " + userId + ";";
		ret = DatabaseAccess.update(query);
		DatabaseAccess.disconnect();
		return ret;		
	}
	
	public String getRegisteredUserPassword(int userId) {
		String query = "SELECT password FROM RegisteredUser WHERE id = " + userId + ";";
		ResultSet result = DatabaseAccess.retrieve(query);
		String password = null;
		try {
			while (result.next()) {
				password = result.getString("password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DatabaseAccess.disconnect();
		return password;
	}
	
	
	public int updateRegisteredUserEmail(String email, int userId) {
		int ret = -1;
		
		String query = "UPDATE RegisteredUser SET email = '" + email + "' WHERE id = " + userId + ";";
		ret = DatabaseAccess.update(query);
		DatabaseAccess.disconnect();
		return ret;	
	}
	
	public String getRegisteredUserEmail(int userId) {
		String query = "SELECT email FROM RegisteredUser WHERE id = " + userId + ";";
		ResultSet result = DatabaseAccess.retrieve(query);
		String email = null;
		try {
			while (result.next()) {
				email = result.getString("email");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DatabaseAccess.disconnect();
		return email;
	}
	
	public int updateRegisteredUserType(int type, int userId) {
		int ret = -1;
		
		String query = "UPDATE RegisteredUser SET type = '" + type + "' WHERE id = " + userId + ";";
		ret = DatabaseAccess.update(query);
		DatabaseAccess.disconnect();
		return ret;	
	}

	public int getRegisteredUserType(int userId) {
		String query = "SELECT type FROM RegisteredUser WHERE id = " + userId + ";";
		ResultSet result = DatabaseAccess.retrieve(query);
		int type = -1;
		try {
			while (result.next()) {
				type = result.getInt("type");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DatabaseAccess.disconnect();
		return type;
	}
	
}
