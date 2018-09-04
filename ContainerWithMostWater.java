class Solution {
    public int maxArea(int[] height) {
        // base cases:
        int n = height.length;
        int[][] area = new int[n][n];
        // len = 0
        int i = 0;
        int j = 0;

        for (; i < n; i++) {
            area[i][i] = 0;
        }

        // len = 1
        i = 0;
        for (; i < n - 1; i++) {
            area[i][i+1] = Math.min(height[i], height[i+1]);
        }

        //recursive case: len = 2,3...n
        int curr_area;
        int max_area;
        for (int len = 2; len <= n; len++) {
            for (i = 0; i < n - len; i++) {
                j = i + len;
                curr_area = len * Math.min(height[i], height[j]);
                max_area = Math.max(Math.max(curr_area, area[i+1][j]), area[i][j-1]);
                area[i][j] = max_area;
            }

        }
        return area[0][n-1];


    }
}