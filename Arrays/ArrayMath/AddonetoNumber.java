package src.InterviewBit.Arrays.ArrayMath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// learning --> in arraylist we cannot directly fill the next elements before filling the previous one's
// this question took more than 2 hrs for edge cases
// https://www.interviewbit.com/problems/add-one-to-number/
public class AddonetoNumber {
    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int size = A.size();
        int num_zeros= 0;
        int i=0;
        boolean allnine = true; // this is used to check if the output needs to be one size more
        boolean prev_zero = true;
        for(;i<size && (allnine || prev_zero);++i)
        {

            if(A.get(i) == 0 && prev_zero) {
                System.out.println("seeting previous sero at "+i);
                prev_zero = true;
                num_zeros++;
            }
            else
                prev_zero = false;
            if(A.get(i) == 9) {
                System.out.println("seeting all 9 to true at "+i);
                allnine = true;
            }else {
                System.out.println("seeting all 9 to false at "+i);
                allnine = false;
            }
        }
        //now we have the value of num zeros and nines
        System.out.println("all nine "+allnine);
        int second_size = size-num_zeros;
        if(num_zeros == size)
            second_size = 1;
        else if(i == size && allnine)
            second_size = size-num_zeros+1;
        System.out.println("size is  "+size+"    num zeroes are "+num_zeros+"  second size is "+second_size);
        ArrayList<Integer> reverse = A;
        Collections.reverse(reverse); // now reverse has the elements in reverse
        ArrayList<Integer> res = new ArrayList<>(second_size);
        int carry =1;
        for(int k=0;k< size- num_zeros;++k)
        {
            int curr = reverse.get(k) +carry;
            if(curr > 9)
            {
                carry =1; // if the value is > , we just add 0
                res.add(0);
            }
            else
            {
                carry =0;
                res.add(curr);
            }
        }
        if(res.size() != second_size)
            res.add(1);
        Collections.reverse(res);

        return res;
    }

    public static void main(String[] args)
    {
        int[] test ={  2, 5, 6, 8, 6, 1, 2, 4, 5 };
        ArrayList<Integer> obj = new ArrayList<>();
        for(int i:test)
            obj.add(i);
        ArrayList<Integer> res = plusOne( obj);
        System.out.println(res);
    }
}
