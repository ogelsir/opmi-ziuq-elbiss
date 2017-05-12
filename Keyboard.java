import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
/**
 * @author Felix Yan
 * @version 5/11/17
 */
public class Keyboard extends JPanel
{
    private Grid grid;
    private Graphics g;
    public Keyboard(Grid x, Graphics y)
    {
        grid = x;
        g = y;
        InputMap w = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        InputMap a = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        InputMap s = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        InputMap d = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        InputMap q = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        InputMap e = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        InputMap esc = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap w2 = getActionMap();
        ActionMap a2 = getActionMap();
        ActionMap s2 = getActionMap();
        ActionMap d2 = getActionMap();
        ActionMap q2 = getActionMap();
        ActionMap e2 = getActionMap();
        ActionMap esc2 = getActionMap();
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
        //this.setPreferredSize(new Dimension(300,300));
    }
    class wAction extends AbstractAction{
        public void actionPerformed(ActionEvent e){
            System.out.println("moved up!");
            grid.up();
            g.drawGrid();
        }
    }
    class aAction extends AbstractAction{
        public void actionPerformed(ActionEvent e){
            System.out.println("moved left!");
            grid.left();
            g.drawGrid();
        }
    }
    class sAction extends AbstractAction{
        public void actionPerformed(ActionEvent e){
            System.out.println("moved down!");
            grid.down();
            g.drawGrid();
        }
    }
    class dAction extends AbstractAction{
        public void actionPerformed(ActionEvent e){
            System.out.println("moved right!");
            grid.right();
            g.drawGrid();
        }
    }
    class qAction extends AbstractAction{
        public void actionPerformed(ActionEvent e){
            //add print inventory
        }
    }
    class eAction extends AbstractAction{
        public void actionPerformed(ActionEvent e){
            //add interaction method
        }
    }
    class escAction extends AbstractAction{
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
}
