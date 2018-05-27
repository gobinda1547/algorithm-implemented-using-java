package binary_search;

import java.util.Random;


/*
 * this program uses loop to find the result
 */
public class Main {

	public static int[] a;

	public static void main(String[] args) {

		a = getRandomInputs();
		printArray(a, "input array is: ");
		int searchValue = 25;
		int ans = binarySearch(searchValue);

		if (ans == -1) {
			System.out.println(searchValue + " not found");
		} else {
			System.out.println(searchValue + " found in position: " + ans);
		}

	}

	public static int binarySearch(int searchValue) {

		int first = 0;
		int last = a.length - 1;
		while (first <= last) {
			int mid = (first + last) / 2;
			if (a[mid] == searchValue) {
				return mid;
			} else if (a[mid] > searchValue) {
				last = mid - 1;
			} else {
				first = mid + 1;
			}
		}

		return -1;

	}

	private static int[] getRandomInputs() {
		int[] in = new int[10];
		for (int i = 0; i < in.length; i++) {
			in[i] = new Random().nextInt(100);
		}
		return in;
	}

	public static void printArray(int[] inputs, String message) {
		System.out.println("printing " + message);
		for (int i = 0; i < inputs.length; i++) {
			System.out.print(inputs[i] + " ");
		}
		System.out.println();
	}

}