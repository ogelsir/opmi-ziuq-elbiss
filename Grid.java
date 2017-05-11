
/**
 *  
 * @author Felix Yan
 * @version 5/9/17
 */
public class Grid
{
    private String[][] grid;
    int pRow;//player row position
    int pCol;//player col position
    public Grid(int row, int col)
    {
        grid = new String[row][col];
    }
    public void set(String x, int row, int col)
    {
        grid[row][col] = x;
        if(x.equals("player")){
            pRow=row;
            pCol=col;
        }
    }
    public void erase(int row, int col){
        grid[row][col] = null;
    }
    
    public void up(){
        if(pRow > 0 && grid[pRow-1][pCol] == null){
            grid[pRow][pCol] = null;
            set("player",pRow-1,pCol);
        }
    }
    public void left(){
        if(pCol > 0 && grid[pRow][pCol-1] == null){
            grid[pRow][pCol] = null;
            set("player",pRow,pCol-1);
        }
    }
    public void down(){
        if(pRow < grid.length-1 && grid[pRow+1][pCol] == null){
            grid[pRow][pCol] = null;
            set("player",pRow+1,pCol);
        }
    }
    public void right(){
        if(pCol < grid[0].length-1 && grid[pRow][pCol+1] == null){
            grid[pRow][pCol] = null;
            set("player",pRow,pCol+1);
        }
    }
    
    public String[][] getGrid(){
        return grid;
    }
}
