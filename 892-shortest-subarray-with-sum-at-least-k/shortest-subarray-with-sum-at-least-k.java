class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n=nums.length;
        int[] pf=new int[n+1];
        for(int i=0;i<n;i++){
            pf[i+1] =pf[i]+nums[i];
        }
        int[] Q=new int[n+1];
        int head=0,tail=0;
        int ans=n+1;
        for(int i=0;i<=n;i++){
            while(head<tail && pf[i]-pf[Q[head]]>=k){
                ans=Math.min(ans,i-Q[head]);
                head++;
            }
            while(head<tail && pf[i]<=pf[Q[tail-1]]){
                tail--;
            }
            Q[tail]=i;
            tail++;
        }
        return ans==n+1?-1:ans;
        
    }
}