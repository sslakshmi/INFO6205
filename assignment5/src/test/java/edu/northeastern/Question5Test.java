package edu.northeastern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Question5Test {

    @Test
    void countOnesTest1() {
        Question5 question5 = new Question5();
        int[] arr = new int[]{1, 1, 0, 0, 0, 0, 0};
        System.out.println(question5.countOnes(arr));
        Assertions.assertEquals(2, question5.countOnes(arr));
    }

    @Test
    void countOnesTest2() {
        Question5 question5 = new Question5();
        int[] arr = new int[]{};
        System.out.println(question5.countOnes(arr));
        Assertions.assertEquals(0, question5.countOnes(arr));
    }

    @Test
    void countOnesTest3() {
        Question5 question5 = new Question5();
        int[] arr = new int[]{0,0,0,0};
        System.out.println(question5.countOnes(arr));
        Assertions.assertEquals(0, question5.countOnes(arr));
    }

    @Test
    void countOnesTest4() {
        Question5 question5 = new Question5();
        int[] arr = new int[]{1,1,1,1,1};
        System.out.println(question5.countOnes(arr));
        Assertions.assertEquals(5, question5.countOnes(arr));
    }
}