import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Dimension;
/**
 * @author Felix Yan 
 * @version 5/10/17
 */
public class Menu extends JFrame 
{
    private Grid grid;
    private Graphics g;
    private ArrayList <String> inventory;
    private String helpText = "Instructions:\n" + "W,A,S,D to move\n" + "E to interact when available\n" + "Q to open inventory";
    public Menu()
    {
        // window
        super("Click Here!");
        setPreferredSize(new Dimension(300,300));
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Game Stuff
        inventory = new ArrayList <String> ();
        grid = new Grid(5,4);
        g = new Graphics(grid.getGrid());
        grid.set("player",4,0);
        grid.set("tree",1,1);
        grid.set("tree2",2,1);
        grid.set("tree3",2,2);
        g.drawGrid();
        //window stuff
        JTextArea instructions = new JTextArea(helpText);
        instructions.setFont(new Font("Segoe UI",0,15));
        instructions.setEditable(false);
        add(new Keyboard(grid, g));//ask sos about layering jcomponents? bug?
        add(instructions);
        pack();
        setVisible(true);
    }
    
}
