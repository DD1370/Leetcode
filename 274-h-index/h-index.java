import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        
        for (int i = 0; i < n; i++) {
            int h = n - i; // Number of papers with at least citations[i] citations
            if (citations[i] >= h) {
                return h;
            }
        }
        
        return 0;
    }
}