import java.util.Scanner;
/**
 * to test the SlidingPuzzle class
 * 
 * @author Oliver Jiang
 * @version 5/19/17
 */
public class TempSlidingDriver
{
    public static void main()
    {
        SlidingPuzzle sGame = new SlidingPuzzle();
        Scanner in = new Scanner(System.in);
        int num;
        while(!sGame.isGameOver())
        {
            sGame.visualize();
            System.out.print("Swap which ingeger? --> ");
            num = in.nextInt();
            System.out.println(sGame.move(num));
        }
        System.out.println("Game is over!");
    }
}
