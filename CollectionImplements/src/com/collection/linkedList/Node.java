package com.collection.linkedList;

public class Node {
	//前一个节点的引用
	private Node prev;
	//存储的数据
	private Object object;
	//下一个节点的引用
	private Node next;

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	
	
	
	
}
