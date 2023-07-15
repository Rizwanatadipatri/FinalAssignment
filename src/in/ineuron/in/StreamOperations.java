package in.ineuron.in;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamOperations {

	public static void main(String[] args) {
		// Create a large dataset
		List<Integer> numbers = new ArrayList<>();
		for (int i = 1; i <= 1000000; i++) {
			numbers.add(i);
		}

		// Example 1: Sorting the data
		List<Integer> sortedNumbers = numbers.stream().sorted(Comparator.reverseOrder()) // Sort in descending order
				.collect(Collectors.toList());
		System.out.println("Sorted Numbers:");
		sortedNumbers.forEach(System.out::println);

		// Example 2: Filtering the data
		List<Integer> filteredNumbers = numbers.stream().filter(n -> n % 2 == 0) // Filter even numbers
				.collect(Collectors.toList());
		System.out.println("\nFiltered Numbers (Even):");
		filteredNumbers.forEach(System.out::println);
	}
}
