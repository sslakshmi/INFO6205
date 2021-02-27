package edu.northeastern;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Question1 {

    /**
     * Intersection of Two Arrays
     * <p>
     * Given two arrays, write a function to compute their intersection.
     * <p>
     * Example 1:
     * <p>
     * Input: nums1 = [1,2,2,1], nums2 = [2,2]
     * Output: [2]
     * <p>
     * Example 2:
     * <p>
     * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * Output: [9,4]
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        int outLength = (nums1.length > nums2.length) ? nums2.length : nums1.length;
        int[] output = new int[outLength];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        int outIndex = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                output[outIndex] = nums2[i];
                set.remove(nums2[i]);
                outIndex++;
            }
        }
        return Arrays.copyOfRange(output, 0, outIndex);
    }
}
