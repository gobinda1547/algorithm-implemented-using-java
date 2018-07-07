package permutation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scanner = new Scanner(new File("src/permutation/input.txt"));
		int textCase = scanner.nextInt();
		for (int testNumber = 1; testNumber <= textCase; testNumber++) {

			int totalNumber = scanner.nextInt();
			int[] arr = new int[totalNumber];
			for (int i = 0; i < totalNumber; i++) {
				arr[i] = scanner.nextInt();
			}

			performPermuteOperation(arr, 0);

		}
		scanner.close();

	}

	private static void performPermuteOperation(int[] arr, int k) {
		if (k == arr.length) {
			for (int i = 0; i < k; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = k; i < arr.length; i++) {

			int temp = arr[k];
			arr[k] = arr[i];
			arr[i] = temp;

			performPermuteOperation(arr, k + 1);

			temp = arr[k];
			arr[k] = arr[i];
			arr[i] = temp;
		}

	}

}
