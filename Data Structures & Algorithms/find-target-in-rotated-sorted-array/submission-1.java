class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l)/2;

            if (nums[m] == target) return m;
            if (nums[r] == target) return r;
            
            //pivot is from m + 1; m
            if (nums[m] > nums[r]) {
                if (nums[m] < target || nums[r] > target) {
                    l = m + 1;
                }
                else {
                    r = m - 1;
                }
            }
            else {
                if (nums[m] < target && nums[r] > target) {
                    l = m + 1;
                }
                else {
                    r = m - 1;
                }
            }
        }

        return -1;

    }
    /*
    3 4 5 6 1 2 

    5 6 1 2 3 4

    6 1 2 3 4 5

    4 5 6 1 2 3
    
    lookup 3
    l = 0 r = 8
    5 6 7 8 9 1 2 3 4 
    
    l = 5 r = 8
    

    */
}
