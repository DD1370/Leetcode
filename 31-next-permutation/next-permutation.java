class Solution {
    public static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public static void rev(int[] nums,int start,int end){
        int left=start;
        int right=end;
        while(left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int i=n-2;
        for(;i>=0;i--){
            if(nums[i]<nums[i+1]){
                break;
            }
        }
        if(i<0){
            rev(nums,0,n-1);
            return;
        }
        int j=n-1;
        for(;j>=0;j--){
            if(nums[j]>nums[i]){
                int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
                break;
            }
            
        }
        //swap(nums,i,j);
        rev(nums,i+1,n-1);
    }
}