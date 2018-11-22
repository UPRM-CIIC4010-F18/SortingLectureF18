import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

		//long result = factorial(5);

		//boolean result = isPalindrome("racecar");

		int[] testArray = new int[5];
		Random genInts = new Random(521);
		for (int i=0; i<5; i++) {
			testArray[i] = genInts.nextInt(100);
		}
		quickSort(testArray);

	}

	public static void selectionSort(int[] a) {

		for(int i=0; i<a.length; i++) {
			int min = i;
			for (int j=i+1; j<a.length; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}

			int temp = a[min];
			a[min] = a[i];
			a[i] = temp;

		}

	}

	public static void insertionSort(int a[]) {
		for (int i=0; i<a.length-1; i++) {
			int j=i+1;
			while ((j >= 1) && (a[j] < a[j-1])) {
				int temp = a[j];
				a[j] = a[j-1];
				a[j-1] = temp;
				j--;
			}
		}
	}

	public static long factorial(long n) {
		if (n==0) {
			return 1;
		}
		return factorial(n-1) * n;
	}

	public static boolean isPalindrome(String word) {
		if (word.length() <=1) {
			return true;
		}
		else if(word.charAt(0) == word.charAt(word.length()-1)) {
			return isPalindrome(word.substring(1, word.length()-1));
		}
		else {
			return false;
		}
	}

	public static void mergeSort(int[] a) {
		if (a.length > 1) {
			int leftLength = a.length / 2;
			int[] leftSide = Arrays.copyOf(a, leftLength);
			int[] rightSide = Arrays.copyOfRange(a, leftLength, a.length);
			mergeSort(leftSide);
			mergeSort(rightSide);
			merge(leftSide, rightSide, a);
		}
	}

	public static void merge(int[] left, int[] right, int[] dest) {
		int d=0;
		int l=0;
		int r=0;
		while (l < left.length && r < right.length) {
			if (left[l] < right[r]) {
				dest[d] = left[l];
				d++; l++;
			}
			else {
				// left number is larger or equal to right number
				dest[d] = right[r];
				d++; r++;
			}
		}
		while (l < left.length) {
			dest[d] = left[l];
			d++; l++;
		}
		while (r < right.length) {
			dest[d] = right[r];
			d++; r++;
		}
	}
	public static void quickSort(int[] a) {
		quickSort(a, 0, a.length-1);
	}

	// helper method
	private static void quickSort(int[] a, int start, int end) {
		if (start < end) {
			//int pivot = start;
			int midPos = partition(a, start, end);
			quickSort(a, start, midPos); // Sort left part
			quickSort(a, midPos+1, end); // Sort right part
			// Done
		}
	}

	private static int partition(int[] a, int start, int end) {
		int pivot = a[start];
		int i = start;
		int j = end;
		while (i < j) {
			while (a[i] < pivot) {
				i++;
			}
			while (a[j] >= pivot) {
				j--;
			}
			if (i < j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++; j--;
			}
		}
		return j;
	}
}
