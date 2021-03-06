import java.util.ArrayList;

/**
 * data class for a towers of hanoi minigame
 * 
 * @author Oliver Jiang
 * @version 5/20/17
 */
public class Hanoi
{
    private ArrayList<Integer> peg1;
    private ArrayList<Integer> peg2;
    private ArrayList<Integer> peg3;
    private int numDisks;
    private String error;
    /**
     * constructs a Hanoi game
     * @param numDisks the number of disks in the game
     * Postcondition: all of the disks are in peg1, none are in peg2 or peg3
     */
    public Hanoi(int myNumDisks)
    {
        peg1 = new ArrayList<Integer>();
        peg2 = new ArrayList<Integer>();
        peg3 = new ArrayList<Integer>();
        numDisks = myNumDisks;
        for(int n = 1; n <= myNumDisks; n++)
        {
            peg1.add(n);
        }
    }
    
    /**
     * move the topmost disk (smallest number) from peg-a to peg-b
     * does not move if the topmost disk in peg-b is larger than the topmost disk in peg-a
     * @param a = int 1,2, or 3 representing the peg to remove a disk from
     * @param b = int 1,2, or 3 representing the peg to add a disk to
     * @return true if a move was made, false otherwise
     */
    public boolean move(int a, int b)
    {
        if(!canMove(a, b))
        {   return false;}
        ArrayList startPeg;   // peg that gets a disk removed
        ArrayList endPeg;     // peg that gets a disk added
        if(a == 1)
        {   startPeg = peg1;}
        else if(a == 2)
        {   startPeg = peg2;}
        else
        {   startPeg = peg3;}
        
        if(b == 1)
        {   endPeg = peg1;}
        else if(b == 2)
        {   endPeg = peg2;}
        else
        {   endPeg = peg3;}
        Integer startDisk = (Integer)startPeg.remove(0);
        endPeg.add(0,startDisk);
        return true;
    }
    
    /**
     * checks if the move of the topmost disk (smallest number) from peg-a to peg-b is legal
     * cannot move if the topmost disk in peg-b is larger than the topmost disk in peg-a
     * @param a = int 1,2, or 3 representing the peg to remove a disk from
     * @param b = int 1,2, or 3 representing the peg to add a disk to
     * @return true if a move is legal, false otherwise
     */
    public boolean canMove(int a, int b)
    {
        ArrayList startPeg;   // peg that gets a disk removed
        ArrayList endPeg;     // peg that gets a disk added
        if(a == b){//added by Felix
            error = "same"; return false;
        }
        if(a == 1)
        {   startPeg = peg1;}
        else if(a == 2)
        {   startPeg = peg2;}
        else if(a == 3)
        {   startPeg = peg3;}
        else
        { error = "outside"; return false;}
        
        
        if(startPeg.size() == 0)
        {   error = "empty"; return false;}
        
        if(b == 1)
        {   endPeg = peg1;}
        else if(b == 2)
        {   endPeg = peg2;}
        else if(b == 3)
        {   endPeg = peg3;}
        else //added error message if inputted number is too large
        { error = "outside"; return false;}
        
        Integer startDisk = (Integer)startPeg.get(0);
        if(endPeg.size() != 0)
        {
            Integer endDisk = (Integer)endPeg.get(0);
            if(startDisk > endDisk)
            { error = "false"; return false;}
        }
        return true;
    }
    
    /**
     * Added by Felix Yan, added lines in the code that makes text more aesthetic 
     */
    public String errorMessage(){
        return error;
    }
    public void resetError(){
        error = "";
    }
    
    /**
     * checks if the game is over
     * game is over if all of the disks are moved to peg2 or peg3
     */
    public boolean isGameOver()
    {
        boolean gameOver = true;
        if(peg2.size() == numDisks){        // all pegs are on peg2
            for(int m = 1; m <= numDisks; m++)
            {
                if(peg2.get(m-1) != m)
                {   gameOver = false;}
            }
        }
        else if(peg3.size() == numDisks){                               // all pegs are on peg3
            for(int m = 1; m <= numDisks; m++)
            {
                if(peg3.get(m-1) != m)
                {   gameOver = false;}
            }
        }
        else
        {   gameOver = false;}
        return gameOver;
    }
    
    /**
     * getter methods
     */
    public ArrayList<Integer> getPeg1(){
        return peg1;
    }
    public ArrayList<Integer> getPeg2(){
        return peg2;
    }
    public ArrayList<Integer> getPeg3(){
        return peg3;
    }
    
    /**
     * method to print out the contents of the pegs for testing purposes
     */
    public void visualize()
    {
        System.out.print("1. ");
        for(int i = peg1.size()-1; i >= 0; i--)
        {   System.out.printf("%3d  ", (int)peg1.get(i));}
        System.out.print("\n2. ");
        for(int i = peg2.size()-1; i >= 0; i--)
        {   System.out.printf("%3d  ", (int)peg2.get(i));}
        System.out.print("\n3. ");
        for(int i = peg3.size()-1; i >= 0; i--)
        {   System.out.printf("%3d  ", (int)peg3.get(i));}
    }
}
