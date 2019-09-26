/* EE422C Assignment #2 submission by
 * <Rithvik Baddam>
 * <UT EID: rrb2442>
 */

package assignment2;

import java.util.Arrays;
import java.util.Scanner;

public class GameBoard {
	private int guessNumber;
	
	public GameBoard() {
		guessNumber = GameConfiguration.guessNumber;
	}
	public int getGuessNumber() {
		return guessNumber;
	}
	// asks user for a guess and decides whether it's a valid guess
	public boolean nextGuess(Scanner sc, Game game){
		String guess;
		boolean validGuess = false;
		
		// prints number of guesses left
		System.out.print("You have " + guessNumber);
		if(guessNumber == 1)
			System.out.println(" guess left.");
		else 
			System.out.println(" guesses left.");
		
		// keeps asking for input until user inputs valid guess
		while(validGuess != true){
			System.out.println("What is your next guess?");
			System.out.println("Type in the characters for your guess and press enter.");
			System.out.print("Enter guess: ");
			guess = sc.nextLine();

			if(guess.equals("HISTORY")) {
				game.printHistory();
			}
			else if(checkIfValid(guess, game.getSecretCode())){  // only if valid 
				game.setCurrentGuess(guess);
				validGuess = true;
				guessNumber--;
			}
			else {
				System.out.println("  -> INVALID GUESS\n");
			}
		}
		
		return validGuess;
	}
	
	// checks if user input guess is valid
	public boolean checkIfValid(String guess, String secretCode){
		
		// if length of guess not equal to secretCode, invalid guess 
		if(guess.length() != secretCode.length()) 
			return false;
		
		String[] guessArray = guess.split(""); // splits user guess into string array to compare with colors array
		boolean containsGuessColor;
		
		// check if guess contains valid color values
		for(String a : guessArray) {
			containsGuessColor = Arrays.stream(GameConfiguration.colors).anyMatch(a::equals); // compares each guess letter to see if it is a valid color
			if(containsGuessColor == false)
				return false;
		}
		
		return true; // if guess passes length and valid colors test, its a valid guess
	}

}
