package com.practice.feelofraj.arrays;

public class MedianOfSArray_4 {
    public static void main(String[] args) {
        MedianOfSArray_4 med = new MedianOfSArray_4();
        int[] nums1 = { 1, 2 };
        int[] nums2 = { 3, 4 };
        System.out.println(med.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        double out = 0;
        boolean takeprev = size % 2 == 0;
        int median = size / 2;
        int j = 0;
        int l = 0;
        int sum = 0;
        // 5 // 1 2 3 5 // 4 6
        for (int i = 0; i < median + 1; i++) {
            if (i == median && takeprev)
                out = sum;
            if (j >= nums1.length) {
                sum = nums2[l];
                l++;
                continue;
            }
            if (l >= nums2.length) {
                sum = nums1[j];
                j++;
                continue;
            }
            if (nums1[j] <= nums2[l]) {
                sum = nums1[j];
                j++;
            } else if (nums1[j] >= nums2[l]) {
                sum = nums2[l];
                l++;
            }
        }
        out += sum;
        if (takeprev)
            out = out / 2;

        return out;
    }
}