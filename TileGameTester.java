
package NumerTileGame;

import NumerTileGame.Hand;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Mohamed Elmurtada Baker
 * NumberTileGame
 * I affirm that this program is entirely my own work and none of it is the 
 * work of any other person.
 * 
 */
public class TileGameTester {
    
    /**
     * 
     * @param args 
     * @throws IOException 
     */
    public static void main(String[] args)throws IOException {
        String ans;
        do {
            System.out.println("Starting a new game...");
            Hand player1 = new Hand();
            Hand player2 = new Hand();
            TileGame game = new TileGame(player1, player2);
            System.out.println("***** Player 1 Initial Hand *****");
            System.out.println(player1.toString());
            System.out.println("***** Player 2 Initial Hand *****");
            System.out.println(player2.toString());
            //Play the game
            game.play();
            //Printout the game
            System.out.println(game.getResults());
            System.out.println("\n Another game?? \n");
            BufferedReader reader = new BufferedReader(new InputStreamReader(
            System.in));
            ans = reader.readLine();
        } while (ans.equalsIgnoreCase("YES"));
    }
}

