class Solution {
    public int[] sortArray(int[] nums) {
        int[] sorted = mergeSort(nums);
        return sorted;
    }

    public int[] mergeSort(int[] nums) {
        if (nums.length == 1) return nums;

        int[] l = mergeSort(Arrays.copyOfRange(nums, 0, nums.length/2));
        int[] r = mergeSort(Arrays.copyOfRange(nums, nums.length/2, nums.length));

        int cl = 0;
        int cr = 0;
        while (cl + cr < nums.length) {
            if (cl == l.length) {
                nums[cl + cr] = r[cr];
                cr++;
                continue;
            }
            if (cr == r.length) {
                nums[cl + cr] = l[cl];
                cl++;
                continue;
            }

            if (l[cl] < r[cr]) {
                nums[cl + cr] = l[cl];
                cl++;
            }
            else {
                nums[cl + cr] = r[cr];
                cr++;
            }
        }

        return nums;

    }
}