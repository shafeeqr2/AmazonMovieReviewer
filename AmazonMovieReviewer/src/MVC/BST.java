package MVC;

public class BST {
	private Node root;

	public BST() {
		this.root = null;
	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {
		if (node == null)
			return 0;
		return node.size;
	}

	public void add(String userID, userMovie umovie) {
		root = add(root, userID, umovie);
	}

	private Node add(Node x, String userID, userMovie umovie) {
		if (x == null) {
			return new Node(userID, umovie);
		}

		int cmp = userID.compareTo(x.getUserID());

		if (cmp < 0)
			x.left = add(x.left, userID, umovie);
		else if (cmp > 0)
			x.right = add(x.right, userID, umovie);
		else {
			x.add(umovie);
			x.size--;
		}


		x.size = size(x.left) + size(x.right) + 1;
		return x;
	}

	public String[] get(String userID) {
		if (root == null)
			throw new IllegalArgumentException("empty BST");
		Node current = root;
		boolean b = true;
		while (b == true) {
			if (userID.compareTo(current.getUserID()) < 0)
				current = current.left;
			else if (userID.compareTo(current.getUserID()) > 0)
				current = current.right;
			else
				b = false;
		}

		SortedList<String> str = new SortedList<String>();
		int i = 0;
		for (userMovie m : current.getMoviesByUser()) {
			if (m.getScore() >= 4.0)
				str.addSortItem(m.getProductId());
			i++;
		}

		String[] str_productID = new String[i];
		for (int j = 0; j < i; j++)
			str_productID[j] = str.get(j);
		return str_productID;
	}

	public Node nodeAtPosition(int n) {
		if (n < 0 || n > size() - 1) {
			throw new IllegalArgumentException("PositionNotFound");
 	}
		return nodeAtPosition(root, n);
	}

	private Node nodeAtPosition(Node node, int n) {
		if (node == null)
			return null;

		int leftsize = size(node.left);
		if (leftsize > n)
			return nodeAtPosition(node.left, n);
		else if (leftsize < n)
			return nodeAtPosition(node.right, n - leftsize - 1);
		else
			return node;

	}

	public void Balance() {
		BST balanced = new BST();
		Balance(balanced, 0, root.size-1);
		this.root = balanced.root;
	}

	public void Balance(BST bst, int l, int r) {
		int median = Math.round((r + l) / 2);
		Node n = nodeAtPosition(median);
		for (userMovie um: n.userMovies)
			bst.add(n.getUserID(),um);
		if (l <= (median - 1))
			Balance(bst, l, median - 1);
		if ((median + 1) <= r)
			Balance(bst, median + 1, r);
	}
}
