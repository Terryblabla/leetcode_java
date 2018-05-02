package leetcode_java;

/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 */

import java.util.Arrays;

public class MedianofTwoSortedArrays_4 {
	public double findMedianSortedArrays_3(int[] nums1, int[] nums2) {
		int totalLen = nums1.length + nums2.length;
		int[] total = new int[totalLen];
		int i1 = 0;
		int i2 = 0;
		for (int i = 0; i < totalLen; i++) {
			if (i2 >= nums2.length || (i1 < nums1.length && nums1[i1] < nums2[i2])) {
				total[i] = nums1[i1++];
			} else {
				total[i] = nums2[i2++];
			}
		}
		return (total[totalLen / 2] + total[(totalLen - 1) / 2]) / 2.0;
	}

	public double findMedianSortedArrays_2(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		if (m > n) { // to ensure m<=n
			int[] temp = A;
			A = B;
			B = temp;
			int tmp = m;
			m = n;
			n = tmp;
		}
		int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
		while (iMin <= iMax) {
			int i = (iMin + iMax) / 2;
			int j = halfLen - i;
			if (i < iMax && B[j - 1] > A[i]) {
				iMin = iMin + 1; // i is too small
			} else if (i > iMin && A[i - 1] > B[j]) {
				iMax = iMax - 1; // i is too big
			} else { // i is perfect
				int maxLeft = 0;
				if (i == 0) {
					maxLeft = B[j - 1];
				} else if (j == 0) {
					maxLeft = A[i - 1];
				} else {
					maxLeft = Math.max(A[i - 1], B[j - 1]);
				}
				if ((m + n) % 2 == 1) {
					return maxLeft;
				}

				int minRight = 0;
				if (i == m) {
					minRight = B[j];
				} else if (j == n) {
					minRight = A[i];
				} else {
					minRight = Math.min(B[j], A[i]);
				}

				return (maxLeft + minRight) / 2.0;
			}
		}
		return 0.0;
	}

	public double findMedianSortedArrays(int A[], int B[]) {
		int total = A.length + B.length;
		int m = A.length;
		int n = B.length;
		if ((total & 0x01) != 0) {
			return findMiddle(A, m, B, n, total / 2 + 1);
		} else {
			return (findMiddle(A, m, B, n, total / 2) + findMiddle(A, m, B, n, total / 2 + 1)) / 2;
		}
	}

	public double findMiddle(int[] A, int m, int[] B, int n, int middle) {
		if (m > n) {
			return findMiddle(B, n, A, m, middle);
		}
		if (m == 0) {
			return B[middle - 1];
		}

		if (middle == 1) {
			return Math.min(A[0], B[0]);
		}

		int pa = Math.min(m, middle / 2);
		int pb = middle - pa;
		if (A[pa - 1] < B[pb - 1]) {
			return findMiddle(Arrays.copyOfRange(A, pa, A.length), m - pa, B, n, middle - pa);
		} else if (A[pa - 1] > B[pb - 1]) {
			return findMiddle(A, m, Arrays.copyOfRange(B, pb, B.length), n - pb, middle - pb);
		} else {
			return A[pa - 1];
		}

	}
}
