class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> m = new HashMap<>();
        Set<String> set = new HashSet<>();
        
        String[] arr = s.split("\\s+");
    

        if (pattern.length() != arr.length) return false; 
        for (int i = 0; i < pattern.length(); i++) {
        char c = pattern.charAt(i);
            String w = arr[i];

            if (m.containsKey(c)) {
                if (!m.get(c).equals(w)) return false;
            } else {
                if (set.contains(w)) return false;
                m.put(c, w);
                set.add(w);
            }
        }
        return true;
    }
}