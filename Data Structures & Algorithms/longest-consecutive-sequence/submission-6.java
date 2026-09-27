class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<Integer>();

        for (int i : nums) {
            s.add(i);
        }

        Set<Integer> seen = new HashSet<>();
        int max = 0;
        for (int i : nums) {
            if (seen.contains(i)) continue;

            int l = 1;
            int r = 1;
            while (s.contains(i - l)) {
                seen.add(i - l);
                l++;
            }
            while (s.contains(i + r)) {
                seen.add(i + r);
                r++;
            }

            max = Math.max(max, l + r - 1);

        }

        return max;
       
    }
    /*

    
    */
}
