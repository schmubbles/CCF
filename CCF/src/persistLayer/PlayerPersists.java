package persistLayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import objectLayer.Player;


public class PlayerPersists {

	public int insertPlayer(Player p) {
		String query = "INSERT INTO Player (RankValue, PlayerTag)"
				+ "VALUES ('" + p.getRankValue()
				+ "', '" + p.getPlayerTag()
				+ "')";
			
		
		int ret = DatabaseAccess.create(query);
		
		DatabaseAccess.disconnect();
		
		return ret;
	}
	
	public int deletePlayer(int id) {
		String query = "DELETE FROM Player WHERE id = " + id + ";";
		return DatabaseAccess.delete(query);
	}
	
	/**
	 * get a Player based on ID
	 * @param userId the ID of the Player
	 * @return Player object with id userID
	 */
	public Player getPlayer(int userId) {
		String query = "SELECT RankValue, PlayerTag FROM Player WHERE id = " + userId + ";";
		ResultSet result = DatabaseAccess.retrieve(query);
		Player Player = null;
		try {
			while (result.next()) {
				Player = new Player(userId, 
						result.getDouble("RankValue"),
						result.getString("PlayerTag")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		DatabaseAccess.disconnect();
		return Player;
	}
	
	/**
	 * get a Player based on PlayerTag
	 * @param playerTag is PlayerTag of the Player
	 * @return Player object with PlayerTag playerTag
	 */
	public Player getPlayer(String playerTag) {
		String query = "SELECT id, RankValue FROM Player WHERE username = " + playerTag + ";";
		ResultSet result = DatabaseAccess.retrieve(query);
		Player Player = null;
		try {
			while (result.next()) {
				Player = new Player(result.getInt("id"), 
						result.getDouble("RankValue"),
						playerTag
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		DatabaseAccess.disconnect();
		return Player;		
	}
	
	/**
	 * get a list of all Players
	 * @return a list of Players
	 */
	public List<Player> getAllPlayers(){
		String query = "SELECT * FROM Player";
		ResultSet result = DatabaseAccess.retrieve(query);
		ArrayList<Player> ret = new ArrayList<Player>();
		
		try {
			while (result.next()) {
				Player Player = new Player(result.getInt("id"), 
						result.getDouble("RankValue"),
						result.getString("PlayerTag") 
						);
				ret.add(Player);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	/**
	 * Return a PlayerID based on a PlayerTag
	 * @param playerTag the PlayerTag of the Player we wish to get the id of
	 * @return the Player's Id, or -1 if no PlayerTag matches
	 */
	public int getPlayerId(String playerTag) {
		String query = "SELECT id FROM Player WHERE PlayerTag = " + playerTag + ";";
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
	 * @param rankValue the rank value we are to update this Player's rankValue to 
	 * @param userId the userId of the Player
	 * @return number of rows affected
	 */
	public int updateRankValue(int rankValue, int userId){
		int ret = -1;
		
		String query = "UPDATE Player SET RankValue = " + rankValue + " WHERE id = " + userId + ";";
		ret = DatabaseAccess.update(query);
		DatabaseAccess.disconnect();
		
		return ret;
	}
		
	/**
	 * update the PlayerTag of a row in the Player table
	 * @param playerTag the new PlayerTag to use
	 * @param userId the ID to set playerTag to
	 * @return the number of rows affected
	 */
	public int updatePlayerTag(String playerTag, int userId) {
		int ret = -1;
		
		String query = "UPDATE Player SET PlayerTag = '" + playerTag + "' WHERE id = " + userId + ";";
		ret = DatabaseAccess.update(query);
		DatabaseAccess.disconnect();
		return ret;		
	}
	
	/**
	 * Get a Player's PlayerTag based on their ID
	 * @param userId the ID of the user
	 * @return the PlayerTag of the Player
	 */
	public String getPlayerTag(int userId) {
		String query = "SELECT PlayerTag FROM Player WHERE id = " + userId + ";";
		ResultSet result = DatabaseAccess.retrieve(query);
		String PlayerTag = null;
		try {
			while (result.next()) {
				PlayerTag = result.getString("username");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DatabaseAccess.disconnect();
		return PlayerTag;
	}
		
	
}
