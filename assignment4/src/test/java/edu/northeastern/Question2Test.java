package edu.northeastern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Question2Test {

    @Test
    void findNthSmallestTest1() {
        Question2 question2 = new Question2();
        int[] arr = new int[]{6,5,3,1,8,7,2,4};
        question2.findNthSmallest(arr, 3);
    }

    @Test
    void findNthSmallestTest2() {
        Question2 question2 = new Question2();
        int[] arr = new int[]{6,5,3,1,8,7,2,4};
        question2.findNthSmallest(arr, 1);
    }

    @Test
    void findNthSmallestTest3() {
        Question2 question2 = new Question2();
        int[] arr = new int[]{6,5,3,1,2,4};
        question2.findNthSmallest(arr, 3);
    }
}