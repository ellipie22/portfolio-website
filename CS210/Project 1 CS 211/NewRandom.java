import java.util.Random;
//Name: Pierre Ellie 
//CS 211 Project 1: New Random Class 
//4/15/2022
//
//This program is an upgrade/expansion of the Random Class that already exists,
// This file creates the 6 methods to test.
public class NewRandom extends Random {
	//nextInt returns a random int within the range given by lower and upper bound
	public int nextInt(int low, int high) {
		int n = nextInt(high - low + 1) + low;
		return n;
	}
	
	public int nextIntDigit(int digits) {
		//nextIntDigit returns a random number with digit count equal to input
		//done by creating random double then multiplying to the size that the inputted digit requires
		double i = Math.random();
		i = Math.pow(10, digits) * i;
		//if statement checks to see if number fits digit criteria
		if (i > Math.pow(10, digits - 1) && i < Math.pow(10, digits)) {
			return (int) i;
		} else {
			return nextIntDigit(digits);
		}

	}

	public char nextChar() {
		//nextChar returns a random letter of the alphabet
		//done by randomly picking one of the ASCII numbers between a and z
		int n = nextInt('a', 'z');
		return (char) n;

	}

	public char nextChar(char from, char to) {
		//nextChar(char from, char to) gives a random letter between the letters given.
		//If checks if the second input is after the first in the alphabet, if it is then randomly picks between them
		if (to > from) {
			int n = nextInt(from, to);
			return (char) n;
			//else if checks if second letter is before the first
		} else if (to < from) {
			//if it is, it finds the distance between each end of the alphabet the letters are
			int n = 1;
			int frontDis = to - 96;
			int backDis = 123 - from;
			//then randomly selects a letter from a pool as large as that distance.
			//if the random number is within the first letter's range, then it picks from that letter and z
			//if random number is within the second number's range, then picks from between a and that letter
			int puller = nextInt(frontDis + backDis) + 1;
			if (puller <= frontDis) {
				n = 96 + puller;
			} else {
				n = 123 - (puller - frontDis);
			}
			return (char) n;
		} else {
			int n = nextInt(from, to);
			return (char) n;
		}

	}

	public char nextChar(char from, int to) {
		//nextChar(char from, int to) returns a random letter from a given range after that letter
		// Similarly ran to nextChar(char from, char to), but if the number is negative, it finds how far back it goes then generates letter.
		if (to < 0) {
			int n = nextInt(from + to, from);
			if (n < 97) {
				int keep = 97 - n;
				n = 123 - keep;
			}
			return (char) n;
		} else if (from + to < 124) {
			int n = nextInt(from, from + to);
			return (char) n;
		} else if (from + to > 124) {
			int n = 1;
			int frontDis = from + to - 122;
			int backDis = 123 - from;
			int puller = nextInt(frontDis + backDis) + 1;
			if (puller <= frontDis) {
				n = 96 + puller;
			} else {
				n = 123 - (puller - frontDis);
			}
			return (char) n;
		} else {
			int n = nextInt(from, to);
			return (char) n;
		}

	}

	public char nextSpecialChar() {
		//nextSpecialChar randomly creates a special character
		//is done by finding the range of special characters, picking a random int of  that range then testing if the char is a digit or letter
		int low = 33;
		int high = 126;
		char c = ' ';
		boolean special = false;
		while (!special) {
			int n = nextInt(low, high);
			c = (char) n;
			if (!Character.isDigit(c) && !Character.isLetter(c)) {
				special = true;
			}
		}

		return c;
	}

}
