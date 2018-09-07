class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort nums Arrays.sort(nums) // inplace sort
        // loop i from 0 to len - 3
        // ptr1 = i+1
        // ptr2 = len-1
        // finding sum to nums[i]
        // base case:
        if (nums.length < 3) {
            return null;
        }

        Arrays.sort(nums);
        int arr_len = nums.length;
        int l;
        int r;
        List<List<Integer>> solutions = new ArrayList<List<Integer>>();
        for (int i = 0; i < arr_len - 2; i++) {
            int val = nums[i];
            int target = (-1) * val;
            l = i + 1;
            r = arr_len - 1;


            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == target) {
                    List<Integer> curr_sol = new ArrayList<Integer>();
                    curr_sol.add(nums[i]);
                    curr_sol.add(nums[l]);
                    curr_sol.add(nums[r]);

                    solutions.add(curr_sol);

                    j++;
                    k--;
                    // handle duplicates ( which will always be adjacent if exist)
                    while (j < k && nums[j] == nums[j+1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k-1]) {
                        k--;
                    }

                } else if (sum < target) {
                    l++;

                } else { // sum > target
                    r--;
                }

            }


        }
        return solutions;

    }
}