
/**
 * represents objects in the environment
 * 
 * @author Oliver Jiang
 * @version 5/9/17
 */
public abstract class Thing
{
    private char[][] grid;
    private int rPos;
    private int cPos;
    
    public Thing(int rows, int cols, int myR, int myC)
    {
        grid = new char[rows][cols];
        rPos = myR;
        cPos = myC;
    }
    
    public void moveRow(int amt)
    {
        rPos += amt;
    }
    
    public void moveCol(int amt)
    {
        cPos += amt;
    }
    
    /* getters -------------------------- */
    
    public int getRow()
    {
        return rPos;
    }
    
    public int getCol()
    {
        return cPos;
    }
}
