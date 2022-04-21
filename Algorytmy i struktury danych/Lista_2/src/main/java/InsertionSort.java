public class InsertionSort {

    private static int swaps = 0, comparisons = 0;

    public static int getSwaps() {return swaps;}

    public static int getComparisons() {return comparisons;}

    // Function to sort array using insertion sort
    public static int[] sort(int[] arr) {
        int n = arr.length;
        for (int j = 1; j < n; j++) {
            int key = arr[j];
            int i = j - 1;
 
            // Move elements of arr[0..j-1], that are
            // greater than key, to one position ahead
            // of their current position
            while (i >= 0 && arr[i] > key) {
                comparisons++;
                arr[i + 1] = arr[i];
                swaps++;
                i = i - 1;
            }
            arr[i + 1] = key;
            swaps++;
        }
        return arr;
    }

    public static void setZero() {
        swaps = 0;
        comparisons = 0;
    }

    // A function to print array of size n
    public static void printArray(int[] arr) {
        for (int j : arr) System.out.print(String.format("%02d", j) + " ");
        System.out.println();
    }

}