/*
 * Class: CMSC203 
 * Instructor: Dr. Grigoriy Grinberg & Prof. Ashique Tanveer
 * Description: This program creates a driver class to test the Movie file
 * It has two classes: Movie and Movie driver
 * Due: 6/21/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: _Rebecca Beyene_________
*/
// This import function makes a Scanner object available for the code
import java.util.Scanner;
// This creates a public class: MovieDriver
public class MovieDriver {
	
	public static void main(String[] args) 
	 {
		//These declare and initializes variables resp and response
		String resp;
		Character response;
		
		// creates a new scanner object: Keyboard
		Scanner keyboard= new Scanner (System.in);
		// This creates a do while loop that executes the program as long as response is equal to 'y' or 'Y'
		// This creates a new movie object: movie_1
				Movie movie_1 = new Movie();
		do {
		
		// TODO Auto-generated method stub
		// This prompts the user for input
		System.out.println("Enter the name of a movie");
		// retrieves the variable title from the class Movie and sets it to the input on the next line
		movie_1.setTitle(keyboard.nextLine());
		
		System.out.println("Enter the rating of the movie");
		// retrieves the variable rating from the class Movie and sets it to the input on the next line
		movie_1.setRating(keyboard.nextLine());
		
		System.out.println("Enter the number of tickets sold for this movie");
		// retrieves the variable title from the class Movie and sets it to the input on the next line
		movie_1.setSoldTickets(keyboard.nextInt());
		
		// this gets access to the toString in the movie class
		System.out.println(movie_1.toString());
		
		// prompts the user for an input to restart the program
		System.out.println("Do you want to enter another? (y or n)");
		
		//evaluates the input
		resp=keyboard.next();
		// reads the first character of the input
		response=resp.charAt(0);
		//prompts the user for a correct input should the input be invalid
		while (response != 'Y' && response != 'y' && response != 'N' && response != 'n')
        {	System.out.println("Please enter Yes or No: ");
			resp=keyboard.next();
			response=resp.charAt(0);}
		// restarts the loop if the input is either 'y' or 'Y'
		}while (response=='Y' || response=='y');

	
		// prints out a message and ends the program
		System.out.println("GoodBye");
		// closes the Scanner object Keyboard when the program is done running.
		keyboard.close();
	}
		
}