import java.util.*;
import java.io.*;

public class Player {

	private String name;
	private int money;
	private int playerPosition;


	static ArrayList<Player> players = new ArrayList<Player>();
	
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
	
	
	public static void chooseOrder(){
		int a = MonopolyRunner.rollDice();
		System.out.println("You rolled a " + a + ".");
		int b = MonopolyRunner.rollDice();
		System.out.println("The computer rolled a " + ".");
		if(a>b){
			players.add(new Player(MonopolyRunner.name, 1500, 0));
			players.add(new Player("The Computer", 1500, 0));
		}
		else if(b>a){
			players.add(new Player("The Computer", 1500, 0));
			players.add(new Player(MonopolyRunner.name, 1500, 0));
		}
		else{
			System.out.println("Rolling again...");
			chooseOrder();
		}
		
		for(int i = 0; i < players.size(); i++){
			System.out.println("Player " + (i+1) + " is " + players.get(i).getName());
		}
		
	}
}
