class Solution {
    public boolean isValid(String s) {
        Stack<Character> seq = new Stack<>();
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (seq.empty() || !paired(seq.peek(), arr[i])) {
                seq.push(arr[i]);
            }
            else {
                seq.pop();
            }
        }

        return (seq.empty());
    }
    private boolean paired(char a, char b) {
        if (a == '[' && b == ']') return true;
        if (a == '(' && b == ')') return true;
        if (a == '{' && b == '}') return true;
        
        return false;
    }
}
