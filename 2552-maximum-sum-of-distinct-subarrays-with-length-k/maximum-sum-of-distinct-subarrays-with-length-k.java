class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        long currSum = 0;
        long maxSum = 0;

        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            currSum += nums[i];
        }

        if (map.size() == k) {
            maxSum = currSum;
        }

        for (int i = k; i < nums.length; i++) {
            int old = nums[i - k];

            map.put(old, map.get(old) - 1);

            if (map.get(old) == 0) {
                map.remove(old);
            }

            currSum -= old;

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            currSum += nums[i];

            if (map.size() == k && currSum > maxSum) {
                maxSum = currSum;
            }
        }

        return maxSum;
    }
}