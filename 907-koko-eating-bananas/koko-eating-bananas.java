class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int m=piles[0];
        for(int num:piles){
            if(num>m){
                m=num;
            }
        }
        int low=1;
        int high=m;
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            long tsum=0;
            for(int i:piles){
                tsum+=i/mid;
                if(i%mid!=0){
                    tsum++;
                }
            }
            if(tsum<=h){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;

    }
}