class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        // Step 1: Place each number in its correct position (nums[i] should be at index nums[i] - 1)
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int correctIdx = nums[i] - 1;
                // Swap nums[i] with nums[correctIdx]
                int temp = nums[i];
                nums[i] = nums[correctIdx];
                nums[correctIdx] = temp;
            }
        }
        
        // Step 2: Find the first index where the value doesn't match index + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        // Step 3: If all numbers from 1 to n are present, the answer is n + 1
        return n + 1;
    }
}