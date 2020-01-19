package src.InterviewBit.Arrays.BucketingorSorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.

Sample Input:

[3 4 1 4 1]
Sample Output:

1

If there are multiple possible answers ( like in the sample case above ), output any one.

If there is no duplicate, output -1
https://www.interviewbit.com/problems/find-duplicate-in-array/
 */
public class FindDuplicate {
    public static int repeatedNumber(final List<Integer> A) {
        int x =-1;
        int len = A.size();
        int[] testarr = new int[len];
        for(int i=0;i<len;++i)
        {
            int curr = A.get(i);
            if(curr < len)
            {
                if(testarr[curr] == -1)
                {
                    x=curr;
                    break;
                }
                else
                    testarr[curr] = -1;
            }
        }
        return x;
    }
    public static void main(String[] args)
    {
        List<Integer> obj = new ArrayList<>(Arrays.asList(3,4,1,4,1));
        System.out.println("repeated number is "+repeatedNumber(obj));
    }
}
