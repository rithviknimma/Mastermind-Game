package assignment2;
import java.util.Scanner;

public class Driver {

	public static boolean GAMEPLAY;
	
	public static void main(String[] args) {
		Game game = new Game();
		
		System.out.print(Game.INTRO);
		
		game.setTestMode(true); // set this to false later
		
		// sets test mode
		if(args.length >= 1 && args[0].equals("1")) {
			game.setTestMode(true);
			System.out.println("TEST MODE.");
		}
		
		Scanner sc = new Scanner(System.in); // scanner initialization
		
		if(sc.nextLine().equals("Y"))  // starts game if user wants to play
			GAMEPLAY = true;
		
		// MAIN GAME DRIVER
		while(GAMEPLAY == true){
			System.out.print("\nGenerating secret code ...");
			
			if(game.getTestMode() == true)
				System.out.println("(for this example the secret code is "+ game.getSecretCode() +")\n");
			else
				System.out.println();
			
			while(game.getGuessNumber() > 0 && game.getGameStatus() == false){ // keep playing until player runs out of guesses or has won
				game.nextGuess(sc);
			}
			
			// restarts game if user wants to keep playing
			System.out.print("Are you ready for another game (Y/N) : ");
			if(sc.nextLine().equals("Y")){
				GAMEPLAY = true;
				game.restartGame();
			}
			else
				GAMEPLAY = false;
		}
		
		sc.close();
	}

}






