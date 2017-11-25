package objectLayer;

import java.sql.Date;

public class Tournament {
	private int id = 0;
	private String tournamentName = null;
	private int numParticipants;
	private Player[] participants;
	private Date date;
	
	public Tournament(int id, String tournamentName, int numParticipants, Player[] participants, Date date) {
		this.id = id;
		this.tournamentName = tournamentName;
		this.numParticipants = numParticipants;
		this.participants = participants;
		this.date = date;
	}
	
	public Tournament(int id, String tournamentName, int numParticipants, Date date) {
		this.id = id;
		this.tournamentName = tournamentName;
		this.numParticipants = numParticipants;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTournamentName() {
		return tournamentName;
	}
	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}
	public int getNumParticipants() {
		return numParticipants;
	}
	public void setNumParticipants(int numParticipants) {
		this.numParticipants = numParticipants;
	}
	public Player[] getParticipants() {
		return participants;
	}
	public void setParticipants(Player[] participants) {
		this.participants = participants;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
