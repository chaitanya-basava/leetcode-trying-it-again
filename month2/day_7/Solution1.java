package month2.day_7;

class Solution1 {
    public long coloredCells(int n) {
        long start = 1;
        int c = 1;

        while(c < n) {
            start += 4L * c;
            c++;
        }

        return start;
    }
}
