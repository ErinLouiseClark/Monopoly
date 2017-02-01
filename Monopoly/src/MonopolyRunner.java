import java.util.*;
import java.io.*;
public class MonopolyRunner {

	static int dieRoll1;
	static int dieRoll2;
	static int totalRoll;
	static String name;
	
	public static void main(String[] args) {
		welcome();
		Board.makeBoard();
		onePlayerMaker();
		PlayerMove.makeMove();

	}
	
	public static void onePlayerMaker(){
		Player.players.add(new Player(name, 1500, 0));
	}
	
	public static void welcome(){
		System.out.println("Welcome to Monopoly! What is your name?");
		Scanner userInput = new Scanner(System.in);
		name = userInput.nextLine();
		System.out.println("Welcome, " + name + "!");
		
	}
	public static int rollDice(){
		dieRoll1 = (int)(Math.random()*6)+1;
		dieRoll2 = (int)(Math.random()*6)+1;
		totalRoll = dieRoll1 + dieRoll2;
		return totalRoll;
	}

}
