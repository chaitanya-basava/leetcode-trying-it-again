class Solution1 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> hands = new TreeMap<>();

        for(int i = 0; i < hand.length; i++) {
            hands.put(hand[i], hands.getOrDefault(hand[i], 0) + 1);
        }

        while(!hands.isEmpty()) {
            int num = hands.keySet().iterator().next();
            for(int i = num; i < num + groupSize; i++) {
                if(!hands.containsKey(i)) return false;
                hands.put(i, hands.get(i)-1);
                if(hands.get(i) == 0) {
                    hands.remove(i);
                }
            }
        }

        return true;
    }
}
