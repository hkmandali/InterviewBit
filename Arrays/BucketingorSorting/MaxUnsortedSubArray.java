package src.InterviewBit.Arrays.BucketingorSorting;

import java.util.ArrayList;
import java.util.Arrays;

/*
https://www.interviewbit.com/problems/maximum-unsorted-subarray/

You are given an array (zero indexed) of N non-negative integers, A0, A1 ,…, AN-1.
Find the minimum sub array Al, Al+1 ,…, Ar so if we sort(in ascending order) that sub array, then the whole array should get sorted.
If A is already sorted, output -1.

Example :

Input 1:

A = [1, 3, 2, 4, 5]

Return: [1, 2]

Input 2:

A = [1, 2, 3, 4, 5]

Return: [-1]
 */
public class MaxUnsortedSubArray {
    public static ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        ArrayList<Integer> out = new ArrayList<>();
        int len = A.size();
        int start =len-1,end=0;

        for(int i=0;i<len-1;++i)
        {
            if(A.get(i) > A.get(i+1))
            {
                start =i;
                break;
            }
        }
        if(start == len-1)
        {
            out.add(-1);
            return out;
        }
        for(int i=len-1;i>=1;--i)
        {
            if(A.get(i-1) > A.get(i))
            {
                end = i;
                break;
            }
        }
        //System.out.println("Start and end are "+start+"   "+end);
        int max = A.get(end),min = A.get(end);
        for(int i=start;i<end;++i)
        {
            if(A.get(i) > max)
                max = A.get(i);
            if(A.get(i) < min)
                min = A.get(i);
        }
        //System.out.println(" max and min are   "+max +"   "+min);
        for(int i=0;i<start;++i)
        {
            if(A.get(i) > min)
            {
                start=i;
                break;
            }
        }

        for(int i=len-1;i>end;--i)
        {
            if(A.get(i) < max) // first element which is less than end
            {
                end=i;
                break;
            }
        }
        out.add(start);
        out.add(end);
        return out;
    }
    public static void main(String[] args)
    {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(16, 6, 18, 17, 13, 6, 18, 16, 6, 15, 15, 18, 16, 13, 16, 16, 6, 18, 15, 15));
        ArrayList<Integer> out = subUnsort(input);
        System.out.println("out is "+Arrays.toString(out.toArray()));

    }
}
