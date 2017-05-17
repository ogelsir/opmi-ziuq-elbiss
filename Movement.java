import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import java.util.ArrayList;
/**
 * @author Felix Yan
 * @version 5/11/17
 */
public class Movement extends JPanel
{
    private Grid grid;
    private Graphics g;
    private ArrayList <String> inventory;
    //keys
    InputMap w;
    InputMap a;
    InputMap s;
    InputMap d;
    InputMap q;
    InputMap e;
    InputMap esc;
    //action maps
    ActionMap w2;
    ActionMap a2;
    ActionMap s2;
    ActionMap d2;
    ActionMap q2;
    ActionMap e2;
    ActionMap esc2;
    public Movement(Grid x, Graphics y, ArrayList <String> i)
    {
        grid = x;
        g = y;
        inventory = i;
        w = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        a = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        s = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        d = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        q = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        e = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        esc = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        w2 = getActionMap();
        a2 = getActionMap();
        s2 = getActionMap();
        d2 = getActionMap();
        q2 = getActionMap();
        e2 = getActionMap();
        esc2 = getActionMap();
        w.put(KeyStroke.getKeyStroke(KeyEvent.VK_W,0),"W");
        a.put(KeyStroke.getKeyStroke(KeyEvent.VK_A,0),"A");
        s.put(KeyStroke.getKeyStroke(KeyEvent.VK_S,0),"S");
        d.put(KeyStroke.getKeyStroke(KeyEvent.VK_D,0),"D");
        q.put(KeyStroke.getKeyStroke(KeyEvent.VK_Q,0),"Q");
        e.put(KeyStroke.getKeyStroke(KeyEvent.VK_E,0),"E");
        esc.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0),"ESC");
        w2.put("W", new wAction());
        a2.put("A", new aAction());
        s2.put("S", new sAction());
        d2.put("D", new dAction());
        q2.put("Q", new qAction());
        e2.put("E", new eAction());
        esc2.put("ESC", new escAction());
    }
    public void disable(){
        w2.put("W", new doNothing());
        a2.put("A", new doNothing());
        s2.put("S", new doNothing());
        d2.put("D", new doNothing());
        q2.put("Q", new doNothing());
        e2.put("E", new doNothing());
    }
    public void enable(){
        w2.put("W", new wAction());
        a2.put("A", new aAction());
        s2.put("S", new sAction());
        d2.put("D", new dAction());
        q2.put("Q", new qAction());
        e2.put("E", new eAction());
    }
    public void updateInventory(ArrayList <String> i){
        inventory = i;
    }
    class wAction extends AbstractAction{
        public void actionPerformed(ActionEvent e){
            grid.up();
            g.drawGrid();
        }
    }
    class aAction extends AbstractAction{
        public void actionPerformed(ActionEvent e){
            grid.left();
            g.drawGrid();
        }
    }
    class sAction extends AbstractAction{
        public void actionPerformed(ActionEvent e){
            grid.down();
            g.drawGrid();
        }
    }
    class dAction extends AbstractAction{
        public void actionPerformed(ActionEvent e){
            grid.right();
            g.drawGrid();
        }
    }
    class qAction extends AbstractAction{
        public void actionPerformed(ActionEvent e){
            if(inventory.size()==0){
                System.out.println("Inventory Empty!");
                System.out.println("");
            }else{
                System.out.println("Inventory:");
                for(int loop = 0; loop < inventory.size(); loop++){
                    System.out.println(inventory.get(loop));
                }
                System.out.println("");
            }
        }
    }
    class eAction extends AbstractAction{
        public void actionPerformed(ActionEvent e){
            if(grid.interactable()){
                grid.interact();
            }
            if(grid.specialCase()){
                grid.interact();
            }
        }
    }
    class escAction extends AbstractAction{
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    class doNothing extends AbstractAction{
        public void actionPerformed(ActionEvent e){
            //do nothing
        }
    }
}
