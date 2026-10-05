class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        // maskPrefix[i] stores the parity mask of character frequencies for s[0...i-1]
        int[] maskPrefix = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            maskPrefix[i + 1] = maskPrefix[i] ^ (1 << (s.charAt(i) - 'a'));
        }
        
        List<Boolean> ans = new ArrayList<>(queries.length);
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            int k = query[2];
            
            // XOR difference gives which characters have odd counts in s[left...right]
            int subMask = maskPrefix[right + 1] ^ maskPrefix[left];
            int oddCount = Integer.bitCount(subMask);
            
            // Each replacement fixes 2 odd-count characters
            ans.add(oddCount / 2 <= k);
        }
        
        return ans;
    }
}