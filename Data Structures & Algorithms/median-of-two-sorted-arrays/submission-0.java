class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];

        int n1 = 0;
        int n2 = 0;
        while (n1 < nums1.length || n2 < nums2.length) {
            if (n1 == nums1.length) {
                merged[n1 + n2] = nums2[n2];
                System.out.print(merged[n1 + n2] + " ");
                n2++;
                continue;
            }
            if (n2 == nums2.length) {
                merged[n1 + n2] = nums1[n1];
                System.out.print(merged[n1 + n2] + " ");
                n1++;
                continue;
            }

            if (nums1[n1] < nums2[n2]) {
                merged[n1 + n2] = nums1[n1];
                System.out.print(merged[n1 + n2] + " ");
                n1++;
            }
            else {
                merged[n1 + n2] = nums2[n2];
                System.out.print(merged[n1 + n2] + " ");
                n2++;
            }
        }



        if (merged.length % 2 == 1) return (double) merged[merged.length/2];
        
        return (merged[merged.length/2 - 1] + merged[merged.length/2])/2.0;

    }
}
