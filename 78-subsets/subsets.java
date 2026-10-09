class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        solve(nums, 0, ds,res);
        return res;
    }
    private void solve(int[] nums, int idx,List<Integer>ds,List<List<Integer>> res){
	//Base case
	if(idx == nums.length){
		res.add(new ArrayList<>(ds));
		return;
		}
	//take
	ds.add(nums[idx]);
	solve(nums, idx+1, ds,res);
	//backtrack
	ds.remove(ds.size()-1);
	//not take
	solve(nums,idx+1,ds,res);
    }
}