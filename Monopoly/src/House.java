import java.util.*;
import java.io.*;
public class House {
	
	private String color;
	private int numOfHouses;
	
	public House(String col, int num){
		color = col;
		numOfHouses = num;
	}
	static ArrayList<House> houses = new ArrayList<House>();
	
	public static void addHouses(){
		houses.add(new House("Brown", 2));
		houses.add(new House("Light Blue", 3));
		houses.add(new House("Pink", 3));
		houses.add(new House("Orange", 3));
		houses.add(new House("Red", 3));
		houses.add(new House("Yellow", 3));
		houses.add(new House("Green", 3));
		houses.add(new House("Blue", 2));
	}
}
