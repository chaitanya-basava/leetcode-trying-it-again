class DetectSquares {
    Map<String, Integer> map;

    public DetectSquares() {
        map = new HashMap<>();
    }

    public void add(int[] point) {
        String p = point[0] + " " + point[1];
        map.put(p, map.getOrDefault(p, 0) + 1);
    }

    public int count(int[] point) {
        int ans = 0;

        for(Map.Entry<String, Integer> p: map.entrySet()) {
            String[] pt = p.getKey().split(" ");
            int x = Integer.parseInt(pt[0]);
            int y = Integer.parseInt(pt[1]);

            // only consider diagonal points
            if(Math.abs(x - point[0]) != Math.abs(y - point[1]) || point[0] == x || point[1] == y) continue;

            // (px, py), (x, y), (px, y), (x, py)
            ans += p.getValue() * map.getOrDefault(x + " " + point[1], 0) * map.getOrDefault(point[0] + " " + y, 0);
        }

        return ans;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
