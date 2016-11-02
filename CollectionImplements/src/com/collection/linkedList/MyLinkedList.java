package com.collection.linkedList;

public class MyLinkedList<E> {
	
	private Node header;//链表的节点头

	private Node tail;//链表的结尾
	
	private int size;//记录当前元素的大小
	
	public MyLinkedList() {
		
		
	}
	/**
	 * 在某个位置插入元素
	 * @param index
	 * @param obj
	 */
	public void set(int index, E obj) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node node = new Node();
		node.setObject(obj);
		Node temp1 = header;
		Node temp = null;
		Node temp2 = tail;
		Node prev = null;
		//除以，看看这个index离header近还是tail近
		if(index >= (size >> 1)) {
			
			for(int i = 0; i < index; i++) {
				temp1 = temp1.getNext();
			}
			temp = temp1;
		} else {
			for(int i = 0; i < size - index - 1; i++) {
				temp2 = temp2.getPrev();
			}
			temp = temp2;
		}
		prev = temp.getPrev();
		if(prev != null) {
			
			prev.setNext(node);
			
		} else {
			header = node;
		}
		node.setNext(temp);
		temp.setPrev(node);
		size ++;
	}
	
	public boolean remove(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		Node temp = header;
		
		for(int i = 0; i < index; i++) {
			temp = temp.getNext();
			
		}
		Node prev = temp.getPrev();
		Node next = temp.getNext();
		if(prev != null) {
			
			prev.setNext(next);
		} else {
			
			header = next;
		}
		if(next != null) {
			
			next.setPrev(prev);
		} else {
			
			tail = prev;
		}
		size --;
		return true;
		
	}
	
	public boolean remove(Object obj) {
		if(obj == null) {
			
			return false;
		}
		Node temp = header;
		Node prev = null;
		Node next = null;
		
		while(temp != null) {
			if(temp.getObject() == obj) {
				
				prev = temp.getPrev();
				next = temp.getNext();
				if(prev != null) {
					
					prev.setNext(next);
				} else {
					header = next;
					
				}
				if(next != null) {
					
					next.setPrev(prev);
				} else {
					tail = prev;
				}
				size --;
				return true;
				
			} else if(temp.getObject().equals(obj) && obj.hashCode() == temp.getObject().hashCode()) {
				
				prev = temp.getPrev();
				next = temp.getNext();
				if(prev != null) {
					
					prev.setNext(next);
				} else {
					
					header = next;
				}
				if(next != null) {
					
					next.setPrev(prev);
				} else {
					tail = prev;
				}
				size --;
				return true;
			} 
			temp = temp.getNext();
		}
		
		return false;
		
	}
	
	
	public boolean add(E obj) {
		Node node = new Node();
		node.setObject(obj);
		if(header == null) {
			header = node;
			header.setPrev(null);
			tail = node;
			node.setNext(null);
			
		} else {
			node.setPrev(tail);
			tail.setNext(node);
			tail = node;
			node.setNext(null);
			
			
		}
		size ++;
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public E get(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		Node temp = header;
		
		for(int i = 0; i < index; i++) {
			temp = temp.getNext();
			
		}
		
		return (E) temp.getObject();
	}
	
	public int size() {
		
		return size;
	}

}
