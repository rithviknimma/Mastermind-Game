/* EE422C Assignment #2 submission by
 * <Rithvik Baddam>
 * <UT EID: rrb2442>
 */

package assignment2;

import java.util.ArrayList;

public class Pegs {
	private int totalPegNumber;
	private int blackPegs;
	private int whitePegs;
	
	public Pegs() {
		totalPegNumber = GameConfiguration.pegNumber;
	}
	
	
	public void setBlackpegs(int Pegs) {
		blackPegs = Pegs;
	}
	
	public void setWhitepegs(int Pegs) {
		whitePegs = Pegs;
	}
	
	// calculates pegs given a guess for a secret code
	public void calculatePegs(String guess, String secretCode, Game game) {
		int blackPeg = 0;
		int whitePeg = 0;
		String[] guessArray;
		String[] secretCodeArray;
		
		// arraylists to check for white pegs
		ArrayList<String> guessArrayColors = new ArrayList<String>(); // does not contain duplicate colors
		ArrayList<String> secretCodeArrayColors = new ArrayList<String>();
		
		guessArray = guess.split("");
		secretCodeArray = secretCode.split("");
			
		// if guess string contains any colors in the same position as secret code, record black pegs
		for(int i = 0; i < guess.length(); i++){
			if(guessArray[i].equals(secretCodeArray[i])){
				blackPeg++;
			}
			else { // if color if not a black peg, record it to check if it is white
				//if(guessArrayColors.contains(guessArray[i]) == false)
					guessArrayColors.add(guessArray[i]);
					
				secretCodeArrayColors.add(secretCodeArray[i]);
			}
		}
			
		// if secret code contains colors from the guess, record white peg
		for(String a : guessArrayColors) {
			if(secretCodeArrayColors.contains(a))
				whitePeg++;
		}
			
		// set black and white pegs
		setBlackpegs(blackPeg);
		setWhitepegs(whitePeg);
			
		// record game history
		if(guess.equals("HISTORY") != true) {
			game.getHistory().add(guess+" "+blackPegs+"B_"+whitePegs+"W");
		}
		
	}

	// prints pegs on console and sets game status if user wins game by guessing correctly
	public void printPegs(String guess, Game game){
		System.out.print("\n"+ guess + " -> Result:  " );
		if(blackPegs != 0 || whitePegs != 0){
			if(blackPegs > 0) {
				if(blackPegs == 1)
					System.out.print(blackPegs + " black peg");
				else
					System.out.print(blackPegs + " black pegs");
			}
			if(blackPegs == totalPegNumber) { // GAME WON
				System.out.print(" - You win !!");
				game.setGameStatus(true);
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
		System.out.println();
	}

}
