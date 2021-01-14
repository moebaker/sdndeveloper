
package NumerTileGame;

import NumerTileGame.Hand;
import NumerTileGame.Board;

/**
 * Mohamed Elmurtada Baker
 * NumberTileGame
 * I affirm that this program is entirely my own work and none of it is the 
 * work of any other person.
 */
/** The main purpose of this class is to create the first two hands in the game
 * as well give instruction to play and make move for each player then get
 * result to show the winner.Implements a domino-like game where two players, 
 * both of whom are the computer, take turns inserting NumberTiles into a Board.
*/
public class TileGame {
    
    
   private final Board board ;     // the game board
   
   private final Hand hand1 ;      // Player 1 hand
   
   private final Hand hand2 ;      // Player 2 hand
   
   private String winner ;   // the winner - player1, player2,
                             // or a tie game
   
   /**
     * @param firstHand
     * @param secondHand
    * @param: TileGame is the players first and seconf hand and creates new
    * board
    */
   public TileGame(Hand firstHand, Hand secondHand)
   {
       hand1 = firstHand;
       
       hand2 = secondHand;      
       
       board = new Board();
      
   }
   
   /**
    * @param: Play makes a move for both hands 
    */
   public void play()
   {
      while(!hand1.isEmpty() && !hand2.isEmpty()) 
      {
          makeMove(hand1);
          makeMove(hand2);
      }      
   }

   /**
    * 
    * @param getIndexForFit new tile may be inserted either between 
    * two existing tiles, as the new first tile, or as the new last tile
    * the index at which a new tile will be inserted into the board, or -1 if 
    * the tile cannot be inserted.
    * @return 
    */
   private int getIndexForFit(NumberTile tile)
   {
       NumberTile leftTile, rightTile;
       for(int i=0; i<=board.getSize(); i++)
       {
           leftTile = board.getTile(i-1);
           rightTile = board.getTile(i);
               
           if( (leftTile == null || leftTile.getRight() == tile.getLeft()) &&
               (rightTile == null || rightTile.getLeft() == tile.getRight()))
           {
               return i;
           }
       }

       return -1;
   }

   /**
    * @param makeMove Checks consecutive tiles in the hand by calling method 
    * getIndexForFit() to see if one can be inserted into the board.  
    */
   private void makeMove(Hand hand)
   {
      int originalSize = hand.getSize();
      for(int i=0; i<hand.getSize(); i++)
      {
          NumberTile tile = hand.get(i);
          int index = getIndexForFit(tile);
          if(index < 0)
          {
            for(int j=0; j<3; j++)
            {
                tile.rotate();
                index = getIndexForFit(tile);
                if(index >= 0)
                    break;
            }
          }
          
          if(index >= 0)
          {
              board.addTile(index, tile);
              hand.removeTile(i);
              break;
          }
      }
      if(originalSize == hand.getSize())
      {
          hand.addTile();
      }
   }
   

   /**
    * 
     * @return 
    * @param: getResults gets the results of the game as a humongous multi-line 
    * String containing,the final board, both both player's final hands, 
    * and the winner.
    */
   public String getResults()
   {
 
       String finalString = "***** The Final Board *****";
       finalString = finalString.concat(board.toString());  
       
       finalString = finalString.concat("***** Player 1 Final Hand *****\n");
       finalString = finalString.concat(hand1.toString());
       
       finalString = finalString.concat("***** Player 2 Final Hand *****\n");
       finalString = finalString.concat(hand2.toString()); 
       if(hand1.isEmpty() && hand2.isEmpty())
       {
           finalString = finalString.concat("Game is tied\n");
       }
       else if(hand1.isEmpty())
       {
           finalString = finalString.concat("The Winner is Player 1\n");
       }
       else
       {
           finalString = finalString.concat("The Winner is Player 2\n");
       }       
       return finalString;
   }
}

