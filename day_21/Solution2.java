class Solution2 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length, i = 0;
        List<int[]> res = new ArrayList<>();

        // find pos to add new interval
        while (i < n && intervals[i][1] < newInterval[0]) res.add(intervals[i++]);

        // merge with the new interval if needed and add the new interval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        // add the rest
        while (i < n) res.add(intervals[i++]);

        return res.toArray(new int[res.size()][2]);
    }
}