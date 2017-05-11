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
    private boolean firstTime = true; //disables random color generation after 1st time
    //colors for the 3 types of trees
    private int t1a,t1b,t1c,t1d,t1e,t1f,t1g,t1h,t1i,t1s;
    private int t2a,t2b,t2c,t2d,t2e,t2f,t2g,t2h,t2i,t2s;
    private int t3a,t3b,t3c,t3d,t3e,t3f,t3g,t3h,t3i,t3s;
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
        firstTime = false;
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
                if(source[r][c].equals("tree2")){
                    pen.move((-(100*(col/2)))+50+(100*c),((100*((double)row/2))-50)-(100*r));
                    drawTree2();
                }
                if(source[r][c].equals("tree3")){
                    pen.move((-(100*(col/2)))+50+(100*c),((100*((double)row/2))-50)-(100*r));
                    drawTree3();
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
        if(firstTime){
            t1a = ((int)(Math.random()*50))+130;
            t1b = (int)(Math.random()*80);
            t1c = (int)(Math.random()*50);
        }
        pen.setColor(new Color(t1a,t1b,t1c));
        if(firstTime){
            t1s = (int)(Math.random()*5)+25;
        }
        pen.fillRect(t1s,70);
        pen.setDirection(90);
        pen.forward(20);
        if(firstTime){
            t1d = (int)(Math.random()*140);
            t1e = (int)(Math.random()*50+200);
        }
        pen.setColor(new Color(t1d,t1e,t1d));
        pen.fillCircle(25);
        pen.up();
        pen.setDirection(270);
        pen.forward(10);
        pen.setDirection(0);
        pen.forward(15);
        if(firstTime){
            t1f = (int)(Math.random()*140);
            t1g = (int)(Math.random()*50+200);
        }
        pen.setColor(new Color(t1f,t1g,t1f));
        pen.down();
        pen.fillOval(40,30);
        pen.up();
        pen.setDirection(180);
        pen.forward(15);
        pen.setDirection(270);
        pen.forward(8);
        pen.setDirection(180);
        pen.forward(15);
        if(firstTime){
            t1h = (int)(Math.random()*140);
            t1i = (int)(Math.random()*50+200);
        }
        pen.setColor(new Color(t1h,t1i,t1h));
        pen.down();
        pen.fillOval(30,20);
        pen.up();
    }
    public void drawTree2(){//draws a different tree with randomly generated colors
        pen.down();
        if(firstTime){
            t2a = ((int)(Math.random()*50))+130;
            t2b = (int)(Math.random()*80);
            t2c = (int)(Math.random()*50);
        }
        pen.setColor(new Color(t2a,t2b,t2c));
        if(firstTime){
            t2s = (int)(Math.random()*5)+25;
        }
        pen.fillRect(t2s,70);
        pen.setDirection(90);
        pen.forward(20);
        if(firstTime){
            t2d = (int)(Math.random()*140);
            t2e = (int)(Math.random()*50+200);
        }
        pen.setColor(new Color(t2d,t2e,t2d));
        pen.fillCircle(25);
        pen.up();
        pen.setDirection(270);
        pen.forward(10);
        pen.setDirection(0);
        pen.forward(15);
        if(firstTime){
            t2f = (int)(Math.random()*140);
            t2g = (int)(Math.random()*50+200);
        }
        pen.setColor(new Color(t2f,t2g,t2f));
        pen.down();
        pen.fillOval(40,30);
        pen.up();
        pen.setDirection(180);
        pen.forward(15);
        pen.setDirection(270);
        pen.forward(8);
        pen.setDirection(180);
        pen.forward(15);
        if(firstTime){
            t2h = (int)(Math.random()*140);
            t2i = (int)(Math.random()*50+200);
        }
        pen.setColor(new Color(t2h,t2i,t2h));
        pen.down();
        pen.fillOval(30,20);
        pen.up();
    }
    public void drawTree3(){//draws a different tree with randomly generated colors
        pen.down();
        if(firstTime){
            t3a = ((int)(Math.random()*50))+130;
            t3b = (int)(Math.random()*80);
            t3c = (int)(Math.random()*50);
        }
        pen.setColor(new Color(t3a,t3b,t3c));
        if(firstTime){
            t3s = (int)(Math.random()*5)+25;
        }
        pen.fillRect(t3s,70);
        pen.setDirection(90);
        pen.forward(20);
        if(firstTime){
            t3d = (int)(Math.random()*140);
            t3e = (int)(Math.random()*50+200);
        }
        pen.setColor(new Color(t3d,t3e,t3d));
        pen.fillCircle(25);
        pen.up();
        pen.setDirection(270);
        pen.forward(10);
        pen.setDirection(0);
        pen.forward(15);
        if(firstTime){
            t3f = (int)(Math.random()*140);
            t3g = (int)(Math.random()*50+200);
        }
        pen.setColor(new Color(t3f,t3g,t3f));
        pen.down();
        pen.fillOval(40,30);
        pen.up();
        pen.setDirection(180);
        pen.forward(15);
        pen.setDirection(270);
        pen.forward(8);
        pen.setDirection(180);
        pen.forward(15);
        if(firstTime){
            t3h = (int)(Math.random()*140);
            t3i = (int)(Math.random()*50+200);
        }
        pen.setColor(new Color(t3h,t3i,t3h));
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
