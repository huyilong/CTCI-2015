/*
Bubble sort has worst-case and average complexity both О(n2), 
where n is the number of items being sorted. 
There exist many sorting algorithms with substantially better 
worst-case or average complexity of O(n log n). 
Even other О(n2) sorting algorithms, such as insertion sort, 
tend to have better performance than bubble sort. Therefore, 
bubble sort is not a practical sorting algorithm when n is large.
Performance of bubble sort over an already-sorted list (best-case) 
is O(n). 
*/

public class BubbleSort {
  
    // logic to sort the elements
    public static void bubble_srt(int array[]) {
        
        for (int m = array.length; m >= 0; m--) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i+1]) {
                    swapNumbers(i, i+1, array);
                }
            }
            printNumbers(array);
        }
    }
  //because we are passing the address of the array
   //even if it is passed by value
    //we can still change the value without returning
    private static void swapNumbers(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
  
    private static void printNumbers(int[] input) {
          
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ", ");
        }
        System.out.println("\n");
    }
  
    public static void main(String[] args) {
        int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
        bubble_srt(input);
  
    }
}
