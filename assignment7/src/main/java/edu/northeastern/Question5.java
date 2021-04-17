package edu.northeastern;

public class Question5 {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";

        for(int i = 0; i < strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
                if(strs[j].length() <= i || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        Question5 question5 = new Question5();
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(question5.longestCommonPrefix(strs));

        strs = new String[]{"dog","racecar","car"};
        System.out.println(question5.longestCommonPrefix(strs));

    }
}
