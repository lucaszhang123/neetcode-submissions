class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        HashSet<Character> containedLetters = new HashSet<>();

        while (right < s.length()) {
            if (!containedLetters.contains(s.charAt(right))) {
                containedLetters.add(s.charAt(right));
            }
            else {
                while (containedLetters.contains(s.charAt(right))) {
                    containedLetters.remove(s.charAt(left));
                    left++;
                }
                containedLetters.add(s.charAt(right));
            }

            if (right - left + 1 > maxLength) maxLength = right - left + 1;
            right++;

        }
        
        return maxLength;
    }
}
