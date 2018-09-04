class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 0) {
            return s;
        }
        boolean[][] palindrome = new boolean[len][len];
        int max_length = 1;
        String longest = s.substring(0,0);

        int j = 0;
        int i;

        for (i = 0; i < len; i++) {
            // base case with one letter (length = 1), is palindrome
            palindrome[i][i] = true;
        }
        for (i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                palindrome[i][i+1] = true;
                if (2 > max_length) {
                    max_length = 2;
                    longest = s.substring(i, i+2);
                }

            } else {
                palindrome[i][i+1] = false;
            }
        }
        i = 0;

        // length 2 to len build upwards (length = 2,3,...,len)
        for (int curr_len = 3; curr_len <= len; curr_len++) {
            // curr_len = 3
            for (i = 0; i < len - curr_len; i++) {
                j = i + curr_len - 1;
                // 1. s[i] == s[j]
                // palindrome[i][j] = palindrome[i+1][j-1]
                // if palindrome[i][j] and j - i + 1 > max_len: max_length =..., longest =
                // 2. palindrome[i][j] = false;
                if (s.charAt(i) == (s.charAt(j))) {
                    palindrome[i][j] = palindrome[i+1][j-1];
                    if (palindrome[i][j] && (j - i + 1 > max_length)) {
                        max_length = j - i + 1;
                        longest = s.substring(i,j+1);
                    }

                } else {
                    palindrome[i][j] = false;
                }
            }
        }
        return longest;




    }

}
