import java.util.*;
import java.io.*;

public class PlayerMove {
	
	public static void makeMove(){
		System.out.println();
		System.out.println("Press enter to roll the dice.");
		Scanner userInput1 = new Scanner(System.in);
		String blank = userInput1.nextLine();
		int roll = MonopolyRunner.rollDice();
		System.out.println("You rolled " + roll + ".");
		System.out.println();
		if((Player.players.get(0).getPlayerPosition() + roll) < Board.board.size()){
			Player.players.get(0).setPlayerPosition(Player.players.get(0).getPlayerPosition() + roll);		
		}
		else if((Player.players.get(0).getPlayerPosition() + roll) > Board.board.size()+1){
			int temp = Board.board.size() - Player.players.get(0).getPlayerPosition();
			int temp2 = roll - temp;
			Player.players.get(0).setPlayerPosition(0 + temp2);
			System.out.println("You passed 'Go'! Your balance has increased by $200!");
			Player.players.get(0).setMoney(Player.players.get(0).getMoney()+200);
		}
		else{
			Player.players.get(0).setPlayerPosition(0);
			System.out.println("You landed on 'Go'! Your balance has increased by $200!");
			Player.players.get(0).setMoney(Player.players.get(0).getMoney()+200);
			System.out.println("Your balance is now $" + Player.players.get(0).getMoney());
			makeMove();
		}

		if(Board.board.get(Player.players.get(0).getPlayerPosition()) instanceof Board){
			System.out.println("You landed on " + (((Board)Board.board.get(Player.players.get(0).getPlayerPosition())).getSpaceName() + "."));
			if(((Board)Board.board.get(Player.players.get(0).getPlayerPosition())).getTask().equals("Draw Card")){
				int random = (int)(Math.random()*3+1);
				System.out.println("Drawing card...");
				if(random == 1){
					System.out.println("You entered into a beauty contest and won!");
				}
				else if(random == 2){
					System.out.println("The bank pays you a dividend!");
				}
				else{
					System.out.println("You got an income tax refund!");
				}
				System.out.println("You gained $50!");
				Player.players.get(0).setMoney(Player.players.get(0).getMoney() + 50);
				System.out.println("Your balance is now $" + Player.players.get(0).getMoney());
				makeMove();
			}
			else if(((Board)Board.board.get(Player.players.get(0).getPlayerPosition())).getTask().equals("Charge Money")){
				System.out.println("You have to pay $" + ((Board)Board.board.get(Player.players.get(0).getPlayerPosition())).getPrice() + ".");
				if(Player.players.get(0).getMoney() < (((Board)Board.board.get(Player.players.get(0).getPlayerPosition())).getPrice())){
					System.out.println("You do not have enough money for this.");
					System.out.println("You are bankrupt.");
					System.exit(0);
				}
				Player.players.get(0).setMoney(Player.players.get(0).getMoney()-((Board)Board.board.get(Player.players.get(0).getPlayerPosition())).getPrice());
				System.out.println("Your balance is now $" + Player.players.get(0).getMoney() + ".");
				makeMove();
			}
			else if(((Board)Board.board.get(Player.players.get(0).getPlayerPosition())).getTask().equals("Change position")){
				System.out.println("Your position has been changed.");
				Player.players.get(0).setPlayerPosition(10);
				makeMove();
			}
			else{
				makeMove();
			}
		}
		else if(Board.board.get(Player.players.get(0).getPlayerPosition()) instanceof Property){
			System.out.println("You landed on " + (((Property)Board.board.get(Player.players.get(0).getPlayerPosition())).getPropertyName() + "."));
			if((((Property)Board.board.get(Player.players.get(0).getPlayerPosition())).getPropertyOwner().equals("None"))){
				System.out.println("This property costs $" + (((Property)Board.board.get(Player.players.get(0).getPlayerPosition())).getPrice()) + ".");
				System.out.println("Would you like to buy this property? (1) Yes (2) No");
				Scanner userInput = new Scanner(System.in);
				int temp = userInput.nextInt();
				if(temp == 1){
					if(Player.players.get(0).getMoney() < (((Property)Board.board.get(Player.players.get(0).getPlayerPosition())).getPrice())){
						System.out.println("You do not have enough money for this.");
						makeMove();
					}
					Player.playerOwnership.add(((Property)Board.board.get(Player.players.get(0).getPlayerPosition())));
					Player.players.get(0).setMoney(Player.players.get(0).getMoney()-((Property)Board.board.get(Player.players.get(0).getPlayerPosition())).getPrice());
					System.out.println("Your balance is now $" + Player.players.get(0).getMoney());
					System.out.println("You now own: ");
					for(int i = 0; i < Player.playerOwnership.size(); i++){
						if(Player.playerOwnership.get(i) instanceof Property){
							System.out.println(((Property) Player.playerOwnership.get(i)).getPropertyName());
						}
						else if(Player.playerOwnership.get(i) instanceof Utility){
							System.out.println(((Utility) Player.playerOwnership.get(i)).getUtilityName());
						}
					}
					makeMove();
				}
				else if(temp == 2){
					System.out.println("Ok.");
					makeMove();
				}
				else{
					System.out.println("That is not an option. You can no longer buy this property.");
					makeMove();
				}
			}
			else{
				System.out.println("You own this property.");
				makeMove();
			}
		}
		else{
			System.out.println("You landed on " + (((Utility)Board.board.get(Player.players.get(0).getPlayerPosition())).getUtilityName() + "."));
			if((((Utility)Board.board.get(Player.players.get(0).getPlayerPosition())).getUtilityOwner().equals("None"))){
				System.out.println("This property costs $" + (((Utility)Board.board.get(Player.players.get(0).getPlayerPosition())).getUtilityPrice()) + ".");
				System.out.println("Would you like to buy this utility? (1) Yes (2) No");
				Scanner userInput = new Scanner(System.in);
				int temp = userInput.nextInt();
				if(temp == 1){
					if(Player.players.get(0).getMoney() < (((Utility)Board.board.get(Player.players.get(0).getPlayerPosition())).getUtilityPrice())){
						System.out.println("You do not have enough money for this.");
						makeMove();
					}
					Player.playerOwnership.add(((Utility)Board.board.get(Player.players.get(0).getPlayerPosition())));
					Player.players.get(0).setMoney(Player.players.get(0).getMoney()-((Utility)Board.board.get(Player.players.get(0).getPlayerPosition())).getUtilityPrice());
					System.out.println("Your balance is now $" + Player.players.get(0).getMoney() + ".");
					System.out.println("You now own: ");
					for(int i = 0; i < Player.playerOwnership.size(); i++){
						if(Player.playerOwnership.get(i) instanceof Property){
							System.out.println(((Property) Player.playerOwnership.get(i)).getPropertyName());
						}
						else if(Player.playerOwnership.get(i) instanceof Utility){
							System.out.println(((Utility) Player.playerOwnership.get(i)).getUtilityName());
						}
					}
					makeMove();
				}
				else if(temp == 2){
					System.out.println("Ok.");
					makeMove();
				}
				else{
					System.out.println("That is not an option. You can no longer buy this property.");
					makeMove();
				}
		}
			else{
				System.out.println("You own this utililty.");
				makeMove();
			}
	}
}
}
