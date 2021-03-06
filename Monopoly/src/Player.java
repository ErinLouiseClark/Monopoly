import java.util.*;
import java.io.*;

public class Player {

	private String name;
	private int money;
	private int playerPosition; 
	private boolean getOutOfJailFreeCard = false;
	private ArrayList<Property> ownedProperties;
	private boolean jailTime = false;


	static ArrayList<Player> players = new ArrayList<Player>();
	static ArrayList playerOwnership = new ArrayList();


	public Player(String n, int m, int p, boolean g, ArrayList<Property> o, boolean j){
		name = n;
		money = m;
		playerPosition = p;
		getOutOfJailFreeCard = g;
		ownedProperties = o;
		jailTime = j;
	}
	
	public boolean isJailTime() {
		return jailTime;
	}

	public void setJailTime(boolean jailTime) {
		this.jailTime = jailTime;
	}

	public ArrayList<Property> getOwnedProperties() {
		return ownedProperties;
	}

	public void setOwnedProperties(ArrayList<Property> ownedProperties) {
		this.ownedProperties = ownedProperties;
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
