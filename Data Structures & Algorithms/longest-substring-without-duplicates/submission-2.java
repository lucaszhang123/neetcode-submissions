class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        Set<Character> hs = new HashSet<Character>();
        int max = 0;
        while (r < s.length()) {
            if (!hs.contains(s.charAt(r))) {
                max = Math.max(max, r - l + 1);
            }

            else {
                while (hs.contains(s.charAt(r))) {
                    hs.remove(s.charAt(l));
                    l++;
                }
            }

            hs.add(s.charAt(r));
            r++;
        }

        return max;
    }
}
