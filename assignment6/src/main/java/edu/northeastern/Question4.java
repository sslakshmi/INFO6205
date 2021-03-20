package edu.northeastern;

import java.util.*;

public class Question4 {
    public static void main(String[] args) {
        Question4 question4 = new Question4();
        System.out.println(question4.generateParenthesis(2));
    }


    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        generateParenthesis(result, "", 0, 0, n);
        return result;
    }

    public void generateParenthesis(List<String> result, String currentString, int open, int close, int n){
        if (currentString.length() == n * 2) {
            result.add(currentString);
            return;
        }

        if (open < n)
            generateParenthesis(result, currentString+"(", open+1, close, n);
        if (close < open)
            generateParenthesis(result, currentString+")", open, close+1, n);
    }
}
