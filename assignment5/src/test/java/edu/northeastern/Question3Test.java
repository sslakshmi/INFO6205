package edu.northeastern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Question3Test {
    @Test
    void peakIndexInMountainArray() {
        Question3 question3 = new Question3();
        int[] arr = new int[]{0, 2, 1, 0};
        System.out.println(question3.peakIndexInMountainArray(arr));
        Assertions.assertEquals(2, question3.peakIndexInMountainArray(arr));
    }
}