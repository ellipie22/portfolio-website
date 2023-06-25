
/*
Pierre Ellie
Bellevue College SID: 950711343

The reason why the original program was showing the incorrect output was because the i variable was changing while the array was also changing
This meant that as i went to 1 and to grab the next character, that character had actually moved to position 0
I fixed this by making the program grab the first two numbers and removing them, then do it again until the array is finished
This varient should work for a longer array list as well. 
*/
import java.util.ArrayList;

public class Quiz4 {
	public static void main(String args[]) {
		ArrayList<Character> myArrayList = new ArrayList<>(); 
		
		// create a list of people
		for (char c='a';c<='f';c++) {
		 myArrayList.add(c);
		}
		// remove first two people from the list to make a team. Each team consists of captain and member.
		boolean run = true;
		while(run == true){
		  char captain = myArrayList.remove(0);

		  char member = myArrayList.remove(0);
		  if (myArrayList.size() == 0) {
			  run = false;
		  }
		  System.out.println("Captain: "+ captain + " Member: "+member);      
		}
	  }
	}
