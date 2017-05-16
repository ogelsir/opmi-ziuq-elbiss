import java.util.Scanner;
import java.util.ArrayList;

/**
 * deals with the letters in the hangman game
 * deals with data only
 * 
 * @author Oliver Jiang
 * @version 5/5/17
 */
public class hangMan
{
    private boolean[] used = new boolean[26];   // true if corresponding letter has been used
    private char[][] phrase;                    // each char[] stores a word
    private boolean[][] incompletePhrase;       // corresponds to phrase. stores false if not guessed yet, true if guessed
    
    /**
     * constructor
     * initiates proper dimensions for phrase
     * adds each letter to phrase
     */
    public hangMan(String myPhrase)
    {
        int numWords = 1;
        for(int i = 0; i < myPhrase.length(); i++)  // counts number of words
        {
            if(myPhrase.charAt(i) == ' ')
            {   numWords++;}
        }
        phrase = new char[numWords][0];
        incompletePhrase = new boolean[numWords][0];
        
        int prevInd = 0;
        int curInd;
        char[] tempWord;
        int tempLength;
        for(int n = 0; n < numWords-1; n++)   // counts length of each word
        {            
             curInd = myPhrase.indexOf(' ', prevInd);
             tempLength = curInd - prevInd;
             phrase[n] = new char[tempLength]; incompletePhrase[n] = new boolean[tempLength];
             String lul = myPhrase.substring(prevInd, curInd);
             tempWord = myPhrase.substring(prevInd, curInd).toCharArray();
             for(int i = 0; i < tempLength; i++)
             {
                 phrase[n][i] = tempWord[i];
             }
             prevInd = curInd + 1;
        }
        tempLength = myPhrase.length() - prevInd;
        phrase[numWords-1] = new char[tempLength];
        tempWord = myPhrase.substring(prevInd).toCharArray();
        for(int i = 0; i < tempLength; i++)
        {
            phrase[numWords-1][i] = tempWord[i];
        }
    }
    
    /**
     * takes the next guess
     * Precondition: used[letterVal] is false
     */
    public void nextGuess(char myGuess)
    {
        int letterVal = (int)myGuess - 97;        
        used[letterVal] = true;
        for(int w = 0; w < phrase.length; w++)
        {
            for(int l = 0; l < phrase[w].length; l++)
            {
                if(isUsed(phrase[w][l]))
                {
                    incompletePhrase[w][l] = true;
                }
            }
        }
    }
    
    /**
     * @param letter is an int from [0,26) that represents an alphabet letter
     * @return true if that letter has been used and false otherwise
     */
    public boolean isUsed(int letter)
    {
        return used[letter];
    }
    
    /**
     * @param letter is a char from [a,z]
     * @return true if that letter has been used and false otherwise
     */
    public boolean isUsed(char letter)
    {
        int charVal = (int)letter - 97;
        return isUsed(charVal);
    }
    
    /**
     * @return boolean[] used
     */
    public boolean[] getUsed()
    {   return used;}
    
    public char[][] getPhrase()
    {   return phrase;}
    
    public boolean[][] getincompletePhrase()
    {   return incompletePhrase;}
    
    /**
     * temporary toString method for TempDriver
     * returns the phrase
     */
    public String toString()
    {
        String toRet = "";
        for(char[] w : phrase)  // w for word
        {
            for(char l : w)     // l for letter
            {   toRet += String.valueOf(l);}
            toRet += " ";
        }
        return toRet;
    }
}