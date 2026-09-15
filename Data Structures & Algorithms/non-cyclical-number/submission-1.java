class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> process = new HashSet<>();
        while(!process.contains(n)) {
            if (n == 1) return true;
            process.add(n);
            n = sumOfDigitsSquared(n);
        }
        return false;
    }

    private int sumOfDigitsSquared(int n) {
        int newN = 0;
        while (n > 0) {
            int dig = n % 10;
            newN += dig*dig;
            n /= 10;
        }
        return newN;
    }
}
