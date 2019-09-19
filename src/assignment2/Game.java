package assignment2;

public class Game {
	private static String secretCode;
	private static int guessNumber;
	private static int pegNumber;
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
	}
	
	public void restartGame(){
		secretCode = SecretCodeGenerator.getInstance().getNewSecretCode();
		guessNumber = GameConfiguration.guessNumber;
		pegNumber = GameConfiguration.pegNumber;
	}
	
	public void setTestMode(boolean set){
		TESTMODE = set;
	}
	
	public boolean getTestMode(){
		return TESTMODE;
	}
	
	public String getSecretCode() {
		return secretCode;
	}
	
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
