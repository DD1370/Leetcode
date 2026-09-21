class Solution {
    private static int atmost(int []nums,int k){
        if(k<0) return 0;
        int l=0;
        int cnt=0;
        int s=0;
        for(int r=0;r<nums.length;r++){
            if(nums[r]%2!=0){
                //odd numbers check
                s++;
            }
            //shrink window fom the left if odd count exceeds k
            while(s>k){
                if(nums[l]%2!=0){
                    s--;
                }
                l++;//move left
            }
            cnt +=(r-l+1);
        }
        return cnt;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return atmost(nums,k)-atmost(nums,k-1);
    }
}