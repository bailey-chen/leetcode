import java.util.Arrays;

public class MergeSortAlgorithm {
    // Lessons: IN PLACE sorting saves space/memory
    /**
     * Returns int array with sorted elements in ARR IN PLACE (save space/memory) (for getting back into algorithms!)
     * @return
     */
    public static void mergeSort(int[] arr) { // mergeSort
        if (arr.length > 1) {
            int[] helper = new int[arr.length];
            mergeSort(arr, helper, 0, arr.length - 1);
        }

    }

    public static void mergeSort(int[] arr, int[] helper, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, helper, left, mid);
            mergeSort(arr, helper, mid + 1, right);
            merge(arr, helper, left, mid, right);
        }
    }

    public static void merge(int[] arr, int[] helper, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left; // helper arr ptr
        // recursive case:
        // while pointer at left < left len AND ptr right < right len:
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                helper[k] = arr[i];
                i++;
            } else {
                helper[k] = arr[j];
                j++;
            }
            k++;
        }

        if (i > mid) {
            // left arr empty, copy rest of right arr
            for (; j <= right; j++) {
                helper[k] = arr[j];
                k++;
            }

        } else {
            // right arr empty, copy rest of left arr
            for (; i <= mid; i++) {
                helper[k] = arr[i];
                k++;
            }

        }
        // transfer helper stuff to arr
        for (int a = left; a <= right; a++ ) {
            arr[a] = helper[a];
        }
    }

}