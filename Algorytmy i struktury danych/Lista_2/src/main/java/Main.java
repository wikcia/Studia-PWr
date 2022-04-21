import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        System.out.println("Choose an action you want to perform(Generate random data to CSV(1) or enter your own data(2)):");
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();

        switch (x) {
            case (1) -> convertToCSV("Results.csv");
            case (2) -> {
                System.out.println("Enter type of sorting(INSERTION_SORT, MERGE_SORT, QUICK_SORT, DUAL_PIVOT_QUICKSORT): ");
                Scanner scanner = new Scanner(System.in);
                TypeOfSorting decision = TypeOfSorting.valueOf(scanner.next());
                switch (decision) {
                    case INSERTION_SORT -> {
                        int[] arrayInsertionSort = consoleReader();
                        System.out.println("Given Array");
                        InsertionSort.printArray(arrayInsertionSort);
                        InsertionSort.sort(arrayInsertionSort);
                        System.out.println("\nSorted array");
                        InsertionSort.printArray(arrayInsertionSort);
                    }
                    case MERGE_SORT -> {
                        int[] arrayMergeSort = consoleReader();
                        System.out.println("Given Array");
                        MergeSort.printArray(arrayMergeSort);
                        MergeSort.mergeSort(arrayMergeSort, 0, arrayMergeSort.length - 1);
                        System.out.println("\nSorted array");
                        MergeSort.printArray(arrayMergeSort);
                    }
                    case QUICK_SORT -> {
                        int[] arrayQuickSort = consoleReader();
                        System.out.println("Given Array");
                        QuickSort.printArray(arrayQuickSort);
                        QuickSort.quickSort(arrayQuickSort, 0, (arrayQuickSort.length - 1));
                        System.out.println("\nSorted array");
                        QuickSort.printArray(arrayQuickSort);
                    }
                    case DUAL_PIVOT_QUICKSORT -> {
                        int[] arrayDualPivotQuickSort = consoleReader();
                        System.out.println("Given Array");
                        DualPivotQuickSort.printArray(arrayDualPivotQuickSort);
                        DualPivotQuickSort.dualPivotQuickSort(arrayDualPivotQuickSort, 0, arrayDualPivotQuickSort.length - 1);
                        System.out.println("\nSorted array");
                        DualPivotQuickSort.printArray(arrayDualPivotQuickSort);
                    }
                    case HYBRID_SORTING_ALGORITHM -> {
                        int[] arrayHybridSortingAlgorithm = consoleReader();
                        System.out.println("Given Array");
                        HybridSortingAlgorithm.printArray(arrayHybridSortingAlgorithm);
                        HybridSortingAlgorithm.hybridQuickSort(arrayHybridSortingAlgorithm, 0, arrayHybridSortingAlgorithm.length - 1);
                        System.out.println("\nSorted array");
                        HybridSortingAlgorithm.printArray(arrayHybridSortingAlgorithm);
                    }
                }
            }
        }
    }

    public static void convertToCSV(String fileName) {
        // first create file object for file placed at location
        // specified by filepath
        File file = new File(fileName);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputFile = new FileWriter(file);

            // create CSVWriter object file writer object as parameter
            CSVWriter writer = new CSVWriter(outputFile);

            // adding header to csv
            String[] header = { "Algorithm", "n", "k", "Average Swaps", "Average Compares", "c/n", "s/n" };
            writer.writeNext(header);

            int[] n = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
            int[] k = {1, 10, 100};
            int sumOfComparisons = 0, sumOfSwaps = 0, comparisons = 0, swaps = 0;

            convertInsertionSortOutputToCSV(writer, n, k, sumOfComparisons, sumOfSwaps, comparisons, swaps);
            convertQuickSortOutputToCSV(writer, n, k, sumOfComparisons, sumOfSwaps, comparisons, swaps);
            convertDualPivotQuickSortOutputToCSV(writer, n, k, sumOfComparisons, sumOfSwaps, comparisons, swaps);
            convertHybridSortingAlgorithmOutputToCSV(writer, n, k, sumOfComparisons, sumOfSwaps, comparisons, swaps);
            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void convertInsertionSortOutputToCSV(CSVWriter writer, int[] n, int[] k, int sumOfComparisons, int sumOfSwaps, int comparisons, int swaps) {
        String[] data1;
        for (int j : n) {
            for(int value: k) {
                for(int i = 0; i < value; i++) {
                    // add data to csv
                        int[] generatedArray = InputGenerator.randomGenerator(j);
                        InsertionSort.sort(generatedArray);
                        comparisons = InsertionSort.getComparisons();
                        swaps = InsertionSort.getSwaps();
                    sumOfComparisons = sumOfComparisons + comparisons;

                    sumOfSwaps = sumOfSwaps + swaps;
                    InsertionSort.setZero();
                }
                double averageNumberOfComparisons = (double)(sumOfComparisons/value);
                double averageNumberOfSwaps = (double) sumOfSwaps /value;

                data1 = new String[]{"Insertion Sort", new BigDecimal(j).toPlainString(), new BigDecimal(value).toPlainString(), new BigDecimal(averageNumberOfComparisons).toPlainString(), new BigDecimal(averageNumberOfSwaps).toPlainString(), Double.toString( averageNumberOfComparisons / j), Double.toString( averageNumberOfSwaps / j)};
                writer.writeNext(data1);
                sumOfComparisons = 0;
                sumOfSwaps = 0;
            }
        }
    }

    private static void convertQuickSortOutputToCSV(CSVWriter writer, int[] n, int[] k, int sumOfComparisons, int sumOfSwaps, int comparisons, int swaps) {
        String[] data1;
        for (int j : n) {
            for(int value: k) {
                for(int i = 0; i < value; i++) {
                    // add data to csv
                    int[] generatedArray = InputGenerator.randomGenerator(j);
                    QuickSort.quickSort(generatedArray, 0, generatedArray.length - 1);
                    comparisons = QuickSort.getComparisons();
                    swaps = QuickSort.getSwaps();
                    sumOfComparisons += comparisons;
                    sumOfSwaps += swaps;
                    QuickSort.setZero();
                }
                double averageNumberOfComparisons = (double) sumOfComparisons /value;
                double averageNumberOfSwaps = (double) sumOfSwaps /value;
                data1 = new String[]{"Quick Sort", new BigDecimal(j).toPlainString(), new BigDecimal(value).toPlainString(), new BigDecimal(averageNumberOfComparisons).toPlainString(), new BigDecimal(averageNumberOfSwaps).toPlainString(), Double.toString( averageNumberOfComparisons / j), Double.toString( averageNumberOfSwaps / j)};
                writer.writeNext(data1);
            }
            sumOfComparisons = 0;
            sumOfSwaps = 0;
        }
    }

    private static void convertDualPivotQuickSortOutputToCSV(CSVWriter writer, int[] n, int[] k, int sumOfComparisons, int sumOfSwaps, int comparisons, int swaps) {
        String[] data1;
        for (int j : n) {
            for(int value: k) {
                for(int i = 0; i < value; i++) {
                    // add data to csv
                    int[] generatedArray = InputGenerator.randomGenerator(j);
                    DualPivotQuickSort.dualPivotQuickSort(generatedArray, 0, generatedArray.length - 1);
                    comparisons = DualPivotQuickSort.getComparisons();
                    swaps = DualPivotQuickSort.getSwaps();
                    sumOfComparisons += comparisons;
                    sumOfSwaps += swaps;
                    DualPivotQuickSort.setZero();
                }
                double averageNumberOfComparisons = (double) sumOfComparisons /value;
                double averageNumberOfSwaps = (double) sumOfSwaps /value;
                data1 = new String[]{"Dual Pivot Quick Sort", new BigDecimal(j).toPlainString(), new BigDecimal(value).toPlainString(), new BigDecimal(averageNumberOfComparisons).toPlainString(), new BigDecimal(averageNumberOfSwaps).toPlainString(), Double.toString( averageNumberOfComparisons / j), Double.toString( averageNumberOfSwaps / j)};
                writer.writeNext(data1);
            }
            sumOfComparisons = 0;
            sumOfSwaps = 0;
        }
    }

    private static void convertHybridSortingAlgorithmOutputToCSV(CSVWriter writer, int[] n, int[] k, int sumOfComparisons, int sumOfSwaps, int comparisons, int swaps) {
        String[] data1;
        for (int j : n) {
            for(int value: k) {
                for(int i = 0; i < value; i++) {
                    // add data to csv
                    int[] generatedArray = InputGenerator.randomGenerator(j);
                    HybridSortingAlgorithm.hybridQuickSort(generatedArray, 0, generatedArray.length - 1);
                    comparisons = HybridSortingAlgorithm.getComparisons();
                    swaps = HybridSortingAlgorithm.getSwaps();
                    sumOfComparisons += comparisons;
                    sumOfSwaps += swaps;
                    HybridSortingAlgorithm.setZero();
                }
                double averageNumberOfComparisons = (double) sumOfComparisons /value;
                double averageNumberOfSwaps = (double) sumOfSwaps /value;
                data1 = new String[]{"Hybrid Sorting Algorithm", new BigDecimal(j).toPlainString(), new BigDecimal(value).toPlainString(), new BigDecimal(averageNumberOfComparisons).toPlainString(), new BigDecimal(averageNumberOfSwaps).toPlainString(), Double.toString( averageNumberOfComparisons / j), Double.toString( averageNumberOfSwaps / j)};
                writer.writeNext(data1);
            }
            sumOfComparisons = 0;
            sumOfSwaps = 0;
        }
    }

    private static int[] consoleReader() {
        System.out.println("Enter number of elements in the array: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            System.out.println("Enter " + (i + 1) + " element");
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}
