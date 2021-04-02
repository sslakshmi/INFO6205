package northeastern.edu;

public class Question3 {
    //Time complexity - O(n)
    //Space complexity - O(1)
    public static void main(String[] args) {
        Question3 question3 = new Question3();

        int[] nums = new int[]{0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0}; //3
        System.out.println(question3.getMaxConsecutiveOnes(nums));

        int[] nums1 = new int[]{1, 1, 1, 0, 1, 0, 1, 1, 1, 1}; //4
        System.out.println(question3.getMaxConsecutiveOnes(nums1));
    }

    public int getMaxConsecutiveOnes(int[] nums) {
        int oneCount = 0;
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                oneCount++;
                maxCount = Math.max(maxCount, oneCount);
            } else {
                oneCount = 0;
            }
        }
        return maxCount;
    }
}
