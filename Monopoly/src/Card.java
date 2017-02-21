import java.util.*;
import java.io.*;

public class Card {

	private String cardName;
	private int cardNum;
	
	public Card(String n, int nu){
		cardName = n;
		cardNum = nu;
	}
	static ArrayList<Card> cardList = new ArrayList<Card>();
	
	
	public static void drawCard(){
		
		int random = (int)(Math.random()*10);
		System.out.println("Drawing card...");
		System.out.println("You landed on " + cardList.get(random).getCardName() + ".");
		if(cardList.get(random).getCardNum() == 1){
			Player.players.get(PlayerMove.player).setPlayerPosition(0);
			System.out.println("You landed on 'Go'! Your balance has increased by 200 " + PlayerMove.currency + "!");
			Player.players.get(PlayerMove.player).setMoney(Player.players.get(PlayerMove.player).getMoney()+200);
			System.out.println("Your balance is now " + Player.players.get(PlayerMove.player).getMoney() + " " + PlayerMove.currency + ".");
			PlayerMove.position = Board.board.get(Player.players.get(PlayerMove.player).getPlayerPosition());
			PlayerMove.makeMove();
		}
		else if(cardList.get(random).getCardNum() == 2){
			System.out.println("You can use this card later.");
			Player.players.get(PlayerMove.player).setGetOutOfJailFreeCard(true);
			PlayerMove.makeMove();
		}
		else if(cardList.get(random).getCardNum() == 3){
			Jail.goToJail();
		}
		else if(cardList.get(random).getCardNum() == 4){
			System.out.println("You gained 50 " + PlayerMove.currency + "!");
			Player.players.get(PlayerMove.player).setMoney(Player.players.get(PlayerMove.player).getMoney() + 50);
			System.out.println("Your balance is now " + Player.players.get(PlayerMove.player).getMoney() + " " +  PlayerMove.currency + ".");
			PlayerMove.makeMove();
		}
		else{
			System.out.println("You lost 50 " + PlayerMove.currency + "!");
			Player.players.get(PlayerMove.player).setMoney(Player.players.get(PlayerMove.player).getMoney() - 50);
			System.out.println("Your balance is now " + Player.players.get(PlayerMove.player).getMoney() + " " +  PlayerMove.currency + ".");
			PlayerMove.makeMove();
		}

	}


	public String getCardName() {
		return cardName;
	}


	public void setCardName(String cardName) {
		this.cardName = cardName;
	}


	public int getCardNum() {
		return cardNum;
	}


	public void setCardNum(int cardNum) {
		this.cardNum = cardNum;
	}


	public ArrayList<Card> getCardList() {
		return cardList;
	}


	public void setCardList(ArrayList<Card> cardList) {
		Card.cardList = cardList;
	}
}
 