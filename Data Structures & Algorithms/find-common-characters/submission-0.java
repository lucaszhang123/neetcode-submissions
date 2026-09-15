class Solution {
    public List<String> commonChars(String[] words) {
        int[][] contained = new int[words.length][26];

        for (int i = 0; i < words.length; i++) {
            for (Character c : words[i].toCharArray()) {
                contained[i][c - 'a']++;
            }
        }
        int[] fullyContained = new int[26];
        for (int j = 0; j < 26; j++) {
            int minContain = Integer.MAX_VALUE;
            for (int i = 0; i < words.length; i++) {
                if (contained[i][j] < minContain) {
                    minContain = contained[i][j];
                }
            }

            fullyContained[j] = minContain;
        }
        List<String> tbr = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int cnt = fullyContained[i];

            for (int j = 0; j < cnt; j++) {
                tbr.add(String.valueOf((char)('a' + i)));
            }
        }

        return tbr;

    }
}