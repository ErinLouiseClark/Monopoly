import java.util.*;
import java.io.*;

public class Player {

	private String name;
	private int money;
	private int playerPosition; 
	private boolean getOutOfJailFreeCard = false;


	static ArrayList<Player> players = new ArrayList<Player>();
	static ArrayList playerOwnership = new ArrayList();


	public Player(String n, int m, int p, boolean g){
		name = n;
		money = m;
		playerPosition = p;
		getOutOfJailFreeCard = g;
	}
	
	public boolean isGetOutOfJailFreeCard() {
		return getOutOfJailFreeCard;
	}


	public void setGetOutOfJailFreeCard(boolean getOutOfJailFreeCard) {
		this.getOutOfJailFreeCard = getOutOfJailFreeCard;
	}


	public static ArrayList getPlayerOwnership() {
		return playerOwnership;
	}


	public static void setPlayerOwnership(ArrayList playerOwnership) {
		Player.playerOwnership = playerOwnership;
	}


	public int getPlayerPosition() {
		return playerPosition;
	}


	public void setPlayerPosition(int playerPosition) {
		this.playerPosition = playerPosition;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}


	public ArrayList<Player> getPlayers() {
		return players;
	}


	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	
}
