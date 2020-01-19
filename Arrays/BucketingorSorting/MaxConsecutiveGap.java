package src.InterviewBit.Arrays.BucketingorSorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Example :

Input : [1, 10, 5]
Output : 5
Return 0 if the array contains less than 2 elements.

You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
You may also assume that the difference will not overflow.
 */
// https://www.interviewbit.com/problems/maximum-consecutive-gap/

// this code has been taken from gfg , didnt answer this
public class MaxConsecutiveGap {
    public static int maximumGap(final List<Integer> A) {
        int len = A.size();
        if(len <2)
            return 0;
        int maxVal = A.get(0);
        int minVal = A.get(0);
        for (int i = 1; i < len; i++) {
            maxVal = Math.max(maxVal, A.get(i));
            minVal = Math.min(minVal, A.get(i));
        }
        // Arrays to store maximum and minimum values
        // in n-1 buckets of differences.
        int maxBucket[] = new int[len - 1];
        int minBucket[] = new int[len - 1];
        Arrays.fill(maxBucket, 0, len - 1, Integer.MIN_VALUE);
        Arrays.fill(minBucket, 0, len - 1, Integer.MAX_VALUE);

        // Expected gap for every bucket.
        float delta = (float) (maxVal - minVal) / (float) (len - 1);

        // Traversing through array elements and
        // filling in appropriate bucket if bucket
        // is empty. Else updating bucket values.
        for (int i = 0; i < len; i++) {
            if (A.get(i) == maxVal || A.get(i) == minVal) {
                continue;
            }

            // Finding index of bucket.
            int index = (int) (Math.round((A.get(i) - minVal) / delta));

            // Filling/Updating maximum value of bucket
            if (maxBucket[index] == Integer.MIN_VALUE) {
                maxBucket[index] = A.get(i);
            } else {
                maxBucket[index] = Math.max(maxBucket[index], A.get(i));
            }

            // Filling/Updating minimum value of bucket
            if (minBucket[index] == Integer.MAX_VALUE) {
                minBucket[index] = A.get(i);
            } else {
                minBucket[index] = Math.min(minBucket[index], A.get(i));
            }
        }
        // Finding maximum difference between maximum value
        // of previous bucket minus minimum of current bucket.
        int prev_val = minVal;
        int max_gap = 0;
        for (int i = 0; i < len - 1; i++) {
            if (minBucket[i] == Integer.MAX_VALUE) {
                continue;
            }
            max_gap = Math.max(max_gap, minBucket[i] - prev_val);
            prev_val = maxBucket[i];
        }
        max_gap = Math.max(max_gap, maxVal - prev_val);
        return max_gap;
    }
    public static void main(String[] args)
    {
        List<Integer> A = new ArrayList<>(Arrays.asList(1,10,5));
        int max = maximumGap(A);
        System.out.println("maximum gap is "+max);

    }
}
