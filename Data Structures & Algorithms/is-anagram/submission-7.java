class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> countS = new HashMap<Character, Integer>(); 
        HashMap<Character, Integer> countT = new HashMap<Character, Integer>(); 
        

        for (char charS : s.toCharArray()) {
            if (!countS.containsKey(charS)) {
                countS.put(charS, 1);
            }
            else {
                Integer c = countS.get(charS);
                countS.put(charS, c + 1);
            }
        }

        for (char charT : t.toCharArray()) {
            if (!countT.containsKey(charT)) {
                countT.put(charT, 1);
            }
            else {
                Integer c = countT.get(charT);
                countT.put(charT, c + 1);
            }
        }

        for (Map.Entry<Character, Integer> e : countS.entrySet()) {
            if (!countT.containsKey(e.getKey()) || !countT.get(e.getKey()).equals(e.getValue())) {
                return false;
            }
        }
        return true;
    }
}
