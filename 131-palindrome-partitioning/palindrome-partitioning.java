class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> path=new ArrayList<>();
        fun(0,s,path,res);
        return res;
    }
    void fun(int index,String s,List<String> path,List<List<String>> res){
        if(index==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPal(s,index,i)){
                path.add(s.substring(index,i+1));
                fun(i+1,s,path,res);
                path.remove(path.size()-1);
            }
        }
    }
    boolean isPal(String s,int l,int r){
        while(l<r){
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}