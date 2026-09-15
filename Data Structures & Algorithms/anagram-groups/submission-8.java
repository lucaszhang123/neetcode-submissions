class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> m = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            int[] arr = new int[26];
            for (char c : s.toCharArray()) {
                arr[c - 'a']++;
            }
            String hashed = Arrays.toString(arr);
            if (!m.containsKey(hashed)) {
                ArrayList<String> first = new ArrayList<String>();
                first.add(s);
                m.put(hashed, first);
            }
            else {
                List<String> retrieved = m.get(hashed);
                retrieved.add(s);
                m.put(hashed, retrieved);
            }
        }

        return new ArrayList<>(m.values());
    }
}
