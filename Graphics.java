import gpdraw.*;
import java.awt.*;
import java.lang.Math;
import java.util.ArrayList;
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
    private Grid grid;
    private Hanoi h;
    
    private boolean works = true;
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
    public Graphics(String[][] s,Grid g)
    {
        source = s;
        grid = g;
        row = s.length;
        col = s[0].length;
        paper = new SketchPad(200+(100*col),200+(100*row),0);
        pen = new DrawingTool(paper);
    }
    public void setHanoi(Hanoi hanoi){
        h = hanoi;
    }
    public void stop(){
        works = false;
    }
    public void drawGrid()
    {
        if(works){
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
    }
    public void drawObjects(){//loops through the center of each "box" in the grid, calling on drawing methods
        pen.up();
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(source[r][c]==null){
                    continue;
                }
                if(source[r][c].equals("player")){
                    pen.move((-(100*(col/2)+50))+50+(100*c),((100*((double)row/2))-50)-(100*r));
                    drawPlayer();
                    if(grid.interactable()){
                        pen.move((-(100*(col/2)+50))+50+(100*c),((100*((double)row/2))-50)-(100*r));
                        drawInteract();
                    } 
                } 
                if(source[r][c].indexOf("riddle") != -1){
                    pen.move((-(100*(col/2)+50))+50+(100*c),((100*((double)row/2))-50)-(100*r));
                    drawRiddle();
                }
                
                //trees
                if(source[r][c].indexOf("tree1") != -1){
                    pen.move((-(100*(col/2)+50))+50+(100*c),((100*((double)row/2))-50)-(100*r));
                    drawTree();
                }
                if(source[r][c].indexOf("tree2") != -1){
                    pen.move((-(100*(col/2)+50))+50+(100*c),((100*((double)row/2))-50)-(100*r));
                    drawTree2();
                }
                if(source[r][c].indexOf("tree3") != -1){
                    pen.move((-(100*(col/2)+50))+50+(100*c),((100*((double)row/2))-50)-(100*r));
                    drawTree3();
                }
                //mountains
                if(source[r][c].indexOf("mountain1") != -1){
                    pen.move((-(100*(col/2)+50))+50+(100*c),((100*((double)row/2))-50)-(100*r));
                    drawMountain();
                }
                if(source[r][c].indexOf("mountain2") != -1){
                    pen.move((-(100*(col/2)+50))+50+(100*c),((100*((double)row/2))-50)-(100*r));
                    drawMountain2();
                }
                if(source[r][c].indexOf("mountain3") != -1){
                    pen.move((-(100*(col/2)+50))+50+(100*c),((100*((double)row/2))-50)-(100*r));
                    drawMountain3();
                }
                //chest
                if(source[r][c].indexOf("chest") != -1){
                    pen.move((-(100*(col/2)+50))+50+(100*c),((100*((double)row/2))-50)-(100*r));
                    if(source[r][c].indexOf("opened") != -1){
                        drawOpenedChest();
                    }else{
                        drawChest();
                    }
                }
                //river and bridge
                if(source[r][c].indexOf("river") != -1){
                    pen.move((-(100*(col/2)+50))+50+(100*c),((100*((double)row/2))-50)-(100*r));
                    drawRiver();
                }
                if(source[r][c].indexOf("bridge") != -1){
                    pen.move((-(100*(col/2)+50))+50+(100*c),((100*((double)row/2))-50)-(100*r));
                    drawBridge();
                }
                //tower of hanoi
                if(source[r][c].indexOf("temple") != -1){
                    pen.move((-(100*(col/2)+50))+50+(100*c),((100*((double)row/2))-50)-(100*r));
                    drawTemple();
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
    public void drawChest(){
        pen.up();
        double x = pen.getXPos();
        double y = pen.getYPos();
        pen.setDirection(270);
        pen.forward(10);
        pen.down();
        //fill
        pen.setColor(new Color(204,102,0));
        pen.fillRect(60,40);
        //border
        pen.setColor(Color.black);
        pen.drawRect(60,40);
        pen.setColor(Color.yellow);
        int width = 58;
        int height = 38;
        for(int loop = 0; loop <= 4; loop++){
            pen.drawRect(width,height);
            width--;
            height--;
        }
        pen.up();
        pen.setColor(Color.black);
        pen.setDirection(180);
        pen.forward(25);
        pen.setDirection(90);
        pen.forward(20);
        pen.setDirection(0);
        for(int loop = 0; loop <= 3; loop++){
            pen.forward(50);
            pen.up();
            pen.backward(50);
            pen.setDirection(270);
            pen.forward(10);
            pen.setDirection(0);
            pen.down();
        }
        pen.up();
        //top half
        pen.move(x,y);
        pen.setDirection(90);
        pen.forward(17);
        pen.down();
        pen.setColor(new Color(204,102,0));
        pen.fillRect(45,14);
        pen.setColor(Color.black);
        pen.drawRect(45,14);
        width = 43;
        height = 12;
        pen.setColor(Color.yellow);
        for(int loop = 0; loop <= 2; loop++){
            pen.drawRect(width,height);
            width--;
            height--;
        }
        //vertical lines
        pen.up();
        pen.setColor(Color.black);
        pen.setDirection(180);
        pen.forward(14);
        pen.setDirection(90);
        pen.forward(4);
        pen.down();
        pen.setDirection(270);
        pen.forward(8);
        pen.up();
        pen.backward(8);
        pen.setDirection(0);
        pen.forward(14);
        pen.down();
        pen.setDirection(270);
        pen.forward(4);
        pen.up();
        pen.backward(4);
        pen.setDirection(0);
        pen.forward(14);
        pen.setDirection(270);
        pen.down();
        pen.forward(8);
        //key hole
        pen.up();
        pen.move(x,y);
        pen.setColor(Color.yellow);
        pen.setDirection(90);
        pen.forward(10);
        pen.down();
        pen.fillRect(18,14);
        pen.setColor(Color.black);
        pen.drawRect(18,14);
        pen.setDirection(270);
        pen.forward(3);
        pen.fillRect(3,6);
        pen.setDirection(90);
        pen.forward(5);
        pen.fillCircle(3);
        pen.up();
    }
    public void drawOpenedChest(){
        pen.up();
        double x = pen.getXPos();
        double y = pen.getYPos();
        pen.setDirection(270);
        pen.forward(10);
        pen.down();
        //fill
        pen.setColor(new Color(204,102,0));
        pen.fillRect(60,40);
        //border
        pen.setColor(Color.black);
        pen.drawRect(60,40);
        pen.setColor(Color.yellow);
        int width = 58;
        int height = 38;
        for(int loop = 0; loop <= 4; loop++){
            pen.drawRect(width,height);
            width--;
            height--;
        }
        pen.up();
        pen.setColor(Color.black);
        pen.setDirection(180);
        pen.forward(26);
        pen.setDirection(90);
        pen.forward(20);
        pen.setDirection(0);
        for(int loop = 0; loop <= 3; loop++){
            pen.forward(50);
            pen.up();
            pen.backward(50);
            pen.setDirection(270);
            pen.forward(10);
            pen.setDirection(0);
            pen.down();
        }
        pen.up();
        //top half
        pen.move(x,y);
        pen.setDirection(90);
        pen.forward(25);
        pen.down();
        pen.setColor(new Color(204,102,0));
        pen.fillRect(45,30);
        pen.setColor(Color.black);
        pen.drawRect(45,30);
        width = 43;
        height = 28;
        pen.setColor(Color.yellow);
        for(int loop = 0; loop <= 2; loop++){
            pen.drawRect(width,height);
            width--;
            height--;
        }
        //vertical lines
        pen.up();
        pen.setColor(Color.black);
        pen.setDirection(180);
        pen.forward(14);
        pen.setDirection(90);
        pen.forward(12);
        pen.down();
        pen.setDirection(270);
        pen.forward(24);
        pen.up();
        pen.backward(24);
        pen.setDirection(0);
        pen.forward(14);
        pen.down();
        pen.setDirection(270);
        pen.forward(24);
        pen.up();
        pen.backward(24);
        pen.setDirection(0);
        pen.forward(14);
        pen.setDirection(270);
        pen.down();
        pen.forward(24);
        pen.up();
        pen.backward(24);
        pen.setDirection(180);
        pen.forward(14);
        pen.setDirection(90);
        pen.forward(6);
        pen.down();
        pen.setColor(Color.yellow);
        pen.fillRect(18,6);
        pen.setColor(Color.black);
        pen.drawRect(18,6);
        pen.setDirection(270);
        pen.forward(1);
        pen.fillRect(5,3);
        pen.up();
    }
    
    public void drawRiddle(){
        pen.setDirection(0);
        pen.forward(25);
        pen.setDirection(270);
        pen.forward(15);
        //
        pen.down();
        pen.setColor(Color.black);
        pen.setDirection(90);
        pen.forward(11.2);
        pen.up();
        pen.forward(12.6);
        pen.down();
        pen.drawCircle(12.6);
        pen.up();
        pen.setDirection(270);
        pen.forward(12.6);
        pen.down();
        pen.forward(16.8);
        pen.setDirection(45);
        pen.forward(16.8);
        pen.backward(16.8);
        pen.setDirection(135);
        pen.forward(16.8);
        pen.backward(16.8);
        pen.setDirection(270);
        pen.forward(12.6);
        pen.setDirection(225);
        pen.forward(16.8);
        pen.backward(16.8);
        pen.setDirection(315);
        pen.forward(16.8);
        pen.up();
        //hat 204 102 0 brown 153 253 153 green
        pen.backward(16.8);
        pen.setDirection(90);
        pen.forward(53);
        pen.setColor(new Color(204,102,0));
        pen.down();
        pen.fillRect(25,4);
        pen.setColor(Color.black);
        pen.drawRect(25,4);
        pen.up();
        pen.forward(3);
        //top triangle
        pen.down();
        pen.setColor(new Color(153,253,153));
        double width = 20;
        for(;width >= 0; width--){
            pen.setDirection(180);
            pen.forward(width/2.0);
            pen.backward(width);
            pen.forward(width/2.0);
            pen.setDirection(90);
            pen.forward(1);
        }
        pen.up();
    }
    
    
    public void drawRiver(){
        pen.setColor(Color.blue);
        double x = pen.getXPos();
        double y = pen.getYPos();
        pen.down();
        pen.move(x-(50-12.5),y+5);       
        pen.setColor(Color.black);
        pen.drawRect(25,31);
        pen.setColor(new Color(100,255,255));
        pen.fillRect(25,30);
        pen.move(x-12.5,y);
        pen.setColor(Color.black);
        pen.drawRect(25,31);
        pen.setColor(new Color(100,255,255));
        pen.fillRect(25,30);
        pen.move(x+12.5,y-5);
        pen.setColor(Color.black);
        pen.drawRect(25,31);
        pen.setColor(new Color(100,255,255));
        pen.fillRect(25,30);
        pen.move(x+(50-12.5),y);
        pen.setColor(Color.black);
        pen.drawRect(25,31);
        pen.setColor(new Color(100,255,255));
        pen.fillRect(25,30);
        pen.up();
        //1st streak
        pen.setColor(Color.black);
        pen.setDirection(90);
        pen.forward(3);
        pen.down();
        pen.setDirection(180);
        pen.forward(10);
        pen.up();
        //2nd streak
        pen.setDirection(270);
        pen.forward(8);
        pen.setDirection(180);
        pen.forward(5);
        pen.down();
        pen.forward(8);
        pen.up();
        //3rd streak
        pen.forward(10);
        pen.setDirection(90);
        pen.forward(5);
        pen.setDirection(180);
        pen.down();
        pen.forward(10);
        pen.up();
        //4th streak
        pen.forward(6);
        pen.setDirection(90);
        pen.forward(6);
        pen.setDirection(180);
        pen.down();
        pen.forward(8);
        pen.up();
        //5th streak
        pen.forward(10);
        pen.setDirection(270);
        pen.forward(4);
        pen.setDirection(180);
        pen.down();
        pen.forward(10);
        pen.up();
        //fix borders
        pen.move(x-50,y+50);
        pen.setColor(Color.black);
        pen.setDirection(270);
        pen.down();
        pen.forward(100);
        pen.up();
        pen.move(x+50,y+50);
        pen.setDirection(270);
        pen.down();
        pen.forward(100);
        pen.up();
    }
    public void drawBridge(){
        pen.setColor(Color.blue);
        double x = pen.getXPos();
        double y = pen.getYPos();
        pen.down();
        pen.move(x-(50-12.5),y+5);       
        pen.setColor(Color.black);
        pen.drawRect(25,31);
        pen.setColor(new Color(100,255,255));
        pen.fillRect(25,30);
        pen.move(x-12.5,y);
        pen.setColor(Color.black);
        pen.drawRect(25,31);
        pen.setColor(new Color(100,255,255));
        pen.fillRect(25,30);
        pen.move(x+12.5,y-5);
        pen.setColor(Color.black);
        pen.drawRect(25,31);
        pen.setColor(new Color(100,255,255));
        pen.fillRect(25,30);
        pen.move(x+(50-12.5),y);
        pen.setColor(Color.black);
        pen.drawRect(25,31);
        pen.setColor(new Color(100,255,255));
        pen.fillRect(25,30);
        pen.up();
        //1st streak
        pen.setColor(Color.black);
        pen.setDirection(90);
        pen.forward(3);
        pen.down();
        pen.setDirection(180);
        pen.forward(10);
        pen.up();
        //2nd streak
        pen.setDirection(270);
        pen.forward(8);
        pen.setDirection(180);
        pen.forward(5);
        pen.down();
        pen.forward(8);
        pen.up();
        //3rd streak
        pen.forward(10);
        pen.setDirection(90);
        pen.forward(5);
        pen.setDirection(180);
        pen.down();
        pen.forward(10);
        pen.up();
        //4th streak
        pen.forward(6);
        pen.setDirection(90);
        pen.forward(6);
        pen.setDirection(180);
        pen.down();
        pen.forward(8);
        pen.up();
        //5th streak
        pen.forward(10);
        pen.setDirection(270);
        pen.forward(4);
        pen.setDirection(180);
        pen.down();
        pen.forward(10);
        pen.up();
        //fix borders
        pen.move(x-50,y+50);
        pen.setColor(Color.black);
        pen.setDirection(270);
        pen.down();
        pen.forward(100);
        pen.up();
        pen.move(x+50,y+50);
        pen.setDirection(270);
        pen.down();
        pen.forward(100);
        pen.up();
        //bridge
        //102 51 0 brown color
        pen.move(x,y);
        pen.setColor(new Color(204,102,0));
        pen.down();
        pen.fillRect(30,60);
        pen.setColor(Color.black);
        pen.drawRect(30,60);
        //bottom poles
        pen.up();
        pen.move(x-18,y-23);
        pen.setColor(new Color(204,102,0));
        pen.down();
        pen.fillRect(6,22);
        pen.setColor(Color.black);
        pen.drawRect(6,22);
        pen.drawRect(6,8);
        pen.up();
        pen.move(x+18,y-23);
        pen.down();
        pen.setColor(new Color(204,102,0));
        pen.fillRect(6,22);
        pen.setColor(Color.black);
        pen.drawRect(6,22);
        pen.drawRect(6,8);
        //top poles
        pen.up();
        pen.move(x+18,y+27);
        pen.down();
        pen.setColor(new Color(204,102,0));
        pen.fillRect(6,17);
        pen.setColor(Color.black);
        pen.drawRect(6,17);
        pen.drawRect(6,6);
        pen.up();
        pen.move(x-18,y+27);
        pen.down();
        pen.setColor(new Color(204,102,0));
        pen.fillRect(6,17);
        pen.setColor(Color.black);
        pen.drawRect(6,17);
        pen.drawRect(6,6);
        //lines
        pen.up();
        pen.move(x-15,y-25);
        pen.setDirection(0);
        pen.down();
        pen.forward(30);
        pen.backward(30);
        pen.move(x-15,y-15);
        pen.setDirection(0);
        pen.down();
        pen.forward(30);
        pen.backward(30);
        pen.move(x-15,y-5);
        pen.setDirection(0);
        pen.down();
        pen.forward(30);
        pen.backward(30);
        pen.move(x-15,y+5);
        pen.setDirection(0);
        pen.down();
        pen.forward(30);
        pen.backward(30);
        pen.move(x-15,y+15);
        pen.setDirection(0);
        pen.down();
        pen.forward(30);
        pen.backward(30);
        pen.move(x-15,y+25);
        pen.setDirection(0);
        pen.down();
        pen.forward(30);
        pen.backward(30);
        //person
        pen.up();
        pen.move(x+30,y-33);
        pen.down();
        pen.setColor(Color.black);
        pen.setDirection(90);
        pen.forward(3);
        pen.up();
        pen.forward(4.5);
        pen.down();
        pen.drawCircle(4.5);
        pen.up();
        pen.setDirection(270);
        pen.forward(4.5);
        pen.down();
        pen.forward(6);
        pen.setDirection(45);
        pen.forward(6);
        pen.backward(6);
        pen.setDirection(135);
        pen.forward(6);
        pen.backward(6);
        pen.setDirection(270);
        pen.forward(4.5);
        pen.setDirection(225);
        pen.forward(6);
        pen.backward(6);
        pen.setDirection(315);
        pen.forward(6);  
        pen.up();
    }
    
    public void drawTemple(){
        double x = pen.getXPos();
        double y = pen.getYPos();
        //left pillar
        pen.move(x-30,y-5);
        pen.setColor(new Color(192,192,192));
        pen.down();
        pen.fillRect(15,50);
        pen.setColor(Color.black);
        pen.drawRect(15,50);
        pen.up();
        pen.move(x-29,y-5);
        pen.down();
        pen.fillRect(6,10);
        pen.up();
        pen.move(x-29,y+8);
        pen.down();
        pen.fillRect(6,10);
        pen.up();
        //left flag
        pen.move(x-33,y+20);
        pen.down();
        pen.setDirection(90);
        pen.forward(14);
        pen.up();
        pen.move(x-32,y+31);
        pen.down();
        drawFlag(5);
        pen.up();
        //right pillar
        pen.move(x+30,y-5);
        pen.setColor(new Color(192,192,192));
        pen.down();
        pen.fillRect(15,50);
        pen.setColor(Color.black);
        pen.drawRect(15,50);
        pen.up();
        pen.move(x+31,y-5);
        pen.down();
        pen.fillRect(6,10);
        pen.up();
        pen.move(x+31,y+8);
        pen.down();
        pen.fillRect(6,10);
        pen.up();
        //right flag
        pen.move(x+26,y+20);
        pen.down();
        pen.setDirection(90);
        pen.forward(14);
        pen.up();
        pen.move(x+27,y+31);
        pen.down();
        drawFlag(5);
        pen.up();
        //center
        pen.move(x,y);
        pen.setColor(new Color(192,192,192));
        pen.down();
        pen.fillRect(25,70);
        pen.setColor(Color.black);
        pen.drawRect(25,70);
        pen.move(x+1,y);
        pen.fillRect(11,20);
        pen.up();
        //circle
        pen.move(x+1,y+20);
        pen.down();
        pen.setColor(Color.white);
        pen.fillCircle(5);
        pen.setColor(Color.black);
        pen.drawCircle(5);
        pen.up();
        //middle flag
        pen.move(x,y+35);
        pen.down();
        pen.setDirection(90);
        pen.forward(9);
        pen.move(x+1,y+41);
        drawFlag(5);
        pen.up();
        //bottom
        pen.move(x,y-25);
        pen.down();
        pen.setColor(new Color(192,192,192));
        pen.fillRect(80,20);
        pen.setColor(Color.black);
        pen.drawRect(80,20);
        pen.up();
        pen.up();
    }
    public void drawFlag(double width){
        pen.setDirection(270);
        pen.setColor(Color.yellow);
        for(;width >= 0; width = width-0.3){
            pen.setDirection(90);
            pen.forward(width/2.0);
            pen.backward(width);
            pen.forward(width/2.0);
            pen.setDirection(0);
            pen.forward(1);
        }
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
    public void drawInteract(){
        pen.up();
        pen.setDirection(90);
        pen.forward(20);
        pen.setDirection(0);
        pen.forward(25);
        pen.setColor(Color.red);
        pen.down();
        pen.fillCircle(2);
        pen.up();
        pen.setDirection(90);
        pen.forward(5);
        pen.down();
        pen.forward(13);
        pen.up();
    }
    public void drawHanoi(){
        //erases previous grid
        pen.up();
        pen.move(0,0);
        pen.down();
        pen.setColor(Color.white);
        pen.fillRect(200+(100*col),200+(100*row));
        pen.setColor(Color.black);
        //draws Hanoi
        pen.up();
        pen.move(0,-250);
        pen.setColor(new Color(153,76,0));
        pen.down();
        pen.fillRect(810,150);
        pen.setColor(Color.black);
        pen.drawRect(810,150);
        //draws pegs
        pen.up();
        pen.setColor(new Color(204,102,0));
        pen.move(-290,40);
        pen.down();
        pen.fillRect(45,430);
        pen.setColor(Color.black);
        pen.drawRect(45,430);
        pen.up();
        pen.setColor(new Color(204,102,0));
        pen.move(0,40);
        pen.down();
        pen.fillRect(45,430);
        pen.setColor(Color.black);
        pen.drawRect(45,430);
        pen.up();
        pen.setColor(new Color(204,102,0));
        pen.move(290,40);
        pen.down();
        pen.fillRect(45,430);
        pen.setColor(Color.black);
        pen.drawRect(45,430);
        pen.up();
        peg1();
        peg2();
        peg3();
        if(h.isGameOver()){
            pen.setColor(Color.yellow);
            pen.move(170,-85);
            pen.setDirection(175);
            drawLight();
            pen.move(180,20);
            pen.setDirection(165);
            drawLight();
            pen.move(200,120);
            pen.setDirection(150);
            drawLight();
            pen.move(225,230);
            pen.setDirection(140);
            drawLight();
            pen.move(270,300);
            pen.setDirection(130);
            drawLight();
            pen.move(330,285);
            pen.setDirection(60);
            drawLight();
            pen.move(380,220);
            pen.setDirection(45);
            drawLight();
            pen.move(400,105);
            pen.setDirection(30);
            drawLight();
            pen.move(420,0);
            pen.setDirection(15);
            drawLight();
            pen.move(430,-100);
            pen.setDirection(5);
            drawLight();
        }
    }
    public void drawLight(){
        pen.down();
        pen.turnLeft(90);
        for(int loop = 0; loop < 120; loop++){
            pen.forward(20);
            pen.backward(20);
            pen.turnRight(90);
            pen.forward(1);
            pen.turnLeft(90);
        }
        pen.up();
    }
    public void peg1(){
        pen.up();
        ArrayList <Integer> temp = h.getPeg1();
        for(int loop = temp.size()-1; loop >= 0; loop--){//places
            pen.move(-290,180 - ((4-temp.size())*100) - (100 * loop));
            drawDisk(temp.get(loop));
        }
        pen.up();
    }
    public void peg2(){
        pen.up();
        ArrayList <Integer> temp = h.getPeg2();
        for(int loop = temp.size()-1; loop >= 0; loop--){//places
            pen.move(0,180 - ((4-temp.size())*100) - (100 * loop));
            drawDisk(temp.get(loop));
        }
        pen.up();
    }
    public void peg3(){
        pen.up();
        ArrayList <Integer> temp = h.getPeg3();
        for(int loop = temp.size()-1; loop >= 0; loop--){//places
            pen.move(290,180 - ((4-temp.size())*100) - (100 * loop));
            drawDisk(temp.get(loop));
        }
        pen.up();
    }
    public void drawDisk(int x){
        if(x == 1){
            disk1();
        }else{
            if(x == 2){
                disk2();
            }else{
                if(x == 3){
                    disk3();
                }else{
                    disk4();
                }
            }
        }
    }
    public void disk1(){
        pen.down();
        pen.setColor(new Color(0,255,128));
        pen.fillRect(80,75);
        pen.setColor(Color.black);
        pen.drawRect(80,75);
        pen.up();
    }
    public void disk2(){
        pen.down();
        pen.setColor(new Color(255,128,0));
        pen.fillRect(120,75);
        pen.setColor(Color.black);
        pen.drawRect(120,75);
        pen.up();
    }
    public void disk3(){
        pen.down();
        pen.setColor(new Color(0,128,255));
        pen.fillRect(160,75);
        pen.setColor(Color.black);
        pen.drawRect(160,75);
        pen.up();
    }
    public void disk4(){
        pen.down();
        pen.setColor(new Color(128,255,0));
        pen.fillRect(200,75);
        pen.setColor(Color.black);
        pen.drawRect(200,75);
        pen.up();
    }
    public void drawEnd1(){
        grid.removeListener();
        System.out.println("The temple around you rumbles as a platform with a peculiar object rises from the ground... (Type anything to continue)");
        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("");
        grid.addEndListener();
        //erases previous grid
        pen.up();
        pen.move(0,0);
        pen.down();
        pen.setColor(Color.white);
        pen.fillRect(200+(100*col),200+(100*row));
        pen.setColor(Color.black);
        //platform
        pen.up();
        pen.move(0,-400);
        pen.down();
        pen.setColor(new Color(153,76,0));
        pen.fillRect(500,300);
        pen.setColor(Color.black);
        pen.drawRect(500,300);
    }
    public void drawEnd2(){
        grid.removeListener();
        System.out.println("Upon the platform lies a gold encrusted potato. What a lame reward...");
        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("Gridquest made by Oliver Jiang and Felix Yan");
        System.out.println("Thanks for playing!");
        //erases previous grid
        pen.up();
        pen.move(0,0);
        pen.down();
        pen.setColor(Color.white);
        pen.fillRect(200+(100*col),200+(100*row));
        pen.setColor(Color.black);
        //platform
        pen.setColor(new Color(153,76,0));
        pen.fillRect(500,100);
        pen.setColor(Color.black);
        pen.drawRect(500,100);
        //stand
        pen.up();
        pen.move(0,-300);
        pen.setColor(new Color(153,76,0));
        pen.down();
        pen.fillRect(150,500);
        pen.setColor(Color.black);
        pen.drawRect(150,500);
        //reward
        pen.up();
        pen.setColor(Color.yellow);
        pen.move(-15,100);
        pen.down();
        pen.fillCircle(50);
        pen.move(0,100);
        pen.fillCircle(50);
        pen.move(15,100);
        pen.fillCircle(50);
        
    }
}
