class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int maxJump=0;
        int steps=0;
        int prev=0;
        for(int i=0;i<n-1;i++){
            int val=nums[i];
            int currJump=i+val; 
            maxJump=Math.max(maxJump,currJump);
            if(i==prev){
                steps++;
                prev=maxJump;
            }
        }
        return steps;
    }
}