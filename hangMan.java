import java.util.Scanner;
import java.util.ArrayList;

/**
 * deals with the letters in the hangman game
 * 
 * @author Oliver Jiang
 * @version 5/5/17
 */
public class hangMan
{
    private boolean[] used = new boolean[26];   // true if corresponding letter has been used
    private char[][] phrase;                    // each char[] stores a word
    
    /**
     * constructor
     */
    public hangMan(String myPhrase)
    {
        int numWords = 1;
        for(int i = 0; i < myPhrase.length(); i++)
        {
            if(myPhrase.charAt(i) == ' ')
            {   numWords++;}
        }
        phrase = new char[numWords][0];
        
        int prevInd = 0;
        int curInd;
        for(int n = 0; n < numWords - 1; n++)
        {            
             curInd = myPhrase.indexOf(' ', prevInd);
             int tempLength = curInd - prevInd;
             phrase[n] = new char[tempLength];
             prevInd = curInd;
        }
        phrase[numWords-1] = new char[myPhrase.length() - prevInd];
    }
    
    /**
     * takes the next guess
     * Precondition: used[letterVal] is false
     */
    public void nextGuess(char myGuess)
    {
        int letterVal = (int)myGuess - 97;        
        used[letterVal] = true;
    }
    
    /**
     * temporary toString method for TempDriver
     */
    public String toString()
    {
        String toRet = "";
        for(char[] w : phrase)  // w for word
        {
            for(char l : w)     // l for letter
            {   toRet += l;}
            toRet += " ";
        }
        return toRet;
    }
}