class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> freq=new HashMap<>();
        char arr[]=s.toCharArray();
        for(char c:arr){
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        //sort
        List<Character> chars=new ArrayList(freq.keySet());
        Collections.sort(chars,(a,b)->(freq.get(b)-freq.get(a)));
        //building string
        StringBuilder sb=new StringBuilder();
        for(char c:chars){
            for(int i=0;i<freq.get(c);i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}