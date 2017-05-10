
/**
 *  
 * @author Felix Yan
 * @version 5/9/17
 */
public class Environment2
{
    private String[][] grid;
    public Environment2(int row, int col)
    {
        grid = new String[row][col];
    }
    public void set(String x, int row, int col)
    {
        grid[row][col] = x;
    }
    public String[][] getGrid(){
        return grid;
    }
}
