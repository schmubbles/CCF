package objectLayer;

//A class to represent a player that is kept track of in the rankings
public class Player {
	private int id = 0;
	private double rankValue;
	private String playerTag;
	
	public Player(int id, double rankValue, String playerTag) {
		this.id = id;
		this.rankValue = rankValue;
		this.playerTag = playerTag;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int newId) {
		this.id = newId;
	}
	
	public double getRankValue() {
		return this.rankValue;
	}
	
	public void setRankValue(double rankValue) {
		this.rankValue = rankValue;
	}
	
	public String getPlayerTag() {
		return this.playerTag;
	}
	
	public void setPlayerTag(String newTag) {
		this.playerTag = newTag;
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
		double winnerRankValue = this.getRankValue();
		double loserRankValue = player.getRankValue();
		
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
	
}
