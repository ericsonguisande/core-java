import java.util.*;

public class JVBasicsPtOneAsnTwo
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);                 //  Input from command line/terminal
        //  Random.nextInt(bound) effective range:  0 -> bound - 1
        //  nextInt(100) gives 0 -> 99 = 100 possible values
        //  nextInt(100) + 1 shifts range to 1 -> 100 check
        int randNum = new Random().nextInt(100) + 1;

        System.out.print("Guess a number from 1 to 100: ");     //  Prompt user to guess
        int guessedNum = input.nextInt();                       //  Get user guess

        int attempts = 1;                                       //  Number of attempts (1 since they already guessed once)
        while (attempts < 5)                                    //  Limited to 5 attempts
        {
            if (guessedNum < randNum - 10 || guessedNum > randNum + 10)     //  Guessed Number not within 10 +/- of pseudo-random generated number -> keep guessing (5 attempts)
            {
                System.out.print("Keep Guessing: ");            //  Prompt to keep guessing
                guessedNum = input.nextInt();                   //  Get user guess again
                attempts++;                                     //  Another attempt taken
            }
            else                                                //  User guessed within 10 +/-
            {
                System.out.println("Correct Answer: " + Integer.toString(randNum));     //  Output correct answer

                input.close();                                  //  Cleanup Scanner
                return;                                         //  Program End
            }
        }
        
        System.out.println("Sorry, Correct Answer was " + Integer.toString(randNum));   //  User couldn't guess within 5 attempts
        input.close();                                          //  Cleanup Scanner
    }
}