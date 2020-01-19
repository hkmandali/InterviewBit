package src.InterviewBit.Arrays.ArrayMath;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/*
https://www.interviewbit.com/problems/repeat-and-missing-number-array/
 */
public class RepeatandMissingNumbe {
    public static ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        ArrayList<Integer> res = new ArrayList<>(2);
        double  len = (double) A.size();
        double sum_n = ((double)len*(double)(len+1)) /2;
        double sum_sq = ((double)len*((double)(len)+1)/2)*((2*(double)len) +1) /3;
        double first,second;
        for(int i=0;i<len;++i) {
            sum_n = sum_n - (double)A.get(i); // this gives us the remaining sum
            sum_sq = sum_sq - ((double)A.get(i)* (double)A.get(i));
        }
        first = ((sum_n + (sum_sq / sum_n))/2);
        second = first - sum_n;
        res.add((int) second);
        res.add((int) first);
        // here second is the repeating and first is not present

        return res;
    }
    public static void main(String[] args) {
        int[] test ={ 3 ,1, 2, 5, 3};
        List<Integer> obj = new ArrayList<>();

        for(int i:test)
            obj.add(i);

        ArrayList<Integer> res =repeatedNumber(obj);
        System.out.println(" max is "+res);
    }

}
