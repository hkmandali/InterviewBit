package src.InterviewBit.Arrays.BucketingorSorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].

If there is no solution possible, return -1.

Example :

A : [3 5 4 2]

Output : 2
for the pair (3, 4)
 */
// https://www.interviewbit.com/problems/max-distance/
public class MaxDistance {
    public static  int maximumGap(final List<Integer> A) {
        int max =-1;
        int len = A.size();
        int[] leftmin = new int[len];
        int[] rightmax = new int[len];
        leftmin[0] = A.get(0);
        rightmax[len-1]=A.get(len-1);
        for(int i=1;i<len;++i)
        {
            leftmin[i] =  Math.min(leftmin[i-1],A.get(i));
        }

        for(int i=len-2;i>=0;--i)
        {
            rightmax[i] = Math.max(A.get(i),rightmax[i+1]);
        }
        int start =0,end=0;
        while(start < len && end < len)
        {
            if(leftmin[start] <= rightmax[end])
            {
                max= Math.max(max,end-start);
                end = end+1;
            }
            else
                start = start+1;
        }

        return max;
    }
    public static void main(String[] args)
    {
        List<Integer> A = new ArrayList<>(Arrays.asList(3,5,4,2));
        int max = maximumGap(A);
        System.out.println("maximum gap is "+max);

    }
}
