package persistLayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import objectLayer.Player;
import objectLayer.Tournament;

public class TournamentPersists {
	
	public int insertTournament(Tournament t){
		String query = "INSERT INTO Tournament (Date, EmbedCode)" 
				+ "VALUES ('" + t.getDate()
				+ "', '" + t.getEmbedCode()
				+ "')";
		int ret = DatabaseAccess.create(query);
		
		DatabaseAccess.disconnect();
		
		return ret;
	}
	
	public int deleteTournament(int id){
		String query = "DELETE FROM Tournament WHERE id = " + id + ";";
		return DatabaseAccess.delete(query);
	}
	
	public Tournament getTournament(int id) {
		Tournament t = null;
		return t;
	}
	
	public Tournament getTournament(String tournamentName) {
		String query = "SELECT id, Date, EmbedCode";
		ResultSet result = DatabaseAccess.retrieve(query);
		Tournament tournament = null;
		try {
			while (result.next()) {
				tournament = new Tournament(result.getInt("id"),
						result.getString("EmbedCode"),
						result.getDate("Date")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseAccess.disconnect();
		return tournament;
	}
}
