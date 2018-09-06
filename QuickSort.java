import java.util.Arrays;

public class QuickSortAlgorithm {
    public static void main(String[] args) {
        int[] arr = new int[] {8,2,5,6,3,5,0};
        quicksort(arr);
        System.out.print(Arrays.toString(arr));
    }
    // in-place sorting

    public static void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);

    }

    public static void quicksort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quicksort(arr, left, pivot - 1);
            quicksort(arr, pivot + 1, right);
        }

    }

    public static int partition(int[] arr, int left, int right) {
        // choose left-most element as pivot index
        int pivot = left;
        int storeIndex = left + 1;// left-most more than partition
        int i = left + 1;

        for (; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, storeIndex, i);
                storeIndex++;
            }

        }

        swap(arr, pivot, storeIndex - 1);
        return storeIndex - 1;
    }

    // iterate i from left + 1 to right

    // if arr[i] < arr[pivot]:
    // swap(arr, storeIndex, i)
    // storeIndex++
    // swap pivot, storeIndex - 1
    // return storeIndex - 1

    public static void swap(int[] arr, int left, int right) {
        if (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }

    }




}