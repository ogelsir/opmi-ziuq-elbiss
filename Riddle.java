import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.lang.Math;
/**
 * INCOMPLETE CODE PLEASE DO NOT TOUCH
 * has a bunch of riddles, but its probably the least complicated class here
 */
public class Riddle
{
    private ArrayList <String> riddles;//the riddles documents has a riddle and then an answer each line 
    private ArrayList <String> answers;
    Scanner in;
    Scanner keyboard;
    private boolean timed;     //"fun" boolean for timed mode
    private boolean backwards; //"fun" boolean for backwards riddles
    public Riddle()//default constuctor (random booleans)
    {
        keyboard = new Scanner(System.in); //keyboard input
        double a = Math.random();
        double b = Math.random();
        if(a<0.5){
            timed = true;
        }else{
            timed = false;
        }
        if(b<0.5){
            backwards = true;
        }else{
            backwards = false;
        }
        try{//checks if the document exists(it should -_-)
            in = new Scanner(new File("files/riddles.txt"));
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        riddles = new ArrayList <String> ();
        answers = new ArrayList <String> ();
        while(in.hasNext()){
            riddles.add(in.nextLine());//alternates each line
            answers.add(in.nextLine());
        }
    }
    public Riddle(boolean t, boolean b)//test constructor to test each feature(controlled booleans)
    { 
        keyboard = new Scanner(System.in); //keyboard input
        timed = t;
        backwards = b;
        try{//checks if the document exists(it should -_-)
            in = new Scanner(new File("files/riddles.txt"));
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        riddles = new ArrayList <String> ();
        answers = new ArrayList <String> ();
        while(in.hasNext()){
            riddles.add(in.nextLine());//alternates each line
            answers.add(in.nextLine());
        }
    }
    public void run()
    {
        System.out.println("Riddle Mini-Game!");
        try{//pauses code for 1000 milliseconds (1 second)
            Thread.sleep(1000);
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        if(timed){
            if(backwards){
                System.out.println("Timed Mode: On");
                System.out.println("Backwards Mode: On");
                try{//pauses code for 1000 milliseconds (1 second)
                    Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Thread.currentThread().interrupt();
                }
                double x = Math.random();//funny message
                if(x<0.333333333){
                    System.out.println("FeelsBadMan");
                    try{//pauses code for 1000 milliseconds (1 second)
                        Thread.sleep(1000);
                    }catch(InterruptedException ex){
                        Thread.currentThread().interrupt();
                    }
                }else{
                    if(x<0.666666666){
                        System.out.println("Unlucky"); 
                        try{//pauses code for 1000 milliseconds (1 second)
                            Thread.sleep(1000);
                        }catch(InterruptedException ex){
                            Thread.currentThread().interrupt();
                        }
                    }else{
                        System.out.println("LUL");
                        try{//pauses code for 1000 milliseconds (1 second)
                            Thread.sleep(1000);
                        }catch(InterruptedException ex){
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }else{
                System.out.println("Timed Mode: On");
                try{//pauses code for 1000 milliseconds (1 second)
                    Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Thread.currentThread().interrupt();
                }
                System.out.println("GOTTA GO FAST");
                try{//pauses code for 500 milliseconds (0.5 second)
                    Thread.sleep(500);
                }catch(InterruptedException ex){
                    Thread.currentThread().interrupt();
                }
            }
        }else{
            if(backwards){
                System.out.println("Backwards Mode: On");
                try{//pauses code for 1000 milliseconds (1 second)
                    Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Thread.currentThread().interrupt();
                }
                System.out.println("!kcul dooG");
                try{//pauses code for 1000 milliseconds (1 second)
                    Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Thread.currentThread().interrupt();
                }
            }
        }
        System.out.print('\u000C');//Clears window
        int index = (int)(Math.random()*riddles.size());
        String answer;
        System.out.println(riddles.get(index));
        try{//pauses code for 2000 milliseconds (1 second)
                    Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Thread.currentThread().interrupt();
                }
        if(timed){
            int time = (int)(Math.random()*5)+7;
            answer = keyboard.next();
            while(keyboard.hasNext() && time != 0){//reprints window for time
                System.out.println(time + " seconds left!");
                System.out.println(riddles.get(index));
                try{//pauses code for 1000 milliseconds (1 second)
                    Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Thread.currentThread().interrupt();
                }
                time--;
                System.out.print('\u000C');//Clears window
            }
            if(answer.equals(answers.get(index))){
                System.out.println("Correct Answer!");
            }else{
                System.out.println("Wrong Answer! :(");
            }
        }
    }
}
