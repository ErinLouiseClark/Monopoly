import java.util.*;

import javax.xml.crypto.Data;

import java.io.*;

public class Board {

	private String spaceName;
	private String task;
	private int price;
	static ArrayList board = new ArrayList();
	static Scanner file;
	static String[] data;
	
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

	public static void makeBoard(int num) throws FileNotFoundException{
		if(num == 1){
			file = new Scanner(new File ("OriginalMonopoly.txt"));
			PlayerMove.currency = "dollars";
		}
		else if (num == 2 ){
			file = new Scanner(new File ("HarryPotterMonopoly.txt"));
			PlayerMove.currency = "galleons";
		}
		while(file.hasNextLine()){
			String temp = file.nextLine();
			data = temp.split(", ");
			if(data.length == 3){
				board.add(new Board(data[0], data[1], (int)Integer.parseInt(data[2])));
			}
			else if(data.length == 7){
				board.add(new Property(data[0], data[1], (int)Integer.parseInt(data[2]),(int)Integer.parseInt(data[3]), (int)Integer.parseInt(data[4]), (int)Integer.parseInt(data[5]), data[6]));
			}
			else{
				board.add(new Utility(data[0], (int)Integer.parseInt(data[1]), (int)Integer.parseInt(data[2]), (int)Integer.parseInt(data[3]), data[4]));
			}
		}
	}
}
