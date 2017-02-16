import java.util.*;
import java.io.*;

public class PlayerMove {
		
	static Object position; 
	static boolean jailTime = false;	
	static String currency;
	static int counter = 0;
	static int player = -1;
	static int spaceOwnerNum;
	static String spaceOwnerName;
	static int roll;
	
	public static void makeMove(){
		player++;
		if(player == Player.players.size()){
			player = 0;
		}
		if(Player.players.size()>1){
			System.out.println();
			System.out.println("It is " + Player.players.get(player).getName() + "'s turn.");
		}
		
		position = Board.board.get(Player.players.get(player).getPlayerPosition());
		System.out.println();
		System.out.println("Press enter to roll the dice.");
		Scanner userInput1 = new Scanner(System.in);
		String blank = userInput1.nextLine();
		if(blank.equals("Draw Card")){
			Card.drawCard();
		}
		else if(blank.equals("Build House")){
			Color.colors.get(0).setOwner(Player.players.get(PlayerMove.player).getName());
			for(int i = 0; i < Board.board.size(); i ++){
				if(Board.board.get(i) instanceof Property){
					if(((Property)Board.board.get(i)).getColor().equals("Brown")){
						Player.players.get(player).getOwnedProperties().add(((Property)Board.board.get(i)));
					}
				}
			}
			Color.checkIfMonopoly();
		}
		roll = MonopolyRunner.rollDice();
		System.out.println("You rolled " + roll + ".");
		
		
		System.out.println();
		if(jailTime == false){
			if((Player.players.get(player).getPlayerPosition() + roll) < Board.board.size()){
				Player.players.get(player).setPlayerPosition(Player.players.get(player).getPlayerPosition() + roll);	
				position = Board.board.get(Player.players.get(player).getPlayerPosition());
			}
			else if((Player.players.get(player).getPlayerPosition() + roll) > Board.board.size()+1){
				int temp = Board.board.size() - Player.players.get(player).getPlayerPosition();
				int temp2 = roll - temp;
				Player.players.get(player).setPlayerPosition(0 + temp2);
				System.out.println("You passed 'Go'! Your balance has increased by 200 " + currency + "!");
				Player.players.get(player).setMoney(Player.players.get(player).getMoney()+200);
				position = Board.board.get(Player.players.get(player).getPlayerPosition());
			}
			else{
				Player.players.get(player).setPlayerPosition(0);
				System.out.println("You landed on 'Go'! Your balance has increased by 200 " + currency + "!");
				Player.players.get(player).setMoney(Player.players.get(player).getMoney()+200);
				System.out.println("Your balance is now " + Player.players.get(player).getMoney() + currency + ".");
				position = Board.board.get(Player.players.get(player).getPlayerPosition());
				makeMove();
			}
		}
		else{
			Jail.jailMove();
		}
		findTypeOfSpace();
	}	

	public static void findTypeOfSpace(){
		if(position instanceof Board){
			makeBoardMove();
		}
		else if(position instanceof Property){
			makePropertyMove();
		}
		else{
			makeUtilityMove();
		}
	
	}
	
	public static void makeBoardMove(){
		
			System.out.println("You landed on " + (((Board)position).getSpaceName() + "."));
			if(((Board)position).getTask().equals("Draw Card")){
				Card.drawCard();
			}
			else if(((Board)position).getTask().equals("Charge Money")){
				System.out.println("You have to pay " + ((Board)position).getPrice() + " " + currency + ".");
				if(Player.players.get(player).getMoney() < (((Board)position).getPrice())){
					Player.players.get(player).setMoney(Player.players.get(player).getMoney()-(((Board)position).getPrice()));
					Bankrupt.checkIfBankrupt();
				}
				Player.players.get(player).setMoney(Player.players.get(player).getMoney()-((Board)position).getPrice());
				System.out.println("Your balance is now " + Player.players.get(player).getMoney()  + " " + currency +  ".");
				makeMove();
			}
			else if(((Board)position).getTask().equals("Change position")){
				Jail.goToJail();
			}
			else{
				makeMove();
			}
		
	}
	
