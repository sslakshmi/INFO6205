package edu.northeastern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Question2Test {

    @Test
    void intersectionTest1() {
        Question2 question2 = new Question2();
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        int[] output = question2.intersection(nums1, nums2);
        System.out.println(Arrays.toString(output));
        Assertions.assertArrayEquals(new int[]{2}, output);
    }
}