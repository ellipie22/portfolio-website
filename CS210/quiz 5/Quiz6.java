/*
Pierre Ellie
Bellevue College SID: 950711343
4/27/2022

This program has a hashmap for the values of varied special characters and then prints them based on the method getPrecedence
*/
import java.util.*;

public class Quiz6 {


	  
	  
	//runs the program and test characters.	 
	 public static void main(String[] args){

		ArrayList<Integer> al = new ArrayList<Integer>();

 HashSet<Integer> hs = new HashSet<Integer>();

 HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();

 

  for (int i= 0; i<2; i++) {

      al.add(i);

      al.add(i+1);
      System.out.println(al);
      hs.add(i);

      hs.add(i+1);
      System.out.println(hs);
      hm.put(al.get(i), al.get(i+1));
      System.out.println(hm);

      hm.put(hm.get(i), hm.get(i+1));
      System.out.println(hm);

   }  

 

  System.out.println(al);

  System.out.println(hs);

  System.out.println(hm); // {key=value}.  
	 
	  }
	}
