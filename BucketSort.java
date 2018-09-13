import java.utils.Arrays;
import Math;

public class BucketSortAlgorithm {

    public static void main(String[] args) {
        // int[] arr

    }

    public static void bucketSort(int[] arr) {
        int index = 0;
        int[] helper = new int[arr.length];
        // use counting sort to get indexes of numbers

        // create 0 -> 9 buckets: new ArrayList()
        // put buckets in arr buckets

        // for index 0 -> max_digit
        // for i: 0 -> arr.length - 1
        // get current digit
        // buckets[digit].add current number
        // traverse through buckets to get a list

        // reflect changes from helper to arr
    }

    public static int numDigits(int i) {
    }

    public static int nthDigit(int num, int index) {
        return num / (Math.pow(10, index));
    }
}