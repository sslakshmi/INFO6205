package edu.northeastern;

public class Question3 {
    /**
     * Let's call an array arr a mountain if the following properties hold:
     *
     * arr.length >= 3
     * There exists some i with 0 < i < arr.length - 1 such that:
     * arr[0] < arr[1] < ... arr[i-1] < arr[i]
     * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
     * Given an integer array arr that is guaranteed to be a mountain, return any i such that arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
     *
     * Example 1:
     * Input: arr = [0,1,0]
     * Output: 1
     *
     * Example 2:
     * Input: arr = [0,2,1,0]
     * Output: 1
     *
     * Example 3:
     * Input: arr = [0,10,5,2]
     * Output: 1
     *
     * Example 4:
     * Input: arr = [3,4,5,1]
     * Output: 2
     *
     * @param arr
     * @return
     */
    public int peakIndexInMountainArrayBruteForce(int[] arr){
        int left;
        int right;
        for (int i = 1; i < arr.length -1; i += 2) {
            if(arr[i-1] < arr[i] && arr[i] > arr[i+1]){
                return i;
            }
        }
        return -1;
    }

    public int peakIndexInMountainArray(int[] arr){
        int low = 0;
        int high = arr.length - 1;
        while(low < high){
            int mid = (low + high)/2;
            if(arr[mid-1] < arr[mid]){
                low = mid + 1;
            }
            else{
                high = mid-1;
            }
        }
        return low;
    }
}
