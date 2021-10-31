// SayMyLargeNumber.java
// CSCI 1302
// Project 3
// 11-21-2020
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * A program that uses a recursive method to return the string corresponding to the input integer.
 * Integers from 1 up to 9.2 Quintillion
 */

public class spellNumber {
	// number's name to be used in the spelling grouped into String arrays
	private static final String[] tensNames = { "", "", " twenty", " thirty", " forty", " fifty", " sixty", " seventy",      //tens
			" eighty", " ninety" };                                

	private static final String[] numNames = { "", " one", " two", " three", " four", " five", " six", " seven",             // [1,19] numbers
			" eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen",
			" seventeen", " eighteen", " nineteen" };

	// Recursive method to spell out any number between 1 and 9.2 Quintillion
	// Ability for the method to hold a long variable parameter
	// The method returns the spelling corresponding to the input integer 
	public static String sayNum(long number) {                          
		String name = "";
		long result  = 0;

		long quintillion = 1000000000000000000L;
		long quadrillion = 1000000000000000L;
		long trillion    = 1000000000000L;
		int billion      = 1000000000;
		int million      = 1000000;
		int thousand     = 1000;
		int hundred      = 100;
		int ten          = 10;

		// if statements to read input numbers by using recursive concepts
		// Can read up to 9.2 Quintillion 
		if (number >= quintillion) {                                 // quintillions                             
			result = number / quintillion;
			name += numNames [(int) result] + " quintillion";
			return name + sayNum(number % (result * quintillion));
		} else if (number >= quadrillion) {                          //quadrillions
			result = number / quadrillion;
			number %= quadrillion;

			if (result >= hundred && result < thousand) {
				name += numNames[(int) (result / hundred)] + " hundred";
				result %= hundred;
			}

			if (result >= 20) {
				name += tensNames[(int) (result / ten)];
				result %= ten;
			}

			name += numNames[(int) result] + " quadrillion";
			return name + sayNum(number);

		} else if (number >= trillion) {                             //trillions
			result = number / trillion;
			number %= trillion;

			if (result >= hundred && result < thousand) {
				name += numNames[(int) (result / hundred)] + " hundred";
				result %= hundred;
			}

			if (result >= 20) {
				name += tensNames[(int) (result / ten)];
				result %= ten;
			}

			name += numNames[(int) result] + " trillion";
			return name + sayNum(number);		
		} else if (number >= billion) {                             // billions
			result = number / billion;
			number %= billion;
			if (result >= hundred && result < thousand) {
				name += numNames[(int) (result / hundred)] + " hundred";
				result %= hundred;
			}

			if (result >= 20) {
				name += tensNames[(int) (result / ten)];
				result %= ten;
			}

			name += numNames[(int) result] + " billion";
			return name + sayNum(number);
			
		} else if (number >= million) {                             // millions
			result = number / million;
			number %= million;

			if (result >= hundred && result < thousand) {
				name += numNames[(int) (result / hundred)] + " hundred";
				result %= hundred;
			}

			if (result >= 20) {
				name += tensNames[(int) (result / ten)];
				result %= ten;
			}

			name += numNames[(int) result] + " million";
			return name + sayNum(number);

		} else if (number >= thousand) {                           // thousands
			result = number / thousand;
			number %= thousand;
			if (result >= hundred && result < thousand) {
				name += numNames[(int) (result / hundred)] + " hundred";
				result %= hundred;
			}

			if (result >= 20) {
				name += tensNames[(int) (result / ten)];
				result %= ten;
			}

			name += numNames[(int) result] + " thousand";
			return name + sayNum(number);

		} else if (number >= hundred) {                           // hundreds
			result = number / hundred;
			name += numNames[(int) result] + " hundred";
			return name + sayNum(number % (result * hundred));
		} else if (number >= 20) {                                // tens
			result = number / ten;
			name += tensNames[(int) result];
			return name + sayNum(number % (result * ten));
		} else {                                                  // base
			name += numNames[(int) number];
			return name;
		}
	}

	public static void main(String[] args)                       // main method
	{
		Scanner scan = new Scanner(System.in);
		long number = 0;
		boolean run = true;
		while (run) {
			// prompt to ask the user to enter a number
			System.out.println("Please enter a positive number in the range from 1 to 9.2 quintillions: ");
			// try and catch statements to make sure the program does not fail for invalid input
			try {
				number = Long.parseLong(scan.nextLine());
				if (number > 0 && number <= 9200000000000000000L) { 
					run = false;
				}
				else if (number < 0) {
					// defining IllegalArgumentException with a throw statement
					throw new IllegalArgumentException ("Input cannot be negative. ");
				} 
			}

			catch (NumberFormatException e) {                   // NumberFormatExeption for  out of range and for non integer errors
				System.out.print("Input has to be an integer or within the given range. ");
			} 
			catch (IllegalArgumentException e) {                // IllegalArgumentExeption for negative errors
				System.out.print(e.getMessage());
			}
			catch(Exception e) {                                // default exception
				System.out.print("Invalid input. ");
			}
		}
		System.out.println("Spells out: " + spellNumber.sayNum(number));
	}
}