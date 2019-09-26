/* EE422C Assignment #2 submission by
 * <Rithvik Baddam>
 * <UT EID: rrb2442>
 */

package assignment2;

import java.util.ArrayList;

public class Game {
	private String secretCode;
	private String currentGuess;
	private boolean GAMEWON;
	private boolean TESTMODE;
	private Pegs pegs;
	private GameBoard gameboard;
	private ArrayList<String> history;
	
	
	private static final String INTRO = "Welcome to Mastermind.  Here are the rules.\n"
			+ "\nThis is a text version of the classic board game Mastermind.\n"
			+ "\nThe  computer  will  think  of  a  secret  code.  The  code  consists  of  4\n"
			+ "colored  pegs. The  pegs  MUST  be  one  of  six  colors:  blue,  green,\n"
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
			+ "Red, and so forth. When entering guesses you only need to enter the\n"
			+ "first character of each color as a capital letter.\n"
			+ "\nYou have 12 guesses to figure out the secret code or you lose the\n"
			+ "game.  Are you ready to play? (Y/N):  ";
	
	public Game(boolean testmode){
		secretCode = SecretCodeGenerator.getInstance().getNewSecretCode();
		pegs = new Pegs();
		gameboard = new GameBoard();
		GAMEWON = false;
		history = new ArrayList<String>();
		TESTMODE = testmode;
	}
	
	public void restartGame(){
		secretCode = SecretCodeGenerator.getInstance().getNewSecretCode();
		pegs = new Pegs();
		gameboard = new GameBoard();
		GAMEWON = false;
		history = new ArrayList<String>();
	}

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
