import java.util.Scanner;

public class TempHanoiDriver
{
    public static void main()
    {
        Scanner in = new Scanner(System.in);
        Hanoi hGame = new Hanoi(4);
        while(!hGame.isGameOver())
        {
            hGame.visualize();
            System.out.print("\npeg to remove from: ");
            int from = in.nextInt();
            System.out.print("peg to add to: ");
            int to = in.nextInt();
            System.out.println(hGame.move(from, to));
        }
        System.out.println("Hanoi game is over.");
    }
}
