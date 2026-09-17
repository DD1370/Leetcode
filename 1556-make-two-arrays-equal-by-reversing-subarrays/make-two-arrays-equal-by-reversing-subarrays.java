import java.util.Arrays;

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) {
            return false;
        }
        
        // Sort both arrays
        Arrays.sort(target);
        Arrays.sort(arr);
        
        // Compare elements element-by-element
        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }
        
        return true;
    }
}