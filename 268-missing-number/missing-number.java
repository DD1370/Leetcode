class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int sum=0;
        //int exSum=n*(n+1)/2;
        int exSum=0;
        for(int i=1;i<=n;i++){
            exSum+=i;
        }
        for(int num:nums){
            sum+=num;
        }
        return exSum-sum;
    }
}