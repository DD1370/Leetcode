class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int slen=s.length();
        int plen=p.length();
        
        ArrayList<Integer> ans=new ArrayList<>();
        if(slen<plen){
            return ans;
        }
        int scount[]=new int[26];
        int pcount[]=new int[26];
        for(int i=0;i<plen;i++){
            pcount[p.charAt(i)-'a']++;
            scount[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(pcount,scount)){
            ans.add(0);
        }
        for(int i=plen;i<slen;i++){
            scount[s.charAt(i)-'a']++;
            scount[s.charAt(i-plen)-'a']--;
            if(Arrays.equals(pcount,scount)){
                ans.add(i-plen+1);
            }
        }
        return ans;
    }
}