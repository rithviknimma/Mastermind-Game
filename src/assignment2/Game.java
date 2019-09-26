/* EE422C Assignment #2 submission by
 * <Rithvik Baddam>
 * <UT EID: rrb2442>
 */

package assignment2;

import java.util.ArrayList;

public class Game {
	private String secretCode;
	private String currentGuess;
	private int guessNumber;
	private boolean GAMEWON;
	private boolean TESTMODE;
	private Pegs pegs;
	private GameBoard gameboard;
	private ArrayList<String> history;
	
	
	private static final String INTRO = "Welcome to Mastermind.  Here are the rules.\n"
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
	
	public Game(boolean testmode){
		secretCode = SecretCodeGenerator.getInstance().getNewSecretCode();
		guessNumber = GameConfiguration.guessNumber;
		pegs = new Pegs();
		gameboard = new GameBoard();
		GAMEWON = false;
		history = new ArrayList<String>();
		TESTMODE = testmode;
	}
	
	public void restartGame(){
		secretCode = SecretCodeGenerator.getInstance().getNewSecretCode();
		guessNumber = GameConfiguration.guessNumber;
		pegs = new Pegs();
		gameboard = new GameBoard();
		GAMEWON = false;
		history = new ArrayList<String>();
	}
	
	// asks user for a guess and decides whether it's a valid guess
//	public boolean nextGuess(Scanner sc){
//		String guess;
//		boolean validGuess = false;
//		
//		// prints number of guesses left
//		System.out.print("You have " + guessNumber);
//		if(guessNumber == 1)
//			System.out.println(" guess left.");
//		else 
//			System.out.println(" guesses left.");
//		
//		// keeps asking for input until user inputs valid guess
//		while(validGuess != true){
//			System.out.println("What is your next guess?");
//			System.out.println("Type in the characters for your guess and press enter.");
//			System.out.print("Enter guess: ");
//			guess = sc.nextLine();
//
//			if(guess.equals("HISTORY")) {
//				printHistory();
//			}
//			else if(checkIfValid(guess)){  // only if valid 
//				//getPegs(guess);
//				currentGuess = guess;
//				validGuess = true;
//				guessNumber--;
//			}
//			else {
//				System.out.println("  -> INVALID GUESS\n");
//			}
//		}
//		
//		return validGuess;
//	}
//	
//	// checks if user input guess is valid
//	public boolean checkIfValid(String guess){
//		
//		// if length of guess not equal to secretCode, invalid guess 
//		if(guess.length() != secretCode.length()) 
//			return false;
//		
//		String[] guessArray = guess.split(""); // splits user guess into string array to compare with colors array
//		boolean containsGuessColor;
//		
//		// check if guess contains valid color values
//		for(String a : guessArray) {
//			containsGuessColor = Arrays.stream(GameConfiguration.colors).anyMatch(a::equals); // compares each guess letter to see if it is a valid color
//			if(containsGuessColor == false)
//				return false;
//		}
//		
//		return true; // if guess passes length and valid colors test, its a valid guess
//	}

	// prints game intro
	public void printIntro() {
		System.out.print(INTRO);
	}
	
	// prints history when user asks for it
	public void printHistory() {
		System.out.println();
		for(String a : history){
			System.out.println(a);
		}
		System.out.println();
	}
	
	public boolean getTestMode(){
		return TESTMODE;
	}
	
	public boolean getGameStatus(){
		return GAMEWON;
	}
	
	public void setGameStatus(boolean setGameStatus){
		GAMEWON = setGameStatus;
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
	
	public ArrayList<String> getHistory(){
		return history;
	}
	
	public void setCurrentGuess(String guess) {
		currentGuess = guess;
	}
	
	public String getCurrentGuess() {
		return currentGuess;
	}
	
	public Pegs getPegs() {
		return pegs;
	}
	
	public GameBoard getGameBoard() {
		return gameboard;
	}
	
}
