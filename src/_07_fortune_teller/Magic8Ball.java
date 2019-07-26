package _07_fortune_teller;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */


import java.util.Random;

public class Magic8Ball {

	// 1. Make a main method that includes all the steps below….
	public static void main(String[] args) {

	// 2. Make a variable that will hold a random number and put a random number into this variable using "new Random().nextInt(4)"
		int r=new Random().nextInt(4);

	// 3. Print out this variable
		System.out.println(r);

	// 4. Get the user to enter a question for the 8 ball

	// 5. If the random number is 0
		if (r==0) {
			System.out.println("The answer to your question is yes.");
		}

	// -- tell the user "Yes"

	// 6. If the random number is 1
		else if(r==1) {
			System.out.println("The answer to your question is no.");
		}
	// -- tell the user "No"

	// 7. If the random number is 2
		else if(r==2){
			System.out.println("Go ask Google. You ain't paying me enough to care.");
		}

	// -- tell the user "Maybe you should ask Google?"

	// 8. If the random number is 3
		else {
			System.out.println("DESPACITO IS ALWAYS THE ANSWER");
		}

	// -- write your own answer
		
	}

}
