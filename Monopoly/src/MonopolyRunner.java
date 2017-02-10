import java.util.*;
import java.io.*;
public class MonopolyRunner {

	static int dieRoll1;
	static int dieRoll2;
	static int totalRoll;
	static int numPlayers = 0;
	
	public static void main(String[] args) throws FileNotFoundException{
		
		welcome();
		PlayerMove.makeMove();
		//Board = 3; Property = 7; Utility = 5;

	}
	
	public static void addPlayers(String name){
		Player.players.add(new Player(name, 1500, 0));
	}
	
	public static void welcome() throws FileNotFoundException {
		System.out.println("Welcome to Monopoly!");
		
		System.out.println("How many players are there?");
		Scanner userInput2 = new Scanner(System.in);
		numPlayers = userInput2.nextInt();
		for(int i = 0; i < numPlayers; i++){
			System.out.println("Enter the name of Player " + (i+1) + ".");
			Scanner userInput = new Scanner(System.in);
			String name = userInput.nextLine();
			addPlayers(name);
			System.out.println("Welcome, " + name + "!");
		}
		
		System.out.println("Which version would you like to play? (1) Original (2) Harry Potter");
		Scanner chooseVersion = new Scanner(System.in);
		int num = chooseVersion.nextInt();
		Board.makeBoard(num);
		
	}
	public static int rollDice(){
		dieRoll1 = (int)(Math.random()*6)+1;
		dieRoll2 = (int)(Math.random()*6)+1;
		totalRoll = dieRoll1 + dieRoll2;
		return totalRoll;
	}

}
