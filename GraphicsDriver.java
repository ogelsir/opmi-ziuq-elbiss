import java.util.Arrays;
public class GraphicsDriver
{
    public static void graphics(){
        Grid env = new Grid(5,4);//rows and columns
        Graphics g = new Graphics(env.getGrid());
        env.set("player",4,0);
        env.set("tree",1,1);//adds a tree to that index in the 2d array
        env.set("tree",2,1);
        g.drawGrid();//prints
    }
}
