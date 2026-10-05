class Solution {
    public int largestRectangleArea(int[] arr) {
        int n=arr.length;
        int maxArea=0;
        Deque<Integer> st=new ArrayDeque<>();
        for(int i=0;i<=n;i++){
            int curr=(i==n)?0:arr[i];
            while(!st.isEmpty() && arr[st.peek()]>=curr){
                int h=arr[st.pop()];
                int pse=st.isEmpty()?-1:st.peek();
                int nse=i;
                int width=nse-pse-1;
                int area=h*width;
                maxArea=Math.max(maxArea,area);
            }
            if(i<n) st.push(i);
        }
        return maxArea;
    }
}