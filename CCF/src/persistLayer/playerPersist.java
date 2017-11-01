package persistLayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import objectLayer.Player;


public class playerPersist {

	public int insertPlayer(Player p) {
		String query = "INSERT INTO player (rankValue, fName, lName, username, password, email, type)"
				+ "VALUES ('" + p.getRankValue()
				+ "', '" + p.getfName()
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
	
	public int deletePlayer(int id) {
		String query = "DELETE FROM player WHERE id = " + id + ";";
		return DatabaseAccess.delete(query);
	}
	
	/**
	 * get a player based on ID
	 * @param userId the ID of the player
	 * @return Player object with id userID
	 */
	public Player getPlayer(int userId) {
		String query = "SELECT fName, lName, username, password, email, type FROM player WHERE id = " + userId + ";";
		ResultSet result = DatabaseAccess.retrieve(query);
		Player Player = null;
		try {
			while (result.next()) {
				Player = new Player(userId, 
						result.getInt("rankValue"),
//TODO rankValue shouldn't be a double
						
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
		return Player;
	}
	
	/**
	 * get a player based on username
	 * @param username is username of the player
	 * @return Player object with username username
	 */
	public Player getPlayer(String username) {
		String query = "SELECT id, fname, lName, password, email, type FROM player WHERE username = " + username + ";";
		ResultSet result = DatabaseAccess.retrieve(query);
		Player Player = null;
		try {
			while (result.next()) {
				Player = new Player(result.getInt("id"), 
						result.getInt("rankValue"),
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
		return Player;		
	}
	
	/**
	 * get a list of all players
	 * @return a list of players
	 */
	public List<Player> getAllPlayers(){
		String query = "SELECT * FROM player";
		ResultSet result = DatabaseAccess.retrieve(query);
		ArrayList<Player> ret = new ArrayList<Player>();
		
		try {
			while (result.next()) {
				Player player = new Player(result.getInt("id"), 
						result.getInt("rankValue"),
						result.getString("fName"), 
						result.getString("lName"),
						result.getString("username"),
						result.getString("password"),
						result.getString("email"),
						result.getInt("type")
						);
				ret.add(player);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	/**
	 * Return a playerID based on a username
	 * @param username the username of the player we wish to get the id of
	 * @return the player's Id, or -1 if no username matches
	 */
	public int getPlayerId(String username) {
		String query = "SELECT id FROM player WHERE username = " + username + ";";
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
	 * Update a rankValue based on a Player's id
	 * @param rankValue the rank value we are to update this player's rankValue to 
	 * @param userId the userId of the Player
	 * @return number of rows affected
	 */
	public int updateRankValue(int rankValue, int userId){
		int ret = -1;
		
		String query = "UPDATE player SET rankValue = " + rankValue + " WHERE id = " + userId + ";";
		ret = DatabaseAccess.update(query);
		DatabaseAccess.disconnect();
		
		return ret;
	}
	
	/**
	 * update the first name of a row in the player table
	 * @param fName the new fName to use
	 * @param userId the ID to set fName to
	 * @return number of rows affected
	 */
	public int updateFirstName(String fName, int userId) {
		int ret = -1;
		
		String query = "UPDATE player SET fName = '" + fName + "' WHERE id = " + userId + ";";
		ret = DatabaseAccess.update(query);
		DatabaseAccess.disconnect();
		return ret;
	}

	/**
	 * update the last name of a row in the player table
	 * @param lName the new lName to use
	 * @param userId the ID to set fName to
	 * @return number of rows affected
	 */
	public int updateLastName(String lName, int userId) {
		int ret = -1;
		
		String query = "UPDATE player SET lName = '" + lName + "' WHERE id = " + userId + ";";
		ret = DatabaseAccess.update(query);
		DatabaseAccess.disconnect();
		return ret;		
	}
	
	/**
	 * update the username of a row in the player table
	 * @param username the new username to use
	 * @param userId the ID to set username to
	 * @return the number of rows affected
	 */
	public int updatePlayerUsername(String username, int userId) {
		int ret = -1;
		
		String query = "UPDATE player SET username = '" + username + "' WHERE id = " + userId + ";";
		ret = DatabaseAccess.update(query);
		DatabaseAccess.disconnect();
		return ret;		
	}
	
	/**
	 * Get a player's username based on their ID
	 * @param userId the ID of the user
	 * @return the username of the player
	 */
	public String getPlayerUsername(int userId) {
		String query = "SELECT username FROM player WHERE id = " + userId + ";";
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
	
	public int updatePlayerPassword(String password, int userId) {
		int ret = -1;
		
		String query = "UPDATE player SET password = '" + password + "' WHERE id = " + userId + ";";
		ret = DatabaseAccess.update(query);
		DatabaseAccess.disconnect();
		return ret;		
	}
	
	public String getPlayerPassword(int userId) {
		String query = "SELECT password FROM player WHERE id = " + userId + ";";
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
	
	
	public int updatePlayerEmail(String email, int userId) {
		int ret = -1;
		
		String query = "UPDATE player SET email = '" + email + "' WHERE id = " + userId + ";";
		ret = DatabaseAccess.update(query);
		DatabaseAccess.disconnect();
		return ret;	
	}
	
	public String getPlayerEmail(int userId) {
		String query = "SELECT email FROM player WHERE id = " + userId + ";";
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
	
	public int updatePlayerType(int type, int userId) {
		int ret = -1;
		
		String query = "UPDATE player SET type = '" + type + "' WHERE id = " + userId + ";";
		ret = DatabaseAccess.update(query);
		DatabaseAccess.disconnect();
		return ret;	
	}

	public int getPlayerType(int userId) {
		String query = "SELECT type FROM player WHERE id = " + userId + ";";
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
