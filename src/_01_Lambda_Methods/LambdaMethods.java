package _01_Lambda_Methods;

import javax.xml.stream.events.Characters;

public class LambdaMethods {
	public static void main(String[] args) {
		// 1. Look at the SpecialPrinter function interface.

		// Here is an example of calling the printCustomMessage method with a lambda.
		// This prints the passed in String 10 times.
		printCustomMessage((s) -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(s);
			}
		}, "repeat");

		// 2. Call the printCustonMessage method using a lambda so that the String
		// prints backwards.
		printCustomMessage((s) -> {
			StringBuilder str = new StringBuilder();

			for (int i = s.length(); i > 0; i--) {

				str.append(s.charAt(i - 1));
			}
			System.out.println(str.toString());

		}, "backwards");

		// 3. Call the printCustonMessage method using a lambda so that the String
		// prints with a mix between upper an lower case characters.

		printCustomMessage((s) -> {
			StringBuilder str = new StringBuilder(s);
			for (int i = 0; i < s.length(); i++) {
				if (i % 2 == 0) {
					str.setCharAt(i, Character.toUpperCase(str.charAt(i)));
				}
			}
			System.out.println(str.toString());

		}, "Mix up this long sentence of every other character being and uppercase and lowercase.");

		// 4. Call the printCustonMessage method using a lambda so that the String
		// prints with a period in between each character.

		printCustomMessage((s) -> {
			StringBuilder str = new StringBuilder(s);
			for (int i = 0; i < s.length(); i++) {
				str.insert(2*i, '.');
			}
			System.out.println(str.toString());

		}, "There is a period in between each character.");

		// 5. Call the printCustonMessage method using a lambda so that the String
		// prints without any vowels.

		printCustomMessage((s) -> {
			StringBuilder str = new StringBuilder(s);
			System.out.println(str.charAt(0));
			for (int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'y' || str.charAt(i) == 'u' || str.charAt(i) == 'i' || str.charAt(i) == 'o') {
					str.deleteCharAt(i);
				}
				
			}
			System.out.println(str.toString());
		}, "There are definetly no vowels in this sentence.");
	}

	public static void printCustomMessage(SpecialPrinter sp, String value) {
		sp.printSpecial(value);

	}
}
