package src.InterviewBit.Arrays.Simulation;

import java.util.ArrayList;
import java.util.Arrays;

// https://www.interviewbit.com/problems/spiral-order-matrix-ii/

public class SpiralOrder {
    public static ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<A;++i)
        {
            out.add(i,new ArrayList<>(A));
            //System.out.println("Array list "+Arrays.toString(out.get(i).toArray()));
        }
        int[][] temparr = new int[A][A];
        int curr_row = 0,curr_col =0,end_row =A,end_col =A;
        int square_val=1;
        int i=0;
        while(curr_row < end_row && curr_col < end_col) // i.e curr row and curr col are less than the max till now
        {
            for(i=curr_col ; i<end_col;++i)
            {
                temparr[curr_row][i] = square_val;
                //System.out.println("top value is "+temparr[curr_row][i]+"  "+curr_row+ "  "+i );
                //out.get(curr_row).add(i,square_val);
                //System.out.println("value is "+out.get(curr_row).get(i));
                square_val++;
            }
            curr_row++;
           // System.out.println("curr row is "+curr_row+"   end row is "+end_row+"   end col is "+end_col);
            for(i=curr_row;i<end_row;++i)
            {
                temparr[i][end_col-1] = square_val;
               // System.out.println("last value is "+temparr[i][end_col-1] +"  "+i+ "  "+(end_col-1) );
                //out.get(curr_row).add(end_col-1,square_val);
                //System.out.println("value is "+out.get(i).get(end_col-1));
                square_val++;
            }
            end_col--;

            if(curr_row < end_row)
            {
              //  System.out.println("current row < end row"+ curr_row+"    "+end_row);
                for(i=end_col-1;i>=curr_col;--i)
                {
                    temparr[end_row-1][i] = square_val;
                   // System.out.println("bottom value is "+temparr[end_row-1][i] +"  "+(end_row-1)+ "  "+i );
                    //out.get(end_row-1).add(i,square_val);
                    square_val++;
                }
                end_row--;
            }

            if(curr_col < end_col)
            {
                //System.out.println("current col < end col "+ curr_col+"    "+end_col);
                for(i = end_row-1;i>=curr_row;--i)
                {
                    temparr[i][curr_col] = square_val;
                    //System.out.println("left value is "+temparr[i][curr_col] +"  "+i+ "  "+curr_col );
                    //out.get(i).add(curr_col,square_val);
                    square_val++;
                }
                curr_col++;
            }
        }/*
        for(i=0;i<A;++i)
        {
            System.out.println("arrays ia "+Arrays.toString(temparr[i]));
        }
        */

        for(i=0;i<A;++i)
        {
            for(int j=0;j<A;++j)
            {
                out.get(i).add(j,temparr[i][j]);
            }
        }
        //System.out.println("arrays ia "+Arrays.toString(temparr));
        return out;
    }
    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> out =generateMatrix(3);
        System.out.println(Arrays.toString(out.toArray()));
    }
}
