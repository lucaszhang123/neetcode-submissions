class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (!map.containsKey(num)) map.put(num, 1);
            else map.put(num, map.get(num) + 1); 
        }

        HashSet<String> alrVisited = new HashSet<>();
        List<List<Integer>> sol = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (map.containsKey(-nums[i] - nums[j])) {
                    int numOccur = map.get(-nums[i] - nums[j]);
                    if (-nums[i] - nums[j] == nums[i]) numOccur--;
                    if (-nums[i] - nums[j] == nums[j]) numOccur--;

                    if (numOccur == 0) continue;

                    String visited = Math.max(nums[i], Math.max(nums[j], - nums[i] - nums[j])) + 
                    "-" + Math.min(nums[i], Math.min(nums[j], - nums[i] - nums[j]));

                    if (alrVisited.contains(visited)) continue;
                    alrVisited.add(visited);
                    List<Integer> tba = new ArrayList<Integer>();
                    tba.add(nums[i]);
                    tba.add(nums[j]);
                    tba.add(-nums[i] - nums[j]);

                    sol.add(tba);
                }

            }
        }

        return sol;
        
    }
}
