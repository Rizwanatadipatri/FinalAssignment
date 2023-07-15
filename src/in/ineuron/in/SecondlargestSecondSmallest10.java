package in.ineuron.in;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SecondlargestSecondSmallest10 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> numbers = new ArrayList<>();

		System.out.print("Enter the number of elements: ");
		int n = scanner.nextInt();

		System.out.println("Enter the elements:");
		for (int i = 0; i < n; i++) {
			int num = scanner.nextInt();
			numbers.add(num);
		}

		int secondLargest = findSecondLargest(numbers);
		int secondSmallest = findSecondSmallest(numbers);

		System.out.println("Second largest element: " + secondLargest);
		System.out.println("Second smallest element: " + secondSmallest);
	}

	private static int findSecondLargest(List<Integer> numbers) {
		if (numbers.size() < 2) {
			throw new IllegalArgumentException("List must have at least 2 elements");
		}

		Collections.sort(numbers);
		return numbers.get(numbers.size() - 2);
	}

	private static int findSecondSmallest(List<Integer> numbers) {
		if (numbers.size() < 2) {
			throw new IllegalArgumentException("List must have at least 2 elements");
		}

		Collections.sort(numbers);
		return numbers.get(1);
	}
}
