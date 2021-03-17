// https://leetcode.com/problems/generate-parentheses/submissions/


class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(result, "", n, n);
        return result;
    }

    public void generateParenthesis(List<String> result, String parentheses, int openingRemaining, int closingRemaining) {
        if (openingRemaining == 0 && closingRemaining == 0) {
            result.add(parentheses);
        } else if (openingRemaining <= closingRemaining) {
            if (openingRemaining > 0) {
                generateParenthesis(result, parentheses + "(", openingRemaining - 1, closingRemaining);
            }
            if (closingRemaining > 0) {
                generateParenthesis(result, parentheses + ")", openingRemaining, closingRemaining - 1);
            }
        }
    }
}