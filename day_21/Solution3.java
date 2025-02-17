class Solution3 {
    private int backtrack(Map<Character, Integer> counts) {
        int count = 0;

        // base condition is when everything in the counts is consumed
        for(char c: counts.keySet()) {
            if(counts.get(c) == 0) continue;
            count++;
            counts.put(c, counts.get(c) - 1);
            count += backtrack(counts);
            counts.put(c, counts.get(c) + 1);
        }

        return count;
    }

    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> counts = new HashMap<>();
        for(char tile: tiles.toCharArray()) {
            counts.put(tile, counts.getOrDefault(tile, 0) + 1);
        }

        return backtrack(counts);
    }
}