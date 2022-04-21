public class MergeSort {

    // Main function that sorts arr[l..r] using merge()
    public static int[] mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
        return arr;
    }
    // Merges two sub-arrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    public static void merge(int[] arr, int l, int m, int r) {
        // Find sizes of two sub-arrays to be merged
        int size1 = m - l + 1;
        int size2 = r - m;

        // Create temp arrays
        int[] leftArray = new int[size1];
        int[] rightArray = new int[size2];

        // Copy data to temp arrays
        System.arraycopy(arr, l, leftArray, 0, size1);

        for (int j = 0; j < size2; j++) {
            rightArray[j] = arr[m + 1 + j];
        }

        // Merge the temp arrays

        // Initial indexes of first and second sub-arrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;

        while (i < size1 && j < size2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // A state after merging two arrays
        if(arr.length < 50) {
            System.out.println();
            for (int value : arr) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        // i, j and k are established after the loop has finished its iterations
        // Copy remaining elements of leftArray[] if any
        while (i < size1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray[] if any
        while (j < size2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
    // A function to print array of size n
    public static void printArray(int[] arr) {

        for (int j : arr) System.out.print(String.format("%02d", j) + " ");
        System.out.println();
    }

}