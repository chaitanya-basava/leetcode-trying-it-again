class NumberContainers {
    Map<Integer, Queue<Integer>> nums;
    Map<Integer, Integer> pos;

    public NumberContainers() {
        pos = new HashMap<>();
        nums = new HashMap<>();
    }

    public void change(int index, int number) {
        if(!nums.containsKey(number)) {
            nums.put(number, new PriorityQueue<>());
        }
        nums.get(number).add(index);
        pos.put(index, number);
    }

    public int find(int number) {
        Queue<Integer> position = nums.getOrDefault(number, new PriorityQueue<>());

        while(!position.isEmpty()) {
            if(pos.get(position.peek()) == number) {
                return position.peek();
            }
            position.poll();
        }

        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