	public static void makePropertyMove(){
			System.out.println("You landed on " + (((Property)position).getPropertyName() + "."));
			if((((Property)position).getPropertyOwner().equals("None"))){
				System.out.println("This property costs " + (((Property)position).getPrice()) + " " + currency + ".");
				System.out.println("Would you like to buy this property? (1) Yes (2) No");
				Scanner userInput = new Scanner(System.in);
				int temp = userInput.nextInt();
				if(temp == 1){
					if(Player.players.get(player).getMoney() < (((Property)position).getPrice())){
						System.out.println("You do not have enough money for this.");
						makeMove();
					}
					((Property)position).setPropertyOwner(Player.players.get(player).getName());
					Player.players.get(player).getOwnedProperties().add(((Property)position));
					Player.players.get(player).setMoney(Player.players.get(player).getMoney()-((Property)position).getPrice());
					System.out.println("Your balance is now " + Player.players.get(player).getMoney() + " " + currency + ".");
					System.out.println("You now own: ");
					for(int i = 0; i < Board.board.size()-1; i++){
						if(Board.board.get(i) instanceof Property){
							if(((Property)Board.board.get(i)).getPropertyOwner().equals(Player.players.get(player).getName())){
								System.out.println(((Property)Board.board.get(i)).getPropertyName());
							}	
						}
						else if(Board.board.get(i) instanceof Utility){
							if(((Utility)Board.board.get(i)).getUtilityOwner().equals(Player.players.get(player).getName())){
								System.out.println(((Utility)Board.board.get(i)).getUtilityName());
							}	
						}
					}
					makeMove();
				}
				else if(temp == 2){
					System.out.println("Ok.");
					makeMove();
				}
				else{
					System.out.println("That is not an option.");
					makePropertyMove();
				}
			}
			else if ((((Property)position).getPropertyOwner().equals(Player.players.get(player).getName()))){
				System.out.println("You own this property.");
				makeMove();
			}
			else{
				System.out.println(((Property)position).getPropertyOwner() + " owns this space!");
				System.out.println("You owe " + ((Property)position).getPropertyOwner() + " " + ((Property)position).getRent() + " " + currency + ".");
				Player.players.get(player).setMoney(Player.players.get(player).getMoney()-((Property)position).getRent());
				Bankrupt.checkIfBankrupt();
				for(int b = 0; b < Player.players.size(); b++){
					if(Player.players.get(b).getName().equals(((Property)position).getPropertyOwner())){
						spaceOwnerNum = b;
						spaceOwnerName = Player.players.get(b).getName();
					}
				}
				Player.players.get(spaceOwnerNum).setMoney(Player.players.get(spaceOwnerNum).getMoney()+((Property)position).getRent());
				System.out.println("Your balance is now " + Player.players.get(player).getMoney() + " " + currency + ".");
				System.out.println(spaceOwnerName + "'s balance is now " + Player.players.get(spaceOwnerNum).getMoney() + " " + currency + ".");
				
			}
	}
	
	public static void makeUtilityMove(){
		
			System.out.println("You landed on " + (((Utility)position).getUtilityName() + "."));
			if((((Utility)position).getUtilityOwner().equals("None"))){
				System.out.println("This property costs " + (((Utility)position).getUtilityPrice()) + " " + currency + ".");
				System.out.println("Would you like to buy this utility? (1) Yes (2) No");
				Scanner userInput = new Scanner(System.in);
				int temp = userInput.nextInt();
				if(temp == 1){
					if(Player.players.get(player).getMoney() < (((Utility)position).getUtilityPrice())){
						System.out.println("You do not have enough money for this.");
						makeMove();
					}
					((Utility)position).setUtilityOwner(Player.players.get(player).getName());
					Player.players.get(player).setMoney(Player.players.get(player).getMoney()-((Utility)position).getUtilityPrice());
					System.out.println("Your balance is now " + Player.players.get(player).getMoney() + " " + currency + ".");
					System.out.println("You now own: ");
					for(int i = 0; i < Board.board.size()-1; i++){
						if(Board.board.get(i) instanceof Property){
							if(((Property)Board.board.get(i)).getPropertyOwner().equals(Player.players.get(player).getName())){
								System.out.println(((Property)Board.board.get(i)).getPropertyName());
							}	
						}
						else if(Board.board.get(i) instanceof Utility){
							if(((Utility)Board.board.get(i)).getUtilityOwner().equals(Player.players.get(player).getName())){
								System.out.println(((Utility)Board.board.get(i)).getUtilityName());
							}	
						}
					}

					makeMove();
				}
				else if(temp == 2){
					System.out.println("Ok.");
					makeMove();
				}
				else{
					System.out.println("That is not an option.");
					makeUtilityMove();
				}
		}
			else if ((((Utility)position).getUtilityOwner().equals(Player.players.get(player).getName()))){
				System.out.println("You own this utililty.");
				makeMove();
			}
			else{
				System.out.println(((Utility)position).getUtilityOwner() + " owns this space!");
				System.out.println("You owe " + ((Utility)position).getUtilityOwner() + " " + ((Utility)position).getUtilityRent() + " " + currency + ".");
				Player.players.get(player).setMoney(Player.players.get(player).getMoney()-((Utility)position).getUtilityRent());
				Bankrupt.checkIfBankrupt();
				for(int b = 0; b < Player.players.size(); b++){
					if(Player.players.get(b).getName().equals(((Utility)position).getUtilityOwner())){
						spaceOwnerNum = b;
						spaceOwnerName = Player.players.get(b).getName();
					}
				}
				Player.players.get(spaceOwnerNum).setMoney(Player.players.get(spaceOwnerNum).getMoney()+((Utility)position).getUtilityRent());
				System.out.println("Your balance is now " + Player.players.get(player).getMoney() + " " + currency + ".");
				System.out.println(spaceOwnerName + "'s balance is now " + Player.players.get(spaceOwnerNum).getMoney() + " " + currency + ".");
			}
	}
	
}
