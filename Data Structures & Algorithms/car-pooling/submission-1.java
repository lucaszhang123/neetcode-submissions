class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a,b) -> a[1] - b[1]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);

        int w = 0;

        for (int[] trip : trips) {
            w += trip[0];

            if (w > capacity) {
                //System.out.println("Exceeded for trip: " + trip[1] + ", " + trip[2]);
                while (pq.size() > 0 && pq.peek()[2] <= trip[1]) {
                    //System.out.println("Finished already: " + pq.peek()[1] + ", " + pq.peek()[2]);
                    w -= pq.poll()[0];
                } 
            }

            if (w > capacity) return false;
            
            pq.offer(trip);
        }

        return true;

        /*
        ___
         ______
           ___
            ______
            ___
             ______

        
        */
    }
}