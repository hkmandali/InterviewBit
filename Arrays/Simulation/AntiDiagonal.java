package src.InterviewBit.Arrays.Simulation;

import java.util.ArrayList;
import java.util.Arrays;

/*
Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.

Example:


Input:

1 2 3
4 5 6
7 8 9

Return the following :

[
  [1],
  [2, 4],
  [3, 5, 7],
  [6, 8],
  [9]
]


Input :
1 2
3 4

Return the following  :

[
  [1],
  [2, 3],
  [4]
]

 */
// https://www.interviewbit.com/problems/anti-diagonals/
public class AntiDiagonal {
    public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> out = new ArrayList<>();
        if(A == null)
            return out;
        int size = A.size();
        for(int i=0;i<2*size -1;++i)
        {
            out.add(i,new ArrayList<>());
        }
        //int curr_row =0;
        int index =0; // this is used for adding the arraylist elements
        //int i=0,j=0;
        int end_row =size,end_col = size;
        for(int j=0;j<size;++j) //these are the column num for the first row , printing the first one's
        {
            int start =j;
            int curr_col =j;
            int curr_index =0;
            //int i=0;
            for(int i=0;i<=start;++i)
            {
                //System.out.println("current element is "+A.get(i).get(curr_col));
                out.get(index).add(curr_index,A.get(i).get(curr_col));
                curr_col--; // decrementing the column
                curr_index++; // incrementing the row

            }
            index++; // incrementing the row in arraylist
        }

        // by now we will be having the upperhalf of the grid

        // for second half

        for(int i=1;i< size;++i) // incrementing the rows
        {
            int curr_row = i;
            int curr_col = size-1;
            int curr_index =0;
            for(int j = curr_col;j>=i;--j)
            {
                /*
                System.out.println("current element is "+A.get(curr_row).get(j));
                if(index == 4) {
                    System.out.println("index now is  " + index + "  curr index is " + curr_index + "   curr row is " + curr_row + " j is " + A.get(curr_row).get(j));
                    System.out.println("size is "+out.get(index).size());
                }

                 */
                out.get(index).add(curr_index,A.get(curr_row).get(j));
                curr_row++;
                curr_index++;
                //System.out.println("finished insertion j is "+j);

            }
            //System.out.println("list currently is "+ Arrays.toString(out.toArray()));
            index++;
        }

        return out;
    }
    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> out = new ArrayList<>();
        out.add(0,new ArrayList<>(Arrays.asList(1)));
        /*
        out.add(0,new ArrayList<>(Arrays.asList(1,2,3)));
        out.add(1,new ArrayList<>(Arrays.asList(4,5,6)));
        out.add(2,new ArrayList<>(Arrays.asList(7,8,9)));
        */
        ArrayList<ArrayList<Integer>> test = diagonal(out);

        System.out.println("out is "+ Arrays.toString(test.toArray()));
    }
}
