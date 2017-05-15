import java.io.IOException;
import java.io.OutputStream;
import javax.swing.*;
/**
 * @source code: http://stackoverflow.com/questions/19834155/jtextarea-as-console
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
