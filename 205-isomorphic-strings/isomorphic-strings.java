class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> Smap=new HashMap<>();
        HashMap<Character,Character> Tmap=new HashMap<>();
        if(s.length()!=t.length()) return false;
        for(int i=0;i<s.length();i++){
            char sc=s.charAt(i);
            char tc=t.charAt(i);
            if(Smap.containsKey(sc) && Smap.get(sc)!=tc){
                return false;
            }
            if(Tmap.containsKey(tc) && Tmap.get(tc)!=sc){
                return false;
            }
            Smap.put(sc,tc);
            Tmap.put(tc,sc);
        }
        return true;
    }
}