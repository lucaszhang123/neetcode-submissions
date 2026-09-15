class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] letterCounts = new int[26];
        int[] lettersChecked = new int[26];
        for (char c : s1.toCharArray()) {
            letterCounts[c - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            if (i < s1.length()) {
                lettersChecked[s2.charAt(i) - 'a']++;
                if (i == s1.length() - 1) {
                    if (Arrays.equals(letterCounts, lettersChecked)) return true;
                }
                continue;
            }
            
            lettersChecked[s2.charAt(i) - 'a']++;
            lettersChecked[s2.charAt(i - s1.length()) - 'a']--;

            if (Arrays.equals(letterCounts, lettersChecked)) return true;
        }
        return false;

    }

    /*
    lecabee
    */
}
