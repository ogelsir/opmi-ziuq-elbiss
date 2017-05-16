
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
    
    public boolean interactable(){
        if(pRow > 0){//above
            if(grid[pRow-1][pCol] != null && grid[pRow-1][pCol].indexOf("interact") != -1){
                return true;
            }
        }
        if(pRow < grid.length-1){//below
            if(grid[pRow+1][pCol] != null && grid[pRow+1][pCol].indexOf("interact") != -1){
                return true;
            }
        }
        if(pCol > 0){//left
            if(grid[pRow][pCol-1] != null && grid[pRow][pCol-1].indexOf("interact") != -1){
                return true;
            }
        }
        if(pCol < grid[0].length-1){//right
            if(grid[pRow][pCol+1] != null && grid[pRow][pCol+1].indexOf("interact") != -1){
                return true;
            }
        }
        return false;
    }
    public String[][] getGrid(){
        return grid;
    }
}
