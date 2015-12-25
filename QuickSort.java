/*
On an average Quicksort Algorithm has the complexity of O(nlogn) 
and in the worst case it has O(n²) when the elements of the input 
array are already sorted in ascending or descending order. 
Good thing about Quicksort is that it's an in place algorithm,
 which means it does not takes any additional space, except those 
 used by method stack. 

*/
 import java.util.*;

public class QuickSort {

	public static final int ARRAY_SIZE = 50;

	public static void main(String[] args) {
		Random r = new Random();
		int[] array = new int[ARRAY_SIZE];
		for (int i = 0; i < array.length; i++)
			array[i] = r.nextInt(99);

		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println("");

		sort(array);

		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println("");
	}

	private static class Interval {
		public int a;
		public int b;

		public Interval(int a, int b) { this.a = a; this.b = b; }
	}

	/**
	 * Quicksorts array[a ... b], inclusive.
	 */
	public static void sort(int[] array) {
		int pivot, pivotvalue, split, i;
		LinkedList<Interval> todo = new LinkedList<Interval>();
		todo.add(new Interval(0, array.length - 1));

		while (!todo.isEmpty()) {
			Interval inter = todo.removeFirst();
			int a, b;
			a = inter.a; b = inter.b;

			System.out.println("Sorting array[" + a + "..." + b + "])");

			if (a >= b)
				continue;

			/* Pick last element as pivot -- but it doesn't need to be. */
			pivot = b;
			pivotvalue = array[pivot];
			/* Split between lower and higher elements. */
			split = a;
			swap(array, pivot, b);
			System.out.println("Pivot is " + pivotvalue + ".");
			for (i = a; i < b; i++) {
				if (array[i] < pivotvalue) {
					System.out.println(array[i] + " is less than pivot.");
					/* Get array[i] to the left side and move the split over. */
					swap(array, i, split++);
				} else {
					/* Just leave array[i] where it is -- it's fine. */
					System.out.println(array[i] + " is greater than (or equal to) pivot.");
				}
			}
			/* Put pivot between low and high ranges. */
			swap(array, split, b);

			/* Add low and high ranges to to-do list. */
			todo.addLast(new Interval(a, split - 1));
			todo.addLast(new Interval(split + 1, b));
		}
	}

	protected static void swap(int[] array, int i, int j) {
		int temp;

		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}