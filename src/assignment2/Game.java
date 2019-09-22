package assignment2;

import java.util.Scanner;
import java.util.Arrays;

public class Game {
	private static String secretCode;
	private static int guessNumber;
	private static int pegNumber;
	private static boolean GAMEWON;
	private static boolean TESTMODE;
	
	public static final String INTRO = "Welcome to Mastermind.  Here are the rules.\n"
			+ "\nThis is a text version of the classic board game Mastermind.\n"
			+ "\nThe  computer  will  think  of  a  secret  code.  The  code  consists  of  4\n"
			+ "colored  pegs.The  pegs  MUST  be  one  of  six  colors:  blue,  green,\n"
			+ "orange, purple, red, or yellow. A color may appear more than once in \n"
			+ "the  code.  You  try  to  guess  what  colored  pegs  are  in  the  code  and\n"
			+ "what  order  they  are  in. After  you make  a  valid  guess  the  result\n"
			+ "(feedback) will be displayed.\n"
			+ "\nThe  result  consists  of  a  black  peg  for  each  peg  you  have  guessed\n"
			+ "exactly correct (color and position) in your guess.  For each peg in\n"
			+ "the guess that is the correct color, but is out of position, you get\n"
			+ "a  white  peg. For  each  peg,  which  is  fully  incorrect,  you  get  no\n"
			+ "feedback. \n"
			+ "\nOnly the first letter of the color is displayed. B for Blue, R for\n"
			+ "Red, and so forth.When entering guesses you only need to enter the\n"
			+ "first character of each color as a capital letter.\n"
			+ "\nYou have 12 guesses to figure out the secret code or you lose the\n"
			+ "game.  Are you ready to play? (Y/N):  ";
	
	public Game(){
		secretCode = SecretCodeGenerator.getInstance().getNewSecretCode();
		guessNumber = GameConfiguration.guessNumber;
		pegNumber = GameConfiguration.pegNumber;
		GAMEWON = false;
	}
	
	public void restartGame(){
		secretCode = SecretCodeGenerator.getInstance().getNewSecretCode();
		guessNumber = GameConfiguration.guessNumber;
		pegNumber = GameConfiguration.pegNumber;
		GAMEWON = false;
	}
	
	// prints number of guesses left and rest of the words
	public void nextGuess(Scanner sc){
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
			
			if(checkIfValid(guess)){  // only if valid 
				getPegs(guess);
				validGuess = true;
				guessNumber--;
			}
			else {
				System.out.println("  -> INVALID GUESS\n");
			}
			
			System.out.println();
		}
	}
	
	// checks if user input guess is valid
	public static boolean checkIfValid(String guess){
		
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
	
	public void getPegs(String guess){
		int blackPegs = 0;
		int whitePegs = 0;
		
		if(guess.equals(secretCode)) {
			System.out.println("\n"+ guess + " -> Result:  4 black pegs - You win !!");
			GAMEWON = true;
		}
		else {
			String[] guessArray = guess.split("");
			String[] secretCodeArray = secretCode.split("");
			boolean guessContainsCodeColor;
			
			for(int i = 0; i < guess.length(); i++){
				if(guessArray[i].equals(secretCodeArray[i])){
					blackPegs++;
				}
				else {
					guessContainsCodeColor = Arrays.stream(secretCodeArray).anyMatch(guessArray[i]::equals); // check if guess contains a color from secret code
					if(guessContainsCodeColor){
						whitePegs++;
					}
				}
			}
			printPegs(blackPegs, whitePegs, guess);
		}
	}
	
	// prints
	public void printPegs(int blackPegs, int whitePegs, String guess){
		System.out.print("\n"+ guess + " -> Result:  " );
		if(blackPegs != 0 || whitePegs != 0){
			if(blackPegs > 0) {
				if(blackPegs == 1)
					System.out.print(blackPegs + " black peg");
				else
					System.out.print(blackPegs + " black pegs");
			}
			if(whitePegs > 0) {
				if(blackPegs > 0)
					System.out.print(", and ");
				if(whitePegs == 1)
					System.out.print(whitePegs + " white peg");
				else
					System.out.print(whitePegs + " white pegs");
			}
			System.out.println();
		}
		else if(blackPegs == 0 && whitePegs == 0){
			System.out.println("No Pegs");
		}
	}
	
	public void setTestMode(boolean set){
		TESTMODE = set;
	}
	
	public boolean getTestMode(){
		return TESTMODE;
	}
	
	public boolean getGameStatus(){
		return GAMEWON;
	}
	
	public String getSecretCode() {
		return secretCode;
	}
	
	// may not need this function
	public void decrementGuessNumber() {
		guessNumber--;
	}
	
	public int getGuessNumber() {
		return guessNumber;
	}
	
	public int getPegNumber() {
		return pegNumber;
	}
}
