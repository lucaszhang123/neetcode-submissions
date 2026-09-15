class Solution {
    List<String> sol = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        bt(n, 0, 0, "");
        return sol;
    }

    public void bt(int n, int fUsed, int bUsed, String s) {
        if (s.length() == 2*n) {
            System.out.println("finished string: " + s);
            sol.add(new String(s));
            return;
        }

        if (fUsed == bUsed) {
            s += "(";
            System.out.println("current string: " + s);
            bt(n, fUsed + 1, bUsed, s);
        }
        else {
            if (fUsed == n) {
                s += ")";
                System.out.println("current string: " + s);
                bt(n, fUsed, bUsed + 1, s);
            }

            else {
                s += "(";
                System.out.println("current string: " + s);
                bt(n, fUsed + 1, bUsed, s);
                s = s.substring(0, s.length() - 1);
                System.out.println("current string: " + s);
                s += ")";
                bt(n, fUsed, bUsed + 1, s);
            }
            
        } 
    }
}
