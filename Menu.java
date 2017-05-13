import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.io.PrintStream;
/**
 * @author Felix Yan 
 * @version 5/10/17
 */
public class Menu extends JFrame 
{
    private Grid grid;
    private Graphics g;
    private ArrayList <String> inventory;
    private String helpText = "How to play:\n" + "W, A, S, D to move\n" + "E to interact when available\n" + "Q to open inventory\n" + "ESC to quit game";
    public Menu()
    {
        // window
        super("GridQuest");
        //setPreferredSize(new Dimension(400,400));
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container content = getContentPane();
        content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS));
        //Game Stuff
        inventory = new ArrayList <String> ();
        grid = new Grid(5,4);
        g = new Graphics(grid.getGrid());
        grid.set("player",4,0);
        grid.set("tree",1,1);
        grid.set("tree2",2,1);
        grid.set("tree3",2,2);
        g.drawGrid();
        add(new Keyboard(grid, g));
        //console output
        JTextArea textOutput = new JTextArea(15,40);
        textOutput.setEditable(false);
        textOutput.setLineWrap(true);
        PrintStream out = new PrintStream(new Console(textOutput));
        System.setOut(out);
        System.setErr(out);
        System.out.println(helpText);
        textOutput.setCaretPosition(textOutput.getDocument().getLength());
        JScrollPane scroll = new JScrollPane(textOutput);
        
        add(scroll);
        //textfield
        JTextField input = new JTextField(3);
        add(input);
        pack();
        setVisible(true);
    }
    
}
