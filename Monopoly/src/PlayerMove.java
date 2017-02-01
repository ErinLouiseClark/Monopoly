
public class PlayerMove {
	
	public static void makeMove(){
		int roll = MonopolyRunner.rollDice();
		System.out.println("You rolled a " + roll + ".");
		if((Player.players.get(0).getPlayerPosition() + roll) < Board.board.size()){
			
			Player.players.get(0).setPlayerPosition(Player.players.get(0).getPlayerPosition() + roll);
			
			if(Board.board.get(Player.players.get(0).getPlayerPosition()) instanceof Board){
				System.out.println("You landed on " + (((Board)Board.board.get(Player.players.get(0).getPlayerPosition())).getSpaceName() + "."));
			}
			else if(Board.board.get(Player.players.get(0).getPlayerPosition()) instanceof Property){
				System.out.println("You landed on " + (((Property)Board.board.get(Player.players.get(0).getPlayerPosition())).getPropertyName() + "."));
			}
			else{
				System.out.println("You landed on " + (((Utility)Board.board.get(Player.players.get(0).getPlayerPosition())).getUtilityName() + "."));
			}
		}
		else{
			System.out.println("poop");
		}
	}
}
