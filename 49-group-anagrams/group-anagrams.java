class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> dict= new HashMap<>();
        for(String s:strs){
            char chararr[]=s.toCharArray();
            Arrays.sort(chararr);
            String key=new String(chararr);
            if(!dict.containsKey(key)){
                dict.put(key,new ArrayList<>());
            }
            dict.get(key).add(s);
        }
        return new ArrayList<>(dict.values());
    }
}