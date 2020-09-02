package fr.platana.technical.interview;

public class FizzBuzz {

	public static void main(String[] args) {

		specialCase(0);
		for (int i = 1; i <= 100; i++)
			System.out.println(fizzBuzz(i));

	}

	public static String fizzBuzz(int number) {

		if (isMultipleOf(3, number) && isMultipleOf(5, number))
			return "FizzBuzz";
		if (isMultipleOf(3, number))
			return "Fizz";
		if (isMultipleOf(5, number))
			return "Buzz";

		return String.valueOf(number);
	}

	public static void specialCase(int number) {
		System.out.println(number);
	}

	public static boolean isMultipleOf(int multiplier, int numberToCheck) {
		return numberToCheck % multiplier == 0;
	}
}
