import java.io.IOException;
import java.io.OutputStream;
import javax.swing.*;
/**
 * @author Felix Yan
 * @version 5/12/17
 */
public class Console extends OutputStream
{
    private JTextArea output;
    public Console(JTextArea o)
    {
        output = o;
    }
    public void write(int b) throws IOException
    {
        output.append(String.valueOf((char)b));
    }
}
