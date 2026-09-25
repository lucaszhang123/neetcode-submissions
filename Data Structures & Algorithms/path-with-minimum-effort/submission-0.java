class Solution {
    public int minimumEffortPath(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        int[][] min = new int[r][c];
        boolean[][] visited = new boolean[r][c];

        for (int i = 0; i < heights.length; i++) {
            Arrays.fill(min[i], Integer.MAX_VALUE);
        }
        //c0-> x; c1-> y; c2
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pq.offer(new int[]{0,0,0});

        while (true) {
            int[] minDist = pq.poll();
            int x = minDist[0];
            int y = minDist[1];
            int least = minDist[2];
            visited[x][y] = true;

            if (x == r - 1 && y == c - 1) return least;

            min[x][y] = least;

            if (x - 1 >= 0 && !visited[x-1][y]) {
                min[x - 1][y] = Math.min(min[x - 1][y], 
                Math.max(min[x][y], Math.abs(heights[x][y] - heights[x-1][y])));

                pq.offer(new int[]{x - 1, y, min[x-1][y]});
            }
            if (x + 1 < r && !visited[x+1][y]) {
                min[x + 1][y] = Math.min(min[x + 1][y], 
                Math.max(min[x][y], Math.abs(heights[x][y] - heights[x+1][y])));

                pq.offer(new int[]{x + 1, y, min[x + 1][y]});
            }
            if (y - 1 >= 0 && !visited[x][y-1]) {
                min[x][y-1] = Math.min(min[x][y-1], 
                Math.max(min[x][y], Math.abs(heights[x][y] - heights[x][y-1])));

                pq.offer(new int[]{x, y - 1, min[x][y - 1]});
            }
            if (y + 1 < c && !visited[x][y+1]) {
                min[x][y + 1] = Math.min(min[x][y + 1], 
                Math.max(min[x][y], Math.abs(heights[x][y] - heights[x][y + 1])));

                pq.offer(new int[]{x, y + 1, min[x][y + 1]});
            }

        } 

    }

    
    /*
    dijkstra's 

    pq<int[0,0],>

    0,0 --> 0, 1.  0,2
    |
    1, 0.   1.1 

    2 0
    */


}