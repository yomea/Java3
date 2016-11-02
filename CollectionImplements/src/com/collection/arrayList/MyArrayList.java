package com.collection.arrayList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements Iterable<E> {
	
	private Object[] elementData = null;
	private int size = 0;
	
	public MyArrayList() {
		this(10);

		
	}
	public MyArrayList(int cacaptiy) {
		elementData = new Object[cacaptiy];
	}
	
	public boolean add(E obj) {
		
		if(size >= elementData.length) {
			ensureCapacityInternal(elementData.length);
			
		}
		elementData[size++] = obj;
		
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T[] toArray(T[] arr) {
		
		if(arr.length < size) {
			
			return (T[]) Arrays.copyOf(elementData, size, arr.getClass());
		}
		System.arraycopy(elementData, 0, arr, 0, arr.length);
		if(arr.length > size) {
			arr[size] = null;
			
		}
		
		return arr;
	}
	
	@SuppressWarnings("unchecked")
	public E[] toArray() {
			
			return (E[]) Arrays.copyOf(elementData, elementData.length);
		}
	
	public boolean add(MyArrayList<E> list) {
			
		for(int i = 0; i < list.size; i++) {
			this.add(list.get(i));
		}
		
			return true;
	}
	
	public boolean set(int index, E obj) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		ensureCapacityInternal(1);
		System.arraycopy(elementData, index, elementData, index + 1, size - index);
		elementData[index] = obj;
		size ++;
		return true;
		
	}
	
	
	public boolean remove(int index) {
		if(index < 0 || index >= size) {
			
			throw new ArrayIndexOutOfBoundsException();
		
		}
		System.arraycopy(elementData, index + 1, elementData, index, size - index -1);
		size --;
		return true;
		
	}
	
	public boolean remove(E obj) {
		
		for(int i = 0; i < elementData.length; i++) {
			if(obj == elementData[i]) {
				System.arraycopy(elementData, i + 1, elementData, i, size - i - 1);
				size --;
				return true;
			} else if(obj.equals(elementData[i]) && obj.hashCode() == elementData[i].hashCode()) {
				
				System.arraycopy(elementData, i + 1, elementData, i, size - i - 1);
				size --;
				return true;
			}
			
		}
		
		return false;
		
	}
	
	@SuppressWarnings("unchecked")
	public E get(int index) {
		if(index < 0 || index >= size) {
			
				throw new ArrayIndexOutOfBoundsException();
			
		}
		return (E) elementData[index];
		
	}
	
	public void ensureCapacityInternal(int cacaptiy) {
		Object[] newArr = new Object[elementData.length + cacaptiy];
		System.arraycopy(elementData, 0, newArr, 0, elementData.length);
		elementData = newArr;
	}
	
	public int size() {
		
		return size;
	}
	
	public boolean isEmpty() {
		
		return size == 0;
		
	}
	
	public void clear() {
		
		for(int i = 0; i <size; i++) {
			elementData[i] = null;
		}
		size = 0;
	}
	
	public Iterator<E> iterator() {
		
		return new Itr();
	}
	
	private class Itr implements Iterator<E>{
		private int cursor = 0;
		private int lastRet = -1;

		@Override
		public boolean hasNext() {
			return cursor != size();
		}

		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			if(cursor == size()) {
				throw new NoSuchElementException();
				
			}
			lastRet = cursor;
			return (E) elementData[cursor ++];
		}
		
		public void remove() {
			if(lastRet == -1) {
				throw new IllegalStateException();
			}
			MyArrayList.this.remove(lastRet);
			cursor = lastRet;
			lastRet = -1;
			
			
		}
		
		
	}
	
	

}
