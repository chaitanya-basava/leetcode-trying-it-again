/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution2 {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int s = 0, e = 0;

        int[] start = new int[n];
        int[] end = new int[n];

        for(int i = 0; i < n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int ans = 0, count = 0;

        while(s < n && e < n) {
            if(start[s] < end[e]) {
                s++;
                count++;
            } else {
                e++;
                count--;
            }
            ans = Math.max(ans, count);
        }

        return ans;
    }
}
