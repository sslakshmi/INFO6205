package edu.northeastern;

public class Question5 {

    /**
     * Given a binary array sorted in non-increasing order, count the number of 1’s in it.
     *
     * Examples:
     * Input: arr[] = {1, 1, 0, 0, 0, 0, 0}
     * Output: 2
     *
     * Input: arr[] = {1, 1, 1, 1, 1, 1, 1}
     * Output: 7
     *
     * Input: arr[] = {0, 0, 0, 0, 0, 0, 0}
     * Output: 0
     * @param arr
     * @return
     */
    public int countOnes(int[] arr){
        if(arr == null || arr.length == 0 || arr[0] == 0){
            return 0;
        }
        if(arr[arr.length - 1] == 1){
            return arr.length;
        }
        int low = 0;
        int high = arr.length - 1;
        while( low <= high){
            int mid = (low + high)/2;
            if(arr[mid] == 0){
                high = mid - 1;
            }
            else{
                if(arr[mid + 1] == 1){
                    low = mid + 1;
                }
                else{
                    return mid + 1;
                }
            }
        }
        return 0;
    }
}
