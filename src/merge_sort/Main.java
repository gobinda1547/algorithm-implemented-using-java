package merge_sort;

import java.util.Random;

public class Main {

	public static int[] inputs;

	public static void main(String[] args) {
		inputs = getRandomInputs();
		printArray(inputs, "before merge sort the array is");
		mergeSort(inputs);
		printArray(inputs, "after merge sort the array is");
	}

	public static void mergeSort(int[] a) {
		int n = a.length;
		if (n < 2) {
			return;
		}
		int mid = n / 2;
		int[] left = new int[mid];
		int[] right = new int[n - mid];
		for (int i = 0; i < mid; i++) {
			left[i] = a[i];
		}
		for (int i = mid, j = 0; i < n; i++, j++) {
			right[j] = a[i];
		}
		mergeSort(left);
		mergeSort(right);
		mergeNow(left, right, a);
	}

	private static int[] mergeNow(int[] l, int[] r, int[] a) {

		int nl = l.length;
		int nr = r.length;
		int i = 0, j = 0, k = 0;

		while (i < nl && j < nr) {
			if (l[i] <= r[j]) {
				a[k++] = l[i++];
			} else {
				a[k++] = r[j++];
			}
		}

		while (i < nl) {
			a[k++] = l[i++];
		}

		while (j < nr) {
			a[k++] = r[j++];
		}
		return a;

	}

	public static void printArray(int[] inputs, String message) {
		System.out.println("printing " + message);
		for (int i = 0; i < inputs.length; i++) {
			System.out.print(inputs[i] + " ");
		}
		System.out.println();
	}

	private static int[] getRandomInputs() {
		int[] in = new int[10];
		for (int i = 0; i < in.length; i++) {
			in[i] = new Random().nextInt(100);
		}
		return in;
	}

}