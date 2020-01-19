package src.InterviewBit.Arrays.Simulation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

// https://www.interviewbit.com/problems/max-non-negative-subarray/
public class MaxNonNegative {
    public static ArrayList<Integer> maxset(ArrayList<Integer> A) {
        int start =0;
        int len = A.size();
        int global_start=0,global_end=0;
        long sum=0,max_sum=0;
        ArrayList<Integer> out = new ArrayList<Integer>();
        boolean present = false;
        for(int i=0;i<len;++i)
        {
            long curr_element = (long)A.get(i);
            System.out.println("curr element ius "+curr_element);
            if(curr_element >= 0)
            {
                present = true;
                sum += A.get(i);
                if(sum > max_sum)
                {
                    max_sum = sum;
                    global_end =i;
                    global_start = start;
                }
                else if (sum == max_sum)
                {
                    if((i - start )> (global_end - global_start))
                    {
                        global_end = i;
                        global_start = start;
                    }
                }
                System.out.println(" positive sum is "+sum+"  global start is "+global_start+"   end is "+global_end);
            }
            else
            {
                sum =0;
                start = i+1;
            }
        }
        if(!present)
            return out;
        else {
            for (int i = global_start; i <= global_end; ++i) {
                System.out.println("a .get i is "+A.get(i));
                out.add(A.get(i));
            }
        }
        return out;
    }
    public static void main(String[] args)
    {
        ArrayList<Integer> out=maxset(new ArrayList<>(Arrays.asList( 1967513926, 1540383426, -1303455736, -521595368)));
        System.out.println(out);
    }
}
