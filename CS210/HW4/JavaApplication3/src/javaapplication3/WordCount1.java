/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

/**
 *
 * @author Administrator
 */
public class WordCount1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
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
