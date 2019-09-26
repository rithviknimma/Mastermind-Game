/* EE422C Assignment #2 submission by
 * <Rithvik Baddam>
 * <UT EID: rrb2442>
 */

package assignment2;
import java.util.Scanner;

public class Driver {

	public static boolean GAMEPLAY;
	
	public static void main(String[] args) {
		boolean testmode = false; // default game mode
		boolean validGuess;
		
		// sets test mode if user specifies
		if(args.length >= 1 && args[0].equals("1")) {
			testmode = true;
			System.out.println("TEST MODE.");
		}
		
		// construct game and print intro
		Game game = new Game(testmode);
		game.printIntro();
		
		Scanner sc = new Scanner(System.in); // scanner initialization
		
		if(sc.nextLine().equals("Y"))  // starts game if user wants to play
			GAMEPLAY = true;
		
		// MAIN GAME DRIVER
		while(GAMEPLAY == true){
			System.out.print("\nGenerating secret code ...");
			
			if(game.getTestMode() == true)
				System.out.println("(TEST MODE ENABLED. Secret code is "+ game.getSecretCode() +")\n");
			else
				System.out.println("\n");
			
			while(game.getGameBoard().getGuessNumber() > 0 && game.getGameStatus() == false){ // keep playing until player runs out of guesses or hasn't won yet             
				validGuess = game.getGameBoard().nextGuess(sc, game);
				
				if(validGuess) { // if it's a valid guess, calculate and print pegs
					game.getPegs().calculatePegs(game.getCurrentGuess(), game.getSecretCode(), game);
					game.getPegs().printPegs(game.getCurrentGuess(), game);
				}
			}
			
			if(game.getGameStatus() == false) // if player lost the game
				System.out.println("Sorry, you are out of guesses. You lose, boo-hoo.\n");
			
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






