
/*
Pierre Ellie
Bellevue College SID: 950711343

*/
import java.util.*;

public class Quiz5 {
	

	static int getPrecedence(char c) {

		if(c == '+') {
			return 1;
		}else if(c == '-') {
		   return 1;
		}else if(c == '*') {
		   return 2;
		}else if(c == '/') {
		   return 2;
	   }
	   else return 0;
	 }

	public static void main(String[] args){

		System.out.println(getPrecedence('+'));
		System.out.println(getPrecedence('-'));
		System.out.println(getPrecedence('/'));    
		System.out.println(getPrecedence('*'));
   
	   // test with any special character eg)
		System.out.println(getPrecedence('@'));  
		System.out.println(getPrecedence('&'));
		System.out.println(getPrecedence('!'));
		System.out.println(getPrecedence('#'));    
   
	}
}
