import gpdraw.*;
import java.awt.*;
import java.lang.Math;
/**
 *  
 * @author (your name) 
 * @version 5/9/17
 */
public class Graphics
{
    private DrawingTool pen;
    private SketchPad paper;
    private String[][] source;
    private int row;
    private int col;
    public Graphics(String[][] s)
    {
        source = s;
        row = s.length;
        col = s[0].length;
        paper = new SketchPad(200+(100*col),200+(100*row),0);
        pen = new DrawingTool(paper);
    }
    public void drawGrid()
    {
        //erases previous grid
        pen.up();
        pen.move(0,0);
        pen.down();
        pen.setColor(Color.white);
        pen.fillRect(200+(100*col),200+(100*row));
        pen.setColor(Color.black);
        //draws grid frame
        pen.up();
        pen.move(-(100*(col/2)),100*((double)row/2));
        pen.down();
        pen.setDirection(0);
        for(int loop = 0; loop <= row; loop++){//rows
            pen.forward(100*col);
            pen.up();
            pen.backward(100*col);
            pen.setDirection(270);
            pen.forward(100);
            pen.setDirection(0);
            pen.down();
        }
        pen.up();
        pen.move(-(100*(col/2)),100*((double)row/2));
        pen.setDirection(270);
        pen.down();
        for(int loop = 0; loop <= col; loop++){//cols
            pen.forward(100*row);
            pen.up();
            pen.backward(100*row);
            pen.setDirection(0);
            pen.forward(100);
            pen.setDirection(270);
            pen.down();
        }
        drawObjects();
    }
    public void drawObjects(){//loops through the center of each "box" in the grid, calling on drawing methods
        pen.up();
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(source[r][c]==null){
                    continue;
                }
                if(source[r][c].equals("tree")){
                    pen.move((-(100*(col/2)))+50+(100*c),((100*((double)row/2))-50)-(100*r));
                    drawTree();
                }
                if(source[r][c].equals("player")){
                    pen.move((-(100*(col/2)))+50+(100*c),((100*((double)row/2))-50)-(100*r));
                    drawPlayer();
                } 
            }
        }
    }
    public void drawTree(){//draws a tree with randomly generated colors
        pen.down();
        pen.setColor(new Color(((int)(Math.random()*50))+130,(int)(Math.random()*80),(int)(Math.random()*50)));
        pen.fillRect((int)(Math.random()*5)+25,70);
        pen.setDirection(90);
        pen.forward(20);
        double x = Math.random()*140;
        double y = Math.random()*50+200;
        pen.setColor(new Color((int)x,(int)y,(int)x));
        pen.fillCircle(25);
        pen.up();
        pen.setDirection(270);
        pen.forward(10);
        pen.setDirection(0);
        pen.forward(15);
        x = Math.random()*140;
        y = Math.random()*50+200;
        pen.setColor(new Color((int)x,(int)y,(int)x));
        pen.down();
        pen.fillOval(40,30);
        pen.up();
        pen.setDirection(180);
        pen.forward(15);
        pen.setDirection(270);
        pen.forward(8);
        pen.setDirection(180);
        pen.forward(15);
        x = Math.random()*140;
        y = Math.random()*50+200;
        pen.setColor(new Color((int)x,(int)y,(int)x));
        pen.down();
        pen.fillOval(30,20);
        pen.up();
    }
    public void drawPlayer(){
        pen.down();
        pen.setColor(Color.black);
        pen.setDirection(90);
        pen.forward(10);
        pen.up();
        pen.forward(15);
        pen.down();
        pen.drawCircle(15);
        pen.up();
        pen.setDirection(270);
        pen.forward(15);
        pen.down();
        pen.forward(20);
        pen.setDirection(45);
        pen.forward(20);
        pen.backward(20);
        pen.setDirection(135);
        pen.forward(20);
        pen.backward(20);
        pen.setDirection(270);
        pen.forward(15);
        pen.setDirection(225);
        pen.forward(20);
        pen.backward(20);
        pen.setDirection(315);
        pen.forward(20);
        pen.up();
    }
}
