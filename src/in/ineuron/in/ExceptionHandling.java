package in.ineuron.in;

import java.util.Scanner;

public class ExceptionHandling {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int num = sc.nextInt();
		try {
			if (num < 0) {
				throw new NegativeNumberException("The entered num is negative number");

			}
			System.out.println("The enterd number is" + num);

		} catch (NegativeNumberException ne) {
			System.out.println("the exception caught" + ne.getMessage());
		}
		sc.close();
	}

}

@SuppressWarnings("serial")
class NegativeNumberException extends Exception {
	public NegativeNumberException(String message) {
		super(message);
	}

}
