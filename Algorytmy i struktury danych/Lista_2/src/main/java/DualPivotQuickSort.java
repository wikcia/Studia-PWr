public class DualPivotQuickSort {

    private static int swaps = 0, comparisons = 0;

    public static int getSwaps() {return swaps;}

    public static int getComparisons() {return comparisons;}

    // A utility function to swap two elements in an array
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int[] dualPivotQuickSort(int[] arr, int low, int high) {
        if (low < high) {

            // piv[] stores left pivot and right pivot.
            // piv[0] means left pivot and piv[1] means right pivot
            int[] piv;
            piv = partition(arr, low, high);

            dualPivotQuickSort(arr, low, piv[0] - 1);
            dualPivotQuickSort(arr, piv[0] + 1, piv[1] - 1);
            dualPivotQuickSort(arr, piv[1] + 1, high);
        }
        return arr;
    }

    static int[] partition(int[] arr, int low, int high) {
        comparisons++;
        if (arr[low] > arr[high]) {
            swap(arr, low, high);
            swaps++;
        }
        // p is the left pivot, and q is the right pivot.
        int j = low + 1;
        int g = high - 1, k = low + 1, p = arr[low], q = arr[high];

        while (k <= g) {
            comparisons += 3;

            // If elements are less than the left pivot
            comparisons++;
            if (arr[k] < p) {
                swap(arr, k, j);
                swaps++;
                j++;
            }
            // If elements are greater than or equal to the right pivot
            else if (arr[k] >= q) {

                while (arr[g] > q && k < g) {
                    comparisons += 2;
                    g--;
                }
                swap(arr, k, g);
                swaps++;
                g--;

                comparisons++;
                if (arr[k] < p) {
                    swap(arr, k, j);
                    swaps++;
                    j++;
                }
            }
            k++;
        }
        j--;
        g++;

        // Bring pivots to their appropriate positions.
        swap(arr, low, j);
        swap(arr, high, g);
        swaps += 2;

        // Returning the indices of the pivots
        // because we cannot return two elements
        // from a function, we do that using an array.
        return new int[] { j, g };
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
