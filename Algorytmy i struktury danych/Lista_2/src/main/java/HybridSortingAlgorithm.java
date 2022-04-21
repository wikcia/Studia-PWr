public class HybridSortingAlgorithm {

    private static int swaps = 0, comparisons = 0;

    public static int getSwaps() {return swaps;}

    public static int getComparisons() {return comparisons;}

    private static void insertionSort(int[] a, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            for (int j = i - 1; j >= low; j--) {
                comparisons++;
                if (a[j] > a[j + 1]) {
                    // Swap
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swaps++;
                }
                else
                    break;
            }
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        int j = low;

        while (i <= high) {
            comparisons += 2;
            if (arr[i] > pivot)
                i++;
            else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                swaps++;
                i++;
                j++;
            }
        }
        return j - 1;
    }

    public static void hybridQuickSort(int[] arr, int low, int high) {
        while (low < high) {
            // Check if array size on which we will be working is less than 10
            if (high - low < 10) {
                insertionSort(arr, low, high);
                break;
            }
            else {
                int pivot = partition(arr, low, high);

                // We will do recursion on small size
                // subarray So we can check pivot - low  and
                // pivot - high

                if (pivot - low < pivot - high) {
                    hybridQuickSort(arr, low, pivot - 1);
                    low = pivot + 1;
                }
                else {
                    hybridQuickSort(arr, pivot + 1, high);
                    high = pivot - 1;
                }
            }
        }
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

