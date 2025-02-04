class Solution1 {
    private void createSubsets(List<List<Integer>> ans, int[] nums, List<Integer> subset, int idx) {
        ans.add(new ArrayList<>(subset));
        for(int i = idx; i < nums.length; i++) { // always pick the first index
            if(i > idx && nums[i-1] == nums[i]) continue; // this ensures no duplicate sets are picked up.
            subset.add(nums[i]);
            createSubsets(ans, nums, subset, i+1);
            subset.remove(subset.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        createSubsets(ans, nums, new ArrayList<>(), 0);
        return ans;
    }
}