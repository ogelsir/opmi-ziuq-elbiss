import java.util.ArrayList;
/**
 * @author Felix Yan
 * @version 5/9/17
 */
public class Grid
{
    private String[][] grid;
    private ArrayList <String> inventory;
    private int pRow;//player row position
    private int pCol;//player col position
    private int iRow;//interactable row
    private int iCol;//interactable col
    public Grid(int row, int col,ArrayList <String> i)
    {
        grid = new String[row][col];
        inventory = i;
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
    
    public void setInteractable(int row, int col){
        iRow = row;
        iCol = col;
    }
    
    public boolean interactable(){
        if(pRow > 0){//above
            if(grid[pRow-1][pCol] != null && grid[pRow-1][pCol].indexOf("interact") != -1){
                setInteractable(pRow-1,pCol);
                return true;
            }
        }
        if(pRow < grid.length-1){//below
            if(grid[pRow+1][pCol] != null && grid[pRow+1][pCol].indexOf("interact") != -1){
                setInteractable(pRow+1,pCol);
                return true;
            }
        }
        if(pCol > 0){//left
            if(grid[pRow][pCol-1] != null && grid[pRow][pCol-1].indexOf("interact") != -1){
                setInteractable(pRow,pCol-1);
                return true;
            }
        }
        if(pCol < grid[0].length-1){//right
            if(grid[pRow][pCol+1] != null && grid[pRow][pCol+1].indexOf("interact") != -1){
                setInteractable(pRow,pCol+1);
                return true;
            }
        }
        return false;
    }
    public boolean specialCase(){
        if(pRow > 0){//above
            if(grid[pRow-1][pCol] != null && grid[pRow-1][pCol].indexOf("special") != -1){
                setInteractable(pRow-1,pCol);
                return true;
            }
        }
        if(pRow < grid.length-1){//below
            if(grid[pRow+1][pCol] != null && grid[pRow+1][pCol].indexOf("special") != -1){
                setInteractable(pRow+1,pCol);
                return true;
            }
        }
        if(pCol > 0){//left
            if(grid[pRow][pCol-1] != null && grid[pRow][pCol-1].indexOf("special") != -1){
                setInteractable(pRow,pCol-1);
                return true;
            }
        }
        if(pCol < grid[0].length-1){//right
            if(grid[pRow][pCol+1] != null && grid[pRow][pCol+1].indexOf("special") != -1){
                setInteractable(pRow,pCol+1);
                return true;
            }
        }
        return false;
    }
    public void interact(){
        if(grid[iRow][iCol].indexOf("chest") != -1){
            if(grid[iRow][iCol].indexOf("opened") != -1){
                System.out.println("Chest Empty!");
                System.out.println("");
            }else{
                boolean keyObtained = false;
                for(int loop = 0; loop < inventory.size(); loop++){
                    if(inventory.get(loop).equals("Old Key")){
                        inventory.remove(loop);
                        keyObtained = true;
                    }
                }
                if(keyObtained){
                    inventory.add("Old Relic");
                    grid[iRow][iCol] = "chestinteractableopened";
                    System.out.println("Chest Unlocked!");
                    System.out.println("You obtained: Old Relic");
                    System.out.println("You examine the Old Relic, it appears to fit into something...");
                    System.out.println("");
                }else{
                    System.out.println("The Chest is locked! It looks like you need a key...");
                    System.out.println("");
                }
            }
            
        }
        if(grid[iRow][iCol].indexOf("tree1") != -1){
            inventory.add("Old Key");
            grid[iRow][iCol] = "tree1";
            System.out.println("You rustle around the bushes and find an Old Key buried in the dirt.");
            System.out.println("You obtained: Old Key");
            System.out.println("You examine the Old Key, it appears to fit into a keyhole...");
            System.out.println("");
        }
    }
    public String[][] getGrid(){
        return grid;
    }
}
