
// CS210 Assignment #7 "Personality Test"
// Pierre Ellie
//This program takes the file called personality and looks through it, and finds out the personality of the person based on the answers given, whether it be A or B on 70 questions
// and then writes how many of each answer (A or B), the percantage of each, and the resulting personality type. 
import java.util.*;
import java.io.*;

public class PersonalityTest {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner answerFile = new Scanner(new File("personality.txt"));
        //seting up variables for future use
        boolean done = false;
        int locator = 0;
        int locatorPrev= 0;
        System.out.println("**  This program reports the results for Keirsey Personality Test  **");
        //this while loop runs through the entire file as long as there are lines, reseting after each name and answer set
        while (done == false) {
            if (answerFile.hasNextLine()) {
                //prints out the name the current time
                String name = answerFile.nextLine();
                System.out.println();
                System.out.println(name + ":");
                //this if statement runs as long as there are lines, and it basically goes through each answer set(it's guaranteed to be an answer set because the previous line had to be a name)
                if (answerFile.hasNextLine()) {
                    String[] theTests = new String[10];
                    int[] resultsTemp = new int[8];
                    int[] results = new int[8];
                    String answersTemp = answerFile.nextLine();
                    //this for loop groups each section of 7 up into 10 sections and then counts the answers for each trait. 
                    for (int i = 0; i <= 9; i++) {
                        boolean theEnd = false;
                        //while loop finds the point where to divide each section of answers
                        while(theEnd == false){
                            if(locator % 7 == 0 && locator != 0){
                                theTests[i] = answersTemp.substring(locatorPrev, locator);
                               locatorPrev = locator;
                               theEnd = true;
                            }
                           locator++;
                        }
                        resultsTemp = countAnswers(theTests[i]);
                        for (int j = 0; j < resultsTemp.length; j++) {
                            results[j] += resultsTemp[j]; 
                        }
                    }
                    locator = 0;
                    locatorPrev = 0;
                    System.out.print("answers: [");
                    //this for loop writes down all the answers based on the previous counting made
                    for (int index = 0; index < 8; index += 2) {
                        System.out.print(results[index] + "A-");
                        System.out.print(results[index + 1] + "B");
                        if (index != 6) {
                            System.out.print(",");
                        }
                    }
                    //this for loop finds out the percantage of each answer by divinding them and rounding 
                    int[] percent = new int[4];
                    int percentIndex = 0;
                    for (int i = 0; i < 8; i += 2) {
                        double num = results[i + 1] * 100;
                        double deno = results[i] + results[i + 1];
                        percent[percentIndex] = (int) Math.round(num / deno);
                        percentIndex++;
                    }
                    System.out.println("]");
                    System.out.println("percent B: " + Arrays.toString(percent));
                    //This next section creates a array in which they have set up the 4 spots for theresulting type
                    char[] persLetters = new char[4];
                    //This for loop checks the answer count that was recieved from the countAnswers method and then determines which letter to give based which has more A or B
                    for (int i = 0; i < 8; i += 2) {
                        if (i == 0) {
                            if (results[i] > results[i + 1]) {
                                persLetters[0] = 'E';
                            } else if (results[i] < results[i + 1]) {
                                persLetters[0] = 'I';
                            } else {
                                persLetters[0] = 'X';
                            }
                        } else if (i == 2) {
                            if (results[i] > results[i + 1]) {
                                persLetters[1] = 'S';
                            } else if (results[i] < results[i + 1]) {
                                persLetters[1] = 'N';
                            } else {
                                persLetters[1] = 'X';
                            }
                        } else if (i == 4) {
                            if (results[i] > results[i + 1]) {
                                persLetters[2] = 'T';
                            } else if (results[i] < results[i + 1]) {
                                persLetters[2] = 'F';
                            } else {
                                persLetters[2] = 'X';
                            }
                        } else {
                            if (results[i] > results[i + 1]) {
                                persLetters[3] = 'J';
                            } else if (results[i] < results[i + 1]) {
                                persLetters[3] = 'P';
                            } else {
                                persLetters[3] = 'X';
                            }
                        }
                    }
                    System.out.print("type: ");
                    for (int i = 0; i <= 3; i++) {
                        System.out.print(persLetters[i]);
                    }
                    System.out.println();
                }
            } else {
                done = true;
            }
        }
    }
    //This method checks each spot on the string given and then counts how many answers of A or B there were and takes into account which trait does the answer belong to
    public static int[] countAnswers(String resultsString) {
        int readerPosition = 0;
        int[] answerCount = new int[8];
        while (readerPosition < resultsString.length()) {
            char response = resultsString.charAt(readerPosition);
            if (readerPosition == 0) {
                if (response == 'B' || response == 'b') {
                    answerCount[1]++;
                } else if (response == 'A' || response == 'a') {
                    answerCount[0]++;
                }
            } else if (readerPosition == 1 || readerPosition == 2) {
                if (response == 'B' || response == 'b') {
                    answerCount[3]++;
                } else if (response == 'A' || response == 'a') {
                    answerCount[2]++;
                }
            } else if (readerPosition == 3 || readerPosition == 4) {
                if (response == 'B' || response == 'b') {
                    answerCount[5]++;
                } else if (response == 'A' || response == 'a') {
                    answerCount[4]++;
                }
            } else {
                if (response == 'B' || response == 'b') {
                    answerCount[7]++;
                } else if (response == 'A' || response == 'a') {
                    answerCount[6]++;
                }
            }
            readerPosition++;
        }
        return answerCount;
    }
}
