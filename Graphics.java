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
    //colors
    private final int t1a = ((int)(Math.random()*50))+130;
    private final int t1b = (int)(Math.random()*80);
    private final int t1c = (int)(Math.random()*50);
    private final int t1s = (int)(Math.random()*5)+25;
    private final int t1d = (int)(Math.random()*140);
    private final int t1e = (int)(Math.random()*50+200);
    private final int t1f = (int)(Math.random()*140);
    private final int t1g = (int)(Math.random()*50+200);
    private final int t1h = (int)(Math.random()*140);
    private final int t1i = (int)(Math.random()*50+200);
    //tree2
    private final int t2a = ((int)(Math.random()*50))+130;
    private final int t2b = (int)(Math.random()*80);
    private final int t2c = (int)(Math.random()*50);
    private final int t2s = (int)(Math.random()*5)+25;
    private final int t2d = (int)(Math.random()*140);
    private final int t2e = (int)(Math.random()*50+200);
    private final int t2f = (int)(Math.random()*140);
    private final int t2g = (int)(Math.random()*50+200);
    private final int t2h = (int)(Math.random()*140);
    private final int t2i = (int)(Math.random()*50+200);
    //tree3
    private final int t3a = ((int)(Math.random()*50))+130;
    private final int t3b = (int)(Math.random()*80);
    private final int t3c = (int)(Math.random()*50);
    private final int t3s = (int)(Math.random()*5)+25;
    private final int t3d = (int)(Math.random()*140);
    private final int t3e = (int)(Math.random()*50+200);
    private final int t3f = (int)(Math.random()*140);
    private final int t3g = (int)(Math.random()*50+200);
    private final int t3h = (int)(Math.random()*140);
    private final int t3i = (int)(Math.random()*50+200);
    //mountain1
    private final int m1a = (int)((Math.random()*128)+96);
    private final int m1b = (int)((Math.random()*128)+96);
    private final int m1c = (int)((Math.random()*128)+96);
    //mountain2
    private final int m2a = (int)((Math.random()*128)+96);
    private final int m2b = (int)((Math.random()*128)+96);
    private final int m2c = (int)((Math.random()*128)+96);
    //mountain3
    private final int m3a = (int)((Math.random()*128)+96);
    private final int m3b = (int)((Math.random()*128)+96);
    private final int m3c = (int)((Math.random()*128)+96);
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
        pen.move(-(100*(col/2)+50),100*((double)row/2));
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
        pen.move(-(100*(col/2)+50),100*((double)row/2));
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
        
        //draw
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
                    pen.move((-(100*(col/2)+50))+50+(100*c),((100*((double)row/2))-50)-(100*r));
                    drawTree();
                }
                if(source[r][c].equals("tree2")){
                    pen.move((-(100*(col/2)+50))+50+(100*c),((100*((double)row/2))-50)-(100*r));
                    drawTree2();
                }
                if(source[r][c].equals("tree3")){
                    pen.move((-(100*(col/2)+50))+50+(100*c),((100*((double)row/2))-50)-(100*r));
                    drawTree3();
                }
                if(source[r][c].equals("player")){
                    pen.move((-(100*(col/2)+50))+50+(100*c),((100*((double)row/2))-50)-(100*r));
                    drawPlayer();
                } 
                if(source[r][c].equals("mountain")){
                    pen.move((-(100*(col/2)+50))+50+(100*c),((100*((double)row/2))-50)-(100*r));
                    drawMountain();
                }
                if(source[r][c].equals("mountain2")){
                    pen.move((-(100*(col/2)+50))+50+(100*c),((100*((double)row/2))-50)-(100*r));
                    drawMountain2();
                }
                if(source[r][c].equals("mountain3")){
                    pen.move((-(100*(col/2)+50))+50+(100*c),((100*((double)row/2))-50)-(100*r));
                    drawMountain3();
                }
            }
        }
    }
    public void drawTree(){//draws a tree with randomly generated colors
        pen.down();
        pen.setColor(new Color(t1a,t1b,t1c));
        pen.fillRect(t1s,70);
        pen.setDirection(90);
        pen.forward(20);
        pen.setColor(new Color(t1d,t1e,t1d));
        pen.fillCircle(25);
        pen.up();
        pen.setDirection(270);
        pen.forward(10);
        pen.setDirection(0);
        pen.forward(15);
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
        pen.setColor(new Color(t1h,t1i,t1h));
        pen.down();
        pen.fillOval(30,20);
        pen.up();
    }
    public void drawTree2(){//draws a different tree with randomly generated colors
        pen.down();
        pen.setColor(new Color(t2a,t2b,t2c));
        pen.fillRect(t2s,70);
        pen.setDirection(90);
        pen.forward(20);
        pen.setColor(new Color(t2d,t2e,t2d));
        pen.fillCircle(25);
        pen.up();
        pen.setDirection(270);
        pen.forward(10);
        pen.setDirection(0);
        pen.forward(15);
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
        pen.setColor(new Color(t2h,t2i,t2h));
        pen.down();
        pen.fillOval(30,20);
        pen.up();
    }
    public void drawTree3(){//draws a different tree with randomly generated colors
        pen.down();
        pen.setColor(new Color(t3a,t3b,t3c));
        pen.fillRect(t3s,70);
        pen.setDirection(90);
        pen.forward(20);
        pen.setColor(new Color(t3d,t3e,t3d));
        pen.fillCircle(25);
        pen.up();
        pen.setDirection(270);
        pen.forward(10);
        pen.setDirection(0);
        pen.forward(15);
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
        pen.setColor(new Color(t3h,t3i,t3h));
        pen.down();
        pen.fillOval(30,20);
        pen.up();
    }
    public void drawGate(){
        pen.down();
        //
        
        
        
        //
        pen.up();
    }
    public void drawMountain(){
        pen.up();
        pen.setDirection(270);
        pen.forward(30);
        pen.setDirection(180);
        pen.forward(25);
        pen.setColor(new Color(m1a,m1a,m1a));
        double distance = 68.00735254;
        double distance2 = 68.00735254;
        double distance3 = 39.5;
        double x = pen.getXPos();
        double y = pen.getYPos();
        pen.down();
        for(int loop = 0; distance3 >= 0; loop++){
            pen.setDirection(72.89727103);
            pen.forward(distance);
            pen.setDirection(360-72.89727103);
            pen.forward(distance2);
            pen.setDirection(180);
            pen.forward(distance3);
            distance--;
            distance2 = distance;
            distance3-=0.6;
        }
        pen.up();
        pen.move(x-10,y);
        pen.setColor(new Color(m1b,m1b,m1b));
        x = pen.getXPos();
        y = pen.getYPos();
        distance = 50;
        distance2 = 50;
        distance3 = 29.40858488;
        pen.down();
        for(int loop = 0; distance3 >= 0; loop++){
            pen.setDirection(72.89727103);
            pen.forward(distance);
            pen.setDirection(360-72.89727103);
            pen.forward(distance2);
            pen.setDirection(180);
            pen.forward(distance3);
            distance--;
            distance2 = distance;
            distance3-=0.6;
        }
        pen.move(x,y);
        pen.up();
        pen.move(x+40,y);
        pen.setColor(new Color(m1c,m1c,m1c));
        distance = 40;
        distance2 = 40;
        distance3 = 23.52686791;
        pen.down();
        for(int loop = 0; distance3 >= 0; loop++){
            pen.setDirection(72.89727103);
            pen.forward(distance);
            pen.setDirection(360-72.89727103);
            pen.forward(distance2);
            pen.setDirection(180);
            pen.forward(distance3);
            distance--;
            distance2 = distance;
            distance3-=0.6;
        }
        //
        pen.up();
    }
    public void drawMountain2(){
        pen.up();
        pen.setDirection(270);
        pen.forward(30);
        pen.setDirection(180);
        pen.forward(25);
        pen.setColor(new Color(m2a,m2a,m2a));
        double distance = 68.00735254;
        double distance2 = 68.00735254;
        double distance3 = 39.5;
        double x = pen.getXPos();
        double y = pen.getYPos();
        pen.down();
        for(int loop = 0; distance3 >= 0; loop++){
            pen.setDirection(72.89727103);
            pen.forward(distance);
            pen.setDirection(360-72.89727103);
            pen.forward(distance2);
            pen.setDirection(180);
            pen.forward(distance3);
            distance--;
            distance2 = distance;
            distance3-=0.6;
        }
        pen.up();
        pen.move(x-10,y);
        pen.setColor(new Color(m2b,m2b,m2b));
        x = pen.getXPos();
        y = pen.getYPos();
        distance = 50;
        distance2 = 50;
        distance3 = 29.40858488;
        pen.down();
        for(int loop = 0; distance3 >= 0; loop++){
            pen.setDirection(72.89727103);
            pen.forward(distance);
            pen.setDirection(360-72.89727103);
            pen.forward(distance2);
            pen.setDirection(180);
            pen.forward(distance3);
            distance--;
            distance2 = distance;
            distance3-=0.6;
        }
        pen.move(x,y);
        pen.up();
        pen.move(x+40,y);
        pen.setColor(new Color(m2c,m2c,m2c));
        distance = 40;
        distance2 = 40;
        distance3 = 23.52686791;
        pen.down();
        for(int loop = 0; distance3 >= 0; loop++){
            pen.setDirection(72.89727103);
            pen.forward(distance);
            pen.setDirection(360-72.89727103);
            pen.forward(distance2);
            pen.setDirection(180);
            pen.forward(distance3);
            distance--;
            distance2 = distance;
            distance3-=0.6;
        }
        //
        pen.up();
    }
    public void drawMountain3(){
        pen.up();
        pen.setDirection(270);
        pen.forward(30);
        pen.setDirection(180);
        pen.forward(25);
        pen.setColor(new Color(m3a,m3a,m3a));
        double distance = 68.00735254;
        double distance2 = 68.00735254;
        double distance3 = 39.5;
        double x = pen.getXPos();
        double y = pen.getYPos();
        pen.down();
        for(int loop = 0; distance3 >= 0; loop++){
            pen.setDirection(72.89727103);
            pen.forward(distance);
            pen.setDirection(360-72.89727103);
            pen.forward(distance2);
            pen.setDirection(180);
            pen.forward(distance3);
            distance--;
            distance2 = distance;
            distance3-=0.6;
        }
        pen.up();
        pen.move(x-10,y);
        pen.setColor(new Color(m3b,m3b,m3b));
        x = pen.getXPos();
        y = pen.getYPos();
        distance = 50;
        distance2 = 50;
        distance3 = 29.40858488;
        pen.down();
        for(int loop = 0; distance3 >= 0; loop++){
            pen.setDirection(72.89727103);
            pen.forward(distance);
            pen.setDirection(360-72.89727103);
            pen.forward(distance2);
            pen.setDirection(180);
            pen.forward(distance3);
            distance--;
            distance2 = distance;
            distance3-=0.6;
        }
        pen.move(x,y);
        pen.up();
        pen.move(x+40,y);
        pen.setColor(new Color(m3c,m3c,m3c));
        distance = 40;
        distance2 = 40;
        distance3 = 23.52686791;
        pen.down();
        for(int loop = 0; distance3 >= 0; loop++){
            pen.setDirection(72.89727103);
            pen.forward(distance);
            pen.setDirection(360-72.89727103);
            pen.forward(distance2);
            pen.setDirection(180);
            pen.forward(distance3);
            distance--;
            distance2 = distance;
            distance3-=0.6;
        }
        //
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
