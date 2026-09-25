class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        String[] rows = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = "";
        }
        for (int i = 0; i < s.length(); i++) {
            // going down
            if (i/(numRows-1) % 2 == 0) {
                rows[i % (numRows-1)] += s.charAt(i);
            }
            else {
                rows[(numRows-1) - i % (numRows-1)] += s.charAt(i);
            }
            // going up

        } 
        String sol = "";
        for (String str : rows) {
            sol += str;
        }
        return sol;

    }
    /*
    0           nR * 2 - 2
    1       nR *2 - 3 
    2     nR*2 - 4
    .. nR
    nR-1
    */
}