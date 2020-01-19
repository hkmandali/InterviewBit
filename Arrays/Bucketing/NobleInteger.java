package src.InterviewBit.Arrays.Bucketing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Given an integer array, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p
If such an integer is found return 1 else return -1.
 */
public class NobleInteger {
    public static int solve(ArrayList<Integer> A) {
        int out=-1;
        Collections.sort(A);
        int i=1,prev=0;
        int len =A.size();
        System.out.println("array is "+Arrays.toString(A.toArray()));
        for(;i<len;++i)
        {
            if(A.get(i) == A.get(prev))
            {

            }
            else
            {
                if(A.get(prev) == len - i )
                {
                    System.out.println("element found is "+A.get(prev));
                    return 1;
                }
            }
            prev=i;
        }
        if(A.get(len-1) == 0)
            return 1;
        return out;
    }
    public static void main(String[] args)
    {
        ArrayList<Integer> obj = new ArrayList<>(Arrays.asList( -4, -2, 0, -1, -6));
        System.out.println("noble integer present is "+solve(obj));
    }
}
