package com.quickSort;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 123, 346, 1244, 5723, 568, 3678, 38, 234 };

		quikSort(arr, 0, arr.length-1);
		
		
		for (int i : arr) {
			System.out.println(i);
		}
		
		

	}

	public static void quikSort(int[] arr, int low, int high) {
		
		int i,j;
		int index;
		
		if(low >= high) {
			
			return;
		}
		
		i = low;
		j = high;
		
		index = arr[i];
		
		while(i < j) {
			
			while(i < j && arr[j] >= index) {
				j--;
			}
			if(i < j) {
				arr[i++] = arr[j];
				
				
			}
			while(i < j && arr[i] < index) {
				i ++;
			}
			if(i < j) {
				arr[j--] = arr[i];
			}
			
		}
			
		arr[i] = index;
		quikSort(arr, low, i - 1);
		quikSort(arr, i + 1, high);


	}

	public static int[] concatArray(int[] a, int[] b) {

		int[] c = new int[a.length + b.length];

		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);

		return c;

	}

}
