class Solution {
    List<String> sol;
    public List<String> generateParenthesis(int n) {
        sol = new ArrayList<String>();
        bt(n, 0, 0, "");

        return sol;

    }

    public void bt(int n, int open, int close, String s) {
        if (open == n && close == n) {
            sol.add(new String(s));
            return;
        }

        if (open > close) {
            if (open != n) {
                s += "(";
                bt(n, open + 1, close, s);
                s = s.substring(0, s.length() - 1);
            }

          
            s += ")";
            bt(n, open, close + 1, s);
        }
        else {
            s += "(";
            bt(n, open + 1, close, s);
        }
    }
    /*
     
    */
}
