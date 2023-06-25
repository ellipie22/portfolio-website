
/*
Pierre Ellie
Bellevue College SID: 950711343
4/27/2022

This program takes the input ABCDEF and then outputs CDEBFA
*/

import java.util.*;

public class Quiz9 {

	
	public static void main(String[] args) {
		int initial = 1000;
		double current = initial;
		double RateA = 0.50;
		double RateD = (RateA / 365);
		int dayCount = 1;
		while((initial/2) < current){
			if((dayCount%30)==0||dayCount==1){
				current = current - 100;
			}
			dayCount++;
			
			current = current - (current * RateD);
			System.out.println("Day " + dayCount + ": Value: " + current);
			
		}
		int monthCount = (dayCount/30);
	System.out.println(current);
	System.out.println(dayCount);
	System.out.println("It will take " + monthCount + " months and " + dayCount%30 + "days for you to lose half your investment.");


   }
	}
