
package NumerTileGame;

/**
 * Mohamed Elmurtada Baker
 * NumberTileGame
 * I affirm that this program is entirely my own work and none of it is the 
 * work of any other person.
 * 
 */

/**
 * @param: Board the board for the NumberTile game 
 */

public class Board
{
    private NumberTile [] board ;   // the board for the game
    private int boardSize ;         // current number of tiles on the board
    private static final int MAX_BOARD = 100 ;  // maximum number of tiles
    
    /**
     * @param: Board creates a new Board that can hold up to MAX_BOARD tiles
     * that contains a single NumberTile
     */
    
    public Board()
    {
        boardSize = 1;
        board = new NumberTile[boardSize];
        board[boardSize-1] = new NumberTile();
    }
    
    /**
     * @param index
     * @return 
     * @param: getTile returns the NumberTile at the specified index on this 
     * Board
     */
    
    public NumberTile getTile (int index)
    {
       if(index < 0 || index > getSize() -1)
       {
           return null;
       }
       return board[index];
    }
    
    /**
     * @return 
     * @param: getSize returns the current number of tiles on this Board
     */
    
    public int getSize()
    {
       return boardSize;
    }
    
    /**
     * @param index
     * @param tile
     * @param: addTile insert a new tile into this Board at the specified index
     */
    
    public void addTile(int index, NumberTile tile)
    {
        NumberTile[] temp = new NumberTile[boardSize + 1];
        temp[index]=tile;
        
        for(int i=0, j=0; i < boardSize; j++)
        {
            if(temp[j]==null)
            {
                temp[j]=board[i];
            }
        }
        
        boardSize++;
        board = new NumberTile[boardSize];
        for(int i=0; i<boardSize; i++)
        {
            board[i] = temp[i];
        }
    }
    
    /**
     * @return 
     * @param: toString returns a multiline string containing all the tiles on 
     * this Board
     */
    
    public String toString()
    {
       String multi = new String();
        for(int i=0; i<getSize(); i++)
        {
            String str = board[i].toString();
            multi = multi.concat(str);
        }
        return multi;
    }           
}
