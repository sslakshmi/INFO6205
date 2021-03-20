package edu.northeastern;

import java.util.*;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique
 * triplets in the array which gives the sum of zero.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 */
public class Question3 {
    public static void main(String[] args) {
        Question3 question3 = new Question3();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(question3.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0 || nums.length == 1) return result;

        Arrays.sort(nums);
        //If the smallest number in the array is already >0, then there is no way we can make the total sum = 0
        if (nums[0] > 0) return result;

        for (int i = 0; i < nums.length; i++) {
            //since we don't want to duplicate
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSum(nums, i, result);
            }
        }

        return result;
    }

    private void twoSum(int[] nums, int i, List<List<Integer>> result) {
        Set<Integer> set = new HashSet<>();
        for (int j = i + 1; j < nums.length; j++) {
            int compliment = -(nums[i] + nums[j]);
            //Check to see if the compliment already exists in the set
            if (set.contains(nums[j])) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.add(nums[j]);
                temp.add(compliment);
                result.add(temp);
                while (j + 1 < nums.length && nums[j] == nums[j + 1])
                    j++;
            } else {
                //If not in set, then add
                set.add(compliment);
            }
        }
    }
}
