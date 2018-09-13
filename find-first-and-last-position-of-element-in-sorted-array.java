class Solution {
    // optimize memory/space usage
    public int[] searchRange(int[] nums, int target) {
        // divide and conquer
        // keep track of: nums, target, start=0, end nums.length - 1

        // base case
        // if nums length is 0: return [-1,-1]
        // if nums length is 1: if nums[0] == target: return [0,0]

        // recursive case
        // split in half
        // left [i,j] right [k,l]
        // 1. left contains and right contains
        // return [i,l]
        // 2. only left contains
        // return [i,j]
        // 3. only right contains
        // return [k,l]
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            } else {
                return new int[]{-1, -1};
            }
        }
        return searchRangeHelper(nums, target, 0, nums.length - 1);

    }

    int[] searchRangeHelper(int[] nums, int target, int start, int end) {
        // base case
        if (start == end) { // len = 1
            if (nums[start] == target) {
                return new int[]{start,start};
            } else {
                return new int[]{-1, -1};
            }
        }


        // recursive case
        int mid = (start + end) / 2;
        int[] left = searchRangeHelper(nums, target, start, mid);
        int[] right = searchRangeHelper(nums, target, mid + 1, end);

        boolean leftContains = left[0] > -1;
        boolean rightContains = right[0] > -1;
        if (leftContains && rightContains) {
            return new int[]{left[0], right[1]};
        }
        if (leftContains) {
            return left;
        }

        if (rightContains) {
            return right;
        }

        return left;

    }
}