class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            int m = l + (r - l + 1)/2;
            if (arr[m] > x) r = m - 1;
            else l = m;
        }

        List<Integer> lset = new ArrayList<>();
        List<Integer> sset = new ArrayList<>();


        int smaller;
        int larger;
        if (l == 0 && arr[0] > x) {
            smaller = -1;
            larger = 0;
        }
        else {
            smaller = l;
            larger = l + 1;
        }

        System.out.println("l: " + l);
        while (lset.size() + sset.size() != k) {
            if (smaller < 0) {
                lset.add(arr[larger]);
                larger++;
                continue;
            }
            if (larger >= arr.length) {
                sset.add(arr[smaller]);
                smaller--;
                continue;
            }

            if (x - arr[smaller] <= arr[larger] - x) {
                sset.add(arr[smaller]);
                smaller--;
            }
            else {
                lset.add(arr[larger]);
                larger++;
            }
        }

        List<Integer> sol = new ArrayList<Integer>();

        for (int i = sset.size() - 1; i >= 0; i--) {
            sol.add(sset.get(i));
        }

        for (int i : lset) {
            sol.add(i);
        }

        return sol;
    }
}
/*

(1) 2 4 5 8 10


*/