import java.util.Arrays;
public class GraphicsDriver
{
    public static void graphics(){
        Environment2 env = new Environment2(5,4);//rows and columns
        Environment2Graphics graphics = new Environment2Graphics(env.getGrid());
        env.set("tree",0,0);//adds a tree to that index in the 2d array
        env.set("tree",1,1);
        env.set("tree",2,1);
        graphics.drawGrid();//prints
    }
}
