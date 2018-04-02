package heap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scanner = new Scanner(new File("src/heap/input.txt"));
		int textCase = scanner.nextInt();
		for (int testNumber = 1; testNumber <= textCase; testNumber++) {

			MaxHeap maxHeap = new MaxHeap();
			// MinHeap maxHeap = new MinHeap();
			int n = scanner.nextInt();
			for (int i = 0; i < n; i++)
				maxHeap.push(scanner.nextInt());

			maxHeap.printNow();

			for (int i = 0; i < n; i++)
				System.out.println(maxHeap.pop());

		}
		scanner.close();

	}

	static class MaxHeap {
		private int MAX_TOTAL;
		private int[] array;
		private int NOW_HAVE = 0;

		public MaxHeap() {
			NOW_HAVE = 0;
			MAX_TOTAL = 100000;
			array = new int[MAX_TOTAL];
		}

		public void push(int value) {
			array[NOW_HAVE] = value;
			int childPosition = NOW_HAVE;
			NOW_HAVE++;

			while (childPosition > 0) {
				int parentPosition = (childPosition - 1) / 2;
				if (array[childPosition] > array[parentPosition]) {
					int t = array[childPosition];
					array[childPosition] = array[parentPosition];
					array[parentPosition] = t;
					childPosition = parentPosition;
				} else
					return;
			}
		}

		public int pop() {
			int ret = array[0];
			array[0] = array[NOW_HAVE - 1];
			NOW_HAVE--;
			int parent = 0, maxChild, leftChild, rightChild;
			while (true) {
				maxChild = parent;
				leftChild = parent * 2 + 1;
				rightChild = parent * 2 + 2;
				if (leftChild < NOW_HAVE && array[maxChild] < array[leftChild])
					maxChild = leftChild;
				if (rightChild < NOW_HAVE && array[maxChild] < array[rightChild])
					maxChild = rightChild;
				if (maxChild == parent)
					break;
				int temp = array[maxChild];
				array[maxChild] = array[parent];
				array[parent] = temp;
				parent = maxChild;
			}
			return ret;
		}

		public void printNow() {
			for (int i = 0; i < NOW_HAVE; i++) {
				if (i != 0)
					System.out.print(" ");
				System.out.print(array[i]);
			}
			System.out.println();
		}
	}

	static class MinHeap {
		private int MAX_TOTAL;
		private int[] array;
		private int NOW_HAVE = 0;

		public MinHeap() {
			NOW_HAVE = 0;
			MAX_TOTAL = 100000;
			array = new int[MAX_TOTAL];
		}

		public void push(int value) {
			array[NOW_HAVE] = value;
			int childPosition = NOW_HAVE;
			NOW_HAVE++;

			while (childPosition > 0) {
				int parentPosition = (childPosition - 1) / 2;
				if (array[childPosition] < array[parentPosition]) {
					int t = array[childPosition];
					array[childPosition] = array[parentPosition];
					array[parentPosition] = t;
					childPosition = parentPosition;
				} else
					return;
			}
		}

		public int pop() {
			int ret = array[0];
			array[0] = array[NOW_HAVE - 1];
			NOW_HAVE--;
			int parent = 0, minChild, leftChild, rightChild;
			while (true) {
				minChild = parent;
				leftChild = parent * 2 + 1;
				rightChild = parent * 2 + 2;
				if (leftChild < NOW_HAVE && array[minChild] > array[leftChild])
					minChild = leftChild;
				if (rightChild < NOW_HAVE && array[minChild] > array[rightChild])
					minChild = rightChild;
				if (minChild == parent)
					break;
				int temp = array[minChild];
				array[minChild] = array[parent];
				array[parent] = temp;
				parent = minChild;
			}
			return ret;
		}

		public void printNow() {
			for (int i = 0; i < NOW_HAVE; i++) {
				if (i != 0)
					System.out.print(" ");
				System.out.print(array[i]);
			}
			System.out.println();
		}
	}

}
