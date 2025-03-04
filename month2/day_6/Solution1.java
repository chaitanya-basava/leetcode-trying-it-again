package month2.day_6;

import java.util.PriorityQueue;

class Solution1 {
    private boolean check(int h, int t, int[] piles) {
        int totalTime = 0;
        for(int pile: piles) {
            totalTime += Math.ceil((double) pile / t);
        }

        return totalTime <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int l = 0, r = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int pile: piles) {
            r = Math.max(r, pile);
            pq.add(-pile);
        }

        while(l < r) {
            int m = l + (r - l) / 2;
            // System.out.println(l + " " + r + " " + m);
            if(check(h, m, piles)) r = m;
            else l = m + 1;
        }

        return r;
    }
}
