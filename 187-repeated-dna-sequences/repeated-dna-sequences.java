class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans=new ArrayList<>();
        int n=s.length();
        if(n<0) return ans;
        Set<String> seen =new HashSet<>();
        Set<String> added =new HashSet<>();
        for(int i=0;i<=n-10;i++){
            String sub=s.substring(i,i+10);
            if(!seen.add(sub)&& added.add(sub)){
                ans.add(sub);
            }
        }
        return ans;
    }
}