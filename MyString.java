/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        System.out.println(countChar(hello, 'h'));
        System.out.println(countChar(hello, 'l'));
        System.out.println(countChar(hello, 'z'));
        System.out.println(spacedString(hello));
        System.out.println(remove(hello, "hl"));
        System.out.println(subsetOf("pass", "space"));
        //// Put your other tests here.
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        //// Replace the following statement with your code 

        int couter = 0;
        if (str.length() == 0) {return 0;}
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ch) {couter++;}
        }
        return couter;
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
         //// Replace the following statement with your code
         if (str1.length() > str2.length()) {return false;}
         if (str1.equals("")) {return true;}

         while(str1.length() > 0) {
            if ((countChar(str2,str1.charAt(0))  != 0)) {
                    for( int i = 0; i < str2.length(); i++) {
                        if(str2.charAt(i) == str1.charAt(0)) {
                            str1 = str1.substring(1);
                            str2 = str2.substring(0, i) + str2.substring(i+1);
                            break;
                        }
                    }
            }
            else { return false;} 
         }
        return true;
    }

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        //// Replace the following statement with your code
        if(str.length() == 0) {return "";}
        if(str.length() == 1) {
            return str;
        }
        String newstr = "";
        for(int i = 0; i < str.length(); i++) {
            newstr += str.charAt(i);
            newstr += " ";
        }
        newstr = newstr.substring(0, newstr.length()-1);
        return newstr;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        //// Replace the following statement with your code
        
        String str = "";
        for (int i = 0; i < n; i++) {
           int x = 97 + (int) (Math.random() * 26);
           char ch = (char) x;
           str += ch;
        }
        return str;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
       //// Replace the following statement with your code
       for(int i = 0; i < str2.length(); i++) {
            for(int j = 0; j < str1.length(); j++) {
                if(str1.charAt(j) == str2.charAt(i)) {
                    str1 = str1.substring(0, j) + str1.substring(j+1);
                    break;
                }
            }
       }
        return str1;
    }

    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }    
}
