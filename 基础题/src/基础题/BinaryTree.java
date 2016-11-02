package 基础题;


class Node {
	
	public int data;
	public Node left;
	public Node right;
	public Node(int data) {
		
		this.data = data;
		this.left = null;
		this.right = null;
		
	}
	
}


public class BinaryTree {
	private Node root;
	public BinaryTree() {
		root = null;
	}
	
	
	public void insert(int data) {
		
		Node newNode = new Node(data);
		if(root ==null) {
			root = newNode;
		} else {
			
			Node current = root;
			
			Node parent;
			
			while(true) {
				
				parent = current;
				
				if(data < current.data) {
					current = current.left;
					if(current == null) {
						parent.left = newNode;
						return;
					}
					
				} else {
					current = current.right;
					if(current == null) {
						parent.right = newNode;
						return;
					}
					
				}
				
			}
			
		}
		
		
	}
	
	
	public void inOrder(Node node) {
		
		if(node != null) {
			inOrder(node.left);
			System.out.println(node.data);
			inOrder(node.right);
		}
		
	}
	
	
public void preOrder(Node node) {
		
		if(node != null) {
			System.out.println(node.data);
			inOrder(node.left);
			inOrder(node.right);
		}
		
	}

public void postOrder(Node node) {
	
	if(node != null) {
		inOrder(node.left);
		inOrder(node.right);
		System.out.println(node.data);
	}
	
}
	
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		int[] data = {2,8,7,4,9,3,1,6,7,5};
		
		for (int i : data) {
			binaryTree.insert(i);
		}
		
//		binaryTree.inOrder(binaryTree.root);
//		binaryTree.preOrder(binaryTree.root);
		binaryTree.postOrder(binaryTree.root);
	}
	

}
