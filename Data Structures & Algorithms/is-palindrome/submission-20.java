class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            while (l <= r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l <= r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (l > r) break; 
            if (Character.toLowerCase(s.charAt(r)) != Character.toLowerCase(s.charAt(l))) return false;

            l++;
            r--;
        }
        return true;
    }
}
