// CS210 Assignment #4 "Word Count"
// Student name
package javaapplication3;

public class WordCount{
    public static void Main(String [] args){
        wordCount("hello");
        System.out.println("test");
    }
    public static int wordCount(String inputString) {
        // write your code to count the word in the inputString
        int wordAmount = 0;
        System.out.println(inputString);
        System.out.println(inputString.length());
        for (int i = 0; i < inputString.length(); i++) {
            if(inputString.charAt(i) == ' '){
                wordAmount++;
                System.out.println("new word");
            } 
        }
		return wordAmount;
    }
}
