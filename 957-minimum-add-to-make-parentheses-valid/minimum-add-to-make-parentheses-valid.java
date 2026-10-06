class Solution {
    public int minAddToMakeValid(String s) {
        int res=0;
        Deque<Character> st= new ArrayDeque<>();
        for(char br:s.toCharArray()){
            if(br=='('){
                st.push(br);
            }
            else{
                if(st.isEmpty()) res+=1;
                else{
                    st.pop();
                }
            }
        }
        while(!st.isEmpty()){
            res+=1;
            st.pop();
        }
        return res;
    }
}