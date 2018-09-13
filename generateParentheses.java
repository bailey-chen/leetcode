class Solution {
    // optimization: memoizing solution set for each n = 1,2...n OR
    // restructure to do solution iteratively
    public List<String> generateParenthesis(int n) {
        // recursive structure

        // base case
        ArrayList<String> solutions = new ArrayList<>();
        if (n == 0) {
            solutions.add("");
            return solutions;
        }
        if (n == 1) {
            solutions.add("()");
            return solutions;
        }

        // hash set contains solutionSet
        // HashSet<String> solSet = new HashSet<>();

        // recursive case


        // 1 | n - 1
        // n -1 | 1

        // all together: take right-most b2b parentheses and flip. continue until no b2b parentheses
        String oneParenth = "()";
        // return solSet as list
        List<String> nMinus1 = generateParenthesis(n-1);

        for (String pastSol: nMinus1) {
            solutions.add(oneParenth + pastSol);
            solutions.add(pastSol + oneParenth);
        }

        String latest = solutions.get(solutions.size()-1);
        while (true) {
            int b2b = B2B(latest);
            if (b2b == -1) break;

            // change ()
            StringBuilder sb = new StringBuilder(latest);
            sb.setCharAt(b2b, '(');
            sb.setCharAt(b2b + 1, ')');
            solutions.add(sb.toString());

            latest = solutions.get(solutions.size()-1);
        }


        // RETURN LIST-> SET->LIST!!
        HashSet<String> solSet = new HashSet<>();
        solSet.addAll(solutions);
        ArrayList<String> finalSol = new ArrayList<>();
        finalSol.addAll(solSet);
        return finalSol;



    }
    // returns right-most left index of "("
    static int B2B(String s) {
        // b2b if i = ")" and i + 1 = "("
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == ')' && s.charAt(i + 1) == '(') {
                return i;
            }
        }
        return -1;

    }
}