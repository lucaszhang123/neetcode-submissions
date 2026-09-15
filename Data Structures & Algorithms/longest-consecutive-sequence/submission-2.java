class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }


        int max = 0;
        for (int num : nums) {
            int currCounter = 1;
            if (!set.contains(num - 1)) {
                while (set.contains(num + 1)) {
                    currCounter++;
                    num++;
                }
            }
            if (currCounter > max) max = currCounter;
        }

        return max;
    }
    /*

    
    */
}
