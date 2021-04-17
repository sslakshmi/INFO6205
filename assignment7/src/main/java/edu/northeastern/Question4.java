package edu.northeastern;

import java.util.Arrays;

public class Question4 {
    public boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        for(int i = 0; i < sArray.length; i++){
            if(sArray[i] != tArray[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        Question4 question4 = new Question4();
        System.out.println(question4.isAnagram(s, t));

        s = "a";
        t = "ab";
        question4 = new Question4();
        System.out.println(question4.isAnagram(s, t));
    }
}
