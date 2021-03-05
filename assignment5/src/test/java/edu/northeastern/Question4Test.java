package edu.northeastern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Question4Test {

    @Test
    void reorganizeString() {
        Question4 question4 = new Question4();
        String s = "aab";
        System.out.println(question4.reorganizeString(s));
    }
}