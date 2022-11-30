
import java.util.Arrays;
import java.util.Comparator;

/**
 * Your implementation of various iterative sorting algorithms.
 */
public class Sorting {



    private static <T> void swap(T[] arr, int indexA, int indexB){
        T thingTemp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = thingTemp;
        return;
    }


    /**
     * Implement bubble sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n)
     *
     * NOTE: You should implement bubble sort with the last swap optimization.
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
//     */

//    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
//        int lastSwap = arr.length-1;
//        int tempLast = 0;
//        while(lastSwap > 0){
//            tempLast = 0;
//            for (int j = 0; j < lastSwap; j++) {
//                if(comparator.compare(arr[j],arr[j+1]) > 0){
//                    swap(arr, j, j+1);
//                    tempLast = j;
//                }
//            }
//            lastSwap = tempLast;
//            System.out.println(Arrays.toString(arr));
//        }
//    }

    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
        int lastSwap = arr.length-1;
        //System.out.println("start \n" + Arrays.toString(arr) +"\n");
        while(lastSwap > 0){
            int tempLast = 0;
            int j = 0;
            while (j<lastSwap){
                if(comparator.compare(arr[j],arr[j+1]) > 0){
                    swap(arr, j, j+1);
                    tempLast = j;
                }
                j++;
            }
            lastSwap = tempLast;
            //System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * Implement selection sort.
     *
     * It should be:
     * in-place
     * unstable
     * not adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n^2)
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
        for (int i = arr.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(comparator.compare(arr[i], arr[j]) < 0){
                    swap(arr, i, j);
                }
            }
        }
    }

    /**
     * Implement insertion sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n)
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
        for (int i=1; i< arr.length ;i++) {
            int j = i;
            while (j != 0 && comparator.compare(arr[j], arr[j-1]) < 0){
                    swap(arr, j-1, j);
                    j--;
            }
        }
    }


    public static <T> void main(String[] args) {

        class myComparator implements  Comparator<Integer>{
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        }
        Integer[] tester = {1,2,5,4};
        bubbleSort(tester, new myComparator());

        //selectionSort(tester, new myComparator());
        //(tester, new myComparator());

    }

}