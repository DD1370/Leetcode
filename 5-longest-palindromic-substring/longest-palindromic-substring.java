class Solution {
    private static int expand(String s,int left,int right){
        while((left>=0)&&(right<s.length())&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return (right-left-1);

    }
    public String longestPalindrome(String s) {
        if(s.length()<2) return s;
        int st=0;
        int e=0;
        for(int i=0;i<s.length();i++){
            int ol=expand(s,i,i);
            int el=expand(s,i,i+1);
            int l=Math.max(ol,el);
            if(l>(e-st+1)){
                st=i-(l-1)/2;
                e=i+l/2;
            }
        }
        return s.substring(st,e+1);
    }
}