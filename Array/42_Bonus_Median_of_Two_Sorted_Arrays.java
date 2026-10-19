// https://leetcode.com/problems/median-of-two-sorted-arrays/
// Binary-search the partition in the shorter array. Left partitions contain
// (m+n+1)/2 items. A valid cut has both left maxima <= opposite right minima.
// Too many large values from nums1: move left; too few: move right. Discard cut.
// Time: O(log(min(m,n) + 1)). Extra space: O(1).
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;
        while (left <= right) {
            int cut1 = left + (right - left) / 2;
            int cut2 = (m + n + 1) / 2 - cut1;
            int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int right1 = cut1 == m ? Integer.MAX_VALUE : nums1[cut1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int right2 = cut2 == n ? Integer.MAX_VALUE : nums2[cut2];
            if (left1 <= right2 && left2 <= right1) {
                if ((m + n) % 2 == 1) return Math.max(left1, left2);
                return ((long) Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
            }
            if (left1 > right2) right = cut1 - 1;
            else left = cut1 + 1;
        }
        throw new IllegalArgumentException("Expected sorted arrays with a nonempty combined input");
    }
}
