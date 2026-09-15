class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left=0;
        int right=0;
        int cnt=0;
        int pro=1;
        if(k<=1)
            return 0;
        for(right=0;right<nums.length;right++){
            pro*=nums[right];
            while(pro>=k){
                pro/=nums[left];
                left++;
            }
            cnt+=right-left+1;
        }
        return cnt;
        
    }
}