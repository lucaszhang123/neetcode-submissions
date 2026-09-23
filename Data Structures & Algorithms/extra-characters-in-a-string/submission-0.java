class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>();
        for (String w : dictionary) {
            set.add(w);
        }
        
        int[] wastedChars = new int[s.length() + 1];
        for (int i = s.length() - 1; i >= 0; i--) {
            wastedChars[i] = wastedChars[i + 1] + 1;

            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (set.contains(sub)) wastedChars[i] = Math.min(wastedChars[j], wastedChars[i]);
            }

        }

        return wastedChars[0];
    }

    /*
    neetcodes
    012345678

    neet code neetcodes

    s 1

    es 2

    des 3 

    odes 4

    codes code i = 4; j = 8

    tcodes

    etcodes

    eetcodes

    neetcodes
    */

    /*

    */
}