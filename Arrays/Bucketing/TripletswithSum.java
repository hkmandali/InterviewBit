package src.InterviewBit.Arrays.Bucketing;
/*
Given an array of real numbers greater than zero in form of strings.
Find if there exists a triplet (a,b,c) such that 1 < a+b+c < 2 .
Return 1 for true or 0 for false.

Example:

Given [0.6, 0.7, 0.8, 1.2, 0.4] ,

You should return 1

as

0.6+0.7+0.4=1.7

1<1.7<2

Hence, the output is 1.

O(n) solution is expected.

Note: You can assume the numbers in strings don’t overflow the primitive data type and there are no leading zeroes in numbers. Extra memory usage is allowed.
 */

import java.util.ArrayList;
import java.util.Arrays;

//https://www.interviewbit.com/problems/triplets-with-sum-between-given-range/

// didnt get the idea . implemented it through stack overflow
public class TripletswithSum {
    public static int solve(ArrayList<String> A) {
        int out =0;
        int len =A.size();
        float first = Float.parseFloat(A.get(0));
        float second = Float.parseFloat(A.get(1));
        float third = Float.parseFloat(A.get(2));
        float curr_sum = first + second+ third;
        for(int i=3;i<len;++i)
        {


            if(curr_sum > 1.0 && curr_sum < 2.0)
            {
                return 1;
            }
            if(curr_sum > 2.0) // we need to minimize it i.e basically reducing the maximum value by
            {
                if(first > second && first > third)
                    first= Float.parseFloat(A.get(i));
                else if(second > first && second > third)
                    second= Float.parseFloat(A.get(i));
                else
                    third= Float.parseFloat(A.get(i));
            }
            else // this means sum is < 1 , so we'll take the min value and assign it with current element
            {
                if(first < second && first < third)
                    first= Float.parseFloat(A.get(i));
                else if(second < first && second < third)
                    second= Float.parseFloat(A.get(i));
                else
                    third= Float.parseFloat(A.get(i));
            }
            curr_sum = first + second+ third;
            System.out.println("current values are "+first+"   "+second+"   "+third+"   sum is "+curr_sum);
        }
        if(curr_sum > 1.0 && curr_sum < 2.0)
        {
            return 1;
        }
        return out;
    }
    public static void main(String[] args)
    {
        ArrayList<String> obj = new ArrayList<String>(Arrays.asList("2.673662", "2.419159", "0.573816", "2.454376", "0.403605", "2.503658", "0.806191" ));
        System.out.println(" return is "+Arrays.toString(obj.toArray()));
        System.out.println("noble integer present is "+solve(obj));
    }
}
