package linklist;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scanner = new Scanner(new File("src/linklist/input.txt"));
		LinkedList list = new LinkedList();
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++){
			list.insert(scanner.nextInt());
			list.printList();
		}

		for (int i = 0; i < n; i++){
			list.printList();
			System.out.println("searching " + i + "  " + list.search(i));
			System.out.println();
		}
		
		for (int i = 0; i < n; i++){
			System.out.println("\ndeleting " + i + "  " + list.delete(i));
			list.printList();
		}

		scanner.close();

	}

	static class LinkedList {

		private Node rootNode;

		public void insert(int data) {
			
			if (rootNode == null) {
				rootNode = new Node(data);
				return;
			}
			Node head = rootNode;
			while (head.nextNode != null) {
				head = head.nextNode;
			}
			head.nextNode = new Node(data);
		}

		public boolean delete(int data) {

			Node currentHead = rootNode;
			Node previousHead = null;
			
			if (currentHead == null) {
				return false;
			}

			if (currentHead.data == data) {
				rootNode = rootNode.nextNode;
				return true;
			}

			while (currentHead != null) {
				if (currentHead.data == data) {
					previousHead.nextNode = currentHead.nextNode;
					return true;
				}
				previousHead = currentHead;
				currentHead = currentHead.nextNode;
			}
			return false;
		}

		public boolean search(int data) {
			Node head = rootNode;
			while (head != null) {
				if (head.data == data) {
					return true;
				}
				head = head.nextNode;
			}
			return false;
		}

		public void printList() {
			Node head = rootNode;
			while (head != null) {
				System.out.print(head.data + " ");
				head = head.nextNode;
			}
			System.out.println();
		}

		class Node {
			int data;
			Node nextNode;

			public Node(int data) {
				this.data = data;
				nextNode = null;
			}

			public Node createNode(int data) {
				return new Node(data);
			}
		}

	}

}
