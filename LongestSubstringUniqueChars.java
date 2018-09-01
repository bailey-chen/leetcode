class Solution {
    public int lengthOfLongestSubstring(String s) {
        // setup string to return
        // max length
        // stirng len
        //start & end indices

        // while end index <= string len
        // substring = s.substring(start, end)
        // letters we've seen for this substring: make hashmap for now...
        // if repeated letters, shift frame
        if (s.isEmpty()) {
            return 0;
        }

        String ret = "";
        int max_length = 0;
        int string_len = s.length();
        int start = 0;
        int end = 0;
        String substring;
        Map<Character, Integer> seenLetters = new HashMap();
        boolean unique = true;

        while (end < string_len) {
            substring = s.substring(start, end);
            seenLetters.clear();
            for (int i = 0; i < substring.length(); i++) {
                char c = substring.charAt(i);
                if (seenLetters.containsKey(c)) {
                    // not unique
                    unique = false;
                    break;

                } else {
                    seenLetters.put(c, 1);
                }
            }
            if (unique) {
                if (substring.length() > max_length) {
                    ret = substring;
                    max_length = substring.length();
                }
                end++;
            } else {
                start ++;
            }
            unique = true;

        }
        return max_length;

    }
}