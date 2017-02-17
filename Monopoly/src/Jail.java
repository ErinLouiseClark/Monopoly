import java.util.*;
import java.io.*;
public class Jail {

	public static void jailMove(){
		if((Player.players.get(PlayerMove.player).getPlayerPosition() - PlayerMove.roll) > 0){
			Player.players.get(PlayerMove.player).setPlayerPosition(Player.players.get(PlayerMove.player).getPlayerPosition() - PlayerMove.roll);	
			PlayerMove.position = Board.board.get(Player.players.get(PlayerMove.player).getPlayerPosition());
			PlayerMove.findTypeOfSpace();
		}
		else if((Player.players.get(PlayerMove.player).getPlayerPosition() - PlayerMove.roll) < 0){
			int temp = 0 - Player.players.get(PlayerMove.player).getPlayerPosition();
			int temp2 = PlayerMove.roll + temp;
			Player.players.get(PlayerMove.player).setPlayerPosition((Board.board.size()) - temp2);
			System.out.println("You passed 'Go'! Your balance has decreased by 200  " + PlayerMove.currency + "!");
			Player.players.get(PlayerMove.player).setMoney(Player.players.get(PlayerMove.player).getMoney()+200);
			PlayerMove.position = Board.board.get(Player.players.get(PlayerMove.player).getPlayerPosition());
			PlayerMove.findTypeOfSpace();
		}
		else{
			Player.players.get(PlayerMove.player).setPlayerPosition(0);
			System.out.println("You landed on 'Go'! Your balance has decreased by 200 " + PlayerMove.currency + "!");
			Player.players.get(PlayerMove.player).setMoney(Player.players.get(PlayerMove.player).getMoney()-200);
			System.out.println("Your balance is now " + Player.players.get(PlayerMove.player).getMoney() + PlayerMove.currency + ".");
			PlayerMove.position = Board.board.get(Player.players.get(PlayerMove.player).getPlayerPosition());
			PlayerMove.makeMove();
		}
	}
	
	public static void goToJail(){
		if(Player.players.get(PlayerMove.player).isJailTime() == false){
			if(Player.players.get(PlayerMove.player).isGetOutOfJailFreeCard() == true){
				System.out.println("You have a 'Get Out of Jail Free' card. Would you like to use it? (1) Yes (2) No ");
				Scanner userInput = new Scanner(System.in);
				int answer = userInput.nextInt();
				if(answer == 1){
					System.out.println("You will remain on your current position.");
					PlayerMove.makeMove();
				}
				else if ((answer != 1) && (answer != 2)){
					System.out.println("That is not a valid answer.");
					goToJail();
				}
			}
			System.out.println("Your position has been changed.");
			System.out.println("You paid 50 " + PlayerMove.currency + " to get out of jail.");
			Player.players.get(PlayerMove.player).setMoney(Player.players.get(PlayerMove.player).getMoney()-50);
			System.out.println("Your balance is now " + Player.players.get(PlayerMove.player).getMoney()  + " " + PlayerMove.currency +  ".");
			System.out.println("You will now move in a backwards direction.");
			Player.players.get(PlayerMove.player).setPlayerPosition(10);
			PlayerMove.position = Board.board.get(Player.players.get(PlayerMove.player).getPlayerPosition());
			Player.players.get(PlayerMove.player).setJailTime(true); 
			PlayerMove.makeMove();
		}
		else{
			if(Player.players.get(PlayerMove.player).isGetOutOfJailFreeCard() == true){
				System.out.println("You have a 'Get Out of Jail Free' card. Would you like to use it? (1) Yes (2) No ");
				Scanner userInput = new Scanner(System.in);
				int answer = userInput.nextInt();
				if(answer == 1){
					System.out.println("You will remain on your current position.");
					PlayerMove.makeMove();
				}
				else if ((answer != 1) && (answer != 2)){
					System.out.println("That is not a valid answer.");
					goToJail();
				}
			}
			System.out.println("Your position has been changed.");
			System.out.println("You paid 50 " + PlayerMove.currency + " to get out of jail.");
			Player.players.get(PlayerMove.player).setMoney(Player.players.get(PlayerMove.player).getMoney()-50);
			System.out.println("Your balance is now " + Player.players.get(PlayerMove.player).getMoney()  + " " + PlayerMove.currency +  ".");
			System.out.println("You will now move in a forwards direction.");
			Player.players.get(PlayerMove.player).setPlayerPosition(10);
			PlayerMove.position = Board.board.get(Player.players.get(PlayerMove.player).getPlayerPosition());
			Player.players.get(PlayerMove.player).setJailTime(false);
			PlayerMove.makeMove();
		}
		
	}
}
