package edu.northeastern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Question1 {

    /**
     * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The
     * result should also be sorted in ascending order.
     * <p>
     * An integer a is closer to x than an integer b if:
     * <p>
     * |a - x| < |b - x|, or
     * |a - x| == |b - x| and a < b
     * <p>
     * Example 1:
     * Input: arr = [1,2,3,4,5], k = 4, x = 3
     * Output: [1,2,3,4]
     * <p>
     * Example 2:
     * Input: arr = [1,2,3,4,5], k = 4, x = -1
     * Output: [1,2,3,4]
     *
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = Arrays.stream(arr).boxed().collect(Collectors.toList());

        Collections.sort(result, (a, b) -> {
            System.out.println("A: "+a);
            System.out.println("B: "+b);
            System.out.println("-*-".repeat(10));
            return Math.abs(a - x) == Math.abs(b - x) ? a - b : Math.abs(a - x) - Math.abs(b - x);
        });
        result = result.subList(0, k);
        Collections.sort(result);
        return result;
    }
}
