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
    private Graphics g;
    private Movement m;
    //indexs for moving hanoi disks
    private int from;
    private int to;
    //hanoi
    private Hanoi h = new Hanoi(4);
    private boolean gameOver = false;
    private boolean moveResult;
    private String error;
    private boolean hanoi = false;
    //riddle
    private boolean firstTimeRiddle = true;
    //position stuff
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
    public void setGraphics(Graphics graphics){
        g = graphics;
    }
    public void setMovement(Movement movement){
        m = movement;
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
                    System.out.println("You examine the Old Relic, it appears to have odd writing scribbled on it...");
                    System.out.println("");
                    System.out.println("---------------------------------------------------------------------------------------");
                    System.out.println("");
                    g.drawGrid();
                }else{
                    System.out.println("The Chest is locked! It looks like you need a key conveniently buried in the dirt by a tree nearby...");
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
                if(pRow < iRow && !hanoi){//prevents shenenigans
                    grid[pRow][pCol] = null;
                    set("player",iRow+1,pCol);
                    g.drawGrid();
                }else{
                    if(!hanoi){
                        grid[pRow][pCol] = null;
                        set("player",iRow-1,pCol);
                        g.drawGrid();
                    }
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
                System.out.println("---------------------------------------------------------------------------------------");
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
        if(grid[iRow][iCol].indexOf("temple") != -1){
            hanoi = true;
            set("tree1",0,2);//used to block moving
            startHanoi();
        }
    }
    public void startHanoi(){
        g.setHanoi(h);
        g.stop();
        boolean hasRelic = false;
        for(int loop = 0; loop < inventory.size(); loop++){
            if(inventory.get(loop).equals("Old Relic")){
                hasRelic = true;
            }
        }
        if(hasRelic){
            System.out.println("You enter the temple. You see a pedestal in the middle, and on the walls there are ancient writings reminiscent of an ancient civilization.");
            System.out.println("");
            System.out.print("You notice that the Old Relic you got from the chest earlier has similar writing on it, so you use it to decode the ancient language. ");
            System.out.println("The writings read: TOWER OF HANOI");
            System.out.println("");
            System.out.println("You approach the pedestal, there lie three pegs with four disks.");
            System.out.println("");
        }else{
            System.out.println("You enter the temple. You see a pedestal in the middle, and on the walls there are ancient writings reminiscent of an ancient civilization.");
            System.out.println("");
            System.out.println("Unfortunately, you can't seem to make out what the ancient language reads.");
            System.out.println("");
            System.out.println("You approach the pedestal, there lie three pegs with four disks.");
            System.out.println("");
        }
        //creates text input
        input.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                boolean works = true;
                try{
                    from = Integer.parseInt(e.getActionCommand().substring(0,1));
                    to = Integer.parseInt(e.getActionCommand().substring(2));
                }catch(Exception ex){
                    works = false;
                    System.out.println("Incorrect input format, try again!");
                }
                if(works){
                    moveResult = h.move(from,to);
                    doHanoi();
                }else{
                    works = true;
                }
                input.requestFocus();
            }
        });
        System.out.println("Input in format \"1,1\" to perform action");
        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("");
        input.requestFocusInWindow();
        g.drawHanoi();
    }
    public void doHanoi(){
        if(!h.isGameOver()){
            g.drawHanoi();
            if(moveResult){
                System.out.println("You successfully moved a disk from Peg #" + from + " to Peg #" + to);
                System.out.println("");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("");
                input.requestFocusInWindow();
            }else{
                if(h.errorMessage().equals("false")){
                    System.out.println("You try to move a disk from Peg #" + from + " to Peg #" + to + ", but it doesn't budge.");
                    System.out.println("");
                    System.out.println("---------------------------------------------------------------------------------------");
                    System.out.println("");
                    h.resetError();
                }else{
                    if(h.errorMessage().equals("empty")){
                        System.out.println("You try to move a disk from Peg #" + from + ", but there isn't anything there.");
                        System.out.println("");
                        System.out.println("---------------------------------------------------------------------------------------");
                        System.out.println("");
                        h.resetError();
                    }else{
                        if(h.errorMessage().equals("same")){
                            System.out.println("You try to move a disk from Peg #" + from + " to Peg #" + to + ", but its already there.");
                            System.out.println("");
                            System.out.println("---------------------------------------------------------------------------------------");
                            System.out.println("");
                            h.resetError();
                        }else{
                            //if h.errorMessage().equals("outside")
                            System.out.println("You reach out to move a disk, but you reach too far to one side and miss.");
                            System.out.println("");
                            System.out.println("---------------------------------------------------------------------------------------");
                            System.out.println("");
                            h.resetError();
                        }
                    }
                }
            }
        }else{
            grid[iRow][iCol] = "nothing";
            g.drawHanoi();
            removeListener();
            input.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                    g.drawEnd1();
                }
            });
            System.out.println("As you slide the last disk from Peg #" + from + " to Peg #" + to + ", the disks sink into the pedestal as it lights up brightly... (Type anything to continue)");
            System.out.println("");
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("");
            
        }
    }
    public void removeListener(){
        ActionListener[] temp = input.getActionListeners();
        input.removeActionListener(temp[0]);
    }
    public void addEndListener(){
        input.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                    g.drawEnd2();
                }
            });
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
