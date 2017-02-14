
public class Bankrupt {

	public static void checkIfBankrupt(){
		for(int i = 0; i < Player.players.size(); i++){
			if(Player.players.get(i).getMoney() <= 0){
				System.out.println(Player.players.get(i).getName() + " is bankrupt! They have been kicked out of the game.");
				Player.players.remove(i);
			}
		}
	}
}
