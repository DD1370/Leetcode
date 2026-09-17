class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int i = 0;
        
        // Step 1: Place numbers in their correct positions
        while (i < n) {
            int correctIdx = nums[i] - 1;
            // If the current number is not at its correct position and its target spot isn't already correct
            if (nums[i] != nums[correctIdx]) {
                int temp = nums[i];
                nums[i] = nums[correctIdx];
                nums[correctIdx] = temp;
            } else {
                i++;
            }
        }
        
        // Step 2: Scan to find the duplicate and missing numbers
        for (int j = 0; j < n; j++) {
            if (nums[j] != j + 1) {
                // nums[j] is the duplicate, and j + 1 is the missing number
                return new int[] { nums[j], j + 1 };
            }
        }
        
        return new int[] {};
    }
}