class Solution {
    List<List<String>> sol = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        bt(new ArrayList<String>(), 0, n, new ArrayList<Integer>());
        return sol;
    }
    public void bt(List<String> curr, int r, int n, List<Integer> qpos) {
        if (r == n) {
            sol.add(new ArrayList<>(curr));
        }
        List<Integer> candidates = new ArrayList<>();
        for (int c = 0; c < n; c++) {
            boolean valid = true;
            for (int row = 0; row < qpos.size(); row++) {
                int col = qpos.get(row);
                if (col == c || Math.abs(r - row) == Math.abs(c - col)) {
                    valid = false;
                    break;
                }
            }
            if (valid) candidates.add(c);
        }

        char[] sArr = new char[n];
        Arrays.fill(sArr, '.');

        for (int c : candidates) {
            sArr[c] = 'Q';
            qpos.add(c);
            curr.add(String.valueOf(sArr));
            bt(curr, r + 1, n, qpos);

            sArr[c] = '.';
            qpos.remove(qpos.size() - 1);
            curr.remove(curr.size() - 1);
        }
    }
}