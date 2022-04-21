
public class QuickSort {

    private static int swaps = 0, comparisons = 0;

    public static int getSwaps() {return swaps;}

    public static int getComparisons() {return comparisons;}

    // A utility function to swap two elements
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*
     * We are using Lomuto partition (pivot selected as the first element of an array)
     */
    public static int partition(int[] arr, int p, int q) {
        int pivot = arr[p];
        int i = p;

        for(int j = p + 1; j <= q; j++) {
            comparisons++;
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
                swaps++;
            }
        }
        swap(arr, i, p);
        swaps++;
        return i;
    }

    public static int[] quickSort(int[] arr, int p, int q) {
        if (p < q) {
            int r = partition(arr, p, q);

            quickSort(arr, p, r - 1);
            quickSort(arr, r + 1, q);
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int j : arr) System.out.print(String.format("%02d", j) + " ");

        System.out.println();
    }
    public static void setZero() {
        swaps = 0;
        comparisons = 0;
    }

}
