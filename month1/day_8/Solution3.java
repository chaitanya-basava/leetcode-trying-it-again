class Solution3 {
    private void gatherSubsets(List<List<Integer>> ans, List<Integer> subset,
                               int target, int[] nums, int idx) {
        if(target == 0) ans.add(new ArrayList<>(subset)); // same as in Solution1,
        // except we have a criteria to consider a subset
        for(int i = idx; i < nums.length; i++) {
            if(target < nums[i]) return; // no point in going forward
            if(i > idx && nums[i-1] == nums[i]) continue; // to avoid considering duplicates
            subset.add(nums[i]);
            gatherSubsets(ans, subset, target-nums[i], nums, i+1);
            subset.remove(subset.size()-1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        gatherSubsets(ans, new ArrayList<>(), target, candidates, 0);
        return ans;
    }
}
