class Solution {
    public class ProbEdge {
        int n;
        double w;
        ProbEdge(int i, double wei) {
            n = i;
            w = wei;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        HashMap<Integer, List<ProbEdge>> adj = new HashMap<>();

        for (int i = 0; i < succProb.length; i++) {
            int[] e = edges[i];
            adj.computeIfAbsent(e[0], k -> new ArrayList<>()).add(new ProbEdge(e[1], succProb[i]));
            adj.computeIfAbsent(e[1], k -> new ArrayList<>()).add(new ProbEdge(e[0], succProb[i]));
        }

        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;

        PriorityQueue<ProbEdge> pq = new PriorityQueue<>((a, b) -> Double.compare(b.w, a.w));
        pq.offer(new ProbEdge(start_node, 1.0));

        boolean[] seen = new boolean[n];
        int counter = 0;

        while (counter < n && !pq.isEmpty()) {
            ProbEdge curr = pq.poll();
            if (seen[curr.n]) continue;

            seen[curr.n] = true;
            counter++;

            if (!adj.containsKey(curr.n)) continue;

            for (ProbEdge nb : adj.get(curr.n)) {
                double nProb = curr.w * nb.w;
                if (nProb > maxProb[nb.n]) {
                    maxProb[nb.n] = nProb;
                    pq.offer(new ProbEdge(nb.n, nProb));
                }
            }
        }

        return maxProb[end_node];
    }
}