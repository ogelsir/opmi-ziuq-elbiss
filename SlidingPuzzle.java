import java.util.Collections;
import java.util.ArrayList;

/**
 * data class for a sliding puzzle
 * ex: https://en.wikipedia.org/wiki/Sliding_puzzle
 * probably for a lock?
 * 
 * @author Oliver Jiang
 * @version 5/19/17
 */
public class SlidingPuzzle
{
    private int[][] game;
    private int emptyR;   // stores row of the empty tile
    private int emptyC;   // stores col of the empty tile
    
    /**
     * constructor
     * Postcondition: game is filled with [0,numRows*numCols)
     * Postcondition: emptyR and emptyC are the coordinates of the last tile, which holds 0
     */
    public SlidingPuzzle(int numRows, int numCols)
    {
        game = new int[numRows][numCols];
        ArrayList temp = new ArrayList<Integer>();
        for(int n = 0; n < numRows*numCols; n++)
        {   temp.add(n);}
        int n = 0;
        for(int r = 0; r < game.length; r++)
        {
            for(int c = 0; c < game[r].length; c++)
            {
                game[r][c] = (int)temp.get(n);
                n++;
            }
        }
         emptyR = numRows-1;
         emptyC = numCols-1;
         swap(0, game[emptyR][emptyC]);
    }
    
    /**
     * default constructor
     * numRow and numCol are 3
     */
    public SlidingPuzzle()
    {
        int numRows = 3; 
        int numCols = 3;
        game = new int[numRows][numCols];
        ArrayList temp = new ArrayList<Integer>();
        for(int n = 0; n < numRows*numCols; n++)
        {   temp.add(n);}
        int n = 0;
        for(int r = 0; r < game.length; r++)
        {
            for(int c = 0; c < game[r].length; c++)
            {
                game[r][c] = (int)temp.get(n);
                n++;
            }
        }
         emptyR = numRows-1;
         emptyC = numCols-1;
         swap(0, game[emptyR][emptyC]);
    }
    
    /**
     * Precondition: tile is in game
     * moves a tile if it next to an empty tile
     * @return true if it moved
     * @return false if not
     */
    public boolean move(int tile)
    {
        if(!nextToEmpty(tile))
        {   return false;}
        else
        {
            swap(tile, 0);
            return true;
        }
    }
    
    /**
     * checks if a given tile is next to the empty tile
     * @return true if it is next to, false otherwise
     */
    public boolean nextToEmpty(int tile)
    {
        if(tile == 0)
        {   return false;}
        int myR = -1; int myC = -1;
        for(int r = 0; r < game.length; r++)
        {
            for(int c = 0; c < game[r].length; c++)
            {
                if(game[r][c] == tile)
                {
                    myR = r;
                    myC = c;
                }
            }
        }
        if(myC == emptyC
           && Math.abs(myR - emptyR) == 1)
        {   return true;}
        else if(myR == emptyR
                && Math.abs(myC - emptyC) == 1)
        {   return true;}
        else
        {   return false;}
    }
    
    /**
     * swaps tile1 and tile2
     * Precondition: tile1 and tile2 are in game and game has been instantiated properly
     */
    public void swap(int tile1, int tile2)
    {
        int r1 = -1;
        int c1 = -1;
        int r2 = -1;
        int c2 = -1;
        for(int r = 0; r < game.length; r++)
        {
            for(int c = 0; c < game[r].length; c++)
            {
                if(game[r][c] == tile1)
                {
                    r1 = r;
                    c1 = c;
                }
                else if(game[r][c] == tile2)
                {
                    r2 = r;
                    c2 = c;
                }
            }
        }
        game[r1][c1] = tile2;
        game[r2][c2] = tile1;
    }
    
    /**
     * the game is over when all the tiles are in order
     * the game is in order when game is filled from [1,numRows*numCols-1] and 0 in the last (bottom right) tile
     * @return true if game is over, false otherwise
     */
    public boolean isGameOver()
    {
        boolean temp = true;
        int n = 1;
        for(int r = 0; r < game.length; r++)
        {
            for(int c = 0; c < game[r].length; c++)
            {
                if(game[r][c] != n)
                {   temp = false;}
                n++;
            }
        }
        return temp;
    }
    
    /**
     * prints out the game in a human readable format for testing
     */
    public void visualize()
    {
        for(int r = 0; r < game.length; r++)
        {
            for(int c = 0; c < game[r].length; c++)
            {
                System.out.printf("%-3d", game[r][c]);
            }
            System.out.println();
        }
    }
}
