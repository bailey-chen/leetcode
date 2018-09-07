class Solution {
    public int strStr(String haystack, String needle) {
        // O(n), n = haystack length

        if (needle == null || needle.length() == 0) {
            return 0;
        }

        if (haystack.length() < needle.length()) {
            return -1;
        }

        int max_haystack_index = haystack.length() - needle.length();

        for (int i = 0; i <= max_haystack_index; i++) {
            int j = 0;
            int h_ptr = i;
            boolean match = false;
            while (j < needle.length() && haystack.charAt(h_ptr) == needle.charAt(j)) {
                if (j == needle.length() - 1) { // reached end
                    match = true;
                }
                h_ptr++;
                j++;
            }

            if (match) {
                return i;
            }
        }
        return -1;
    }


}