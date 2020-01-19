package src.InterviewBit.Arrays.ArrayMath;

import java.util.ArrayList;
import java.util.Arrays;

public class Flip {
    public static ArrayList<Integer> flip(String A) {
        // in the given string , we need to find out the subarray with max number of zeros and min number of 1's , to find this , we can convert 0 to 1 and 1 to -1 , so that the subarray with maximum sum will be our output
        int len = A.length();
        ArrayList<Integer> out = new ArrayList<>(2);
        int num_of_one =0;
        for(int i=0;i<len;++i)
        {
            if(A.charAt(i) - '0' ==1)
            {
                ++num_of_one;
            }
        }
        int global_start = len+2;
        int global_end = len+2;
        if(num_of_one == len)
            return out;
        else
        {

            int[] arr = new int[len];
            // 0 to 1 and 1 to -1 , i.e converting the array
            for(int i=0;i<len;++i)
            {
                if(A.charAt(i) - '0' == 0)
                    arr[i] =1;
                else
                    arr[i] =-1;
            }
            // now we need to find the array with maximum sum
            int curr_sum =0;
            int global_sum =0;
            int sum_till_now=0;
            int start=0;
            System.out.println("array is "+ Arrays.toString(arr));
            for(int i=0;i<len;++i)
            {
                sum_till_now = sum_till_now + arr[i];
                if(curr_sum < sum_till_now)
                {
                    curr_sum = sum_till_now;
                    global_start = start;
                }
                if(sum_till_now < 0)
                {
                    sum_till_now = 0;
                    start=i+1; // this will be used for start
                }

                if(global_sum < curr_sum)
                {
                    global_sum = curr_sum;
                    global_end = i;
                }
            }

            out.add(global_start+1);
            out.add(global_end+1);
        }
        return out;
    }
    public static void main(String[] args)
    {
        String s ="011101001111";
        ArrayList<Integer> obj = flip(s);
        System.out.println("out is "+obj);
    }
}
