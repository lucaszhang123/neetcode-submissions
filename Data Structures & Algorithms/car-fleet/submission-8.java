class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] posAndSpeed = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            posAndSpeed[i][0] = position[i];
            posAndSpeed[i][1] = speed[i];
        }

        Arrays.sort(posAndSpeed, (a, b) -> b[0] - a[0]);

        double prevFinishTime = finishTime(posAndSpeed[0], target);
        int numFleets = 1;

        for (int i = 1; i < posAndSpeed.length; i++) {
            double thisFinishTime = finishTime(posAndSpeed[i], target);
            
            if (thisFinishTime > prevFinishTime) {
                numFleets++;
                prevFinishTime = thisFinishTime;
            }
        }

        return numFleets;
    }

    public double finishTime(int[] posAndSpeed, int target) {
        return (double)(target - posAndSpeed[0])/posAndSpeed[1];
    }

    /*

    sort by start pos
    1 -->
       2----->
          3 -->
            4 --->

    furthest ahead --> 10
    2nd --> 8
    ...
    */
}
