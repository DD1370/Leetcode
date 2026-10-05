
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // 1. Calculate prefix sums for each row
        for (int r = 0; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                matrix[r][c] += matrix[r][c - 1];
            }
        }

        int count = 0;

        // 2. Fix the left (c1) and right (c2) column boundaries
        for (int c1 = 0; c1 < cols; c1++) {
            for (int c2 = c1; c2 < cols; c2++) {
                // Map to store frequency of prefix sums: (sum -> frequency)
                Map<Integer, Integer> prefixMap = new HashMap<>();
                prefixMap.put(0, 1);

                int currentSum = 0;

                // 3. Reduce to 1D problem: "Subarray Sum Equals K" across rows
                for (int r = 0; r < rows; r++) {
                    int rowSum = matrix[r][c2] - (c1 > 0 ? matrix[r][c1 - 1] : 0);
                    currentSum += rowSum;

                    // If (currentSum - target) exists, add its count
                    count += prefixMap.getOrDefault(currentSum - target, 0);

                    // Record current sum occurrence
                    prefixMap.put(currentSum, prefixMap.getOrDefault(currentSum, 0) + 1);
                }
            }
        }

        return count;
    }
}