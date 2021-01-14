
package NumerTileGame;

/**
 * Mohamed Elmurtada Baker
 * NumberTileGame
 * I affirm that this program is entirely my own work and none of it is the 
 * work of any other person.
 * 
 */
import java.util.ArrayList;
import java.util.Random;


/**
 *  @param: NumberTile is a square tile with a number from 1 to 9 on each side
 */

public class NumberTile 
{
    private final int [] tile ;    // the 4-sided tile
            
    /**
     * @param: NumberTile() create a NumberTile object with 4 random ints in the 
     * range 1 to 9
     */
    
    public NumberTile() 
    {
         Random gen = new Random() ;  // DO NOT ERASE THIS DECLARATION
         int topNum = gen.nextInt(9)+1;
         int bottomNum = gen.nextInt(9)+1;
         int leftNum = gen.nextInt(9)+1;
         int rightNum = gen.nextInt(9)+1;
         
         tile = new int[4];
         tile[0] = leftNum;
         tile[1] = topNum;
         tile[2] = rightNum;
         tile[3] = bottomNum;
    }
    
    /**
     * @param: Rotate this rotates NumberTile 90 degrees
     */
    
    public void rotate() 
    {
       int temp = tile[0];
       tile[0] = tile[3];
       tile[3] = tile[2];
       tile[2] = tile[1];
       tile[1] = temp;
    }
    
    /**
     * @return 
     * @param: getLeft returns the number on the left side of this NumberTile
     */
    
    public int getLeft()
    {
    	
        return tile[0] ;
    }
    
    /**
     * @return 
     * @param: getRight Returns the number on the right side of this NumberTile
     */
    
    public int getRight() 
    {
        
        return tile[2] ;
    }
    
    // toString Return this NumberTile as a multiline string in the form:
    //     9
    //  3     7
    //     6
    //
    /**
     * @param: toString this Hand as a multi-line String.
     * If this Hand is empty, return an appropriate message
     * @return 
     */
    public String toString() 
    {
       String out = "\n" +
       " " +      tile[1] + " " + "\n" +
       tile[0] + " " +    tile[2] + "\n" +
       " " +      tile[3] + " " +
       "\n";          
       return out ;
    }    
} 
