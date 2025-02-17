class Solution1 {
    public int[][] merge(int[][] intervals) {
        // sort by start
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int lastEnd = ans.get(ans.size() - 1)[1];

            if (start <= lastEnd) {
                ans.get(ans.size() - 1)[1] = Math.max(lastEnd, end);
            } else {
                ans.add(new int[]{start, end});
            }
        }

        return ans.toArray(new int[ans.size()][2]);
    }
}