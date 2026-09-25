class Solution {
    public static int[] buildLps(String pat){
        int n=pat.length();
        int[] lps=new int[n];
        int len=0;
        int i=1;
        while(i<n){
            if(pat.charAt(i)==pat.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }
            else if(len>0){
                len=lps[len-1];
            }
            else{
                i++;
            }
        }
        return lps;
    }
    public int strStr(String haystack, String needle) {
        int n=haystack.length();
        int m=needle.length();
        int[] lps=buildLps(needle);
        int i=0;
        int j=0;
        while(i<n){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
                if(j==m) return i-j;
            }
            else if(j>0){
                j=lps[j-1];
            }
            else{
                i++;
            }
        }
        return -1;
    }

}