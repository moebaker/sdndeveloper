
package NumerTileGame;


/**
 * Mohamed Elmurtada Baker
 * NumberTileGame
 * I affirm that this program is entirely my own work and none of it is the 
 * work of any other person.
 * 
 */

/**
 * @param:  Hand is the player's hand of NumberTiles
 */   

public class Hand{
                                    
    private NumberTile [] hand ;      //a player's hand of tiles
    private int handSize ;            //current number of tiles in the hand
    private static final int MAX_TILES = 50 ;     //maximum hand size
    private static final int INITIAL_SIZE = 5 ;   //starting hand size
                                  
    /**
     * @param: Hand Creates a new hand containing INITIAL_SIZE NumberTiles, but with a 
     * capacity of MAX_TILES
     */
    
    public Hand()
    {
        hand = new NumberTile[INITIAL_SIZE];
        for(int i=0; i<INITIAL_SIZE; i++)
        {
            hand[i] = new NumberTile();
        }   
        handSize = INITIAL_SIZE;
    }
       
    /**
     * @param index
     * @return 
     * @param: NumberTile gets the NumberTile at the specified index in this Hand
     */
    
    public NumberTile get(int index)
    {       
       return hand[index] ;
    }
    
    /**
     * @return 
     * @param: getSize gets the number of tiles in this Hand
     */
    
    public int getSize()
    {
       return handSize;
    }
    
    /**
     * @param: addTile adds a new NumberTile to this Hand
     */
    
    public void addTile()
    {
        NumberTile[] temp = new NumberTile[handSize + 1];
        for(int i=0; i< handSize; i++)
        {
            temp[i] = hand[i];
        }
        temp[handSize] = new NumberTile();
        handSize++;
        hand = new NumberTile[handSize];
        for(int i=0; i<handSize; i++)
        {
            hand[i] = temp[i];
        }
    }
    
    /**
     * @param index
     * @param: removeTile removes the NumberTile at the specified index from this Hand
     */
    
    public void removeTile(int index)
    {
        NumberTile[] temp = new NumberTile[handSize - 1];
        int tempIndex = 0;
        for(int i=0; i<handSize; i++)
        {
            if(i == index)
            {
                continue;
            }
            temp[tempIndex] = hand[i];                             
            tempIndex++;
        }
        handSize--;
        hand = new NumberTile[handSize];
        for(int i=0; i<handSize; i++)
        {
            hand[i] = temp[i];
        }
    }
    
    /** @param: isEmpty looks to find this hand is empty?
     * 
     * @return 
     */
    public boolean isEmpty()
    {
       return handSize == 0;
    }
    
    /**
     * @return 
     * @param: toString returns this Hand as a multiline String.
     * If this Hand is empty, return an appropriate message
     */
    

    
    public String toString()
    {
       if(isEmpty())
        {
            return "[The hand is empty]\n";
        }
        
        String multi = new String();
        for(int i=0; i<getSize(); i++)
        {
            String str = hand[i].toString();
            multi = multi.concat(str);
        }
        return multi;
    }
}


    

