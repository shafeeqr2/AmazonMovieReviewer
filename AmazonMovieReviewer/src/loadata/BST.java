package loadata;

public class BST {
	public static Node root;
	
	public BST() {
		this.root = null;
	}
	
	public void add(String userID, userMovie umovie) {
		root = add(root, userID, umovie);
	}
	
	private Node add(Node x, String userID, userMovie umovie) {
		if(x==null) {
			return new Node(userID,umovie);}
		
		int cmp = userID.compareTo(x.getUserID());
		
		if (cmp < 0) x.left = add(x.left, userID, umovie);
		else if(cmp > 0) x.right = add(x.right, userID, umovie);
		else x.add(umovie);
		return x;
	}
	
	public String[] get(String userID) {
		if(root==null) throw new IllegalArgumentException("empty BST");
		Node current = root;
		boolean b = true;
		while( b == true) {
			if(userID.compareTo(current.getUserID())<0)
				current = current.left;
			else if(userID.compareTo(current.getUserID())>0)
				current = current.right;
			else b=false;
		}
		SortedList<String> str = new SortedList<String>();
		int i =0;
		for(userMovie m :current.getMoviesByUser()) {
			if(m.getRating() >= 4.0)
				str.addSortItem(m.getProductId());
				i++;
		}
		String[] str_userID = new String[i];
		for (int j=0;j<i;j++)
			str_userID[j]=str.get(j);
		return str_userID;
		
			
	}
}


