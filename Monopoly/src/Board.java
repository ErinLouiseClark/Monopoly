import java.util.*;
import java.io.*;

public class Board {

	private String spaceName;
	private String task;
	private int price;
	
	public Board(String n, String t, int p){
		spaceName = n;
		task = t;
		price = p;	
	}
	
	public void makeBoard(){
		ArrayList board = new ArrayList();
		board.add(new Board("GO", "", 200));
		board.add(new Property());
		board.add(new Board("Community Chest", "", ));
		board.add(new Property());
		board.add(new Board("Income Tax", "", 100));
		board.add(new Board());
		board.add(new Property());
		board.add(new Board("Chance", "", ));
		board.add(new Property());
		board.add(new Property());
		board.add(new Board());
		board.add();
		board.add();
		board.add();
		board.add();
		board.add();
		board.add();
		board.add();
		board.add();
		board.add();
		board.add();
		board.add();
		board.add();
		board.add();
		board.add();
		board.add();
		board.add();
		board.add();
		board.add();
		board.add();
		board.add();
		board.add();
		board.add();
		board.add();
		board.add();
		board.add();
		board.add();
		board.add();
		board.add();
		board.add();

	}
}
