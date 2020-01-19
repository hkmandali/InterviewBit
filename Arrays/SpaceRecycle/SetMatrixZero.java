package src.InterviewBit.Arrays.SpaceRecycle;
/*
Given a matrix, A of size M x N of 0s and 1s. If an element is 0, set its entire row and column to 0.

Note: This will be evaluated on the extra memory used. Try to minimize the space and time complexity.



Input Format:

The first and the only argument of input contains a 2-d integer matrix, A, of size M x N.
Output Format:

Return a 2-d matrix that satisfies the given conditions.
Constraints:

1 <= N, M <= 1000
0 <= A[i][j] <= 1
Examples:

Input 1:
    [   [1, 0, 1],
        [1, 1, 1],
        [1, 1, 1]   ]

Output 1:
    [   [0, 0, 0],
        [1, 0, 1],
        [1, 0, 1]   ]

Input 2:
    [   [1, 0, 1],
        [1, 1, 1],
        [1, 0, 1]   ]

Output 2:
    [   [0, 0, 0],
        [1, 0, 1],
        [0, 0, 0]   ]
 */
// https://www.interviewbit.com/problems/set-matrix-zeros/
import java.util.ArrayList;
import java.util.Arrays;

public class SetMatrixZero {
    public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
        int row,col = 0;
        if(a == null)
            return;
        row = a.size();
        if(row != 0)
            col = a.get(0).size();
        if(row ==0 || col ==0)
            return;
        int[] rowmat = new int[row];
        int[] colmat = new int[col];

        for(int i=0;i<row;++i)
        {
            for(int j=0;j<col;++j)
            {
                if(a.get(i).get(j) == 0)
                {
                    rowmat[i] = 1;
                    colmat[j]=1;
                }
            }
        }

        for(int i=0;i<row;++i)
        {
            for(int j=0;j<col;++j)
            {
                if(rowmat[i] == 1 || colmat[j] ==1)
                {
                    a.get(i).set(j,0);

                }
            }
        }


    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> obj = new ArrayList<>();
        obj.add(0,new ArrayList<>(Arrays.asList(1,0,1)));
        obj.add(1,new ArrayList<>(Arrays.asList(1,1,1)));
        obj.add(2,new ArrayList<>(Arrays.asList(1,0,1)));
        setZeroes(obj);
        System.out.println(Arrays.toString(obj.toArray()));

    }

}
