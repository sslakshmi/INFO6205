package edu.northeastern;

import java.util.ArrayList;
import java.util.List;

public class Question4 {

    /**
     * Given an array of integers arr, sort the array by performing a series of pancake flips.
     *
     * In one pancake flip we do the following steps:
     *
     * Choose an integer k where 1 <= k <= arr.length.
     * Reverse the sub-array arr[0...k-1] (0-indexed).
     * For example, if arr = [3,2,1,4] and we performed a pancake flip choosing k = 3, we reverse the sub-array
     * [3,2,1], so arr = [1,2,3,4] after the pancake flip at k = 3.
     *
     * Return an array of the k-values corresponding to a sequence of pancake flips that sort arr. Any valid answer
     * that sorts the array within 10 * arr.length flips will be judged as correct.
     *
     * Example 1:
     * Input: arr = [3,2,4,1]
     * Output: [4,2,4,3]
     * Explanation:
     * We perform 4 pancake flips, with k values 4, 2, 4, and 3.
     * Starting state: arr = [3, 2, 4, 1]
     * After 1st flip (k = 4): arr = [1, 4, 2, 3]
     * After 2nd flip (k = 2): arr = [4, 1, 2, 3]
     * After 3rd flip (k = 4): arr = [3, 2, 1, 4]
     * After 4th flip (k = 3): arr = [1, 2, 3, 4], which is sorted.
     *
     * Example 2:
     * Input: arr = [1,2,3]
     * Output: []
     * Explanation: The input is already sorted, so there is no need to flip anything.
     * Note that other answers, such as [3, 3], would also be accepted.
     *
     * @param arr
     * @return
     */
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> flipList = new ArrayList<>();

        for(int valToSort = arr.length; valToSort > 0; valToSort--){
            int index = find(arr, valToSort);
            //If index == 0, we skip the 1st flip
            if(index != 0){
                flipList.add(index + 1);
                flip(arr, index + 1);
            }
            //Mandatory 2nd flip
            flipList.add(valToSort);
            flip(arr, valToSort);
        }
        return flipList;
    }

    private void flip(int[] sublist, int k) {
        int i = 0;
        while (i < k / 2) {
            int temp = sublist[i];
            sublist[i] = sublist[k - i - 1];
            sublist[k - i - 1] = temp;
            i += 1;
        }
    }

    private int find(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == target)
                return i;
        return -1;
    }
}
