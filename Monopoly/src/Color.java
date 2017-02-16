import java.util.ArrayList;
import java.util.Scanner;
public class Color {

	private String color;
	private int numHouses;
	private String owner;
	static String c;
	static int p;
	
	static ArrayList<Property> temp = new ArrayList<Property>();
	static ArrayList<Color> colors = new ArrayList<Color>();
	
	public Color(String col, int num, String o){
		color = col;
		numHouses = num;
		owner = o;
	}
	
	public static void addColors(){
		colors.add(new Color("Brown", 2, null));
		colors.add(new Color("Light Blue", 3, null));
		colors.add(new Color("Pink", 3, null));
		colors.add(new Color("Orange", 3, null));
		colors.add(new Color("Red", 3, null));
		colors.add(new Color("Yellow", 3, null));
		colors.add(new Color("Green", 3, null));
		colors.add(new Color("Blue", 2, null));		
	}
	
	public static void checkIfMonopoly(){
		for(int i = 0; i < colors.size(); i++){
			int counter = 0;
			for(int j = 0; j < Player.players.get(PlayerMove.player).getOwnedProperties().size(); j++){
				if(colors.get(i).getOwner() == null){
					if(Player.players.get(PlayerMove.player).getOwnedProperties().get(j).getColor().equals(colors.get(i).getColor())){
						counter++;
					}
					if(counter == colors.get(i).getNumHouses()){
						System.out.println(Player.players.get(PlayerMove.player).getName() + " has a monopoly of " + colors.get(i).getColor() + " properties!");
						colors.get(i).setOwner(Player.players.get(PlayerMove.player).getName());
						System.out.println("Would you like to buy a house? (1) Yes (2) No");
						Scanner userInput = new Scanner(System.in);
						int answer = userInput.nextInt();
						if(answer == 1 ){
							addHouses();
						}
						else if(answer == 2){
							System.out.println("Ok");
							
						}
						else{
							System.out.println("Not a valid answer.");
							i--;
							checkIfMonopoly();
						}
						
					}
				}
				else{
					i++;
				}
			}
		}
		PlayerMove.makeMove();
	}
	
	public static void addHouses(){
		for(int i = 0; i < colors.size(); i++){
			if(colors.get(i).getOwner().equals(Player.players.get(PlayerMove.player).getName())){
				c = colors.get(i).getColor();
			}
		}
		if(c.equals("Brown") || c.equals("Light Blue")){
			p = 50;
		}
		else if(c.equals("Pink") || c.equals("Orange")){
			p = 100;
		}
		else if(c.equals("Red") || c.equals("Yellow")){
			p = 150; 
		}
		else{
			p = 200;
		}
		if(Player.players.get(PlayerMove.player).getMoney() < 200){
			System.out.println("You do not have enough money to buy a house.");
			PlayerMove.makeMove();
		}
		for(int i = 0; i < Board.board.size(); i++){
			if(Board.board.get(i) instanceof Property){
				if((((Property)Board.board.get(i)).getColor()).equals(c)){
					temp.add((Property)Board.board.get(i));
				}		
			}
		}
		System.out.println("Which property would you like to add a house to?");
		for(int i = 0; i < temp.size(); i++){
			System.out.println((i+1) + " " + temp.get(i).getPropertyName());
		}
		Scanner userInput = new Scanner(System.in);
		int answer = userInput.nextInt();
		for(int i = 1; i <= temp.size(); i++){
			if(answer == (i-1)){
				for(int j = 0; j < Board.board.size(); j++){
					if((((Property)Board.board.get(j)) == temp.get(i-1))){
						((Property)Board.board.get(j)).setHouses((((Property)Board.board.get(j)).getHouses() + 1));
						if((((Property)Board.board.get(j)).getHouses() == 1)){
							((Property)Board.board.get(j)).setRent((((Property)Board.board.get(j)).getR1()));
						}
						else if((((Property)Board.board.get(j)).getHouses() == 2)){
							((Property)Board.board.get(j)).setRent((((Property)Board.board.get(j)).getR2()));
						}
						else if((((Property)Board.board.get(j)).getHouses() == 3)){
							((Property)Board.board.get(j)).setRent((((Property)Board.board.get(j)).getR3()));
						}
						else if((((Property)Board.board.get(j)).getHouses() == 4)){
							((Property)Board.board.get(j)).setRent((((Property)Board.board.get(j)).getR4()));
						}
						else if((((Property)Board.board.get(j)).getHouses() == 5)){
							((Property)Board.board.get(j)).setRent((((Property)Board.board.get(j)).getR5()));
							
						}
					}
					System.out.println("The rent for this property is now " + ((Property)Board.board.get(j)).getRent());
				}
			}
		}
		Player.players.get(PlayerMove.player).setMoney(Player.players.get(PlayerMove.player).getMoney() - p);
		System.out.println("You paid " + p + " for the house. Your balance is now " + Player.players.get(PlayerMove.player).getMoney() + ".");
		PlayerMove.makeMove();
		
		
	}
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public static ArrayList<Color> getColors() {
		return colors;
	}

	public static void setColors(ArrayList<Color> colors) {
		Color.colors = colors;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNumHouses() {
		return numHouses;
	}

	public void setNumHouses(int numHouses) {
		this.numHouses = numHouses;
	}
}
