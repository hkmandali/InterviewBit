package src.InterviewBit.Arrays.Simulation;

import java.util.ArrayList;
import java.util.Arrays;

/*
Given numRows, generate the first numRows of Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Given numRows = 5,

Return

[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]
 */
// https://www.interviewbit.com/problems/pascal-triangle/
public class PascalTriangle {
    public static ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> out= new ArrayList<>();
        for(int i=0;i<A;++i)
        {
            out.add(i,new ArrayList<>(A));
        }
        if(A > 0)
        {
            out.get(0).add(0,1);
        }
        for(int i=1;i<A;++i)
        {
            out.get(i).add(0,1);
            int j;
            for(j=1;j<i;++j)
            {
                int add = out.get(i-1).get(j) +out.get(i-1).get(j-1);
                out.get(i).add(j,add);
            }
            out.get(i).add(j,1);
        }
        return out;
    }
    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> out = solve(7);
        System.out.println("out is "+ Arrays.toString(out.toArray()));
    }
}
