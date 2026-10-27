/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* twoSum(int* nums, int n, int target, int* returnSize) {
    
    int *ans=malloc(sizeof(int)*2);
    int i=0,j=1;
    for(i;i<n;i++){
        for(j;j<n;j++){
            if( i!=j && nums[i]+nums[j]==target){
                ans[0]=i;
                ans[1]=j;
                *returnSize=2;
                return ans;
            }
            
        }
        j=0;
    }
    *returnSize=2;
    return ans;
}