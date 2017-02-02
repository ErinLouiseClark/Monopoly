import java.util.*;
import java.io.*;

public class Board {

	private String spaceName;
	private String task;
	private int price;
	static ArrayList board = new ArrayList();
	
	public Board(String n, String t, int p){
		spaceName = n;
		task = t;
		price = p;	
	}
	
	public String getSpaceName() {
		return spaceName;
	}

	public void setSpaceName(String spaceName) {
		this.spaceName = spaceName;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public static ArrayList getBoard() {
		return board;
	}

	public static void setBoard(ArrayList board) {
		Board.board = board;
	}

	public static void makeBoard(){
		
		board.add(new Board("GO", "Give Money", 200));
		
		board.add(new Property("Mediterranean Avenue", "Brown", 60, 0, 30, 2, "None"));
		
		board.add(new Board("Community Chest", "Draw Card", 0));
		
		board.add(new Property("Baltic Avenue", "Brown", 60, 0, 30, 4, "None"));
		
		board.add(new Board("Income Tax", "Charge Money", 200));
		
		board.add(new Utility("Reading Railroad",200, 100, 0, "None"));
		
		board.add(new Property("Oriental Avenue", "Light Blue", 100, 0, 50, 6, "None"));
		
		board.add(new Board("Chance", "Draw Card", 0));
		
		board.add(new Property("Vermont Avenue", "Light Blue", 100, 0, 50, 6, "None"));
		board.add(new Property("Connecticut Avenue", "Light Blue", 120, 0, 50, 6, "None"));
		
		board.add(new Board("Jail", "None", 0));
		
		board.add(new Property("St Charles Place", "Pink", 140, 0, 70, 10, "None"));
		
		board.add(new Utility("Electric Company", 150, 75, 0, "None"));
		
		board.add(new Property("States Avenue", "Pink", 140, 0, 70, 10, "None"));
		board.add(new Property("Virginia Avenue", "Pink", 160, 0, 80, 12, "None"));
		
		board.add(new Utility("Pennsylvania Railroad", 200, 100, 0, "None"));
		
		board.add(new Property("St James Place", "Orange", 180, 0, 90, 14, "None"));
		
		board.add(new Board("Community Chest", "Draw Card", 0));
		
		board.add(new Property("Tennessee Avenue", "Orange", 180, 0, 90, 14, "None"));
		board.add(new Property("New York Avenue", "Orange", 200, 0, 100, 16, "None"));
		
		board.add(new Board("Free Parking", "None", 0));
		
		board.add(new Property("Kentucky Avenue", "Red", 220, 0, 110, 18, "None"));
		
		board.add(new Board("Chance", "Draw Card", 0));
		
		board.add(new Property("Indiana Avenue", "Red", 220, 0, 110, 18, "None"));
		board.add(new Property("Illinois Avenue", "Red", 240, 0, 120, 20, "None"));
		
		board.add(new Utility("B&O Railroad", 200, 100, 0, "None"));
		
		board.add(new Property("Atlantic Avenue", "Yellow", 260, 0, 130, 22, "None"));
		board.add(new Property("Ventnor Avenue", "Yellow", 260, 0, 130, 22, "None"));
		
		board.add(new Utility("Water Works", 150, 75, 0, "None"));
		
		board.add(new Property("Marvin Gardens", "Yellow", 280, 0, 140, 24, "None"));
		
		board.add(new Board("Go to Jail", "Change position", 0));
		
		board.add(new Property("Pacific Avenue", "Green", 300, 0, 150, 26, "None"));
		board.add(new Property("North Carolina Avenue", "Green", 300, 0, 150, 26, "None"));
		
		board.add(new Board("Community Chest", "Draw Card", 0));
		
		board.add(new Property("Pennsylvania Avenue", "Green", 320, 0, 160, 28, "None"));
		
		board.add(new Utility("Short Line", 200, 100, 0, "None"));
		
		board.add(new Board("Chance", "Draw Card", 0));
		
		board.add(new Property("Park Place", "Blue", 350, 0, 175, 35, "None"));
		
		board.add(new Board("Luxary Tax", "Charge Money", 100));
		
		board.add(new Property("Boardwalk", "Blue", 400, 0, 200, 50, "None"));

	}
}
