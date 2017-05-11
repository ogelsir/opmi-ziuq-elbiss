import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
/**
 * @author Felix Yan 
 * @version 5/10/17
 */
public class Input extends JFrame implements KeyListener
{
    private Grid grid;
    private Graphics g;
    private ArrayList <String> inventory;
    public Input()
    {
        //input window
        super("Keyboard Input");
        setSize(300,300);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
               
        addKeyListener(this);
        //Game Stuff
        inventory = new ArrayList <String> ();
        grid = new Grid(5,4);
        g = new Graphics(grid.getGrid());
        grid.set("player",4,0);
        grid.set("tree",1,1);
        grid.set("tree2",2,1);
        grid.set("tree3",2,2);
        g.drawGrid();
    }
    public void keyReleased(KeyEvent e){
        //not used
    }
    public void keyTyped(KeyEvent e){
        //not used
    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if(key == e.VK_W){
            //moves up
            grid.up();
            g.drawGrid();
        }
        if(key == e.VK_A){
            //moves left
            grid.left();
            g.drawGrid();
        }
        if(key == e.VK_S){
            //moves down
            grid.down();
            g.drawGrid();
        }
        if(key == e.VK_D){
            //moves right
            grid.right();
            g.drawGrid();
        }
        if(key == e.VK_Q){
            //prints inventory
            if(inventory.size() == 0){
                System.out.println("Inventory Empty!");
            }else{
                System.out.println("Inventory:");
                for(int loop = 0; loop < inventory.size(); loop++){
                    System.out.println(inventory.get(loop));
                }
            }
        }
    }
}
