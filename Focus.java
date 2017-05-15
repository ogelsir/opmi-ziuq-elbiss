import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
/**
 * @author Felix Yan
 * @version 5/14/17
 */
public class Focus extends FocusAdapter
{
    private Movement m;
    public Focus(Movement movement){
        m = movement;
    }
    public void focusGained(FocusEvent e){
        {
            ((JTextField)e.getSource()).setText("");
            m.disable();
        }
    }
}
