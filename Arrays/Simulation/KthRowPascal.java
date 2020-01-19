package src.InterviewBit.Arrays.Simulation;

import java.util.ArrayList;
import java.util.Arrays;

/*
Given an index k, return the kth row of the Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Input : k = 3

Return : [1,3,3,1]
 NOTE : k is 0 based. k = 0, corresponds to the row [1].
Note:Could you optimize your algorithm to use only O(k) extra space?
 */
// https://www.interviewbit.com/problems/kth-row-of-pascals-triangle/
public class KthRowPascal {
    public static ArrayList<Integer> getRow(int A) {
        int size = A+1;
        ArrayList<Integer> out = new ArrayList<Integer>(size);
        if(A < 0)
            return out;
        else if(A == 0)
        {
            out.add(1);
            return out;
        }
        else
        {
            out.add(1);
            int mid = (size+1)/2;
           for(int i=1;i<mid;++i)
           {
                int curr = out.get(i-1)*(size - i)/i;
                //System.out.println("adding "+curr);
                out.add(curr);
           }
           for(int i=mid;i<size-1;++i)
           {
               int curr_index  = size - i-1;
               //System.out.println("curr index is  "+curr_index);
               //System.out.println("  value is "+out.get(curr_index));
               out.add(out.get(curr_index));
           }
            out.add(1);
        }
        return out;
    }
    public static void main(String[] args)
    {
        ArrayList<Integer> out = getRow(15);
        System.out.println("out is "+ Arrays.toString(out.toArray()));
    }
}
