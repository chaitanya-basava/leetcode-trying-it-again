class Solution2 {
    private void gatherSubsets(List<List<Integer>> ans, List<Integer> subset,
                               int target, int[] nums, int idx) {
        if(idx == nums.length) {
            if(target == 0) ans.add(new ArrayList<>(subset));
            return;
        }

        if(nums[idx] <= target) {
            subset.add(nums[idx]);
            // considering number in current idx
            gatherSubsets(ans, subset, target - nums[idx], nums, idx);
            subset.remove(subset.size()-1);
        }

        // ignoring the number in current idx
        gatherSubsets(ans, subset, target, nums, idx+1);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        gatherSubsets(ans, new ArrayList<>(), target, candidates, 0);
        return ans;
    }
}