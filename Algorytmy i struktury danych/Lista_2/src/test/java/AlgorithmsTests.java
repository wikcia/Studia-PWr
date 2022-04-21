import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlgorithmsTests {

    @Test
    @DisplayName("Should sort random sequence of numbers by Insertion Sort")
    public void test1(){

        int[] possibleValuesOfn = {8, 16, 32};
        for (int n : possibleValuesOfn) {
            int[] array = InputGenerator.randomGenerator(n);
            int[] array2 = InsertionSort.sort(array);
            assertEquals(array,array2);
        }
    }

    @Test
    @DisplayName("Should sort descending sequence of numbers by Insertion Sort")
    public void test2(){

        int[] possibleValuesOfn = {8, 16, 32};
        for (int n : possibleValuesOfn) {
            int[] array = InputGenerator.descendingGenerator(n);
            int[] array2 = InsertionSort.sort(array);
            assertEquals(array,array2);
        }
    }

    @Test
    @DisplayName("Should sort random sequence of numbers by Dual Pivot Quick Sort")
    public void test3(){

        int[] possibleValuesOfn = {8, 16, 32};
        for (int n : possibleValuesOfn) {
            int[] array = InputGenerator.randomGenerator(n);
            int[] array2 = DualPivotQuickSort.dualPivotQuickSort(array, 0, array.length - 1);
            assertEquals(array,array2);
        }
    }

    @Test
    @DisplayName("Should sort descending sequence of numbers by Dual Pivot Quick Sort")
    public void test4(){

        int[] possibleValuesOfn = {8, 16, 32};
        for (int n : possibleValuesOfn) {
            int[] array = InputGenerator.descendingGenerator(n);
            int[] array2 = DualPivotQuickSort.dualPivotQuickSort(array, 0, array.length - 1);
            assertEquals(array,array2);
        }
    }

    @Test
    @DisplayName("Should sort descending sequence of numbers by Merge Sort")
    public void test5(){

        int[] possibleValuesOfn = {8, 16, 32};
        for (int n : possibleValuesOfn) {
            int[] array = InputGenerator.descendingGenerator(n);
            int[] array2 = MergeSort.mergeSort(array, 0, array.length - 1);
            assertEquals(array,array2);
        }
    }

    @Test
    @DisplayName("Should sort random sequence of numbers by Merge Sort")
    public void test6(){

        int[] possibleValuesOfn = {8, 16, 32};
        for (int n : possibleValuesOfn) {
            int[] array = InputGenerator.randomGenerator(n);
            int[] array2 = MergeSort.mergeSort(array, 0, array.length - 1);
            assertEquals(array,array2);
        }
    }

    @Test
    @DisplayName("Should sort random sequence of numbers by Quick Sort")
    public void test7(){

        int[] possibleValuesOfn = {8, 16, 32};
        for (int n : possibleValuesOfn) {
            int[] array = InputGenerator.randomGenerator(n);
            int[] array2 = QuickSort.quickSort(array, 0, array.length - 1);
            assertEquals(array,array2);
        }
    }

    @Test
    @DisplayName("Should sort descending sequence of numbers by Quick Sort")
    public void test8(){

        int[] possibleValuesOfn = {8, 16, 32};
        for (int n : possibleValuesOfn) {
            int[] array = InputGenerator.descendingGenerator(n);
            int[] array2 = QuickSort.quickSort(array, 0, array.length - 1);
            assertEquals(array,array2);
        }
    }
}
