class Solution {
    public int findMin(int[] nums) {
        if (nums[0] <= nums[nums.length - 1]) return nums[0];
        

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;   
            } else {
                right = mid;    
            }
        }

        return nums[left];
        
        
    }

    // 5 6 1 2 3 4

    // 6 1 2 3 4 5



    // 2 3 4 5 6 1

    // 3 4 5 6 1 2 

    // 4 5 6 1 2 3


}
