class Solution {
    public String convert(String s, int numRows) {
        ArrayList<Character>[] rows = new ArrayList[numRows];
        int row = 0;
        int strLen = s.length();
        boolean down = true;

        for (int r = 0; r < numRows; r++) {
            rows[r] = new ArrayList<Character>();
        }

        int i = 0;
        while (i < strLen) {
            rows[row].add(s.charAt(i));
            if (row == 0 && !down) {
                down = true;
                row++;
            } else if ((row == numRows - 1) && down) {
                down = false;
                row--;
            } else if (!down) {
                row--;
            } else { // down
                row++;
            }
            i++;
        }
        // return extended rows[0] w/ rows[1]...rows[numRows-1] to String
        ArrayList<Character> char_list = new ArrayList();
        for (int j = 0; j < numRows; j++) {
            char_list.addAll(rows[j]);
        }
        StringBuilder builder = new StringBuilder(s.length());
        for (Character c: char_list) {
            builder.append(c);
        }

        return builder.toString();


    }
}