package edu.northeastern;

public class Question3 {

    /**
     * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same
     * color are adjacent, with the colors in the order red, white, and blue.
     * <p>
     * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
     * <p>
     * Example 1:
     * Input: nums = [2,0,2,1,1,0]
     * Output: [0,0,1,1,2,2]
     * <p>
     * Example 2:
     * Input: nums = [2,0,1]
     * Output: [0,1,2]
     * <p>
     * Example 3:
     * Input: nums = [0]
     * Output: [0]
     * <p>
     * Example 4:
     * Input: nums = [1]
     * Output: [1]
     *
     * @param arr
     */
    public void sortColors(int[] arr) {
        sortColors(arr, 1);
    }

    private void sortColors(int[] arr, int pivot) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] < pivot) {
                swap(arr, low, mid);
                mid++;
                low++;
            } else if (arr[mid] == pivot) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
