class Solution {
    public int characterReplacement(String s, int k) {
        int lp = 0;
        int rp = 0;
        int maxLen = 0;

        int[] counts = new int[26];

        while (rp < s.length()) {
            counts[s.charAt(rp) - 'A']++;

            int maximalChar = 0;
            for (int i = 0; i < 26; i++) {
                if (counts[i] > maximalChar) maximalChar = counts[i];
            }

            if (rp - lp + 1 - maximalChar <= k) {
                if (maxLen < rp - lp + 1) maxLen = rp - lp + 1;
            }
            else {
                while (rp - lp + 1 - maximalChar > k) {
                    counts[s.charAt(lp) - 'A']--;
                    lp++;
                    for (int i = 0; i < 26; i++) {
                        if (counts[i] > maximalChar) maximalChar = counts[i];
                    }
                }
            }
            rp++;
        } 

        return maxLen; 
    }
}
/*


XYYXX

lp = 0
rp = 2
len = rp - lp + 1 = 3

X: 1
Y: 2

maximal letter count: 2
count not maximal: count - mlc = 1

if (cnm <= k) rp++
else lp++ 
reclauclate maximal letter 

map letter --> count
map count --> letters

*/