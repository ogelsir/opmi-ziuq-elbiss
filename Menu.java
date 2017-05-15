import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.PrintStream;
/**
 * @author Felix Yan 
 * @version 5/10/17
 */
public class Menu extends JFrame 
{
    private Grid grid;
    private Graphics g;
    private String help1 = "How to play:\n" + "W, A, S, D to move\n" + "E to interact when available\n";
    private String help2 = "Q to open inventory\n" + "ESC to quit game\n";
    private ArrayList <String> inventory;

    public Menu()
    {
        // window
        
        super("GridQuest");
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
        
        //inventory
        inventory = new ArrayList <String> ();
        inventory.add("Chest");
        
        //keyboard input
        Movement m = new Movement(grid,g,inventory);
        add(m);
        
        //console output
        JTextArea textOutput = new JTextArea(15,40);
        textOutput.setEditable(false);
        textOutput.setLineWrap(true);
        PrintStream out = new PrintStream(new Console(textOutput));
        System.setOut(out);
        System.setErr(out);
        System.out.println(help1 + help2);
        textOutput.setCaretPosition(textOutput.getDocument().getLength());
        JScrollPane scroll = new JScrollPane(textOutput);
        add(scroll);
        
        //textfield for input
        JTextField input = new JTextField("Movement disabled when typing here.");
        input.addFocusListener(new Focus(m));
        input.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                m.enable();
                String text = e.getActionCommand();
                input.setText("");
                //do whatever you need to do with text here!! Example: System.out.println(text);
                scroll.requestFocusInWindow();
            }
        });
        add(input);
        
        //final touches
        pack();
        setVisible(true);
    }
    
}
