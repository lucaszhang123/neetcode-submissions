class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        bt(0, 0, target, nums, new ArrayList<>());
        return ans;
    }

    public void bt(int start, int currSum, int target, int[] nums, ArrayList<Integer> numSeq) {
        if (currSum == target) {
            ans.add(new ArrayList<>(numSeq));
            return;
        }
        if (currSum > target) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            numSeq.add(nums[i]);
            bt(i, currSum + nums[i], target, nums, numSeq);
            numSeq.remove(numSeq.size() - 1);
        }
    }
}

/*
indexMax = nums.size()

if (currSum == sum) hashSet.add(arr);
if (currSum > sum) return;

choices:
loop(num : nums) 
- arr[index of num]++; 
- bt(currSum + num, target, nums, arr)
- arr[index of num]--;


*/
