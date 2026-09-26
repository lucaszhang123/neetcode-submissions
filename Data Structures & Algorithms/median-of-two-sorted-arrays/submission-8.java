class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) return findMedianSortedArrays(nums2, nums1);

        if (nums2.length == 0) {
            if (nums1.length % 2 == 0) return (nums1[nums1.length/2] + nums1[nums1.length/2 - 1])/2.0;
            else return (double) nums1[nums1.length/2];
        }

        int totalTake = (nums1.length + nums2.length + 1)/2;
        int l = 0;
        int r = nums2.length;

        while (l <= r) {
            int takeSmall = l + (r - l)/2;
            int takeBig = totalTake - takeSmall;
            System.out.println(takeSmall);

            if (takeSmall < nums2.length && nums1[takeBig - 1] > nums2[takeSmall]) {
                System.out.println(nums1[takeBig - 1] + " " + nums2[takeSmall]);
                l = takeSmall + 1;
            }
            else if (takeSmall > 0 && nums2[takeSmall - 1] > nums1[takeBig]) {
                System.out.println(nums2[takeSmall - 1] + " " + nums1[takeBig]);
                r = takeSmall - 1;
            }
            else {
                break;
            }
        }

        int takeSmall = l + (r - l)/2;
        int takeBig = totalTake - takeSmall;

        System.out.println("Take Small: " + takeSmall);
        System.out.println("Take Big: " + takeBig);

        while (l <= r) {
            takeSmall = l + (r - l)/2;
            takeBig = totalTake - takeSmall;

            if (takeSmall < nums2.length && nums1[takeBig - 1] > nums2[takeSmall]) {
                l = takeSmall + 1;
            }
            else if (takeSmall > 0 && nums2[takeSmall - 1] > nums1[takeBig]) {
                r = takeSmall - 1;
            }
            else {
                break;
            }
        }

        int leftMax;
        if (takeSmall == 0) {
            leftMax = nums1[takeBig - 1];
        }
        else if (takeBig == 0) {
            leftMax = nums2[takeSmall - 1];
        }
        else {
            leftMax = Math.max(nums1[takeBig - 1], nums2[takeSmall - 1]);
        }

        if ((nums1.length + nums2.length) % 2 == 1) {
            return (double) leftMax;
        }

        int rightMin;
        if (takeSmall == nums2.length) {
            rightMin = nums1[takeBig];
        }
        else if (takeBig == nums1.length) {
            rightMin = nums2[takeSmall];
        }
        else {
            rightMin = Math.min(nums1[takeBig], nums2[takeSmall]);
        }

        return (leftMax + rightMin)/2.0;
    }
    /*


    totalTake = 7

    0 5
    ts = 2
    tb = 5
    3 4 5 7 8 | 9 10 11 
    1 2 | 6 12 13

    10 > 3 --> needs to take more from small
    
    3 5
    ts = 4
    tb = 3
    3 4 5 | 7 8 9 10 11
    1 2 6 12 | 13

    12 > 7 --> needs to take less from small

    3 3 
    ts = 3
    tb = 4
    3 4 5 7 | 8 9 10 11
    1 2 6 | 12 13

    7 < 12; 6 < 8 --> good


    1 3 | 5
    2 | 4 6
    */

}
