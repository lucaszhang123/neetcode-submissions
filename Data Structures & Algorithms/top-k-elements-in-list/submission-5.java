class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i : nums) {
            if (freq.containsKey(i)) freq.put(i, freq.get(i) + 1);
            else freq.put(i, 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        for (Map.Entry i : freq.entrySet()) {
            int[] e = new int[]{(int) i.getKey(), (int) i.getValue()};
            if (pq.size() < k) {
                pq.add(e);
            } 
            else {
                int[] prevMin = pq.peek();
                if (prevMin[1] < e[1]) {
                    pq.poll();
                    pq.offer(e);
                }
            }
        }

        int[] sol = new int[k];
        for (int i = 0; i < k; i++) {
            int[] popped = pq.poll();

            sol[i] = popped[0];
        }

        return sol;
    }
    /*
    minheap --> size k
    if i     
    (1,1)
    */
}