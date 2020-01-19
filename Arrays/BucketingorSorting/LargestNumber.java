package src.InterviewBit.Arrays.BucketingorSorting;

import java.util.*;

/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example:

Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
 */
// https://www.interviewbit.com/problems/largest-number/
public class LargestNumber {
    public static String largestNumber(final List<Integer> A) {
        String out = new String();
        int len = A.size();
        boolean allzeros = true;
        ArrayList<Integer> test= new ArrayList<>(A);
        Collections.sort(test, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                String first = Integer.toString(integer) +Integer.toString(t1);
                String second = Integer.toString(t1) +Integer.toString(integer);
                if(first.compareTo(second) > 0 )
                    return -1;
                else
                    return 1;
            }
        });
        Iterator itr = test.iterator();
        while(itr.hasNext())
        {
            out = out+ itr.next();
        }
        /*
        for(int i=0;i<len;++i)
        {
            String curr = Integer.toString(test.get(i));
            if(test.get(i) != 0)
                allzeros = false;
            if(Double.parseDouble(out+curr) > Double.parseDouble(curr+out))
            {
                out = out+curr;
            }
            else
                out = curr+out;
        }

         */
        if(out.charAt(0) == 0)
            return "0";
        /*
        String[] arr = new String[a.size()];
    for (int i = 0; i < a.size(); i++) {
        arr[i] = String.valueOf(a.get(i));
    }


    Arrays.sort(arr, new Comparator<String>(){
        public int compare(String a, String b){
            return (b+a).compareTo(a+b);
        }
    });


    StringBuilder sb = new StringBuilder();
    for(String s: arr){
        sb.append(s);
    }

    if(sb.charAt(0) == '0'){     //check if all zeroes are there
        return String.valueOf(0);
    }

    return sb.toString();
         */
        /*
        if(allzeros)
            return Integer.toString(0);
        */
        return out;

    }
    public static void main(String[] args)
    {
        List<Integer> test = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0)); //9534330//3, 30, 34, 5, 9
        String out = largestNumber(test);
        System.out.println("the largest number formed is "+ out);
    }

}
