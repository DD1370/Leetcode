class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        Deque<Integer> st=new ArrayDeque<>();
        int[] ans= new int[n];
        for(int i=2*n-1;i>=0;i--){
            int curr=nums[i%n];
            while(!st.isEmpty() && curr>=st.peek()){
                st.pop();
            }
            if(i<n){
                if(st.isEmpty()){
                    ans[i]=-1;
                }
                else{
                    ans[i]=st.peek();
                }
            }
            st.push(curr);
        }
        
        return ans;
    }
}