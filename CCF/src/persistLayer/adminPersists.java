package persistLayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import objectLayer.Admin;


public class adminPersists {

	public int insertAdmin(Admin a) {
		String query = "INSERT INTO admin (fName, lName, username, password, email, type)"
				+ "VALUES ('" + a.getfName()
				+ "', '" + a.getlName()
				+ "', '" + a.getUsername()
				+ "', '" + a.getPassword()
				+ "', '" + a.getEmail()
				+ "', '" + a.getType()
				+ "')";
		
		int ret = DatabaseAccess.create(query);
		
		DatabaseAccess.disconnect();
		
		return ret;
	}
	
	
	public int deleteAdmin(int id) {
		String query = "DELETE FROM admin WHERE id = " + id + ";";
		return DatabaseAccess.delete(query);
	}
	
	public int deleteAdmin(String username) {
		String query = "DELETE FROM admin WHERE username = " + username + ";";
		return DatabaseAccess.delete(query);		
	}
	
	public Admin getAdmin(int userId) {
		String query = "SELECT fName, lName, username, password, email, type";
		ResultSet result = DatabaseAccess.retrieve(query);
		Admin Admin = null;
		try {
			while (result.next()) {
				Admin = new Admin(userId, 
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
		return Admin;
	}
	

	public Admin getAdmin(String username) {
		String query = "SELECT id, fName, lName, username, password, email, type";
		ResultSet result = DatabaseAccess.retrieve(query);
		Admin Admin = null;
		try {
			while (result.next()) {
				Admin = new Admin(result.getInt("id"), 
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
		return Admin;
	}
	
	public List<Admin> getAllAdmins(){
		String query = "SELECT * FROM admin";
		ResultSet result = DatabaseAccess.retrieve(query);
		ArrayList<Admin> ret = new ArrayList<Admin>();
		
		try {
			while (result.next()) {
				Admin Admin = new Admin(result.getInt("id"),
						result.getString("fName"),
						result.getString("lName"),
						result.getString("username"),
						result.getString("password"),
						result.getString("email"),
						result.getInt("type")
						);
				ret.add(Admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return ret;
	}
	
	/**
	 * Get a AdminID based on their username 
	 * @param username the username of the admin
	 * @return the id paired with the specified username
	 */
	public int getAdminId(String username) {
		String query = "SELECT id FROM admin WHERE username = " + username + ";";
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
	
}






























