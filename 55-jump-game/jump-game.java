class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int i=0;
        int maxJump=0;
        while(i<=n-1){
            if(i>maxJump){
                return false;
            }
            maxJump=Math.max(maxJump,i+nums[i]);
            i++;
        }
        return true;

    }
}