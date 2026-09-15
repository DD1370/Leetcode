class Solution {
    public int trap(int[] height) {
        int left=0;
        int right=height.length-1;
        int lm=height[left];
        int rm=height[right];
        int w=0;
        while(left<right){
            if(height[left]<height[right]){
                if(lm<height[left]){
                    lm=height[left];
                }
                else{
                    w+=lm-height[left];
                }
                left++;
            }
            else{
                if(rm<height[right]){
                    rm=height[right];
                }
                else{
                    w+=rm-height[right];
                }
                right--;
            } 
        }
        return w;
    }
}