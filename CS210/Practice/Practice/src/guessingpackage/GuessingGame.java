// CS210 Assignment #5 "GuessingGame"
// Pierre Ellie
//This is a guessing game in which you guess a number as many times as wanted then is given overall statistics at the end

import java.util.*;

public class GuessingGame {

    public static void main(String[] args) {
        // write your code to play the number guessing game
        Scanner console = new Scanner(System.in);
        Random rand = new Random();
        double gameCount = 0.0;
        double guesscountTotal = 0.0;
        int bestGameCount = 1000;
        double bestGame = 1.0;
        boolean playing = true;
        //Above is all set up for the game to begin, setting all numbers to zero and creating the classes
        while (playing == true) {
            //this while loop is running as long as the user wants to play the game
            int n = rand.nextInt(100) + 1;
            int guesscount = 0;
            boolean complete = false;
            System.out.println("I'm thinking of a number between 1 and 100...");
            while (complete == false) {
                //this while loop is running as long as the user hasn't gotten the correct guess
                System.out.println("Your guess?");
                int g = console.nextInt();
                //this if statment checks whether the number is correct, then if it is it increases the total variables and tells the user. If not, then it tells higher or lower
                if (checkCorrect(n, g) == false) {
                    System.out.println("It's " + highOrLow(n, g));
                    guesscount++;
                } else {
                    guesscount++;
                    if(guesscount < bestGameCount){
                        bestGameCount = guesscount;
                        bestGame = gameCount + 1;
                    }
                    guesscountTotal = guesscountTotal + guesscount;
                    System.out.println("You guessed it in " + guesscount + " guesses!");
                    complete = true;
                }
            }
            gameCount++;
            //these next couple lines ask the user if they want to play again then checks if the user typed a Y and if they did they play again.
            System.out.println("Play Again?");
            String yesOrNo = console.next();
            yesOrNo = yesOrNo.toLowerCase();
            if (!(yesOrNo.startsWith("y"))) {
                playing = false;
            }
        }
        //The next lines give out the final statistics 
        System.out.println("Your overall results");
        System.out.println("Total games = " + gameCount);
        System.out.println("Total guesses = " + guesscountTotal);
        System.out.println("Guesses/game = " + (guesscountTotal/gameCount));
        System.out.println("Best game = " + bestGame);
    }

    public static String highOrLow(int real, int guess) {
        //this method checks whether the guess is higher or lower than the real number
        if (guess < real) {
            return ("higher.");
        } else {
            return ("lower.");
        }

    }

    public static boolean checkCorrect(int real, int guess) {
        //this method checks whether the guess matches the real number
        if (guess == real) {

            return (true);
        } else {
            return (false);
        }
    }
}
