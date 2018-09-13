class Solution {
    public void nextPermutation(int[] nums) {
        // swap from neighbors?
        // 1 2 3 4 -> 1 2 4 3
        // 1 2 4 3 -> 1 3 2 4
        //not 1 4 2 3
        // 1 2 4 3
        // 1 2 3 4 NOPE (smaller)
        // 1 2 4 3 NOPE (already have max at position)
        // 1 3 2 4
        // use priority queue to order things?

        // 4 3 2 1 // max ordering if BIGGEST -> smallest (preemptive check?)
        // 1 2 3 4
        // 4 2 1 3
        // nope
        // 4 1 2 3 vs 4 2 3 1
        // 1 2 3 4
        // min of neighbors

        // go through rightmost to leftmore int: see which position we can change

        // if go all the way to index 0 and can't change, then go to lowest order
        //_______________________________________________________

        // if nums length <= 1: return nums

        // if max (check by sorting nums and getting reverse order). if equal, then return ascending sorted nums

        // start with 2nd to right most num, go to left in for loop index i
        // curr_num
        // if left-most: get ascending sorted nums
        // else, get right neighbor
        // if neighbor is greater, swap: break
        // 1 2 3
        // 4 2 1 3
        // 4 2 3 1

        if (nums.length <= 1) {
            return;
        }

        if (nums.length == 2) {
            swap(nums, 0, 1);
            return;
        }

        for (int i = nums.length - 2; i >= 0;  i--) {
            int curr_num = nums[i];
            int right_neighbor = nums[i + 1];
            if (right_neighbor > curr_num) {
                // swap
                swap(nums, i, i+1);
                return;
            }
        }

        // sorted ascending
        Arrays.sort(nums);




    }

    public static void swap(int[] arr, int one, int two) {
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }
}