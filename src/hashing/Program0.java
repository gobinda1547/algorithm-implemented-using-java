package hashing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Here is an example of Hashing algorithm
 * which includes [ Separate Chaining method ]
 */
public class Program0 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scanner = new Scanner(new File("src/hashing/input.txt"));
		long inputValue;
		MyHash myHash = new MyHash((byte) 125);

		while ((inputValue = scanner.nextLong()) != -1) {
			myHash.insert(inputValue);
		}

		while ((inputValue = scanner.nextLong()) != -1) {
			System.out.println("seraching: " + inputValue + " status: " + myHash.search(inputValue));
		}
		scanner.close();

	}

	static class MyHash {

		private byte totalDistinct;
		private ArrayList<ArrayList<Long>> hashTable;
 
		public MyHash(byte totalDistinct) {
			this.totalDistinct = totalDistinct;
			hashTable = new ArrayList<>();
			for (int i = 0; i < totalDistinct; i++) {
				hashTable.add(new ArrayList<>());
			}
		}

		public void insert(long value) {
			byte key = getMyHashCode(value);
			hashTable.get(key).add(value);
		}

		public boolean search(long value) {
			byte key = getMyHashCode(value);
			return hashTable.get(key).contains(value);
		}

		public boolean remove(long value) {
			byte key = getMyHashCode(value);
			return hashTable.get(key).remove(value);
		}

		public byte getMyHashCode(long value) {
			return (byte) (value % totalDistinct);
		}

	}

}
