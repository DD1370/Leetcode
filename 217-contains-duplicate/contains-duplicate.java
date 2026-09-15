class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int n=nums.length;
        int m=set.size();
        if(n==m){
            return false;
        }
        else{
            return true;
        }
    }
}