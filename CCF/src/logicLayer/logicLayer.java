package logicLayer;

import java.sql.Connection;
import java.util.List;
import objectLayer.Player;
import persistLayer.*;

public class logicLayer {

	public logicLayer (){
		
	}
	
	public List<Player> getAllPlayers(){
		List<Player> result = null;
		PlayerPersists x = new PlayerPersists();
		result = x.getAllPlayers();
		return result;
	}
}
