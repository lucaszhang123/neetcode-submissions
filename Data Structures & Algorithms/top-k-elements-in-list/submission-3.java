class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqTable = new HashMap<>();
        for (int i : nums) {
            if (!freqTable.containsKey(i)) {
                freqTable.put(i, 1);
            }
            else freqTable.put(i, freqTable.get(i) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<Integer, Integer> e : freqTable.entrySet()) {
            pq.offer(e);
        }

        int[] tbr = new int[k];
        for (int i = 0; i < k; i++) {
            int ith = pq.poll().getKey();
            tbr[i] = ith;
        }

        return tbr;
    
    }
}
