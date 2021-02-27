package edu.northeastern;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class Question4Test {

    @Test
    void pancakeSortTest1() {
        Question4 question4 = new Question4();
        int[] arr = new int[]{3, 2, 4, 1};
        List<Integer> output = question4.pancakeSort(arr);
        System.out.println(output.toString());
        System.out.println(Arrays.toString(arr));
    }
}