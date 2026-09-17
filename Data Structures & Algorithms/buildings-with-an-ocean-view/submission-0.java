class Solution {
    public int[] findBuildings(int[] heights) {
        // Stack<int[]> s = new Stack<>();

        // for (int i : heights) {
        //     while (s.size() == 0) {

        //     }
        // }

        int max = 0;
        List<Integer> indices = new ArrayList<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > max) {
                max = heights[i];
                indices.add(i);
            }
        }

        int[] res = new int[indices.size()];
        for (int i = 0; i < indices.size(); i++) {
            res[i] = indices.get(indices.size() - 1 - i); 
        }
        return res;
    }
}