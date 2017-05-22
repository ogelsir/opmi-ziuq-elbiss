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
    private String help1 = "How to play:\n" + "W, A, S, D to move\n" + "E to interact nearby (indicated by red exclamation)\n";
    private String help2 = "Q to print inventory\n" + "ESC to quit game\n";
    private ArrayList <String> inventory;
    final JTextField input = new JTextField("Movement disabled when typing here.");
    public Menu()
    {
        // window
        super("GridQuest");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container content = getContentPane();
        content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS));
        
        //inventory
        inventory = new ArrayList <String> ();
        
        //Game initialization
        grid = new Grid(6,7,inventory,input);
        g = new Graphics(grid.getGrid(),grid);
        grid.setGraphics(g);
        grid.set("player",5,0);
        //mountains
        grid.set("mountain1",1,0);
        grid.set("mountain2",2,0);
        grid.set("mountain3",2,1);
        grid.set("mountain2",2,2);
        grid.set("mountain1",3,1);
        //trees around mountains
        grid.set("tree1",1,1);
        grid.set("tree2",1,2);
        grid.set("tree3",2,3);
        grid.set("tree2",3,2);
        //trees near bottom + hidden key
        grid.set("tree1special",5,3);
        grid.set("tree3",5,4);
        
        //chest
        grid.set("chestinteractable",3,0);
        
        //riddle guy
        grid.set("riddleinteractable",5,6);
        
        //river
        grid.set("river",2,4);
        grid.set("bridgeinteractable",2,5);
        grid.set("river",2,6);
        
        //temple + hanoi game
        grid.set("templeinteractable",0,0);
        
        //draw grid for first time
        g.drawGrid();

        //console output
        JTextArea textOutput = new JTextArea(15,40);
        textOutput.setEditable(false);
        textOutput.setLineWrap(true);
        textOutput.setWrapStyleWord(true);
        PrintStream out = new PrintStream(new Console(textOutput));
        System.setOut(out);
        System.setErr(out);
        System.out.print(help1 + help2);
        System.out.println("\n---------------------------------------------------------------------------------------");
        System.out.println("");
        final JScrollPane scroll = new JScrollPane(textOutput);
        add(scroll);
        
        //keyboard input
        final Movement m = new Movement(grid,g,inventory);
        add(m);
        
        //textfield for input
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
        this.setLocation(950,200);
        this.setSize(375,300);
        //pack();
        setVisible(true);
    }
    
}
