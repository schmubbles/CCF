package TestCases;

import objectLayer.Player;
import objectLayer.RegisteredUser;
import objectLayer.Tournament;
import objectLayer.Video;
import java.util.Date;
import static org.junit.Assert.*;
public class objectLayerTest {

	public static void main(String[] args) {
		//Testing Player
		Player player1 = new Player(12,15,"Zelda");
		Player player2 = new Player(13,22,"Mario");
		assertEquals("Values match",12,player1.getId());
		assertEquals("Values match",13,player2.getId());
		player1.setId(20);
		assertEquals("Values match",20,player1.getId());
		player1.setRankValue(17);
		assertEquals(17.0,player1.getRankValue(),.01);
		assertEquals("Values match","Zelda",player1.getPlayerTag());
		player1.setPlayerTag("Zelda1");
		assertEquals("Values match","Zelda1",player1.getPlayerTag());
		player1.wonAgainst(player2);
		assertEquals(34,player1.getRankValue(),.01);
		assertEquals(6,player2.getRankValue(),.01);
		player2.wonAgainst(player1);
		assertEquals(17,player1.getRankValue(),.01);
		assertEquals(24,player2.getRankValue(),.01);
		//Testing RegisteredUser
		RegisteredUser user1 = new RegisteredUser(0,"Jack","Polkington","kitty022","stophackingme","kitty@gmail.com",2);
		assertEquals(0,user1.getId());
		assertEquals("Jack",user1.getfName());
		assertEquals("Polkington",user1.getlName());
		assertEquals("kitty022",user1.getUsername());
		assertEquals("stophackingme",user1.getPassword());
		assertEquals("kitty@gmail.com",user1.getEmail());
		assertEquals(2,user1.getType());
		//Testing Tournament
		Date testDate,verifyDate;
		testDate = new Date();
		verifyDate = new Date();
		Tournament firstTournament = new Tournament(123,"asdasd23x393",testDate);
		assertEquals(123,firstTournament.getId());
		firstTournament.setId(222);
		assertEquals(222,firstTournament.getId());
		assertEquals("asdasd23x393",firstTournament.getEmbedCode());
		firstTournament.setEmbedCode("asdhajsd232xcdc");
		assertEquals("asdhajsd232xcdc",firstTournament.getEmbedCode());
		assertEquals(testDate,firstTournament.getDate());
		firstTournament.setDate(verifyDate);
		assertEquals(verifyDate,firstTournament.getDate());
		
		
	}

}
