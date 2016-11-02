package ccom.LinkedList;

public class Test {
	
	static Node<Integer> reserverNode = null;

	public static void main(String[] args) {

		Node<Integer> node1 = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(3);

		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(null);

		for (Node<Integer> node = node1; node != null; node = node.getNext()) {

			System.out.println(node);
		}

		System.out.println("####################################");
		reserverNode(node1);
		

		for (Node<Integer> node = reserverNode; node != null; node = node.getNext()) {

			System.out.println(node);
		}
		System.out.println("####################################");
		Node<Integer> reNode = reserverNode2(reserverNode);
		
		for (Node<Integer> node = reNode; node != null; node = node.getNext()) {

			System.out.println(node);
		}

	}

//方法一
	public static Node<Integer> reserverNode(Node<Integer> node) {

		if (node == null || node.getNext() == null) {
			reserverNode = node;

			return reserverNode;

		}

		Node<Integer> tempNode = reserverNode(node.getNext());

		tempNode.setNext(node);

		node.setNext(null);

		return node;

	}
	
	//方法二
	public static Node<Integer> reserverNode2(Node<Integer> node) {
		
		if(node == null) {
			return node;
		} else if(node.getNext() == null) {
			Node<Integer> temp = node.getNext();
			node.setNext(null);
			temp.setNext(node);
			return temp;
		}
		
		Node<Integer> prev = null;
		Node<Integer> middle = node;
		Node<Integer> next = node.getNext();
		
		while(next != null) {
			middle.setNext(prev);
			prev = middle;
			middle = next;
			next = next.getNext();
			
		}
		
		middle.setNext(prev);

		return middle;

	}

}
