package in.ineuron.in;

import java.util.Scanner;

public class BinarySearchAlg07 {
	public static int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (arr[mid] == target)
				return mid;

			if (arr[mid] < target)
				left = mid + 1;
			else
				right = mid - 1;
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };

		System.out.print("Enter the target value: ");
		Scanner scanner = new Scanner(System.in);
		int target = scanner.nextInt();
		scanner.close();

		int result = binarySearch(arr, target);
		if (result == -1)
			System.out.println("Target value not found.");
		else
			System.out.println("Target value found at index: " + result);
	}
}
