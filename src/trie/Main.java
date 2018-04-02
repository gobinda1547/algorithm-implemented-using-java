package trie;

public class Main {

	public static void main(String[] args) {

		Trie trie = new Trie();

		trie.insert("gobinda");
		trie.insert("gopal");
		trie.insert("taher");
		trie.insert("mahmud");
		trie.insert("zilani");
		trie.insert("turzo");
		trie.insert("turjo");
		trie.insert("root");

		System.out.println("searching zilani = " + trie.search("zilani"));
		System.out.println("deleting zilani = " + trie.delete("zilani"));
		System.out.println("searching zilani = " + trie.search("zilani"));
		System.out.println("deleting zilani = " + trie.delete("zilani"));
		System.out.println("searching zilani = " + trie.search("zilani"));

		trie.insert("abcd");
		trie.insert("sljdfl");
		trie.insert("abcde");

		System.out.println("searching abc = " + trie.search("abc"));
		System.out.println("searching abcd = " + trie.search("abcd"));
		System.out.println("searching abcde = " + trie.search("abcde"));
		System.out.println("searching abcdf = " + trie.search("abcdf"));

	}

	static class Trie {

		private Node rootNode;

		public Trie() {
			rootNode = new Node();
			for (int i = 0; i < 26; i++)
				rootNode.nextNode[i] = null;
		}

		public void insert(String data) {
			Node head = rootNode;
			for (int i = 0; i < data.length(); i++) {
				int pos = data.charAt(i) - 'a';
				if (head.nextNode[pos] == null) {
					head.nextNode[pos] = new Node();
				}
				head = head.nextNode[pos];
			}
			head.isLeaf = true;
		}

		public boolean delete(String data) {
			Node head = rootNode;
			for (int i = 0; i < data.length(); i++) {
				int pos = data.charAt(i) - 'a';
				if (head.nextNode[pos] == null)
					return false;
				head = head.nextNode[pos];
			}
			if (head.isLeaf == false)
				return false;
			head.isLeaf = false;
			return true;
		}

		public boolean search(String data) {
			Node head = rootNode;
			for (int i = 0; i < data.length(); i++) {
				int pos = data.charAt(i) - 'a';
				if (head.nextNode[pos] == null)
					return false;
				head = head.nextNode[pos];
			}
			return head.isLeaf;
		}

		class Node {
			boolean isLeaf;
			Node[] nextNode = new Node[26];

			public Node() {
				isLeaf = false;
				for (int i = 0; i < 26; i++)
					nextNode[i] = null;
			}
		}

	}

}
