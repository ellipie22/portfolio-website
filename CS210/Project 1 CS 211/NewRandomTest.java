import java.util.Scanner;

//Name: Pierre Ellie 
//CS 211 Project 1: New Random Class 
//4/15/2022
//
//This program is an upgrade/expansion of the Random Class that already exists,
// This file is testing the 6 methods from the NewRandom file.
public class NewRandomTest {
	static String[] method = new String[6];
	static String[] errorMsg = new String[2];
	// Set up for possible Errors and the method counts
	// howManyTest is how many times the method will be ran, instructions say 20
	// times so set to that
	// Set up Scanner and Random File calling methods
	static int howManyTest = 20;
	static NewRandom nRand = new NewRandom();
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		loadMenu();
		loadErrorMsg();
		selectNtest();
	}

	// Prints the menu for the user to see available options for which method to
	// test.
	public static void loadMenu() {
		method[0] = "nextInt(int low, int high)";
		method[1] = "nextIntDigit(int digits)";
		method[2] = "nextChar()";
		method[3] = "nextChar( char from, char to) ";
		method[4] = "nextChar(char from, int i)";
		method[5] = "nextSpecialChar()";
	}

	// Prepares both asked error messages for being out of range as well as not
	// imputing an integer.
	public static void loadErrorMsg() {
		errorMsg[0] = "Must be between 0 and 6";
		errorMsg[1] = "Must be digit";
	}

	// Reduces redundancy for printing error messages
	public static void printErrorMsg(int errNumber) {
		System.out.println(errorMsg[errNumber]);
	}

	// tests the imput user submits for it be an integer or not, prompts user to go
	// again if not an integer.
	public static int testInteger() {
		int i = 6;
		boolean temp = true;
		while (temp) {
			String test = input.next();
			try {
				// Try catch tests for integer by attempting to parse input into a int.
				i = Integer.parseInt(test);
				return i;
			} catch (Exception e) {
				// if failed, provides error messages and allows to try again.
				printErrorMsg(1);
				continue;
			}
		}
		return i;

	}

	public static void selectNtest() {
		// title line
		System.out.println("\nProject 1. New Random Class. (Spring Quarter 2022)");
		boolean run = true;
		while (run) {
			// Sets up Menu and prompts user to input prefered test.
			System.out.println("\nWhat method would you like to test?");
			for (int index = 0; index < method.length; index++) {
				System.out.println(index + ". " + method[index]);
			}
			System.out.println(method.length + ": quit");
			// tests for integer
			int whichTest = testInteger();
			// tests if integer is within range
			if (whichTest < 0 || whichTest > 6) {
				printErrorMsg(0);
			}
			// if inputted 6, then quits with message
			if (whichTest == method.length) {
				run = false;
				System.out.println("Bye!");
				break;
			} else {
				// runs specified test otherwise.
				test(whichTest);
			}

		}
	}

	public static void test(int index) {
		// If inputed 0, prompts user to input a low bound and high bound for the
		// nextInt(int low, int high) method
		// Returns random number within the range
		// tests all inputs for integers as well
		// Details for method on NewRandom file.
		if (index == 0) {
			System.out.println("input low");
			int low = testInteger();
			System.out.println("input high");
			int high = testInteger();
			// provides results for howManyTest time, in this case 20.
			System.out.println("\nResult: nextInt(" + low + ", " + high + ")");
			for (int i = 0; i < howManyTest; i++) {
				int a = nRand.nextInt(low, high);
				System.out.print(a + " ");
			}
			System.out.println();
		}

		else if (index == 1) {
			// If inputed 1, prompts user to input a digit count for the method to use and
			// returns random number of that size
			// tests inputs for integers as well
			// Details for method on NewRandom file.
			System.out.println("input digits");
			int digits = testInteger();

			System.out.println("\nResult: nextIntDigit(" + digits + ")");
			// provides results for howManyTest time, in this case 20.

			for (int i = 0; i < howManyTest; i++) {
				int a = nRand.nextIntDigit(digits);
				System.out.print(a + " ");
			}
			System.out.println();
		}

		else if (index == 2) {
			// If inputed 2, runs nextChar method that gives a random character
			// Details for method on NewRandom file.
			System.out.println("\nResult: nextChar()");
			// provides results for howManyTest time, in this case 20.
			for (int i = 0; i < howManyTest; i++) {
				char a = nRand.nextChar();
				System.out.print(a + " ");
			}
			System.out.println();
		}

		else if (index == 3) {
			// If inputed 3, prompts user to input a character lower bound and upper bound
			// Returns random character between bounds
			// Details for method on NewRandom file.
			System.out.println("input char from");
			char from = input.next().charAt(0);
			System.out.println("input char to");
			char to = input.next().charAt(0);
			// provides results for howManyTest time, in this case 20.
			System.out.println("\nResult: nextInt(" + from + ", " + to + ")");
			for (int i = 0; i < howManyTest; i++) {
				char a = nRand.nextChar(from, to);
				System.out.print(a + " ");
			}
			System.out.println();
		}

		else if (index == 4) {
			// If inputed 4, prompts user to input a base character and integer range.
			// Returns random character between base character and distance given.
			// Details for method on NewRandom file.
			System.out.println("input char from");
			char from = input.next().charAt(0);
			System.out.println("input int to");
			int to = testInteger();
			// provides results for howManyTest time, in this case 20.
			System.out.println("\nResult: nextInt(" + from + ", " + to + ")");
			for (int i = 0; i < howManyTest; i++) {
				char a = nRand.nextChar(from, to);
				System.out.print(a + " ");
			}
			System.out.println();
		} else if (index == 5) {
			// If inputed 5, returns random special character
			// Details for method on NewRandom file.
			// provides results for howManyTest time, in this case 20.
			System.out.println("\nResult: nextSpecialChar()");
			for (int i = 0; i < howManyTest; i++) {
				char a = nRand.nextSpecialChar();
				System.out.print(a + " ");
			}
			System.out.println();
		}
	}

}
