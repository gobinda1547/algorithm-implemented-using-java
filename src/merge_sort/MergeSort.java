package merge_sort;

public class MergeSort {

	private int[] array;
	private int[] tempMergeArray;
	private int lenght;

	public static void main(String[] args) {
		int[] inputs = { 2, 56, 1, 4, 5, 9, 0, 21, 6, 3, 4, 52 };
		MergeSort myMergeSort = new MergeSort();
		myMergeSort.sort(inputs);
		myMergeSort.printArray();
	}

	private void printArray() {

		System.out.println("printing array");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public void sort(int[] inputArr) {
		this.array = inputArr;
		this.lenght = inputArr.length;
		this.tempMergeArray = new int[lenght];
		doMergeSort(0, this.lenght - 1);
	}

	private void doMergeSort(int low, int high) {

		if (low < high) {
			int mid = low + (high - low) / 2;
			doMergeSort(low, mid);
			doMergeSort(mid + 1, high);
			mergeParts(low, mid, high);
		}

	}

	private void mergeParts(int low, int mid, int high) {

		for (int i = low; i <= high; i++) {
			tempMergeArray[i] = array[i];
		}
		int i = low;
		int j = mid + 1;
		int k = low;

		while (i <= mid && j <= high) {
			if (tempMergeArray[i] <= tempMergeArray[j]) {
				array[k++] = tempMergeArray[i++];
			} else {
				array[k++] = tempMergeArray[j++];
			}
		}
		while (i <= mid) {
			array[k++] = tempMergeArray[i++];
		}

		while (j <= high) {
			array[k++] = tempMergeArray[j++];
		}
	}

}