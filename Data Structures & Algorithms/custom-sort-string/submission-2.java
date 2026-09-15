class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> ctoi = new HashMap<>();
        HashMap<Integer, Character> itoc = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            ctoi.put(order.charAt(i), i);
            itoc.put(i, order.charAt(i));
        }
        String str = "";
        List<Integer> contained = new ArrayList<>();
        for (Character c : s.toCharArray()) {
            if (ctoi.containsKey(c)) {
                contained.add(ctoi.get(c));
            }
            else str += c;
        }

        Collections.sort(contained);

        for (int i : contained) {
            str += itoc.get(i);
        }
        return str;
    }
}