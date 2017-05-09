

public class TempDriver
{
    public static void hangMan()
    {
        hangMan sampleGame = new hangMan("i really like apples");
        System.out.println(sampleGame);
    }
    public static void Riddle(){
        boolean timed = true;
        boolean backwards = true;
        Riddle game = new Riddle(timed, backwards);
        game.run();
    }
}
