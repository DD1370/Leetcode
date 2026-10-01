class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> st=new ArrayDeque<>();
        Map<Integer,Integer> nge= new HashMap<>();
        int n=nums1.length;
        int m=nums2.length;
        for(int i=m-1;i>=0;i--){
            while(!st.isEmpty() && nums2[i]>st.peek()){
                st.pop();
            }
            int val=st.isEmpty()?-1:st.peek();
            nge.put(nums2[i],val);
            st.push(nums2[i]);
        }
        int [] res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=nge.get(nums1[i]);
        }
        return res;
    }
}