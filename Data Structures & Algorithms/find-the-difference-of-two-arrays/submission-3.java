class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        for (int i : nums1) {
            s1.add(i);
        }
        for (int i : nums2) {
            s2.add(i);
        }

        List<Integer> in1not2 = new ArrayList<>();
        List<Integer> in2not1 = new ArrayList<>();

        for (int i : s1) {
            if (!s2.contains(i)) in1not2.add(i);
        }

        for (int i : s2) {
            if (!s1.contains(i)) in2not1.add(i);
        }

        List<List<Integer>> sol = new ArrayList<>();
        sol.add(in1not2);
        sol.add(in2not1);

        return sol;

    }
}