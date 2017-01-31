import java.util.*;
import java.io.*;
public class MonopolyRunner {

	static int dieRoll1;
	static int dieRoll2;
	static int totalRoll;
	static String name;
	
	public void main(String[] args) {
		welcome();
		

	}
	
	public static void welcome(){
		System.out.println("Welcome to Monopoly! What is your name?");
		Scanner userInput = new Scanner(System.in);
		name = userInput.nextLine();
		System.out.println("Welcome, " + name + "!");
		
	}
	public static int diceRoll(){
		dieRoll1 = (int)(Math.random()*6)+1;
		dieRoll2 = (int)(Math.random()*6)+1;
		totalRoll = dieRoll1 + dieRoll2;
		return totalRoll;
	}

}
