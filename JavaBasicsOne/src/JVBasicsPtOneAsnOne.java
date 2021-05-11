public class JVBasicsPtOneAsnOne
{
    /**
     * 
     * @param   character   Character to repeat
     * @param   count       Number of times to repeat (< 1 just returns the character as a String no repetition)
     * @return              String of repeated characters (count > 0)
     */
    private static String repeatChar(char character, int count)
    {
        if (count > 0)
        {
            StringBuilder strBuilder = new StringBuilder(count + 1);    //  Allocate space

            strBuilder.append(character);           //  Append first instance
            for (int i = 0; i < count; i++)         //  Repeats character and appends
            {
                strBuilder.append(character);       //  String.replace can also be used (removes loop from seen code)
            }

            return strBuilder.toString();           //  Finalize string and return repeated characters
        }
        else
            return Character.toString(character);   //  Provided argument (count) did not make sense return character with no repetition
    }
    
    public static void main(String[] args)
    {
        StringBuilder strBuilder = new StringBuilder();         //  Use StringBuilder for accumulating strings in loops

        //  Pattern 1
        for (int i = 0; i < 4; i++)                             //  Generate star ladder (1 star [newline] 2 star [newline]...)
        {
            strBuilder.append(repeatChar('*', i) + "\n");
        }
        strBuilder.append(repeatChar('.', 8));                  //  Add repeated dots

        System.out.println("1)\n" + strBuilder.toString());     //  Output Pattern

        strBuilder.setLength(0);                                //  Clear Buffer for next pattern

        //  Pattern 2
        strBuilder.append(repeatChar('.', 9) + "\n");           //  Add repeated dots
        for (int i = 3; i > -1; i--)                            //  Generate star ladder as prev pattern but reversed (4 star [newline]...)
            strBuilder.append(repeatChar('*', i) + "\n");

        System.out.print("2)\n" + strBuilder.toString());       //  Output Pattern

        strBuilder.setLength(0);                                //  Clear Buffer

        //  Pattern 3
        for (int i = 0; i <= 6; i += 2)                         //  Generate star pyramid with spaces added before the stars to center pyramid
        {
            //  Generate spaces needed to center current line of stars
            //  11 dots at the end. first star should be in the sixth position (5 counting from 0)
            //  11 - addedStars(multiples of 2) - middle star = spaces needed
            //  Divide by two to get space needed on one side (before star(s))
            //  It is offseted by one in order to accomodate for repetition (character counts as one already)
            //  Ex. 10 spaces needed
            //  repeatChar(' ', 10) -> 11 characters since the first character does not count as a repeat
            //  NEEDED: repeatChar(char, count) - 1 -> above example now gives us 10 characters
            strBuilder.append(repeatChar(' ', ((11 - i - 1) / 2) - 1));
            strBuilder.append(repeatChar('*', i) + "\n");
        }
        strBuilder.append(repeatChar('.', 10));                 //  Add repeated dots

        System.out.println("3)\n" + strBuilder.toString());     //  Output Pattern

        strBuilder.setLength(0);                                //  Clear Buffer

        //  Pattern 4
        strBuilder.append(repeatChar('.', 11) + "\n");          //  Add repeated dots
        for (int i = 6; i >= 0; i -= 2)                         //  Generate reversed star pyramid with spaces added before the stars to center pyramid
        {
            //  Generate spaces needed to center current line of stars
            //  11 dots at the end. first star should be in the sixth position (5 counting from 0)
            //  11 - addedStars(multiples of 2) - middle star = spaces needed
            //  Divide by two to get space needed on one side (before star(s))
            //  It is offseted by one in order to accomodate for repetition (character counts as one already)
            //  Ex. 10 spaces needed
            //  repeatChar(' ', 10) -> 11 characters since the first character does not count as a repeat
            //  NEEDED: repeatChar(char, count) - 1 -> above example now gives us 10 characters
            strBuilder.append(repeatChar(' ', ((12 - i - 1) / 2) - 1));
            strBuilder.append(repeatChar('*', i) + "\n");
        }

        System.out.println("4)\n" + strBuilder.toString());     //  Output Pattern

        strBuilder.setLength(0);                                //  Clear Buffer
    }
}