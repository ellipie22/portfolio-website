// CS210 Assignment #4 "Word Count"
// Pierre Ellie

public class WordCount {


    public static int wordCount(String inputString) {
        int wordAmount = 0;
        //a for loop that runs through the entire string
        for (int i = 0; i < inputString.length(); i++) {
            //The first if and nested if checks that if the string ends with a nonspace charactet than it still counts as a word
            if (i == inputString.length() - 1) {
                if (inputString.charAt(i) != ' ') {
                    wordAmount++;
                }
            }
            //These if statements checks if the character is a space then if it is checks if the character before was a nonspace character
            if (inputString.charAt(i) == ' ') {
                if (i >= 1 && inputString.charAt(i - 1) != ' ') {
                    wordAmount++;
                }
            }
        }
        return wordAmount;
    }
}
