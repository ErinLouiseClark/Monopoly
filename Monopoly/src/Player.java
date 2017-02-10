import java.util.*;
import java.io.*;

public class Player {

	private String name;
	private int money;
	private int playerPosition;


	static ArrayList<Player> players = new ArrayList<Player>();
	static ArrayList playerOwnership = new ArrayList();
	
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


	public Player(String n, int m, int p){
		name = n;
		money = m;
		playerPosition = p;
	}
	
	public int getPlayerPosition() {
		return playerPosition;
	}


	public void setPlayerPosition(int playerPosition) {
		this.playerPosition = playerPosition;
	}
	
	
	
}
