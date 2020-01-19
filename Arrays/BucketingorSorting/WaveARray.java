package src.InterviewBit.Arrays.BucketingorSorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Given an array of integers, sort the array into a wave like array and return it,
In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....

Example

Given [1, 2, 3, 4]

One possible answer : [2, 1, 4, 3]
Another possible answer : [4, 1, 3, 2]

NOTE : If there are multiple answers possible, return the one thats lexicographically smallest.
So, in example case, you will return [2, 1, 4, 3]

 */
// https://www.interviewbit.com/problems/wave-array/
public class WaveARray {
    public static ArrayList<Integer> wave(ArrayList<Integer> A) {
        ArrayList<Integer> out = new ArrayList<>();
        //Stack<Integer> s = new Stack<>();
        int len = A.size();
        Collections.sort(A);
        //s.add(A.get(0));
        int i=0;
        for(i=0;i<len-1;++i)
        {
          if(i % 2 ==0)
          {
              out.add(A.get(i+1));
          }
          else
              out.add(A.get(i-1));
        }
        if(len % 2==0)
        {
            out.add(A.get(len-2));
        }
        else
            out.add(A.get(len-1));
        return out;
    }
    public static void main(String[] args)
    {
        ArrayList<Integer> out = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Collections.sort(out);
        ArrayList<Integer> test= wave(out);
        System.out.println("out is "+Arrays.toString(test.toArray()));
    }
}
