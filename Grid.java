import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.lang.Math;
/**
 * @author Felix Yan
 * @version 5/9/17
 */
public class Grid
{
    private String[][] grid;
    private ArrayList <String> inventory;
    private JTextField input;
    private boolean firstTimeRiddle = true;
    private int pRow;//player row position
    private int pCol;//player col position
    private int iRow;//interactable row
    private int iCol;//interactable col
    public Grid(int row, int col, ArrayList <String> i, JTextField in)
    {
        grid = new String[row][col];
        inventory = i;
        input = in;
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
                    System.out.println("---------------------------------------------------------------------------------------");
                    System.out.println("");
                }else{
                    System.out.println("The Chest is locked! It looks like you need a key...");
                    System.out.println("");
                    System.out.println("---------------------------------------------------------------------------------------");
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
        if(grid[iRow][iCol].indexOf("bridge") != -1){
            if(grid[iRow][iCol].indexOf("opened") != -1){
                if(pRow < iRow){
                    grid[pRow][pCol] = null;
                    set("player",iRow+1,pCol);
                }else{
                    grid[pRow][pCol] = null;
                    set("player",iRow-1,pCol);
                }
            }else{
                boolean fee = false;
                for(int loop = 0; loop < inventory.size(); loop++){
                    if(inventory.get(loop).equals("Silver Coin")){
                        inventory.remove(loop);
                        fee = true;
                    }
                }
                if(fee){
                    grid[iRow][iCol] = "bridgeinteractableopened";
                    System.out.println("Thank you for your payment, you may pass!");
                    System.out.println("(Interact with Bridge to pass)");
                    System.out.println("");
                    System.out.println("---------------------------------------------------------------------------------------");
                    System.out.println("");
                }else{
                    System.out.println("You don't have payment! Go away!");
                    System.out.println("");
                    System.out.println("---------------------------------------------------------------------------------------");
                    System.out.println("");
                }
            }
        }
        if(grid[iRow][iCol].indexOf("riddle") != -1){
            if(grid[iRow][iCol].indexOf("answered") != -1){
                System.out.println("Gah! I can't think of a riddle to stump you...");
                System.out.println("");
            }else{
                if(firstTimeRiddle){
                    System.out.println("See if you can guess my riddle, the reward will be a Silver Coin!");
                    firstTimeRiddle = false;
                }else{
                    System.out.println("Back for more? Let's see if you can guess my new riddle...");
                }
                System.out.println("");
                input.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        String x = e.getActionCommand();
                        riddleGuess(x);
                    }
                });
                runRiddle(); 
                input.requestFocusInWindow();
            }
        }
    }
    public String[][] getGrid(){
        return grid;
    }
    private ArrayList <String> riddles;//the riddles documents has a riddle and then an answer each line 
    private ArrayList <String> answers;
    Scanner in;
    private int index;
    private String riddle;
    private boolean guessedRight;
    public void runRiddle()
    {
        try{//checks if the document exists(it should -_-)
            in = new Scanner(new File("files/riddles.txt"));
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        riddles = new ArrayList <String> ();
        answers = new ArrayList <String> ();
        while(in.hasNext()){
            riddles.add(in.nextLine());//alternates each line
            answers.add(in.nextLine());
        }
        index = (int)(Math.random()*riddles.size());  
        System.out.println(riddles.get(index));
        riddle = riddles.get(index);
        System.out.println("a(n) ");
        System.out.println("");
        
    }
    public void riddleGuess(String x){
        if(x.equals(answers.get(index))){
            guessedRight = true;
        }else{
            guessedRight = false;
        }
        result();
    }
    public void result(){
        ActionListener[] temp = input.getActionListeners();
        input.removeActionListener(temp[0]);
        if(guessedRight){
            System.out.println("Correct Answer! As your reward here's a Silver Coin!");
            System.out.println("");
            System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("");
            inventory.add("Silver Coin");
            grid[iRow][iCol] = "riddleinteractableanswered";
        }else{
            System.out.println("Wrong Answer! Maybe next time I'll give you an easier riddle...");
            System.out.println("The answer was: " + answers.get(index));
            System.out.println("");
            System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("");
        }        
    }
}
