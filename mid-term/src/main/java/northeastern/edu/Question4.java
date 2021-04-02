package northeastern.edu;

public class Question4 {
    //Time complexity - O(log n) as in binary search the input get reduced to half each time the recursion happens.
    //Space complexity - O(1)
    public static void main(String[] args) {
        Question4 question4 = new Question4();
        //[2,4,4,4,6,7,7,7,8,9,9,9,] & x = 7 , the result should be 5
        int[] nums = new int[]{2, 4, 4, 4, 6, 7, 7, 7, 8, 9, 9, 9};
        int x = 7;
        System.out.println(question4.getIndex(nums, x)); //5

        int[] nums1 = new int[]{2, 4, 4, 4, 6, 7, 7, 7, 8, 9, 9, 9};
        int x1 = 5;
        System.out.println(question4.getIndex(nums1, x1)); //-1

        int[] nums2 = new int[]{};
        int x2 = 5;
        System.out.println(question4.getIndex(nums2, x2)); //-1
    }

    public int getIndex(int[] nums, int x) {
        int low = 0;
        int high = nums.length - 1;
        int output = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (x < nums[mid])
                high = mid - 1;
            else if (x > nums[mid])
                low = mid + 1;
            else {
                //if equal, go further left
                output = mid;
                high = mid - 1;
            }
        }
        return output;
    }
}
