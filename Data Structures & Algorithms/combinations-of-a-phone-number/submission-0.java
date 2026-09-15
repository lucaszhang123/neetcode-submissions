class Solution {
    public List<String> sol;

    public List<String> letterCombinations(String digits) {
        sol = new ArrayList<String>();

        if (digits.length() == 0) return sol;

        bt(0, "", digits);

        return sol;
    }

    public void bt(int index, String curr, String digits) {
        if (index == digits.length()) {
            sol.add(curr);
            return;
        }

        char[] chars = numConv(digits.substring(index, index + 1));

        for (char c : chars) {
            curr += c;
            bt(index + 1, curr, digits);
            curr = curr.substring(0, curr.length() - 1);
        }

    }

    public char[] numConv(String n) {
        if (n.equals("2")) {
            return new char[]{'a', 'b', 'c'};
        }
        else if (n.equals("3")) {
            return new char[]{'d', 'e', 'f'};
        }
        else if (n.equals("4")) {
            return new char[]{'g', 'h', 'i'};
        }
        else if (n.equals("5")) {
            return new char[]{'j', 'k', 'l'};
        }
        else if (n.equals("6")) {
            return new char[]{'m', 'n', 'o'};
        }
        else if (n.equals("7")) {
            return new char[]{'p', 'q', 'r', 's'};
        }
        else if (n.equals("8")) {
            return new char[]{'t', 'u', 'v'};
        }
        else {
            return new char[]{'w', 'x', 'y', 'z'};
        }
    }
}
