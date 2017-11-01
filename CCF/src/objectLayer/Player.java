package objectLayer;


public class Player {
	private int id = 0;
	private int rankValue;
	private String fName = null;
	private String lName = null;
	private String username = null;
	private String password = null;
	private String email = null;
	private int type = 0;
	
	public Player(int id, int rankValue, String fName, String lName, String username, String password, String email, int type) {
		this.id = id;
		this.rankValue = rankValue;
		this.fName = fName;
		this.lName = lName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.type = type;
	}
	
	/**
	 * A function which calculates new rank score based on the match that is entered.
	 * This object is the winner, the parameter is the loser, and 32 is our k value
	 * for reference on the methodoligy used, look at https://en.wikipedia.org/wiki/Elo_rating_system#Most_accurate_distribution_model
	 * Our player objects start with a rank of 0
	 * @param player - the player that lost
	 */
	public void wonAgainst(Player player){
		int kValue = 32;
		
		//get the rank values for computation
		int winnerRankValue = this.getRankValue();
		int loserRankValue = player.getRankValue();
		
		double winnerExponent = (double)(loserRankValue - winnerRankValue) / 400.0f;
		double expectedWinner = (1 / (1 + Math.pow(10, winnerExponent)));
		
		
		double loserExponent = (double)(winnerRankValue - loserRankValue) / 400.0f;
		double expectedLoser = (1 / (1 + Math.pow(10, loserExponent)));
		
		
		winnerRankValue = (int)Math.ceil((winnerRankValue + kValue * (1 - expectedWinner)));
		loserRankValue = (int)Math.ceil((loserRankValue + kValue * (0 - expectedLoser)));
		
		//set the player's rank values to the calculated amounts
		this.setRankValue(winnerRankValue);
		player.setRankValue(loserRankValue);
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getRankValue() {
		return this.rankValue;
	}
	
	public void setRankValue(int rankValue) {
		this.rankValue = rankValue;
	}
	
	public String getfName() {
		return this.fName;
	}
	
	public void setfName(String fName) {
		this.fName = fName;
	}
	
	public String getlName() {
		return this.lName;
	}
	
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getType() {
		return this.type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
}
