import java.util.*;

/**
 * Your implementation of various divide & conquer sorting algorithms.
 */

public class Sorting {

    /**
     * Implement merge sort.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of: O(n log n)
     * And a best case running time of: O(n log n)
     *
     * You can create more arrays to run merge sort, but at the end, everything
     * should be merged back into the original T[] which was passed in.
     *
     * When splitting the array, if there is an odd number of elements, put the
     * extra data on the right side.
     *
     * Hint: You may need to create a helper method that merges two arrays
     * back into the original T[] array. If two data are equal when merging,
     * think about which subarray you should pull from first.
     *
     * You may assume that the passed in array and comparator are both valid
     * and will not be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array to be sorted.
     * @param comparator The Comparator used to compare the data in arr.
     */

    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        if(arr.length <= 1){
            return;
        }
        int length = arr.length;
        int mid = length/2;
        int leftStart = 0;
        int leftEnd = mid;
        int rightStart = mid;
        int rightEnd = length;

        T[] leftArray = (T[]) new Object[leftEnd - leftStart];
        for(int i=0; i<leftEnd; i++){
            leftArray[i] = arr[i];
        }
        T[] rightArray = (T[]) new Object[rightEnd - rightStart];
        for(int i=mid; i<rightEnd; i++){
            rightArray[i-mid] = arr[i];
        }
        mergeSort(leftArray,comparator);
        mergeSort(rightArray,comparator);

        int i =0;
        int j =0;
        while(i<leftArray.length && j<rightArray.length){
            if(comparator.compare(leftArray[i],rightArray[j])<=0){
                arr[i+j] = leftArray[i];
                i++;
            }
            else{
                arr[i+j] = rightArray[j];
                j++;
            }
        }
        while (i<leftArray.length){
            arr[i+j] = leftArray[i];
            i++;
        }
        while (j<rightArray.length){
            arr[i+j] = rightArray[j];
            j++;
        }
        return;
    }

    /**
     * Implement LSD (least significant digit) radix sort.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of: O(kn)
     * And a best case running time of: O(kn)
     *
     * Feel free to make an initial O(n) passthrough of the array to
     * determine k, the number of iterations you need.
     *
     * At no point should you find yourself needing a way to exponentiate a
     * number; any such method would be non-O(1). Think about how how you can
     * get each power of BASE naturally and efficiently as the algorithm
     * progresses through each digit.
     *
     * You may use an ArrayList or LinkedList if you wish, but it should only
     * be used inside radix sort and any radix sort helpers. Do NOT use these
     * classes with merge sort. However, be sure the List implementation you
     * choose allows for stability while being as efficient as possible.
     *
     * Do NOT use anything from the Math class except Math.abs().
     *
     * You may assume that the passed in array is valid and will not be null.
     *
     * @param arr The array to be sorted.
     */
    public static void lsdRadixSort(int[] arr) {

        //find max value
        int maxValue = Integer.MAX_VALUE;

        for (int element: arr) {
            int elementTemp = element;
            if(elementTemp>0){
                elementTemp = (-1)*elementTemp;
            }
            if(elementTemp < maxValue){
                maxValue = elementTemp;
            }
        }

        //find digit length
        int k=1;
        while(maxValue/10 != 0){
            maxValue = maxValue/10;
            k++;
        }

        //make buckets
        Queue[] buckets = new Queue[19];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<Integer>();
        }

        int arrLength = arr.length;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < arrLength; j++) {
              int digit = arr[j]/((int)Math.pow(10,i)) % (10);
              buckets[digit + 9].add(arr[j]);
            }
            int arrPutIndex = 0;
            for (Queue<Integer> bucket:buckets) {
                while (bucket.peek() != null){

                    arr[arrPutIndex] = bucket.poll();
                    arrPutIndex++;
                }
            }
        }
    }


    public static void main(String[] args) {

        class myComparator implements Comparator<Integer>{
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        }

        myComparator comp = new myComparator();

        Integer[] arr = {123,412,-123};
        mergeSort(arr, comp);
        System.out.println(Arrays.toString(arr));

//        int[] arr = {8888,444444,-2222,-1000,-1000000,-999,-99999999, 12312351};
//        lsdRadixSort(arr);
//        System.out.println(Arrays.toString(arr));
//

    }
}