package edu.northeastern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Question3Test {

    @Test
    void sortColorsTest1() {
        Question3 question3 = new Question3();
        int[] arr = new int[]{2, 0, 2, 1, 1, 0, 2};
        question3.sortColors(arr);
        System.out.println(Arrays.toString(arr));
        Assertions.assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2, 2}, arr);
    }

    @Test
    void sortColorsTest2() {
        Question3 question3 = new Question3();
        int[] arr = new int[]{1, 1, 1, 1, 1, 1, 1};
        question3.sortColors(arr);
        System.out.println(Arrays.toString(arr));
        Assertions.assertArrayEquals(new int[]{1, 1, 1, 1, 1, 1, 1}, arr);
    }
}