package kadane_algorithm;

public class Main {

	public static void main(String[] args) {

		System.out.println(getMaximumSubArraySum(new int[] { 3, -2, 1 }));
		System.out.println(getMaximumSubArraySum(new int[] { 0, -2, -7, 0, 9, 2, -6, 2 }));
		System.out.println(getMaximumSubArraySum(new int[] { 0, 6, -7, 0, 2, -6, 2 }));
		System.out.println(getMaximumSubArraySum(new int[] { 0, 2, 7, -5, 9, 2, -6, 7 }));
		System.out.println(getMaximumSubArraySum(new int[] { 10, 2, -7, 6, 9, 2, -6, -2 }));

	}

	public static int getMaximumSubArraySum(int[] arr) {
		if (arr.length <= 0)
			return -1;

		int currentSum = arr[0], globalSum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			currentSum = Math.max(arr[i], currentSum + arr[i]);
			globalSum = Math.max(globalSum, currentSum);
		}
		return globalSum;
	}

}
