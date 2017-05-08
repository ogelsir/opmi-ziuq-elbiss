import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.lang.Math;
import java.util.Timer;
import java.util.TimerTask;
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
    Timer timer; //timer for a time limit
    private boolean finished=true; //boolean for if finished on time
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
        timer = new Timer();
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
        timer = new Timer();
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
        int index = (int)(Math.random()*riddles.size());//FIX THIS LINE, MAY ALSO BE A PROBLEM WITH THE ARRAYLISTS
        String answer;
        if(timed){
            int time = (int)(Math.random()*5)+5;
            //work on timing stuff here
            System.out.println("Seconds to answer: " + time);
            try{//pauses code for 1000 milliseconds (1 second)
                Thread.sleep(1000);
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
            System.out.println("Ready....");
            try{//pauses code for 1000 milliseconds (1 second)
                Thread.sleep(1000);
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
            System.out.println("Set....");
            try{//pauses code for 1000-3000 milliseconds (1-3 second) used to cause tension!
                Thread.sleep(((int)(Math.random()*2)+1)*1000);
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
            System.out.println(riddles.get(index));
            System.out.print("a(n) ");
            timer.schedule(new timeLimit(),time*1000);
            answer = keyboard.next();
            if(!finished){
                System.out.println("The answer was: " + answers.get(index));
            }else{
                if(answer.equals(answers.get(index))){
                    timer.cancel();
                    System.out.println("Correct Answer!");
                }else{
                    timer.cancel();
                    System.out.println("Wrong Answer! :(");
                    try{//pauses code for 1000-3000 milliseconds (1-3 second) used to cause tension!
                        Thread.sleep(((int)(Math.random()*2)+1)*1000);
                    }catch(InterruptedException ex){
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("The answer was: " + answers.get(index));
                }
            }
        }
    }
    class timeLimit extends TimerTask
    {
        public void run()//timertask class, used to stop scanner if time limit is not met
        {
            System.out.println("Time's up!");
            try{//pauses code for 1000 milliseconds (1 second)
                    Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Thread.currentThread().interrupt();
                }
            System.out.println("Type in any letter to continue...");
            finished = false;
            timer.cancel();
        }
    }
}


