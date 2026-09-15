class Solution {
    List<List<Integer>> solutionSet = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        bt(0, new ArrayList<Integer>(), nums);
        return solutionSet;
    }
    public void bt(int index, List<Integer> currList, int[] nums) {
        if (index == nums.length) {
            solutionSet.add(new ArrayList<>(currList));
            return;
        }

        bt(index + 1, currList, nums);
        currList.add(nums[index]);
        bt(index + 1, currList, nums);
        currList.remove(currList.size() - 1);
    }
}

/*
bc --> index = nums.length
add the curr Array

else:
backtrack(index + 1, currList)
add nums[index] to currList;
backtrack(index + 1, currList)

*/
