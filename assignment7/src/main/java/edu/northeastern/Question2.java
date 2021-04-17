package edu.northeastern;

public class Question2 {
    public String reverseWords(String s) {
        s = s.trim();

        String[] strList = s.split("\\s+");
        StringBuilder result = new StringBuilder();
        for(int i = strList.length - 1; i >= 0 ; i--){
            result.append(strList[i] + " ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        Question2 question2 = new Question2();

        String s = "the sky is blue";
        System.out.println(question2.reverseWords(s));

        s = "   hello world";
        System.out.println(question2.reverseWords(s));

        s = "  Bob   loves    Alice    ";
        System.out.println(question2.reverseWords(s));
    }
}
