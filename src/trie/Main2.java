package trie;

import java.io.File;
import java.util.Scanner;

public class Main2 {

	public static int totalCharacterPossible = 26;
	public static int totalStudent = 100000;
	public static String[] studentList = new String[totalStudent];

	public static void main(String[] args) {

		Trie trie = new Trie();
		System.out.println("done");
		try {
			Scanner scanner = new Scanner(new File("src\\trie\\input2.txt"));
			int totalInsert = Integer.parseInt(scanner.nextLine());
			for (int i = 0; i < totalInsert; i++) {
				studentList[i] = scanner.nextLine();
				// System.out.println("inserting = [" + studentList[i] + "]");
				trie.insertIntoTrie(studentList[i], i);
			}
			scanner.close();

			System.out.println("printing the sorted list");
			for (int i = 1; i <= totalInsert; i++) {
				System.out.println(i + " " + studentList[trie.searchValueByIndex(Trie.rootNode, i, 0)]);
			}

			System.out.println("If we sort inputs then position of [taher] will be "
					+ trie.searchIndexByValue(Trie.rootNode, "taher"));

			System.out.println("If we sort inputs then position of [mahmud] will be "
					+ trie.searchIndexByValue(Trie.rootNode, "mahmud"));

			System.out.println("If we sort inputs then 4th position will be for "
					+ studentList[trie.searchValueByIndex(Trie.rootNode, 4, 0)]);

			System.out.println("If we sort inputs then 8th position will be for "
					+ studentList[trie.searchValueByIndex(Trie.rootNode, 8, 0)]);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	static class Trie {

		private static Node rootNode;

		public Trie() {
			rootNode = new Node();
		}

		public int searchValueByIndex(Node head, int findIndex, int currentIndex) {
			Node currentHead = head;
			if (currentHead.isLeaf) {
				return currentHead.value;
			}
			for (int i = 0; i < currentHead.nextNode.length; i++) {
				if (currentHead.nextNode[i] != null) {
					if (currentIndex + currentHead.nextNode[i].childCount < findIndex) {
						currentIndex += currentHead.nextNode[i].childCount;
					} else {
						return searchValueByIndex(currentHead.nextNode[i], findIndex, currentIndex);
					}
				}
			}
			return -1;
		}

		public int searchIndexByValue(Node head, String data) {
			int ans = 0;
			Node currentHead = head;
			for (int i = 0; i < data.length(); i++) {
				int pos = data.charAt(i) - 'a';
				for (int j = 0; j < pos; j++) {
					if (currentHead.nextNode[j] != null) {
						ans += currentHead.nextNode[j].childCount;
					}
				}
				currentHead = currentHead.nextNode[pos];
			}
			return ans + 1;

		}

		public void insertIntoTrie(String key, int data) {
			Node currentHead = rootNode;
			for (int i = 0; i < key.length(); i++) {
				int pos = key.charAt(i) - 'a';
				if (currentHead.nextNode[pos] == null) {
					currentHead.nextNode[pos] = new Node();
				}
				currentHead.childCount++;
				currentHead = currentHead.nextNode[pos];
			}
			currentHead.isLeaf = true;
			currentHead.childCount++;
			currentHead.value = data;
		}

		public boolean searchIntoTrie(String data) {
			Node currentHead = rootNode;
			for (int i = 0; i < data.length(); i++) {
				int pos = data.charAt(i) - 'a';
				if (currentHead.nextNode[pos] == null) {
					return false;
				}
				currentHead = currentHead.nextNode[pos];
			}
			return currentHead.isLeaf;
		}

		public int searchForStoredValue(String data) {
			Node currentHead = rootNode;
			for (int i = 0; i < data.length(); i++) {
				int pos = data.charAt(i) - 'a';
				if (currentHead.nextNode[pos] == null) {
					return -1;
				}
				currentHead = currentHead.nextNode[pos];
			}
			return currentHead.value;
		}

		public void deleteFromTrie(String data) {
			if (searchIntoTrie(data) == false) {
				return;
			}
			Node curretHead = rootNode;
			for (int i = 0; i < data.length(); i++) {
				int pos = data.charAt(i) - 'a';
				curretHead.childCount--;
				curretHead = curretHead.nextNode[pos];
			}
			curretHead.isLeaf = false;
			curretHead.childCount--;
			curretHead.value = -1;
		}

		class Node {
			boolean isLeaf;
			int childCount;
			Node[] nextNode;
			int value;

			public Node() {
				isLeaf = false;
				childCount = 0;
				value = -1;
				nextNode = new Node[totalCharacterPossible];
				for (int i = 0; i < nextNode.length; i++) {
					nextNode[i] = null;
				}
			}

		}

	}

}
