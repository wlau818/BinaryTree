/*
 * This class defines a binary tree data structure along with utility methods
 * to make it useful.
 */
public class BinaryTree {
	
	public Node root;
	
	public BinaryTree() {
		root = null;
	}
	
	/*
	 * Methods to insert a new node into the tree.
	 * 
	 * insertNode inserts a new node into the subtree with root
	 * node topNode and returns the new tree structure back with the
	 * same root node.
	 * 
	 * insert is the public interface to the subtreeInsert method and will
	 * be the method actually invoked by the calling program.  Methods like
	 * it are often called "wrapper" methods because they "wrap" the private
	 * methods that do all of the work in a more convenient interface.
	 */
	public void insert(int newRecord) {
		root = subtreeInsert(root, newRecord);
	}
	
	private Node subtreeInsert(Node topNode, int newRecord) {
		if (topNode == null) {
			topNode = new Node(newRecord);
		} else if (newRecord < topNode.record) {
			topNode.left = subtreeInsert(topNode.left, newRecord);
		} else {
			topNode.right = subtreeInsert(topNode.right, newRecord);
		}
		return topNode;
	}
	
	
	/*
	 * Methods to perform an in-order tree traversal.
	 * 
	 * The inOrderSubtree method does all of the work, with inOrder
	 * serving as a wrapper method (see above).
	 */
	public void inOrder() {
		inOrderSubtree(root);
	}
	
	private void inOrderSubtree(Node topNode) {
		if (topNode == null) {
			return;
		} else {
			inOrderSubtree(topNode.left);
			System.out.print(topNode.record + " ");
			inOrderSubtree(topNode.right);
		}
	}
	
	
	/*
	 * Methods to perform a pre-order traversal.
	 */
	public void preOrder() {
		preOrderSubtree(root);
	}
	
	private void preOrderSubtree(Node topNode) {
		if (topNode == null) {
			return;
		} else {
			System.out.print(topNode.record + " ");
			preOrderSubtree(topNode.left);			
			preOrderSubtree(topNode.right);
		}
	}
	
	
	/*
	 * Methods to perform a post-order traversal.
	 */
	public void postOrder() {
		postOrderSubtree(root);
	}
	
	private void postOrderSubtree(Node topNode) {
		if (topNode == null) {
			return;
		} else {
			postOrderSubtree(topNode.left);			
			postOrderSubtree(topNode.right);
			System.out.print(topNode.record + " ");
		}
	}
	
	
	/*
	 * Methods to calculate the size (number of nodes) in a tree.
	 */
	public int size() {
		return subtreeSize(root);
	}
	
	private int subtreeSize(Node topNode) {
		if (topNode == null) {
			return 0;
		} else {
			int i = subtreeSize(topNode.left);
			int j = subtreeSize(topNode.right);
			return i + j + 1;
		}
	}
	
	
	/*
	 * Methods to calculate the maximum depth of a tree.
	 */
	
	public int maxDepth() {
		return subtreeMaxDepth(root);
	}
	
	private int subtreeMaxDepth(Node topNode) {
		if (topNode == null) {
			return 0;
		} else {
			int left = subtreeMaxDepth(topNode.left);
			int right = subtreeMaxDepth(topNode.right);
			if (left > right) {
				return left + 1;
			} else {
				return right + 1;
			}
		}
	}
	
}
