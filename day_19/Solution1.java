class Solution1 {
    private static class ListComparator implements Comparator<List<String>> {
        @Override
        public int compare(List<String> list1, List<String> list2) {
            return list1.get(1).compareTo(list2.get(1));
        }
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        tickets.sort(new ListComparator());

        Map<String, List<String>> adj = new HashMap<>();
        for(List<String> ticket: tickets) {
            if(!adj.containsKey(ticket.get(0))) {
                adj.put(ticket.get(0), new ArrayList<>());
            }
            adj.get(ticket.get(0)).add(ticket.get(1));
        }
        // System.out.println(adj);

        List<String> itinerary = new ArrayList<>();

        this.dfs("JFK", adj, itinerary, tickets.size());

        return itinerary;
    }

    private boolean dfs(String src, Map<String, List<String>> adj
            , List<String> itinerary, int edges) {
        itinerary.add(src);
        if(itinerary.size() == edges + 1) return true;

        List<String> neis = adj.getOrDefault(src, new ArrayList<>());
        for(int i = 0; i < neis.size(); i++) {
            String nei = neis.get(i);
            adj.get(src).remove(i);
            if(dfs(nei, adj, itinerary, edges)) return true;
            adj.get(src).add(i, nei);
        }
        itinerary.remove(itinerary.size()-1);
        return false;
    }
}
