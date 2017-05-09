import java.util.ArrayList;

/**
 * the Environment represents the "pixels" in the menu
 * 
 * @author Oliver Jiang 
 * @version 5/9/17
 */
public class Environment
{
    private char[][] grid;
    private ArrayList<Thing> things;
    
    public Environment(int rows, int cols)
    {
        things = new ArrayList<Thing>();
        grid = new char[rows][cols];
        for(char[] r : grid)
        {
            for(char c : r)
            {
                c = ' ';
            }
        }
    }
    
    public void addThing(Thing t)
    {
        if(0 <= t.getRow() && t.getRow() < grid.length
        && 0 <= t.getCol() && t.getCol() < grid[0].length)
        {   things.add(t);}
    }
}
