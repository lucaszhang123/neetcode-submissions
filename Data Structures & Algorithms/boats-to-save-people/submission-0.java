class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int numBoats = 0;

        Arrays.sort(people);

        int l = 0;
        int r = people.length - 1;

        while (l <= r) {
            if (l == r) {
                numBoats++;
                break;
            }

            if (limit - people[r] >= people[l]) {
                l++;
            }
            r--;

            numBoats++;
        }

        return numBoats;
    }
    /*

    5 
    */
}