package edu.northeastern;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Question1Test {

    @Test
    void findClosestElements() {
        Question1 question1 = new Question1();
        List<Integer> closestElements = question1.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3);
        System.out.println(closestElements);
    }
}