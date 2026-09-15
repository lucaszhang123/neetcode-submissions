class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> (b[0]*b[0]+b[1]*b[1]) - (a[0]*a[0]+a[1]*a[1]));

        for (int i = 0; i < points.length; i++) {
            if (i < k) pq.offer(points[i]);
            else {
                int[] top = pq.peek();
                if (Math.sqrt(points[i][0]*points[i][0]+points[i][1]*points[i][1]) 
                < Math.sqrt(top[0]*top[0]+top[1]*top[1])) {
                    pq.poll();
                    pq.offer(points[i]);
                }
            }
        }

        int[][] tbr = new int[k][2];
        for(int i = 0; i < k; i++) {
            tbr[i] = pq.poll();
        }
        return tbr;
    }
}
