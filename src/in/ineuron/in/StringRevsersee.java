package in.ineuron.in;

import java.util.Scanner;

public class StringRevsersee {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		for (int i = s.length() - 1; i >= 0; i--) {
			System.out.print(s.charAt(i));
		}
		sc.close();
	}

}
