import java.util.*;
import java.io.*;

public class Card {

	public static void drawCard(){
		int random = (int)(Math.random()*3+1);
		System.out.println("Drawing card...");
		if(PlayerMove.currency.equals("dollars")){
			if(random == 1){
				System.out.println("You entered into a beauty contest and won!");
			}
			else if(random == 2){
				System.out.println("The bank pays you a dividend!");
			}
			else{
				System.out.println("You got an income tax refund!");
			}
		}
		else{
			if(random == 1){
				System.out.println("You won the Triwizard Tournament!");
			}
			else if(random == 2){
				System.out.println("You got a Ministy of Magic tax refund!");
			}
			else{
				System.out.println("Your house won the House Cup!");
			}
		}
		System.out.println("You gained 50 " + PlayerMove.currency + "!");
		Player.players.get(0).setMoney(Player.players.get(0).getMoney() + 50);
		System.out.println("Your balance is now " + Player.players.get(0).getMoney() + " " +  PlayerMove.currency + ".");
		PlayerMove.makeMove();
	}
}
